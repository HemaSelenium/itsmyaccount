package dashboard;

import org.junit.Test;

import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
 
public class Bookingfacility extends TestBase{
	@Test
	public void facilitybooking() throws InterruptedException{
		helper.Navigate(GlobalVariablesCalling.EnterUrl);
		helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
		//send password
		helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
		//click on agree terms and conditions
			helper.ClickByID("VariableCalling.SelectTermsAndConditions");
			//click on login button
			helper.ClickByXpath(VariableCalling.LoginButton);
			helper.DeepSleep();
	//click on application button
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	helper.DeepSleep();
	//click on my facilities
	helper.ClickByXpath(".//*[@id='111']/div/img");
	helper.DeepSleep();
	
	helper.DeepSleep();
	helper.ClickByXpath(".//*[@id='21']/td[12]/a/button");
	helper.DeepSleep();

	//click on book 
			helper.ClickByID("Add");
			
			helper.DeepSleep();
			
			helper.ClickByID("FromDate");
					helper.DeepSleep();
					//select date
			helper.ClickByXpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a");
			helper.DeepSleep();
			helper.clearFromTime();
			helper.DeepSleep();
			helper.SetValueByID("FromTime", "02:30 PM");
			helper.ClickByID("ToDate");
			helper.DeepSleep();
			helper.ClickByXpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a");
			helper.DeepSleep();
			helper.clearToTime();
			helper.DeepSleep();
			helper.SetValueByID("ToTime", "03:00 PM");
			helper.DeepSleep();
								
			helper.ClickByXpath(".//*[@id='FacilityBooking']/div/div[2]/div/div/div/div/div[1]/div[6]/a");
			helper.DeepSleep();
			helper.ClickByXpath(".//*[@id='ui-id-6']");
			helper.DeepSleep();
			helper.ClickByXpath(".//*[@id='FacilityBooking']/div/div[2]/div/div/div/div/div[1]/div[7]/a");
			helper.DeepSleep();
			helper.ClickByXpath(".//*[@id='ui-id-8']");
	helper.SetValueByID("Description", "test");
	//click on book
	helper.ClickByXpath(".//*[@id='FacilityBooking']/div/div[3]/button[2]");
	helper.DeepSleep();
	helper.Navigate("http://test-itsmyaccount.azurewebsites.net/Home/Index");
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.FinanceVouchersButton);
	
	helper.ClickByID("jqg_Grid_2");
	helper.action();
	helper.DeepSleep();
	helper.Navigate("http://test-itsmyaccount.azurewebsites.net/Home/Index");
	helper.DeepSleep();
	//click on finance reorts
	helper.ClickByXpath(".//*[@id='506']/div/img");
	helper.DeepSleep();
	//click on filter
	helper.ClickByID("setlink");
	helper.DeepSleep();
	helper.SetValueByID("FromDate","06-06-2016");
	helper.DeepSleep();
	helper.SetValueByID("ToDate","06-06-2016");
	helper.DeepSleep();
	helper.ClickByXpath("//*[@id='btnGo']");
	helper.DeepSleep();
	//click on trialbalance
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[1]/a");
	helper.DeepSleep();
	//click on balance sheet
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[2]/a");
	helper.DeepSleep();
	//click on income and expenditure
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[3]/a");
helper.DeepSleep();
//click on daybook
helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[5]/a");
	
	//click on export
	helper.ClickByXpath("html/body/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[3]/div/button");
	helper.DeepSleep();
	//click on pdf
	helper.ClickByXpath("html/body/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[3]/div/ul/li[1]/a");
	
			}

}
