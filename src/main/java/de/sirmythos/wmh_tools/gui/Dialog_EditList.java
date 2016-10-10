package de.sirmythos.wmh_tools.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import de.sirmythos.wmh_tools.dbobjects.ArmyList;
import de.sirmythos.wmh_tools.dbobjects.Objective;
import de.sirmythos.wmh_tools.enums.Faction;
import de.sirmythos.wmh_tools.handler.Handler_List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Dialog_EditList extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7382968699783614988L;

	private ArmyList armyList;
	private Faction faction = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 * 
	 * @param aL
	 * @param title
	 * @param f
	 */
	public Dialog_EditList(JFrame f, String title, ArmyList aL) {
		super(f, true);
		setLocale(f.getLocale());
		armyList = aL;
		if (aL == null) {
			// TODO Noch zu befüllen
		}
		setPreferredSize(new Dimension(800, 600));
		setName("Edit_ArmyList_Dialog");
		getContentPane().setName("contentPane");
		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 50, 500 };
		gbl_contentPanel.rowHeights = new int[] { 30, 30, 30, 600, 30 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0 };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name:");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblFaction = new JLabel("Faction:");
			GridBagConstraints gbc_lblFaction = new GridBagConstraints();
			gbc_lblFaction.anchor = GridBagConstraints.EAST;
			gbc_lblFaction.insets = new Insets(0, 0, 5, 5);
			gbc_lblFaction.gridx = 0;
			gbc_lblFaction.gridy = 1;
			contentPanel.add(lblFaction, gbc_lblFaction);
		}
		{
			JComboBox<String> comboBox = new JComboBox<String>();
			
			String[] sFaction = new String[Faction.values().length];
			for (int i = 0; i < Faction.values().length; i++) {
				sFaction[i] = Faction.values()[i].toString(getLocale());
			}
			comboBox.setModel(new DefaultComboBoxModel<String>(sFaction));
			comboBox.setSelectedItem(null);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
				          String item = (String) e.getItem();
				          for (int i = 0; i < Faction.values().length; i++) {
				        	  if (sFaction[i] == item){
				        		  faction = Faction.values()[i]
				        				  // TO DO - Faction-Zuweisung
				        	  }
				          }
				       }
				}
			});
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 1;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblCaster = new JLabel("Caster:");
			GridBagConstraints gbc_lblCaster = new GridBagConstraints();
			gbc_lblCaster.anchor = GridBagConstraints.EAST;
			gbc_lblCaster.insets = new Insets(0, 0, 5, 5);
			gbc_lblCaster.gridx = 0;
			gbc_lblCaster.gridy = 2;
			contentPanel.add(lblCaster, gbc_lblCaster);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "Caster 1", "Caster 2" }));
			comboBox.setSelectedItem(null);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 2;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblList = new JLabel("List:");
			GridBagConstraints gbc_lblList = new GridBagConstraints();
			gbc_lblList.anchor = GridBagConstraints.EAST;
			gbc_lblList.insets = new Insets(0, 0, 5, 5);
			gbc_lblList.gridx = 0;
			gbc_lblList.gridy = 3;
			contentPanel.add(lblList, gbc_lblList);
		}
		{
			JTextPane textPane = new JTextPane();
			GridBagConstraints gbc_textPane = new GridBagConstraints();
			gbc_textPane.insets = new Insets(0, 0, 5, 0);
			gbc_textPane.fill = GridBagConstraints.BOTH;
			gbc_textPane.gridx = 1;
			gbc_textPane.gridy = 3;
			contentPanel.add(textPane, gbc_textPane);
		}
		{
			JLabel lblObjective = new JLabel("Objective:");
			GridBagConstraints gbc_lblObjective = new GridBagConstraints();
			gbc_lblObjective.anchor = GridBagConstraints.EAST;
			gbc_lblObjective.insets = new Insets(0, 0, 0, 5);
			gbc_lblObjective.gridx = 0;
			gbc_lblObjective.gridy = 4;
			contentPanel.add(lblObjective, gbc_lblObjective);
		}
		{
			JComboBox<Objective> comboBox = new JComboBox<Objective>();
			comboBox.setModel(new DefaultComboBoxModel<>(Handler_List.getObjectives(this.getLocale())));
			comboBox.setSelectedItem(null);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 4;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("Save");
				btnSave.setAction(new ApproveAction());
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setAction(new DissmissAction());;
				buttonPane.add(btnCancel);
			}
		}
	}

	public ArmyList getListData() {
		return armyList;
	}
	
	@SuppressWarnings("serial")
	private class ApproveAction extends AbstractAction {

		private ApproveAction() {
			super("Ok");
		}

		public void actionPerformed(ActionEvent ae) {
			// TODO Datensicherung implementieren
		
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
