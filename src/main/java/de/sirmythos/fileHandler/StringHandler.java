package de.sirmythos.fileHandler;

public class StringHandler {

	public static String generateOutputString(String[] lines) {
		String result = "";
		for (String l : lines) {
			result = result + l + System.getProperty("line.separator");
		}
		return result;

	}

	public static String[] seperateStringLines(String text) {
		int lines = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '\n') {
				lines++;
			}
		}
		String[] result = new String[lines];
		int line = 0;
		result[line] = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '\n') {
				line++;
				if (line < result.length) {
					result[line] = "";
				}
			} else {
				result[line] = result[line] + text.charAt(i);
			}
		}
		return result;
	}

	public static String[] objectArrayToStringArray(Object[] objectArray) {
		String[] result = new String[objectArray.length];
		int i = 0;
		for (Object o : objectArray) {
			result[i] = o.toString();
			i++;
		}
		return result;
	}
}
