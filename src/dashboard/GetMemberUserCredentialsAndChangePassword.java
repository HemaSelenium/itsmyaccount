package dashboard;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class GetMemberUserCredentialsAndChangePassword extends TestBase{
@Test
public void GetcredentialsAndChangepassword() throws Exception{
Reporter.log("ScriptName:Member--->ForGetUserId---->ForgetPassword--->GetMemberUserCredentialsAndChangePassword", true);	
Reporter.log("---------------------------------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.ClickByXpath(VariableCalling2.ClickOnForgetUserId);
helper.MaxSleep();
helper.SetValueByID("email", GlobalVariablesCalling.EnterMemberMailId);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnGetUserIdButton);
helper.MaxSleep();
helper.ProcessAlert();
helper.MaxSleep();
helper.Navigate("http://www.gmail.com");
helper.MaxSleep();
helper.SetValueByXpath(VariableCalling2.MailIdLocation, GlobalVariablesCalling.EnterMemberMailId);
helper.MaxSleep();
helper.ClickByID(VariableCalling2.ClickOnNextButton);
helper.MaxSleep();
helper.SetValueByXpath(VariableCalling2.PasswordLocation, GlobalVariablesCalling. EnterMemberMailPassword);
helper.MaxSleep();

helper.ClickByXpath(VariableCalling2.ClickOnSignInButton);
helper.MaxSleep();
helper.MaxSleep();
SeleniumHelper.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
String EnterUserId= Method2.IdentifyUserIdInMailInbox();
helper.MaxSleep();
helper.MaxSleep();
helper.MaxSleep();
helper.Navigate(GlobalVariablesCalling.EnterUrl);   
Reporter.log("Naviagted to login page", true);	
helper.MaxSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnForgetPasswordButton);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterUserIdLocation,EnterUserId );
helper.MaxSleep();
helper.SetValueByID("email", GlobalVariablesCalling.EnterMemberMailId);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnGetPasswordButton);
helper.ProcessAlert();
helper.Sleep();
helper.Navigate("http://www.gmail.com");
helper.MaxSleep();
String EnterPassword=Method2.IdentifyUserpasswordInMailInbox();
helper.MaxSleep();
helper.MaxSleep();

try{
helper.Navigate(GlobalVariablesCalling.EnterUrl);  
helper.MaxSleep();	
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
}

Reporter.log("Naviagted to login page", true);	
helper.MaxSleep();
helper.SetValue1("UserName", EnterUserId);
helper.MaxSleep();
helper.SetValueByID("Password", EnterPassword);
helper.MaxSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
String CurrentUrl=SeleniumHelper.driver.getCurrentUrl();
helper.MaxSleep();
if (CurrentUrl.equals(GlobalVariablesCalling.HomePageUrl)){
helper.MaxSleep();
Reporter.log("Login Sucessfull With New Login Id,Password", true);	
}helper.ClickByXpath(VariableCalling2.ClickOnChangePasswordButton);
helper.MaxSleep();
helper.SetValueByXpath(VariableCalling2.OldPasswordLocation, EnterPassword);
helper.SetValueByID("newpassword", GlobalVariablesCalling.EnterMemberPassword);
helper.SetValueByID("retype", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonForChangePassword);
helper.MaxSleep();
String CurrentUrlOfApplicationPage=SeleniumHelper.driver.getCurrentUrl();
helper.MaxSleep();
if (CurrentUrlOfApplicationPage.equals(GlobalVariablesCalling.ApplicationHomePage)){
helper.MaxSleep();
Reporter.log("Password Changed Sucessfully", true);	
Reporter.log("New UserId Is :"  +EnterUserId+ "\nNew Password Is : "+GlobalVariablesCalling.EnterMemberPassword, true);	
}}}
