package dashboard;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;

public class MemberMyResidents extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->MemberMyResidents", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.DeepSleep();
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.DeepSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.DeepSleep(); 
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
Reporter.log("Login Sucessfull", true);
}
@Test(priority=2)
public void SendSMS() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.MyResidentsButton);
helper.DeepSleep();
Reporter.log("Only Able To See Data", true);
helper.TakeScreenShot("MemberMyResidents");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberMyResidents", true);
Reporter.log(" ", true);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectOwnerNameInSearchOptions);
Thread.sleep(4000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberName);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(5000);
try{
if(helper.GetValueByXpath(VariableCalling.MemberNameInMyResidents).equals(GlobalVariablesCalling.EnterMemberName)){
Reporter.log("Search Function Working Fine. ", true);
helper.TakeScreenShot("Search with Member Name in residents");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search with Member Name in residents", true);
Reporter.log(" ", true);
Reporter.log("-----------------------------", true);

}}
catch(NoSuchElementException e){
Reporter.log("Eaither Search Function Not Working For Member OR Member Not Found In My Residents", true);
}}}
