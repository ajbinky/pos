package time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;

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
		Timestamp expectedStart = new Timestamp(System.currentTimeMillis());
		t.clockIn();
		Thread.sleep(100);
		Timestamp expectedEnd = new Timestamp(System.currentTimeMillis());
		t.clockOut();
		Shift s = t.getShifts().get(0);
		Timestamp actualStart = s.getClockInTime();
		Timestamp actualEnd = s.getClockOutTime();
		assertEquals("Something is wrong with the times for clocked in", expectedStart, actualStart);
		assertEquals("Something is wrong with the times for clocked out", expectedEnd, actualEnd);
	}

}
