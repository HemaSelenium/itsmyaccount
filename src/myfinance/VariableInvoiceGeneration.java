package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
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
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class VariableInvoiceGeneration extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
		String voucherno2;
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	protected static FinanceVariables fin=new FinanceVariables();
	
	@Test(priority = 1)
	public void ScriptName() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_003",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Variable Invoice Generation For Owner BaseAmount",true);
		helper1.SAP();
		Reporter.log("--------------------------------------",true);
		
	}
	

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
	}
	
	@Test(priority = 3,dataProvider="VariableInvoice",dependsOnMethods="Login")
	public void Variable(String amount)
			throws InterruptedException, IOException, BiffException, HeadlessException, AWTException {
		voucherno2=help1.GenerateVariableInvoice(amount);
		Reporter.log("--------------------------------------",true);
		helper1.SAP();
		//System.out.println(voucherno2);
		MethodsCalling.driver.navigate().refresh();
		Thread.sleep(8000);
	}

	@Test(priority = 4,dataProvider="NegativeInvoice",dependsOnMethods="Variable")
	public void Variablenegative(String amount)
			throws InterruptedException, IOException, BiffException, HeadlessException, AWTException {
		help1.GenerateVariableInvoicenegativeTesting(amount);
		Reporter.log("--------------------------------------",true);
		helper1.SAP();
	}
	@Test(priority = 5,dependsOnMethods="Variablenegative")
	public void PaymentForVariable()
			throws InterruptedException, IOException, BiffException, HeadlessException, AWTException {
		help1.paymentForVariable();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.PaymentTable));
		List<WebElement> rows1 = paymenttable.findElements(By.tagName(FinanceVariables.TableRowId));
		int rowscount = rows1.size();
		
		for (rowscount = 1; rowscount < rows1.size(); rowscount++) {
			List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName(FinanceVariables.TablecolumnId));
			String rowvalue = columns1.get(1).getText();
			
			if (rowvalue.equals(voucherno2)) {
				
				columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.payNarration)).sendKeys(FinanceVariables.PaymentNarration);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click();
				helper1.SAP();
				method.TakeScreenShotOfWindowPopUp("PaymentForVariableInvoice");
				Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"PaymentForVariableInvoice", true);
				helper1.SAP();
				Alert alert2 = MethodsCalling.driver.switchTo().alert();
				Thread.sleep(1000);
				String popup=MethodsCalling.driver.switchTo().alert().getText();
			    Thread.sleep(1000);
				Reporter.log(popup, true);
				Thread.sleep(1000);
				alert2.dismiss();
				Thread.sleep(1000);
				
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(voucherno2);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																						// button
		method.TakeScreenShot("VariableInvoicePaymentVoucher");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"VariableInvoicePaymentVoucher", true);
		helper1.SAP();
		helper1.SAP();
		Reporter.log("Payment Amount: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
		Reporter.log("Due Date:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DuedateTabInFinanceVouchers)).getText(),true);
		Reporter.log("Voucher no: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers)).getText(),true);
		Reporter.log("Clearing reference:" + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ClearingReferenceTabInFinanceVouchers)).getText(),true);
		Reporter.log("--------------------------------------",true);
		break;
		}
	}
}
	
	
	@Test(priority = 6,dependsOnMethods="PaymentForVariable")
	public void ManualChecking() throws InterruptedException {
		Reporter.log("Items to be checked Manually");
		Reporter.log("----------------------------");
		Reporter.log("SMS Status");
		Reporter.log("Email Status");
		Reporter.log("Soft copy in Email");
		Reporter.log("Check DayBookEntry");
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports");
		helper1.SAP();
    //MethodsCalling.driver.quit();
	}


@DataProvider(name = "VariableInvoice")
public  Object [][] readexcel1()  throws  IOException, BiffException  {
   File fs = new File(FinanceGlobalVariables.VariableInvoice);
    Workbook ws= Workbook.getWorkbook(fs);
    Sheet s = ws.getSheet("Variable");
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

@DataProvider(name = "NegativeInvoice")
public  Object [][] readexcel2()  throws  IOException, BiffException  {
   File fs = new File(FinanceGlobalVariables.VariableInvoice);
    Workbook ws= Workbook.getWorkbook(fs);
    Sheet s = ws.getSheet("Negative");
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

