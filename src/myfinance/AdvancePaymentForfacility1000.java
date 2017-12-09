package myfinance;


	
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.TestBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import myfinance.BookingFacilityHelper;
	import myfinance.BookingFacilityhelpDEMO10;
	import myfinance.FinancialVouchersHelp;
	import myfinance.logindetails;

	public class AdvancePaymentForfacility1000 extends TestBase {
		//WebDriver driver = new FirefoxDriver();
		logindetails ldr = new logindetails();
		public String advancevoucherno2=null;
		
		BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
		FinancialVouchersHelp help2 = new FinancialVouchersHelp();
	
		
		@Test(priority = 1)
		public void ScriptName() {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_007",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Advance payment for Facility",true);
		}

		
		@Test(priority = 2)
		public void Login() throws InterruptedException {
			ldr.adminlogin();
			helper1.SAP();
			
			
		}
		
		@Test(priority = 3,dataProvider = "Advance",dependsOnMethods="Login")
		public void advance(String amount) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
			advancevoucherno2=help2.AdvancePaymentForFacility(amount);
			System.out.println(advancevoucherno2);
			helper1.SAP();
		}
		
		@Test(priority = 4,dependsOnMethods="advance")
		public void writeVoucherno()
				throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
			
			FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GettingAdvancePaymentReferenceForFacility);
			WritableWorkbook wb = Workbook.createWorkbook(file);
			WritableSheet sheet = wb.createSheet("Advance1", 0);
			
			Label sheetcontent1 = new Label(0,0,advancevoucherno2);
		
			sheet.addCell(sheetcontent1);
			wb.write();
			wb.close();
		}
		
		@Test(priority = 5,dependsOnMethods="writeVoucherno")
		public void ManualChecking() {
			Reporter.log("Items to be checked Manually");
			Reporter.log("----------------------------");
			Reporter.log("SMS Status");
			Reporter.log("Email Status");
			Reporter.log("Soft copy in Email");
			Reporter.log("Check DayBookEntry");
			Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports");

		}
		
		
		@DataProvider(name = "Advance")
		public Object[][] readexcel2() throws IOException, BiffException {
			File fs = new File(FinanceCommon.FinanceGlobalVariables.Advance);
			Workbook ws = Workbook.getWorkbook(fs);
			Sheet s = ws.getSheet("Facility");
			int rows = s.getRows();
			int columns = s.getColumns();
			String inputdata[][] = new String[rows - 1][columns];
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					Cell cl = s.getCell(j, i);
					inputdata[i - 1][j] = cl.getContents();
				}
			}
			return inputdata;
		}

		

	}
