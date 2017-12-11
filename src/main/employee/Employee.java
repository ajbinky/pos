package employee;
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
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
		timesheet = new Timesheet();
	}
	
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
