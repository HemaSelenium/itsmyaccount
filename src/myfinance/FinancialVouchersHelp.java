package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class FinancialVouchersHelp extends TestBase {

	//  = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	 protected static MethodsCalling method=new MethodsCalling();
	 protected static Variables var=new Variables();
	 protected static FinanceVariables fin=new FinanceVariables();
	 //protected static FinanceGlobalVariables fin1=new FinanceGlobalVariables();
	 String advancevoucherno2;
	String advanceamount;
	

	String editamount1 = "400";
	String editamount2 = "600";
	String editamount="150";

	/*
	 * public void login() throws InterruptedException { logindetails logd = new
	 * logindetails(); logd.adminlogin(MethodsCalling.driver, "DEMO_9", "DEMO_9"); }
	 */
	
	public void Payment()
			throws InterruptedException, BiffException, IOException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
			helper1.SAP();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).sendKeys(method.Presentdateplus12());
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.Facilityvoucher);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
			helper1.SAP();
			
	}

	public void setDate(String id,int year,int month,int day) throws InterruptedException {
		//System.out.println("Payment Date is not set so taken current date");
	}
	
	public void ScreenShots(String voucherno) throws InterruptedException, IOException{
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
																						// button
	helper1.SAP();
		Reporter.log("Voucher Date:" + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherdateTabInFinanceVouchers)).getText(),true);
		Reporter.log("Amount Cleared:" + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.TotalAmountClearedTabInFinVouchers)).getText(),true);
		String clearingvoucher = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ClearingReferenceTabInFinanceVouchers)).getText();
		if(clearingvoucher != null){
			Reporter.log("By Clearing Voucher no:  " + clearingvoucher,true);
				}
		else{
			System.out.println("There are no Clearing References");
		}
		Reporter.log("Files Stored in (Path Name)",true);
		Reporter.log("---------------------------",true);
		System.out.println("For Line item Colour indicator in Fin voucher listing for Doc No: " + voucherno );
	helper1.SAP();
		
		method.TakeScreenShot("facilitypayment");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"facilitypayment", true);
	helper1.SAP();
		WebElement element = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[3]"));
		Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
		action.build().perform();
	helper1.SAP();
		
	method.TakeScreenShot("VoucherDetails");
	Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"VoucherDetails", true);
