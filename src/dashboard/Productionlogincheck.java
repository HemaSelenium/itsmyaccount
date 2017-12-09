package dashboard;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class Productionlogincheck extends TestBase{
	@Test(priority=1)
	public void Login(){
	Reporter.log("Script Name:Admin---->Application--->CurrentEvents", true);	
	Reporter.log("----------------------------------------------", true);	
	Reporter.log(" ", true);	
	helper.Navigate("http://test-itsmyaccount.azurewebsites.net/login");
	helper.SetValue1("UserName", "DEMO_10");
	helper.SetValue1("Password", "DEMO_10");
	helper.ClickByID(VariableCalling.SelectTermsAndConditions);
	helper.ClickByXpath(VariableCalling.LoginButton);

	}
	@Test(priority=2)
	public void AddFinaceVoucher() throws IOException, InterruptedException{
		
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);	
	helper.ClickByXpath(".//*[@id='503']/div/img");
	helper.DeepSleep();
	helper.TakeScreenShot("financevouchersbeforerearrange");
	helper.ClickByID("Add");
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.id("VoucherDate")).clear();
	helper.Sleep();
	SeleniumHelper.driver.findElement(By.id("VoucherDate")).sendKeys("05-07-2017");
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.id("VoucherDate")).sendKeys(Keys.TAB);
	helper.Sleep();
	SeleniumHelper.driver.findElement(By.xpath(".//*[@id='Debit']")).sendKeys(Keys.BACK_SPACE);
	SeleniumHelper.driver.findElement(By.xpath(".//*[@id='Debit']")).sendKeys(Keys.BACK_SPACE);
	SeleniumHelper.driver.findElement(By.xpath(".//*[@id='Debit']")).sendKeys(Keys.BACK_SPACE);
	SeleniumHelper.driver.findElement(By.xpath(".//*[@id='Debit']")).sendKeys(Keys.BACK_SPACE);
	helper.Sleep();
	SeleniumHelper.driver.findElement(By.xpath(".//*[@id='Debit']")).sendKeys("10.00");
	helper.Sleep();
	helper.ClickByXpath(".//*[@id='Voucher']/div/div/div[2]/div/div[4]/table/tbody/tr/td[9]/button");
	helper.DeepSleep();
	helper.SetValueByXpath(".//*[@id='Description']", "manual pay");
	DesiredCapabilities dc = new DesiredCapabilities();
    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	helper.DeepSleep();
    helper.ClickByXpath(".//*[@id='Voucher']/div/div/div[3]/button[1]");
    helper.DeepSleep();  
     
    
		Alert alert = SeleniumHelper.driver.switchTo().alert();
		helper.Sleep();
		String popup = alert.getText();
		alert.accept();
		helper.Sleep();
	    helper.TakeScreenShot("FinanceVouchersAfterAddnewVoucherForRearrange");
			
		String VoucherNumber=popup.split(" ")[1];
		helper.Sleep();
		System.out.println(VoucherNumber);
		VoucherNumber=VoucherNumber.substring(3);
		System.out.println(VoucherNumber);
		 helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
		 helper.DeepSleep();
		 helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, VoucherNumber);
		 helper.ClickByXpath(VariableCalling.ClickOnFindButton);
		 helper.DeepSleep();
		 helper.ClickByXpath(VariableCalling.CloseSearchFunction);
		 helper.DeepSleep();
		 helper.ClickByID(VariableCalling.SelectRow);
		 helper.Sleep();
		 helper.ClickByXpath(".//*[@id='Delete']");
		 helper.DeepSleep();
		 helper.ProcessAlert();
		 helper.TakeScreenShot("FinanceVouchersAfterDeleteAddedVoucherForRearrange"); 
	}
	
	

}
