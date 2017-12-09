package dashboard;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
public class Templates extends TestBase{
	@Test(priority=1)
	public void Login() throws Exception{
	helper.Navigate(GlobalVariablesCalling.EnterUrl);
	helper.SetValueByID("UserName", GlobalVariablesCalling.EnterAdminUserId);
	helper.SetValueByID("Password", GlobalVariablesCalling.EnterAdminPassword);
	helper.ClickByID(VariableCalling.SelectTermsAndConditions);
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.LoginButton);
	Thread.sleep(4000);
	}
@Test(priority=2)
public void TemplatesDownloads() throws Exception{
	
	helper.ClickByXpath(".//*[@id='SocietyAdmin']/div[2]/div[3]/div[2]/div/div/ol/li[1]/a");
	Thread.sleep(4000);
	//MethodCalling3.FirefoxDriverProfile();
}
}

 