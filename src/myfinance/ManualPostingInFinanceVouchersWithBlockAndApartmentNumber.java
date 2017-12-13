package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
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

public class ManualPostingInFinanceVouchersWithBlockAndApartmentNumber extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	
	 protected static MethodsCalling method=new MethodsCalling();
	 	
	 @Test(priority = 1)
		public void Scriptname() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_028",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Manual Posting In Finance Vouchers With Block And Apartment Number",true);
			helper1.SAP();
			
		}
		
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		
		ldr.adminlogin();
		helper1.SAP();
		
	}
		
	
	@Test(priority = 3,dataProvider="Manual",dependsOnMethods="Login")
	public void ManualpostingWarning(String amount) throws InterruptedException, HeadlessException, IOException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AddmanualVoucher)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(method.PresentdateMinus5());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		/*MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(Keys.ENTER);
		helper1.SAP();*/
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(amount);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ExtendButton)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).sendKeys(FinanceVariables.narration);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveVoucher)).click();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("ManualVoucherWithBlockAndApartment");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"ManualVoucherWithBlockAndApartment", true);
	    helper1.SAP();
		Alert alert3 = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message2 = alert3.getText();
		Reporter.log(message2,true);
		helper1.SAP();
		String message3 = message2.split(" ")[1];
		System.out.println(message3);
		String message4=message3.substring(3,6);
		helper1.SAP();
		System.out.println("manual voucher no.: " + message4);
		helper1.SAP();
		alert3.accept();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		//MethodsCalling.driver.findElement(By.xpath("//option[contains(.,'Header Reference')]")).click();
		//helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(message4);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		helper1.SAP();
		Actions action = new Actions(MethodsCalling.driver);
		action.moveToElement(MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers))).doubleClick().build().perform();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(FinanceVariables.EditManualVoucherAmount);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Credit)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Credit)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Credit)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Credit)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Credit)).sendKeys(Keys.BACK_SPACE);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Credit)).sendKeys("55.00");
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveVoucher)).click();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("EditedManualVoucherWithBlockAndApartment");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"EditedManualVoucherWithBlockAndApartment", true);
				helper1.SAP();
		Alert alert4 = MethodsCalling.driver.switchTo().alert();
		alert4.accept();
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Export)).click();
		helper1.SAP();
 	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Exportpdf)).click();
 	  helper1.SAP();
 	 method.TakeScreenShot("EditedManualVoucherWithBlockAndApartmentpdf");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"EditedManualVoucherWithBlockAndApartmentpdf", true);
				helper1.SAP();
 	 
		
		
		
/*WebElement Vouchertable=MethodsCalling.driver.findElement(By.xpath(FinanceVariables.WaiveOffTable));
		
		List<WebElement>rows=Vouchertable.findElements(By.tagName(FinanceVariables.TableRowId));
		List<WebElement>coloumns=rows.get(1).findElements(By.tagName(FinanceVariables.TablecolumnId));
		System.out.println(coloumns.get(7).findElement(By.tagName(FinanceVariables.TagnameInputId)).getAttribute("value"));
		coloumns.get(7).findElement(By.tagName(FinanceVariables.TagnameInputId)).clear();
		coloumns.get(7).findElement(By.tagName(FinanceVariables.TagnameInputId)).sendKeys(Keys.ENTER);
		coloumns.get(7).findElement(By.tagName(FinanceVariables.TagnameInputId)).clear();
		coloumns.get(7).findElement(By.tagName(FinanceVariables.TagnameInputId)).sendKeys("55.00");
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveVoucher)).click();
		helper1.SAP();
		Alert alert1 = MethodsCalling.driver.switchTo().alert();
		alert1.accept();
		helper1.SAP();*/
		
	}
	
	
	
	@Test(priority = 4,dependsOnMethods="ManualpostingWarning")
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		Reporter.log("Check for re-numbering of voucher manually through pdf file",true);
	}
	@DataProvider(name = "Manual")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ManualPostingOfFinanceVouchers);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("M4");
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
