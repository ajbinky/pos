package menu;

/**
 * 
 * MenuItem. Because we need something to sell.
 * 
 * @author AJ Behncke
 *
 */
public class MenuItem {

	private String item;
	private double price;

	/**
	 * Constructor
	 * 
	 * @param item
	 *            Name to give item
	 * @param price
	 *            Price to give item
	 */
	public MenuItem(String item, double price) {
		this.item = item;
		this.price = price;
	}

	/**
	 * Getter
	 * 
	 * @return Name of item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * Setter
	 * 
	 * @param item
	 *            Name to give item
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * Getter
	 * 
	 * @return Price of item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter
	 * 
	 * @param price
	 *            Price to set for item
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.getItem() + " - " + this.getPrice();
	}

}
