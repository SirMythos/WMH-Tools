package de.sirmythos.background;

import de.sirmythos.wmh_tools.gui.Window_MainWindow;

public enum BG_MainFrame {

	INSTANCE;

	private Window_MainWindow mw;
	
	private BG_MainFrame(){
		mw = new Window_MainWindow();
		mw.setVisible(true);
	}

	public Window_MainWindow getWindow() {
		return mw;
	}

}
