package de.sirmythos.dbhandler;

import java.util.List;
import java.util.Locale;

import de.sirmythos.language.LanguageHandler;
import de.sirmythos.wmh_tools.dbobjects.Caster;
import de.sirmythos.wmh_tools.enums.Faction;

public class Test_DBHandler {

	public static void main(String[] args) {

		Locale locale = Locale.ENGLISH;

		List<Caster> listCaster = DBHandler.getObjects(Caster.class, Database.StaticDB);
		int i = 1;
		for (Caster c : listCaster) {
			System.out.println(i + ": "
					+ LanguageHandler.translate(locale, Caster.class,
							c.getFaction().toString() + "." + c.getCasterName())
					+ " (" + LanguageHandler.translate(locale, Faction.class, c.getFaction().toString()) + ")");
			i++;
		}

	}
}