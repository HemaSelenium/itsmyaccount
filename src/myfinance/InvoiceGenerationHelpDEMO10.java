package myfinance;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InvoiceGenerationHelpDEMO10 extends InvoiceGenerationHelper {
	
	
	
	public void setDate(WebDriver driver,String id,int year,int month,int day) throws InterruptedException{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date datespecified = c.getTime();
		driver.findElement(By.id(id)).clear();
		Thread.sleep(2000);
		driver.findElement(By.id(id)).sendKeys(df.format(datespecified));
		Thread.sleep(2000);
	}
	
	public void SelectTax(WebDriver driver,String choose) throws InterruptedException{
		 WebElement checkbox = driver.findElement(By.cssSelector("#CH1"));
	  	  String selectcheckbox = "yes";
	  	  if(selectcheckbox.equals(choose)){
	  	  if(checkbox.isSelected() == true){
	  		  System.out.println("Tax is Selected");
	  		      		  
	  	  }
	  	  else{
	  		Thread.sleep(2000);
	  		  checkbox.click();
	  			Thread.sleep(2000);
	  			
	  	  }
	  	  }
	  	  else{
	  		 if(checkbox.isSelected() == true){
	  			Thread.sleep(2000);
	  			 checkbox.click();
	  			Thread.sleep(2000);
	  			 }
	  		 else{
	  			 System.out.println("Tax not selected");
	  		 }
	  	  }
	
		
	
	}

	/*public void SelectTaxInProfile(WebDriver driver,String checkboxselect) throws InterruptedException, BiffException, IOException{
		Thread.sleep(2000);
		String select = "yes";
		if(checkboxselect.equals(select)){
		driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/span/a")).click();
		Thread.sleep(4000);
	WebElement checkbox = driver.findElement(By.id("ServiceTax"));
	if(!checkbox.isSelected()){
		checkbox.click();
		Thread.sleep(2000);
		driver.findElement(By.id("ServiceTaxPercent")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		ldr.logout(driver);
		}
	else
	{
		ldr.logout(driver);
	}
	}
	}*/

}
