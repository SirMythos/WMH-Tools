package de.sirmythos.wmh_tools.gui_handler;

import java.util.List;

import de.sirmythos.dbhandler.DBHandler;
import de.sirmythos.wmh_tools.dbobjects.Player;
import de.sirmythos.wmh_tools.enums.PlayerSort;

public class PlayerHandler {

	public static Player createPlayer() {
		
		Player p = new Player();

		System.out.println("Neuen Player anlegen");

		return p;
	}

	public static Player[] deletePlayer(Player player, PlayerSort sort) {

		System.out.println("Player löschen");

		return loadPlayers(sort);

	}

	public static Player editPlayer(Player player) {
		System.out.println("Player bearbeiten");

		return player;

	}

	public static Player[] loadPlayers(PlayerSort sort) {
		System.out.println("Spieler laden");

		List<Player> listPlayer = DBHandler.getObjects(Player.class);

		Player[] players = new Player[listPlayer.size()];

		for (int i = 0; i < players.length; i++) {
			players[i] = listPlayer.get(i);
		}

		return players;

	}

}
