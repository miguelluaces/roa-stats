package roa.stats;

import java.util.HashMap;
import java.util.Map;

import roa.stats.swgoh.SWGOH;

public class Player implements Comparable<Player> {

	private String guildName;
	private String playerName;
	private Integer playerPG;
	private String playerURL;
	private double arenaAvg;
	private Map<String, Character> characterCollection = new HashMap<String, Character>();
	private Map<String, Ship> shipCollection = new HashMap<String, Ship>();

	public Map<String, Character> getCharacterCollection() {
		return characterCollection;
	}

	public void setCharacterCollection(Map<String, Character> characterCollection) {
		this.characterCollection = characterCollection;
	}

	public Map<String, Ship> getShipCollection() {
		return shipCollection;
	}

	public void setShipCollection(Map<String, Ship> shipCollection) {
		this.shipCollection = shipCollection;
	}


	public Player(String guildName, String playerName, Integer playerPG, String playerURL, double arenaAvg) {
		super();
		this.guildName = guildName;
		this.playerName = playerName;
		this.playerPG = playerPG;
		this.playerURL = playerURL;
		this.arenaAvg = arenaAvg;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getPlayerPG() {
		return playerPG;
	}

	public void setPlayerPG(Integer playerPG) {
		this.playerPG = playerPG;
	}

	public String getPlayerURL() {
		return playerURL;
	}

	public void setPlayerURL(String playerURL) {
		this.playerURL = playerURL;
	}

	public double getArenaAvg() {
		return arenaAvg;
	}

	public void setArenaAvg(double arenaAvg) {
		this.arenaAvg = arenaAvg;
	}

	public String getGuildName() {
		return guildName;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

	@Override
	public int compareTo(Player o) {
		Double playerAPoints = getPoints() + (getPlayerPG() * 1.0 / SWGOH.getMaxPG());
		Double playerBPoints = o.getPoints() + (o.getPlayerPG() * 1.0 / SWGOH.getMaxPG());		
		return playerAPoints.compareTo(playerBPoints);
	}

	public Double getPoints() {
		return new Double(
				hasCLS() + hasCLSPlus() + hasGK() + hasBB8() + hasCHOLO() + hasCHOLOPlus() + hasHRScout() + hasHRSoldier() +
				hasROLO() + hasHermitYoda() + hasImperialProbeDroid() + hasWampa() + hasImperialSoldiers() + 
				hasR1() + hasFenix() + hasHomeOne() + hasEndurance() + hasHomeOnePlus() + hasEndurancePlus() + 
				hasVader() + hasThrawn() + hasVeers() + hasVeersPlus() + hasSnowtrooper() + hasSnowtrooperPlus() + 
				hasStarck() + hasStarckPlus() + hasCazarrecompensas() + hasExecutrix() + hasExecutrixPlus() + 
				hasChimaera() + hasChimaeraPlus() + (1.0 / getArenaAvg()));
	}
	
	public int hasCLS() {
		Character c = characterCollection.get("Commander Luke Skywalker");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasCLSPlus() {
		Character c = characterCollection.get("Commander Luke Skywalker");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 11)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasROLO() {
		Character c = characterCollection.get("Rebel Officer Leia Organa");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasGK() {
		Character c = characterCollection.get("General Kenobi");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasGKPlus() {
		Character c = characterCollection.get("General Kenobi");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 11)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasBB8() {
		Character c = characterCollection.get("BB-8");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasCHOLO() {
		Character c = characterCollection.get("Captain Han Solo");
		if ((c!=null) && (c.getStars() >= 5)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasCHOLOPlus() {
		Character c = characterCollection.get("Captain Han Solo");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasImperialProbeDroid() {
		Character c = characterCollection.get("Imperial Probe Droid");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasWampa() {
		Character c = characterCollection.get("Wampa");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasHermitYoda() {
		Character c = characterCollection.get("Hermit Yoda");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasHRScout() {
		Character c = characterCollection.get("Hoth Rebel Scout");
		if ((c!=null) && (c.getStars() >= 6)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasHRSoldier() {
		Character c = characterCollection.get("Hoth Rebel Soldier");
		if ((c!=null) && (c.getStars() >= 5)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasR1() {
		Character baze = characterCollection.get("Baze Malbus");
		if ((baze!=null) && (baze.getStars() >= 7) && (baze.getLevel() >= 85) && (baze.getGear() >= 8)){
			Character chirrut = characterCollection.get("Chirrut Îmwe");
			if ((chirrut!=null) && (chirrut.getStars() >= 7) && (chirrut.getLevel() >= 85) && (chirrut.getGear() >= 8)){
				Character jyn = characterCollection.get("Jyn Erso");
				if ((jyn!=null) && (jyn.getStars() >= 7) && (jyn.getLevel() >= 85) && (jyn.getGear() >= 8)){
					String[] otherR1={"Bistan","Bodhi Rook","Cassian Andor","K-2SO","Pao","Scarif Rebel Pathfinder"};
					int otherR1Number = 0;
					for (String cName:otherR1) {
						Character c = characterCollection.get(cName);
						if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
							otherR1Number++;
						}
					}
					if (otherR1Number>=2) {
						return 1;
					}
				}
			}			
		}
		return 0;
	}

	public int hasImperialSoldiers() {
		String[] imperialSoldiers={"General Veers", "Snowtrooper", "Stormtrooper", "Shoretrooper", "Magmatrooper", "Death Trooper", "Colonel Starck"};
		int imperialSoldiersNumber = 0;
		for (String cName:imperialSoldiers) {
			Character c = characterCollection.get(cName);
			if ((c!=null)&&(c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
				imperialSoldiersNumber++;
			}
		}
		if (imperialSoldiersNumber>=5) {
			return 1;
		}
		return 0;
	}
	
	
	public int hasFenix() {
		
		Character hera = characterCollection.get("Hera Syndulla");
		if ((hera!=null) && (hera.getStars() >= 7) && (hera.getLevel() >= 85) && (hera.getGear() >= 8)){
			String[] otherFenix={"Chopper", "Ezra Bridger", "Garazeb \"Zeb\" Orrelios","Kanan Jarrus","Sabine Wren"};
			int otherFenixNumber = 0;
			for (String cName:otherFenix) {
				Character c = characterCollection.get(cName);
				if ((c!=null)&&(c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
					otherFenixNumber++;
				}
			}
			if (otherFenixNumber>=4) {
				return 1;
			}
		}
		return 0;
	}

	public int hasHomeOne() {
		Ship s = shipCollection.get("Home One");
		if ((s!=null) && (s.getStars() >= 6) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasHomeOnePlus() {
		Ship s = shipCollection.get("Home One");
		if ((s!=null) && (s.getStars() >= 7) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasEndurance() {
		Ship s = shipCollection.get("Endurance");
		if ((s!=null) && (s.getStars() >= 6) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasEndurancePlus() {
		Ship s = shipCollection.get("Endurance");
		if ((s!=null) && (s.getStars() >= 7) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasVader() {
		Character c = characterCollection.get("Darth Vader");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 11)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasThrawn() {
		Character c = characterCollection.get("Grand Admiral Thrawn");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasVeers() {
		Character c = characterCollection.get("General Veers");
		if ((c!=null) && (c.getStars() >= 5)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasVeersPlus() {
		Character c = characterCollection.get("General Veers");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasSnowtrooper() {
		Character c = characterCollection.get("Snowtrooper");
		if ((c!=null) && (c.getStars() >= 5)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasSnowtrooperPlus() {
		Character c = characterCollection.get("Snowtrooper");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasCazarrecompensas() {

		String[] cazarecompensas={"Boba Fett", "Cad Bane", "Dengar", "Greedo", "Zam Wesell", "IG-88"};
		int cazarecompensasNumber = 0;
		for (String cName:cazarecompensas) {
			Character c = characterCollection.get(cName);
			if ((c!=null)&&(c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
				cazarecompensasNumber++;
			}
		}
		if (cazarecompensasNumber>=5) {
			return 1;
		}
		return 0;
	}

	public int hasStarck() {
		Character c = characterCollection.get("Colonel Starck");
		if ((c!=null) && (c.getStars() >= 5)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasStarckPlus() {
		Character c = characterCollection.get("Colonel Starck");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasExecutrix() {
		Ship s = shipCollection.get("Executrix");
		if ((s!=null) && (s.getStars() >= 6) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasExecutrixPlus() {
		Ship s = shipCollection.get("Executrix");
		if ((s!=null) && (s.getStars() >= 7) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasChimaera() {
		Ship s = shipCollection.get("Chimaera");
		if ((s!=null) && (s.getStars() >= 5) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasChimaeraPlus() {
		Ship s = shipCollection.get("Chimaera");
		if ((s!=null) && (s.getStars() >= 7) && (s.getLevel() >= 85)){
			return 1;
		} else {
			return 0;
		}
	}
}