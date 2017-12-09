package dashboard;
import java.io.IOException;
import org.openqa.selenium.By;
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
public class ResetPassword extends TestBase{
@Test
public void PasswordReset() throws InterruptedException, IOException{
Reporter.log("Script Name:Admin---->Dashboard--->Reset Password--->Member login after PW reset", true);
Reporter.log("--------------------------------------------------", true);
Reporter.log(" ", true);
helper.MaxSleep();
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.Sleep();
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.Sleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.Nap();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnResetPasswordButton);
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.id("auto_UserName")).clear();
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("auto_UserName")).sendKeys(GlobalVariablesCalling.EnterMemberUserId);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnResetPassword);
helper.DeepSleep();
try{
helper.RefreshPage();	
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);	
}
helper.Sleep();
helper.Navigate("http://www.gmail.com");
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling2.MailIdLocation, GlobalVariablesCalling.EnterMemberMailId);
helper.MaxSleep();
helper.ClickByID(VariableCalling2.ClickOnNextButton);
helper.MaxSleep();
helper.SetValueByXpath(VariableCalling2.PasswordLocation, GlobalVariablesCalling.EnterMemberMailPassword);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSignInButton);
helper.MaxSleep();
helper.DeepSleep();
String EnterPassword=Method2.IdentifyResetUserpasswordInMailInbox();
//Reporter.log("password: "+EnterPassword, true);
helper.MaxSleep();
Reporter.log("New Password Sent Through Mail Is : "+EnterPassword, true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);  
helper.MaxSleep();
helper.SetValueByID("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.MaxSleep();
helper.SetValueByID("Password", EnterPassword);
helper.MaxSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.TakeScreenShot("LoginAfterPasswordReset");
String CurrentUrl=SeleniumHelper.driver.getCurrentUrl();
helper.MaxSleep();
if (CurrentUrl.equals(GlobalVariablesCalling.HomePageUrl)){
helper.MaxSleep();
Reporter.log("Login Sucessfull With New Login Id,Password", true);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnChangePasswordButton);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling2.OldPasswordLocation, EnterPassword);
helper.Sleep();
helper.SetValueByID("newpassword", GlobalVariablesCalling.EnterMemberPassword);
helper.Sleep();
helper.SetValueByID("retype", GlobalVariablesCalling.EnterMemberPassword);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonForChangePassword);
helper.MaxSleep();
String CurrentUrlOfApplicationPage=SeleniumHelper.driver.getCurrentUrl();
helper.MaxSleep();
if (CurrentUrlOfApplicationPage.equals(GlobalVariablesCalling.ApplicationHomePage)){
helper.MaxSleep();
helper.Navigate(GlobalVariablesCalling.EnterUrl);  
helper.MaxSleep();
helper.SetValueByID("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.MaxSleep();
helper.SetValueByID("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.MaxSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
String LoginPageAfterChangedPassword=SeleniumHelper.driver.getCurrentUrl();
if (LoginPageAfterChangedPassword.equals(GlobalVariablesCalling.HomePageUrl)){	
helper.TakeScreenShot("LoginAfterChangePassword");	
Reporter.log("Password Changed Sucessfully", true);
Reporter.log( "New UserId Is :"  +GlobalVariablesCalling.EnterMemberUserId+ "\nNew Password Is : "+GlobalVariablesCalling.EnterMemberPassword, true);
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"LoginAfterPasswordReset", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"LoginAfterChangePassword", true);
Reporter.log("Items to be checked Manually", true);
Reporter.log("-----------------------------", true);
Reporter.log("Auto Email To Be Triggered To Member Mail Of :  "+GlobalVariablesCalling.EnterMemberMailId, true);
Reporter.log(" ", true);
 }else{
Reporter.log("Login Failed With ChangedPassword", true);
  }	} 
else{
Reporter.log("6)Password Unable To Change", true);
}}
else{
Reporter.log("5)Login Failed With New Credentials", true);
}}}
