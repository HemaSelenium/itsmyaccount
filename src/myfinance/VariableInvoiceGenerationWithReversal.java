package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
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

public class VariableInvoiceGenerationWithReversal extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	
	String voucherno2;
	InvoiceGenerationHelper help1 = new InvoiceGenerationHelpDEMO10();
	
	protected static FinanceVariables fin=new FinanceVariables();
	
	protected static MethodsCalling method=new MethodsCalling();
	
	 @Test(priority = 1)
		public void Scriptname() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_031",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Variable Invoice Generation With Reversal",true);
			helper1.SAP();
			
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
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		helper1.SAP();
	}
	@Test(priority = 4,dependsOnMethods="Variable")
	public void reverse()
			throws InterruptedException, IOException, BiffException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VariableInvoiceReversal)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ReversalInvoiceNumbertab)).sendKeys(voucherno2);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerGo)).click();
		helper1.SAP();
		WebElement load=MethodsCalling.driver.findElement(By.id(Variables.IdentifyingTable));
		WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
		List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
       
		int jsize=rows3.size();
	
		for(int p=1;p<jsize;p++){  
      				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
			String data3=coloumn3.get(2).getText();
			System.out.println(data3);
			
			if(data3.equals(voucherno2)){
				coloumn3.get(2).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversalReverse)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversalDate)).clear();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversalDate)).sendKeys(method.PresentdateMinus1());
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoiceReversalReason)).sendKeys("Reverse");
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoiceReverseAfterReason)).click();
				helper1.SAP();
				method.TakeScreenShotOfWindowPopUp("VariableInvoiceGenerationWithReversal");
				Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"VariableInvoiceGenerationWithReversal", true);
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
	   			helper1.SAP();
	   			String vouchermessage = alert.getText();
	   			String voucherno = vouchermessage.split(" ")[3];
	   			helper1.SAP();
	   			System.out.println(voucherno);
	   			alert.accept();
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
	   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
	   			helper1.SAP();
	   			WebElement element = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers));
	   			Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
	   			action.build().perform();
	   			helper1.SAP();
	   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CloseVocherInFinanceVouchers));
	   			helper1.SAP();
						
			}	
}
	}
	
	
	@Test(priority = 5,dependsOnMethods="reverse")
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		
	}
	 @Test(priority = 6,dependsOnMethods="ManualChecking")
		public void UserLogin()
				throws InterruptedException, IOException {
			method.userLoginWithScreenShotsAfterProcess1(MethodsCalling.driver);
			helper1.SAP();
		}

		@Test(priority = 7,dependsOnMethods="UserLogin")
		public void logout() throws InterruptedException {
			ldr.logout();
			helper1.SAP();
		}
		
	
	@DataProvider(name = "VariableInvoice")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.VariableInvoice);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("Variable2");
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
