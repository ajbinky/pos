package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author AJ Behncke
 *
 */
public class Menu {
	
	private ArrayList<MenuItem> menuItems;
	Pattern regexPattern;
	Matcher regexMatcher;
	
	/**
	 * Default constructor
	 * Maybe we can use for demonstration or something
	 */
	public Menu() {
		menuItems = new ArrayList<MenuItem>();
		regexPattern = Pattern.compile("(.*) (\\d.\\d{0,2})");
	}
	
	/**
	 * Constructor
	 * @param menuFile
	 * 		File with menu items and prices, one item name and price per line, separated by spaces
	 * item1 price1
	 * item2 price2
	 * etc
	 * @throws FileNotFoundException 
	 */
	public Menu(File menuFile) throws FileNotFoundException {
		menuItems = new ArrayList<MenuItem>();
		regexPattern = Pattern.compile("(.*) (\\d.\\d{0,2})");
		readMenuFile(menuFile);
	}
	
	private void readMenuFile(File f) throws FileNotFoundException {
		Scanner s = new Scanner(f);
		
		while (s.hasNextLine()) {
			regexMatcher = regexPattern.matcher(s.nextLine());
			regexMatcher.matches();
			menuItems.add(new MenuItem(regexMatcher.group(1), Double.parseDouble(regexMatcher.group(2))));
		}
		s.close();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (MenuItem i : menuItems) {
			sb.append(i.getItem() + " - $" + i.getPrice() + "\n");
		}
		return sb.toString();
	}

}
