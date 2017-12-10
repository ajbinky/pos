package time;

import java.sql.Timestamp;

public class Shift {

	private Timestamp clockInTime;
	private Timestamp clockOutTime;
	private boolean isClockedIn;
	
	/**
	 * 
	 * @param clockInTime
	 */
	public Shift(long clockInTime) {
		this.clockInTime = new Timestamp(clockInTime);
	}

	/**
	 * Probably shouldn't be used? Maybe for testing.
	 * @param clockInTime
	 * @param clockOutTime
	 */
	public Shift(long clockInTime, long clockOutTime) {
		this.clockInTime = new Timestamp(clockInTime);
		this.clockOutTime = new Timestamp(clockOutTime);
	}

	public Timestamp getClockInTime() {
		return clockInTime;
	}

	public void setClockInTime(long clockInTime) {
		this.clockInTime = new Timestamp(clockInTime);
	}

	public Timestamp getClockOutTime() {
		return clockOutTime;
	}

	public void setClockOutTime(long clockOutTime) {
		this.clockOutTime = new Timestamp(clockOutTime);
	}

	public boolean isClockedIn() {
		return isClockedIn;
	}

	public void setClockedIn(boolean isClockedIn) {
		this.isClockedIn = isClockedIn;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(clockInTime.toString());
		sb.append(" --- ");
		sb.append(clockOutTime.toString());
		return sb.toString();
	}

}
