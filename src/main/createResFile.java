import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class createResFile {
	
public void reservation() throws Exception {
	Scanner userinp = new Scanner(System.in);

	String time,firstName, lastName, groupNum, custoData; 
	
	System.out.println("Enter the time you like to reserve");
	time = userinp.nextLine();
	
	System.out.println("Enter your first name");
	firstName = userinp.nextLine();
	
	System.out.println("Enter your last name");
	lastName = userinp.nextLine();
	
	System.out.println("Enter the number of members in the group");
	groupNum = userinp.nextLine();
	
	custoData = ("Cusmtomer Name: " +firstName+ " " +lastName+" Time of Reservation: " +time+ " Size of Group: " +groupNum);
	
	BufferedWriter writer = new BufferedWriter(new FileWriter("Reservation.txt",true));
	
	writer.write(custoData);
	writer.newLine();
	writer.close();
	userinp.close();
	Main.main(null);
}
	
}