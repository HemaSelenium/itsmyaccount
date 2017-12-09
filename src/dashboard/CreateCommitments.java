package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class CreateCommitments extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->my Account--->My Commitments---->CreateComittment", true);	
Reporter.log("----------------------------------------------", true);	
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
}
@Test(priority=2,dataProvider="CreateCommitment",dataProviderClass= DataProviders2.class)
public void CreateCommitment(String EnterCategoryName,String EnterCategoryDescription,String EnterCategoryNameToSearch,String SelectCategoryInList,String EnterCommitmentName,String EnterDescription1,String EnterDescription2,String EnterDescription3,String SelectFrequencyType,String EnterDueDate,String EnterNumberOfDaysRemindBeforeDueDate,String EnterNumberOfDaysRemindAfterDueDate,String EnterCategoryNameToVerify,String EnterCommitmentNameToVerify,String EnterDescriptionOfCommitment,String EnterDescriptionToVerifyAfterSearch,String  EnterFromDate,String EnterToDate) throws InterruptedException, IOException, HeadlessException, AWTException{
boolean contains=false;
helper.ClickByXpath(VariableCalling2.ClickOnMyCommitmentsButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling2.ClickOnCategoriesButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.MaxSleep();
helper.SetValueByID("CategoryName", EnterCategoryName);
helper.SetValueByID("CategoryDescription", EnterCategoryDescription);
helper.ClickByID(VariableCalling.ClickOnSaveButton);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
List<String>CategoryNames=new ArrayList<String>();
for(int rows=1;rows<tableRows1.size();rows++){
List<WebElement> tablecoloumns = tableRows1.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
CategoryNames.add(tablecoloumns.get(1).findElement(By.tagName("span")).getText());
for(int Categories=0;Categories<CategoryNames.size();Categories++){
if(CategoryNames.get(Categories).equals(EnterCategoryNameToSearch)){
helper.DeepSleep();
contains=true;
}}}
if(contains){
helper.Sleep();
Reporter.log("Category Added Sucessfully ", true);	
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByID(VariableCalling2.ClickOnCommitmentsButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2. ClickOnCategoryDropdownList)).click();
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.linkText(SelectCategoryInList)).click();
helper.SetValueByID("CommitmentName", EnterCommitmentName);
helper.SetValueByID("Description1", EnterDescription1);
helper.SetValueByID("Description2", EnterDescription2);
helper.SetValueByID("Description3", EnterDescription3);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClickOnFrequencyDropDownList)).click();
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.linkText(SelectFrequencyType)).click();
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterCommitmentDueDate, EnterDueDate);  	
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterCommitmentDueDate)).sendKeys(Keys.TAB);
helper.Sleep();
helper.SetValueByID("ReminderBefore", EnterNumberOfDaysRemindBeforeDueDate);
helper.SetValueByID("ReminderAfter", EnterNumberOfDaysRemindAfterDueDate);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInCommitments);
helper.MaxSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
WebElement CommitmentList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> Commtments = CommitmentList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
try{
for(int rows=1;rows<Commtments.size();rows++){
List<WebElement> Category = Commtments.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(Category.get(2).findElement(By.tagName("span")).getText().equals(EnterCategoryNameToVerify)){
helper.Sleep();
List<WebElement> commitment = Commtments.get(rows+1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(commitment.get(2).findElement(By.tagName("span")).getText().equals(EnterCommitmentNameToVerify)){
helper.DeepSleep();
Reporter.log("Created Commitment Added Under "+Category.get(2).findElement(By.tagName("span")).getText() +" Category", true);	
helper.TakeScreenShot("AddedCommitment");
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectDescriptionInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterDescriptionOfCommitment);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement CommitmentListAfterSearch=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
List<WebElement> CommtmentsAfterSearch = CommitmentListAfterSearch.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<String>CommitmentDescriptionsList=new ArrayList<String>();
for(int Rows=1;Rows<CommtmentsAfterSearch.size();Rows++){
List<WebElement> CategoryAfterSearch = CommtmentsAfterSearch.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
CommitmentDescriptionsList.add(CategoryAfterSearch.get(3).getText());
for(int descriptionlist=0;descriptionlist<CommitmentDescriptionsList.size();descriptionlist++)
{if(CommitmentDescriptionsList.get(descriptionlist).equals(EnterDescriptionToVerifyAfterSearch)){
helper.Sleep();
contains=true;
}}}
if(contains){
Reporter.log("Search with Description of Commitment working Fine ", true);	
helper.SetValueByID(VariableCalling2.EnterFromDdate, EnterFromDate);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterToDate, EnterToDate);
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButton);
helper.Sleep();
Reporter.log("Data Filtered According To GivenDates", true);	
System.out.println();
helper.TakeScreenShot("GetDetailsByGivenPerioOfDates");
helper.ClickByXpath(VariableCalling2.clickOnExportButtonInCommitments);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInCommitments);
helper.MaxSleep();
helper.TakeScreenShotOfExportPDF("CommitmentListPdf");
}else{
Reporter.log("Searched Commitment Not Displayed", true);	
}}
else{
Reporter.log("Created Commitment Not Added Under Selected Category", true);	
}}}
}catch(StaleElementReferenceException Ignored){
}
}else{
Reporter.log(" Category Unable To Add ", true);	
}}
@Test(priority=3,dependsOnMethods="CreateCommitment")
public void Result(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedCommitment" +  "  AddedCommitment", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"GetDetailsByGivenPerioOfDates" +  "  GetDetailsByGivenPerioOfDates", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"CommitmentListPdf" + "   CommitmentListPdf", true);	
Reporter.log(" ", true);	
}
}
	  			  		
	  		
	  			
	  		  	
	  			
	  			
	  			
	  		
  		  	
	


	
	
	
	























