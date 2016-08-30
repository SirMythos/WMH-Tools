package de.sirmythos.wmh_tools.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.sirmythos.wmh_tools.dbobjects.Player;
import de.sirmythos.wmh_tools.enums.PlayerSort;
import de.sirmythos.wmh_tools.handler.Handler_Player;

public class Panel_Player extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7913743622378864203L;

	private Player player = null;
	private PlayerSort sort = PlayerSort.SURNAME;

	private Player[] players = Handler_Player.loadPlayers(sort);

	private JLabel lblVarName = new JLabel("");
	private JLabel lblVarNickname = new JLabel("");
	private JList<Object> playerList = new JList<Object>(players);
	private JButton btnEditPlayer = new JButton("Edit Player");

	private JFrame owner;

	/**
	 * Create the panel.
	 */
	public Panel_Player(JFrame f) {
		owner = f;
		setPreferredSize(new Dimension(750, 600));
		setLayout(new BorderLayout(0, 0));

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		add(panelMenu, BorderLayout.NORTH);

		JButton btnNewPlayer = new JButton("New Player");
		panelMenu.add(btnNewPlayer);

		JButton btnDeletePlayer = new JButton("Delete Player");
		panelMenu.add(btnDeletePlayer);

		btnEditPlayer.setEnabled(false);
		panelMenu.add(btnEditPlayer);

		JPanel panelSatus = new JPanel();
		panelSatus.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) panelSatus.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panelSatus, BorderLayout.SOUTH);

		JLabel lblSpieler = new JLabel("Spieler");
		lblSpieler.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panelSatus.add(lblSpieler);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(playerList);

		playerList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				player = (Player) playerList.getSelectedValue();
				if (player != null) {
					updateDetailsPanel();
					btnEditPlayer.setEnabled(true);
				}

			}
		});
		playerList.setBorder(null);
		playerList.setValueIsAdjusting(true);

		JPanel panelSort = new JPanel();
		panel.add(panelSort, BorderLayout.SOUTH);

		JButton btnSortByName = new JButton("Sort by Name");
		btnSortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				Player tempPlayer = (Player) playerList.getSelectedValue();
				sort = PlayerSort.NAME;
				players = Handler_Player.loadPlayers(sort);
				playerList.setListData(players);
				player = tempPlayer;
				if (player != null) {
					for (Player p : players) {
						if (p.getID() == player.getID()) {
							player = p;
							btnEditPlayer.setEnabled(true);
							break;
						}
					}
					playerList.setSelectedValue(player, true);
				}
			}
		});
		panelSort.add(btnSortByName);

		JButton btnSortByNick = new JButton("Sort by Nickname");
		btnSortByNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				Player tempPlayer = (Player) playerList.getSelectedValue();
				sort = PlayerSort.NICKNAME;
				players = Handler_Player.loadPlayers(sort);
				playerList.setListData(players);
				player = tempPlayer;
				if (player != null) {
					for (Player p : players) {
						if (p.getID() == player.getID()) {
							player = p;
							btnEditPlayer.setEnabled(true);
							break;
						}
					}
					playerList.setSelectedValue(player, true);
				}
			}
		});
		panelSort.add(btnSortByNick);

		JButton btnSortBySurname = new JButton("Sort by Surname");
		btnSortBySurname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				Player tempPlayer = (Player) playerList.getSelectedValue();
				sort = PlayerSort.SURNAME;
				players = Handler_Player.loadPlayers(sort);
				playerList.setListData(players);
				player = tempPlayer;
				if (player != null) {
					for (Player p : players) {
						if (p.getID() == player.getID()) {
							player = p;
							btnEditPlayer.setEnabled(true);
							break;
						}
					}
					playerList.setSelectedValue(player, true);
				}
			}
		});
		panelSort.add(btnSortBySurname);

		JPanel panelDetails = new JPanel();
		panelDetails.setAlignmentY(Component.TOP_ALIGNMENT);
		add(panelDetails, BorderLayout.EAST);
		panelDetails.setBorder(null);
		panelDetails.setPreferredSize(new Dimension(350, 100));
		GridBagLayout gbl_panelDetails = new GridBagLayout();
		gbl_panelDetails.columnWidths = new int[] { 75, 250 };
		gbl_panelDetails.rowHeights = new int[] { 300, 30, 30, 30 };
		gbl_panelDetails.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panelDetails.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		panelDetails.setLayout(gbl_panelDetails);

		JLabel lblNewLabel = new JLabel("Picture");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(250, 250));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(25, 25, 2, 25);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelDetails.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setName("lblName");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(5, 5, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panelDetails.add(lblName, gbc_lblName);

		lblVarName.setName("lblVarName");
		GridBagConstraints gbc_lblVarName = new GridBagConstraints();
		gbc_lblVarName.anchor = GridBagConstraints.WEST;
		gbc_lblVarName.insets = new Insets(5, 5, 0, 5);
		gbc_lblVarName.gridx = 1;
		gbc_lblVarName.gridy = 1;
		panelDetails.add(lblVarName, gbc_lblVarName);

		lblVarNickname.setName("lblVarNickname");
		GridBagConstraints gbc_lblVarNickname = new GridBagConstraints();
		gbc_lblVarNickname.anchor = GridBagConstraints.WEST;
		gbc_lblVarNickname.insets = new Insets(0, 5, 5, 0);
		gbc_lblVarNickname.gridx = 1;
		gbc_lblVarNickname.gridy = 2;
		panelDetails.add(lblVarNickname, gbc_lblVarNickname);

		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setName("lblNickname");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.WEST;
		gbc_lblNickname.insets = new Insets(0, 5, 0, 5);
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 2;
		panelDetails.add(lblNickname, gbc_lblNickname);

		btnEditPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = Handler_Player.editPlayer(owner, player);
				updateDetailsPanel();
			}
		});
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				players = Handler_Player.deletePlayer(player, sort);
				playerList.setListData(players);
				player = null;

			}
		});
		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				player = Handler_Player.createPlayer(owner);
				Player tempPlayer = player;
				players = Handler_Player.loadPlayers(sort);
				playerList.setListData(players);
				player = tempPlayer;
				if (player != null) {
					for (Player p : players) {
						if (p.getID() == player.getID()) {
							player = p;
							btnEditPlayer.setEnabled(true);
							break;
						}
					}
					playerList.setSelectedValue(player, true);
				}
				updateDetailsPanel();

			}
		});

	}

	private void updateDetailsPanel() {
		if (player != null) {
			lblVarName.setText(player.getName() + " " + player.getSurname());
			lblVarNickname.setText(player.getNickname());
		}
		playerList.update(playerList.getGraphics());

	}

}
