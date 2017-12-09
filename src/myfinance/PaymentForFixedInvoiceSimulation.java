package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.TestBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PaymentForFixedInvoiceSimulation extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
		FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	
	
	@Test(priority = 1)
	public void ScriptName() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_015",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Payment for Fixed Invoice Simulation",true);
		ldr.adminlogin();
		helper1.SAP();
	}

	
	
	@Test(priority =2,dataProvider="FixedInvoice")
	public void payment(String amount) throws BiffException, InterruptedException, IOException, HeadlessException, AWTException
			{
		
		help2.payment(amount);
		helper1.SAP();
		
		
	}
	
	@DataProvider(name = "FixedInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ownwerbasefixedinvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("Simulation");
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
