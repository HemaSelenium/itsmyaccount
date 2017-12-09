package dashboard;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
public class MemberPersonalDocuments extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Member---->Application--->MyAccount--->My Personal Documents", true);	
Reporter.log("------------------------------------------------------------------------", true);	
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
}@Test(priority=2,dataProvider="MemberPersonalDocuments",dataProviderClass= DataProviders2.class)
public void MyPersonalDocuments(String EnterDocumentName,String EnterDescriptonOfDocument,String SelectFileToUpload,String EnterDocumentNameToSearch,String EnterDocumentNameToVerifyInList,String EnterDescriptonOfDocumentToEdit,String EnterDocumentNameToVerifyAfterEdit,String EnterDescriptionToVerify,String EnterDocumentNameToVerifyAfterDelete ) throws InterruptedException, AWTException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnMyPersonalDocumentsButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.MaxSleep();
helper.SetValueByID("DocumentName", EnterDocumentName);
helper.SetValueByID("Description",EnterDescriptonOfDocument);
helper.ExecuteScript(VariableCalling2.FileDisplayTypeAsLine);
helper.SetValue1("file_upload", SelectFileToUpload);
helper.MaxSleep();
helper.ExecuteScript(VariableCalling2.FileDisplayTypeAsNone);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInPersonalDocuments);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectDocumentNameInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterDocumentNameToSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();

try{
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
if(tablecoloumns.get(2).getText().equals(EnterDocumentNameToVerifyInList)){
Reporter.log("Document Added Sucessfully", true);		
helper.TakeScreenShot("Added Member Personal Document");
tablecoloumns.get(2).click();
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.MaxSleep();
helper.SetValueByID("Description",EnterDescriptonOfDocumentToEdit);	
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInPersonalDocuments);
helper.MaxSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectDocumentNameInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterDocumentNameToSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement SocietyDocumentsList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> SocietyDocumentRows = SocietyDocumentsList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
List<WebElement>Coloumns = SocietyDocumentRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns.get(2).getText().equals(EnterDocumentNameToVerifyAfterEdit)){
if(Coloumns.get(3).getText().equals(EnterDescriptionToVerify)){
Reporter.log("Personal Documents Description  Edited Sucessfully", true);		
helper.TakeScreenShot("Edited Personal Document");
Coloumns.get(2).click();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
WebElement DocumentsList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> DocumentRows = DocumentsList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
List<String>DocumentNames=new ArrayList<String>();
for(int RowsOfDocumentList=0;RowsOfDocumentList<DocumentRows.size();RowsOfDocumentList++){
List<WebElement>DocumentColoumns = DocumentRows.get(RowsOfDocumentList).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
DocumentNames.add(DocumentColoumns.get(2).getText());
}
if(DocumentNames.contains(EnterDocumentNameToVerifyAfterDelete)){
Reporter.log("Unable To Delete Member Personal Documents", true);		
}else{
Reporter.log("Member Personal Document Deleted Sucessfully", true);	
}}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();	
WebElement DocumentsList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> DocumentRows = DocumentsList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
List<String>DocumentNames=new ArrayList<String>();
try{
for(int RowsOfDocumentList=1;RowsOfDocumentList<DocumentRows.size();RowsOfDocumentList++){
List<WebElement>DocumentColoumns = DocumentRows.get(RowsOfDocumentList).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
DocumentNames.add(DocumentColoumns.get(2).getText());
}if(DocumentNames.contains(EnterDocumentNameToVerifyAfterDelete)){
Reporter.log("Unable To Delete Member Personal Documents", true);	
}else{
Reporter.log("Member Personal Document Deleted Sucessfully", true);	
helper.TakeScreenShot("Member Personal Documents After Delete added Document");
}}
catch(NoSuchElementException E){
Reporter.log("Member Personal Document List Is Empty", true);	
}}}else{
Reporter.log("Unable To Edit Description Of Document", true);	
}}
else{
Reporter.log("Search Works Fail(Searched Document Is Not Required Document)After Edit", true);	
}}
else{
Reporter.log("Search Not Worked With Document Name /Added Document Not Saved Sucessfully", true);	
}}
catch(NoSuchElementException e){
Reporter.log("Search By Using Documentname Fails/ Document Unable To Add ", true);	
}}
@Test(priority=3,dependsOnMethods="MyPersonalDocuments")
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added Member Personal Document" + "  Added Member Personal Document", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Personal Document" + "  Edited Personal Document", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Member Personal Documents After Delete added Document" + "  Member Personal Documents After Delete added Document", true);	
Reporter.log(" ", true);	
}










}
