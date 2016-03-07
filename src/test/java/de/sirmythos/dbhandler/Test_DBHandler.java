package de.sirmythos.dbhandler;

import java.util.List;

import de.sirmythos.playstatistic.dbobjects.Caster;
import de.sirmythos.playstatistic.dbobjects.Faction;
import de.sirmythos.playstatistic.dbobjects.Player;
import de.sirmythos.playstatistic.dbobjects.Steamroller;

public class Test_DBHandler {

	public static void main(String[] args) {

		List<Faction> listFaction = DBHandler.getObjects(Faction.class);
		for (Faction f : listFaction) {
			System.out.println(f.getFactionName());
		}

		List<Player> listPlayer = DBHandler.getObjects(Player.class);
		for (Player p : listPlayer) {
			System.out.println(p.getNickname());
		}

		List<Caster> listCaster = DBHandler.getObjects(Caster.class);
		for (Caster c : listCaster) {
			System.out.println(c.getCasterName() + " (" + c.getFaction().getFactionName() + ")");
		}

		List<Steamroller> listSR = DBHandler.getObjects(Steamroller.class);
		for (Steamroller sr : listSR) {
			System.out.println(sr.getId() + " - " + sr.getSteamroller());
		}

	}
}