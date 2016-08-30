package de.sirmythos.wmh_tools.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import de.sirmythos.wmh_tools.handler.Handler_Window_Main;
import java.awt.Dimension;

public class Window_Main extends JFrame {

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
					Window_Main frame = new Window_Main();
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
	public Window_Main() {
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		setName("MainWindow");
		setTitle("Warmachine/Hordes-Tools");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMain = new JMenu("Menu");
		menuBar.add(mnMain);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setPreferredSize(new Dimension(100, 22));
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		JMenu mnCreateNew = new JMenu("New ...");
		mnCreateNew.setPreferredSize(new Dimension(100, 22));
		mnMain.add(mnCreateNew);

		JMenuItem mntmList = new JMenuItem("List");
		mntmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handler_Window_Main.newList(Window_Main.this);
			}
		});
		mnCreateNew.add(mntmList);

		JMenuItem mntmPlayer = new JMenuItem("Player");
		mntmPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handler_Window_Main.newPlayer(Window_Main.this);
			}
		});
		mnCreateNew.add(mntmPlayer);

		JMenuItem mntmTournament = new JMenuItem("Tournament");
		mntmTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handler_Window_Main.newTournament(Window_Main.this);
			}
		});
		mnCreateNew.add(mntmTournament);

		JSeparator separator = new JSeparator();
		mnMain.add(separator);
		mnMain.add(mntmQuit);

		JMenu mnPlayer = new JMenu("Players");
		menuBar.add(mnPlayer);

		JMenuItem mntmCreateNewPlayer = new JMenuItem("New Player");
		mntmCreateNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handler_Window_Main.newPlayer(Window_Main.this);
			}
		});
		mnPlayer.add(mntmCreateNewPlayer);

		JMenuItem mntmViewPlayerlist = new JMenuItem("Organzise Players");
		mntmViewPlayerlist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setVisible(false);
				int width = getContentPane().getWidth();
				int height = getContentPane().getHeight();
				JPanel panel = Handler_Window_Main.getPlayerPanel(Window_Main.this);
				panel.setSize(width, height);
				setContentPane(panel);
				getContentPane().update(getContentPane().getGraphics());
				getContentPane().setVisible(true);

			}

		});
		mnPlayer.add(mntmViewPlayerlist);

		JMenu mnTournament = new JMenu("Tournaments");
		menuBar.add(mnTournament);

		JMenuItem mntmNewTournament = new JMenuItem("New Tournament");
		mntmNewTournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handler_Window_Main.newTournament(Window_Main.this);
			}
		});
		mnTournament.add(mntmNewTournament);

		JMenu mnLists = new JMenu("Lists");
		menuBar.add(mnLists);

		JMenuItem mntmNewList = new JMenuItem("New List");
		mnLists.add(mntmNewList);
		
		JMenu mnGames = new JMenu("Games");
		menuBar.add(mnGames);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handler_Window_Main.newGame(Window_Main.this);
			}
		});
		mnGames.add(mntmNewGame);

		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setPreferredSize(new Dimension(100, 22));
		mnOptions.add(mntmSettings);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setPreferredSize(new Dimension(100, 22));
		mnHelp.add(mntmAbout);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

	}
}
