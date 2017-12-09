package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberSocietyMeetingCalendar extends TestBase{
@Test(priority=1)
public void Login() throws InterruptedException{
Reporter.log("Script Name:Member---->Application--->SocietyMeetingCalander", true);	
Reporter.log("------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
}
@Test(priority=2)
public void WithoutSmsAndEnableEmail() throws InterruptedException, HeadlessException, IOException, AWTException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyMeetingCalanderButton);
Thread.sleep(4000);
Method2.ClickOnColourOfEvent();
helper.TakeScreenShotOfWindowPopUp("Member Society Meeting Calendar Events ");
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Member Society Meeting Calendar Events " , true);
}
}
 