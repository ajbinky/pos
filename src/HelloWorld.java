import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		int menu;
		Scanner in = new Scanner(System.in);
		
		System.out.println("****************************");
		System.out.println("Welcome!");
		System.out.println("Please select one of the menu items using its number value");
		System.out.println("1: Reservations");
		System.out.println("2: Menu/Order");
		System.out.println("3: Employee Time Sheets");
		System.out.println("4: Product List");
		System.out.println("****************************");
		menu = in.nextInt();
		
		
		switch (menu) {
			case 1:  System.out.println("This is a placeholder! This is for Reservations");
					 break;
			case 2:  System.out.println("This is a placeholder! This is for the Menu");
					 break;
			case 3:  System.out.println("This is a placeholder! This is for the Employee Sheets");
					 break;
			case 4:  System.out.println("This is a placeholder! This is for the Product list");
					 break;
			default: System.out.println("We're sorry. We don't recognize that value");
					 break;
		}
		
		System.out.println("lskadjf");
		
		in.close();
	}

}
