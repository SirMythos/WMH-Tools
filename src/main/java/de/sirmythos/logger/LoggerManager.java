package de.sirmythos.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LoggerManager {

	public static void setErrorLogToFile() {

		File file = new File("logs/WMH-Tools Error.log");

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		PrintStream ps = new PrintStream(fos);

		System.setErr(ps);
	}

	public static void setErrorLogToConsole() {
		PrintStream console = System.err;
		System.setErr(console);

	}

	public static void setSysOutToFile() {

		File file = new File("logs/WMH-Tools Error.log");

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		PrintStream ps = new PrintStream(fos);

		System.setOut(ps);
	}

	public static void setSysOutToConsole() {
		PrintStream console = System.err;
		System.setOut(console);

	}
}
