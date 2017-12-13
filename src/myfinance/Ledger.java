package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;


public class Ledger extends TestBase  {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	protected static FinanceVariables fin=new FinanceVariables();
	 protected static MethodsCalling method=new MethodsCalling();
	 
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_035",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Ledger",true);
		ldr.adminlogin();
		helper1.SAP();
		
	}
	@Test(priority = 2)
	public void ledger() throws InterruptedException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceReports)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Ledger)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerGroupDropdown)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerGroupDropdown)).sendKeys(FinanceVariables.LedgerGroupname);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerAccountDropdown)).sendKeys(FinanceVariables.LedgerAccountName);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerGo)).click();
		helper1.SAP();
		JavascriptExecutor jse = (JavascriptExecutor)MethodsCalling.driver;
		 jse.executeScript("window.scrollBy(0,5500)", ""); //y value '800' can be altered
		    helper1.SAP();
		    jse.executeScript("window.scrollBy(0,-5500)", ""); //y value '800' can be altered
		    helper1.SAP();
		    method.TakeScreenShot("ledger");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"ledger", true);
			helper1.SAP();
		
		
		
		
		
		
		
		
		
		
}
}