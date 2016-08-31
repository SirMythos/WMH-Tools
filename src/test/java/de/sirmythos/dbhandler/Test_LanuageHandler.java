package de.sirmythos.dbhandler;

import java.util.Locale;

import de.sirmythos.language.LanguageHandler;
import de.sirmythos.wmh_tools.enums.Faction;

public class Test_LanuageHandler {

	public static void main(String[] args) {
		Locale locale = Locale.ENGLISH;
		Locale locale2 = Locale.GERMAN;
		
		System.out.println(LanguageHandler.translate(locale, Faction.class, Faction.PROTECTORATE_OF_MENOTH.toString()));
		System.out.println(LanguageHandler.translate(locale2, Faction.class, Faction.PROTECTORATE_OF_MENOTH.toString()+"_SHORT"));

	}

}
