/*
 * Project: WMH-Tools
 * Package: de.sirmythos.language
 * File:	LanguageHandler.java
 *
 * Date:	02.08.2016
 * Time:	15:42:04
 * 
 * @author 	SirMythos
 */
package de.sirmythos.language;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class LanguageHandler.
 */
public class LanguageHandler {

	/**
	 * Translate.
	 *
	 * @param <T>
	 *            the generic type
	 * @param locale
	 *            the locale
	 * @param entityClass
	 *            the entity class
	 * @param t
	 *            the t
	 * @return the string
	 */
	public static <T> String translate(Locale locale, Class<T> entityClass, String t) {

		t = t.replace(" ", "_");

		String languagePack = "language/";

		String[] s = entityClass.getName().split(Pattern.quote("."));

		languagePack = languagePack.concat(s[s.length - 1]);

		return ResourceBundle.getBundle(languagePack, locale).getString(t);

	}

}
