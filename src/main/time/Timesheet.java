package time;

import java.util.ArrayList;

/**
 * 
 * Used for keeping track of employees' shifts.
 * 
 * @author AJ Behncke
 *
 */
public class Timesheet {

	private ArrayList<Shift> shifts;
	private Shift currentShift;

	/**
	 * Constructor
	 */
	public Timesheet() {
		shifts = new ArrayList<Shift>();
	}

	/**
	 * Creates a new shift and saves initial time
	 * 
	 * @throws Error
	 *             Because I didn't want to take the time to make a new
	 *             error/exception class
	 */
	public void clockIn() {
		if (currentShift == null) {
			currentShift = new Shift(System.currentTimeMillis());
			currentShift.setClockedIn(true);
		} else {
			throw new Error("Already clocked in");
		}
	}

	/**
	 * Sets clockOutTime in currentShift, adds currentShift to shifts, and makes
	 * currentShift null
	 * 
	 * @throws Error
	 *             Because I didn't want to take the time to make a new
	 *             error/exception class
	 */
	public void clockOut() {
		if (currentShift == null) {
			throw new Error("Not currently clocked in");
		} else {
			currentShift.setClockOutTime(System.currentTimeMillis());
			currentShift.setClockedIn(false);
			shifts.add(currentShift);
			currentShift = null;
		}
	}

	/**
	 * Returns true if there is a shift currently open.
	 * 
	 * @return isClockedIn self explanatory I hope
	 */
	public boolean getIsClockedIn() {
		if (currentShift == null) {
			return false;
		}
		return currentShift.isClockedIn();
	}

	/**
	 * Returns an ArrayList of all the employee's shifts
	 * 
	 * @return shifts Returns list of Shifts
	 */
	public ArrayList<Shift> getShifts() {
		return shifts;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Shift s : shifts) {
			sb.append(s.toString() + "\n");
		}
		return sb.toString();
	}

}