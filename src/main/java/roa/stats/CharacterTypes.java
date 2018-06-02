package roa.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterTypes {

	private static final Map<String, String> characterTypes = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> characterTypes = new HashMap<String, String>();
		characterTypes.put("Aayla Secura","Light");
		characterTypes.put("Admiral Ackbar","Light");
		characterTypes.put("Ahsoka Tano","Light");
		characterTypes.put("Ahsoka Tano (Fulcrum)","Light");
		characterTypes.put("Amilyn Holdo","Light");
		characterTypes.put("Asajj Ventress","Dark");
		characterTypes.put("B2 Super Battle Droid","Dark");
		characterTypes.put("Barriss Offee","Light");
		characterTypes.put("Baze Malbus","Light");
		characterTypes.put("BB-8","Light");
		characterTypes.put("Biggs Darklighter","Light");
		characterTypes.put("Bistan","Light");
		characterTypes.put("Boba Fett","Dark");
		characterTypes.put("Bodhi Rook","Light");
		characterTypes.put("Bossk","Dark");
		characterTypes.put("Cad Bane","Dark");
		characterTypes.put("Captain Han Solo","Light");
		characterTypes.put("Captain Phasma","Dark");
		characterTypes.put("Cassian Andor","Light");
		characterTypes.put("CC-2224 \"Cody\"","Light");
		characterTypes.put("Chief Chirpa","Light");
		characterTypes.put("Chief Nebit","Light");
		characterTypes.put("Chirrut �mwe","Light");
		characterTypes.put("Chopper","Light");
		characterTypes.put("Clone Sergeant - Phase I","Light");
		characterTypes.put("Clone Wars Chewbacca","Light");
		characterTypes.put("Colonel Starck","Dark");
		characterTypes.put("Commander Luke Skywalker","Light");
		characterTypes.put("Coruscant Underworld Police","Light");
		characterTypes.put("Count Dooku","Dark");
		characterTypes.put("CT-21-0408 \"Echo\"","Light");
		characterTypes.put("CT-5555 \"Fives\"","Light");
		characterTypes.put("CT-7567 \"Rex\"","Light");
		characterTypes.put("Darth Maul","Dark");
		characterTypes.put("Darth Nihilus","Dark");
		characterTypes.put("Darth Sidious","Dark");
		characterTypes.put("Darth Sion","Dark");
		characterTypes.put("Darth Traya","Dark");
		characterTypes.put("Darth Vader","Dark");
		characterTypes.put("Dathcha","Light");
		characterTypes.put("Death Trooper","Dark");
		characterTypes.put("Dengar","Dark");
		characterTypes.put("Director Krennic","Dark");
		characterTypes.put("Eeth Koth","Light");
		characterTypes.put("Emperor Palpatine","Dark");
		characterTypes.put("Enfys Nest","Light"); 
		characterTypes.put("Ewok Elder","Light");
		characterTypes.put("Ewok Scout","Light");
		characterTypes.put("Ezra Bridger","Light");
		characterTypes.put("Finn","Light");
		characterTypes.put("First Order Executioner","Dark");
		characterTypes.put("First Order Officer","Dark");
		characterTypes.put("First Order SF TIE Pilot","Dark");
		characterTypes.put("First Order Stormtrooper","Dark");
		characterTypes.put("First Order TIE Pilot","Dark");
		characterTypes.put("Gamorrean Guard","Dark");
		characterTypes.put("Gar Saxon","Dark");
		characterTypes.put("Garazeb \"Zeb\" Orrelios","Light");
		characterTypes.put("General Grievous","Dark");
		characterTypes.put("General Kenobi","Light");
		characterTypes.put("General Veers","Dark");
		characterTypes.put("Geonosian Soldier","Dark");
		characterTypes.put("Geonosian Spy","Dark");
		characterTypes.put("Grand Admiral Thrawn","Dark");
		characterTypes.put("Grand Master Yoda","Light");
		characterTypes.put("Grand Moff Tarkin","Dark");
		characterTypes.put("Greedo","Dark");
		characterTypes.put("Han Solo","Light");
		characterTypes.put("Hera Syndulla","Light");
		characterTypes.put("Hermit Yoda","Light");
		characterTypes.put("HK-47","Dark");
		characterTypes.put("Hoth Rebel Scout","Light");
		characterTypes.put("Hoth Rebel Soldier","Light");
		characterTypes.put("IG-100 MagnaGuard","Dark");
		characterTypes.put("IG-86 Sentinel Droid","Dark");
		characterTypes.put("IG-88","Dark");
		characterTypes.put("Ima-Gun Di","Light");
		characterTypes.put("Imperial Probe Droid","Dark");
		characterTypes.put("Imperial Super Commando","Dark");
		characterTypes.put("Jawa","Light");
		characterTypes.put("Jawa Engineer","Light");
		characterTypes.put("Jawa Scavenger","Light");
		characterTypes.put("Jedi Consular","Light");
		characterTypes.put("Jedi Knight Anakin","Light");
		characterTypes.put("Jedi Knight Guardian","Light");
		characterTypes.put("Jyn Erso","Light");
		characterTypes.put("K-2SO","Light");
		characterTypes.put("Kanan Jarrus","Light");
		characterTypes.put("Kit Fisto","Light");
		characterTypes.put("Kylo Ren","Dark");
		characterTypes.put("Kylo Ren (Unmasked)","Dark");
		characterTypes.put("Lando Calrissian","Light");
		characterTypes.put("Lobot","Light");
		characterTypes.put("Logray","Light");
		characterTypes.put("Luke Skywalker (Farmboy)","Light");
		characterTypes.put("Luminara Unduli","Light");
		characterTypes.put("Mace Windu","Light");
		characterTypes.put("Magmatrooper","Dark");
		characterTypes.put("Mob Enforcer","Dark");
		characterTypes.put("Mother Talzin","Dark");
		characterTypes.put("Nightsister Acolyte","Dark");
		characterTypes.put("Nightsister Initiate","Dark");
		characterTypes.put("Nightsister Spirit","Dark");
		characterTypes.put("Nightsister Zombie","Dark");
		characterTypes.put("Nute Gunray","Dark");
		characterTypes.put("Obi-Wan Kenobi (Old Ben)","Light");
		characterTypes.put("Old Daka","Dark");
		characterTypes.put("Pao","Light");
		characterTypes.put("Paploo","Light");
		characterTypes.put("Plo Koon","Light");
		characterTypes.put("Poe Dameron","Light");
		characterTypes.put("Poggle the Lesser","Dark");
		characterTypes.put("Princess Leia","Light");
		characterTypes.put("Qi'ra","Light");
		characterTypes.put("Qui-Gon Jinn","Light");
		characterTypes.put("R2-D2","Light");
		characterTypes.put("Rebel Officer Leia Organa","Light");
		characterTypes.put("Resistance Pilot","Light");
		characterTypes.put("Resistance Trooper","Light");
		characterTypes.put("Rey (Jedi Training)","Light");
		characterTypes.put("Rey (Scavenger)","Light");
		characterTypes.put("Rose Tico","Light");
		characterTypes.put("Royal Guard","Dark");
		characterTypes.put("Sabine Wren","Light");
		characterTypes.put("Savage Opress","Dark");
		characterTypes.put("Scarif Rebel Pathfinder","Light");
		characterTypes.put("Shoretrooper","Dark");
		characterTypes.put("Sith Assassin","Dark");
		characterTypes.put("Sith Marauder","Dark");
		characterTypes.put("Sith Trooper","Dark");
		characterTypes.put("Snowtrooper","Dark");
		characterTypes.put("Stormtrooper","Dark");
		characterTypes.put("Stormtrooper Han","Light");
		characterTypes.put("Sun Fac","Dark");
		characterTypes.put("Talia","Dark");
		characterTypes.put("Teebo","Light");
		characterTypes.put("TIE Fighter Pilot","Dark");
		characterTypes.put("Tusken Raider","Dark");
		characterTypes.put("Tusken Shaman","Dark");
		characterTypes.put("Ugnaught","Light");
		characterTypes.put("URoRRuR'R'R","Dark");
		characterTypes.put("Vandor Chewbacca","Light");
		characterTypes.put("Veteran Smuggler Chewbacca","Light");
		characterTypes.put("Veteran Smuggler Han Solo","Light");
		characterTypes.put("Wampa","Dark");
		characterTypes.put("Wedge Antilles","Light");
		characterTypes.put("Wicket","Light");
		characterTypes.put("Young Han Solo","Light");
		characterTypes.put("Zam Wesell","Dark");
		return characterTypes;
	}

	public static String get(String characterName) {
		return characterTypes.get(characterName);
	}
	
	public static List<String> getCharacterNames() {
		List<String> result = new ArrayList<String>();
		result.addAll(characterTypes.keySet());
		Collections.sort(result);
		return result;		
	}

}