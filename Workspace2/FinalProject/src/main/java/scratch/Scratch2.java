package scratch;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Scratch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		double val=100.1101;
//		System.out.println((val*100)%1==0.0);
		
		//not Lenient by default
//		LocalDate dob=LocalDate.parse("2000-20-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		System.out.println(dob);
		
		try {
			LocalDate dob=LocalDate.parse("2000-30-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.println("Date object is "+dob);
		}catch (DateTimeParseException e) {
			System.out.println("error");
		}		
		
//		LocalDate curr=LocalDate.now();
//		System.out.println("curr: "+curr);
		
		
		
		
	}

}
