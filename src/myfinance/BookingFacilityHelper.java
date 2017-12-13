package myfinance;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class BookingFacilityHelper extends TestBase {
	public String FIGvoucherno = null;
	public String FIGvoucherno1 = null;
	
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	String fromdate = "FromDate";
	String todate = "ToDate";
	protected static FinanceVariables fin=new FinanceVariables();
	protected static MethodsCalling method=new MethodsCalling();
	public void Addfacility(String facilityname,String contactperson,String contactnumber, String hour,String amount,String days) throws InterruptedException, BiffException, IOException {
	
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.MyFacilities)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.AddFacility)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityNameId)).sendKeys(facilityname);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.ContactPersonId)).sendKeys(contactperson);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.ContactNumberId)).sendKeys(contactnumber);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.AllowForBookingId)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.paidId)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.MinimumHoursId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.MinimumHoursId)).sendKeys(hour);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.HourlyAmountId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.HourlyAmountId)).sendKeys(amount);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CalculationType)).sendKeys(FinanceVariables.CalculationType1);	
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CalculationType)).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(days);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilitySave)).click();
			Thread.sleep(4000);
			/*Alert simple=MethodsCalling.driver.switchTo().alert();
			simple.accept();*/
			WebElement verification = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ManageFacilityHeadingpath));
			Thread.sleep(4000);
			String value = verification.getText();
			Thread.sleep(4000);
			Assert.assertEquals(value, FinanceVariables.ManageFacilityHeading);
			Thread.sleep(4000);

		}
	
	
	
	public void Addfacility1(String facilityname,String contactperson,String contactnumber, String hour,String amount) throws InterruptedException, BiffException, IOException {
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.MyFacilities)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.AddFacility)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityNameId)).sendKeys(facilityname);
			Thread.sleep(10000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.ContactPersonId)).sendKeys(contactperson);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.ContactNumberId)).sendKeys(contactnumber);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.AllowForBookingId)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.paidId)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.MinimumHoursId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.MinimumHoursId)).sendKeys(hour);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.HourlyAmountId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.HourlyAmountId)).sendKeys(amount);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CalculationType)).sendKeys(FinanceVariables.DueDateType1);
			//DueDate(MethodsCalling.driver,choose,days1);
			Thread.sleep(8000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CalculationType)).sendKeys(Keys.ENTER);
			//DueDate(MethodsCalling.driver,choose,days1);
			Thread.sleep(8000);
			
			
			System.out.println("Booked Facility Name: " + facilityname);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilitySave)).click();
			Thread.sleep(4000);
			/*Alert simple=MethodsCalling.driver.switchTo().alert();
			simple.accept();*/
			WebElement verification = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ManageFacilityHeadingpath));
			Thread.sleep(4000);
			String value = verification.getText();
			Thread.sleep(4000);
			Assert.assertEquals(value, FinanceVariables.ManageFacilityHeading);
			Thread.sleep(4000);

		}
	public void userlogin(String URL, String username, String password, String Before) throws InterruptedException, IOException {
	}

	public void DueDate(String choose, String days) {
		System.out.println("Due date has not given");
	}

	public void dropdown() throws InterruptedException {
		WebElement select = MethodsCalling.driver.findElement(By.id("rows"));
		Thread.sleep(2000);
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if ("40".equals(option.getText())) {
				option.click();
				Thread.sleep(3000);
			}
		}
	}

	public void BookFacility1(String Facilityname, String Fromdateid,String FromTime, String Todateid,
			String ToTime,String Description) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
			MethodsCalling.driver.navigate().refresh();
			Thread.sleep(2000);
			
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click(); // search
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilityGridSearchType)).click();
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(Facilityname);
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
		    Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilityBookOrCancel)).click();
			Thread.sleep(5000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.AddFacility)).click();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).sendKeys(method.Presentdateplus1());
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityFromTimeId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityFromTimeId)).sendKeys(FromTime);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.Presentdateplus1());
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityToTimeId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityToTimeId)).sendKeys(ToTime);
			Thread.sleep(2000);
			ldr.blockFlat();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityDescriptionId)).sendKeys(Description);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilityFinalBook)).submit();
			Thread.sleep(4000);
			method.TakeScreenShotOfWindowPopUp("OtherFacilityBooked");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"OtherFacilityBooked", true);
			helper1.SAP();
			WebDriverWait wait = new WebDriverWait(MethodsCalling.driver,50);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert2 = MethodsCalling.driver.switchTo().alert();
			Thread.sleep(4000);
			alert2.accept();
			Thread.sleep(4000);
			/*Alert simple=MethodsCalling.driver.switchTo().alert();
			String simple1=MethodsCalling.driver.switchTo().alert().getText();
			Thread.sleep(2000);
			Reporter.log(simple1, true);
			Thread.sleep(2000);
			simple.accept();
			Thread.sleep(2000);*/
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
			/*WebElement header = MethodsCalling.driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[1]/h3"));
			String value = header.getText();
			Assert.assertEquals(value, "Facility Availability");*/
			Thread.sleep(2000);
			
		}
	public void BookFacility(String Facilityname, String Fromdateid,String FromTime, String Todateid,
			String ToTime,String Description) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
			MethodsCalling.driver.navigate().refresh();
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilitySearchGridID)).click(); // search
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilityGridSearchType)).click();
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(Facilityname);
			Thread.sleep(2000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																							// button
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilityBookOrCancel)).click();
			Thread.sleep(5000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityBookID)).click();
			Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).sendKeys(method.Presentdateplus1());
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityFromTimeId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityFromTimeId)).sendKeys(FromTime);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.Presentdateplus1());
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityToTimeId)).clear();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityToTimeId)).sendKeys(ToTime);
			Thread.sleep(2000);
			ldr.blockFlat();
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityDescriptionId)).sendKeys(Description);
			Thread.sleep(4000);
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilityFinalBook)).submit();
			Thread.sleep(5000);
			method.TakeScreenShotOfWindowPopUp("Facilitybooked");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"Facilitybooked", true);
			helper1.SAP();
			WebDriverWait wait = new WebDriverWait(MethodsCalling.driver,50);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert2 = MethodsCalling.driver.switchTo().alert();
			String message=alert2.getText();
			Thread.sleep(5000);
			Reporter.log(message,true);
			Thread.sleep(5000);
			alert2.accept();
			Thread.sleep(4000);
			MethodsCalling.driver.navigate().refresh();
			Thread.sleep(4000);
			
			
		}
	
	
	public void setDate(String id) throws InterruptedException{
		DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.DATE,1);
		dt = cl.getTime();
		MethodsCalling.driver.findElement(By.id(id)).clear();
		Thread.sleep(3000);
		String mydate = df.format(dt);
		MethodsCalling.driver.findElement(By.id(id)).sendKeys(mydate);
		Thread.sleep(4000);
		
		/*Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date datespecified = c.getTime();
		Thread.sleep(3000);
		MethodsCalling.driver.findElement(By.id(id)).clear();
		Thread.sleep(3000);
		MethodsCalling.driver.findElement(By.id(id)).sendKeys(df.format(datespecified));
		Thread.sleep(2000);*/
	}

	
	public void ScreenShots(String voucherno) throws InterruptedException, IOException{
	}
	

	public String ToGetGeneratedVoucherno() throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		Thread.sleep(9000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		Thread.sleep(8000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		Thread.sleep(3000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		Thread.sleep(2000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchCompare)).click();
		Thread.sleep(2000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(FinanceVariables.FacilitySearchKeyword);
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();
		Thread.sleep(20000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		Thread.sleep(3000);
		method.TakeScreenShotOfWindowPopUp("FacilityFound");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FacilityFound", true);
		helper1.SAP();
	 FIGvoucherno1 = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.HeaderReferenceTabInFinanceVouchers)).getText();
		Thread.sleep(4000);
		String duedate = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DuedateTabInFinanceVouchers)).getText();
		Thread.sleep(4000);
		
		Reporter.log("Invoice Date:  "+ MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherdateTabInFinanceVouchers)).getText(),true);
		Thread.sleep(4000);
		Reporter.log("Billing Date:  "+ MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CreatedOndateTabInFinanceVouchers)).getText(),true);
		Thread.sleep(4000);
		Reporter.log("Duedate  " + duedate,true);
		Thread.sleep(4000);
		Reporter.log("Facility Booking Amount:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
		
		Thread.sleep(4000);
		Reporter.log("Facility booking Document No:  " + FIGvoucherno1,true);
		
		Thread.sleep(4000);
		MethodsCalling.driver.navigate().refresh();
		return FIGvoucherno1;
	}
	
	
    
	public String ToVerifyGeneratedVouchernoforscenario4() throws InterruptedException {
		MethodsCalling.driver.navigate().to("https://test-itsmyaccount.azurewebsites.net/Voucher");
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(
				By.xpath("html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/table/tbody/tr/td[3]/div/a/i"))
				.click();// voucher type
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.linkText("Facility Booking")).click();
		Thread.sleep(4000);
		String FIGvoucherno = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[6]")).getText();
		System.out.println("Generated Facility Booked Voucherno : " + FIGvoucherno);
		String duedate = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[11]")).getText();
		System.out.println("Duedate  " + duedate);
		String clearedvouchers = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[12]")).getText();
		System.out.println("Facility booked adjusted with advance vouchers " + clearedvouchers);
		MethodsCalling.driver.navigate().refresh();
		return FIGvoucherno;
	}

	public void VerifyFacilityBookedForGivenDateandtoCancel( int day) throws InterruptedException {
		WebElement calendertable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='calendar']/div[2]"));
		Thread.sleep(4000);
		List<WebElement> cellrows = calendertable.findElements(By.cssSelector(".cal-row-fluid.cal-before-eventlist"));
		Thread.sleep(4000);
		for (int x = 1; x < 5; x++) {
			Thread.sleep(4000);
			List<WebElement> columns = cellrows.get(x).findElements(By.tagName("div"));
			Thread.sleep(4000);
			for (int i = 0; i <= 12; i++) {
				String givendate = columns.get(i).getText();
				Thread.sleep(4000);
				String number = Integer.toString(day);
				if (number.equals(givendate)) {
					columns.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
		}
	}

	public void VerifyFacilityBookedForGivenDate( int day) throws InterruptedException {
		WebElement calendertable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='calendar']/div[2]"));
		Thread.sleep(4000);
		List<WebElement> cellrows = calendertable.findElements(By.cssSelector(".cal-row-fluid.cal-before-eventlist"));
		Thread.sleep(4000);
		for (int x = 1; x < 5; x++) {
			Thread.sleep(4000);
			List<WebElement> columns = cellrows.get(x).findElements(By.tagName("div"));
			Thread.sleep(4000);
			for (int i = 0; i <= 12; i++) {
				String givendate = columns.get(i).getText();
				Thread.sleep(4000);
				String number = Integer.toString(day);
				if (number.equals(givendate)) {
					columns.get(i).click();
					Thread.sleep(2000);
					break;
				}
			}
		}
	}

