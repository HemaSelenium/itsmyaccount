package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;

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

public class WaiverForFixedInvoice2000 extends TestBase {
	
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	
	protected static FinanceVariables fin=new FinanceVariables();
	
	 @Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_018",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Waiver For Fixed Invoice 2000",true);
			helper1.SAP();
			Reporter.log("--------------------------------------",true);
		}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority = 3,dataProvider = "Partial",dependsOnMethods="Login")
	public void waiver(String waveofvoucher ) throws InterruptedException, HeadlessException, IOException, AWTException {
		help2.Waiver(waveofvoucher);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		Thread.sleep(4000);
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(waveofvoucher);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); 
		helper1.SAP();																					
		}
	
	@Test(priority = 4,dependsOnMethods="waiver")
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
	
	@DataProvider(name = "Partial")
	public Object[][] readexcel4() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.GettingHeaderreferenceforFixedInvoice2000);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Payment");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows][columns];
		System.out.println(rows);
		System.out.println(columns);
		
				Cell cl = s.getCell(0, 0);
				inputdata[0][0] = cl.getContents();
		
		return inputdata;
	}

	
}
