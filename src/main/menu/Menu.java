package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tui.Tui;
import tui.TuiInterface;

/**
 * 
 * @author AJ Behncke
 *
 */
public class Menu implements TuiInterface {

	private ArrayList<MenuItem> menuItems;
	Pattern regexPattern;
	Matcher regexMatcher;

	/**
	 * Default constructor Maybe we can use for demonstration or something
	 */
	public Menu() {
		menuItems = new ArrayList<MenuItem>();
		regexPattern = Pattern.compile("(.*) (\\d.\\d{0,2})");
	}

	/**
	 * Constructor
	 * 
	 * @param menuFile
	 *            File with menu items and prices, one item name and price per line,
	 *            separated by spaces item1 price1 item2 price2 etc
	 * @throws FileNotFoundException
	 */
	public Menu(File menuFile) throws FileNotFoundException {
		menuItems = new ArrayList<MenuItem>();
		regexPattern = Pattern.compile("(.*) (\\d.\\d{0,2})");
		readMenuFile(menuFile);
	}

	// Why didn't I do string arg
	private void readMenuFile(File f) throws FileNotFoundException {
		Scanner s = new Scanner(f);

		while (s.hasNextLine()) {
			regexMatcher = regexPattern.matcher(s.nextLine());
			regexMatcher.matches();
			menuItems.add(new MenuItem(regexMatcher.group(1), Double.parseDouble(regexMatcher.group(2))));
		}
		s.close();
	}

	/**
	 * Saves file with current menu. Formatted the same as the way it is read.
	 * 
	 * @param file
	 *            String of the file path and name to be saved to
	 * @throws FileNotFoundException
	 */
	public void saveMenuFile(String file) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (MenuItem item : menuItems) {
				pw.println(item.getItem() + " " + item.getPrice());
			}
		}
	}

	/**
	 * Adds a new menu item based on given details.
	 * 
	 * @param itemName
	 *            Name of the item
	 * @param price
	 *            Price of the item
	 */
	public void addMenuItem(String itemName, double price) {
		menuItems.add(new MenuItem(itemName, price));
	}

	/**
	 * Removes all items with name matching what is given.
	 * 
	 * @param itemName
	 *            Name of item(s) to remove
	 */
	public int removeMenuItem(String itemName) {
		int removed = 0;
		
		for (Iterator<MenuItem> it = menuItems.iterator(); it.hasNext();) {
			MenuItem item = it.next();
			if (item.getItem().equals(itemName)) {
				it.remove();
				removed++;
			}
		}
		
		/*
		for (MenuItem item : menuItems) {
			if (item.getItem().equals(itemName)) {
				menuItems.remove(item);
				removed++;
			}
		}
		Exception in thread "main" java.util.ConcurrentModificationException
		RIP
		*/
		return removed;
	}

	/**
	 * Removes all items with name and price matching what is given.
	 * 
	 * @param itemName
	 *            Name of item(s) to remove
	 * @param price
	 *            Price of item(s) to remove
	 */
	public int removeMenuItem(String itemName, double price) {
		int removed = 0;
		
		for (Iterator<MenuItem> it = menuItems.iterator(); it.hasNext();) {
			MenuItem item = it.next();
			if (item.getItem().equals(itemName) && item.getPrice() == price) {
				it.remove();
				removed++;
			}
		}
		
		/*
		for (MenuItem item : menuItems) {
			if (item.getItem().equals(itemName) && item.getPrice() == price) {
				menuItems.remove(item);
				removed++;
			}
		}
		Exception in thread "main" java.util.ConcurrentModificationException
		RIP
		*/
		return removed;
	}

	public void Tui(Scanner s) {
		String userInterface = Tui.createInterface("View all items", "Add item to menu", "Remove item from menu",
				"Save menu to file", "Rescan menu file", "Return to main menu");
		int userInput = 0;
		while (true) {
			System.out.println(userInterface);
			userInput = s.nextInt();
			switch (userInput) {
			case 1: {
				s.nextLine(); // flush
				System.out.println("****************************");
				if (menuItems.isEmpty()) {
					System.out.println("-No items currently in menu-");
				} else {
					System.out.println(this.toString());
				}
				System.out.println("****************************");
				break;
			}
			case 2: {
				s.nextLine(); // flush
				System.out.print("Item Name: ");
				String itemName = s.nextLine();
				System.out.print("\nItem Price: ");
				double price = s.nextDouble();
				this.addMenuItem(itemName, price);
				System.out.println("\nItem added.");
				break;
			}
			case 3: {
				s.nextLine(); // flush
				int removed;
				System.out.print("Enter name of item to remove: ");
				String itemName = s.nextLine();
				System.out.print("\nEnter price of item (enter -1 to only match by name): ");
				double price = s.nextDouble();
				if (price == -1) {
					removed = this.removeMenuItem(itemName);
				} else {
					removed = this.removeMenuItem(itemName, price);
				}
				System.out.println("\n" + removed + " items have been removed.");
				break;
			}
			case 4: {
				s.nextLine(); // flush
				System.out.print("Enter file name: ");
				String fileName = s.nextLine();
				try {
					saveMenuFile(fileName);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("\nMenu saved.");
				break;
			}
			case 5: {
				s.nextLine(); // flush
				System.out.print("Enter file name: ");
				String fileName = s.nextLine();
				try {
					readMenuFile(new File(fileName));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("\nMenu imported.");
				break;
			}
			case 6: {
				s.nextLine(); // flush
				return;
			}
			default: {
				s.nextLine(); // flush
				System.out.println("We're sorry. We don't recognize that value");
				break;
			}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (MenuItem i : menuItems) {
			sb.append(i.getItem() + " - $" + i.getPrice() + "\n");
		}
		return sb.toString();
	}

}
