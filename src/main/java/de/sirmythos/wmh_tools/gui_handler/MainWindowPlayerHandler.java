package de.sirmythos.wmh_tools.gui_handler;

import javax.swing.JPanel;

import de.sirmythos.wmh_tools.gui.PanelPlayer;

public class MainWindowPlayerHandler {
	
	public static void createNewPlayer() {
		PlayerHandler.createPlayer();
	}

	public static JPanel getPlayerMenu() {
		return new PanelPlayer();
	}

}
