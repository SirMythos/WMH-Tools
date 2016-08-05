package de.sirmythos.wmh_tools.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.sirmythos.wmh_tools.dbobjects.Player;
import de.sirmythos.wmh_tools.enums.PlayerSort;
import de.sirmythos.wmh_tools.gui_handler.PlayerHandler;

public class PanelPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7913743622378864203L;

	private Player player = null;
	private PlayerSort sort = PlayerSort.SURNAME;

	private Player[] players = PlayerHandler.loadPlayers(sort);

	private JLabel lblVarName = new JLabel("");
	private JLabel lblVarNickname = new JLabel("");
	private JList<Object> playerList = new JList<Object>(players);
	private JButton btnEditPlayer = new JButton("Edit Player");

	/**
	 * Create the panel.
	 */
	public PanelPlayer() {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				Dimension d = getComponent(3).getPreferredSize();
				d.setSize(event.getComponent().getWidth() / 3, d.getHeight());
				getComponent(3).setPreferredSize(d);

			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}
		});
		addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
				Dimension d = getComponent(3).getPreferredSize();
				d.setSize(e.getComponent().getWidth() / 3, d.getHeight());
				getComponent(3).setPreferredSize(d);
			}
		});
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

		JPanel panelDetails = new JPanel();
		panelDetails.setBorder(null);
		add(panelDetails, BorderLayout.EAST);
		GridBagLayout gbl_panelDetails = new GridBagLayout();
		gbl_panelDetails.columnWidths = new int[] { 30, 90, 120, 30 };
		gbl_panelDetails.rowHeights = new int[] { 30, 30, 30, 30, 30, 30 };
		gbl_panelDetails.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panelDetails.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelDetails.setLayout(gbl_panelDetails);

		JLabel lblName = new JLabel("Name:");
		lblName.setName("lblName");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		panelDetails.add(lblName, gbc_lblName);

		lblVarName.setName("lblVarName");
		GridBagConstraints gbc_lblVarName = new GridBagConstraints();
		gbc_lblVarName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVarName.insets = new Insets(0, 0, 5, 5);
		gbc_lblVarName.gridx = 2;
		gbc_lblVarName.gridy = 3;
		panelDetails.add(lblVarName, gbc_lblVarName);

		lblVarNickname.setName("lblVarNickname");
		GridBagConstraints gbc_lblVarNickname = new GridBagConstraints();
		gbc_lblVarNickname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVarNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblVarNickname.gridx = 2;
		gbc_lblVarNickname.gridy = 4;
		panelDetails.add(lblVarNickname, gbc_lblVarNickname);

		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setName("lblNickname");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 1;
		gbc_lblNickname.gridy = 4;
		panelDetails.add(lblNickname, gbc_lblNickname);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(playerList);

		playerList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				player = (Player) playerList.getSelectedValue();
				if (player != null) {
					lblVarName.setText(player.getName() + " " + player.getSurname());
					lblVarNickname.setText(player.getNickname());
					btnEditPlayer.setEnabled(true);
				}

			}
		});
		playerList.setBorder(null);
		playerList.setValueIsAdjusting(true);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		JButton btnSortByName = new JButton("Sort by Name");
		btnSortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort = PlayerSort.NAME;
				players = PlayerHandler.loadPlayers(sort);
				playerList.setListData(players);
			}
		});
		panel_1.add(btnSortByName);

		JButton btnSortByNick = new JButton("Sort by Nickname");
		btnSortByNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort = PlayerSort.NICKNAME;
				players = PlayerHandler.loadPlayers(sort);
				playerList.setListData(players);
			}
		});
		panel_1.add(btnSortByNick);

		JButton btnSortBySurname = new JButton("Sort by Surname");
		btnSortBySurname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort = PlayerSort.SURNAME;
				players = PlayerHandler.loadPlayers(sort);
				playerList.setListData(players);
			}
		});
		panel_1.add(btnSortBySurname);

		btnEditPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = PlayerHandler.editPlayer(player);
			}
		});
		btnDeletePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				players = PlayerHandler.deletePlayer(player, sort);
				playerList.setListData(players);
				player = null;

			}
		});
		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditPlayer.setEnabled(false);
				Player np = PlayerHandler.createPlayer();
				players = PlayerHandler.loadPlayers(sort);
				playerList.setListData(players);
				for (Player p : players) {
					if (p.getID() == np.getID()) {
						np = p;
						btnEditPlayer.setEnabled(true);
						break;
					}
				}
				playerList.setSelectedValue(np, true);
			}
		});

	}

}
