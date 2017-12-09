package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.TestBase;



public class Step7simulationTocheckForAdvancePayments extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_005",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Simulation To check For Advance Payments",true);
		ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority = 2)
	public void AdvancepaymentSimulation() throws InterruptedException, IOException, HeadlessException, AWTException {
		help2.AdvanceSimulationscenario7();
	Reporter.log("There is due amount for maintainance unable to pay advance", true);
		helper1.SAP();
		
		
	}
	
	

}
