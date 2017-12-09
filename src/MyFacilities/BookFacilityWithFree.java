package MyFacilities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.DataProvider4;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class BookFacilityWithFree extends TestBase{
@Test(priority=1,dataProvider="FacilityWithFree",dataProviderClass= DataProvider4.class)
public void BookingFacilityByAdmin(String EnterFacilityNameToSearch) throws InterruptedException, IOException{
Reporter.log("ScriptName:AdminLogin ---->Application--->Facility--> Book(FacilityWithFree)", true);	
Reporter.log("----------------------------------------------------------------------------", true);
Reporter.log(" ", true);
String FacilityName=EnterFacilityNameToSearch;
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
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
helper.SetValueByID(VariableCalling2.EnterDataToSearch, FacilityName);
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
Reporter.log("Added Free Facility Found Sucessfully", true);
helper.TakeScreenShot("FacilityWithFreeAnd Not Allow For Booking");}
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
if(PriceDetailsButton.equals("Free")){
if(BookingButton.equals("Book / Cancel")){
Reporter.log("Booking Is Allowed", true);
FacilityColoumns.get(11).findElement(By.tagName("button")).click();
helper.DeepSleep();
helper.TakeScreenShot("Booking Allowing For Facility With Free And with Not Allow For Booking");
Reporter.log("Booking Allowing For Facility With Free And with Not Allow For Booking", true);
}}			
}catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available So booking Is Not Allowed For This Facility", true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
helper.TakeScreenShot("Booking Not Allowed For Facility With FreeAnd With Not Allow For Booking");
}}catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FacilityWithFreeAnd Not Allow For Booking" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Booking Not Allowed For Facility With FreeAnd With Not Allow For Booking",true);
Reporter.log(" ", true);
	}

@Test(priority=2,dataProvider="FacilityWithFree",dataProviderClass= DataProvider4.class)
public void BookingFacilityByMember(String EnterFacilityNameToSearch) throws InterruptedException, IOException{
Reporter.log("ScriptName:MemberLogin ---->Application--->Facility--> Book(FacilityWithFree)", true);	
Reporter.log("----------------------------------------------------------------------------", true);
Reporter.log(" ", true);
String FacilityName=EnterFacilityNameToSearch;
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
helper.SetValueByID(VariableCalling2.EnterDataToSearch, FacilityName);
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
Reporter.log("Added Free Facility Found Sucessfully", true);
helper.TakeScreenShot("FacilityWithFreeAnd Not Allow For Booking WithMemberLogin");}
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
if(PriceDetailsButton.equals("Free")){
if(BookingButton.equals("Book / Cancel")){
Reporter.log("Booking Is Allowed", true);
FacilityColoumns.get(11).findElement(By.tagName("button")).click();
helper.DeepSleep();
helper.TakeScreenShot("Booking Allowing For Facility With Free And with Not Allow For Booking WithMemberLogin");
Reporter.log("Booking Allowing For Facility With Free And with Not Allow For Booking WithMemberLogin", true);
}}			
}catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available So booking Is Not Allowed For This Facility", true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
helper.TakeScreenShot("Booking Not Allowed For Facility With FreeAnd With Not Allow For Booking WithMemberLogin");
}}catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FacilityWithFreeAnd Not Allow For Booking WithMemberLogin" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Booking Not Allowed For Facility With FreeAnd With Not Allow For Booking WithMemberLogin",true);
Reporter.log(" ", true);
	}































}
