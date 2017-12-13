package employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Tui;
import util.TuiInterface;

/**
 * 
 * Saves a list of {@link Employee}s.
 * 
 * @author AJ Behncke
 *
 */
public class Employees implements TuiInterface {

	private ArrayList<Employee> employees;
	private Pattern pattern;
	private Matcher matcher;

	/**
	 * Constructor
	 */
	public Employees() {
		employees = new ArrayList<Employee>();
		pattern = Pattern.compile("(.*) (\\d*)");
	}

	/**
	 * Add {@link Employee} with given name (id auto-assigned)
	 * 
	 * @param name
	 *            Name of new employee
	 */
	public void addEmployee(String name) {
		employees.add(new Employee(name));
	}

	/**
	 * Remove {@link Employee} with given id
	 * 
	 * @param id
	 *            ID of employee to be removed
	 * @return number of employees removed
	 */
	public int removeEmployee(int id) {
		int removed = 0;

		for (Iterator<Employee> it = employees.iterator(); it.hasNext();) {
			Employee emp = it.next();
			if (emp.getId() == id) {
				it.remove();
				removed++;
			}
		}

		return removed;
	}

	/**
	 * Saves all {@link Employee}s to a text file. Each {@link Employee} on a new
	 * line, with space delimiters.
	 * 
	 * @param file
	 *            String containing file path and name
	 * @throws FileNotFoundException
	 *             if file isn't found I assume?
	 */
	public void saveToFile(String file) throws FileNotFoundException {
		File f = new File(file);
		try (PrintWriter pw = new PrintWriter(f)) {
			for (Employee e : employees) {
				pw.println(e.getName() + " " + e.getId());
			}
		}
	}

	/**
	 * Reads given file and imports all employees from the file. (Overwriting
	 * existing employees)
	 * 
	 * @param file
	 *            String with file path and name
	 * @throws FileNotFoundException
	 *             if file isn't found I assume?
	 */
	public void readFile(String file) throws FileNotFoundException {
		employees = new ArrayList<Employee>();
		File f = new File(file);
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			matcher = pattern.matcher(s.nextLine());
			matcher.matches();
			employees.add(new Employee(matcher.group(1), Integer.parseInt(matcher.group(2))));
		}
		s.close();
	}

	public String QuickClockInOut(int id) {
		for (Employee e : employees) {
			if (e.getId() == id) {
				if (e.isClockedIn()) {
					e.clockOut();
					return "Sucessfully clocked out.";
				} else {
					e.clockIn();
					return "Successfully clocked in.";
				}
			}
		}
		return "Give me a better ID.";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Employee e : employees) {
			sb.append(e.toString() + "\n");
		}
		return sb.toString();
	}

	@Override
	public void Tui(Scanner s) {
		String userInterface = Tui.createInterface("View all employees", "Add employee", "Remove employee",
				"Save employees to file", "Read employees from file", "Return to main menu");
		int userInput = 0;
		while (true) {
			System.out.println(userInterface);
			userInput = s.nextInt();
			switch (userInput) {
			case 1: {
				s.nextLine(); // flush
				System.out.println("****************************");
				if (employees.isEmpty()) {
					System.out.println("-No employees in list-");
				} else {
					System.out.println(this.toString());
				}
				System.out.println("****************************");
				break;
			}
			case 2: {
				s.nextLine(); // flush
				System.out.print("Enter new employee's name: ");
				String name = s.nextLine();
				this.addEmployee(name);
				System.out.println("\n" + name + " has been added to the list of employees.");
				break;
			}
			case 3: {
				s.nextLine(); // flush
				System.out.print("Enter ID of employee to be removed: ");
				int id = s.nextInt();
				this.removeEmployee(id);
				System.out.println("\nemployee with id " + id + " has been removed.");
				break;
			}
			case 4: {
				s.nextLine(); // flush
				System.out.print("Enter file name: ");
				String file = s.nextLine();
				try {
					this.saveToFile(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("\nFile saved.");
				break;
			}
			case 5: {
				s.nextLine();
				System.out.print("Enter file name: ");
				String file = s.nextLine();
				try {
					this.readFile(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
			case 6: {
				s.nextLine(); // flush
				return;
			}
			default: {
				System.out.println("We're sorry. We don't recognize that value.");
				break;
			}
			}
		}
	}

}
