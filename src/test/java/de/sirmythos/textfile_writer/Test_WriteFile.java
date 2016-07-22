package de.sirmythos.textfile_writer;

import de.sirmythos.fileHandler.ReadFile;
import de.sirmythos.fileHandler.StringHandler;
import de.sirmythos.fileHandler.WriteFile;

public class Test_WriteFile {

	public static void main(String[] args) {
		String[] s = new String[2];
		String s1 = "Test";
		String s2 = "Test Zeile 2";
		s[0] = s1;
		s[1] = s2;
		String test = StringHandler.generateOutputString(s);
		WriteFile.writeTxtFile("temp", "fileWriter", test);
		String txt = ReadFile.readTxtFile("temp", "fileWriter");
		String[] txte = StringHandler.seperateStringLines(txt);
		for (int i = 0; i < txte.length; i++){
			System.out.println("Line " + i + ":");
			System.out.println(txte[i]);
		}
		
	}

}
