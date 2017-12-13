package employee;

import time.Timesheet;

/**
 * 
 * Employee. So we can have employees I guess.
 * 
 * @author AJ Behncke
 *
 */
public class Employee {

	// To prevent duplicate IDs
	private static int counter = 100;

	private String name;
	private int id;
	private Timesheet timesheet;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Name to give employee
	 */
	public Employee(String name) {
		this.name = name;
		id = counter++;
		timesheet = new Timesheet();
	}

	/**
	 * Should only be used by {@link Employees#readFile(String)}, or else I can only
	 * assume everything would blow up. I don't really care to take the time to
	 * figure out what would happen and fix it.
	 * 
	 * @param name
	 *            Name given to employee
	 * @param id
	 *            ID given to employee
	 */
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
		timesheet = new Timesheet();
	}

	/**
	 * Getter
	 * 
	 * @return Name of employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter
	 * 
	 * @param name
	 *            Name to give employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter
	 * 
	 * @return ID of employee
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            ID to give employee
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Clocks employee in
	 */
	public void clockIn() {
		timesheet.clockIn();
	}

	/**
	 * Clocks employee out
	 */
	public void clockOut() {
		timesheet.clockOut();
	}

	/**
	 * Getter
	 * 
	 * @return True if employee is clocked in, else false
	 */
	public boolean isClockedIn() {
		return timesheet.getIsClockedIn();
	}

	@Override
	public String toString() {
		return this.getName() + " - " + this.getId();
	}

}
