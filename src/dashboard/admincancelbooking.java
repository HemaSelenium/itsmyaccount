package dashboard;

import org.junit.Test;

import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;

public class admincancelbooking extends TestBase{
	@Test
	public void cancelbooking(){
		
	helper.Navigate(GlobalVariablesCalling.EnterUrl);
	helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);//enter user name
	
	helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);//enter password
	
	helper.ClickByID(VariableCalling.SelectTermsAndConditions);//click on agree terms and conditions
		
		helper.ClickByXpath(VariableCalling.LoginButton);//click on login button
		helper.DeepSleep();
//click on application button
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
//click on my facilities
helper.ClickByXpath(VariableCalling.MyFacilityButton);
helper.DeepSleep();

//click on booking/cancel
helper.ClickByXpath(VariableCalling.BookButton);
helper.DeepSleep();
//click on already booked facility which is in orange colour

helper.ClickByXpath(".//*[@id='calendar']/div[2]/div[2]/div[3]/div/div[1]/a[3]");
helper.DeepSleep();
helper.ClickByID(VariableCalling.CancelButton);
helper.DeepSleep();
//helper.Navigate("http://test-itsmyaccount.azurewebsites.net/Home/Index");
//click on application
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);

helper.DeepSleep();
//click on finance voucher
helper.ClickByXpath(VariableCalling.FinanceVouchersButton);
helper.DeepSleep();
helper.ClickByID("jqg_Grid_2");
helper.DeepSleep();
helper.ClickByXpath(".//*[@id='Voucher']/div/div/div[3]/div[2]/button");
helper.DeepSleep();
helper.ClickByXpath(".//*[@id='Voucher']/div/div/div[3]/div[2]/ul/li[1]/a");
helper.DeepSleep();
helper.Navigate("http://test-itsmyaccount.azurewebsites.net/Home/Index");
helper.DeepSleep();
helper.ClickByXpath(".//*[@id='506']/div/img");
helper.DeepSleep();

helper.ClickByID("setlink");
helper.DeepSleep();
helper.SetValueByID("FromDate", "06-06-2016");
helper.SetValueByID("ToDate", "06-06-2016");
//click on go
helper.ClickByID("btnGo");
helper.DeepSleep();
//click on trail balance
helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[1]/a");
//click on balancesheet
helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[2]/a");
helper.DeepSleep();
//click on expenditure 
helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[3]/a");
helper.DeepSleep();
//click on daybook
helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[5]/a");












}
}