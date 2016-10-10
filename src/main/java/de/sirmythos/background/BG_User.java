package de.sirmythos.background;

import de.sirmythos.wmh_tools.dbobjects.User;

public enum BG_User {

	INSTANCE;

	private User u = new User();

	public User getUser() {
		return u;
	}

}
