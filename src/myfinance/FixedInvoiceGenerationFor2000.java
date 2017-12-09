package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FixedInvoiceGenerationFor2000 extends TestBase {
String splitmessage1;
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	
	 protected static MethodsCalling method=new MethodsCalling();
	 
	 
	 @Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_016",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Fixed Invoice Generationfor 2000",true);
			helper1.SAP();	
		}
	
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		
		ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority = 3,dependsOnMethods="Login")
	public void tax() throws InterruptedException {
		
		driver.findElement(By.xpath(FinanceVariables.AdminProfile)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.TaxRadioButtonInAdminProfile)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.SaveButtonInAdmin)).click();
		helper1.SAP();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.LogOut)).click();
		helper1.SAP();	
		ldr.adminlogin();
		helper1.SAP();
		
	}
	@Test(priority = 4,dataProvider="FixedInvoice",dependsOnMethods="tax")
	public void GenerateFixedInvoice(String amount) throws InterruptedException, IOException, HeadlessException, AWTException {
		splitmessage1=help1.generateFixedInvoice(amount);
		helper1.SAP();	
	}
	@Test(priority = 5,dependsOnMethods="GenerateFixedInvoice")
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		
		
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GettingHeaderreferenceforFixedInvoice2000);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("Payment", 0);
		
		Label sheetcontent1 = new Label(0,0,splitmessage1);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}
	
	@Test(priority = 6,dependsOnMethods="writeVoucherno")
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
	
	@DataProvider(name = "FixedInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ownwerbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("FixedInvoice3");
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
