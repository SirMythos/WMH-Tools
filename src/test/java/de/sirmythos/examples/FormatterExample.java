package de.sirmythos.examples;

import java.text.*;
import java.util.*;

public class FormatterExample {

	private void formatNumbers(Locale locale) {
		NumberFormat formatter = NumberFormat.getNumberInstance(locale);
		System.out.println(formatter.format(101001.22d) + ", " + locale);
	}

	private void formatCurrency(Locale locale) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
		System.out.println(formatter.format(101001.22d) + ", " + locale);
	}

	private void formatDate(Locale locale) {
		Calendar cal = Calendar.getInstance(locale);
		// this is terrible: it actually is the first of may
		cal.set(2005, 04, 01);
		Date date = cal.getTime();
		// first a formatting-schema then the actual value
		// BTW: DateFormat.MEDIUM yields a textual month
		// for French and English but not for German
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
		System.out.println(formatter.format(date) + ", " + locale);
		formatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		System.out.println(formatter.format(date) + ", " + locale);
	}

	public static void main(String[] parm) {
		FormatterExample example = new FormatterExample();
		example.formatNumbers(Locale.GERMAN);
		example.formatNumbers(Locale.FRANCE);
		example.formatNumbers(Locale.US);
		System.out.println();
		example.formatCurrency(Locale.GERMANY);
		example.formatCurrency(Locale.FRANCE);
		example.formatCurrency(Locale.US);
		System.out.println();
		example.formatDate(Locale.GERMAN);
		example.formatDate(Locale.FRANCE);
		example.formatDate(Locale.US);
		example.formatDate(Locale.UK);
	}
}
