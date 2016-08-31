package de.sirmythos.wmh_tools.threads;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.sirmythos.wmh_tools.gui.Panel_Player;
import de.sirmythos.wmh_tools.handler.Handler_Player;

public class Thread_Window_Main {

	public static void newPlayer(JFrame f) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Handler_Player.createPlayer(f);
			}
		});
	}

	public static void newList(JFrame f) {
		System.out.println("List");
	}

	public static void newTournament(JFrame f) {
		System.out.println("Tournament");
	}

	public static JPanel getPlayerPanel(JFrame f) {
		return new Panel_Player(f);
	}

	public static void newGame(JFrame f) {
		System.out.println("Game");
	}
}
