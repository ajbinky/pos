package tui;

/**
 * 
 * @author AJ Behncke
 *
 */
public class Tui {

	/**
	 * 
	 * @param args
	 * 		Strings that you want as options in the menu
	 * @return String
	 * 		String built with the given arguments
	 * 
	 * for example
	 * Main.userInterface("Hello world!");
	 * would return a string that, when printed, would look like this:
	 * ****************************
	 * Welcome!
	 * Please select one of the menu items using its number value
	 * 1: Hello world!
	 * ****************************
	 */
	public static String createInterface(String... args) {
		int counter = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("****************************\n");
		sb.append("Welcome!\n");
		sb.append("Please select one of the menu items using its number value\n");
		for (String s : args) {
			sb.append(counter++ + ": " + s + "\n");
		}
		sb.append("****************************");
		return sb.toString();
	}
	
}
