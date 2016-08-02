package de.sirmythos.dbhandler;

import java.util.Locale;
import de.sirmythos.language.LanguageHandler;
import de.sirmythos.wmh_play_statistic.dbobjects.Faction;

public class Test_LanuageHandler {

	public static void main(String[] args) {
		Locale locale = Locale.ENGLISH;
		Locale locale2 = Locale.GERMAN;
				
		System.out.println(LanguageHandler.translate(locale, Faction.class, "Protectorat_Long"));
		System.out.println(LanguageHandler.translate(locale2, Faction.class, "Protectorat_Long"));


	}

}
