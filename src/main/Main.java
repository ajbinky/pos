import java.util.Scanner;

import employee.Employees;
import menu.Menu;
import menu.Order;
import reservation.createResFile;
import util.Tui;

public class Main {

	public static void main(String[] args) throws Exception {

		String menuString = Tui.createInterface("Create new order", "Reservations", "Menu/Products", "Employees",
				"Quick Clock in/out", "Exit");
		createResFile createResFileObject = new createResFile();
		Menu menu = new Menu();
		Employees employees = new Employees();
		int userInput = 0;
		Scanner in = new Scanner(System.in);

		// Program arguments for importing menu and employee?
		// <coding> <falalalalalala> <coding/> @author Nicole Axtell

		while (true) {
			System.out.println(menuString);

			userInput = in.nextInt();

			switch (userInput) {
			case 1:
				new Order(menu).Tui(in);
			case 2:
				createResFileObject.reservation(in);
				break;
			case 3:
				menu.Tui(in);
				break;
			case 4:
				employees.Tui(in);
				break;
			case 5:
				System.out.print("Enter ID: ");
				int id = in.nextInt();
				String s = employees.QuickClockInOut(id);
				System.out.println(s);
				break;
			case 6:
				in.close();
				System.exit(0);
			default:
				System.out.println("We're sorry. We don't recognize that value");
				break;
			}
		}

	}

}
