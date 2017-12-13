package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;


public class TrialBalance extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	protected static FinanceVariables fin=new FinanceVariables();
	 protected static MethodsCalling method=new MethodsCalling();
	 
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_033",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Trial Balance",true);
		ldr.adminlogin();
		helper1.SAP();
		
	}
	@Test(priority = 2)
	public void trial() throws InterruptedException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceReports)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.TrialBalance)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Filter)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.NextFinancialtoYearplus1month());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterGo)).click();
		helper1.SAP();
		Alert alert=MethodsCalling.driver.switchTo().alert();
		alert.accept();
		helper1.SAP();
        method.TakeScreenShot("TrialBalance");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"TrialBalance", true);
		helper1.SAP();
}
}