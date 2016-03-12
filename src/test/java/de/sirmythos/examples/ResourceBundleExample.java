package de.sirmythos.examples;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {

	   public static void main(String[] parm) {
	      Locale locale = Locale.ENGLISH;
	      ResourceBundle bundle = 
	         ResourceBundle.getBundle("language/Faction", locale);
	      System.out.println(bundle.getString("ProtectoratLong"));
	   }
	}