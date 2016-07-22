package de.sirmythos.fileHandler;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadFile {

	public static String readTxtFile(String path, String fileName) {

		Reader reader = null;
		String txt = "";
		try {
			reader = new FileReader(path + "/" + fileName + ".txt");

			for (int c; (c = reader.read()) != -1;)
				txt = txt + (char) c;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Fehler beim Lesen der Datei!");
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				System.err.println("Konnte Reader nicht schlieﬂen!");
			}
		}
		return txt;
	}
}
