package roa.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipTypes {

	private static final Map<String, String> shipTypes = createMap();

	private static Map<String, String> createMap() {
		Map<String, String> shipTypes = new HashMap<String, String>();
		shipTypes.put("Ahsoka Tano's Jedi Starfighter","Light");
		shipTypes.put("Biggs Darklighter's X-wing","Light");
		shipTypes.put("Bistan's U-wing","Light");
		shipTypes.put("Cassian's U-wing","Light");
		shipTypes.put("Chimaera","Dark Capital");
		shipTypes.put("Clone Sergeant's ARC-170","Light");
		shipTypes.put("Endurance","Light Capital");
		shipTypes.put("Executrix","Dark Capital");
		shipTypes.put("First Order SF TIE Fighter","Dark");
		shipTypes.put("First Order TIE Fighter","Dark");
		shipTypes.put("Gauntlet Starfighter","Light");
		shipTypes.put("Geonosian Soldier's Starfighter","Dark");
		shipTypes.put("Geonosian Spy's Starfighter","Dark");
		shipTypes.put("Ghost","Light");
		shipTypes.put("Home One","Light Capital");
		shipTypes.put("Imperial TIE Fighter","Dark");
		shipTypes.put("Jedi Consular's Starfighter","Light");
		shipTypes.put("Kylo Ren's Command Shuttle","Dark");
		shipTypes.put("Lando's Millennium Falcon","Light");
		shipTypes.put("Millennium Falcon (Ep VII)","Light");
		shipTypes.put("Phantom II","Light");
		shipTypes.put("Plo Koon's Jedi Starfighter","Light");
		shipTypes.put("Poe Dameron's X-wing","Light");
		shipTypes.put("Resistance X-wing","Light");
		shipTypes.put("Rex's ARC-170","Light");
		shipTypes.put("Scimitar","Dark");
		shipTypes.put("Slave I","Dark");
		shipTypes.put("Sith Fighter","Dark");
		shipTypes.put("Sun Fac's Geonosian Starfighter","Dark");
		shipTypes.put("TIE Advanced x1","Dark");
		shipTypes.put("TIE Reaper","Dark");
		shipTypes.put("TIE Silencer","Dark");
		shipTypes.put("Umbaran Starfighter","Light");
		shipTypes.put("Wedge Antilles's X-wing","Light");
		return shipTypes;
	}

	public static String get(String shipName) {
		return shipTypes.get(shipName);
	}
	
	public static List<String> getShipNames() {
		List<String> result = new ArrayList<String>();
		result.addAll(shipTypes.keySet());
		Collections.sort(result);
		return result;		
	}

}
