package dashboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Date {
	
	public void CurrentDate(){

Calendar calendar = Calendar.getInstance();
Date today = new Date();

calendar.add(Calendar.DAY_OF_YEAR, 1);
Date tomorrow = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

String todayAsString = dateFormat.format(today);
String tomorrowAsString = dateFormat.format(tomorrow);

System.out.println(todayAsString);
System.out.println(tomorrowAsString);
	        
}
}
