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
import FinanceCommon.Variables;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PartialPaymentForFixedInvoice2000 extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
		FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	protected static FinanceVariables fin=new FinanceVariables();
	String voucherno;
	
	 @Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_017",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Partial payment for Fixed Invoice 2000",true);
			helper1.SAP();
			Reporter.log("----------------------------",true);
		}
	
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		
		ldr.adminlogin();
		helper1.SAP();
		Reporter.log("----------------------------",true);
		}
	
	@Test(priority = 3, dataProvider = "Partial")
	public void PartialPayment(String voucherno) throws InterruptedException, HeadlessException, IOException, AWTException {
		help2.Partialpayment();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.PaymentTable));
		List<WebElement> rows1 = paymenttable.findElements(By.tagName(FinanceVariables.TableRowId));
		int rowscount = rows1.size();
		for (rowscount = 1; rowscount < rows1.size(); rowscount++) {
			List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName(FinanceVariables.TablecolumnId));
			String rowvalue = columns1.get(1).getText();
			System.out.println(rowvalue);
			System.out.println(voucherno);
			if (rowvalue.equals(voucherno)) {
				System.out.println(voucherno);
				System.out.println("Paying amount for the voucher: " + voucherno);
				columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceTab)).clear();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceTab)).sendKeys("300");
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration)).sendKeys(Variables.narration);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				Thread.sleep(3000);
				method.TakeScreenShotOfWindowPopUp("PartialFixedInvoice2000");
				Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"PartialFixedInvoice2000", true);
				helper1.SAP();
				String message = alert.getText();
				System.out.println(message);
				alert.dismiss();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(voucherno);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); 
				helper1.SAP();																				
				Reporter.log("----------------------------",true);
				
				break;
			}
			
		}
		
		
	}

	@Test(priority = 4)
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		Reporter.log("Generate Fixed invoice manually by uploading excel file",true);
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
