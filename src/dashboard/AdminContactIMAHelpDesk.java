//without attach any file send email
package dashboard;
import java.io.IOException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;

public class AdminContactIMAHelpDesk extends TestBase{
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->DashBoard---->ContactIMAHelpDesk", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2,dataProvider="ContactIMAHelpDesk",dataProviderClass= DataProvider3.class)
public void SendMailWithoutAttachMent(String EnterSubject,String EnterMessageInContactUsPage ) throws IOException, InterruptedException{
helper.ClickByID(VariableCalling.ClickOnContactIMAHelpDeskButton);
helper.ClearElementByname(VariableCalling.ClearDefaultMailId);
helper.Sleep();
helper.SetValueByname("Email", GlobalVariablesCalling.EnterAdminEmailId);
helper.ClearElementByname(VariableCalling.ClearDefaultContactNumber);
helper.Sleep();
helper.SetValueByname("Contact", GlobalVariablesCalling.EnterAdminContactNo);
helper.SetValue1("Subject", EnterSubject);
helper.SetValueByID("Message", EnterMessageInContactUsPage);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSentEmailButton);
helper.MaxSleep();
try{
helper.RefreshPage();
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
Reporter.log("Mail Send Sucessfully Without Attachment", true);	
helper.DeepSleep();
helper.RefreshPage();
Thread.sleep(5000);
	}
}
@Test(priority=3,dataProvider="ContactIMAHelpDesk",dataProviderClass= DataProvider3.class)
public void SendMailWithAttachment(String EnterSubject,String EnterMessageInContactUsPage) throws InterruptedException, IOException{
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnContactIMAHelpDeskButton);
helper.MaxSleep();
helper.ClearElementByname(VariableCalling.ClearDefaultMailId);
Thread.sleep(2000);
helper.SetValueByname("Email", GlobalVariablesCalling.EnterAdminEmailId);
helper.ClearElementByname(VariableCalling.ClearDefaultContactNumber);
Thread.sleep(2000);
helper.SetValueByname("Contact", GlobalVariablesCalling.EnterAdminContactNo);
helper.SetValue1("Subject", EnterSubject);
helper.SetValueByID("Message", EnterMessageInContactUsPage);
helper.ExecuteScript(VariableCalling.FileDisplayTypeAsLine);
Thread.sleep(3000);
helper.SetValue1("fileinput", VariableCalling.SelectFileToAttach);
Thread.sleep(3000);
helper.ExecuteScript(VariableCalling.FileDisplayTypeAsNone);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnSentEmailButton);
Thread.sleep(2000);

try{
helper.RefreshPage();
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
Reporter.log("Mail Send Sucessfully With Attachment", true);
helper.DeepSleep();
}
	
helper.Sleep();
Reporter.log(" ", true);	
Reporter.log("Manual Items To Be Check", true);	
Reporter.log("-------------------------", true);	
Reporter.log("Check whether Mail Send To support@itsmyaccount.com ", true);	
Reporter.log(" ", true);	
	
	}}
