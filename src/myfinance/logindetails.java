package myfinance;


import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;



public class logindetails extends TestBase {
	
	
	protected static Logger log=Logger.getLogger(logindetails.class);
	protected static FinanceVariables fin=new FinanceVariables();
	// public static WebMethodsCalling.driver MethodsCalling.driver;
	public void userlogin() throws InterruptedException, IOException {
		DOMConfigurator.configure("log4j.xml");
		MethodsCalling.driver.get(FinanceVariables.URL);
		helper1.SAP();
		MethodsCalling.driver.manage().window().maximize();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.UsernameId)).sendKeys(FinanceGlobalVariables.MemberUsername);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.PasswordId)).sendKeys(FinanceGlobalVariables.MemberPassword);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.TermsAndConditions)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SignIn)).click();
		helper1.SAP();
		WebElement verification = MethodsCalling.driver
				.findElement(By.xpath(FinanceVariables.Application));
		helper1.SAP();
		String value = verification.getText();
		helper1.SAP();
		Assert.assertEquals(value, "Application");
		helper1.SAP();
	}

	public void adminlogin() throws InterruptedException {
		MethodsCalling.driver.get(FinanceVariables.URL);
		helper1.SAP();
		MethodsCalling.driver.manage().window().maximize();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.UsernameId)).sendKeys(FinanceGlobalVariables.AdminUsername);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.PasswordId)).sendKeys(FinanceGlobalVariables.AdminPassword);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.TermsAndConditions)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SignIn)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
	}
	

	public void logout() throws InterruptedException {
MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LogOut)).click();;
		Thread.sleep(4000);
	}

	public void blockFlat() throws InterruptedException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SelectBlock)).sendKeys(FinanceGlobalVariables.OwnerBlock);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.SelectApartment)).sendKeys(FinanceGlobalVariables.OwnerApartmentNo);
		helper1.SAP();

	}

	public void SearchVoucherno( String splitmessage) throws InterruptedException, IOException, HeadlessException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(splitmessage);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		Thread.sleep(8000);
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																						// button
		helper1.SAP();
		Reporter.log(
				"Invoice Generated For Amount: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
		Reporter.log("Due Date:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DuedateTabInFinanceVouchers)).getText(),true);
		
		String clearingvoucher = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ClearingReferenceTabInFinanceVouchers)).getText();
		if (clearingvoucher == null) {
			System.out.println("By Clearing Voucher no:  " + clearingvoucher);

		} else {
			System.out.println("There are no Clearing References");
		}
		
		
		Reporter.log("For Line item Colour indicator in Fin voucher listing for Doc No: " + splitmessage,true);
		helper1.SAP();
		
		helper1.SAP();
		WebElement element = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers));
		Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
		action.build().perform();
		helper1.SAP();
		method.TakeScreenShot("Voucher");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"Voucher", true);
		helper1.SAP();
	
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CloseVocherInFinanceVouchers));
		helper1.SAP();
	}
	public void SearchVoucherno1( String splitmessage) throws InterruptedException, IOException {
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='503']/div/img")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(
				By.xpath("html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/table/tbody/tr/td[3]/div/a/i"))
				.click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("searchgrid")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath("//option[contains(.,'Header Reference')]")).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("jqg2")).sendKeys(splitmessage);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id("fbox_Grid_search")).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='searchhdfbox_Grid']/a/span")).click(); // close
																						// button
		helper1.SAP();
		Reporter.log(
				"Payment Amount: " + MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[7]")).getText(),true);
		helper1.SAP();
		Reporter.log("Due Date:  " + MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[11]")).getText(),true);
		helper1.SAP();
		Reporter.log("Voucher no: " + MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[3]")).getText(),true);
		String clearingvoucher = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[12]")).getText();
		
		Reporter.log("By Clearing Voucher no:  " + clearingvoucher,true);

		
	
		/*System.out.println("Files Stored in (Path Name)");
		System.out.println("---------------------------");
		File screenshot1 = ((TakesScreenshot) MethodsCalling.driver).getScreenshotAs(OutputType.FILE);
		helper1.SAP();
		String path1 = "C://Users//IMA//FinanceScreenshots//Screenshots.bmp" + screenshot1.getName();
		helper1.SAP();
		System.out.println("8)For Line item Colour indicator in Fin voucher listing for Doc No: " + splitmessage + path1);
		helper1.SAP();
		FileUtils.copyFile(screenshot1, new File(path1));
		helper1.SAP();
		WebElement element = MethodsCalling.driver.findElement(By.xpath(".//*[@id='1']/td[3]"));
		Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
		action.build().perform();
		helper1.SAP();
		File screenshot = ((TakesScreenshot) MethodsCalling.driver).getScreenshotAs(OutputType.FILE);
		helper1.SAP();
		String path = "C://Users//IMA//FinanceScreenshots//Screenshots.bmp" + screenshot.getName();
		helper1.SAP();
		System.out.println("9)For Debit And Credit Entry :  " + path);
		helper1.SAP();
		FileUtils.copyFile(screenshot, new File(path));
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(".//*[@id='Voucher']/div/div/div[1]/button"));
		helper1.SAP();*/
	}
	
	public void findVoucherno(String advancevoucherno2) throws InterruptedException, IOException {
		
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(advancevoucherno2);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																						// button
		helper1.SAP();
		Reporter.log(
				"Advance Amount: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
		helper1.SAP();
		Reporter.log("Date:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CreatedOndateTabInFinanceVouchers)).getText(),true);
		helper1.SAP();
		Reporter.log("Voucher no: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers)).getText(),true);
		helper1.SAP();
		WebElement element = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers));
		Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
		action.build().perform();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CloseVocherInFinanceVouchers));
		helper1.SAP();
	}
public void findVoucherno1(String advancevoucherno4) throws InterruptedException, IOException {
		
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(advancevoucherno4);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																						// button
		helper1.SAP();
		Reporter.log(
				"Advance Amount: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
		helper1.SAP();
		Reporter.log("Date:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherdateTabInFinanceVouchers)).getText(),true);
		helper1.SAP();
		Reporter.log("Voucher no: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers)).getText(),true);
		helper1.SAP();
		WebElement element = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers));
		Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
		action.build().perform();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CloseVocherInFinanceVouchers));
		helper1.SAP();
	}

public void SearchVoucherno2(String splitmessage1) throws InterruptedException, IOException, HeadlessException, AWTException {
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchType)).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSearchTxtboxId)).sendKeys(splitmessage1);
	helper1.SAP();
	MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();// find button
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click(); // close
																					// button
	helper1.SAP();
	Reporter.log(
			"Invoice Generated For Amount: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AmountOndateTabInFinanceVouchers)).getText(),true);
	helper1.SAP();
	Reporter.log("Due Date:  " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DuedateTabInFinanceVouchers)).getText(),true);
	helper1.SAP();
	Reporter.log("Voucher no: " + MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers)).getText(),true);
	helper1.SAP();
	String clearingvoucher = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ClearingReferenceTabInFinanceVouchers)).getText();
	
		Reporter.log("By Clearing Voucher no:  " + clearingvoucher,true);
		helper1.SAP();
	
	WebElement element = MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherNumberTabInFinanceVouchers));
	Actions action = new Actions(MethodsCalling.driver).doubleClick(element);
	action.build().perform();
	helper1.SAP();
	method.TakeScreenShot("Invoice2000");
	Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"Invoice2000", true);
	helper1.SAP();
	
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.CloseVocherInFinanceVouchers));
	helper1.SAP();
}
}
