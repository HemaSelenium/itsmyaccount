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

public class PartialAndFullPaymentFor2Invoices extends TestBase {

	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	String splitmessage;
	
	@Test(priority = 1)
	public void ScriptName() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_024",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Partial And Full Payment For 2Invoices",true);
		helper1.SAP();
		Reporter.log("--------------------------------------",true);
		
	}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority = 3)
	public void partial() throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		help2.PaymentInstep23D();
		helper1.SAP();
		Reporter.log("--------------------------------------",true);
		
	}
	
	@Test(priority = 4)
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		
		
	}
}
