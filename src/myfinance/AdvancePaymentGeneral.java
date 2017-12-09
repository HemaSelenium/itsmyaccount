package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
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

public class AdvancePaymentGeneral extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	String advancevoucherno3;
	
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();

	@Test(priority = 1)
	public void ScriptName() {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_008",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  General Advance payment",true);
	}


	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
		
	}

	@Test(priority = 3,dataProvider = "Advance",dependsOnMethods="Login")
	public void advance(String amount) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		advancevoucherno3=help2.AdvancePaymentForStep12(amount);
		System.out.println(advancevoucherno3);
		helper1.SAP();
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
	@DataProvider(name = "Advance")
	public Object[][] readexcel2() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.Advance);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("General");
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
