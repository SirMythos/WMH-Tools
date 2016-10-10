package de.sirmythos.wmh_tools.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.sirmythos.wmh_tools.dbobjects.Player;
import de.sirmythos.wmh_tools.handler.Handler_Player;

public class Dialog_EditPlayer extends JDialog {

	private static final long serialVersionUID = 7036222130016187025L;

	private Player playerData;
	private static JTextField textFieldName;
	private static JTextField textFieldSurname;
	private static JTextField textFieldNickname;
	private JPanel panelPicture;

	public Dialog_EditPlayer(JFrame f, String title, Player p) {
		super(f, true);
		playerData = p;
		if (p == null) {

			p = Handler_Player.createNewPlayerObject();
		}
		setPreferredSize(new Dimension(600, 800));
		setName("Edit_Player_Dialog");
		getContentPane().setName("contentPane");

		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		{
			JPanel panelMain = new JPanel();
			getContentPane().add(panelMain, BorderLayout.CENTER);
			GridBagLayout gbl_panelMain = new GridBagLayout();
			gbl_panelMain.rowHeights = new int[] { 350, 40, 40, 40 };
			gbl_panelMain.columnWidths = new int[] { 100, 480 };
			gbl_panelMain.columnWeights = new double[] { 1.0 };
			gbl_panelMain.rowWeights = new double[] { 1.0, 0.0 };
			panelMain.setLayout(gbl_panelMain);

			panelPicture = new JPanel();
			GridBagConstraints gbc_panelPicture = new GridBagConstraints();
			gbc_panelPicture.gridwidth = 2;
			gbc_panelPicture.insets = new Insets(10, 10, 10, 10);
			gbc_panelPicture.fill = GridBagConstraints.BOTH;
			gbc_panelPicture.gridx = 0;
			gbc_panelPicture.gridy = 0;
			// TODO Picture auslesen implementieren
			panelMain.add(panelPicture, gbc_panelPicture);
			GridBagLayout gbl_panelPicture = new GridBagLayout();
			gbl_panelPicture.columnWidths = new int[] { 300 };
			gbl_panelPicture.rowHeights = new int[] { 300, 0 };
			gbl_panelPicture.columnWeights = new double[] { 0.0 };
			gbl_panelPicture.rowWeights = new double[] { 0.0, 0.0 };
			panelPicture.setLayout(gbl_panelPicture);
			{
				JLabel lblPicture = new JLabel("Please insert Picture here");
				lblPicture.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				lblPicture.setHorizontalTextPosition(SwingConstants.CENTER);
				lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
				lblPicture.setPreferredSize(new Dimension(500, 500));
				GridBagConstraints gbc_lblPicture = new GridBagConstraints();
				gbc_lblPicture.insets = new Insets(0, 0, 5, 0);
				gbc_lblPicture.gridx = 0;
				gbc_lblPicture.gridy = 0;
				panelPicture.add(lblPicture, gbc_lblPicture);

				JButton btnChangePicutre = new JButton("Change Picutre");
				btnChangePicutre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// TODO Picture Management einfügen
					}
				});
				GridBagConstraints gbc_btnChangePicutre = new GridBagConstraints();
				gbc_btnChangePicutre.gridx = 0;
				gbc_btnChangePicutre.gridy = 1;
				panelPicture.add(btnChangePicutre, gbc_btnChangePicutre);
			}
			JLabel lblNickname = new JLabel("Nickname");
			GridBagConstraints gbc_lblNickname = new GridBagConstraints();
			gbc_lblNickname.anchor = GridBagConstraints.WEST;
			gbc_lblNickname.insets = new Insets(10, 10, 10, 10);
			gbc_lblNickname.gridx = 0;
			gbc_lblNickname.gridy = 1;
			panelMain.add(lblNickname, gbc_lblNickname);

			textFieldNickname = new JTextField(p.getNickname());
			GridBagConstraints gbc_textFieldNickname = new GridBagConstraints();
			gbc_textFieldNickname.insets = new Insets(10, 10, 10, 10);
			gbc_textFieldNickname.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNickname.gridx = 1;
			gbc_textFieldNickname.gridy = 1;
			panelMain.add(textFieldNickname, gbc_textFieldNickname);
			textFieldNickname.setColumns(200);

			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(10, 10, 10, 10);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 2;
			panelMain.add(lblName, gbc_lblName);

			textFieldName = new JTextField(p.getName());
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.insets = new Insets(10, 10, 10, 10);
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.gridx = 1;
			gbc_textFieldName.gridy = 2;
			panelMain.add(textFieldName, gbc_textFieldName);
			textFieldName.setColumns(200);

			JLabel lblSurname = new JLabel("Surname");
			GridBagConstraints gbc_lblSurname = new GridBagConstraints();
			gbc_lblSurname.anchor = GridBagConstraints.WEST;
			gbc_lblSurname.insets = new Insets(10, 10, 10, 10);
			gbc_lblSurname.gridx = 0;
			gbc_lblSurname.gridy = 3;
			panelMain.add(lblSurname, gbc_lblSurname);

			textFieldSurname = new JTextField(p.getSurname());
			GridBagConstraints gbc_textFieldSurname = new GridBagConstraints();
			gbc_textFieldSurname.insets = new Insets(10, 10, 10, 10);
			gbc_textFieldSurname.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSurname.gridx = 1;
			gbc_textFieldSurname.gridy = 3;
			panelMain.add(textFieldSurname, gbc_textFieldSurname);
			textFieldSurname.setColumns(200);
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		{
			JButton btnSave = new JButton("Save");
			btnSave.setAction(new ApproveAction());
			buttonPanel.add(btnSave);
			getRootPane().setDefaultButton(btnSave);

			JButton btnCancel = new JButton("Cancel");
			btnCancel.setAction(new DissmissAction());
			buttonPanel.add(btnCancel);
		}

		pack();

	}

	public Player getPlayerData() {
		return playerData;
	}

	@SuppressWarnings("serial")
	private class ApproveAction extends AbstractAction {

		private ApproveAction() {
			super("Ok");
		}

		public void actionPerformed(ActionEvent ae) {
			// TODO Foto-Speicherung implementieren
			if (playerData == null) {
				playerData = new Player();
			}
			playerData.setNickname(textFieldNickname.getText());
			playerData.setName(textFieldName.getText());
			playerData.setSurname(textFieldSurname.getText());
			dispose();

		}
	}

	@SuppressWarnings("serial")
	private class DissmissAction extends AbstractAction {

		private DissmissAction() {
			super("Cancel");
		}

		public void actionPerformed(ActionEvent ae) {

			dispose();

		}
	}

}
