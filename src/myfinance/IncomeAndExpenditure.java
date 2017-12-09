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



public class IncomeAndExpenditure extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	protected static FinanceVariables fin=new FinanceVariables();
	 protected static MethodsCalling method=new MethodsCalling();
	 
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_034",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Income And Expenditure",true);
		ldr.adminlogin();
		helper1.SAP();
		
	}
	@Test(priority = 2)
	public void Income() throws InterruptedException, IOException, HeadlessException, AWTException {
		driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FinanceReports)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.IncomeandExpenditure)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.Filter)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).clear();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).sendKeys(method.PreviousFinancialYearfromDate());
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.PreviousFinancialYearToDate());
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FilterGo)).click();
		helper1.SAP();
		
        method.TakeScreenShotOfWindowPopUp("IncomeAndExpenditure");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"IncomeAndExpenditure", true);
		helper1.SAP();

}
}
