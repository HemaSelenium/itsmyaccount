package dashboard;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
public class Carparkinglots extends TestBase{
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->CarParkingLots", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.DeepSleep();
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.DeepSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
}
@Test(priority=2)
public void CarParkingLotsMemberDetails() throws Exception{
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnManageMembers)).click();
helper.DeepSleep();
Method3.CompareManageMembersANdCarparkingLotMembers();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnCarParkingLotsButton);
helper.DeepSleep();
Method.FirstRowMemberdetails();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnLogoutButton);
helper.DeepSleep();
}
@Test(priority=3)
public void SelectCarRentSpaceInProfile() throws InterruptedException, IOException{
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);				
helper.ClickByXpath(VariableCalling.ClickOnProfile);	
File MemberProfileBeforeSelectRentCarSpace=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile( MemberProfileBeforeSelectRentCarSpace, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberProfileBeforeSelectRentCarSpace.png"));
if (SeleniumHelper.driver.findElement(By.id(VariableCalling.ClickOnIsRentCarSpaceButton)).isSelected()) {	   
Reporter.log("5)Rentfor CarSpace Field Selected Already ", true);	
}
else  {
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnIsRentCarSpaceButton);
helper.SetValueByID("Rent", VariableCalling.EnterRentAmount);
helper.SetValueByID("Occupation", VariableCalling.EnterProfessionInMemberProfile);	
helper.SetValueByID("MembersInHouse", "1");
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonMemberProfile);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnProfile);			
if(SeleniumHelper.driver.findElement(By.id(VariableCalling.ClickOnIsRentCarSpaceButton)).isSelected()) {
Reporter.log("5)Rentfor CarSpace Field Selected ", true);
File MemberProfileAfterSelectRentCarSpace=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile( MemberProfileAfterSelectRentCarSpace, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberProfileAfterSelectRentCarSpace.png"));
}		  
else{
Reporter.log(" 5)Rentfor CarSpace  Unable To Selected", true);
} } }
@Test(priority=4)	
public void  Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberProfileBeforeSelectRentCarSpace.png", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberProfileAfterSelectRentCarSpace.png", true);
Reporter.log(" ", true);
Reporter.log("Items to be checked Manually", true);
Reporter.log("-----------------------------", true);
Reporter.log("Check Manually Whether RentCarspace Field Selected Or Not  ", true);
Reporter.log(" ", true);
Reporter.log(" ", true);
}}