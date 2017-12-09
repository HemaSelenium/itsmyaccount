package dashboard;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminAddEditDeletecomplaints extends TestBase {
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->MyComplaints", true);	
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
public void AddComplaints(String EnterCategoryOfComplaint,String EnterDescriptionOfComplaint,String SelectPriority,String SelectStatusOfComplaint,String EnterDescriptionOfComplaintToSearch
,String EnterDescriptionOfComplaintToVerify) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.Sleep();
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
helper.Sleep();
helper.SetValueByID("Description", EnterDescriptionOfComplaint);
helper.ClickByXpath(VariableCalling2.ClickOnBlockDropDownListInComplaints);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnApartmentNumbersDropDownListInComplaints);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnPriorityOfComplaintDropDownList);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.linkText(SelectPriority)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnStatusOfComplaintsDropDownList);
helper.DeepSleep();
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
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
try{
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(tablecoloumns.get(9).getText().equals(MethodsCalling.CurrentDate())){
if(tablecoloumns.get(8).getText().equals(EnterDescriptionOfComplaintToVerify)){
helper.Sleep();
Reporter.log("Complaint Added Sucessfully", true);
if(tablecoloumns.get(10).getText().equals("1")){
Reporter.log("Complaint status colour is : Red", true);	
}
else{
	if(tablecoloumns.get(10).getText().equals("2")){
		Reporter.log("Complaint status colour is : Amber", true);	
		}
	else{
		Reporter.log("Complaint status colour is : Green", true);
	}
	
}

tablecoloumns.get(8).click();
helper.Sleep();
helper.TakeScreenShot("AddedCompalintByAdminLogin");
}
else{
Reporter.log("Unable to Add Complaint/Search Not Working with Description Of Complaint", true);

}}else{
Reporter.log("Unable to Add Complaint With ToDay Date", true);
	
}
}
catch(NoSuchElementException e){
Reporter.log("unable to find added complaint using search function/unable to add complaint", true);	
}}
@Test(priority=3,dataProvider="EditComplaints",dataProviderClass= Dataproviders.class,dependsOnMethods={"AddComplaints"})
public void EditAndDeleteComplaint(String EnterDescriptionOfComplaintToEdit,String EnterEditedDescriptionToSearch,String EnterEditedDescriptionOfComplaintToVerify,String EnterDeletedDescriptionOfComplaintToVerify) throws InterruptedException, IOException{
boolean Result=true;
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.MaxSleep();
helper.SetValueByID("Description", EnterDescriptionOfComplaintToEdit);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterEditedDescriptionToSearch);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement Tablevalues1=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> Rows1 = Tablevalues1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement>coloumns = Rows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(coloumns.get(9).getText().equals(MethodsCalling.CurrentDate())){
if(coloumns.get(8).getText().equals(EnterEditedDescriptionOfComplaintToVerify)){
helper.Sleep();
Reporter.log("Complsint Edited Sucessfully", true);
coloumns.get(8).click();
helper.Sleep();
helper.TakeScreenShot("Edited Complaint By AdminLogin");
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.Sleep();
helper.ProcessAlert();
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.TakeScreenShot("List Of Complaints After Delete Added Complaint");
WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement> RowsInComplaints = Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<String> list = new ArrayList<String>();
for(int ComplaintRows=1;ComplaintRows<RowsInComplaints.size();ComplaintRows++){
List<WebElement>ColoumnsInComplaints = RowsInComplaints.get(ComplaintRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
list.add(ColoumnsInComplaints.get(8).getText());
for(int j=0;j<list.size();j++){
if((list.get(j)).equals(EnterDeletedDescriptionOfComplaintToVerify))
helper.Sleep();
{
Result=false;
}} }if(Result){
helper.Sleep();
Reporter.log("Complaint Unable To Delete", true);
}else{
Reporter.log("Complaint Deleted Sucessfully ", true);
helper.Nap();
}	
}else{
Reporter.log("Complaint unable to edit", true);	
}}

}
@Test(priority=4,dependsOnMethods="EditAndDeleteComplaint")
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedCompalintByAdminLogin", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Complaint By AdminLogin", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"List Of Complaints After Delete Added Complaint",true);
Reporter.log(" ", true);	

}







}
