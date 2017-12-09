package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class MembermaintainanceTeamMembers extends TestBase{
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->MaintenanceTeammembers", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);	
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnMaintenanceTeam);
helper.MaxSleep();
File MemberMaintenanceTeamMembers=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberMaintenanceTeamMembers, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberMaintenanceTeamMembers.png"));
Reporter.log("Maintenance Team Members Details Are Only AbleTo View", true);	
}
@Test(priority=2) 
public void SearchFunction() throws InterruptedException{	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.SelectIsNotNullOptionInSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
}
@Test(priority=3)
public void Export() throws InterruptedException, HeadlessException, AWTException, IOException{
helper.ClickByXpath(VariableCalling. ClickOnExportButtonInMaintenanceMembers);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInMaintenanceMembers);
helper.MaxSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberMaintenceTeamMembersPdf .png"));
}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberMaintenanceTeamMembers.png" + "  MemberMaintenanceTeamMembers", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberMaintenceTeamMembersPdf.png" + " MemberMaintenceTeamMembersPdf", true);	
Reporter.log(" ", true);	
}








}