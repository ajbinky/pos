package time;

import java.sql.Timestamp;
import java.util.HashMap;

public class Timesheet {
	
	private Timestamp clockInTime;
	private HashMap<Timestamp, Timestamp> shifts;
	private boolean isClockedIn;
	
	/**
	 * Constructor
	 * @throws InterruptedException
	 */
	public Timesheet() {
		clockInTime = null;
		shifts = new HashMap<Timestamp, Timestamp>();
		isClockedIn = false;
	}
	
	/**
	 * clockIn()
	 * Creates new Timestamp
	 */
	public void clockIn() {
		if (clockInTime == null) {
			clockInTime = new Timestamp(System.currentTimeMillis());
			isClockedIn = true;
		} else {
			throw new Error("Already clocked in");
		}
	}
	
	/**
	 * clockOut()
	 * Creates new Timestamp and saves it along with the Timestamp from clockIn()
	 */
	public void clockOut() {
		if (clockInTime == null) {
			throw new Error("Not currently clocked in");
		} else {
			shifts.put(clockInTime, new Timestamp(System.currentTimeMillis()));
			clockInTime = null;
			isClockedIn = false;
		}
	}
	
	/**
	 * getIsClockedIn()
	 * @return isClockedIn
	 */
	public boolean getIsClockedIn() {
		return isClockedIn;
	}
	
	/**
	 * getShifts()
	 * @return shifts
	 * 		pairs of Timestamps of shifts clocked in
	 */
	public HashMap<Timestamp, Timestamp> getShifts() {
		return shifts;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Timestamp ts : shifts.keySet()) {
			sb.append(ts.toString());
			sb.append(" ----- ");
			sb.append(shifts.get(ts).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
}