public void MemberReports(String voucherno) throws InterruptedException{
	
	
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	Thread.sleep(12000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceReports)).click();
	Thread.sleep(8000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.MemberReports)).click();
	Thread.sleep(8000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
	Thread.sleep(4000);
	
	
	System.out.println("Found"+voucherno);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.MemberReportGridSearchTxtbox)).sendKeys(voucherno);
	Thread.sleep(6000);
	MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();
	Thread.sleep(6000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
	Thread.sleep(4000);
	
			

}
public String ToGetGeneratedVoucherno1() throws InterruptedException, BiffException, IOException {
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
	Thread.sleep(3000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
	Thread.sleep(2000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchCompare)).click();
	Thread.sleep(2000);
	MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys("FIG");
	Thread.sleep(2000);
	MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();
	Thread.sleep(20000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
	Thread.sleep(5000);
 FIGvoucherno = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.HeaderReferenceTabInFinanceVouchers)).getText();
	Thread.sleep(4000);
	String duedate = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DuedateTabInFinanceVouchers)).getText();
	Thread.sleep(4000);
	Reporter.log("Clearing References:  "+ MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ClearingReferenceTabInFinanceVouchers)).getText(),true);
	Thread.sleep(4000);
	Reporter.log("Booking Date:  "+ MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CreatedOndateTabInFinanceVouchers)).getText(),true);
	Thread.sleep(4000);
	Reporter.log("Duedate  " + duedate);
	Thread.sleep(4000);
	Reporter.log("Facility Booking Amount:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
	Thread.sleep(4000);
	Reporter.log("Facility booking Document No:  " + FIGvoucherno,true);
	Thread.sleep(4000);
	MethodsCalling.driver.navigate().refresh();
	return FIGvoucherno;
}
	

