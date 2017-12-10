package time;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author AJ Behncke
 *
 */
public class Timesheet {
	
	private ArrayList<Shift> shifts;
	private Shift currentShift;
	
	/**
	 * Constructor
	 * @throws InterruptedException
	 */
	public Timesheet() {
		shifts = new ArrayList<Shift>();
	}
	
	/**
	 * clockIn()
	 * Creates new Timestamp
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
	 * clockOut()
	 * Sets clockOutTime in currentShift, adds currentShift to shifts, and makes currentShift null
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
	 * getIsClockedIn()
	 * @return isClockedIn
	 */
	public boolean getIsClockedIn() {
		if (currentShift == null) {
			return false;
		}
		return currentShift.isClockedIn();
	}
	
	/**
	 * getShifts()
	 * @return shifts
	 * 		Returns list of Shifts
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