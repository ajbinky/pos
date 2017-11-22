package time;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author AJ Behncke
 *
 */
public class TimesheetTest {
	
	Timesheet t;

	@Before
	public void setUp() throws Exception {
		t = new Timesheet();
	}
	
	@Test
	public void testIsClockedIn() {
		assertFalse("isClockedIn doesn't initialize correctly", t.getIsClockedIn());
		t.clockIn();
		assertTrue("clockIn() doesn't change isClockedIn properly", t.getIsClockedIn());
		t.clockOut();
		assertFalse("clockOut() doesn't change isClockedIn properly", t.getIsClockedIn());
	}

	@Test
	public void testClockInClockOut() throws InterruptedException {
		long msStart = System.currentTimeMillis();
		t.clockIn();
		Thread.sleep(100);
		long msEnd = System.currentTimeMillis();
		t.clockOut();
		HashMap<Timestamp, Timestamp> shifts = t.getShifts();
		Timestamp ts = shifts.keySet().iterator().next();
		Timestamp te = shifts.get(new Timestamp(msStart));
		//System.out.println("ts: " + ts.getTime() + "\nte: " + te.getTime() + "\nmsStart: " + msStart + "\nmsEnd: " + msEnd);
		assertEquals("Timestamps time are innacurate", msEnd-msStart, te.getTime()-ts.getTime());
	}

}
