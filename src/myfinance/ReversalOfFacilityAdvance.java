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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReversalOfFacilityAdvance extends TestBase{
	
	logindetails ldr = new logindetails();
	
	
	
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();
		
	@Test(priority = 1)
	public void ScriptName() {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_011",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Reversal of Facility Advance",true);
	}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();	
	}
	
	@Test(priority = 3,dataProvider = "Payment",dependsOnMethods="Login")
	public void advance(String voucherno2 ) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		help2.ReversalOfFacilityadvance();
		Thread.sleep(7000);
		WebElement reversaltable = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ReverseAdvanceTable));
		helper1.SAP();
		int rowcount = reversaltable.findElements(By.tagName(FinanceVariables.TableRowId)).size();
		helper1.SAP();
		loop1: for (int i = 1; i < rowcount; i++) {
			String rowID = i + "";
			
			List<WebElement> rows1 = reversaltable.findElements(By.id(rowID));
			Thread.sleep(5000);
			String rowdata = rows1.get(0).findElements(By.tagName(FinanceVariables.TablecolumnId)).get(6).getText();
			if (rowdata.equals(voucherno2)) {
				System.out.println(123);
				System.out.println(voucherno2);
				rows1.get(0).findElements(By.tagName(FinanceVariables.TablecolumnId)).get(6).click();
				MethodsCalling.driver.findElement(By.id(FinanceVariables.ReverseReason)).sendKeys(FinanceVariables.Reason);
				MethodsCalling.driver.findElement(By.id(FinanceVariables.ReverseButton)).click();
				
       			method.TakeScreenShot("ReverseAdvancefacility");
       			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"ReverseAdvancefacility", true);
       			helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				String message = alert.getText();
				 String advancevoucherno = message.split(" ")[3];
				Reporter.log("Reverse advance voucher no: " + advancevoucherno,true);
				alert.accept();
				break loop1;
		
	}

		}
	}

	@Test(priority = 4,dependsOnMethods="advance")
	public void ManualChecking() {
		Reporter.log("Items to be checked Manually");
		Reporter.log("----------------------------");
		Reporter.log("SMS Status");
		Reporter.log("Email Status");
		Reporter.log("Soft copy in Email");
		Reporter.log("Check DayBookEntry");
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports");

	}
		
		@DataProvider(name = "Payment")
		public Object[][] readexcel4() throws IOException, BiffException {
			File fs = new File(FinanceGlobalVariables.GettingAdvancePaymentReferenceForFacility);
			Workbook ws = Workbook.getWorkbook(fs);
			Sheet s = ws.getSheet("Advance1");
			int rows = s.getRows();
			int columns = s.getColumns();
			String inputdata[][] = new String[rows][columns];
			
					Cell cl = s.getCell(0, 0);
					inputdata[0][0] = cl.getContents();
			
			return inputdata;
		}
}
