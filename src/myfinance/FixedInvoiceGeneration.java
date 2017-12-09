package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
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
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FixedInvoiceGeneration extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
		InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	String splitmessage=null;
	
	String splitmessage1;
	
	@Test(priority = 1)
	public void ScriptName() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_002",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Fixed Invoice Generation For Owner BaseAmount",true);
		helper1.SAP();
	}

	

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority=3,dataProvider="FixedInvoice",dependsOnMethods="Login")
	public void FixedInvoiceGenerationWithDates(String amount,String narration)  throws BiffException, InterruptedException, IOException, HeadlessException, AWTException{
		splitmessage = help1.GenerateFixedInvoiceno(amount, narration) ;
		Thread.sleep(10000);
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		
		
	}
	
	@Test(priority = 4,dataProvider="TenantFixedInvoice",dependsOnMethods="FixedInvoiceGenerationWithDates")
	public void GenerateFixedInvoicenoForTenant(String amount, String narration) throws BiffException, InterruptedException, IOException, HeadlessException, AWTException{
		splitmessage1= help1.GenerateFixedInvoicenoForTenant(amount, narration);
		System.out.println(splitmessage1);
		helper1.SAP();
		
	}
	@Test(priority = 5, dataProvider = "toWriteVoucher",dependsOnMethods="GenerateFixedInvoicenoForTenant")
	public void writeVoucherno(String dateid)
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		
		help1.writeVoucherno(dateid,splitmessage);
		helper1.SAP();
	}
	
	@Test(priority = 6,dataProvider="negativeFixedInvoice",dependsOnMethods="writeVoucherno")
	public void GenerateFixedInvoicenoNegativeTestingwriteVoucherno(String amount, String narration)
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException, HeadlessException, AWTException {
		helper1.SAP();
		help1.GenerateFixedInvoicenoNegativeTesting(amount, narration);
		helper1.SAP();
	}
	
	
	
	
	@Test(priority = 7,dataProvider="ReverseInvoice",dependsOnMethods="GenerateFixedInvoicenoNegativeTestingwriteVoucherno")
	public void ReverseInvoice(String dateid, String splitmessage1 ) throws BiffException, InterruptedException, IOException, HeadlessException, AWTException{
		
		help1.ReverseInvoice(splitmessage1);
		helper1.SAP();
		helper1.SAP();
		
	}
	

	@Test(priority = 8,dependsOnMethods="ReverseInvoice")
	public void ManualChecking() throws InterruptedException {
		Reporter.log("Items to be checked Manually");
		Reporter.log("----------------------------");
		Reporter.log("SMS Status");
		Reporter.log("Email Status");
		Reporter.log("Soft copy in Email");
		Reporter.log("Check DayBookEntry");
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports");
		helper1.SAP();

	}
	
	@DataProvider(name = "FixedInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ownwerbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("FixedInvoice");
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
	
	
	@DataProvider(name = "negativeFixedInvoice")
	public  Object [][] readexcel2()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.negativeownwerbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("FixedInvoice");
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
	@DataProvider(name = "TenantFixedInvoice")
	public  Object [][] readexcel3()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.Tenantbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("FixedInvoice");
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
	
	@DataProvider(name = "toWriteVoucher")
	public Object[][] readexcel4() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.FacilityBookingFor1000);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Payment2");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i][j] = cl.getContents();

			}
		}
		return inputdata;
	}
	
	
	@DataProvider(name = "ReverseInvoice")
	public  Object [][] readexcel5()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.GeneratedInvoiceNo03);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("PaymentForGenInvoice");
	    int rows = s.getRows();
	    int columns = s.getColumns();
	    String inputdata [][]= new String [rows][columns]; 
	    for (int i=0; i<rows; i++){
	        for (int j=0; j<columns; j++){
	            Cell cl = s.getCell(j,i);
	            inputdata [i][j] = cl.getContents();
	                  
	        }
	    }
	            return inputdata;
	}
		}
