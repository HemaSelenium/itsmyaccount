package dashboard;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
public class MemberContactIMAHelpDesk extends TestBase {
@Test(priority=1)
public void ContactIMA() throws InterruptedException{
Reporter.log("Script Name:Member---->DashBoard---->ContactIMAHelpDesk", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
}
@Test(priority=2,dataProvider="ContactIMAHelpDesk",dataProviderClass= DataProvider3.class)
public void SendMailWithoutAttachMent(String EnterSubject,String EnterMessageInContactUsPage ){
helper.ClickByID(VariableCalling.ClickOnContactIMAHelpDeskButton);
helper.ClearElementByname(VariableCalling.ClearDefaultMailId);
helper.Sleep();
helper.SetValueByname("Email", GlobalVariablesCalling.EnterMemberMailId);
helper.ClearElementByname(VariableCalling.ClearDefaultContactNumber);
helper.Sleep();
helper.SetValueByname("Contact", GlobalVariablesCalling.EnterMemberContactNumber);
helper.SetValue1("Subject", EnterSubject);
helper.SetValueByID("Message", EnterMessageInContactUsPage);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSentEmailButton);
helper.MaxSleep();
DesiredCapabilities SentMailPopUp=new DesiredCapabilities();
SentMailPopUp.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
helper.MaxSleep();
Reporter.log("Mail Send Sucessfully Without Attachment", true);	
helper.DeepSleep();
}
@Test(priority=3,dataProvider="ContactIMAHelpDesk",dataProviderClass= DataProvider3.class)
public void SendMailWithAttachment(String EnterSubject,String EnterMessageInContactUsPage) throws InterruptedException{
helper.Init();
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnContactIMAHelpDeskButton);
helper.MaxSleep();
helper.ClearElementByname(VariableCalling.ClearDefaultMailId);
Thread.sleep(2000);
helper.SetValueByname("Email", GlobalVariablesCalling.EnterMemberMailId);
helper.ClearElementByname(VariableCalling.ClearDefaultContactNumber);
Thread.sleep(2000);
helper.SetValueByname("Contact", GlobalVariablesCalling.EnterMemberContactNumber);
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
DesiredCapabilities SentMailPopUp=new DesiredCapabilities();
SentMailPopUp.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
helper.MaxSleep();
Reporter.log("Mail Send Sucessfully With Attachment", true);	
helper.Sleep();
Reporter.log(" ", true);	
Reporter.log("Manual Items To Be Check", true);	
Reporter.log("-------------------------", true);	
Reporter.log("Check whether Mail Send To support@itsmyaccount.com ", true);	
Reporter.log(" ", true);	
}}
