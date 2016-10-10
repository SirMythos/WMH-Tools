package de.sirmythos.wmh_tools.handler;

import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;

import de.sirmythos.dbhandler.DBHandler;
import de.sirmythos.dbhandler.Database;
import de.sirmythos.wmh_tools.dbobjects.ArmyList;
import de.sirmythos.wmh_tools.dbobjects.Objective;
import de.sirmythos.wmh_tools.gui.Dialog_EditList;

public class Handler_List {

	public static ArmyList createList(JFrame f) {
		ArmyList aL = callListDialog(f, "New List", null);
		if (aL != null) {
			aL = DBHandler.insertObject(aL, Database.DynamicDB);
		}
		return aL;
	}

	private static ArmyList callListDialog(JFrame f, String title, ArmyList aL) {
		Dialog_EditList dialog = new Dialog_EditList(f, title, aL);
		dialog.setVisible(true);
		aL = dialog.getListData();
		dialog.dispose();
		return aL;
	}

	public static Objective[] getObjectives(Locale locale) {
		List<Objective> listObjective = DBHandler.getObjects(Objective.class, Database.StaticDB);
		for (Objective o: listObjective){
			o.setLocale(locale);
		}
		return listObjective.toArray(new Objective[0]);
	}

}
