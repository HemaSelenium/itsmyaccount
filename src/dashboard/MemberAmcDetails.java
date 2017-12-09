package dashboard;

import org.testng.Reporter;
import org.testng.annotations.Test;

import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class MemberAmcDetails extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("ScriptName:Member--->Application-->Assets&Inventory-->AmcDetails", true);	
Reporter.log("----------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
}
@Test(priority=2,dataProvider="AmcDetailsByGivenPeriodOfDates",dataProviderClass= Dataproviders.class)
public void AmcDetails(String EnterFromDate,String EnterToDate) throws InterruptedException{
helper.ClickByXpath(VariableCalling2.ClickOnAmcDetailsButtonInAssetsAndInventory);
helper.SetValueByID(VariableCalling2.EnterFromDdate, EnterFromDate);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterToDate, EnterToDate);
helper.DeepSleep();
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButton);
helper.MaxSleep();
Reporter.log("Amc Details Between GivenPeriod Of Dates Are Displayed", true);	
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInAmcDetailsPage);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInAmcDetailsPage);
helper.MaxSleep();
Reporter.log("Amc Details Between GivenPeriod Of Dates Are Exported To Pdf", true);	

	}

}


