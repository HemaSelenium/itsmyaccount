package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
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

public class FixedMaintainanceInvoiceGenerationwithExcelUpload extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
		InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	String splitmessage=null;
	String dateid = "ReversalDate";
	String splitmessage1;
	
	@Test(priority = 1)
	public void ScriptName() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_013",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Fixed Invoice Generation excel upload",true);
		helper1.SAP();
	}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority=3,dataProvider="FixedInvoice",dependsOnMethods="Login")
	public void FixedInvoiceGenerationWithDates(String amount,String narration)  throws BiffException, InterruptedException, IOException, HeadlessException, AWTException{
		splitmessage = help1.GenerateFixedInvoiceno1(amount, narration) ;
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
			
	}
	
	@Test(priority = 4,dependsOnMethods="FixedInvoiceGenerationWithDates")
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GeneratedInvoiceNo03);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("Invoice", 0);
		
		Label sheetcontent1 = new Label(0,0,splitmessage1);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}
	
	@Test(priority = 5,dependsOnMethods="writeVoucherno")
	public void ManualChecking() throws InterruptedException {
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		Reporter.log("Generate Fixed invoice manually by uploading excel file",true);
		helper1.SAP();

	}
	
	@DataProvider(name = "FixedInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ownwerbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("FixedInvoice2");
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
