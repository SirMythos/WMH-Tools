package de.sirmythos.wmh_tools.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import de.sirmythos.wmh_tools.gui_handler.MainWindowMenuHandler;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2326374662070310221L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow").getString("MainWindow.this.title")); //$NON-NLS-1$ //$NON-NLS-2$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		// setExtendedState(Frame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMain = new JMenu(
				ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow").getString("MainWindow.mnMain.text")); //$NON-NLS-1$ //$NON-NLS-2$
		menuBar.add(mnMain);

		JMenuItem mntmQuit = new JMenuItem(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mntmQuit.text")); //$NON-NLS-1$
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		JMenu mnCreateNew = new JMenu(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mnCreateNew.text")); //$NON-NLS-1$
		mnMain.add(mnCreateNew);

		JMenuItem mntmList = new JMenuItem(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mntmList.text")); //$NON-NLS-1$
		mnCreateNew.add(mntmList);

		JMenuItem mntmPlayer = new JMenuItem(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mntmPlayer.text")); //$NON-NLS-1$
		mntmPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindowMenuHandler.createNewPlayer();
			}
		});
		mnCreateNew.add(mntmPlayer);

		JMenuItem mntmTournament = new JMenuItem(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mntmTournament.text")); //$NON-NLS-1$
		mnCreateNew.add(mntmTournament);
		mnMain.add(mntmQuit);

		JMenu mnPlayer = new JMenu(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mnPlayer.text")); //$NON-NLS-1$
		menuBar.add(mnPlayer);

		JMenuItem mntmCreateNewPlayer = new JMenuItem(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mntmCreateNewPlayer.text")); //$NON-NLS-1$
		mntmCreateNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindowMenuHandler.createNewPlayer();
			}
		});
		mnPlayer.add(mntmCreateNewPlayer);

		JMenuItem mntmViewPlayerlist = new JMenuItem(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mntmViewPlayerlist.text")); //$NON-NLS-1$
		mntmViewPlayerlist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				int width = getContentPane().getWidth();
				int height = getContentPane().getHeight();
				JPanel panel = new PanelPlayer();
				panel.setSize(width, height);
				setContentPane(panel);
				getContentPane().update(getContentPane().getGraphics());
				getContentPane().setVisible(true);

			}

		});
		mnPlayer.add(mntmViewPlayerlist);

		JMenu mnTournament = new JMenu(ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow") //$NON-NLS-1$
				.getString("MainWindow.mnTournament.text")); //$NON-NLS-1$
		menuBar.add(mnTournament);

		JMenu mnLists = new JMenu(
				ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow").getString("MainWindow.mnLists.text")); //$NON-NLS-1$ //$NON-NLS-2$
		menuBar.add(mnLists);

		JMenu mnHelp = new JMenu(
				ResourceBundle.getBundle("de.sirmythos.wmh_tools.gui.MainWindow").getString("MainWindow.mnHelp.text")); //$NON-NLS-1$ //$NON-NLS-2$
		menuBar.add(mnHelp);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

	}
}
