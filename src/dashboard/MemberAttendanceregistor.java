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

public class MemberAttendanceregistor extends TestBase{
@Test(priority=1)
public void AttendanceRegistor()throws Exception{
Reporter.log("Script Name:Member---->Application--->AttendanceRegister", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);	
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnAttendanceRegister);
helper.DeepSleep();
File MemberAttendanceRegister=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberAttendanceRegister, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberAttendanceRegister.png"));
}
@Test(priority=2)
public void Export() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInAttendanceregistor);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInAttendanceRegistor);
helper.DeepSleep();
File MemberAttendanceRegisterPdf=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberAttendanceRegisterPdf, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberAttendanceRegisterPdf.png"));
}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberAttendanceRegister.png" +  "  MemberAttendanceRegister", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberAttendanceRegisterPdf.png" + "  MemberAttendanceRegisterPdf", true);	
Reporter.log(" ", true);	
}
}
