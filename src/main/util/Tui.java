package util;

/**
 * 
 * Helper method for building a text based menu.
 * 
 * @author AJ Behncke
 *
 */
public class Tui {

	/**
	 * 
	 * Builds and returns a String for a menu to suit your needs.
	 * 
	 * @param args
	 *            Strings that you want as options in the menu
	 * @return String String built with the given arguments
	 * 
	 *         for example Main.userInterface("Hello world!"); would return a string
	 *         that, when printed, would look like this:
	 *         </ul>
	 *         <li>****************************</li>
	 *         <li>Welcome! - Apparently I broke the javadoc.... oh well.</li>
	 *         <li>Please select one of the menu items using its number value</li>
	 *         <li>1: Hello world!</li>
	 *         <li>****************************</li>
	 *         </ul>
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
