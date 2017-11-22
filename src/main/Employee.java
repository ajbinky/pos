import time.Timesheet;

/**
 * 
 * @author AJ Behncke
 *
 */
public class Employee {
	
	private String name;
	private int id;
	private Timesheet timesheet;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void clockIn() {
		timesheet.clockIn();
	}
	
	public void clockOut() {
		timesheet.clockOut();
	}

}
