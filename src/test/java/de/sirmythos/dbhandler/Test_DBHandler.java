package de.sirmythos.dbhandler;

import java.util.Locale;

public class Test_DBHandler {

	public static void main(String[] args) {

		Locale locale = Locale.ENGLISH;
		Locale locale2 = Locale.GERMAN;

		// List<Faction> listFaction = DBHandler.getObjects(Faction.class);
		// for (Faction f : listFaction) {
		// String t1 = LanguageHandler.translate(locale, f.getClass(),
		// f.getFactionName());
		// String t2 = LanguageHandler.translate(locale2, f.getClass(),
		// f.getFactionName());
		// System.out.println(t1 + " / " + t2);
		// }

		// List<Player> listPlayer = DBHandler.getObjects(Player.class);
		// for (Player p : listPlayer) {
		// System.out.println(p.getNickname());
		// }
		//
		// List<Caster> listCaster = DBHandler.getObjects(Caster.class);
		// for (Caster c : listCaster) {
		// System.out.println(c.getCasterName() + " (" +
		// c.getFaction().getFactionName() + ")");
		// }
		//
		// List<Steamroller> listSR = DBHandler.getObjects(Steamroller.class);
		// for (Steamroller sr : listSR) {
		// System.out.println(sr.getId() + " - " + sr.getSteamroller());
		// }

	}
}