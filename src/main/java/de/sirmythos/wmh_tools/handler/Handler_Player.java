package de.sirmythos.wmh_tools.handler;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import de.sirmythos.dbhandler.DBHandler;
import de.sirmythos.wmh_tools.dbobjects.Player;
import de.sirmythos.wmh_tools.enums.PlayerSort;
import de.sirmythos.wmh_tools.gui.Dialog_EditPlayer;

public class Handler_Player {

	public static Player createPlayer(JFrame f) {
		Player p = callPlayerDialog(f, "New Player", null);
		if (p != null) {
			p = DBHandler.insertObject(p);
		}
		return p;
	}

	public static Player[] deletePlayer(Player player, PlayerSort sort) {
		DBHandler.removeObject(player);
		return loadPlayers(sort);
	}

	public static Player editPlayer(JFrame f, Player p) {
		p = callPlayerDialog(f, "Edit Player", p);
		DBHandler.updateObject(p);
		return p;
	}

	public static Player[] loadPlayers(PlayerSort sort) {
		List<Player> listPlayer = DBHandler.getObjects(Player.class);
		Player[] players = new Player[listPlayer.size()];
		for (int i = 0; i < players.length; i++) {
			players[i] = listPlayer.get(i);
		}
		switch (sort) {
		case NAME:
			Arrays.sort(players, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
			break;
		case NICKNAME:

			Arrays.sort(players, (a, b) -> a.getNickname().compareToIgnoreCase(b.getNickname()));
			break;
		case SURNAME:
			Arrays.sort(players, (a, b) -> a.getSurname().compareToIgnoreCase(b.getSurname()));
			break;
		}
		return players;
	}

	private static Player callPlayerDialog(JFrame f, String title, Player p) {
		Dialog_EditPlayer dialog = new Dialog_EditPlayer(f, "Edit Player", p);
		dialog.setVisible(true);
		p = dialog.getPlayerData();
		dialog.dispose();
		return p;
	}

	public static Player createNewPlayerObject() {
		return DBHandler.createObject(Player.class);
	}

}
