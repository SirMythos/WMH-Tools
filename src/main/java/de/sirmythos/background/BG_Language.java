package de.sirmythos.background;

import java.util.Locale;

public enum BG_Language {

	GERMAN(Locale.GERMAN), 
	ENGLISH(Locale.ENGLISH);

	private Locale locale;

	private BG_Language(Locale locale) {
		this.locale = locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}
}
