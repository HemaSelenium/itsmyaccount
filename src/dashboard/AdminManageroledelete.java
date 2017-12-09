package dashboard;

import org.junit.Test;

import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;

public class AdminManageroledelete extends TestBase {
	@Test
	public void manageroledelete()throws Exception{
		
	helper.Navigate(GlobalVariablesCalling.EnterUrl);
	//send userid
	helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
	//send password
	helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
	helper.ClickByID("VariableCalling.SelectTermsAndConditions");
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.LoginButton);
	helper.DeepSleep();
	//click on managerole
	helper.ClickByXpath(".//*[@id='901']/div/img");
	helper.DeepSleep();
	//selecting data 1 row
	helper.ClickByID("jqg_Grid_7");
	helper.DeepSleep();
	//click on delete 
	helper.ClickByID("Delete");
	helper.ProcessAlert();
}
}