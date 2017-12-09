package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminPostageandcourier extends TestBase{
boolean PostageDate;
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->PostageAndCourier", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2,dataProvider="AdminPostageAndCourier",dataProviderClass= DataProvider3.class)
public void AddEditAndDeleteCourierDetails(String EnterCourierName,String EnterCourierTo,String EnterCourierContact,String EnterCourierrecievedByWhome,String EnterNameOfCourierHandOverToWhome,String SearchCourierContactAfterAdd,String SearchCourierContactNumberForEditing,String EnterCourierContactNumberToEdit,String SearchCourierContactAfterEdit,String SearchCourierContactNumberAfterDelete,String EnterFromDateToGetDetails,String EnterFromDateToSearch) throws InterruptedException, IOException, ParseException{

helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnPostageANdCourierRegistorButton);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("CourierName",EnterCourierName);
helper.SetValueByID("CourierTo", EnterCourierTo);	
helper.ClickByXpath(VariableCalling.ClickOnDropDownListOfBlockInPostageANdCourier);
helper.Sleep();
helper.ClickByLinkText(GlobalVariablesCalling.EnterMemberBlockName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnDropDownlistOfApartmentInPostageCourier);
helper.Sleep();
helper.ClickByLinkText(GlobalVariablesCalling.EnterMemberApartmentNumber);
helper.DeepSleep();
helper.SetValueByID("CourierContact", EnterCourierContact);
helper.SetValueByID("ReceivedBy", EnterCourierrecievedByWhome);
helper.SetValueByID("HandedOverTo", EnterNameOfCourierHandOverToWhome);  
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInPostageAndCourier);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement PostageAndCourier=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfPostageAndCourier=PostageAndCourier.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ContactNumbers=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfPostageAndCourier.size();Rows++){
List<WebElement>ColoumnsOfPostageAndCourier=RowsOfPostageAndCourier.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String Blockname=ColoumnsOfPostageAndCourier.get(4).getText();
String ApartmentNumber=ColoumnsOfPostageAndCourier.get(5).getText();

if(Blockname.equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ApartmentNumber.equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
ContactNumbers.add(ColoumnsOfPostageAndCourier.get(7).getText());
}}}

