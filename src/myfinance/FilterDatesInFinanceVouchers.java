package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;




public class FilterDatesInFinanceVouchers extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	protected static FinanceVariables fin=new FinanceVariables();
	 protected static MethodsCalling method=new MethodsCalling();
	 
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_036",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Filter Dates In Finance Vouchers",true);
		ldr.adminlogin();
		helper1.SAP();
		
	}
	@Test(priority = 2)
	public void period() throws InterruptedException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Filter)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.NextFinancialtoYearMinus1month());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinFilterGo)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Filter)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.NextFinancialtoYear1());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinFilterGo)).click();
		helper1.SAP();
		 method.TakeScreenShotOfWindowPopUp("FilterDatesInFinanceVouchers");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FilterDatesInFinanceVouchers", true);
			helper1.SAP();
		
		
		
		
		
		
}
}
