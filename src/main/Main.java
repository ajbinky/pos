import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		String menuString = userInterface("Reservations", "Menu/Order", "Employee Time Sheets", "Product List", "Exit");
		createResFile createResFileObject = new createResFile();
		int menu = 0;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(menuString);

			menu = in.nextInt();

			switch (menu) {
			case 1:
				createResFileObject.reservation(in);
				break;
			case 2:
				System.out.println("This is a placeholder! This is for the Menu");
				break;
			case 3:
				;
				break;
			case 4:
				System.out.println("This is a placeholder! This is for the Product list");
				break;
			case 5:
				in.close();
				System.exit(0);
			default:
				System.out.println("We're sorry. We don't recognize that value");
				break;
			}
		}

	}
	
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
	public static String userInterface(String... args) {
		int counter = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("****************************\n");
		sb.append("Welcome!\n");
		sb.append("Please select one of the menu items using its number value\n");
		for (String s : args) {
			sb.append(counter++ + ": " + s + "\n");
		}
		sb.append("****************************\n");
		return sb.toString();
	}

}
