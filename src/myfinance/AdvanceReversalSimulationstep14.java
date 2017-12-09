package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.TestBase;
import jxl.read.biff.BiffException;

public class AdvanceReversalSimulationstep14 extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_010",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Advance Reversal Simulation",true);
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority = 2)
	public void advance() throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		help2.AdvanceReversalsimulationstep14();
		helper1.SAP();
	}

}
