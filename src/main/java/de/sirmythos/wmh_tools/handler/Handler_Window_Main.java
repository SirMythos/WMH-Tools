package de.sirmythos.wmh_tools.handler;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.sirmythos.wmh_tools.gui.Panel_Player;

public class Handler_Window_Main {

	public static void newPlayer(JFrame f) {
		Handler_Player.createPlayer(f);
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
	
	public static void newGame(JFrame f){
		System.out.println("Game");
	}
}
