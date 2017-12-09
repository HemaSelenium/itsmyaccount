package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
public class AdminRegularvendorsWithoutBadgeId extends TestBase {
public String TypeOfService;
public String VendorName;
public String ContactNumberToEdit;
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->RegularVendors With Out Badge ID", true);	
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
@Test(priority=2,dataProvider="RegularVendors",dataProviderClass= DataProviders2.class,dependsOnMethods="Login")
public void AddVendorDetails(String TypeOfservice,String Vendorname,String ContactNumber,String AgencyName,String Description,String Cost,String Reference1,String Reference2,String Reference3,String ContactnumberToEdit) throws InterruptedException, IOException{
TypeOfService=TypeOfservice;
VendorName=	Vendorname;
ContactNumberToEdit=ContactnumberToEdit;
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
SeleniumHelper.driver.findElement(By.id("PassNo")).clear();
helper.Sleep();
helper.SetValueByID("Reference1", Reference1);
helper.SetValueByID("Reference2", Reference2);
helper.SetValueByID("Reference3", Reference3);
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
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInVendorList, TypeOfService);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
helper.TakeScreenShot("AddedVendorRecordWithoutBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedVendorRecordWithoutBadgeId", true);

String ContactNumberBeforeEdit=helper.GetValueByXpath(VariableCalling.ContactNumber);
Reporter.log("Contact Number Before Edit: "+ContactNumberBeforeEdit, true);
File AddedRegularVendor=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedRegularVendor, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedRegularVendor.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("Contact", ContactNumberToEdit);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInRegularVendors);
helper.DeepSleep();
WebElement RegularVendors=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfRegularVendor=RegularVendors.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ContactNumbersAfterEdit=new ArrayList<String>();
List<String>TypeOfWorkAfterEdit=new ArrayList<String>();
for(int RowsInRegularVendors=1;RowsInRegularVendors<RowsOfRegularVendor.size();RowsInRegularVendors++){
List<WebElement>ColoumnsInRegularVendor=RowsOfRegularVendor.get(RowsInRegularVendors).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
ContactNumbersAfterEdit.add(ColoumnsInRegularVendor.get(5).getText());
TypeOfWorkAfterEdit.add(ColoumnsInRegularVendor.get(3).getText());
}
if(TypeOfWorkAfterEdit.contains(TypeOfService)){
if(ContactNumbersAfterEdit.contains(ContactNumberToEdit)){
Reporter.log("2)Edited Contact details Of newly added Vendor ", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.selectTypeOfWorkInSearchFunction);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInVendorList, TypeOfService);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
helper.TakeScreenShot("EditedVendorRecordWithoutBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedVendorRecordWithoutBadgeId", true);

String ContactNumberAfterEdit=helper.GetValueByXpath(VariableCalling.ContactNumber);
Reporter.log("Contact Number After Edit: "+ContactNumberAfterEdit, true);
File EditedRegularVendor=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedRegularVendor, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedRegularVendor.png"));
helper.ClickByID(VariableCalling.SelectRow);

helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.Sleep();
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();


WebElement RegularVendorsAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfRegularVendorAfterDelete=RegularVendorsAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ContactNumbersAfterDelete=new ArrayList<String>();
for(int RowsInRegularVendors=1;RowsInRegularVendors<RowsOfRegularVendorAfterDelete.size();RowsInRegularVendors++){
List<WebElement>ColoumnsInRegularVendor=RowsOfRegularVendorAfterDelete.get(RowsInRegularVendors).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
ContactNumbersAfterDelete.add(ColoumnsInRegularVendor.get(5).getText());
}
if(ContactNumbersAfterDelete.contains(ContactNumberToEdit)){
Reporter.log("3)Unable to Delete Added Vendor Details", true);
}
else{
Reporter.log("3)Added Vendor Details Deleted Sucessfully", true);
System.out.println();	
}
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement RegularVendorsAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfRegularVendorAfterDelete=RegularVendorsAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ContactNumbersAfterDelete=new ArrayList<String>();
for(int RowsInRegularVendors=1;RowsInRegularVendors<RowsOfRegularVendorAfterDelete.size();RowsInRegularVendors++){
List<WebElement>ColoumnsInRegularVendor=RowsOfRegularVendorAfterDelete.get(RowsInRegularVendors).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
ContactNumbersAfterDelete.add(ColoumnsInRegularVendor.get(5).getText());
}
if(ContactNumbersAfterDelete.contains(ContactNumberToEdit)){
Reporter.log("3)Unable to Delete Added Vendor Details", true);	
}
else{
Reporter.log("3)Added Vendor Details Deleted Sucessfully", true);	
}


}


}
else{
Reporter.log("2)Unable To Edit Contact Number Of Vendor Details ", true);	
}}
else{
Reporter.log("2)Unable to find Added Work Type After Edit Conatct Details of Added worktype", true);
}}
else{
Reporter.log("1)Unable To Add Vendor Details", true);
	}}
else{
Reporter.log("1)Unable To Add Vendor Details", true);
}}
@Test(priority=3,dependsOnMethods="AddVendorDetails")
public void Export() throws InterruptedException, HeadlessException, AWTException, IOException{
helper.DeepSleep();
helper.ClickByXpath(VariableCalling. ClickOnExportButtonInRegularVendors);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInRegularVendors);
helper.DeepSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminRegulaVendorsPdf .png"));

 }
@Test(priority=4,dependsOnMethods="Export")
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedRegularVendor.png" + "  AddedRegularVendor", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedRegularVendor.png" + "  EditedRegularVendor", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminRegulaVendorsPdf .png" + "  AdminRegulaVendorsPdf ", true);
Reporter.log(" ", true);
Reporter.log("Items to be checked Manually", true);
Reporter.log("-----------------------------", true);
Reporter.log("Check Added RegularVendor Deleted Or Not", true);
Reporter.log(" ", true);
}
}
