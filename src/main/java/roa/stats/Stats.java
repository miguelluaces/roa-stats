package roa.stats;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import roa.stats.swgoh.SWGOH;

public class Stats {
	private String propertiesFile = "config.properties";
	
	private Properties readProperties() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = Stats.class.getClassLoader().getResourceAsStream(propertiesFile);
		if(input==null){
			throw new RuntimeException("Sorry, unable to find " + propertiesFile);
		} else {
			prop.load(input);
			return prop;
		}
	}
	
	public static void printPlayer(Player player, Row row) {
		int i = 0;
		row.getCell(i++).setCellValue(player.getPlayerName());
		row.getCell(i++).setCellValue(player.getPlayerPG());
		row.getCell(i++).setCellValue(player.getArenaAvg());
		row.getCell(i++).setCellValue(player.getGuildName());
		row.getCell(i++).setCellValue(player.hasCLS());
		row.getCell(i++).setCellValue(player.hasCLSPlus());
		row.getCell(i++).setCellValue(player.hasGK());
		row.getCell(i++).setCellValue(player.hasGKPlus());
		row.getCell(i++).setCellValue(player.hasBB8());
		row.getCell(i++).setCellValue(player.hasBB8Plus());
		row.getCell(i++).setCellValue(player.hasR2D2());
		row.getCell(i++).setCellValue(player.hasR2D2Plus());
		row.getCell(i++).setCellValue(player.hasRJT());
		row.getCell(i++).setCellValue(player.hasRJTPlus());
		row.getCell(i++).setCellValue(player.hasCHOLO());
		row.getCell(i++).setCellValue(player.hasCHOLOPlus());
		row.getCell(i++).setCellValue(player.hasHRScout());
		row.getCell(i++).setCellValue(player.hasHRSoldier());
		row.getCell(i++).setCellValue(player.hasROLO());
		row.getCell(i++).setCellValue(player.hasHermitYoda());
		row.getCell(i++).setCellValue(player.hasR1());
		row.getCell(i++).setCellValue(player.hasR1Plus());
		row.getCell(i++).setCellValue(player.hasFenix());
		row.getCell(i++).setCellValue(player.hasFenixPlus());
		row.getCell(i++).setCellValue(player.hasHomeOne()+player.hasEndurance());
		row.getCell(i++).setCellValue(player.hasHomeOnePlus()+player.hasEndurancePlus());
		row.getCell(i++).setCellValue(player.hasPalpa());
		row.getCell(i++).setCellValue(player.hasPalpaPlus());
		row.getCell(i++).setCellValue(player.hasVader());
		row.getCell(i++).setCellValue(player.hasVaderPlus());
		row.getCell(i++).setCellValue(player.hasThrawn());
		row.getCell(i++).setCellValue(player.hasThrawnPlus());
		row.getCell(i++).setCellValue(player.hasVeers());
		row.getCell(i++).setCellValue(player.hasVeersPlus());
		row.getCell(i++).setCellValue(player.hasSnowtrooper());
		row.getCell(i++).setCellValue(player.hasSnowtrooperPlus());
		row.getCell(i++).setCellValue(player.hasStarck());
		row.getCell(i++).setCellValue(player.hasStarckPlus());
		row.getCell(i++).setCellValue(player.hasImperialProbeDroid());
		row.getCell(i++).setCellValue(player.hasWampa());
		row.getCell(i++).setCellValue(player.hasImperialSoldiers());
		row.getCell(i++).setCellValue(player.hasImperialSoldiersPlus());
		row.getCell(i++).setCellValue(player.hasCazarrecompensas());
		row.getCell(i++).setCellValue(player.hasCazarrecompensasPlus());
		row.getCell(i++).setCellValue(player.hasExecutrix());
		row.getCell(i++).setCellValue(player.hasExecutrixPlus());
		row.getCell(i++).setCellValue(player.hasChimaera());
		row.getCell(i++).setCellValue(player.hasChimaeraPlus());
	}
	
	private void creaExcelEstado(String guildName, Map<String, Player> guildPlayerCollection, List<PlayerZeta> playerZetas) throws IOException, InvalidFormatException {
		Workbook wbook = WorkbookFactory.create(getClass().getResourceAsStream("/templates/roaestadotemplate.xlsx"));
		Sheet wsheet = wbook.getSheetAt(0);
		List<Player> players = new ArrayList<Player>(guildPlayerCollection.values());
		Collections.sort(players);
		int rowNumber = 1;
		for (Player player : players) {
			Map<String, Character> characterCollection = player.getCharacterCollection();
			for (Character character:characterCollection.values()) {
				int i = 1;
				Row row = wsheet.getRow(rowNumber);
				row.getCell(i++).setCellValue(player.getPlayerName());
				row.getCell(i++).setCellValue(character.getName());
				row.getCell(i++).setCellValue(character.getStars());
				row.getCell(i++).setCellValue(character.getGear());
				row.getCell(i++).setCellValue(character.getLevel());
				rowNumber++;
			}
			Map<String, Ship> shipCollection = player.getShipCollection();
			for (Ship ship:shipCollection.values()) {
				int i = 1;
				Row row = wsheet.getRow(rowNumber);
				row.getCell(i++).setCellValue(player.getPlayerName());
				row.getCell(i++).setCellValue(ship.getName());
				row.getCell(i++).setCellValue(ship.getStars());
				row.getCell(i++).setCellValue("");
				row.getCell(i++).setCellValue(ship.getLevel());
				rowNumber++;				
			}
		}
		wsheet = wbook.getSheetAt(1);
		int zetaRow = 1;
		for (PlayerZeta playerZeta : playerZetas) {
			int i = 1;
			Row row = wsheet.getRow(zetaRow);
			row.getCell(i++).setCellValue(playerZeta.getPlayerName());
			row.getCell(i++).setCellValue(playerZeta.getCharacterName());
			row.getCell(i++).setCellValue(playerZeta.getZetaName());
			zetaRow++;
		}
		wsheet = wbook.getSheetAt(2);
		rowNumber = 1;
		for (String characterName:CharacterTypes.getCharacterNames()) {
			Row row = wsheet.getRow(rowNumber);
			row.getCell(0).setCellValue(characterName);
			row.getCell(1).setCellValue(CharacterTypes.get(characterName));
			rowNumber++;
		}
		wsheet = wbook.getSheetAt(3);
		rowNumber = 1;
		for (String shipName:ShipTypes.getShipNames()) {
			Row row = wsheet.getRow(rowNumber);
			row.getCell(0).setCellValue(shipName);
			row.getCell(1).setCellValue(ShipTypes.get(shipName));
			rowNumber++;
		}
		List<String> playerNames = new ArrayList<String>(guildPlayerCollection.keySet());
		Collections.sort(playerNames, ASCIICaseInsensitiveComparator.CASE_INSENSITIVE_ORDER);
		wsheet = wbook.getSheetAt(4);
		Row row = wsheet.getRow(0);
		int i = 2;
		for (String playerName:playerNames) {
			row.getCell(i).setCellValue(playerName);
			i++;
		}
		wsheet = wbook.getSheetAt(5);
		row = wsheet.getRow(0);
		i = 2;
		for (String playerName:playerNames) {
			row.getCell(i).setCellValue(playerName);
			i++;
		}
		wsheet = wbook.getSheetAt(6);
		row = wsheet.getRow(0);
		i = 3;
		for (String playerName:playerNames) {
			row.getCell(i).setCellValue(playerName);
			i+=3;
		}
		wsheet = wbook.getSheetAt(7);
		row = wsheet.getRow(0);
		i = 2;
		for (String playerName:playerNames) {
			row.getCell(i).setCellValue(playerName);
			i++;
		}
		wsheet = wbook.getSheetAt(8);
		rowNumber = 1;
		for (String playerName:playerNames) {
			row = wsheet.getRow(rowNumber);
			row.getCell(1).setCellValue(playerName);
			rowNumber++;
		}
		wbook.setForceFormulaRecalculation(true);
		FileOutputStream fileOut = new FileOutputStream("Estado_" + guildName + ".xlsx");
		wbook.write(fileOut);
		fileOut.close();		
	}
	
	public void execute(String[] args) throws IOException, InvalidFormatException, GeneralSecurityException {
		Properties prop = readProperties();
		String[] guildNames = prop.getProperty("guilds").split(",");
	    Map<String, Player> playerCollection = new HashMap<String, Player>(); 
		for(String oneGuildName:guildNames) {			
			String guildURL = prop.getProperty(oneGuildName + ".url");
			Document document = Jsoup.connect(guildURL).userAgent("Mozilla/5.0").timeout(100000).get();
			Map<String, Player> guildPlayerCollection = SWGOH.retrievePlayers(document, oneGuildName);
			Document zetasDocument = Jsoup.connect(guildURL.concat("zetas/")).userAgent("Mozilla/5.0").timeout(100000).get();
			List<PlayerZeta> playerZetas = SWGOH.readPlayerZetas(zetasDocument);
			SWGOH.readCollectionSWGOH(guildURL, guildPlayerCollection);
			playerCollection.putAll(guildPlayerCollection);
			creaExcelEstado(oneGuildName, guildPlayerCollection, playerZetas);
		}			
	    List<Player> players = new ArrayList<Player>(playerCollection.values());
	    Collections.sort(players, Collections.reverseOrder());
	    int rowNumber = 1;
		Workbook wbook = WorkbookFactory.create(getClass().getResourceAsStream("/templates/roastatstemplate.xlsx"));
	    Sheet wsheet = wbook.getSheetAt(0);
		for (Player player : players) {
			Row row = wsheet.getRow(rowNumber);
			printPlayer(player, row);
			rowNumber++;
		}
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wbook);
		FileOutputStream fileOut = new FileOutputStream("Stats.xlsx");
		wbook.write(fileOut);
		fileOut.close();
	}

	public static void main(String[] args) {
		Stats stats = new Stats();
		try {
			stats.execute(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

