package MyFacilities;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider6;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class CancelOwnerFacility extends TestBase{
@Test(dataProvider="CancelOwnerFacility",dataProviderClass=DataProvider6.class)
public void CancelFacility(String AdddedFacilityName,String FacilityName,String DescriptionOfFacility) throws InterruptedException, IOException, HeadlessException, AWTException{
Reporter.log("ScriptName:Member Login (Owner) - Community (O) Booked for 1 hour (9:00 to 10:00 AM)  - Cancel", true);	
Reporter.log("----------------------------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
helper.ClickElementByCssSelector(VariableCalling2.FacilityButton);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.EnterDataToSearch, AdddedFacilityName);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String FacilityNames=FacilityColoumns.get(2).getText();
if(FacilityNames.equals(FacilityName)){
Reporter.log("Added Free Facility Found Sucessfully", true);
FacilityColoumns.get(11).findElement(By.tagName("button")).click();
helper.MaxSleep();
helper.DeepSleep();
Method6.CancelFacility(DescriptionOfFacility);
helper.DeepSleep();
helper.TakeScreenShotOfWindowPopUp("AfterClickedOnCancelButtonOfOwnerFacility");
try{
helper.ProcessAlert();
helper.MaxSleep();
helper.TakeScreenShot("FacilityCalendarAfterCancelOwnerFacility");
Reporter.log("Meeting Cancelled", true);
}
catch(NoAlertPresentException e){
Reporter.log("facility Cancellation Popup not came", true);
}}
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterClickedOnCancelButtonOfOwnerFacility", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FacilityCalendarAfterCancelOwnerFacility", true);
Reporter.log(" ", true);
Reporter.log("Items To Be Checked Manually", true);
Reporter.log("---------------------------", true);	
Reporter.log(" SMS and Soft copy (With Financial Posting) Member and Moderator", true);
Reporter.log(" Cancellation Charges of Rs. 0 to be posted (Another Soft copy of the invoice to be sent ONLY to Member)", true);
Reporter.log("Check Colour Of Cancel Event In screenshot", true);
	}

}
