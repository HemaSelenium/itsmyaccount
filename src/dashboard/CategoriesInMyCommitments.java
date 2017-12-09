package dashboard;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
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
public class CategoriesInMyCommitments extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->my Account--->My Commitments---->Categories", true);	
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
@Test(priority=2,dataProvider="MemberCategoryInMyCommitments",dataProviderClass= DataProviders2.class)
public void CommitmentCategory(String EnterCategoryName,String EnterCategoryDescription,String EnterCategoryNameToVerify,String EnterCategoryNameTosearch,String EnterCategoryDescriptionToEdit,String EnterCategoryNameTosearchAfterEdit,String EnterCategoryDescriptionTosearchAfterEdit,String EnterCategoryDescriptionToVerifyAfterEdit,String EnterCategoryNameToVerifyAfterDelete) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnMyCommitmentsButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling2.ClickOnCategoriesButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.MaxSleep();
helper.SetValueByID("CategoryName", EnterCategoryName);
helper.SetValueByID("CategoryDescription", EnterCategoryDescription);
helper.ClickByID(VariableCalling.ClickOnSaveButton);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
ArrayList<String>ListOfCategories=new ArrayList<String>();
for(int rows=1;rows<tableRows1.size();rows++){
List<WebElement> tablecoloumns = tableRows1.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.DeepSleep();
ListOfCategories.add(tablecoloumns.get(1).findElement(By.tagName("span")).getText());
String CategoryName=tablecoloumns.get(1).findElement(By.tagName("span")).getText();
if(CategoryName.equals(EnterCategoryNameToVerify)){
tablecoloumns.get(1).click();
helper.TakeScreenShot("AddedCategoryOfCommitment");
}}
if(ListOfCategories.contains(EnterCategoryNameTosearch)){
Reporter.log("Category Added Sucessfully", true);
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.SetValueByID("CategoryDescription", EnterCategoryDescriptionToEdit);
helper.ClickByID(VariableCalling.ClickOnSaveButton);
helper.DeepSleep();
WebElement CategoryList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> CategoryListRows = CategoryList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
ArrayList<String>CategorydescriptionAfterEdit=new ArrayList<String>();
for(int rows=1;rows<CategoryListRows.size();rows++){
List<WebElement> CategoryListColoumns = CategoryListRows.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
CategorydescriptionAfterEdit.add(CategoryListColoumns.get(2).getText());
}
if(CategorydescriptionAfterEdit.contains(EnterCategoryDescriptionToVerifyAfterEdit)) {
Reporter.log("Category Description Edited Sucessfully", true);
WebElement CommitmentCategories=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> CommitmentCategoryRows = CommitmentCategories.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
for(int list=1;list<CommitmentCategoryRows.size();list++){
List<WebElement> CommitmentCategoryColoumns = CommitmentCategoryRows.get(list).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
if(CommitmentCategoryColoumns.get(1).findElement(By.tagName("span")).getText().equals(EnterCategoryNameTosearchAfterEdit)){
if(CommitmentCategoryColoumns.get(2).getText().equals(EnterCategoryDescriptionTosearchAfterEdit)){
CommitmentCategoryColoumns.get(1).click();
helper.TakeScreenShot("EditedCategoryOfCommitment");
helper.ClickByID(VariableCalling.ClickONDeleteButton);
}}}
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement SocietyCategoryList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> SocietyCategoryListRows = SocietyCategoryList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
ArrayList<String>CategoryNamesAfterDelete=new ArrayList<String>();
for(int row=1;row<SocietyCategoryListRows.size();row++){
List<WebElement> SocietyCategoryListColoumns = SocietyCategoryListRows.get(row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
CategoryNamesAfterDelete.add(SocietyCategoryListColoumns.get(1).findElement(By.tagName("span")).getText());
}if(CategoryNamesAfterDelete.contains(EnterCategoryNameToVerifyAfterDelete)){
Reporter.log("Unable To Delete Category", true);
}
else{
Reporter.log("Added Category deleted sucessfully", true);
helper.TakeScreenShot("ListOfCategoriesAfterDeleteAddedCategory");
}}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
WebElement SocietyCategoryList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> SocietyCategoryListRows = SocietyCategoryList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
ArrayList<String>CategoryNamesAfterDelete=new ArrayList<String>();
for(int row=1;row<SocietyCategoryListRows.size();row++){
List<WebElement> SocietyCategoryListColoumns = SocietyCategoryListRows.get(row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
CategoryNamesAfterDelete.add(SocietyCategoryListColoumns.get(1).findElement(By.tagName("span")).getText());
}if(CategoryNamesAfterDelete.contains(EnterCategoryNameToVerifyAfterDelete)){
Reporter.log("Unable To Delete Category", true);
}else{
Reporter.log("Added Category deleted sucessfully", true);
helper.TakeScreenShot("ListOfCategoriesAfterDeleteAddedCategory");
}}}else{
Reporter.log("Unable To Find Category After Edit", true);
}}else{
Reporter.log("Category Unable To Add", true);
}}
@Test(priority=3,dependsOnMethods="CommitmentCategory")
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedCategoryOfCommitment" +  "  AddedCategoryOfCommitment", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedCategoryOfCommitment" + "   EditedCategoryOfCommitment", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ListOfCategoriesAfterDeleteAddedCategory" + "  ListOfCategoriesAfterDeleteAddedCategory", true);
Reporter.log(" ", true);
}






}
