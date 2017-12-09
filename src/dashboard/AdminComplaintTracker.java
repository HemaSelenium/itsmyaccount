package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminComplaintTracker extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->MyComplaints---->TrackComplaints", true);
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
}	
@Test(priority=2,dataProvider="CreateComplaint",dataProviderClass= Dataproviders.class)
public void AddComplaints(String EnterCategoryOfComplaint,String EnterDescriptionOfComplaint,String SelectPriority,String SelectStatusOfComplaint,String EnterDescriptionOfComplaintToSearch,String EnterDescriptionOfComplaintToVerify) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
Select AllCategories=new Select(SeleniumHelper.driver.findElement(By.id("Category")));
helper.Sleep();
List <WebElement> elementCount = AllCategories.getOptions();
for(int i =0; i<elementCount.size() ; i++){
String sValue = elementCount.get(i).getAttribute("value");
if(sValue.equals(EnterCategoryOfComplaint)){
SeleniumHelper.driver.findElement(By.id("auto_Category")).clear();
SeleniumHelper.driver.findElement(By.id("auto_Category")).sendKeys(sValue);
helper.Sleep();	
}
}
helper.SetValueByID("Description", EnterDescriptionOfComplaint);
helper.ClickByXpath(VariableCalling2.ClickOnBlockDropDownListInComplaints);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnApartmentNumbersDropDownListInComplaints);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnPriorityOfComplaintDropDownList);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(SelectPriority)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnStatusOfComplaintsDropDownList);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(SelectStatusOfComplaint)).click();
helper.Sleep();
try{
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
helper.Sleep();
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
}
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterDescriptionOfComplaintToSearch);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
String DescriptionOfComplaint=tablecoloumns.get(8).getText();
if(DescriptionOfComplaint.equals(EnterDescriptionOfComplaintToVerify)){
helper.Sleep();
Reporter.log("Complaint Added Sucessfully", true);
helper.TakeScreenShot("AddedComplaint");
String TicketNumberOfComplaint=tablecoloumns.get(2).getText();
Reporter.log("Ticket Number Of Complaints: "+TicketNumberOfComplaint, true);
helper.Sleep();
if(tablecoloumns.get(10).getText().equals("1")){
helper.Sleep();
Reporter.log("Complaint status Is In Red Colour", true);
}else{
Reporter.log("Complaint status Is Not In Red Colour", true);

}
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnComplaintTrackingButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectTicketNumberInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInComplaints, TicketNumberOfComplaint);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement ComplaintTrackerTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
List<WebElement> ComplaintTrackerTableRows = ComplaintTrackerTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
List<WebElement> ComplaintTrackerTableColoumns = ComplaintTrackerTableRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(ComplaintTrackerTableColoumns.get(0).getText().equals("Open")){
Reporter.log("Added Complaint Under Open Category", true);
helper.TakeScreenShot("Added Complaint Under Open Category");
}
else{
Reporter.log("Added Complaint Not In Open Category", true);
}
}
else{
Reporter.log("Complaint unable to Add", true);
}}
@Test(priority=3,dataProvider="ChangestatusOfComplaintToPicked",dataProviderClass= DataProviders2.class)
public void ChangeStatusOfComplaintToPicked(String SelectStatusOfComplaintToPicked,String EnterDescriptionOfComplaintToSearch,String EnterDescriptionOfComplaintToVerify,String EnterDescriptionOfComplaintToSearchAgain,String EnterDescriptionOfComplaintToVerifyAgain) throws InterruptedException, IOException{
System.out.println("entered into method");
WebElement ComplaintTrackerTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();

List<WebElement> ComplaintTrackerTableRows = ComplaintTrackerTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> ComplaintTrackerTableColoumns = ComplaintTrackerTableRows.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
ComplaintTrackerTableColoumns.get(2).click();
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnChangeStatusButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnStatusOfComplaintsDropDownList);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(SelectStatusOfComplaintToPicked)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
helper.MaxSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterDescriptionOfComplaintToSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement ComplaintTrackerTable1=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
List<WebElement> ComplaintTrackerTableRows1 = ComplaintTrackerTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
List<WebElement> ComplaintTrackerTableColoumns1 = ComplaintTrackerTableRows1.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
String DescriptionOfComplaint=ComplaintTrackerTableColoumns1.get(10).getText();
if(DescriptionOfComplaint.equals(EnterDescriptionOfComplaintToVerify)){
helper.Sleep();
List<WebElement> ComplaintTrackerTableRows2 = ComplaintTrackerTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> ComplaintTrackerColoumns = ComplaintTrackerTableRows2.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(ComplaintTrackerColoumns.get(0).getText().equals("Taken Up")){
helper.DeepSleep();
Reporter.log("Complaint Satus Of Picked Is Under Taken Up Category", true);
helper.TakeScreenShot("After Compalint status Changed To Picked");
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.DeepSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterDescriptionOfComplaintToSearchAgain);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
String DescriptionOfComplaintAfterChangeStatus=tablecoloumns.get(8).getText();
if(DescriptionOfComplaintAfterChangeStatus.equals(EnterDescriptionOfComplaintToVerifyAgain)){
helper.DeepSleep();
if(tablecoloumns.get(10).getText().equals("2")){
helper.Sleep();
Reporter.log("Complaint status Is In Amber Colour", true);
}else{
Reporter.log("Complaint status Is Not In Amber Colour", true);

}}}
else{
Reporter.log("Picked Satus Complaint Not Under Taken Up Category", true);

}}}
@Test(priority=4)
public void Export() throws InterruptedException, HeadlessException, IOException, AWTException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInComplaints);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInComplaints);
Thread.sleep(4000);
Reporter.log("Data Exported Into PDF", true);
helper.TakeScreenShotOfExportPDF("ComplaintsPDF");
	
}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);
Reporter.log("---------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedComplaint" +  "  AddedComplaint", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added Complaint Under Open Category" +  "  Added Complaint Under Open Category", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"After Compalint status Changed To Picked" +  "   After Compalint status Changed To Picked ", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ComplaintsPDF " +  "  ComplaintsPDF ", true);
Reporter.log(" ", true);
	
}




}





