package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminCurrentevents extends TestBase{
@Test(priority=1)
public void login() throws InterruptedException{
Reporter.log("Script Name:Admin---->Application--->CurrentEvents", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
	}
@Test(priority=2,dataProvider="AdminCurrentEvents",dataProviderClass= DataProviders2.class)
public void AddEvent(String EnterTypeOfEvent,String EnterFromTimeOfEvent,String EnterToTimeOfEvent,String EnterContactPersonName,String EnterContactPersonNo,String AmountForEvent,String EnterRemarks,String SearchingAddedEvent,String SearchForEventType,String EnterContactPersonNoToEdit,String SearchContactNumberAfterEdit,String SearchForEventTypeAfterEdit,String SearchForTypeOfEventAfterDelete) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling2.ClickOnCurrentEventsButton);
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("Type",EnterTypeOfEvent);
helper.ClearElementById(VariableCalling2.FromTime);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.FromTime,EnterFromTimeOfEvent);
helper.ClearElementById(VariableCalling2.ToTime);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.ToTime,EnterToTimeOfEvent);
helper.SetValueByID("ContactName",EnterContactPersonName);
helper.SetValueByID("ContactNo",EnterContactPersonNo);
helper.SetValueByID("Amount", AmountForEvent);
helper.SetValueByID("Remarks",EnterRemarks);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInCurrentEvents);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement CurrentEventsTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfCurrentEvents=CurrentEventsTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>EventType=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfCurrentEvents.size();Rows++){
List<WebElement>ColoumnsInRowsOfCurrentEvents=RowsOfCurrentEvents.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
EventType.add(ColoumnsInRowsOfCurrentEvents.get(2).getText());	
}
try{
if(EventType.contains(SearchingAddedEvent)){
Reporter.log("New Event Details Added sucessfully", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.SelectTypeInSearchFunction);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, SearchForEventType);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);	
String ContactNumber=helper.GetValueByXpath(VariableCalling.GetContactNumberOfEventMember);
Reporter.log("Contact Number Of Event Member Before Editing Is: "+ContactNumber, true);
helper.TakeScreenShot("AddedCurrentEvent");
helper.ClickByID(VariableCalling.SelectRow);
Thread.sleep(4000);
helper.ClickByID(VariableCalling.ClickOnEditButton);
Thread.sleep(4000);
helper.SetValueByID("ContactNo",EnterContactPersonNoToEdit);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInCurrentEvents);
WebElement CurrentEvents=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

List<WebElement>RowsOfEvents=CurrentEvents.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ConactNumberListAfterEdit=new ArrayList<String>();
for(int Row=1;Row<RowsOfEvents.size();Row++){
List<WebElement>ColoumnsInCurrentEvents=RowsOfEvents.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
ConactNumberListAfterEdit.add(ColoumnsInCurrentEvents.get(6).getText());	
}
if(ConactNumberListAfterEdit.contains(SearchContactNumberAfterEdit)){
Reporter.log("Contact Number In Newly Added Event Details Edited Sucessfully", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.SelectTypeInSearchFunction);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, SearchForEventTypeAfterEdit);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);	
String ContactNumberAfterEdit=helper.GetValueByXpath(VariableCalling.GetContactNumberOfEventMember);
Reporter.log("Contact Number Of Event Member After Edit Is: "+ContactNumberAfterEdit, true);
helper.TakeScreenShot("EditedCurrentEventDetails");
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(3000);
WebElement EventList=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>EventListRows=EventList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
List<String>TypeOfEvent=new ArrayList<String>();
for(int EventRows=1;EventRows<EventListRows.size();EventRows++){
List<WebElement>EventColoumns=EventListRows.get(EventRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
TypeOfEvent.add(EventColoumns.get(2).getText());	
}
if(TypeOfEvent.contains(SearchForTypeOfEventAfterDelete)){
Reporter.log("Added Event Type Unable To Delete ", true);	
}
else{
Reporter.log("Added Event Type Deleted Sucessfully ", true);	
}

}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement EventList=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>EventListRows=EventList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
List<String>TypeOfEvent=new ArrayList<String>();
for(int EventRows=1;EventRows<EventListRows.size();EventRows++){
List<WebElement>EventColoumns=EventListRows.get(EventRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
TypeOfEvent.add(EventColoumns.get(2).getText());	
}
if(TypeOfEvent.contains(SearchForTypeOfEventAfterDelete)){
Reporter.log("Added Event Unable To Delete ", true);	
}
else{
Reporter.log("Added Event Deleted Sucessfully ", true);	
}}
}
else{
Reporter.log("Contact Number Details Unable To Edit", true);	
}
}else{
Reporter.log("New Event Details Unable To Add", true);	
}
}
catch(NoSuchElementException e){
Reporter.log("Search For Added Event By Using Type In Search Function Is Failed", true);	
	
}
	}

@Test(priority=3)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling.ClickExportButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickPdfButton);
helper.DeepSleep();
Reporter.log("All Data In List Exported into Pdf", true);	
helper.TakeScreenShotOfExportPDF("AdminCurrentEventsPdf");
	}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedCurrentEvent", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedCurrentEventDetails", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminCurrentEventsPdf", true);	
Reporter.log(" ", true);	
}
}
