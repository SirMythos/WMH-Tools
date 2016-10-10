package de.sirmythos.dbhandler;

import de.sirmythos.background.BG_User;
import de.sirmythos.wmh_tools.dbobjects.User;

public class Test_Background {

	public static void main(String[] args) {
		User u = BG_User.INSTANCE.getUser();
	
		System.out.println(BG_User.INSTANCE.getUser().getId());
				
		BG_User.INSTANCE.getUser().setId(5);
		System.out.println(BG_User.INSTANCE.getUser().getId());
		BG_User.INSTANCE.getUser().setId(3);
		System.out.println(BG_User.INSTANCE.getUser().getId());

	}

}
