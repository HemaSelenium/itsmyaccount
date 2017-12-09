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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class Membercurrentevents extends TestBase {
@Test(priority=1)
public void Login(){
Reporter.log("Script Name:Member---->Application--->CurrentEvents", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
	                 }
@Test(priority=2)
public void MemberCurrentEvents() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling2.ClickOnCurrentEventsButton);
Thread.sleep(4000);
Reporter.log("Current Event List Is Able to View,Verify In ScreenShot", true);
File MemberCurrentEvents=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberCurrentEvents, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberCurrentEvents.png"));

}
@Test(priority=3)
public void Search() throws InterruptedException, IOException{
	try{
String TypeOfEventInFirstRow=helper.GetValueByXpath(VariableCalling2.TypeOfEventInFirstRow);
Reporter.log("Searching For Current Event Of: "+TypeOfEventInFirstRow, true);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling2.SelectTypeInSearchFunction);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.EnterDataToSearch,TypeOfEventInFirstRow );
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
File SearchingEventInMemberCurrentEvents=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SearchingEventInMemberCurrentEvents, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchingEventInMemberCurrentEvents.png"));
}
catch(NoSuchElementException e){
Reporter.log("No data available In tis section", true);		
	}
	
	
	}
@Test(priority=4)  
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling.ClickExportButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickPdfButton);
Thread.sleep(4000);
Reporter.log("All Data In List Exported Into Pdf ", true);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberCurrentEventsPdf.png"));
}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberCurrentEvents.png" + "  MemberCurrentEvents", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchingEventInMemberCurrentEvents.png" + " SearchingEventInMemberCurrentEvents", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberCurrentEventsPdf.png" + " MemberCurrentEventsPdf", true);
Reporter.log(" ", true);

}}
