package FinanceCommon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

public class Startingmonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance(); 
		c.set(Calendar.DAY_OF_MONTH, 13); 
		 
		// DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	       //String startDate=df.format(c.getTime());
	       System.out.println(c.getTime());
		 
		// driver.findElement(By.xpath(".//*[@id='InvoiceDate']")).sendKeys(startDate);
			
	
	}

}
