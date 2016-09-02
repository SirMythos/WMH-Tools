/*
 * Project: WMH-Tools
 * Package: de.sirmythos.wmh_tools.threads
 * File:	Thread_Window_Main.java
 *
 * Date:	02.09.2016
 * Time:	11:41:16
 * 
 * @author 	SirMythos
 */
package de.sirmythos.wmh_tools.handler;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.sirmythos.wmh_tools.gui.Panel_Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Thread_Window_Main.
 */
public class Handler_MainWindow {

	/**
	 * New player.
	 *
	 * @param f
	 *            the f
	 */
	public static void newPlayer(JFrame f) {
		Handler_Player.createPlayer(f);
	}

	/**
	 * New list.
	 *
	 * @param f
	 *            the f
	 */
	public static void newList(JFrame f) {
		System.out.println("List");
	}

	/**
	 * New tournament.
	 *
	 * @param f
	 *            the f
	 */
	public static void newTournament(JFrame f) {
		System.out.println("Tournament");
	}

	/**
	 * Gets the player panel.
	 *
	 * @param f
	 *            the f
	 * @return the player panel
	 */
	public static JPanel getPlayerPanel(JFrame f) {
		return new Panel_Player(f);
	}

	/**
	 * New game.
	 *
	 * @param f
	 *            the f
	 */
	public static void newGame(JFrame f) {
		System.out.println("Game");
	}
}