helper1.SAP();
		
		
	
	
	}

	public String AdvancePaymentForFacility(String amount) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
			helper1.SAP();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click(); // payment button
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();// Block
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo); // Apartment
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.Facilityvoucher); // Voucher
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceRow)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceRow)).sendKeys(amount);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.payNarration)).sendKeys(Variables.narration);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click(); // pay button
			helper1.SAP();
			method.TakeScreenShotOfWindowPopUp("AdvancePaymentForFacility");
			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"AdvancePaymentForFacility", true);
			helper1.SAP();
			Alert alert = MethodsCalling.driver.switchTo().alert();
			helper1.SAP();
			String vouchermessage = alert.getText();
			helper1.SAP();
			Reporter.log(vouchermessage, true);
			helper1.SAP();
			alert.dismiss();
			helper1.SAP();
			
			 advancevoucherno2 = vouchermessage.split(" ")[1];
			System.out.println(vouchermessage + advancevoucherno2);
			ldr.findVoucherno(advancevoucherno2);
			return advancevoucherno2;
	}
	

	public void AdvancePaymentForGeneralAndMaintenance(String url,String dateid,String Block
			,String Flatno,String vouchertype,String advanceamount,String naration,String message)
			throws InterruptedException, BiffException, IOException {
			MethodsCalling.driver.navigate().to(url);
			helper1.SAP();
			MethodsCalling.driver.navigate().to(url);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Payment")).click(); // payment button
			helper1.SAP();
			//setDate(MethodsCalling.driver,dateid,2016,9,26);
			MethodsCalling.driver.findElement(By.cssSelector("#auto_BlockID")).clear();// Block
																		// ID
																		// dropdown
			helper1.SAP();
			MethodsCalling.driver.findElement(By.cssSelector("#auto_BlockID")).sendKeys(Block);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("auto_ApartmentId")).sendKeys(Flatno); // Apartment
																			// ID
			helper1.SAP();
			MethodsCalling.driver.findElement(By.cssSelector("#auto_InvType")).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.cssSelector("#auto_InvType")).sendKeys(vouchertype); // Voucher
																						// type
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Go")).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='advrow']/td[4]/input")).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='advrow']/td[4]/input")).sendKeys(advanceamount);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Narration")).sendKeys(naration);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("btnpay")).click(); // pay button
			Alert alert = MethodsCalling.driver.switchTo().alert();
			String vouchermessage = alert.getText();
			alert.accept();
			String advancevoucherno1 = vouchermessage.split(" ")[1];
			System.out.println(message + advancevoucherno1);
		}

	public void Waiver(String waveofvoucher) throws InterruptedException, HeadlessException, IOException, AWTException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.Waiveoff)).click();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
		helper1.SAP();
		WebElement Waveoftable= MethodsCalling.driver.findElement(By.xpath(FinanceVariables.WaiveOffTable));
		List<WebElement> rows1 = Waveoftable.findElements(By.tagName(FinanceVariables.TableRowId));
		int rowscount = rows1.size();
		System.out.println(rowscount);
		for (rowscount = 0; rowscount < rows1.size(); rowscount++) {
			List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName(FinanceVariables.TablecolumnId));
			String rowvalue = columns1.get(1).getText();
			helper1.SAP();
			System.out.println(rowvalue);
			if (rowvalue.equals(waveofvoucher)) {
				columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
				helper1.SAP();
				List<WebElement> vlues = columns1.get(5).findElements(By.tagName(FinanceVariables.TagnameInputId));
				helper1.SAP();
				vlues.get(2).clear();
				vlues.get(2).sendKeys(editamount);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration)).sendKeys(Variables.narration);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.WaiveOffButton)).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				helper1.SAP();
				method.TakeScreenShotOfWindowPopUp(" WaiverForFixedInvoice2000");
				Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+" WaiverForFixedInvoice2000", true);
				helper1.SAP();
				String message = alert.getText();
				Reporter.log(message,true);
				alert.dismiss();
				String advancevoucherno1 = message.split(" ")[1];
				System.out.println("Generated Waveoff Voucher no:" + advancevoucherno1);
				Reporter.log("--------------------------------------",true);
			}
		}
	}

	public void ReverseAdvance(String url, String advancevoucherno) throws InterruptedException, BiffException, IOException {
		String reverseadvancevoucherno;
		MethodsCalling.driver.navigate().to(url);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("RevAdv")).click();
		helper1.SAP();
		WebElement reversaltable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='Grid1']/tbody"));
		helper1.SAP();
		int rowcount = reversaltable.findElements(By.tagName("tr")).size();
		helper1.SAP();
		loop1: for (int i = 1; i < rowcount; i++) {
			String rowID = i + "";
			// List<WebElement> rows =
			// reversaltable.findElement(By.xpath(".//*[@id='Grid1']/tbody")).findElements(By.id(rowID));
			List<WebElement> rows1 = reversaltable.findElements(By.id(rowID));
			helper1.SAP();
			String rowdata = rows1.get(0).findElements(By.tagName("td")).get(6).getText();
			if (rowdata.equals(advancevoucherno)) {
				rows1.get(0).findElements(By.tagName("td")).get(6).click();
				MethodsCalling.driver.findElement(By.id("Reason")).sendKeys("Reversing advance amount of facility booking");
				MethodsCalling.driver.findElement(By.id("Generate")).click();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				String message = alert.getText();
				reverseadvancevoucherno = message.split(" ")[3];
				System.out.println("Reverse advance voucher no: " + reverseadvancevoucherno);
				alert.accept();
				break loop1;

			}
		
			else {
			//MethodsCalling.driver.findElement(By.xpath(".//*[@id='Popup']/div/div/div[3]/div[3]/button[2]")).click();
			System.out.println("Voucher does not exist in the list:" + advancevoucherno);
		}
		}
	}
	
	public void PaymentMoreThanTotalAmount(String URL1,String dateid,String year,String month,String date,
			String Block,String Flat,String advancevoucher,String editamount,String narration) throws InterruptedException, BiffException, IOException {
		int payyear = Integer.parseInt(year);
		int paymonth = Integer.parseInt(month);
		int paydate = Integer.parseInt(date);
		MethodsCalling.driver.navigate().to(URL1);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Payment")).click();
		helper1.SAP();
		//setDate(MethodsCalling.driver,dateid,payyear,paymonth,paydate);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[1]/div/a/i")).click();//dropdown xpath
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Block)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[2]/div/a/i")).click();// dropdown xpath
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Flat)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Go")).click();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[4]/table/tbody"));
		List<WebElement> rows1 = paymenttable.findElements(By.tagName("tr"));
		int rowscount = rows1.size();
		for (rowscount = 0; rowscount < rows1.size(); rowscount++) {
			List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName("td"));
			String rowvalue = columns1.get(1).getText();
			if (rowvalue.equals(advancevoucher)) {
				columns1.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				List<WebElement> vlues = columns1.get(5).findElements(By.tagName("input"));
				helper1.SAP();
				vlues.get(2).clear();
				vlues.get(2).sendKeys(editamount);
				MethodsCalling.driver.findElement(By.id("Narration")).sendKeys(narration);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("btnpay")).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				helper1.SAP();
				String message = alert.getText();
				System.out.println(message);
				alert.accept();
				MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[3]/button[2]")).click();
			}
		}

	}
	
	public void PaymentForTwoVouchers() throws InterruptedException, IOException, BiffException, HeadlessException, AWTException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
		helper1.SAP();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).clear();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).sendKeys(method.PresentDate());
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.MaintainaceType);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectGL)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectGL)).sendKeys(FinanceVariables.GLtype1);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
		helper1.SAP();
		File src=new File(FinanceGlobalVariables.InvoiceTax);
		FileInputStream fis=new FileInputStream(src);
		Workbook wb1=Workbook.getWorkbook(fis);
		Sheet sh1= wb1.getSheet(0);
        String str=sh1.getCell(0,0).getContents();
		String Voucher=str.trim();
		System.out.println(Voucher);
	
		File src1=new File(FinanceGlobalVariables.GettingHeaderreferenceforFixedInvoice2000);
		FileInputStream fis1=new FileInputStream(src1);
		Workbook wb2=Workbook.getWorkbook(fis1);
		Sheet sh2= wb2.getSheet(0);
		
		String excelvalue=sh2.getCell(0,0).getContents();
		System.out.println(excelvalue);
		helper1.SAP();


		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.PaymentTable));
		List<WebElement> rows1 = paymenttable.findElements(By.tagName(FinanceVariables.TableRowId));
		int rowscount = rows1.size();
		System.out.println(rowscount);
		for (rowscount =1; rowscount < rows1.size(); rowscount++) {
			List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName(FinanceVariables.TablecolumnId));
			String rowvalue = columns1.get(1).getText();
			//System.out.println(rowvalue);
			//System.out.println(Voucher);
			if (rowvalue.equals(excelvalue)) {
				
				columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
				helper1.SAP();
				break;
	
								
			}	
		}
			WebElement paymenttable1 = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.PaymentTable));
			List<WebElement> rows2 = paymenttable1.findElements(By.tagName(FinanceVariables.TableRowId));
			int rowscount1 = rows2.size();
			for (rowscount1 = 2; rowscount1<rows2.size(); rowscount1++) {
				List<WebElement> columns1 = rows2.get(rowscount1).findElements(By.tagName(FinanceVariables.TablecolumnId));
				String rowvalue1 = columns1.get(1).getText();
				System.out.println(rowvalue1);
				System.out.println(Voucher);
				if (rowvalue1.equals(Voucher)) {
					columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
					helper1.SAP();
					break;
	
				}
			}
				
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration)).sendKeys(Variables.narration);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("Balance");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"Balance", true);
		helper1.SAP();
		Alert alert = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message = alert.getText();
		Reporter.log(message,true);
		String paidvoucherno = message.split(" ")[1];
		System.out.println("Paid voucher no: " + paidvoucherno);
		alert.dismiss();
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(paidvoucherno);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
	helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).clear();
	helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(Voucher);
	helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
	helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).clear();
	helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(excelvalue);
	helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
	helper1.SAP();
	}
	
	
	
	

	/*public void Paymentforscenario4forcancel(, String URL, String Block, String Flat,
			String advancevoucher, String editamount, String narration) throws InterruptedException {
		MethodsCalling.driver.navigate().to(URL);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Payment")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[1]/div[3]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Block)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[1]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Flat)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Go")).click();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[3]/table/tbody"));
		List<WebElement> rows = paymenttable.findElements(By.tagName("tr"));
		int rowscount = rows.size();
		for (rowscount = 0; rowscount < rows.size(); rowscount++) {
			List<WebElement> columns = rows.get(rowscount).findElements(By.tagName("td"));
			String rowvalue = columns.get(1).getText();
			if (rowvalue.equals(advancevoucher)) {
				columns.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				List<WebElement> vlues = columns.get(5).findElements(By.tagName("input"));
				helper1.SAP();
				vlues.get(2).clear();
				vlues.get(2).sendKeys(editamount);
				MethodsCalling.driver.findElement(By.id("Narration")).sendKeys(narration);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("btnpay")).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				helper1.SAP();
				String message = alert.getText();
				System.out.println(message);
				alert.accept();
				MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[3]/button[2]")).click();
			}
		}

	}
*/
	/*public void Paymentforscenario4forpay(, String URL, String Block, String Flat,
			String advancevoucher, String editamount, String narration) throws InterruptedException {
		MethodsCalling.driver.navigate().to(URL);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Payment")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[1]/div[3]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Block)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[1]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Flat)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Go")).click();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[3]/table/tbody"));
		List<WebElement> rows = paymenttable.findElements(By.tagName("tr"));
		int rowscount = rows.size();
		for (rowscount = 0; rowscount < rows.size(); rowscount++) {
			List<WebElement> columns = rows.get(rowscount).findElements(By.tagName("td"));
			String rowvalue = columns.get(1).getText();
			if (rowvalue.equals(advancevoucher)) {
				columns.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				List<WebElement> vlues = columns.get(5).findElements(By.tagName("input"));
				helper1.SAP();
				vlues.get(2).clear();
				vlues.get(2).sendKeys(editamount);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("Narration")).sendKeys(narration);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.id("btnpay")).click();
				helper1.SAP();
				Alert alert = MethodsCalling.driver.switchTo().alert();
				helper1.SAP();
				String message = alert.getText();
				System.out.println(message);
				alert.accept();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(".//*[@id='btnpay']")).click();
				helper1.SAP();
			}
		}

	}

	public void Paymentforscenario6invoice1(,String URL,String Block,String Apartment, String voucherno, String facvoucherno, String editamount1)
			throws InterruptedException {
		MethodsCalling.driver.navigate().to("https://www.itsmyaccount.com/Voucher" + URL);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Payment")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[1]/div[3]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Block)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[1]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText(Apartment)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Go")).click();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[3]"));
		List<WebElement> rows = paymenttable.findElements(By.tagName("tr"));
		int rowscount = rows.size();
		System.out.println(rowscount);
		for (rowscount = 1; rowscount < rows.size(); rowscount++) {
			List<WebElement> columns = rows.get(rowscount).findElements(By.tagName("td"));
			String rowvalue = columns.get(1).getText();
			helper1.SAP();
			if (rowvalue.equals(voucherno)) {
				helper1.SAP();
				System.out.println(voucherno);
				helper1.SAP();
				columns.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				break;
			}
			if (rowvalue.equals(facvoucherno)) {
				columns.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				List<WebElement> vlues = columns.get(5).findElements(By.tagName("input"));
				helper1.SAP();
				vlues.get(2).clear();
				vlues.get(2).sendKeys(editamount1);
				helper1.SAP();
			}

			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Narration")).sendKeys("Paying amount for voucher");
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("btnpay")).click();
			helper1.SAP();
			Alert alert = MethodsCalling.driver.switchTo().alert();
			helper1.SAP();
			String message3 = alert.getText();
			helper1.SAP();
			System.out.println(message3);
			String splitmessage = message3.split(" ")[1];
			helper1.SAP();
			System.out.println(splitmessage);
			alert.accept();
			helper1.SAP();

		}
	}

	public void Paymentforscenario6invoice2(, String voucherno, String facvoucherno, String editamount2)
			throws InterruptedException {
		MethodsCalling.driver.navigate().to("https://www.itsmyaccount.com/Voucher");
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Payment")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[1]/div[3]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText("Block 3")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[1]/div/a/i")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.linkText("B3/1")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("Go")).click();
		helper1.SAP();
		WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[3]"));
		List<WebElement> rows = paymenttable.findElements(By.tagName("tr"));
		int rowscount = rows.size();
		System.out.println(rowscount);
		for (rowscount = 1; rowscount < rows.size(); rowscount++) {
			List<WebElement> columns = rows.get(rowscount).findElements(By.tagName("td"));
			String rowvalue = columns.get(1).getText();
			helper1.SAP();
			if (rowvalue.equals(voucherno)) {
				helper1.SAP();
				System.out.println(voucherno);
				helper1.SAP();
				columns.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				break;
			}
			if (rowvalue.equals(facvoucherno)) {
				columns.get(0).findElement(By.tagName("input")).click();
				helper1.SAP();
				List<WebElement> vlues = columns.get(5).findElements(By.tagName("input"));
				helper1.SAP();
				vlues.get(2).clear();
				vlues.get(2).sendKeys(editamount2);
				helper1.SAP();
			}

			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Narration")).sendKeys("Paying amount for voucher");
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("btnpay")).click();
			helper1.SAP();
			Alert alert = MethodsCalling.driver.switchTo().alert();
			helper1.SAP();
			String message3 = alert.getText();
			helper1.SAP();
			System.out.println(message3);
			String splitmessage = message3.split(" ")[1];
			helper1.SAP();
			System.out.println(splitmessage);
			alert.accept();
			helper1.SAP();

		}
		
		
		
	*/
    
       public void AdvanceSimulationscenario7() throws InterruptedException, IOException, HeadlessException, AWTException{
    	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
    	   Thread.sleep(5000);
    	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
    	   helper1.SAP();
    	   MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
   		helper1.SAP();
   		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
		helper1.SAP();
		
   		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
   		
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.MaintainaceType);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("AdvanceSimulationInstep7");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"AdvanceSimulationInstep7", true);
		helper1.SAP();
		
		
    	   
    	   
    	   
       }
       
       public String AdvancePaymentForStep12(String amount) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
   		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
   			helper1.SAP();
   			Thread.sleep(5000);
   			MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click(); // payment button
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();// Block
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo); // Apartment
   		    helper1.SAP();
   		    MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceRow)).clear();
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceRow)).sendKeys(amount);
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.payNarration)).sendKeys(Variables.narration);
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
   			helper1.SAP();
   			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click(); // pay button
   			helper1.SAP();
   			method.TakeScreenShotOfWindowPopUp("GeneralAdvancepayment");
   			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"GeneralAdvancepayment", true);
   			helper1.SAP();
   			Alert alert = MethodsCalling.driver.switchTo().alert();
   			helper1.SAP();
   			String vouchermessage = alert.getText();
   			helper1.SAP();
   			Reporter.log(vouchermessage, true);
   			helper1.SAP();
   			alert.dismiss();
   			helper1.SAP();
   			String advancevoucherno3 = vouchermessage.split(" ")[1];
   			System.out.println(vouchermessage + advancevoucherno3);
   			ldr.findVoucherno1(advancevoucherno3);
   			return advancevoucherno3;
   	}  
       public String AdvancePaymentforMaintainance(String amount) throws InterruptedException, BiffException, IOException {
      		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
      			helper1.SAP();
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click(); // payment button
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();// Block															// dropdown
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo); // Apartment
      		    helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
    			helper1.SAP();
    			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.MaintainaceType);
    			helper1.SAP();
      		    MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceRow)).clear();
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceRow)).sendKeys(amount);
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.payNarration)).sendKeys(Variables.narration);
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
      			helper1.SAP();
      			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click(); // pay button
      			helper1.SAP();
      			Alert alert = MethodsCalling.driver.switchTo().alert();
      			helper1.SAP();
      			String vouchermessage = alert.getText();
      			helper1.SAP();
      			Reporter.log(vouchermessage, true);
      			helper1.SAP();
      			alert.dismiss();
      			helper1.SAP();
      			String advancevoucherno4 = vouchermessage.split(" ")[1];
      			System.out.println(vouchermessage + advancevoucherno4);
      			ldr.findVoucherno1(advancevoucherno4);
      			return advancevoucherno4;
      	}  
          
       public void AdvanceReversalsimulationstep14() throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
     		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
     			helper1.SAP();
     			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
     			helper1.SAP();
     			Thread.sleep(5000);
     			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceReverse)).click();
     			helper1.SAP();
     			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Advancegrid1)).click();
     			helper1.SAP();
     			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Advancegrid2)).click();
     			helper1.SAP();
     			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Advancegrid3)).click();
     			helper1.SAP();
     			
       			method.TakeScreenShotOfWindowPopUp("ReverseAdvanceSimulation");
       			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"ReverseAdvanceSimulation", true);
       			helper1.SAP();
     			
       }
       
       public void ReversalOfFacilityadvance() throws InterruptedException, BiffException, IOException {
    	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
    			helper1.SAP();
    			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
    			helper1.SAP();
    			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceReverse)).click();
    			helper1.SAP();
    			method.TakeScreenShot("ReverseAdvancefacilitySimulation");
       			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"ReverseAdvancefacilitySimulation", true);
       			helper1.SAP();
    			
    				}
    				
       public void ReversalOfMaintainanceadvance() throws InterruptedException, BiffException, IOException {
    	   MethodsCalling.driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/span/a")).click();
    			helper1.SAP();
    			MethodsCalling.driver.findElement(By.xpath(".//*[@id='503']/div/img")).click();
    			helper1.SAP();
    			MethodsCalling.driver.findElement(By.xpath(".//*[@id='RevAdv']")).click();
    			helper1.SAP();
    			
    				}	
       public void reverse() throws InterruptedException, BiffException, IOException {
    	   MethodsCalling.driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/span/a")).click();
   		helper1.SAP();
   		MethodsCalling.driver.findElement(By.xpath(".//*[@id='503']/div/img")).click();
   		helper1.SAP();
   		MethodsCalling.driver.findElement(By.xpath(".//*[@id='RevAdv']")).click();
   		helper1.SAP();
    			
    				}	
       
       public void payment(String amount) throws InterruptedException, IOException, HeadlessException, AWTException{
    	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
    	   helper1.SAP();
    	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
    	   helper1.SAP();
    	   MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
    	   helper1.SAP();
    	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).sendKeys(method.Presentdateplus12());
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.MaintainaceType);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.RadioButtonInFinancePayments)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceTab)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AdvanceTab)).sendKeys(amount);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration)).sendKeys(Variables.narration);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click();
			helper1.SAP();
			
   			method.TakeScreenShotOfWindowPopUp("AdvancepaymentformaintainanceSimulation");
   			Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"AdvancepaymentformaintainanceSimulation", true);
   			helper1.SAP();
			Alert alert = MethodsCalling.driver.switchTo().alert();
   			helper1.SAP();
   			alert.dismiss();
			
    	   
       }
  public void Partialpayment() throws InterruptedException{
	  MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	  helper1.SAP();
	  MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
		helper1.SAP();
		 MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).sendKeys(method.Presentdateplus12());
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
			helper1.SAP();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Vouchertype)).sendKeys(FinanceVariables.MaintainaceType);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
			helper1.SAP();
			
	  
			
	  
  }
  
  public void PaymentInstep23c()
			throws InterruptedException, BiffException, IOException {
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/span/a")).click();
		helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='503']/div/img")).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Payment")).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='date']")).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='date']")).sendKeys(method.PresentDate());
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='auto_BlockID']")).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='auto_BlockID']")).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("auto_ApartmentId")).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Go")).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Go")).click();
			helper1.SAP();
			File src=new File(FinanceGlobalVariables.GettingHeaderReferenceForOtherFacility1000);
			FileInputStream fis=new FileInputStream(src);
			Workbook wb1=Workbook.getWorkbook(fis);
			Sheet sh1= wb1.getSheet(0);
			String Voucher=sh1.getCell(0,0).getContents();
			System.out.println(Voucher);
		
			File src1=new File(FinanceGlobalVariables.SeleniumVariables6);
			FileInputStream fis1=new FileInputStream(src1);
			Workbook wb2=Workbook.getWorkbook(fis1);
			Sheet sh2= wb2.getSheet(0);
			
			String excelvalue=sh2.getCell(0,0).getContents();
			
			System.out.println(excelvalue);
			helper1.SAP();


			WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(".//*[@id='frm-Payment']/div/div/div[2]/div[4]/table/tbody"));
			List<WebElement> rows = paymenttable.findElements(By.tagName("tr"));
			int rowscount = rows.size();
			for (rowscount = 0; rowscount < rows.size(); rowscount++) {
				List<WebElement> columns = rows.get(rowscount).findElements(By.tagName("td"));
				String rowvalue = columns.get(1).getText();
				if (rowvalue.equals(Voucher)) {
					columns.get(0).findElement(By.tagName("input")).click();
					helper1.SAP();
		
									
				}	
			}
				WebElement paymenttable1 = MethodsCalling.driver.findElement(By.xpath(".//*[@id='frm-Payment']/div/div/div[2]/div[4]/table/tbody"));
				List<WebElement> rows1 = paymenttable1.findElements(By.tagName("tr"));
				int rowscount1 = rows1.size();
				for (rowscount1 = 0; rowscount1<rows1.size(); rowscount1++) {
					List<WebElement> columns1 = rows1.get(rowscount1).findElements(By.tagName("td"));
					String rowvalue1 = columns1.get(1).getText();
					if (rowvalue1.equals(excelvalue)) {
						columns1.get(0).findElement(By.tagName("input")).click();
						helper1.SAP();
		
					}
				}
				helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='frm-Payment']/div/div/div[2]/div[4]/table/tbody/tr[2]/td[6]/input[3]")).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='frm-Payment']/div/div/div[2]/div[4]/table/tbody/tr[2]/td[6]/input[3]")).sendKeys("400");
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Narration")).sendKeys(Variables.narration);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='btnpay']")).click();
			helper1.SAP();
			Alert alert = MethodsCalling.driver.switchTo().alert();
   			helper1.SAP();
   			alert.dismiss();
      
}
  
  public void PaymentInstep23D()
			throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.payment)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paymentDate)).sendKeys(method.PresentDate());
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id(FinanceVariables.FinGo)).click();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.id("Go")).click();
			helper1.SAP();
			File src=new File(FinanceGlobalVariables.GettingHeaderReferenceForOtherFacility1000);
			FileInputStream fis=new FileInputStream(src);
			Workbook wb1=Workbook.getWorkbook(fis);
			Sheet sh1= wb1.getSheet(0);
			String Voucher=sh1.getCell(0,0).getContents();
			System.out.println(Voucher);
		
			File src1=new File(FinanceGlobalVariables.SeleniumVariables6);
			FileInputStream fis1=new FileInputStream(src1);
			Workbook wb2=Workbook.getWorkbook(fis1);
			Sheet sh2= wb2.getSheet("voucher1");
			
			String excelvalue=sh2.getCell(0,0).getContents();
			
			System.out.println(excelvalue);
			helper1.SAP();


			WebElement paymenttable = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.WaiveOffTable));
			List<WebElement> rows = paymenttable.findElements(By.tagName(FinanceVariables.TableRowId));
			int rowscount = rows.size();
			for (rowscount = 0; rowscount < rows.size(); rowscount++) {
				List<WebElement> columns = rows.get(rowscount).findElements(By.tagName(FinanceVariables.TablecolumnId));
				String rowvalue = columns.get(1).getText();
				if (rowvalue.equals(Voucher)) {
					columns.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
					helper1.SAP();
		
									
				}	
			}
				WebElement paymenttable1 = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.WaiveOffTable));
				List<WebElement> rows1 = paymenttable1.findElements(By.tagName(FinanceVariables.TableRowId));
				int rowscount1 = rows1.size();
				for (rowscount1 = 0; rowscount1<rows1.size(); rowscount1++) {
					List<WebElement> columns1 = rows1.get(rowscount1).findElements(By.tagName(FinanceVariables.TablecolumnId));
					String rowvalue1 = columns1.get(1).getText();
					if (rowvalue1.equals(excelvalue)) {
						columns1.get(0).findElement(By.tagName(FinanceVariables.TagnameInputId)).click();
						helper1.SAP();
		
					}
				}
				
				helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='frm-Payment']/div/div/div[2]/div[4]/table/tbody/tr[2]/td[6]/input[3]")).clear();
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(".//*[@id='frm-Payment']/div/div/div[2]/div[4]/table/tbody/tr[2]/td[6]/input[3]")).sendKeys("600");
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Narration)).sendKeys(Variables.narration);
			helper1.SAP();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.paybutton)).click();
			helper1.SAP();
			method.TakeScreenShotOfWindowPopUp("PartialAndFullPaymentFor2Invoices");
			Reporter.log("File Name :"+FinanceGlobalVariables.ScreenShotsFileName+"PartialAndFullPaymentFor2Invoices", true);
			helper1.SAP();
			Alert alert = MethodsCalling.driver.switchTo().alert();
 			helper1.SAP();
 			alert.dismiss();
    
}
}



