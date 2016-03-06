package de.sirmythos.dbhandler;

import java.util.List;

import de.sirmythos.playstatistic.dbobjects.Caster;
import de.sirmythos.playstatistic.dbobjects.Faction;
import de.sirmythos.playstatistic.dbobjects.Player;

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

		Caster caster = new Caster();
		caster.setCasterName("Commander Coleman Stryker");
		caster.setCasterShortName("Stryker1");
		caster.setFaction(listFaction.get(0));

		DBHandler.insertObject(caster);

		List<Caster> listCaster = DBHandler.getObjects(Caster.class);
		for (Caster c : listCaster) {
			System.out.println(c.getCasterName() + " (" + c.getFaction().getFactionName() + ")");
		}
	}
}