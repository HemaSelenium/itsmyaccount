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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminCommiteeMembers extends TestBase{
@Test(priority=1)
public void Login() throws InterruptedException{
Reporter.log("Script Name:Admin---->Application--->CommiteeMembers", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
Thread.sleep(4000);
}@Test(priority=2)
public void ComiteeMebers() throws InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
Thread.sleep(3000);
Method4.CompareMAnagemebersAndCommiteeMembers();
}
@Test(priority=3)
public void Search() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnCommiteeMembersButton);
Thread.sleep(3000);
String Designation=helper.GetValueByXpath(VariableCalling2.DesignationOfCommiteeMembers);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.SetValueByID(VariableCalling2.EnterDataToSearchInCommiteemembers,Designation);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
File SearchInAdminCommiteeMembers=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SearchInAdminCommiteeMembers, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchInAdminCommiteeMembers.png"));
Thread.sleep(4000);
try{
helper.ClickByID(VariableCalling.SelectRow);
Thread.sleep(3000);
String MailIdOfCommiteeMember=helper.GetValueByXpath(VariableCalling2.MailIdOfCommiteeMember);
helper.ClickByID(VariableCalling.ClickOnEmailButton);
helper.DeepSleep();
helper.SetValueByID("Subject", GlobalVariablesCalling.EnterMailSubjectInCommiteeMembers);
helper.SetValueByID("Message", GlobalVariablesCalling.EnterMessageOfmailInCommiteemembers);
helper.ClickByXpath(VariableCalling.ClickOnSendMailButtonInCommiteeMembers);
helper.DeepSleep();
helper.DeepSleep();
helper.ProcessAlert();
Reporter.log("Mail Sent To CommiteeMemberOf : "+MailIdOfCommiteeMember, true);	
}
catch(NoSuchElementException e){
Reporter.log("Unable To Select CommiteeMember Or SearchNot Working And Mail Unable To Send", true);		
}
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
File AdminCommiteeMembers=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AdminCommiteeMembers, new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminCommiteeMembers.png"));
}
@Test(priority=4)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling.ClickOnExportButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnPDFButton);
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminCommiteeMembersPDF.png"));
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminCommiteeMembers.png" + " AdminCommiteeMembers", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminCommiteeMembersPDF.png" + "AdminCommiteeMembersPDF", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchInAdminCommiteeMembers.png" + "SearchInAdminCommiteeMembers", true);	
Reporter.log(" ", true);	
Reporter.log("Items to be checked Manually", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("Mail Status ", true);	
Reporter.log(" ", true);	
}
}
