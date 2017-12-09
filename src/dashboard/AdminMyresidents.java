package dashboard;
import java.io.File;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
public class AdminMyresidents extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->MyResidents", true);		
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
public void SendSMS() throws InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.MyResidentsButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectOwnerNameInSearchOptions);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
try{
if(helper.GetValueByXpath(VariableCalling.MemberNameInMyResidents).equals(GlobalVariablesCalling.EnterMemberName)){
helper.ClickByID(VariableCalling.SelectOneMember);
helper.ClickByID(VariableCalling.ClickOnSmsButton);	
helper.DeepSleep();
helper.SetValueByID("Message", GlobalVariablesCalling.EnterMessageInMyResidents);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSendSmsButton);
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException e){
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
}
}
}
catch(NoSuchElementException e){
Reporter.log("Eaither Search Function Not Working For Identifing Member OR Member Not Found In My Residents", true);		

	}

	}
@Test(priority=3)
public void SendMailWithAttachment() throws InterruptedException {
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectOwnerNameInSearchOptions);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
try{
if(helper.GetValueByXpath(VariableCalling.MemberNameInMyResidents).equals(GlobalVariablesCalling.EnterMemberName)){
helper.ClickByID(VariableCalling.SelectOneMember);
helper.ClickByID(VariableCalling.ClickOnEmailButton);
helper.DeepSleep();
helper.SetValueByID("Subject", GlobalVariablesCalling.EnterSubjectOfMailInMyResidents);
helper.SetValueByID("Message", GlobalVariablesCalling.EnterMessageInMyResidents);
helper.ExecuteScript(VariableCalling.FileDisplayTypeAsLine);
helper.SetValue1("fileinput", VariableCalling.SelectFileToAttach);
helper.ExecuteScript(VariableCalling.FileDisplayTypeAsNone);
helper.ClickByXpath(VariableCalling.ClickOnSendEmailButton);
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException e){
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
}
}}
catch(NoSuchElementException e){
Reporter.log("Eaither Search Function Not Working For Member OR Member Not Found In My Residents", true);		
	}
		}
@Test(priority=4)
public void SendMailwithoutAttachment() throws InterruptedException {
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectOwnerNameInSearchOptions);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
try{
if(helper.GetValueByXpath(VariableCalling.MemberNameInMyResidents).equals(GlobalVariablesCalling.EnterMemberName)){
helper.ClickByID(VariableCalling.SelectOneMember);
helper.ClickByID(VariableCalling.ClickOnEmailButton);
helper.DeepSleep();
helper.SetValueByID("Subject", GlobalVariablesCalling.EnterSubjectOfMailInMyResidents);
helper.SetValueByID("Message", GlobalVariablesCalling.EnterMessageInMyResidents);
helper.ClickByXpath(VariableCalling.ClickOnSendEmailButton);
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException e){
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
}
}}
catch(NoSuchElementException e){
Reporter.log("Eaither Search Function Not Working For Member OR Member Not Found In My Residents", true);	
	}
		}	
@Test(priority=5)
public void SortingOccupancy() throws Exception{
helper.RefreshPage();
helper.Sleep();
Reporter.log("Occupany Types of Member Before Sorting Are", true);	
helper.Sleep();
File OccupancyOfMembersBeforeSortingInMyResidents=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(OccupancyOfMembersBeforeSortingInMyResidents, new File(GlobalVariablesCalling.ScreenShotsFileName+"OccupancyOfMembersBeforeSortingInMyResidents .png"));
Method.OccupancyOfMembers();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnOccupancyTypeColoumn);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnOccupancyTypeColoumn);
helper.Sleep();
Reporter.log("Occupany Types of Member After Sorting Are", true);	
helper.MaxSleep();
File OccupancyOfMembersAfterSortingInMyResidents=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(OccupancyOfMembersAfterSortingInMyResidents, new File(GlobalVariablesCalling.ScreenShotsFileName+"OccupancyOfMembersAfterSortingInMyResidents .png"));
Method.OccupancyOfMembers();
helper.DeepSleep();	
SeleniumHelper.driver.findElement(By.id("Block")).sendKeys(GlobalVariablesCalling.EnterMemberBlockName);
SeleniumHelper.driver.findElement(By.id("Block")).sendKeys(Keys.ENTER);
helper.DeepSleep();
Method3.VerifyingSelectFunctionality();
helper.DeepSleep();
Method.FirstRowMemberdetails();
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
helper.DeepSleep();
Method4.CompareManageMembersANdMyResidents();
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"OccupancyOfMembersBeforeSortingInMyResidents.png" + "  OccupancyOfMembersBeforeSortingInMyResidents", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"OccupancyOfMembersAfterSortingInMyResidents .png" + " OccupancyOfMembersAfterSortingInMyResidents ", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"VerifyingSelectFunctionInMyResidents.png" + "  VerifyingSelectFunctionInMyResidents", true);
Reporter.log(" ", true);
Reporter.log("Items to be checked Manually", true);
Reporter.log("-----------------------------", true);
Reporter.log("SMS Status", true);
Reporter.log("Mail Status", true);
Reporter.log(" ", true);

		}
	}

			
