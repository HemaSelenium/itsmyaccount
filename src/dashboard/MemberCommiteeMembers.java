package dashboard;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
 
public class MemberCommiteeMembers extends TestBase{
@Test(priority=1)
public void Login() throws InterruptedException{
Reporter.log("Script Name:Member---->Application--->CommiteeMembers", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
		}
@Test(priority=2)
public void ComiteeMebers() throws InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
helper.DeepSleep();
Method4.CompareMAnagemebersAndCommiteeMembers();
}
@Test(priority=3)
public void Search() throws InterruptedException, IOException{
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();	
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnCommiteeMembersButton);
helper.DeepSleep();
String Designation=helper.GetValueByXpath(VariableCalling2.DesignationOfCommiteeMembers);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInCommiteemembers,Designation);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
File SearchInMemberCommiteeMembers=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SearchInMemberCommiteeMembers, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchInMemberCommiteeMembers.png"));
helper.DeepSleep();
try{
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
String MailIdOfCommiteeMember=helper.GetValueByXpath(VariableCalling2.MailIdOfCommiteeMember);
helper.ClickByID(VariableCalling.ClickOnEmailButton);
helper.DeepSleep();
helper.SetValueByID("Subject", GlobalVariablesCalling.EnterMailSubjectInCommiteeMembers);
helper.SetValueByID("Message", GlobalVariablesCalling.EnterMessageOfmailInCommiteemembers);
helper.ClickByXpath(VariableCalling.ClickOnSendMailButtonInCommiteeMembers);
try 
{ 
helper.ProcessAlert(); 
Reporter.log("Mail Sent To CommiteeMemberOf : "+MailIdOfCommiteeMember, true);	
}   // try 
catch (NoAlertPresentException Ex) 
{ 
Reporter.log("Mail Unable To Sent To CommiteeMemberOf : "+MailIdOfCommiteeMember, true);	
File SendMailToComiteememberThroughMemberLogin=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SendMailToComiteememberThroughMemberLogin, new File(GlobalVariablesCalling.ScreenShotsFileName+"SendMailToComiteememberThroughMemberLogin.png"));	
Reporter.log("While Sending Mail To CommiteeMember Using MemberLogin Autherization Message Displayed As :  "+helper.GetValueByXpath(VariableCalling2.AutherizationMessageInCommiteeMembers), true);	
SeleniumHelper.driver.navigate().back();
helper.DeepSleep();
}  

}
catch(NoSuchElementException e){
Reporter.log("Unable To Select CommiteeMember Or SearchNot Working ", true);	
}

File MemberCommiteeMembers=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberCommiteeMembers, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberCommiteeMembers.png"));	
}
@Test(priority=4)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{

helper.ClickByXpath(VariableCalling.ClickOnExportButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnPDFButton);
helper.DeepSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberCommiteeMembersPDF.png"));
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminCommiteeMembers.png" + " MemberCommiteeMembers", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchInMemberCommiteeMembers.png" + "SearchInMemberCommiteeMembers", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberCommiteeMembersPDF.png" + "MemberCommiteeMembersPDF", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SendMailToComiteememberThroughMemberLogin.png" + "SendMailToComiteememberThroughMemberLogin", true);	
Reporter.log(" ", true);	
	}

}
