import java.util.Scanner;

public class EmpMenu {
	public static void startMenu() {
		int menu;
		Scanner in = new Scanner(System.in);
		
		System.out.println("****************************");
		System.out.println("Welcome!");
		System.out.println("Please select one of the menu items using its number value");
		System.out.println("1: Add Employee");
		System.out.println("2: Remove Employee");
		System.out.println("3: Employee List");
		System.out.println("4: Timesheet");
		System.out.println("****************************");
		menu = in.nextInt();
		
		switch (menu) {
		case 1:  System.out.println("Placeholder");
				 break;
		case 2:  System.out.println("Placeholder");
				 break;
		case 3:  System.out.println("Placeholder");
				 break;
		case 4: timeMenu();
				 break;
		default: System.out.println("We're sorry. We don't recognize that value");
				 break;
		}
		
		in.close();
	}

	public static void timeMenu() {
		int menu;
		Scanner in = new Scanner(System.in);
		
		System.out.println("****************************");
		System.out.println("Welcome to the timesheet menu!");
		System.out.println("Please select one of the menu items using its number value");
		System.out.println("1: Clock in");
		System.out.println("2: Clock out");
		System.out.println("3: Print Timesheet");
		System.out.println("****************************");
		menu = in.nextInt();
		
		switch (menu) {
		case 1:  System.out.println("Placeholder");
				 break;
		case 2:  System.out.println("Placeholder");
				 break;
		case 3:  System.out.println("Placeholder");
				 break;
		default: System.out.println("We're sorry. We don't recognize that value");
				 break;
		}
		
		in.close();
	}
}
