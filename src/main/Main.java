import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		createResFile createResFileObject = new createResFile();
		int menu = 0;
		Scanner in = new Scanner(System.in);
		while(true) {
		System.out.println("****************************");
		System.out.println("Welcome!");
		System.out.println("Please select one of the menu items using its number value");
		System.out.println("1: Reservations");
		System.out.println("2: Menu/Order");
		System.out.println("3: Employee Time Sheets");
		System.out.println("4: Product List");
		System.out.println("5: Exit");
		System.out.println("****************************");
		
		menu = in.nextInt();
		
		
		switch (menu) {
			case 1:  createResFileObject.reservation(in);
					 break;
			case 2:  System.out.println("This is a placeholder! This is for the Menu");
					 break;
			case 3:  ;
					 break;
			case 4:  System.out.println("This is a placeholder! This is for the Product list");
					 break;
			case 5:  
				in.close();
				System.exit(0);
			default: System.out.println("We're sorry. We don't recognize that value");
					 break;
		}
		}

	}
	


}