if(ContactNumbers.contains(SearchCourierContactAfterAdd)){
Reporter.log("Courier Details Added Sucessfully", true);		
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.EnterBlockNameToSearch);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling. EnterDataToSearchInRegularVendors, GlobalVariablesCalling.EnterMemberBlockName);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
WebElement PostageAndCouriers=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfPostageAndCouriers=PostageAndCouriers.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int Row=1;Row<RowsOfPostageAndCouriers.size();Row++){
List<WebElement>ColoumnsOfPostageAndCouriers=RowsOfPostageAndCouriers.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfPostageAndCouriers.get(4).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfPostageAndCouriers.get(5).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){	
if(ColoumnsOfPostageAndCouriers.get(7).getText().equals(SearchCourierContactNumberForEditing)){
if(ColoumnsOfPostageAndCouriers.get(2).getText()==null){
Reporter.log("Courier Date And Time Unable To Filled Automatically", true);	
}
else{
Reporter.log("Courier Date And Time Filled Automatically", true);	
Reporter.log("Courier Date And Time"+ColoumnsOfPostageAndCouriers.get(2).getText(), true);	
}
Reporter.log("Contact Number Of Courier Before Editing: "+ColoumnsOfPostageAndCouriers.get(7).getText(), true);	
ColoumnsOfPostageAndCouriers.get(7).click();
File AddedCourierDetails=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedCourierDetails, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedCourierDetails.png"));
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("CourierContact", EnterCourierContactNumberToEdit);
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInPostageAndCourier);
WebElement Couriers=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsinCouriers=Couriers.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
for(int Rows=1;Rows<RowsinCouriers.size();Rows++){
List<WebElement>ColoumnsOfCouriers=RowsinCouriers.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfCouriers.get(4).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfCouriers.get(5).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(ColoumnsOfCouriers.get(7).getText().equals(SearchCourierContactAfterEdit)){
Reporter.log("Courier Details Edited Sucessfully", true);	
if(ColoumnsOfCouriers.get(10).getText()==null){
Reporter.log("Handed Over On Date Not Filled Automatically While Editing", true);	
}
else{
Reporter.log("Handed Over On Date Filled Automatically While Editing", true);	
Reporter.log("Handed Over Date: "+ColoumnsOfCouriers.get(10).getText(), true);	
	}
Reporter.log("Contact Number Of Courier After Editing: "+ColoumnsOfCouriers.get(7).getText(), true);	
helper.DeepSleep();
File EditedCourierDetails=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedCourierDetails, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedCourierDetails.png"));
helper.ClickByID(VariableCalling.ClickONDeleteButton);
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
WebElement Courier=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfCourier=Courier.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>CourierContactNumbers=new ArrayList<String>();		
for(int CourierRows=1;CourierRows<RowsOfCourier.size();CourierRows++){
List<WebElement>ColoumnsOfCourier=RowsOfCourier.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfCourier.get(4).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfCourier.get(5).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
CourierContactNumbers.add(ColoumnsOfCourier.get(7).getText());
}}}
if(CourierContactNumbers.contains(SearchCourierContactNumberAfterDelete)){
Reporter.log("Added Courier Details Unable to Delete", true);	
}
else{
Reporter.log("Added Courier Details Deleted Sucessfully", true);	
}}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement Courier=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfCourier=Courier.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>CourierContactNumbers=new ArrayList<String>();		
for(int CourierRows=1;CourierRows<RowsOfCourier.size();CourierRows++){
List<WebElement>ColoumnsOfCourier=RowsOfCourier.get(CourierRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfCourier.get(4).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfCourier.get(5).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
CourierContactNumbers.add(ColoumnsOfCourier.get(7).getText());
}}}
if(CourierContactNumbers.contains(SearchCourierContactNumberAfterDelete)){
Reporter.log("Added Courier Details Unable to Delete", true);	
}else{
Reporter.log("Added Courier Details Deleted Sucessfully", true);	
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.EnterFromDate, EnterFromDateToGetDetails);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).sendKeys(Keys.TAB);
helper.SetValueByXpath(VariableCalling.EnterToDate, MethodsCalling.CurrentDate());
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).sendKeys(Keys.TAB);
helper.ClickByXpath(VariableCalling.ClickOnGetDetailsButton);
helper.DeepSleep();
WebElement PostagesAndCouriers=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfPostagesAndCouriers=PostagesAndCouriers.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>PostageDates=new ArrayList<String>();	
for(int CourierRows=1;CourierRows<RowsOfPostagesAndCouriers.size();CourierRows++){
List<WebElement>ColoumnsOfPostages=RowsOfPostagesAndCouriers.get(CourierRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String DatesInList=ColoumnsOfPostages.get(2).getText();
String CourierDatesinCouriers=DatesInList.substring(0, 10);
//SimpleDateFormat Date = new SimpleDateFormat(VariableCalling.EnterDateFormate);
PostageDates.add(CourierDatesinCouriers);
}
SimpleDateFormat Date = new SimpleDateFormat(VariableCalling.EnterDateFormate);

for(int Dates=0;Dates<PostageDates.size();Dates++){
	if(PostageDates.get(Dates)==MethodsCalling.CurrentDate() && PostageDates.get(Dates)==EnterFromDateToSearch){
		PostageDate=true;
	}
	else{
		if(Date.parse(PostageDates.get(Dates)).before(Date.parse(MethodsCalling.CurrentDate())) && Date.parse(PostageDates.get(Dates)).after(Date.parse(EnterFromDateToSearch))){
	
		PostageDate=true;
	}
	else{
		PostageDate=false;
	}	
	}
	}	
	}
	
break;	
}}}}}}}}
if(PostageDate=true){
	Thread.sleep(2000);
	Reporter.log("GetDetails By GIven From And To Dates Are Filtered With In That Range", true);	
	Thread.sleep(1000);
	}
else{
	Thread.sleep(2000);
	Reporter.log("GetDetails By GIven From And To Dates Are Not Filtered With In That Range", true);	
	Thread.sleep(1000);
}}}
else{
Reporter.log("Courier Details Unable To Add", true);	
}

}

@Test(priority=3)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
SeleniumHelper.driver.navigate().refresh();
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInPostageAndCourier);
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInPostageAndCourier);
Thread.sleep(3000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminPostageAndCourierPDF .png"));	
}

@Test(priority=4)
public void Results(){
	Reporter.log(" ", true);	
	Reporter.log("Files Stored in (Path Name)", true);	
	Reporter.log("-----------------------------", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedCourierDetails.png" +  "  AddedCourierDetails", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedCourierDetails.png" + " EditedCourierDetails", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminPostageAndCourierPDF .png" + " AdminPostageAndCourierPDF", true);	
	Reporter.log(" ", true);	

}


}
