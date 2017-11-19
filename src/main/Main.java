import time.Timesheet;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Timesheet ts = new Timesheet();
		ts.clockIn();
		Thread.sleep(5000);
		ts.clockOut();
		ts.clockIn();
		Thread.sleep(5000);
		ts.clockOut();
		ts.clockIn();
		Thread.sleep(5000);
		ts.clockOut();
		ts.clockIn();
		Thread.sleep(5000);
		ts.clockOut();
		System.out.println(ts.toString());
		System.out.println("Hello World!");
	}

}
