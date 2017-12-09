package myfinance;



import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.TestBase;


public class ReversalFunctionTestingSimulationstep10 extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_006",true);
		Reporter.log("--------------------------------------",true);
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority = 2)
	public void simulate() throws InterruptedException, IOException{
		help1.simulatestep10();
		helper1.SAP();
		
	}
	

}
