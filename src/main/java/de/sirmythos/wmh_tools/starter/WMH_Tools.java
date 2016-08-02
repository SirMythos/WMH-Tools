package de.sirmythos.wmh_tools.starter;

import java.util.List;
import java.util.Locale;

import de.sirmythos.dbhandler.DBHandler;
import de.sirmythos.language.LanguageHandler;
import de.sirmythos.logger.LoggerManager;
import de.sirmythos.wmh_tools.dbobjects.Faction;

public class WMH_Tools {

	public static void main(String[] args) {

		// LoggerManager.setErrorLogToFile();
		// LoggerManager.setSysOutToFile();

		// JOptionPane.showMessageDialog(null, "WMH-Tools mit Modulen");

		Locale locale = Locale.ENGLISH;
		Locale locale2 = Locale.GERMAN;
		List<Faction> listFaction = null;
		listFaction = DBHandler.getObjects(Faction.class);
		for (Faction f : listFaction) {
			String t1 = LanguageHandler.translate(locale, f.getClass(), f.getFactionName());
			String t2 = LanguageHandler.translate(locale2, f.getClass(), f.getFactionName());
			System.out.println(t1 + " / " + t2);
		}
	}

}
