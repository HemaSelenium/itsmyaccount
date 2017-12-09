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

public class Membervisitorregistor extends TestBase {
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Member---->Application--->VisitorRegister", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
Thread.sleep(3000);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
}
@Test(priority=2)
public void MemberVisitorRegister() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnVisitorRegestor);
Thread.sleep(4000);
Reporter.log("visitor Register Is Able to View", true);	
File MemberVisitorRegister=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberVisitorRegister, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberVisitorRegister.png"));
Thread.sleep(3000);
} 
@Test(priority=3)
public void Search() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.SelectIsNotNullOptionInSearch);
Thread.sleep(4000);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
File SearchFunctionInMemberVisitorRegister=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SearchFunctionInMemberVisitorRegister, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchFunctionInMemberVisitorRegister.png"));
}
@Test(priority=4)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling.ClickExportButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickPdfButton);
Thread.sleep(4000);
Reporter.log("visitor registor export to pdf", true);	
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberVisitorRegisterPdf .png"));			
}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberVisitorRegister.png" + " AddVisitorDetails", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchFunctionInMemberVisitorRegister.png" + " EditVisitorDetails", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberVisitorRegisterPdf .png" + " AdminVisitorRegisterPdf", true);	
Reporter.log(" ", true);	
	}

}