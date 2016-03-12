package de.sirmythos.playstatistic.languagepack;

import java.util.Locale;
import java.util.ResourceBundle;

import de.sirmythos.playstatistic.dbobjects.Faction;

public class LanguageHandler {

	public static <T> String translate(Locale locale, Class<T> entityClass, String t) {

		String languagePack = null;

		if (entityClass.getName().equals(Faction.class.getName())) {
			languagePack="language/Faction";
		}
		
		return ResourceBundle.getBundle(languagePack, locale).getString(t);
		
	}

}
