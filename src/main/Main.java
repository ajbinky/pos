import java.util.Scanner;

import menu.Menu;
import reservation.createResFile;
import tui.Tui;

public class Main {

	public static void main(String[] args) throws Exception {
		String menuString = Tui.createInterface("Reservations", "Menu/Order", "Employee Time Sheets", "Product List", "Exit");
		createResFile createResFileObject = new createResFile();
		Menu menu = new Menu();
		int userInput = 0;
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(menuString);

			userInput = in.nextInt();

			switch (userInput) {
			case 1:
				createResFileObject.reservation(in);
				break;
			case 2:
				menu.Tui(in);
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

}
