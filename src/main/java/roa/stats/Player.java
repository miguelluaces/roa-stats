package roa.stats;

import java.util.Arrays;
import java.util.Collections;
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
				hasCLS() + hasCLSPlus() + hasGK() + hasGKPlus() + hasBB8() + hasBB8Plus() + hasR2D2() + hasR2D2Plus() + 
				hasRJT() + hasRJTPlus() + hasCHOLO() + hasCHOLOPlus() + hasHRSoldier() + hasHRScout() + 
				hasROLO() + hasROLOPlus() + hasHermitYoda() +  hasR1() + hasR1Plus() + hasFenix() + hasFenixPlus() + hasHomeOne() + hasEndurance() + hasHomeOnePlus() + hasEndurancePlus() + 
				hasPalpa() + hasPalpaPlus() + hasVader() + hasVaderPlus() + hasThrawn() + hasThrawnPlus() + hasSion() + hasSionPlus() + hasTraya() + hasTrayaPlus() + 
				hasVeers() + hasVeersPlus() + hasSnowtrooper() + hasSnowtrooperPlus() + 
				hasStarck() + hasStarckPlus() + hasImperialProbeDroid() + hasWampa() + hasImperialSoldiers() + hasImperialSoldiersPlus() +
				hasCazarrecompensas() + hasCazarrecompensasPlus() + hasExecutrix() + hasExecutrixPlus() + 
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
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
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

	public int hasROLOPlus() {
		Character c = characterCollection.get("Rebel Officer Leia Organa");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
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
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
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

	public int hasBB8Plus() {
		Character c = characterCollection.get("BB-8");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasR2D2() {
		Character c = characterCollection.get("R2-D2");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasR2D2Plus() {
		Character c = characterCollection.get("R2-D2");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasRJT() {
		Character c = characterCollection.get("Rey (Jedi Training)");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasRJTPlus() {
		Character c = characterCollection.get("Rey (Jedi Training)");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
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

	public int hasR1Plus() {
		int power = 0;
		Character baze = characterCollection.get("Baze Malbus");
		if ((baze!=null) && (baze.getStars() >= 7) && (baze.getLevel() >= 85) && (baze.getGear() >= 8)){
			power+=baze.getPower();
			Character chirrut = characterCollection.get("Chirrut Îmwe");
			if ((chirrut!=null) && (chirrut.getStars() >= 7) && (chirrut.getLevel() >= 85) && (chirrut.getGear() >= 8)){
				power+=chirrut.getPower();
				Character jyn = characterCollection.get("Jyn Erso");
				if ((jyn!=null) && (jyn.getStars() >= 7) && (jyn.getLevel() >= 85) && (jyn.getGear() >= 8)){
					power+=jyn.getPower();
					String[] otherR1={"Bistan","Bodhi Rook","Cassian Andor","K-2SO","Pao","Scarif Rebel Pathfinder"};
					int[] otherR1Power=new int[otherR1.length];
					int otherR1Number = 0;
					int otherR1Position = 0;
					for (String cName:otherR1) {
						Character c = characterCollection.get(cName);
						if (c!=null) {
							otherR1Power[otherR1Position] = c.getPower();
							if ((c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){							
								otherR1Number++;
							}
						} else {
							otherR1Power[otherR1Position] = 0;
						}
						otherR1Position++;
					}
					if (otherR1Number>=2) {
						if((addLargestN(otherR1Power, 2)+power)>75000) {
							return 1;
						}
					}
				}
			}			
		}
		return 0;
	}

	public int hasImperialSoldiers() {
		String[] imperialSoldiers={"General Veers", "Snowtrooper", "Stormtrooper", "Shoretrooper", "Magmatrooper", "Death Trooper", "Colonel Starck", "Range Trooper"};
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

	public int hasImperialSoldiersPlus() {
		String[] imperialSoldiers={"General Veers", "Snowtrooper", "Stormtrooper", "Shoretrooper", "Magmatrooper", "Death Trooper", "Colonel Starck", "Range Trooper"};
		int imperialSoldiersNumber = 0;
		int[] imperialSoldiersPower=new int[imperialSoldiers.length];
		int imperialSoldiersPosition = 0;
		for (String cName:imperialSoldiers) {
			Character c = characterCollection.get(cName);			
			if ((c!=null)&&(c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
				imperialSoldiersNumber++;
				imperialSoldiersPower[imperialSoldiersPosition] = c.getPower();
			}
			imperialSoldiersPosition++;
		}
		if (imperialSoldiersNumber>=5) {
			if((addLargestN(imperialSoldiersPower, 5))>75000) {
				return 1;
			}
		}
		return 0;
	}
	
	public int hasFenixPlus() {
		int power = 0;
		Character hera = characterCollection.get("Hera Syndulla");
		if ((hera!=null) && (hera.getStars() >= 7) && (hera.getLevel() >= 85) && (hera.getGear() >= 8)){
			power+=hera.getPower();
			String[] otherFenix={"Chopper", "Ezra Bridger", "Garazeb \"Zeb\" Orrelios","Kanan Jarrus","Sabine Wren"};
			int[] otherFenixPower=new int[otherFenix.length];
			int otherFenixNumber = 0;
			int otherFenixPosition = 0;
			for (String cName:otherFenix) {
				Character c = characterCollection.get(cName);
				
				if ((c!=null)&&(c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
					otherFenixPower[otherFenixPosition] = c.getPower();
					otherFenixNumber++;
				} else {
					otherFenixPower[otherFenixPosition] = 0;
				}
				otherFenixPosition++;				
			}
			if (otherFenixNumber>=4) {
				if((addLargestN(otherFenixPower, 4)+power)>75000) {
					return 1;
				}
			}
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

	public int hasPalpa() {
		Character c = characterCollection.get("Emperor Palpatine");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasPalpaPlus() {
		Character c = characterCollection.get("Emperor Palpatine");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasVader() {
		Character c = characterCollection.get("Darth Vader");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasVaderPlus() {
		Character c = characterCollection.get("Darth Vader");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
			return 1;
		} else {
			return 0;
		}
	}
	
	public int hasSion() {
		Character c = characterCollection.get("Darth Sion");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasSionPlus() {
		Character c = characterCollection.get("Darth Sion");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasTraya() {
		Character c = characterCollection.get("Darth Traya");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){
			return 1;
		} else {
			return 0;
		}
	}

	public int hasTrayaPlus() {
		Character c = characterCollection.get("Darth Traya");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
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

	public int hasThrawnPlus() {
		Character c = characterCollection.get("Grand Admiral Thrawn");
		if ((c!=null) && (c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 12)){
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

		String[] cazarecompensas={"Boba Fett", "Cad Bane", "Dengar", "Greedo", "Zam Wesell", "IG-88", "Bossk"};
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

	public int hasCazarrecompensasPlus() {
		String[] cazarecompensas={"Boba Fett", "Cad Bane", "Dengar", "Greedo", "Zam Wesell", "IG-88", "Bossk"};
		int cazarecompensasNumber = 0;
		int[] cazarecompensasPower=new int[cazarecompensas.length];
		int cazarecompensasPosition = 0;
		for (String cName:cazarecompensas) {
			Character c = characterCollection.get(cName);			
			if ((c!=null)&&(c.getStars() >= 7) && (c.getLevel() >= 85) && (c.getGear() >= 8)){				
				cazarecompensasNumber++;
				cazarecompensasPower[cazarecompensasPosition] = c.getPower();
			}
			cazarecompensasPosition++;
		}
		if (cazarecompensasNumber>=5) {
			if((addLargestN(cazarecompensasPower, 5))>75000) {
				return 1;
			}
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

	public static int addLargestN(int values[], int n){
		int result = 0;
		Arrays.sort(values);
		for (int i = 1; i<=n; i++){
			result+=values[values.length - i];
		}
	    return result; 
	}	
}