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
public class MemberRegularVendor extends TestBase{
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Member---->Application--->RegularVendors", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);					
}
@Test(priority=2)
public void RegularVendorsData() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnRegularVendorsButton);
Thread.sleep(4000);
Reporter.log("Regular Vendor List Is Able to View", true);	
File MemberRegularVendor=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberRegularVendor, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberRegularVendor.png"));
Thread.sleep(3000);
 
}
@Test(priority=3)
public void Search() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectVendorNameInSearchFunctions);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectIsNotNullOptionInSearch);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
File SearchFunctionOfNotNullInMemberRegularVendor=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SearchFunctionOfNotNullInMemberRegularVendor, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchFunctionOfNotNullInMemberRegularVendor.png"));

}
@Test(priority=4)
public void Export() throws IOException, HeadlessException, AWTException, InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInRegularVendors);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInRegularVendors);
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberRegularVendorsPdf .png"));
}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberRegularVendor.png" + "  MemberRegularVendor", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchFunctionOfNotNullInMemberRegularVendor.png" + " SearchFunctionOfNotNullInMemberRegularVendor", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberRegularVendorsPdf .png" + " MemberRegularVendorsPdf", true);	
Reporter.log(" ", true);	
}


}


