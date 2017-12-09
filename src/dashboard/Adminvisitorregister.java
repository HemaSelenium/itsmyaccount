package dashboard;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
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
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class Adminvisitorregister extends TestBase{
@Test(priority=1)	
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->VisitorRegister", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	}
@Test(priority=2,dataProvider="VisitorRegister",dataProviderClass= DataProviders2.class)	
public void AddVisitorDetails(String EnterVisitorName,String EnterVisitorContactNumber,String EnterPersonTomeet,String EnterGate,String EnterVehicalNumber,String EnterVisitorType,String EnterPassNo,String EnterPurpose,String EnterPassnumberToSearch,String EnterPassNumberToSearchAfterAdd,String EnterPassNumberToEdit,String SearchPassNumberAfterEdit,String EnterPassNoToSearchAfteredit,String SearchPassNumberAfterDelete) throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnVisitorRegestor);
helper.ClickByID(VariableCalling.ClickOnAddButton);
Thread.sleep(3000);
String Date=SeleniumHelper.driver.findElement(By.id("date")).getAttribute("value");
Reporter.log(Date, true);	
if(Date.equals(MethodsCalling.CurrentDate())){
Reporter.log("1)Date is Filled Up Automatically With CurrentDate", true);	
}
else{
Reporter.log("1)Date Is Not Automatically filled /Date Is Not Matched with Current sate", true);	
}
helper.SetValueByID("VisitorName", EnterVisitorName);
helper.SetValueByID("ContactNo", EnterVisitorContactNumber);
helper.SetValueByID("PersonToMeet",EnterPersonTomeet);
helper.SetValueByID("Gate",EnterGate);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnBlockDropDownListButton);
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApartmentDropDownlist);
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.DeepSleep();
helper.DeepSleep();
helper.SetValueByID("VehicleNo", EnterVehicalNumber);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnVistorTypeDropDownList);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.linkText(EnterVisitorType));
helper.DeepSleep();
helper.SetValueByID("PassNo", EnterPassNo);
helper.SetValueByID("RefField",EnterPurpose);
helper.DeepSleep();
String InTime=SeleniumHelper.driver.findElement(By.xpath(".//*[@id='timepicker1']")).getAttribute("value");
if(InTime==null){
Reporter.log("2)InTime Of Visitor Unable To Fill Automatically ", true);	
}
else{
Reporter.log("2)Intime Of Visitor Filled Automatically", true);	
Reporter.log("InTime Of Visitor"+InTime, true);	
}
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInVisitorRegistor); 
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement VisitorRegister=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfVisitors=VisitorRegister.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>DateInVisitorRegister=new ArrayList<String>();
List<String>PassNumber=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfVisitors.size();Rows++){
List<WebElement>ColoumnsOfVisitors=RowsOfVisitors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
DateInVisitorRegister.add(ColoumnsOfVisitors.get(2).getText());
PassNumber.add(ColoumnsOfVisitors.get(11).getText());
}
if(DateInVisitorRegister.contains(MethodsCalling.CurrentDate())){
if(PassNumber.contains(EnterPassnumberToSearch)){
Reporter.log("3)New VisitorRegister Details Added To VisitorRegister List Sucessfully", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.SelectPassNoInSearchFunction);
helper.ClickByXpath(VariableCalling.SelectPassNoInSearchFunction);
helper.SetValueByXpath(VariableCalling. EnterDataToSearchInVisitorRegister, EnterPassNumberToSearchAfterAdd);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
String PassNOBeforeEdit=helper.GetValueByXpath(VariableCalling.PassNumber);
Reporter.log("4)Pass Number Before Edit: "+PassNOBeforeEdit, true);	
File AddVisitorDetails=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddVisitorDetails, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddVisitorDetails.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
Thread.sleep(4000);
helper.SetValueByID("PassNo", EnterPassNumberToEdit);
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInVisitorRegistor); 
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement Visitors=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsInVisitors=Visitors.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>DateAfterEdit=new ArrayList<String>();
List<String>PassNumberAfterEdit=new ArrayList<String>();
for(int RowsInRegularVendors=1;RowsInRegularVendors<RowsInVisitors.size();RowsInRegularVendors++){
List<WebElement>ColoumnsInVisitors=RowsInVisitors.get(RowsInRegularVendors).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
DateAfterEdit.add(ColoumnsInVisitors.get(2).getText());
PassNumberAfterEdit.add(ColoumnsInVisitors.get(11).getText());
}
if(DateAfterEdit.contains(MethodsCalling.CurrentDate())){
if(PassNumberAfterEdit.contains(SearchPassNumberAfterEdit)){
Reporter.log("5)PassNumber Of newly added VisitorRegister Edited Sucessfully", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.SelectPassNoInSearchFunction);
Thread.sleep(4000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInVisitorRegister, EnterPassNoToSearchAfteredit);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
String PassNOAfterEdit=helper.GetValueByXpath(VariableCalling.PassNumber);
Reporter.log("6)Pass Number After Edit: "+PassNOAfterEdit, true);	
String OutTime=helper.GetValueByXpath(VariableCalling.OutTime);
if(OutTime==null){
Reporter.log("7)Outtime Not Filled While Editing", true);	
}
else{
Reporter.log("7)outtime Filled Automatically while editing", true);	
Reporter.log("OutTime Of Visitor"+OutTime, true);	
}
File EditVisitorDetails=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditVisitorDetails, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditVisitorDetails.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.ClickByID(VariableCalling.ClickONDeleteButton);
Thread.sleep(4000);
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement VisitorsAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfVisitorsAfterDelete=VisitorsAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>PassNumbersAfterDelete=new ArrayList<String>();
for(int RowsInVisitorRegister=1;RowsInVisitorRegister<RowsOfVisitorsAfterDelete.size();RowsInVisitorRegister++){
List<WebElement>ColoumnsInVisitors=RowsOfVisitorsAfterDelete.get(RowsInVisitorRegister).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
PassNumbersAfterDelete.add(ColoumnsInVisitors.get(11).getText());
}
if(PassNumbersAfterDelete.contains(SearchPassNumberAfterDelete)){
Reporter.log("8)Unable to Delete Added Visitor Details", true);	
}else{
Reporter.log("8)Added Visitor Details Deleted Sucessfully", true);	
}}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement VisitorsAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfVisitorsAfterDelete=VisitorsAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>PassNumbersAfterDelete=new ArrayList<String>();
for(int RowsInVisitorRegister=1;RowsInVisitorRegister<RowsOfVisitorsAfterDelete.size();RowsInVisitorRegister++){
List<WebElement>ColoumnsInVisitors=RowsOfVisitorsAfterDelete.get(RowsInVisitorRegister).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
PassNumbersAfterDelete.add(ColoumnsInVisitors.get(11).getText());
}
if(PassNumbersAfterDelete.contains(SearchPassNumberAfterDelete)){
Reporter.log("8)Unable to Delete Added Visitor Details", true);	
}else{
Reporter.log("8)Added Visitor Details Deleted Sucessfully", true);	
}}}
else{
Reporter.log("5)PassNumber Of newly added VisitorRegister Unable to Edited ", true);	
}}
else{
Reporter.log("5)PassNumber Of newly added VisitorRegister Unable to Edited ", true);	
}}
else{
Reporter.log("3)Unable To Add VisitorDetails/Unable Find Added Details", true);	
}}
else{
Reporter.log("3)Unable To Add Visitor Details/Unable To Find Added Details", true);	
}	}
@Test(priority=3)	
public void Export() throws Exception{
helper.ClickByXpath(VariableCalling.ClickExportButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickPdfButton);
Thread.sleep(4000);
Reporter.log("visitor registor export to pdf", true);	
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminVisitorRegisterPdf .png"));	
	}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddVisitorDetails.png" + " AddVisitorDetails", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditVisitorDetails.png" + " EditVisitorDetails", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminVisitorRegisterPdf .png" + " AdminVisitorRegisterPdf", true);	
Reporter.log(" ", true);	
	
}


}
