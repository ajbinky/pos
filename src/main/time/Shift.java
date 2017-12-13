package time;

import java.sql.Timestamp;

/**
 * 
 * Each individual shift an employee has worked. For use in Timesheet.
 * 
 * @author AJ Behncke
 *
 */
public class Shift {

	private Timestamp clockInTime;
	private Timestamp clockOutTime;
	private boolean isClockedIn;

	/**
	 * Constructor
	 * 
	 * @param clockInTime
	 *            Time in ms
	 */
	public Shift(long clockInTime) {
		this.clockInTime = new Timestamp(clockInTime);
	}

	/**
	 * Probably shouldn't be used? Maybe for testing.
	 * 
	 * @param clockInTime
	 *            Time in ms
	 * @param clockOutTime
	 *            Time in ms
	 */
	public Shift(long clockInTime, long clockOutTime) {
		this.clockInTime = new Timestamp(clockInTime);
		this.clockOutTime = new Timestamp(clockOutTime);
	}

	/**
	 * Returns Timestamp from when it was clocked in
	 * 
	 * @return Timestamp clockInTime
	 */
	public Timestamp getClockInTime() {
		return clockInTime;
	}

	/**
	 * Sets time clocked in
	 * 
	 * @param clockInTime
	 *            Time in ms
	 */
	public void setClockInTime(long clockInTime) {
		this.clockInTime = new Timestamp(clockInTime);
	}

	/**
	 * Returns Timestamp from when it was clocked out
	 * 
	 * @return Timestamp clockOutTime
	 */
	public Timestamp getClockOutTime() {
		return clockOutTime;
	}

	/**
	 * Sets time clocked out
	 * 
	 * @param clockOutTime
	 *            Time in ms
	 */
	public void setClockOutTime(long clockOutTime) {
		this.clockOutTime = new Timestamp(clockOutTime);
	}

	/**
	 * Returns true if this shift is clocked in, else false
	 * 
	 * @return boolean isClockedIn
	 */
	public boolean isClockedIn() {
		return isClockedIn;
	}

	/**
	 * Sets flag for isClockedIn
	 * 
	 * @param isClockedIn
	 *            boolean to set isClockedIn to
	 */
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
