package roa.stats;

import java.util.HashMap;
import java.util.Map;

public class CharacterTypes {

	private static final Map<String, String> characterTypes = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> characterTypes = new HashMap<String, String>();
		characterTypes.put("Commander Luke Skywalker","01 Especiales");
		characterTypes.put("Hoth Rebel Scout","01 Especiales");
		characterTypes.put("Hoth Rebel Soldier","01 Especiales");
		characterTypes.put("Rebel Officer Leia Organa","01 Especiales");
		characterTypes.put("Captain Han Solo","01 Especiales");
		characterTypes.put("Admiral Ackbar","02 Rebeldes");
		characterTypes.put("Biggs Darklighter","02 Rebeldes");
		characterTypes.put("Han Solo","02 Rebeldes");
		characterTypes.put("Lando Calrissian","02 Rebeldes");
		characterTypes.put("Lobot","02 Rebeldes");
		characterTypes.put("Luke Skywalker (Farmboy)","02 Rebeldes");
		characterTypes.put("Princess Leia","02 Rebeldes");
		characterTypes.put("R2-D2","02 Rebeldes");
		characterTypes.put("Stormtrooper Han","02 Rebeldes");
		characterTypes.put("Wedge Antilles","02 Rebeldes");
		characterTypes.put("Chopper","03 F�nix");
		characterTypes.put("Ezra Bridger","03 F�nix");
		characterTypes.put("Garazeb \"Zeb\" Orrelios","03 F�nix");
		characterTypes.put("Hera Syndulla","03 F�nix");
		characterTypes.put("Kanan Jarrus","03 F�nix");
		characterTypes.put("Sabine Wren","03 F�nix");
		characterTypes.put("Baze Malbus","04 Rogue One");
		characterTypes.put("Bistan","04 Rogue One");
		characterTypes.put("Bodhi Rook","04 Rogue One");
		characterTypes.put("Cassian Andor","04 Rogue One");
		characterTypes.put("Chirrut �mwe","04 Rogue One");
		characterTypes.put("Jyn Erso","04 Rogue One");
		characterTypes.put("K-2SO","04 Rogue One");
		characterTypes.put("Pao","04 Rogue One");
		characterTypes.put("Scarif Rebel Pathfinder","04 Rogue One");
		characterTypes.put("Clone Wars Chewbacca","05 Otros");
		characterTypes.put("Coruscant Underworld Police","05 Otros");
		characterTypes.put("Veteran Smuggler Chewbacca","05 Otros");
		characterTypes.put("Veteran Smuggler Han Solo","05 Otros");
		characterTypes.put("Ugnaught","05 Otros");
		characterTypes.put("Chief Chirpa","06 Ewok");
		characterTypes.put("Ewok Elder","06 Ewok");
		characterTypes.put("Ewok Scout","06 Ewok");
		characterTypes.put("Logray","06 Ewok");
		characterTypes.put("Paploo","06 Ewok");
		characterTypes.put("Teebo","06 Ewok");
		characterTypes.put("Wicket","06 Ewok");
		characterTypes.put("Aayla Secura","07 Jedis");
		characterTypes.put("Ahsoka Tano","07 Jedis");
		characterTypes.put("Ahsoka Tano (Fulcrum)","07 Jedis");
		characterTypes.put("Barriss Offee","07 Jedis");
		characterTypes.put("Eeth Koth","07 Jedis");
		characterTypes.put("General Kenobi","07 Jedis");
		characterTypes.put("Grand Master Yoda","07 Jedis");
		characterTypes.put("Hermit Yoda","07 Jedis");
		characterTypes.put("Ima-Gun Di","07 Jedis");
		characterTypes.put("Jedi Consular","07 Jedis");
		characterTypes.put("Jedi Knight Anakin","07 Jedis");
		characterTypes.put("Jedi Knight Guardian","07 Jedis");
		characterTypes.put("Kit Fisto","07 Jedis");
		characterTypes.put("Luminara Unduli","07 Jedis");
		characterTypes.put("Mace Windu","07 Jedis");
		characterTypes.put("Obi-Wan Kenobi (Old Ben)","07 Jedis");
		characterTypes.put("Plo Koon","07 Jedis");
		characterTypes.put("Qui-Gon Jinn","07 Jedis");
		characterTypes.put("CC-2224 \"Cody\"","08 Clones");
		characterTypes.put("CT-21-0408 \"Echo\"","08 Clones");
		characterTypes.put("CT-5555 \"Fives\"","08 Clones");
		characterTypes.put("CT-7567 \"Rex\"","08 Clones");
		characterTypes.put("Clone Sergeant - Phase I","08 Clones");
		characterTypes.put("BB-8", "09 Resistencia");
		characterTypes.put("Finn", "09 Resistencia");
		characterTypes.put("Poe Dameron", "09 Resistencia");
		characterTypes.put("Resistance Pilot", "09 Resistencia");
		characterTypes.put("Resistance Trooper", "09 Resistencia");
		characterTypes.put("Rey (Jedi Training)", "09 Resistencia");
		characterTypes.put("Rey (Scavenger)", "09 Resistencia");
		characterTypes.put("Chief Nebit", "10 Jawas");
		characterTypes.put("Dathcha", "10 Jawas");
		characterTypes.put("Jawa", "10 Jawas");
		characterTypes.put("Jawa Engineer", "10 Jawas");
		characterTypes.put("Jawa Scavenger", "10 Jawas");
		characterTypes.put("Colonel Starck", "50 Especial");
		characterTypes.put("Darth Vader", "50 Especial");
		characterTypes.put("General Veers", "50 Especial");
		characterTypes.put("Snowtrooper", "50 Especial");
		characterTypes.put("Imperial Probe Droid", "50 Especial");
		characterTypes.put("Death Trooper", "51 Imperio");
		characterTypes.put("Director Krennic", "51 Imperio");
		characterTypes.put("Emperor Palpatine", "51 Imperio");
		characterTypes.put("Gar Saxon", "51 Imperio");
		characterTypes.put("Grand Admiral Thrawn", "51 Imperio");
		characterTypes.put("Grand Moff Tarkin", "51 Imperio");
		characterTypes.put("Imperial Super Commando", "51 Imperio");
		characterTypes.put("Magmatrooper", "51 Imperio");
		characterTypes.put("Royal Guard", "51 Imperio");
		characterTypes.put("Shoretrooper", "51 Imperio");
		characterTypes.put("Stormtrooper", "51 Imperio");
		characterTypes.put("TIE Fighter Pilot", "51 Imperio");
		characterTypes.put("Count Dooku", "52 Sith");
		characterTypes.put("Darth Maul", "52 Sith");
		characterTypes.put("Darth Nihilus", "52 Sith");
		characterTypes.put("Darth Sidious", "52 Sith");
		characterTypes.put("Savage Opress", "52 Sith");
		characterTypes.put("Sith Assassin", "52 Sith");
		characterTypes.put("Sith Trooper", "52 Sith");
		characterTypes.put("Captain Phasma", "53 Primera Orden");
		characterTypes.put("First Order Officer", "53 Primera Orden");
		characterTypes.put("First Order SF TIE Pilot", "53 Primera Orden");
		characterTypes.put("First Order Stormtrooper", "53 Primera Orden");
		characterTypes.put("First Order TIE Pilot", "53 Primera Orden");
		characterTypes.put("Kylo Ren", "53 Primera Orden");
		characterTypes.put("Kylo Ren (Unmasked)", "53 Primera Orden");
		characterTypes.put("Boba Fett", "54 Cazarecompensas");
		characterTypes.put("Cad Bane", "54 Cazarecompensas");
		characterTypes.put("Dengar", "54 Cazarecompensas");
		characterTypes.put("Greedo", "54 Cazarecompensas");
		characterTypes.put("Zam Wesell", "54 Cazarecompensas");
		characterTypes.put("B2 Super Battle Droid", "55 Droide");
		characterTypes.put("General Grievous", "55 Droide");
		characterTypes.put("HK-47", "55 Droide");
		characterTypes.put("IG-100 MagnaGuard", "55 Droide");
		characterTypes.put("IG-86 Sentinel Droid", "55 Droide");
		characterTypes.put("IG-88", "55 Droide");
		characterTypes.put("Asajj Ventress", "56 Hermana");
		characterTypes.put("Mother Talzin", "56 Hermana");
		characterTypes.put("Nightsister Acolyte", "56 Hermana");
		characterTypes.put("Nightsister Initiate", "56 Hermana");
		characterTypes.put("Nightsister Spirit", "56 Hermana");
		characterTypes.put("Nightsister Zombie", "56 Hermana");
		characterTypes.put("Old Daka", "56 Hermana");
		characterTypes.put("Talia", "56 Hermana");
		characterTypes.put("Geonosian Soldier", "57 Geonosiano");
		characterTypes.put("Geonosian Spy", "57 Geonosiano");
		characterTypes.put("Poggle the Lesser", "57 Geonosiano");
		characterTypes.put("Sun Fac", "57 Geonosiano");
		characterTypes.put("Tusken Raider", "58 Tusken");
		characterTypes.put("Tusken Shaman", "58 Tusken");
		characterTypes.put("URoRRuR'R'R", "58 Tusken");
		characterTypes.put("Gamorrean Guard", "59 Otros");
		characterTypes.put("Mob Enforcer", "59 Otros");
		characterTypes.put("Nute Gunray", "59 Otros");
		characterTypes.put("Wampa", "59 Otros");		
		return characterTypes;
	}

	public static String get(String characterName) {
		return characterTypes.get(characterName);
	}

}
