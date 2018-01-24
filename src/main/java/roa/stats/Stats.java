package roa.stats;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
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
	
	private void printHeader() {
		System.out.println("Jugador, PG, Arena, Gremio, CLS, Chan 5*, ERH 6*, SRH 5*, R1, Fénix, Home One, Endurance, Vader, G. Veers 5*, S.Nieves, Cazarrecompensas, Executrix 6*, Chimera 5*");
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
		row.getCell(i++).setCellValue(player.hasBB8());
		row.getCell(i++).setCellValue(player.hasCHOLO());
		row.getCell(i++).setCellValue(player.hasCHOLOPlus());
		row.getCell(i++).setCellValue(player.hasHRScout());
		row.getCell(i++).setCellValue(player.hasHRSoldier());
		row.getCell(i++).setCellValue(player.hasR1());
		row.getCell(i++).setCellValue(player.hasFenix());
		row.getCell(i++).setCellValue(player.hasHomeOne()+player.hasEndurance());
		row.getCell(i++).setCellValue(player.hasHomeOnePlus()+player.hasEndurancePlus());
		row.getCell(i++).setCellValue(player.hasVader());
		row.getCell(i++).setCellValue(player.hasThrawn());
		row.getCell(i++).setCellValue(player.hasVeers());
		row.getCell(i++).setCellValue(player.hasVeersPlus());
		row.getCell(i++).setCellValue(player.hasSnowtrooper());
		row.getCell(i++).setCellValue(player.hasSnowtrooperPlus());
		row.getCell(i++).setCellValue(player.hasStarck());
		row.getCell(i++).setCellValue(player.hasStarckPlus());
		row.getCell(i++).setCellValue(player.hasCazarrecompensas());
		row.getCell(i++).setCellValue(player.hasExecutrix());
		row.getCell(i++).setCellValue(player.hasExecutrixPlus());
		row.getCell(i++).setCellValue(player.hasChimaera());
		row.getCell(i++).setCellValue(player.hasChimaeraPlus());
	}
	
	
	public void execute(String[] args) throws IOException, InvalidFormatException, GeneralSecurityException {
		Properties prop = readProperties();
		String[] guildNames = prop.getProperty("guilds").split(",");
		URL template = getClass().getResource("/templates/roastatstemplate.xlsx");
	    File temp = File.createTempFile("ROA_Stats_template", ".xlsx");
	    temp.deleteOnExit();
		FileUtils.copyURLToFile(template, temp);		
		Workbook wbook = WorkbookFactory.create(temp);
	    Sheet wsheet = wbook.getSheetAt(0);                                                    // Does not work with getSheetAt0) -&gt; works with 1! strange
	    Map<String, Player> playerCollection = new HashMap<String, Player>(); 
		for(String oneGuildName:guildNames) {			
			String guildURL = prop.getProperty(oneGuildName + ".url");
			Document document = Jsoup.connect(guildURL).userAgent("Mozilla/5.0").timeout(100000).get();
			Map<String, Player> guildPlayerCollection = SWGOH.retrievePlayers(document, oneGuildName);
			SWGOH.readCollectionSWGOH(guildURL, guildPlayerCollection);
			playerCollection.putAll(guildPlayerCollection);
		}			
	    List<Player> players = new ArrayList<Player>(playerCollection.values());
	    Collections.sort(players, Collections.reverseOrder());
	    int rowNumber = 1;
		for (Player player : players) {
			Row row = wsheet.getRow(rowNumber);
			printPlayer(player, row);
			rowNumber++;
		}
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wbook);
		FileOutputStream fileOut = new FileOutputStream("ROA_Stats.xlsx");
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
