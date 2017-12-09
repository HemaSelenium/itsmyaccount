package MyFacilities;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider6;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class simulateFacilityOfRatesForBothWithOwnerLogin extends TestBase{
@Test(priority=1,dataProvider="SimulateRatesForBOTHFacility",dataProviderClass= DataProvider6.class)
public void BookingFacility(String EnterFacilityNameToSearch,String FacilityName,String EnterFromTime,String EnterToTime,String EnterDescription ) throws InterruptedException, IOException, HeadlessException, AWTException{
Reporter.log("ScriptName:Simulate BOTH Member Login (Owner) - Book for 3 hours (9 AM to 12 PM) - Should show Rs. 1500x3 = 4500", true);	
Reporter.log("----------------------------------------------------------------------------", true);
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
helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
try{
List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String FacilityNames=FacilityColoumns.get(2).getText();
if(FacilityNames.equals(FacilityName)){
Reporter.log("Added RatesForBOTH Facility Found Sucessfully", true);
}
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
if(PriceDetailsButton.equals("Show")){
if(BookingButton.equals("Book / Cancel")){
FacilityColoumns.get(11).findElement(By.tagName("button")).click();
helper.MaxSleep();
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.MaxSleep();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).clear();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).sendKeys(MethodsCalling.EnterTomorrowDate());
helper.MaxSleep();
helper.ClickOnTabButton("FromDate");
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromTime)).clear();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromTime)).sendKeys(EnterFromTime);
helper.DeepSleep();
helper.ClickOnTabButton("FromTime");
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).clear();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).sendKeys(MethodsCalling.EnterTomorrowDate());
helper.MaxSleep();
helper.ClickOnTabButton("ToDate");
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToTime)).clear();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToTime)).sendKeys(EnterToTime);
helper.ClickOnTabButton("ToTime");
helper.Sleep();	
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.Description)).sendKeys(EnterDescription);
helper.MaxSleep();
String TotalAmount=SeleniumHelper.driver.findElement(By.id("Total")).getAttribute("value");
Reporter.log("Total Amount Charged For Selected Period Of Time Is:" +TotalAmount, true);
helper.TakeScreenShot("Simulation Of BOTH Facility with Specified Timings With Member Login");
helper.DeepSleep();
}		}
}catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available So booking Is Not Allowed For This Facility", true);
String PriceDetailsButton1=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton1, true);
helper.TakeScreenShot("Booking Not Allowed For BOTH Facility With Owner Login");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Booking Not Allowed For OTH Facility With Owner Login", true);
}}catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added RatesForBOTH Facility Found Sucessfully" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Simulation Of BOTH Facility with Specified Timings With Member Login" , true);
Reporter.log(" ", true);
	}}
