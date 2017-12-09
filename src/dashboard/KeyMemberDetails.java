package dashboard;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class KeyMemberDetails extends TestBase{
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Dashboard--->KeyMemberDetails", true);	
Reporter.log("--------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2)
public void KeyMemberDetailsInApplication() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Reporter.log("1)KeyMember Details In Application Are: ", true);
System.out.println();
String ModeratorName=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetModeratorNameOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
String ModeratorContactNumber=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetModeratorContactNumberOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
String ModeratorMailId=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetModeratorMailIdOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
Reporter.log("Moderator     "  +   ModeratorName  +  "     "  +     ModeratorContactNumber    +  "    "  +  ModeratorMailId, true);

String KeyContact1Name=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetKeyContact1NameOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
String KeyContact1ContactNumber=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetKeyContact1ContactNumberOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
String KeyContact1MailId=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetKeyContact1MailIdOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
Reporter.log("KeyContact 1  "  +   KeyContact1Name  +  "      "   +    KeyContact1ContactNumber    +   "    "   +  KeyContact1MailId, true);
String KeyContact2Name=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetKeyContact2OfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
String KeyContact2ContactNumber=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetKeyContact2ContactNumberOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
String KeyContact2MailId=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.GetKeyContact2MailIdOfKeyMemberDetailsInApplication)).getAttribute(VariableCalling2.GetDataInField);
Reporter.log("KeyContact 2  "  +   KeyContact2Name  +  "  "   +    KeyContact2ContactNumber    +   "    "   +  KeyContact2MailId, true);
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.DeepSleep();
helper.Sleep();
WebElement KeymemberDetailsInDashBoard=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyingKeyMemberDetailsLocationInDashBoard));
List<WebElement>Details=KeymemberDetailsInDashBoard.findElements(By.tagName(VariableCalling2.IdentifyingKeyMemberDetailsInDashBoard));
Reporter.log(" ", true);
Reporter.log("2)KeyMemberDetails In DashBoard Before Editing :", true);
helper.Sleep();
String ModeratorDetailsInDashBoard=Details.get(1).getText();
Reporter.log(ModeratorDetailsInDashBoard, true);
String KeyContact1DetailsInDashBoard=Details.get(3).getText();
Reporter.log(KeyContact1DetailsInDashBoard, true);
String KeyContact2DetailsInDashBoard=Details.get(5).getText();
Reporter.log(KeyContact2DetailsInDashBoard, true);
File KeyMemberDetailsBeforeEditing=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(KeyMemberDetailsBeforeEditing, new File(GlobalVariablesCalling.ScreenShotsFileName+"KeyMemberDetailsBeforeEditing.png"));

helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClearOldContactNumberOfModeratorOfKeyMemberDetailsInApplication)).clear();
helper.Sleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClearOldContactNumberOfModeratorOfKeyMemberDetailsInApplication)).sendKeys(GlobalVariablesCalling.EnterNewContactNumberInModeratorOfKeyMemberDetails);
helper.ClickByXpath(VariableCalling2.ClickOnUpdateButton);
helper.DeepSleep();
helper.ProcessAlert();
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.MaxSleep();
WebElement KeymemberDetailsInDashBoardAfterEditing=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyingKeyMemberDetailsLocationInDashBoard));
List<WebElement>DetailsAfterEditing=KeymemberDetailsInDashBoardAfterEditing.findElements(By.tagName(VariableCalling2.IdentifyingKeyMemberDetailsInDashBoard));
Reporter.log(" ", true);
Reporter.log("3)Moderator Details In DashBoard  After Edited:", true);
String ModeratorDetailsInDashBoardAfterEditing=DetailsAfterEditing.get(1).getText();
Reporter.log(ModeratorDetailsInDashBoardAfterEditing, true);
File KeyMemberDetailsAfterEditing=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(KeyMemberDetailsAfterEditing, new File(GlobalVariablesCalling.ScreenShotsFileName+"KeyMemberDetailsAfterEditing.png"));
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"KeyMemberDetailsBeforeEditing.png" + "  KeyMember Details Before Editing", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"KeyMemberDetailsAfterEditing.png.png" + "  KeyMember Details After Editing", true);
Reporter.log(" ", true);
Reporter.log("Items to be checked Manually", true);
Reporter.log("-----------------------------", true);
Reporter.log("KeyMemberDetails In Application And DashBoard Both Should Be Same", true);
Reporter.log(" ", true);
}}
