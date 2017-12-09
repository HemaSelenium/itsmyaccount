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
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class Membercomplaints extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Member---->Application--->MyComplaints", true);
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
@Test(priority=2,dataProvider="CreateMemberComplaints",dataProviderClass= Dataproviders.class)
public void AddComplaints(String EnterCategoryOfComplaint,String EnterDescriptionOfComplaint,String SelectPriority,String SelectStatusOfComplaint,String EnterDescriptionOfComplaintToSearch
,String EnterDescriptionOfComplaintToVerify) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.MaxSleep();
Select AllCategories=new Select(SeleniumHelper.driver.findElement(By.id("Category")));
helper.Sleep();
List <WebElement> elementCount = AllCategories.getOptions();
for(int i =0; i<elementCount.size() ; i++){
String sValue = elementCount.get(i).getAttribute("value");
if(sValue.equals(EnterCategoryOfComplaint)){
SeleniumHelper.driver.findElement(By.id("auto_Category")).clear();
SeleniumHelper.driver.findElement(By.id("auto_Category")).sendKeys(sValue);
helper.Sleep();	
}}
helper.SetValueByID("Description", EnterDescriptionOfComplaint);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnMemberComplaintPriorityDropDown);
helper.DeepSleep();
helper.SetDropDownValue("Priority", SelectPriority);
//SeleniumHelper.driver.findElement(By.linkText(SelectPriority)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnMemberComplaintStatusDropDown);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.linkText(SelectStatusOfComplaint)).click();
helper.Sleep();
try{
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
helper.DeepSleep();
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
if(tablecoloumns.get(8).getText().equals(EnterDescriptionOfComplaintToVerify)){
helper.Sleep();
Reporter.log("Complaint Added Sucessfully", true);
tablecoloumns.get(8).click();
helper.Sleep();
helper.TakeScreenShot("AddedCompalintByMemberLogin");
}
else{
Reporter.log("Unable to Add Complaint/Search Not Working with Description Of Complaint", true);	
}
}
catch(NoSuchElementException e){
Reporter.log("unable to find added complaint using search function/unable to add complaint", true);	
}}
@Test(priority=3,dataProvider="EditMemberComplaints",dataProviderClass= Dataproviders.class,dependsOnMethods={"AddComplaints"})
public void EditAndDeleteComplaint(String EnterDescriptionOfComplaintToEdit,String EnterEditedDescriptionToSearch,String EnterEditedDescriptionOfComplaintToVerify,String EnterDeletedDescriptionOfComplaintToVerify) throws InterruptedException, IOException{
boolean Result=true;
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.MaxSleep();
helper.SetValueByID("Description", EnterDescriptionOfComplaintToEdit);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
helper.DeepSleep();
helper.RefreshPage();
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
if(coloumns.get(8).getText().equals(EnterEditedDescriptionOfComplaintToVerify)){
helper.Sleep();
Reporter.log("Complsint Edited Sucessfully", true);
coloumns.get(8).click();
helper.Sleep();
helper.TakeScreenShot("Edited Complaint By MemberLogin");
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.Sleep();
try{
helper.ProcessAlert();
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.TakeScreenShot("List Of Complaints After Delete Added Complaint By Member");
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
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.TakeScreenShot("List Of Complaints After Delete Added Complaint By Member");
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
}	}
}else{
Reporter.log("Complaint unable to edit", true);	
}}
@Test(priority=4,dependsOnMethods="EditAndDeleteComplaint")
public void SearchByCategory() throws IOException{
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
	helper.MaxSleep();
	helper.ClickByXpath(".//*[@id='status']");
	Select categories= new Select(SeleniumHelper.driver.findElement(By.id("status")));
	categories.selectByVisibleText("Open");
	helper.DeepSleep();
	WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
	helper.MaxSleep();
	List<String>ListOfcategories=new ArrayList<String>();
	List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
	helper.Sleep();
	try{
	for(int i=1;i<tableRows1.size();i++){
	List<WebElement> tablecoloumns = tableRows1.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
	helper.Sleep();
	ListOfcategories.add(tablecoloumns.get(10).getText());
	}
	System.out.println(ListOfcategories);
	if(ListOfcategories.isEmpty()){
	Reporter.log("Either Filter Complaints By Category Not Working Fine OR ListIs Empty ", true);
		}
	else{
	if(ListOfcategories.contains("1")){
	helper.Sleep();
	Reporter.log("Filter Complaints By Category Working Fine ", true);
	helper.TakeScreenShot("Filter complaints By Open Category");
	}else{
	Reporter.log("Complaint status Is Not In Red Colour", true);
	}
	}}
	catch(IndexOutOfBoundsException e){
	Reporter.log("Either Open Category Complaints Not Availble OR Search By Category With Open Category Not Working ", true);
	}}
@Test(priority=5,dependsOnMethods="SearchByCategory")
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);
Reporter.log("---------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedCompalintByMemberLogin" +  "  AddedCompalintByMemberLogin", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Complaint By MemberLogin" +  "  Edited Complaint By MemberLogin", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"List Of Complaints After Delete Added Complaint By Member" +  "  List Of Complaints After Delete Added Complaint By Member", true);
Reporter.log(" ", true);
}}
