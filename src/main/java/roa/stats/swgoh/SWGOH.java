package roa.stats.swgoh;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import roa.stats.Character;
import roa.stats.CharacterTypes;
import roa.stats.Player;
import roa.stats.PlayerZeta;
import roa.stats.Ship;

public class SWGOH {
	private static Map<String, CharacterSWGOH> charactersSWGOH;		
	private static Map<String, ShipSWGOH> shipsSWGOH;
	private static int maxPG = 0;
	
	static {
		try {
			charactersSWGOH = SWGOH.readCharactersSWGOH();		
			shipsSWGOH = SWGOH.readShipsSWGOH();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e); 
		}
	}
	
	public static int getMaxPG() {
		return maxPG;
	}
	
	public static Map<String, Player> retrievePlayers(Document guildDoc, String guildName) {
		Map<String, Player> playerCollection = new HashMap<String, Player>();

		Element table = guildDoc.select("table").get(0);
		Elements rows = table.select("tr");
		for (int i = 1; i < rows.size(); i++) {
			Element member = rows.get(i).select("td").get(0).select("a").get(0);
			String memberName = member.text();
			Element pg = rows.get(i).select("td").get(1);
			Integer pgValue = new Integer(pg.text());
			String memberURL = member.attr("href");
			Element arenaAvgElement = rows.get(i).select("td").get(4);
			double arenaAvg;
			try {
				arenaAvg = Double.parseDouble(arenaAvgElement.text());
			} catch (Exception e) {
				arenaAvg = -1;
			}
			if (pgValue > maxPG) {
				maxPG = pgValue;
			}
			Player player = new Player(guildName, memberName, pgValue, memberURL, arenaAvg);
			playerCollection.put(memberName, player);
		}
		return playerCollection;
	}
	
	public static List<PlayerZeta> readPlayerZetas(Document zetasDoc) {
		List<PlayerZeta> result = new ArrayList<PlayerZeta>();
		Element table = zetasDoc.select("table").get(0);
		Elements rows = table.select("tr");
		for (int i = 1; i < rows.size(); i++) {
			Element member = rows.get(i).select("td").get(0).select("a").get(0);
			String memberName = member.text();
			Elements characterElements = rows.get(i).select("td").get(2).select(".guild-member-zeta");
			for (Element characterElement:characterElements) {
				Element characterNameElement = characterElement.select(".char-portrait-small").get(0);
				String characterName = characterNameElement.attr("title");
				Elements zetaElements = characterElement.select(".guild-member-zeta-ability");
				for (Element zetaElement:zetaElements) {
					String zetaName = zetaElement.attr("title");
					PlayerZeta playerZeta = new PlayerZeta(memberName, characterName, zetaName); 
					result.add(playerZeta);
				}
			}
		}		
		return result;		
	}
	
	public static Map<String, CharacterSWGOH> readCharactersSWGOH() throws JsonMappingException, JsonParseException, IOException{
		ObjectMapper mapper = new ObjectMapper();		
		URL apiURL = new URL("https://swgoh.gg/api/characters/");		
		URLConnection uc = apiURL.openConnection();		
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();		
		List<CharacterSWGOH> characterList = mapper.readValue(uc.getInputStream(), new TypeReference<List<CharacterSWGOH>>(){});		
		Map<String,CharacterSWGOH> result = new HashMap<String,CharacterSWGOH>();
		for (CharacterSWGOH oneCharacter : characterList) {
			result.put(oneCharacter.getBase_id(),oneCharacter);		
		}
		return result;
	}

	public static Map<String, ShipSWGOH> readShipsSWGOH() throws JsonMappingException, JsonParseException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		URL apiURL = new URL("https://swgoh.gg/api/ships/");		
		URLConnection uc = apiURL.openConnection();		
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();		
		List<ShipSWGOH> characterList = mapper.readValue(uc.getInputStream(), new TypeReference<List<ShipSWGOH>>(){});		
		Map<String,ShipSWGOH> result = new HashMap<String,ShipSWGOH>();
		for (ShipSWGOH oneCharacter : characterList) {
			result.put(oneCharacter.getBase_id(),oneCharacter);		
		}
		return result;
	}
	
	public static void readCollectionSWGOH(String guildURL, Map<String, Player> playerCollection) throws JsonMappingException, JsonParseException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String guildID = guildURL.substring(0, guildURL.lastIndexOf("/", guildURL.lastIndexOf("/") - 1));
		URL apiURL = new URL(guildID.replace("https://swgoh.gg/g/","https://swgoh.gg/api/guilds/").concat("/units/"));		
		URLConnection uc = apiURL.openConnection();		
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();		
		Map<String, CollectionSWGOH[]> rawMap = mapper.readValue(uc.getInputStream(), new TypeReference<HashMap<String, CollectionSWGOH[]>>() {});
		Map<String, Map<String, CollectionSWGOH>> result = new HashMap<String, Map<String, CollectionSWGOH>>();
		for (String oneCharacter : rawMap.keySet()) {			
			CollectionSWGOH[] collections = rawMap.get(oneCharacter);
			for (CollectionSWGOH oneCollection:collections) {				
				if (oneCollection.getCombat_type() == 1) {
					String characterName = charactersSWGOH.get(oneCharacter).getName();
					Character c = new Character(characterName, oneCollection.getLevel(), oneCollection.getRarity(), oneCollection.getGear_level(), CharacterTypes.get(characterName), oneCollection.getPower());
					playerCollection.get(oneCollection.getPlayer()).getCharacterCollection().put(characterName, c);
				} else {
					String shipName = shipsSWGOH.get(oneCharacter).getName();
					Ship s = new Ship(shipName, oneCollection.getLevel(), oneCollection.getRarity());
					playerCollection.get(oneCollection.getPlayer()).getShipCollection().put(shipName, s);
				}
			}
		}
	}

	public static Map<String, Character> retrieveCharacterCollection(Document memberCollectionDoc, boolean alfabetico, Map<String, String> characterGroups, Set<String> pjsRequeridos) {
		Map<String, Character> characterCollection = new TreeMap<String, Character>();
		Elements pjs = memberCollectionDoc.select(".collection-char");
		for (int j = 0; j < pjs.size(); j++) {
			Element pj = pjs.get(j);
			Elements characterPortraitDiv = pj.select(".player-char-portrait");
			int numberOfStars = retrieveNumberOfStars(characterPortraitDiv);
			int gear = retrieveGear(characterPortraitDiv);
			int characterLevel;
			if ("".equals(characterPortraitDiv.select(".char-portrait-full-level").text())) {
				characterLevel = 0;
			} else {
				characterLevel = Integer.parseInt(characterPortraitDiv.select(".char-portrait-full-level").text());
			}
			Elements characterNameDiv = pj.select(".collection-char-name");
			String characterName = characterNameDiv.select("a").get(0).text();
			String type = "";
			if (!alfabetico) {
				type = characterGroups.get(characterName);
			}
			Character character = new Character(characterName, characterLevel, numberOfStars, gear, type, 0);
			if (pjsRequeridos == null || pjsRequeridos.contains(characterName)) {
				characterCollection.put(type + "-" + characterName, character);
			}
		}
		return characterCollection;
	}

	public static Map<String, Ship> retrieveShipCollection(Document memberCollectionDoc, Set<String> navesRequeridas) {
		Map<String, Ship> shipCollection = new TreeMap<String, Ship>();
		Elements ships = memberCollectionDoc.select(".collection-ship");
		for (int j = 0; j < ships.size(); j++) {
			Element ship = ships.get(j);
			Elements shipPortraitDiv = ship.select(".ship-portrait-full-stars");
			int numberOfStars = retrieveNumberOfStarsShip(shipPortraitDiv);
			String shipLevel = ship.select(".ship-portrait-full-frame-level").text();
			int characterLevel = 0;
			if (!"".equals(shipLevel)) {
				characterLevel = Integer.parseInt(shipLevel);
			}
			String shipName = ship.select(".collection-ship-name-link").text();
			Ship shipObject = new Ship(shipName, characterLevel, numberOfStars);
			if (navesRequeridas == null || navesRequeridas.contains(shipName)) {
				shipCollection.put(shipName, shipObject);
			}
		}
		return shipCollection;
	}

	private static int retrieveNumberOfStars(Elements characterPortraitDiv) {
		int result = 0;

		if (characterPortraitDiv.select(".star7").not(".star-inactive").size() == 1) {
			result = 7;
		} else if (characterPortraitDiv.select(".star6").not(".star-inactive").size() == 1) {
			result = 6;
		} else if (characterPortraitDiv.select(".star5").not(".star-inactive").size() == 1) {
			result = 5;
		} else if (characterPortraitDiv.select(".star4").not(".star-inactive").size() == 1) {
			result = 4;
		} else if (characterPortraitDiv.select(".star3").not(".star-inactive").size() == 1) {
			result = 3;
		} else if (characterPortraitDiv.select(".star2").not(".star-inactive").size() == 1) {
			result = 2;
		} else if (characterPortraitDiv.select(".star1").not(".star-inactive").size() == 1) {
			result = 1;
		}
		return result;
	}

	private static int retrieveNumberOfStarsShip(Elements characterPortraitDiv) {

		return characterPortraitDiv.select(".ship-portrait-full-star").not(".ship-portrait-full-star-inactive").size();
	}

	private static int retrieveGear(Elements characterPortraitDiv) {
		int result = 0;

		if (characterPortraitDiv.select(".char-portrait-full-gear-level").size() == 1) {
			String gearAsRoman = characterPortraitDiv.select(".char-portrait-full-gear-level").get(0).text();
			switch (gearAsRoman) {
			case "I":
				result = 1;
				break;
			case "II":
				result = 2;
				break;
			case "III":
				result = 3;
				break;
			case "IV":
				result = 4;
				break;
			case "V":
				result = 5;
				break;
			case "VI":
				result = 6;
				break;
			case "VII":
				result = 7;
				break;
			case "VIII":
				result = 8;
				break;
			case "IX":
				result = 9;
				break;
			case "X":
				result = 10;
				break;
			case "XI":
				result = 11;
				break;
			case "XII":
				result = 12;
				break;
			}
		}
		return result;
	}
}
