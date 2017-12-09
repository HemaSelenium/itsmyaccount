package myfinance;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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

public class ManualPostingInFinanceVouchersThroughExcel extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	 boolean result=true;
	 protected static MethodsCalling method=new MethodsCalling();
	 	
	 @Test(priority = 1)
		public void Scriptname() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_027",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Manual Posting In FinanceVouchers Through Excel",true);
			helper1.SAP();
			
		}
		
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		
		ldr.adminlogin();
		helper1.SAP();
		
	}
		
	
	@Test(priority = 3,dataProvider="Manual")
	public void Manualposting(String amount) throws InterruptedException {
		driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.AddmanualVoucher)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.VoucherDate)).clear();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(method.PresentdateMinus6());
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.ManualVoucherGLtxt)).clear();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.ManualVoucherGLtxt)).sendKeys("Travelling Expenses");
	    helper1.SAP();
	    driver.findElement(By.xpath(FinanceVariables.ManualVoucherGLtxt)).sendKeys(Keys.ENTER);
		helper1.SAP();
	    driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
	helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
	helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
	helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(amount);
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.ExtendButton)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).sendKeys(FinanceVariables.narration);
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.SaveVoucher)).click();
		helper1.SAP();
		Alert alert2 = driver.switchTo().alert();
		helper1.SAP();
		String message2 = alert2.getText();
		Reporter.log(message2,true);
		helper1.SAP();
		String message3 = message2.split(" ")[1];
		System.out.println(message3);
		String message4=message3.substring(3,6);
		helper1.SAP();
		System.out.println("manual voucher no.: " + message4);
		helper1.SAP();
		alert2.accept();
		helper1.SAP();
		
		driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		
		driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(message4);
		helper1.SAP();
		driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		helper1.SAP();
		driver.navigate().refresh();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.Export)).click();
		helper1.SAP();
 	   driver.findElement(By.xpath(FinanceVariables.Exportpdf)).click();
 	  helper1.SAP();
 	 
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
		Reporter.log("Check for re-numbering of voucher manually through pdf file",true);
	}
	@DataProvider(name = "Manual")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ManualPostingOfFinanceVouchers);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("M3");
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
