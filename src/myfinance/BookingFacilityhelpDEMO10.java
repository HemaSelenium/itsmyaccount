package myfinance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public  class BookingFacilityhelpDEMO10 extends BookingFacilityHelper{
	
		
	public void DueDate(WebDriver driver,String choose,String days){
		int Choose = Integer.parseInt(choose);
		Select duedate =new Select(driver.findElement(By.id("TypeOfDueDate")));
		if (Choose == 0){
			System.out.println("Due Date is End Of Month");
		}
		else{
		duedate.selectByIndex(Choose);
		driver.findElement(By.id("DueDate")).sendKeys(days);
		}
	}
	
	public String ToVerifyGeneratedVoucherno(WebDriver driver) throws InterruptedException, IOException {
		driver.findElement(By.xpath(".//*[@id='503']/div/img")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/table/tbody/tr/td[3]/div/a/i"))
				.click();// voucher type
		Thread.sleep(4000);
		driver.findElement(By.linkText("Facility Booking")).click();
		Thread.sleep(4000);
		String FIGvoucherno = driver.findElement(By.xpath(".//*[@id='1']/td[6]")).getText();
		String duedate = driver.findElement(By.xpath(".//*[@id='1']/td[11]")).getText();
		String Voucherno = driver.findElement(By.xpath(".//*[@id='1']/td[3]")).getText();
		System.out.println("4)Voucher No: " + Voucherno );
		System.out.println("5)Invoice Date: "+ driver.findElement(By.xpath(".//*[@id='1']/td[4]")).getText());
		System.out.println("6)Billing Date: "+ driver.findElement(By.xpath(".//*[@id='1']/td[15]")).getText());
		System.out.println("7)Duedate " + duedate);
		System.out.println("8)Facility Booking Amount: " + driver.findElement(By.xpath(".//*[@id='1']/td[7]")).getText());
		System.out.println("9)Facility booking Document No: " + FIGvoucherno);
		String clearedreference = driver.findElement(By.xpath(".//*[@id='1']/td[12]")).getText();
		if (clearedreference != null){
		System.out.println("10)By Clearing Voucher no.s:  " + clearedreference);
		}
		else {
			System.out.println("10)There are no Clearing Vouchers");
		}
		System.out.println("Files Stored in (Path Name)");
		System.out.println("---------------------------");
		File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		String path1= "C://Users//IMA//FinanceScreenshots//Screenshots.bmp" + screenshot1.getName();
		Thread.sleep(2000);
		System.out.println("11)For Line item Colour indicator in Fin voucher listing for Doc No: " + FIGvoucherno + path1);
		Thread.sleep(2000);
		FileUtils.copyFile(screenshot1, new File(path1));
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='1']/td[3]"));
		Actions action = new Actions(driver).doubleClick(element);
		action.build().perform();
		Thread.sleep(2000);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		String path= "C://Users//IMA//FinanceScreenshots//Screenshots.bmp" + screenshot.getName();
		Thread.sleep(2000);
		System.out.println("12)For Debit And Credit Entry :  " +  path);
		Thread.sleep(2000);
		FileUtils.copyFile(screenshot, new File(path));
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		return FIGvoucherno;
			}
	
	
}

