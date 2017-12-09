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
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AddRegularVendorWithoutSMSTick extends TestBase{
public String TypeOfService;
public String VendorName;
public String ContactNumberToEdit;
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->RegularVendors With Badge Id Without SMS Tick", true);	
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
@Test(priority=2,dataProvider="RegularVendorsWithBadgeIdWithoutSMSTick",dataProviderClass= DataProviders2.class,dependsOnMethods="Login")
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

if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
SeleniumHelper.driver.findElement(By.id("ISSMS")).click();
helper.Sleep();
Reporter.log("While Adding SMS Option Is UnTicked ", true);
}
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
Reporter.log("New Vendor Details  Added To RegularVendors List Sucessfully", true);	
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
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
Thread.sleep(4000);
helper.TakeScreenShot("AddedVendorDetailsWithoutSMSTick");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedVendorDetailsWithoutSMSTick", true);


if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
Reporter.log("Untick SMS Option Didn't Saved ", true);

}
else{
Reporter.log("Untick SMS Option Is Saved Sucessfully", true);
}
}}}
}
