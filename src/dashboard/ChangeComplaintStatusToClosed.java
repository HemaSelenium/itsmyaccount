package dashboard;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class ChangeComplaintStatusToClosed extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->MyComplaints---->TrackComplaints--->ChangeStatusToClosed", true);	
Reporter.log("---------------------------------------------------------------------------------------------", true);	
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
@Test(priority=2,dataProvider="ChangeComplaintStatusToClosed",dataProviderClass= DataProviders2.class)
public void ChangeStatusOfComplaintToClosed(String EnterDescriptionOfComplaintToSearchComplaint,String SelectStatusOfComplaintToClosed,String EnterDescriptionOfComplaintToSearch,String EnterDescriptionOfComplaintToVerify,String EnterFromDate,String EnterToDate,String EnterDescriptionOfComplaintToSearchAgain,String EnterDescriptionOfComplaintToVerifyAgain) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnComplaintTrackingButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterDescriptionOfComplaintToSearchComplaint);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement ComplaintTrackerTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> ComplaintTrackerTableRows = ComplaintTrackerTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> ComplaintTrackerTableColoumns = ComplaintTrackerTableRows.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
ComplaintTrackerTableColoumns.get(2).click();
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnChangeStatusButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnStatusOfComplaintsDropDownList);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.linkText(SelectStatusOfComplaintToClosed)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterDescriptionOfComplaintToSearch);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement ComplaintTrackerTable1=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement> ComplaintTrackerTableRows1 = ComplaintTrackerTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> ComplaintTrackerTableColoumns1 = ComplaintTrackerTableRows1.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
String DescriptionOfComplaint=ComplaintTrackerTableColoumns1.get(10).getText();
if(DescriptionOfComplaint.equals(EnterDescriptionOfComplaintToVerify)){
helper.Sleep();
List<WebElement> ComplaintTrackerTableRows2 = ComplaintTrackerTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));

List<WebElement> ComplaintTrackerColoumns = ComplaintTrackerTableRows2.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Thread.sleep(4000);
if(ComplaintTrackerColoumns.get(0).getText().equals("Closed")){
Thread.sleep(3000);
Reporter.log("Complaint Which Is Modified With Closed Status Is Under Closed Category", true);	
helper.TakeScreenShot("Complaint Status Changed To Closed");
helper.SetValueByID(VariableCalling2.EnterFromDdate, EnterFromDate);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.EnterToDate, EnterToDate);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButton);
Thread.sleep(5000);
Reporter.log("Complaints  Filtered According To Given Dates", true);	
helper.TakeScreenShot("Complaints  Filtered According To Given Dates");
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterDescriptionOfComplaintToSearchAgain);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
Thread.sleep(4000);
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
Thread.sleep(3000);
Thread.sleep(2000);
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Thread.sleep(4000);
String DescriptionOfComplaintAfterChangeStatus=tablecoloumns.get(8).getText();
if(DescriptionOfComplaintAfterChangeStatus.equals(EnterDescriptionOfComplaintToVerifyAgain)){
Thread.sleep(4000);
if(tablecoloumns.get(10).getText().equals("3")){
Thread.sleep(3000);
Reporter.log("Closed Complaint status Is Green Colour", true);	
Thread.sleep(2000);
helper.TakeScreenShot("Closed Complaint status Is Green Colour");
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInComplaints);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInComplaints);
Thread.sleep(4000);
}else{
Reporter.log("Complaint status Is Not In Green Colour", true);	
}}}else{
Reporter.log("Closed Satus Complaint Is Not Under Closed Category", true);	
}}}

@Test(priority=3)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Complaint Status Changed To Closed" +  "     Complaint Status Changed To Closed", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Complaints  Filtered According To Given Dates" +  "     Complaints  Filtered According To Given Dates", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Closed Complaint status Is Green Colour" +  "      Closed Complaint status Is Green Colour", true);	
Reporter.log(" ", true);	
	
}









}
