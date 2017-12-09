package dashboard;

import org.testng.Reporter;
import org.testng.annotations.Test;

import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class AdminAmcDetails extends TestBase{
	@Test(priority=1)
	public void Login()throws Exception{
		Reporter.log("Script Name:Admin---->Application--->AMC Details", true);	
		Reporter.log("----------------------------------------------", true);	
		Reporter.log(" ", true);
		helper.Navigate(GlobalVariablesCalling.EnterUrl);
		Thread.sleep(3000);
		helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
		
		helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
		
			helper.ClickByID(VariableCalling.SelectTermsAndConditions);
			//click on login button
			helper.ClickByXpath(VariableCalling.LoginButton);
			Thread.sleep(4000);
			helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
			Thread.sleep(4000);
	}

	@Test(priority=2,dataProvider="AmcDetailsByGivenPeriodOfDates",dataProviderClass= Dataproviders.class)
	public void AmcDetails(String EnterFromDate,String EnterToDate) throws InterruptedException{
		
	helper.ClickByXpath(VariableCalling2.ClickOnAmcDetailsButtonInAssetsAndInventory);
	helper.SetValueByID(VariableCalling2.EnterFromDdate, EnterFromDate);
	Thread.sleep(4000);
	helper.SetValueByID(VariableCalling2.EnterToDate, EnterToDate);
	Thread.sleep(3000);
	helper.ClickByID(VariableCalling2.ClickOnGetDetailsButton);
	Thread.sleep(4000);
	Reporter.log("Amc Details Between GivenPeriod Of Dates Are Displayed", true);
	helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInAmcDetailsPage);
	Thread.sleep(4000);
	helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInAmcDetailsPage);
	Thread.sleep(4000);
	Reporter.log("Amc Details Between GivenPeriod Of Dates Are Exported To Pdf", true);
		}

}
