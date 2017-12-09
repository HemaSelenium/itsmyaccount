package myfinance;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import jxl.read.biff.BiffException;

public class BalancePaymentForFixedInvoice2000 extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
		
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	 protected static MethodsCalling method=new MethodsCalling();
	
	 @Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_019",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Balance Payment For Fixed Invoice 2000",true);
			helper1.SAP();
		}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
		
	}
	@Test(priority = 3,dependsOnMethods="Login")
	public void balancepayment() throws InterruptedException, BiffException, IOException {
		help2.PaymentForTwoVouchers();
		helper1.SAP();
		}

	@Test(priority = 4,dependsOnMethods="balancepayment")
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		Reporter.log("Member report should be checked manually for CLG references",true);
	}
	

}
