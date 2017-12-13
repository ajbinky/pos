package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import util.Tui;
import util.TuiInterface;

/**
 * 
 * Going about this the ezpz way.
 * 
 * @author AJ Behncke
 *
 */
public class Order implements TuiInterface {

	private static int counter = 1;

	private ArrayList<MenuItem> orderList;
	private Menu menu;
	private int orderNumber;

	/**
	 * Constructor
	 * 
	 * @param menu
	 *            Menu for people to choose from to create order
	 */
	public Order(Menu menu) {
		orderList = new ArrayList<MenuItem>();
		this.menu = menu;
		orderNumber = counter++;
	}

	/**
	 * Essentially just menu.toString()
	 */
	public void displayMenu() {
		ArrayList<MenuItem> menuItems = menu.getMenuItems();
		int i;
		System.out.println("*******************");
		System.out.println("Enter number to select item");
		for (i = 1; i <= menuItems.size(); i++) {
			System.out.println(i + ": " + menuItems.get(i - 1).toString());
		}
		System.out.println(i + ": " + "Return to order");
		System.out.println("*******************");
	}

	/**
	 * Add item to order
	 * @param item
	 * 		item to add
	 */
	public void addItem(MenuItem item) {
		orderList.add(item);
	}

	/**
	 * Remove item from order
	 * 
	 * @param item
	 *            Item to remove
	 */
	public void removeItem(MenuItem item) {
		orderList.remove(item);
	}

	/**
	 * Prints order to file (receipt)
	 * 
	 * @throws FileNotFoundException
	 */
	public void printReceipt() throws FileNotFoundException {
		double total = 0;
		File f = new File("Order" + orderNumber);
		try (PrintWriter pw = new PrintWriter(f)) {
			for (MenuItem item : orderList) {
				pw.println(item.getItem() + " " + item.getPrice());
				total += item.getPrice();
			}
			pw.println("\n\nTotal " + total);
		}
	}

	@Override
	public void Tui(Scanner s) {
		String userInterface = Tui.createInterface("Add item", "Remove item", "Print receipt", "Return to main menu");
		int userInput = 0;
		while (true) {
			System.out.println(userInterface);
			userInput = s.nextInt();
			switch (userInput) {
			case 1: {
				s.nextLine(); // flush
				this.displayMenu();
				int id = s.nextInt() - 1;
				try {
					this.addItem(menu.getMenuItems().get(id));
				} catch (NullPointerException e) {
					return;
				}
				System.out.println("Added");
				break;
			}
			case 2: {
				s.nextLine();
				this.displayMenu();
				int id = s.nextInt() - 1;
				try {
					this.removeItem(menu.getMenuItems().get(id));
				} catch (NullPointerException e) {
					return;
				}
				System.out.println("Removed");
				break;
			}
			case 3: {
				s.nextLine();
				try {
					this.printReceipt();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
			case 4: {
				s.nextLine();
				return;
			}
			default: {
				System.out.println("Didn't catch that. Try again.");
			}
			}

		}
	}
}