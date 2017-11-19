package time;

import java.sql.Timestamp;
import java.util.HashMap;

public class Timesheet {
	
	private Timestamp clockInTime; // null if not clocked in, otherwise holds timestamp of when clocked in.
	private HashMap<Timestamp, Timestamp> shifts;
	private boolean isClockedIn;
	
	public Timesheet() throws InterruptedException {
		clockInTime = null;
		shifts = new HashMap<Timestamp, Timestamp>();
		isClockedIn = false;
	}
	
	public void clockIn() {
		if (clockInTime == null) {
			clockInTime = new Timestamp(System.currentTimeMillis());
			isClockedIn = true;
		} else {
			// throw error - already clocked in
			throw new Error("Already clocked in");
		}
	}
	
	public void clockOut() {
		if (clockInTime == null) {
			throw new Error("Not currently clocked in");
		} else {
			shifts.put(clockInTime, new Timestamp(System.currentTimeMillis()));
			clockInTime = null;
			isClockedIn = false;
		}
	}
	
	public boolean getIsClockedIn() {
		return isClockedIn;
	}
	
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