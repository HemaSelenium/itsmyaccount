package dashboard;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;

public class Errornotifications extends TestBase {
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Dashboard--->Errornotifications", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);	    
}
@Test(priority=2)
public void ErrorNotifications() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.ClickByID(VariableCalling.ClickOnErrorNotificationsButton);
Thread.sleep(4000);
Reporter.log("Error Notifications Are Ready To View ", true);
File ErrorNotifications=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ErrorNotifications, new File(GlobalVariablesCalling.ScreenShotsFileName+"ErrorNotifications.png"));
helper.ClickByID(VariableCalling.ClickOnCloseButton);	
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ErrorNotifications.png", true);
	}
}
