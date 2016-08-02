package de.sirmythos.language;

import java.util.Locale;
import java.util.ResourceBundle;

import de.sirmythos.wmh_play_statistic.dbobjects.Faction;

public class LanguageHandler {

	public static <T> String translate(Locale locale, Class<T> entityClass, String t) {

		String languagePack = null;

		if (entityClass.getName().equals(Faction.class.getName())) {
			languagePack="language/Faction";
		}
		
		return ResourceBundle.getBundle(languagePack, locale).getString(t);
		
	}

}