public void MemberReport() throws InterruptedException, BiffException, IOException {
	Thread.sleep(12000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	Thread.sleep(9000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceReports)).click();
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.MemberReports)).click();
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(".//*[@id='IsActive_OFF']")).click();
	Thread.sleep(3000);
	
	String CLGvoucherno1=MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[5]")).getText();
	Thread.sleep(12000);
	String CLGvoucherno2=MethodsCalling.driver.findElement(By.xpath(".//*[@id='2']/td[5]")).getText();
	 Thread.sleep(12000);
	String duedate = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[11]")).getText();
	Thread.sleep(12000);
	System.out.println("Clearing References1:  "+ CLGvoucherno1 +"is for amount" +MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[8]")).getText());
	Thread.sleep(12000);
	System.out.println("Clearing References2:  "+ CLGvoucherno2 +"is for amount" +MethodsCalling.driver.findElement(By.xpath(".//*[@id='2']/td[8]")).getText());
	Thread.sleep(12000);
	System.out.println("Booking Date:  "+ MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[3]")).getText());
	Thread.sleep(12000);
	System.out.println("Duedate  " + MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[7]")).getText());
	Thread.sleep(4000);
	MethodsCalling.driver.navigate().refresh();
	
}
public void Addfacility1(String facilityname,String contactperson,String contactnumber, String hour,String amount,String days) throws InterruptedException, BiffException, IOException {
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	Thread.sleep(4000);
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.MyFacilities)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.AddFacility)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityNameId)).sendKeys(facilityname);
		Thread.sleep(10000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.ContactPersonId)).sendKeys(contactperson);
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.ContactNumberId)).sendKeys(contactnumber);
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.AllowForBookingId)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.paidId)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.MinimumHoursId)).clear();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.MinimumHoursId)).sendKeys(hour);
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.HourlyAmountId)).clear();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.HourlyAmountId)).sendKeys(amount);
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CalculationType)).sendKeys(FinanceVariables.DueType2);
	Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CalculationType)).sendKeys(Keys.ENTER);
Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(days);
		Thread.sleep(4000);
		Reporter.log("Booked Facility Name: " + facilityname,true);
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FacilitySave)).click();
		Thread.sleep(4000);
		
		WebElement verification = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ManageFacilityHeadingpath));
		Thread.sleep(4000);
		String value = verification.getText();
		Thread.sleep(4000);
		Assert.assertEquals(value, FinanceVariables.ManageFacilityHeading);
		Thread.sleep(4000);

	}
}	

