package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class FixedInvoiceWithTax extends TestBase {

	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	
	 protected static FinanceVariables fin=new FinanceVariables();
	 protected static MethodsCalling method=new MethodsCalling();
	 String splitmessage1;

		@Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_014",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Fixed Invoice Generation with tax",true);
			helper1.SAP();
		}
	
	@Test(priority = 2)
	public void Login() throws InterruptedException {
			ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority = 3,dependsOnMethods="Login")
	public void Tax() throws BiffException, InterruptedException, IOException{
		help1.SelectTaxInProfile();
		helper1.SAP();
	}
	
	@Test(priority = 4,dependsOnMethods="Tax")
	public void log() throws BiffException, InterruptedException, IOException{
		ldr.logout();
		
		helper1.SAP();
		ldr.adminlogin();
		helper1.SAP();
	}
	@Test(priority = 5,dataProvider="FixedInvoice",dependsOnMethods="log")
	public void GenerateFixedInvoiceWithTax(String amount) throws InterruptedException, IOException, BiffException, HeadlessException, AWTException{
		splitmessage1=help1.GenerateFixedInvoiceWithTax(amount);
		helper1.SAP();
		driver.navigate().refresh();
		helper1.SAP();	
	}
	@Test(priority = 6,dependsOnMethods="GenerateFixedInvoiceWithTax")
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.InvoiceTax);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("voucher", 0);
		
		Label sheetcontent1 = new Label(0,0,splitmessage1);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}
	
	@Test(priority = 7,dataProvider = "advance",dependsOnMethods="writeVoucherno")
	public void CheckadvanceClearance(String advref) throws InterruptedException{
		driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
	    helper1.SAP();
		driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(advref);
		helper1.SAP();
		driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
	    helper1.SAP();
	}
	
	@Test(priority = 8,dependsOnMethods="CheckadvanceClearance")
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
	
	@DataProvider(name = "advance")
	public Object[][] readexcel4() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.GettingHeaderReferenceForMaintainanceAdvance);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Advance2");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows][columns];
		System.out.println(rows);
		System.out.println(columns);
		
				Cell cl = s.getCell(0, 0);
				inputdata[0][0] = cl.getContents();
		
		return inputdata;
	}
	
	@DataProvider(name = "FixedInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ownwerbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("Tax");
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
