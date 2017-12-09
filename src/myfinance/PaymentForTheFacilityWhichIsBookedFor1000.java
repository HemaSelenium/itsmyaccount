package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PaymentForTheFacilityWhichIsBookedFor1000 extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();
		 protected static FinanceVariables fin=new FinanceVariables();
	String voucher;

	@Test(priority = 1)
	public void ScriptName() {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_004",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Payment For The Facility Which Is Booked For 1000",true);
	}

	

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
	}

	@Test(priority = 3, dataProvider = "Payment",dependsOnMethods="Login")
	public void PaymentForFacilityBooked(String voucher) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		help2.Payment();
		 helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.PaymentTable));
		List<WebElement> rows1 = paymenttable.findElements(By.tagName(FinanceVariables.TableRowId));
		/*System.out.println(123);*/
		int rowscount = rows1.size();
		for (rowscount = 1; rowscount < rows1.size(); rowscount++) {
			List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName(FinanceVariables.TablecolumnId));
			String rowvalue = columns1.get(1).getText();
			/*System.out.println(rowvalue);
			System.out.println(voucher);*/
			if (rowvalue.equals(voucher)) {
				/*System.out.println(voucher);*/
				Reporter.log("Paying amount for the voucher: " + voucher,true);
				//columns1.get(0).click();
				columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
				
				break;
			}
		}
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration)).sendKeys(Variables.Narrstion);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click();
		helper1.SAP();
		
		
		method.TakeScreenShotOfWindowPopUp("PaymentOfFacility1000");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"PaymentOfFacility1000", true);
		helper1.SAP();
		Alert alert = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message3 = alert.getText();
		helper1.SAP();
		
		String splitmessage = message3.split(" ")[1];
		helper1.SAP();
		Reporter.log("Generated Payment Receipt no: " + splitmessage,true);
		alert.dismiss();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(voucher);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																						// button
		helper1.SAP();
		Reporter.log("Voucher Date:" + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherdateTabInFinanceVouchers)).getText(),true);
		Reporter.log("Amount Cleared:" + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.TotalAmountClearedTabInFinVouchers)).getText(),true);
		String clearingvoucher = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ClearingReferenceTabInFinanceVouchers)).getText();
		if(clearingvoucher != null){
			Reporter.log("By Clearing Voucher no:  " + clearingvoucher,true);
				}
		else{
			System.out.println("There are no Clearing References");
		}
		Reporter.log("Files Stored in (Path Name)",true);
		Reporter.log("---------------------------",true);
		
		System.out.println("For Line item Colour indicator in Fin voucher listing for Doc No: " + voucher );
		helper1.SAP();
		
		
		method.TakeScreenShot("facilitypayment3");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"facilitypayment3", true);
		helper1.SAP();
		
		WebElement element = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[3]"));
		Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
		action.build().perform();
		helper1.SAP();
		
		
		method.TakeScreenShot("facilitypayment1");
		
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"facilitypayment1", true);
		helper1.SAP();
		
			
		}
	@Test(priority = 4,dependsOnMethods="PaymentForFacilityBooked")
	  public void ManualChecking(){
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true); 
		
	  }

	@DataProvider(name = "Payment")
	public Object[][] readexcel4() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.GettingFacilityHeaderReferenceof1000);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Payment");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows][columns];
		
		
				Cell cl = s.getCell(0, 0);
				inputdata[0][0] = cl.getContents();
		
		return inputdata;
	}

}
