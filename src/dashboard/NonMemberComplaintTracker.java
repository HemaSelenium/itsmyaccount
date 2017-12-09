package dashboard;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class NonMemberComplaintTracker extends TestBase{
	@Test(priority=1)
	public void Login()throws Exception{
	Reporter.log("Script Name:Admin---->Application--->MyComplaints---->TrackComplaints", true);
	Reporter.log("----------------------------------------------", true);
	Reporter.log(" ", true);
	helper.Navigate(GlobalVariablesCalling.EnterUrl);
	helper.DeepSleep();
	helper.SetValue1("UserName",GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete);
	helper.SetValue1("Password", GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete);
	helper.ClickByID(VariableCalling.SelectTermsAndConditions);
	helper.ClickByXpath(VariableCalling.LoginButton);
	helper.MaxSleep();
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButtonInNonMemberLogin);
	helper.MaxSleep();
	}	
	@Test(priority=2,dataProvider="CreateComplaintByNonMember",dataProviderClass= DataProvider3.class)
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
	}}
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
	helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInComplaints);
	helper.Sleep();
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
	helper.TakeScreenShot("AddedComplaintByNonMember");
	String TicketNumberOfComplaint=tablecoloumns.get(2).getText();
	Reporter.log("Ticket Number Of Complaints: "+TicketNumberOfComplaint, true);
	helper.Sleep();
	if(tablecoloumns.get(10).getText().equals("1")){
	helper.Sleep();
	Reporter.log("Complaint status Is In Red Colour", true);
		}else{
	Reporter.log("Complaint status Is Not In Red Colour", true);
		}
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButtonInNonMemberLogin);
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
		helper.TakeScreenShot("Added Complaint By NonMember  Under Open Category");

	}

	else{
	Reporter.log("Added Complaint Not In Open Category", true);
		}
	}
	else{
	Reporter.log("Complaint unable to Add", true);
		}}
	
	
	@Test(priority=3)
	public void SearchByCategory() throws IOException{
		helper.ClickByXpath(VariableCalling.ClickOnApplicationButtonInNonMemberLogin);
		helper.MaxSleep();
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
		for(int i=0;i<tableRows1.size();i++){
		List<WebElement> tablecoloumns = tableRows1.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		helper.Sleep();
		ListOfcategories.add(tablecoloumns.get(10).getText());
		}
		if(ListOfcategories.contains("1")){
			helper.Sleep();
			Reporter.log("Filter Complaints By Category Working Fine ", true);
			helper.TakeScreenShot("Filter complaints By Open Category");
			
				}else{
			Reporter.log("Complaint status Is Not In Red Colour", true);
				}
		}
		
	
	@Test(priority=4)
	public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);
Reporter.log("---------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedComplaintByNonMember" +  "    AddedComplaintByNonMember", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added Complaint By NonMember  Under Open Category" +  "   Added Complaint Under Open Category", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Compalint status Changed To Picked By NonMember" +  "    Compalint status Changed To Picked By NonMember", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ComplaintsPDFInNonMemberLogin" +  "    ComplaintsPDFInNonMemberLogin", true);
Reporter.log(" ", true);
		}


}
