package de.sirmythos.dbhandler;

import java.util.Locale;

import de.sirmythos.wmh_tools.enums.Faction;

public class Test_Enum {

	public static void main(String[] args) {
		String[] string = new String[Faction.values().length];
		for (int i = 0 ; i < Faction.values().length; i++){
			string[i] = Faction.values()[i].toString(Locale.ENGLISH);
			System.out.println(string[i]);
		}

	}

}
