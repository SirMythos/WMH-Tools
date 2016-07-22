package de.sirmythos.fileHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {

	public static void writeTxtFile(String path, String fileName, String text) {

		Writer fw = null;

		try {
			fw = new FileWriter(path + "/" + fileName + ".txt");
			fw.write(text);
		} catch (IOException e) {
			System.err.println("Konnte Datei nicht erstellen!");
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("Konnte Writer nicht schlieﬂen!");
				}
		}
	}

	public static void writeCsvFile(String path, String fileName, Object[] objectArray) {

		Writer fw = null;
		String[] stringArray = StringHandler.objectArrayToStringArray(objectArray);
		String text = StringHandler.generateOutputString(stringArray);

		try {
			fw = new FileWriter(path + "/" + fileName + ".csv");
			fw.write(text);
		} catch (IOException e) {
			System.err.println("Konnte Datei nicht erstellen!");
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("Konnte Writer nicht schlieﬂen!");
				}
		}

	}

}
