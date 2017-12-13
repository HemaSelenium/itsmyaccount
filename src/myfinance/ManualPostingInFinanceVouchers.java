package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ManualPostingInFinanceVouchers extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	 boolean result=true;
	 protected static MethodsCalling method=new MethodsCalling();
	
	
	@Test(priority = 1)
	public void Scriptname() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_026",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Manual Posting In Finance Vouchers",true);
		helper1.SAP();
		
	}
	
@Test(priority = 2)
public void Login() throws InterruptedException {
	
	ldr.adminlogin();
	helper1.SAP();
	
}
	
	@Test(priority = 3,dataProvider="Manual",dependsOnMethods="Login")
	public void Manualposting(String amount) throws InterruptedException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AddmanualVoucher)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(method.PresentdateMinus5());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ManualVoucherGLtxt)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ManualVoucherGLtxt)).sendKeys(FinanceVariables.TravelGL);
	    helper1.SAP();
	    MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
	    MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(amount);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ExtendButton)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).sendKeys(FinanceVariables.narration);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveVoucher)).click();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("manualPostingFor300");
		Reporter.log("File Name :"+FinanceGlobalVariables.ScreenShotsFileName+"manualPostingFor300", true);
		helper1.SAP();
		Alert alert2 = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message2 = alert2.getText();
		Reporter.log(message2,true);
		helper1.SAP();
		String message3 = message2.split(" ")[1];
		System.out.println(message3);
		String message4=message3.substring(3,6);
		helper1.SAP();
		System.out.println("manual voucher no.: " + message4);
		helper1.SAP();
		alert2.accept();
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(message4);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		helper1.SAP();
		method.TakeScreenShot("manualentryfor300");
		Reporter.log("File Name :"+FinanceGlobalVariables.ScreenShotsFileName+"manualentryfor300", true);
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Export)).click();
		helper1.SAP();
 	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Exportpdf)).click();
 	  helper1.SAP();
 	 method.TakeScreenShot("manualPostingFor300pdf");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"manualPostingFor300pdf", true);
				helper1.SAP();
 	 
	}
	
	@Test(priority = 4,dependsOnMethods="Manualposting")
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		
		Reporter.log("Check for re-numbering of voucher manually through pdf file",true);
	}
		
	@DataProvider(name = "Manual")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ManualPostingOfFinanceVouchers);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("M2");
	    int rows = s.getRows();
	    int columns = s.getColumns();
	    String inputdata [][]= new String [rows-1][columns]; 
	    for (int i=1; i<rows; i++){
	        for (int j=0; j<columns; j++){
	            Cell cl = s.getCell(j,i);
	            inputdata [i-1][j] = cl.getContents();
	                  
	        }
	    }
	            return inputdata;
	}
}
