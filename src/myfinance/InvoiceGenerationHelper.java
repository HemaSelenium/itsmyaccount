package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

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

public class InvoiceGenerationHelper extends TestBase {
	//  = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	protected static Variables var=new Variables();
    String splitmessge=null;
    String splitmessge1=null;
    
    
    String choose="yes";
   /* String amount2="4500";
    String amount3="2000";
    String amount="550";*/
    
    //String splitmessge1=null;
    
    protected static FinanceVariables fin=new FinanceVariables();
    protected static MethodsCalling method=new MethodsCalling();
    public String GenerateFixedInvoiceno(String amount, String narration) throws InterruptedException, IOException, HeadlessException, AWTException{
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonth());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDuedate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDuedate)).sendKeys(method.StartingDatePlus12());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDuedate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		ldr.blockFlat();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// basic
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax1)).click();												// amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax2)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.OpeningBalance)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.narration)).sendKeys(narration);// narration
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // Generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click();// yes button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click(); // generate invoice
		helper1.SAP();	
		method.TakeScreenShotOfWindowPopUp("FixedInvoice");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FixedInvoice", true);
		helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);	
		alert.accept();
		String splitmessage = message.split(" ")[2];
		System.out.println("Maintanance fixed invoice no." + splitmessage);
		helper1.SAP();
		String fixedvoucherno = splitmessage;
		helper1.SAP();
		ldr.SearchVoucherno(splitmessage);
		return fixedvoucherno;
	}
	
	public void GenerateFixedInvoicenoNegativeTesting(String amount, String narration)
			throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.TenantBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SelectApartment)).sendKeys(FinanceGlobalVariables.TenantApartmentNo);
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// basic
															// amount
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.narration)).sendKeys(narration);// narration
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // Generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click();// yes button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click(); // generate invoice
		helper1.SAP();	// button
		method.TakeScreenShotOfWindowPopUp("NegativeFixedInvoice");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"NegativeFixedInvoice", true);
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);
		alert.accept();
		helper1.SAP();
		

		
		
	}

	public void SelectTaxInProfile()
			throws InterruptedException, BiffException, IOException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdminProfile)).click();
		helper1.SAP();
		
		WebElement checkbox = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.TaxRadioButtonInAdminProfile));
		String selectcheckbox = "yes";
		if (selectcheckbox.equals(choose)) {
			if (checkbox.isSelected() == true) {
				System.out.println("Tax Percentage is:  " + Variables.Taxpercentage);

			} else {
				checkbox.click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id(FinanceVariables.serviceTaxTxtbox)).sendKeys(Variables.Taxpercentage);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveButtonInAdmin)).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				alert.accept();
				helper1.SAP();
				ldr.logout();
			}
		} else {
			if (checkbox.isSelected() == true) {
				checkbox.click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("btnSave")).click();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				alert.accept();
				helper1.SAP();
				ldr.logout();
			} else {
				System.out.println("Tax not selected");
			}
		}
		
		ldr.logout();
	}

	public void setDate( String dateid, int year, int month, int day) throws InterruptedException {
		System.out.println("Taken Current Date");
	}

	public String GenerateFixedInvoicenoForTenant(String amount, String narration)
			throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonth());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(method.StartingDatePlus10());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.TenantBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SelectApartment)).sendKeys(FinanceGlobalVariables.TenantApartmentNo);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoiceTenantAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoiceTenantAmount)).sendKeys(amount);// basic
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.narration)).sendKeys(narration);// narration
		helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax1)).click();												// amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax2)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.OpeningBalance)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // Generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click();// yes button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click(); // generate invoice
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("FixedInvoiceTenant");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FixedInvoiceTenant", true);
		helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);
		alert.accept();
		String splitmessage = message.split(" ")[2];
		System.out.println("Maintanance fixed invoice no." + splitmessage);
		helper1.SAP();
		String fixedvoucherno = splitmessage;
		helper1.SAP();
		ldr.SearchVoucherno(splitmessage);
		return fixedvoucherno;
	}

	public void ReverseInvoice( String splitmessage1)
			throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversal)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoiceReversalVoucher)).sendKeys(splitmessage1);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoiceReversalGo)).click();// submit button
		helper1.SAP();
		WebElement reversaltable = MethodsCalling.driver.findElement(By.id("Grid"));
		List<WebElement> rows1 = reversaltable.findElements(By.tagName("tr"));
		int rowscount = rows1.size();
		if (rowscount == 1) {
			System.out.println("Amount already paid for this voucher so reversal is not possible");
		} else {
			String migvoucher = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceNumberTabInFixedInvoiceReversal)).getText();
			if (migvoucher.equals(splitmessage1)) {
				MethodsCalling.driver.findElement(By.id(FinanceVariables.CheckBoxInFixedInvoiceReversal)).click();// click
																// checkbox
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversalReverse)).click();// reverse
																										// button
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversalDate)).clear();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FixedInvoiceReversalDate)).sendKeys(method.PresentDate());
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("Reason")).sendKeys("reversing amount for Invoice" + splitmessage1);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("Generate")).click(); // reverse button
																// after giving
																// reason
				Thread.sleep(12000);
								
				method.TakeScreenShotOfWindowPopUp("FixedInvoiceReversal");
				Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FixedInvoiceReversal", true);
				helper1.SAP();
				Alert alert2 = MethodsCalling.driver.switchTo().alert();
				helper1.SAP();
				String message2 = alert2.getText();
				helper1.SAP();
				System.out.println(message2);
				message2 = message2.split(" ")[3];
				helper1.SAP();
				System.out.println("Reversal maintanance invoice no. " + message2);
				helper1.SAP();
				alert2.accept();
				helper1.SAP();
				ldr.SearchVoucherno(message2);

			}
		}
	}

	public String GenerateVariableInvoice(String amount)
			throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.VariableInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonthplus1());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(method.StartingDateOfMonthplus14());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		ldr.blockFlat();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// Basic amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration1)).sendKeys(Variables.Narrstion);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax1)).click();												// amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax2)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.OpeningBalance)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click(); // Yes button
		helper1.SAP();
		Alert alert = MethodsCalling.driver.switchTo().alert();
		alert.accept();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click();// generate button
		helper1.SAP();
		
		method.TakeScreenShotOfWindowPopUp("FixedInvoiceReversal");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FixedInvoiceReversal", true);
		helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message1 = alert1.getText();
		helper1.SAP();
		Reporter.log(message1,true);
		helper1.SAP();
		alert1.accept();
		helper1.SAP();
		String splitmessage = message1.split(" ")[2];
		helper1.SAP();
		System.out.println("Generated Adhoc Invoice no: " + splitmessage);
		helper1.SAP();
		String voucherno1 = splitmessage;
		helper1.SAP();
		/*ldr.SearchVoucherno(splitmessage);
		helper1.SAP();*/
		return voucherno1;
	}
	
	public void GenerateVariableInvoicenegativeTesting(String amount)
			throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.VariableInvoicing)).click();
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.TenantBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SelectApartment)).sendKeys(FinanceGlobalVariables.TenantApartmentNo);
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// Basic amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration1)).sendKeys(Variables.Narrstion);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click(); // Yes button
		helper1.SAP();
		Alert alert1 = MethodsCalling.driver.switchTo().alert();
		alert1.accept();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click();
		helper1.SAP();
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String popup=MethodsCalling.driver.switchTo().alert().getText();
		System.out.println(popup);
		alert.accept();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("NegativeVariable");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"NegativeVariable", true);
		helper1.SAP();
		
	}

	public void SelectTax( String choose) throws InterruptedException {
		WebElement checkbox = MethodsCalling.driver.findElement(By.cssSelector("#CH1"));
		String selectcheckbox = "yes";
		if (selectcheckbox.equals(choose)) {
			helper1.SAP();
			if (checkbox.isSelected() == true) {
				helper1.SAP();
				System.out.println("Tax is Selected");

			} else {
				helper1.SAP();
				checkbox.click();
				helper1.SAP();
				
			}
		} else {
			if (checkbox.isSelected() == true) {
				helper1.SAP();
				checkbox.click();
				helper1.SAP();
				
			} else {
				helper1.SAP();
				System.out.println("Tax not selected");
			}
		}
	}
	
	public void SelectOpeningBalance( String chooseOP) throws InterruptedException {
		WebElement checkbox = MethodsCalling.driver.findElement(By.id("OPB1"));
		String selectcheckbox = "yes";
		if (selectcheckbox.equals(chooseOP)) {
			helper1.SAP();
			if (checkbox.isSelected() == true) {
				helper1.SAP();
				System.out.println("OpeningBalance is Selected");

			} else {
				helper1.SAP();
				checkbox.click();
				helper1.SAP();
				
			}
		} else {
			if (checkbox.isSelected() == true) {
				helper1.SAP();
				checkbox.click();
				helper1.SAP();
				
			} else {
				helper1.SAP();
				System.out.println("OpeningBalance not selected");
			}
		}
	}

	// data for fixed invoice generation in sheet 3
	@DataProvider(name = "testdata5")
	public Object[][] readexcel5() throws IOException, BiffException {
		File fs = new File("C:/Users/Swetha/Desktop/variabledata.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet(3);
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

	public void writeVoucherno(String dateid,String splitmessag) throws RowsExceededException, WriteException, IOException {
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GeneratedInvoiceNo03);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("PaymentForGenInvoice", 0);
		Label sheetcontent1 = new Label(0,0,method.StartingDatePlus12());
		Label sheetcontent2 = new Label(1,0,splitmessag);
		sheet.addCell(sheetcontent1);
		sheet.addCell(sheetcontent2);
		wb.write();
	    wb.close();
		}
	
	public void paymentForVariable() throws InterruptedException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
			helper1.SAP();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
			helper1.SAP();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).sendKeys(method.Presentdateplus13());
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
			helper1.SAP();
MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys("Variable / Adhoc Invoice");
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
			helper1.SAP();
			
			

	}
	public void simulatestep10() throws InterruptedException, IOException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VariableInvoiceReversal)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceType)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceType)).sendKeys("Select..");
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceType)).sendKeys(Keys.TAB);
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SelectApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SelectApartment)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
		helper1.SAP();
		helper1.SAP();
		method.TakeScreenShot("simulatestep10");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"simulatestep10", true);
		helper1.SAP();
		
		
	}
	
	public String GenerateFixedInvoiceWithTax(String amount) throws InterruptedException, IOException, HeadlessException, AWTException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonth());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(method.StartingDateOfMonthplus14());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		ldr.blockFlat();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// basic
															// amount
		helper1.SAP();
		
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.narration)).sendKeys(Variables.Narrstion);// narration
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // Generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click();// yes button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click(); // generate invoice
		helper1.SAP();											// button
					
			method.TakeScreenShotOfWindowPopUp("InvoiceTax");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"InvoiceTax", true);
			helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);
		alert.accept();
		String splitmessage1 = message.split(" ")[2];
		System.out.println("Maintanance fixed invoice no." + splitmessage1);
		helper1.SAP();
		String fixedinvoiceno = splitmessage1;
		helper1.SAP();
		ldr.SearchVoucherno2(splitmessage1);
		return fixedinvoiceno;
		
	}
	public void MemberReports() throws InterruptedException, BiffException, IOException {
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/span/a")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='506']/div/img")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li/b[6]/a")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='IsActive_OFF']")).click();
		Thread.sleep(3000);
		
		String CLGvoucherno=MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[5]")).getText();
		helper1.SAP();
		
		String duedate = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[11]")).getText();
		helper1.SAP();
		System.out.println("Clearing References1:  "+ CLGvoucherno +"is for amount" +MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[8]")).getText());
		helper1.SAP();
		
		System.out.println("Booking Date:  "+ MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[3]")).getText());
		helper1.SAP();
		System.out.println("Duedate  " + MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[7]")).getText());
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		
	}
	
	public String generateFixedInvoice(String amount) throws InterruptedException, IOException, HeadlessException, AWTException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonth());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(method.StartingDateOfMonthplus10());
		helper1.SAP();
		ldr.blockFlat();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// basic													// amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.narration)).sendKeys(Variables.narration);// narration
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // Generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click();// yes button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click(); // generate invoice
		helper1.SAP();											// button
		
		method.TakeScreenShotOfWindowPopUp("FixedInvoice2000");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"FixedInvoice2000", true);
			helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);
		alert.accept();
		String splitmessage1 = message.split(" ")[2];
		System.out.println("3)Maintanance fixed invoice no." + splitmessage1);
		helper1.SAP();
		String fixedinvoiceno = splitmessage1;
		helper1.SAP();
		ldr.SearchVoucherno2(splitmessage1);
		return fixedinvoiceno;
		
	}
	public String VariableInvoiceWithTax(String amount) throws InterruptedException, IOException, HeadlessException, AWTException{
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.VariableInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonthplus2());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(method.StartingDateOfMonthplus2plus10());
		helper1.SAP();
		ldr.blockFlat();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// Basic amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax1)).click();												// amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax2)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VariableNarration)).sendKeys(Variables.Narrstion);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click(); // Yes button
		helper1.SAP();
		Alert alert = MethodsCalling.driver.switchTo().alert();
		alert.accept();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click();// generate button
		helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message1 = alert1.getText();
		helper1.SAP();
		Reporter.log(message1,true);
		helper1.SAP();
		alert1.accept();
		helper1.SAP();
		String splitmessage = message1.split(" ")[2];
		helper1.SAP();
		System.out.println("Generated Adhoc Invoice no: " + splitmessage);
		helper1.SAP();
		String voucherno3 = splitmessage;
		ldr.SearchVoucherno(splitmessage);
		return voucherno3;
	}
	
	
