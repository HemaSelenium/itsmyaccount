package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class VariableInvoiceGenerationWithExcelUpload extends TestBase{
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
		String voucherno2;
		 String choose="yes";
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	protected static FinanceVariables fin=new FinanceVariables();
	
	@Test(priority = 1)
	public void ScriptName() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_021",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: Variable InvoiceGeneration With ExcelUpload",true);
		helper1.SAP();
		}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority = 3,dependsOnMethods="Login")
	public void Tax() throws BiffException, InterruptedException, IOException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdminProfile)).click();
		helper1.SAP();
		
		WebElement checkbox = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.TaxRadioButtonInAdminProfile));
		String selectcheckbox = "yes";
		if (selectcheckbox.equals(choose)) {
			if (checkbox.isSelected() == true) {
				checkbox.click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveButtonInAdmin)).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				alert.accept();
				helper1.SAP();
				ldr.logout();
				

			} else {
				helper1.SAP();
				ldr.logout();
			}
		} 
		
		
	}
		
	
	
	@Test(priority = 4,dependsOnMethods="Tax")
	public void log() throws BiffException, InterruptedException, IOException{
		ldr.adminlogin();
		helper1.SAP();
	}
	@Test(priority = 5,dataProvider="VariableInvoice",dependsOnMethods="Login")
	public void Variable(String amount)
			throws InterruptedException, IOException, BiffException, HeadlessException, AWTException {
		voucherno2=help1.GenerateVariableInvoice1(amount);
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
	}

	@Test(priority = 6)
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.SeleniumVariables6);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("voucher1", 0);
		
		Label sheetcontent1 = new Label(0,0,voucherno2);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}
	
	
	@Test(priority = 7)
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		Reporter.log("Generate Fixed invoice manually by uploading excel file",true);
		
	}
	
	@DataProvider(name = "VariableInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.VariableInvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("Variable1");
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
