package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class RegularVendorsWithBadgeId extends TestBase{
public String TypeOfService;
public String VendorName;
public String ContactNumberToEdit;
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->RegularVendors With Badge Id", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Reporter.log("login Sucessfully", true);
helper.DeepSleep();
}
@Test(priority=2,dataProvider="RegularVendorsWithBadgeId",dataProviderClass= DataProviders2.class,dependsOnMethods="Login")
public void AddVendorDetails(String TypeOfservice,String Vendorname,String ContactNumber,String AgencyName,String Description,String Cost,String BadgeId,String Reference1,String Reference2,String Reference3) throws InterruptedException, IOException, AWTException{
TypeOfService=TypeOfservice;
VendorName=	Vendorname;
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnRegularVendorsButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("WorkType", TypeOfService);
helper.SetValueByID("VendorName",VendorName);
helper.SetValueByID("Contact", ContactNumber);
helper.SetValueByID("Agency", AgencyName);
helper.SetValueByID("Description", Description);
helper.SetValueByID("Cost", Cost);
helper.SetValueByID("PassNo", BadgeId);
helper.SetValueByID("Reference1", Reference1);
helper.SetValueByID("Reference2", Reference2);
helper.SetValueByID("Reference3", Reference3);
helper.ClickByXpath(VariableCalling2.UploadImage);
helper.Sleep();
helper.Sleep();
StringSelection stringSelection = new StringSelection(GlobalVariablesCalling.ImageToUpload);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_CONTROL);
helper.Sleep();
rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.WebCam);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.TakeSnapShot);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInRegularVendors);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement RegularVendorsTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfRegularVendors=RegularVendorsTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>TypeOfWork=new ArrayList<String>();
List<String>VendorNames=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfRegularVendors.size();Rows++){
List<WebElement>ColoumnsInRegularVendors=RowsOfRegularVendors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
TypeOfWork.add(ColoumnsInRegularVendors.get(3).getText());
VendorNames.add(ColoumnsInRegularVendors.get(4).getText());
}
if(TypeOfWork.contains(TypeOfService)){
if(VendorNames.contains(VendorName)){
Reporter.log("1)New Vendor Details  Added To RegularVendors List Sucessfully", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.selectTypeOfWorkInSearchFunction);
helper.Sleep();
helper.SetValueByXpath(VariableCalling. EnterDataToSearchInVendorList, TypeOfService);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
helper.TakeScreenShot("AddedVendorDetailsWithBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedVendorDetailsWithBadgeId", true);




helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.WebCameImageOnLeftSide);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.TakeSnapShotOnLeftSide);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.UploadImageOnRightSide);
helper.Sleep();
helper.Sleep();
StringSelection stringSelection1 = new StringSelection(GlobalVariablesCalling.ImageToUpload);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, stringSelection1);
Robot rb1=new Robot();
rb1.keyPress(KeyEvent.VK_CONTROL);
rb1.keyPress(KeyEvent.VK_V);
rb1.keyRelease(KeyEvent.VK_V);
rb1.keyRelease(KeyEvent.VK_CONTROL);
helper.Sleep();
rb1.keyPress(KeyEvent.VK_ENTER);
rb1.keyRelease(KeyEvent.VK_ENTER);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInRegularVendors);
helper.DeepSleep();
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException ex){
Reporter.log("Vendor Details Edited Sucessfully With LeftSide WebCam Image And Right Side Uploaded Image", true);
}
WebElement RegularVendors=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfRegularVendor=RegularVendors.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>TypeOfWorkAfterEdit=new ArrayList<String>();
List<String>VendorNamesAfterEdit=new ArrayList<String>();
for(int RowsInRegularVendors=1;RowsInRegularVendors<RowsOfRegularVendor.size();RowsInRegularVendors++){
List<WebElement>ColoumnsInRegularVendor=RowsOfRegularVendor.get(RowsInRegularVendors).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
TypeOfWorkAfterEdit.add(ColoumnsInRegularVendor.get(3).getText());
VendorNamesAfterEdit.add(ColoumnsInRegularVendor.get(4).getText());
}
if(TypeOfWorkAfterEdit.contains(TypeOfService)){
if(VendorNamesAfterEdit.contains(VendorName)){	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.selectTypeOfWorkInSearchFunction);
helper.Sleep();
helper.SetValueByXpath(VariableCalling. EnterDataToSearchInVendorList, TypeOfService);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
try{
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
Reporter.log("Search with Type of Service workinh Fine ", true);
}
catch(NoSuchElementException e){
Reporter.log("Either search With TypeOf work not working OR Edited Record Not Present In List", true);	
}}
else{
Reporter.log("After Edit Vendor Name Didn't Find In List", true);	
}}else{
Reporter.log("After Edit Type Of Sevice Didn't Find In List Of Vendors ", true);
}		
}else{
Reporter.log("Added Vendor Name Didn't Find In List", true);	
}}
else{
Reporter.log("Added Type Of Sevice Didn't Find In List Of Vendors ", true);
}}
@Test(priority=3,dataProvider="RegularVendorsWithExistedBadgeId",dataProviderClass= DataProviders2.class,dependsOnMethods="AddVendorDetails")
public void EditRecordWithExistedBadgeId(String ExistedBadgeId) throws InterruptedException, IOException{
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.DeepSleep();
helper.SetValueByID("PassNo", ExistedBadgeId);
helper.Sleep();	
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInRegularVendors);
helper.DeepSleep();
helper.TakeScreenShot("EditVendorDetailsWithExistedBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditVendorDetailsWithExistedBadgeId", true);
try{
Reporter.log("While Editing Record  With Existed BadgId", true);	
helper.ProcessAlert();
helper.Sleep();
}
catch(NoAlertPresentException e){
Reporter.log("Even Record Edited With Existed BadgId Did't Get Any Error(Saved Record With Existed BadgeId)", true);	
}}	
@Test(priority=4,dependsOnMethods="EditRecordWithExistedBadgeId")
public void ManuallyNeedToCheck(){
Reporter.log("   ", true);	
Reporter.log("swipe FP(Finger print) of 1004 in Biometric device", true);
Reporter.log("----------------------------------", true);
Reporter.log("1) SMS to reach moderator as ENTERED", true);
Reporter.log("2)Biometric screen to be updated as IN with intime", true);
Reporter.log("3) Summary listing tobe updated as 1/0 Under vendor list", true);

Reporter.log(" Swipe FP of 1004 in Biometric (Exit)", true);
Reporter.log("----------------------------------", true);
Reporter.log("1) SMS to reach moderator as  LEFT", true);
Reporter.log("2) Biometric screen to be update as OUT with out time", true);
Reporter.log("3) Summary listing to be uploaded as 1/1", true);








}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
