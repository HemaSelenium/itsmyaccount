package dashboard;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class AdminSocietydocuments extends TestBase {
@Test(priority = 1)
public void Login() throws InterruptedException {
Reporter.log("Script Name:Admin---->Application--->SocietyDocuments", true);	
Reporter.log("--------------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
}
@Test(priority = 2, dataProvider = "AddSocietyDocument", dataProviderClass = DataProvider3.class, dependsOnMethods = "Login")
public void AddDocument(String EnterDocumentName, String EnterDescriptionOfDocument, String SelectFileToUpload,
String EnterDocumentNameToSearch, String EnterAddedDocumentNameToSearch)
throws InterruptedException, IOException {
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSocietyDocuments);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("DocumentName", EnterDocumentName);
helper.SetValueByID("Description", EnterDescriptionOfDocument);
helper.ExecuteScript(VariableCalling2.FileDisplayTypeAsLine);
helper.SetValue1("file_upload", SelectFileToUpload);
helper.ExecuteScript(VariableCalling2.FileDisplayTypeAsNone);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInSocietyDocument);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(3000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, EnterDocumentNameToSearch);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
String DocumentName = helper.GetValueByXpath(VariableCalling.GetDocumentAfterSearch);
if (DocumentName.equals(EnterAddedDocumentNameToSearch)) {
Reporter.log("Search With DocumentName Working Fine And Document Added saucessfully", true);		
helper.TakeScreenShot("AddedSocietyDocument");
helper.ClickByID(VariableCalling.SelectRow);
} else {
Reporter.log("Search Not Worked With Document Name /Added Document Not Saved Sucessfully", true);	
}	}
@Test(priority = 3, dataProvider = "EditSocietyDocument", dataProviderClass = DataProvider3.class, dependsOnMethods = "AddDocument")
public void EditDocument(String EnterDescriptionToEdit, String EnterDocumentNameToSearch,
String EnterEditedDescriptionToVerify) throws InterruptedException, IOException {
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("Description", EnterDescriptionToEdit);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInSocietyDocument);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(3000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, EnterDocumentNameToSearch);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
String Description = helper.GetValueByXpath(VariableCalling.GetDescriptionofDocument);
if (Description.equals(EnterEditedDescriptionToVerify)) {
Reporter.log("Society Document Edited Sucessfully", true);	
Reporter.log("Description After Edit : " + Description, true);	
helper.TakeScreenShot("EditedSocietyDocument");
helper.ClickByID(VariableCalling.SelectRow);
} else {
Reporter.log("Search Not Worked With Document Name After Edited Description/Description Unable To Edit", true);	
}	}
@Test(priority = 4, dataProvider = "DeleteSocietyDocument", dataProviderClass = DataProvider3.class, dependsOnMethods = "EditDocument")
public void DeleteDocument(String DocumentNameToVerifyAfterDelete) throws InterruptedException, IOException {
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.DeepSleep();
try {
try {
helper.ProcessAlert();
Thread.sleep(2000);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(2000);
WebElement SocietyDocuments = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement> RowsOfDocuments = SocietyDocuments.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String> Documentnames = new ArrayList<String>();
for (int Row = 1; Row < RowsOfDocuments.size(); Row++) {
List<WebElement> ColoumnsInSocietyDocuments = RowsOfDocuments.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Documentnames.add(ColoumnsInSocietyDocuments.get(2).getText());
}
if (Documentnames.contains(DocumentNameToVerifyAfterDelete)) {
Reporter.log("Added Document Unable To Delete", true);	
helper.TakeScreenShot("DocumentUnableToDelete");
} else {
Reporter.log("Added Document Deleted Sucessfully", true);	
File SocietyDocumentListAfterDelete = ((TakesScreenshot) SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SocietyDocumentListAfterDelete, new File(GlobalVariablesCalling.ScreenShotsFileName + "SocietyDocumentListAfterDelete.png"));
}} catch (NoAlertPresentException e) {
Reporter.log("After Click On Delete Button Conformation Diologue Box Not Appeared/Unable To Click Delete Button", true);	
}} catch (UnhandledAlertException e) {
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement SocietyDocuments = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement> RowsOfDocuments = SocietyDocuments.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String> Documentnames = new ArrayList<String>();
for (int Row = 1; Row < RowsOfDocuments.size(); Row++) {
List<WebElement> ColoumnsInSocietyDocuments = RowsOfDocuments.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Documentnames.add(ColoumnsInSocietyDocuments.get(2).getText());
}
if (Documentnames.contains(DocumentNameToVerifyAfterDelete)) {
Reporter.log("Added Document Unable To Delete", true);	
helper.TakeScreenShot("DocumentUnableToDelete");
} else {
Reporter.log("Added Document Deleted Sucessfully", true);	
helper.TakeScreenShot("SocietyDocumentListAfterDelete");
}}}
@Test(priority = 5, dependsOnMethods = "DeleteDocument")
public void Results() {
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : " + GlobalVariablesCalling.ScreenShotsFileName + "AddedSocietyDocument", true);	
Reporter.log("File Name : " + GlobalVariablesCalling.ScreenShotsFileName + "EditedSocietyDocument", true);	
Reporter.log("File Name : " + GlobalVariablesCalling.ScreenShotsFileName + "SocietyDocumentListAfterDelete", true);	
Reporter.log(" ", true);	
	}
}