public String GenerateFixedInvoiceno1( String amount, String narration) throws InterruptedException, IOException, HeadlessException, AWTException{
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FixedInvoicing)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonth());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDuedate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDuedate)).sendKeys(method.StartingDatePlus12());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDuedate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		ldr.blockFlat();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// basic
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax1)).click();												// amount
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax2)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.OpeningBalance)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.narration)).sendKeys(narration);// narration
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // Generate button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click();// yes button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click(); // generate invoice
		helper1.SAP();											// button
			method.TakeScreenShotOfWindowPopUp("MyAccountBeforeInvoiceWithexcel");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"MyAccountBeforeInvoiceWithexcel", true);
			
			helper1.SAP();
		WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = MethodsCalling.driver.switchTo().alert();
		String message = alert.getText();
		Reporter.log(message,true);
		alert.accept();
		String splitmessage = message.split(" ")[2];
		System.out.println("Maintanance fixed invoice no." + splitmessage);
		helper1.SAP();
		String fixedvoucherno = splitmessage;
		helper1.SAP();
		ldr.SearchVoucherno(splitmessage);
		return fixedvoucherno;
	}
public String GenerateVariableInvoice1(String amount)
		throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
	
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SocietyInvoicing)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.VariableInvoicing)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).clear();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceDate)).sendKeys(method.StartingDateOfMonthplus2());
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).clear();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DueDate)).sendKeys(method.StartingDateOfMonthplus2plus10());
	helper1.SAP();
	ldr.blockFlat();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).clear();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceAmount)).sendKeys(amount);// Basic amount
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration1)).sendKeys(Variables.Narrstion);
	
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax1)).click();												// amount
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceTax2)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.OpeningBalance)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGenerate)).click(); // generate button
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.InvoiceGeneratePopup)).click(); // Yes button
	helper1.SAP();
	Alert alert = MethodsCalling.driver.switchTo().alert();
	alert.accept();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.InvoiceGenerateFinal)).click();// generate button
	helper1.SAP();
	WebDriverWait wait = new WebDriverWait(MethodsCalling.driver, 50);
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert1 = MethodsCalling.driver.switchTo().alert();
	helper1.SAP();
	String message1 = alert1.getText();
	helper1.SAP();
	Reporter.log(message1,true);
	helper1.SAP();
	alert1.accept();
	helper1.SAP();
	String splitmessage = message1.split(" ")[2];
	helper1.SAP();
	System.out.println("Generated Adhoc Invoice no: " + splitmessage);
	helper1.SAP();
	String voucherno1 = splitmessage;
	helper1.SAP();
	ldr.SearchVoucherno(splitmessage);
	helper1.SAP();
	return voucherno1;
}
}


