package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.MethodCalling7;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
import common.variablecalling3;
public class AssignVacantCaraprkingToVisitors extends TestBase{
boolean acceptNextAlert;
public static String PassNo;
public static String parkinglot;
public String OutTimeInSavedRecord;
public static String ParkinglotNumber;
@Test(priority=1)
public void Login(){
Reporter.log("Script Name:Admin---->Application--->VisitorRegister", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnVisitorRegestor);

}
@Test(priority=2,dataProvider="Visitor",dataProviderClass= DataProvider8.class)
public void AddVisitorRecord(String EnterVisitorName,String EnterVisitorContactNumber,String EnterPersonTomeet, String EnterGate,String EnterPurpose,String EnterPassNo,String CarParkingLotNumber, String EnterVehicalNumber  ) throws InterruptedException, IOException, AWTException{
PassNo=EnterPassNo;
ParkinglotNumber=CarParkingLotNumber;
helper.DeepSleep();
Reporter.log("...........Adding Record With parking lot NUmber "+ParkinglotNumber+" ...........", true);
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.Sleep();
closeAlertAndGetItsText();
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("date")).clear();
SeleniumHelper.driver.findElement(By.id("date")).sendKeys(MethodsCalling.CurrentDate());
helper.Sleep();
helper.SetValueByID("VisitorName", EnterVisitorName);
helper.SetValueByID("ContactNo", EnterVisitorContactNumber);
helper.SetValueByID("PersonToMeet",EnterPersonTomeet);
helper.SetValueByID("Gate",EnterGate);
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.BlockDropDown);
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.ApartmentNumbersDropdown);
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.DeepSleep();
helper.SetValueByID("RefField", EnterPurpose);
String InTime=SeleniumHelper.driver.findElement(By.xpath(variablecalling3.InTimeField)).getAttribute("value");
String SystemTime= MethodsCalling.CurrentTime();
try{
Assert.assertEquals(InTime,SystemTime);
Reporter.log("1) In Time Filled Automatically Filled With System Time ", true);
helper.TakeScreenShot("Automatically Filled InTime InVisitor Register");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Automatically Filled InTime InVisitor Register" , true);

}
catch(AssertionError e){
if(InTime.isEmpty()){
Reporter.log("1) In Time Field Didnt Fill Automatically",true);
helper.TakeScreenShot("InTime Didn't Fill In Visitor Register");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"InTime Didn't Fill In Visitor Register" , true);
}
else{
Reporter.log("1) In Time Field Filled Automatically But It Didnt Match To Current System Time which is : "+InTime , true);
helper.TakeScreenShot("InTime Didn't Match With SystemTime");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"InTime Didn't Match With SystemTime" , true);
}}	  
helper.SetValueByID("PassNo", EnterPassNo);
helper.DeepSleep();
helper.ClickByCSSSelector(variablecalling3.CarparkinglotDropdown);
helper.TakeScreenShot("Available Car parkingLots");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Available Car parkingLots" , true);
WebElement Carparkinglots=SeleniumHelper.driver.findElement(By.id(variablecalling3.carparkinglotid));
List<WebElement> list=Carparkinglots.findElements(By.tagName(variablecalling3.listofdropdown));

Reporter.log("Available carparking lots are : ", true);

for(WebElement e : list) {
System.out.println(e.findElement(By.tagName("a")).getText());
}SeleniumHelper.driver.findElement(By.linkText(CarParkingLotNumber)).click();
helper.SetValueByID("VehicleNo", EnterVehicalNumber);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.UploadImage);
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
PassNumber.add(ColoumnsOfVisitors.get(3).getText());
}
if(DateInVisitorRegister.contains(MethodsCalling.CurrentDate())){
if(PassNumber.contains(PassNo)){
Reporter.log("2) New VisitorRegister Details Added To VisitorRegister List Sucessfully", true);	
}
else{
Reporter.log("3) Unable To Add Visitor Details ", true);
}}}
@Test(priority=3,dataProvider="VisitorRecord2",dataProviderClass= DataProvider8.class)
public void Add2ndRecord(String EnterVisitorName, String EnterVisitorContactNumber, String EnterPersonTomeet, String EnterGate, String EnterPurpose, String EnterPassNo, String CarParkingLotNumber, String EnterVehicalNumber,String FirstRecordPassNo) throws InterruptedException, IOException, AWTException{
parkinglot=FirstRecordPassNo;
Method7.AnotherAddVisitorRecord(EnterVisitorName, EnterVisitorContactNumber, EnterPersonTomeet, EnterGate, EnterPurpose, EnterPassNo, CarParkingLotNumber, EnterVehicalNumber);
//this.AddVisitorRecord(EnterVisitorName, EnterVisitorContactNumber, EnterPersonTomeet, EnterGate, EnterPurpose, EnterPassNo, CarParkingLotNumber, EnterVehicalNumber);
}
@Test(priority=4,dependsOnMethods="Add2ndRecord")
public void EditFirstRecord() throws InterruptedException, IOException{
Reporter.log("..............Editing Record Which is having carparking lot number of : "+parkinglot+" ...............", true);
helper.DeepSleep();
helper.RefreshPage();
helper.DeepSleep();
WebElement VisitorRegister=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfVisitors=VisitorRegister.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int Rows=1;Rows<RowsOfVisitors.size();Rows++){
List<WebElement>ColoumnsOfVisitors=RowsOfVisitors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
if(ColoumnsOfVisitors.get(11).getText().equals(parkinglot)){
ColoumnsOfVisitors.get(11).click();
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
closeAlertAndGetItsText();
helper.Sleep();
String OutTime=SeleniumHelper.driver.findElement(By.xpath(variablecalling3.OutTime)).getAttribute("value");
String SystemTime=MethodsCalling.CurrentTime();
try{
Assert.assertEquals(OutTime, SystemTime);
Reporter.log("1) Out Time Filled Automatically Filled With System Time as "+OutTime , true);

helper.TakeScreenShot("Out Time Filled Automatically Filled With System Time");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Out Time Filled Automatically Filled With System Time" , true);


}
catch(AssertionError e){
if(OutTime.isEmpty()){
Reporter.log("2) Out Time Field Didnt Fill Automatically",true);

helper.TakeScreenShot("Out Time Field Didnt Fill Automatically");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Out Time Field Didnt Fill Automatically" , true);


}
else{
Reporter.log("2) Out Time Field Filled Automatically But It Didnt Match To Current System Time which is ", true);
Reporter.log("Out Time while editing is : "+OutTime, true);
Reporter.log("System Time while editing : "+SystemTime, true);
helper.TakeScreenShot("Out Time Didn't Match System Time");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Out Time Didn't Match System Time" , true);

}}	
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInVisitorRegistor); 
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement Register=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>visitors=Register.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));	
for(int rows=1;rows<visitors.size();rows++){
List<WebElement>Coloumns=visitors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
if(Coloumns.get(11).getText().equals(parkinglot)){
OutTimeInSavedRecord=Coloumns.get(15).getAttribute("title");
break;
}}
if(OutTimeInSavedRecord.equals(OutTime)){
Reporter.log("3) Out Time saved sucessfully ", true);
}
else{
Reporter.log("3) Out Time While adding record,Out Time after record saved both are different", true);
Reporter.log("3) Out Time After record saved is : "+OutTimeInSavedRecord, true);
helper.TakeScreenShot("Out Time After saved Record");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Out Time After saved Record" , true);
}break;
}
}
}
@Test(priority=5,dependsOnMethods="EditFirstRecord")
public void AddRecordForSimulation() throws IOException{
Reporter.log("................Creating 3rd Visitor Register For Simulation......................", true);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnVisitorRegestor);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.Sleep();
closeAlertAndGetItsText();
helper.ClickByCSSSelector(variablecalling3.CarparkinglotDropdown);
helper.TakeScreenShot("Car parking lot screenshot while adding 3rd record");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Car parking lot screenshot while adding 3rd record" , true);
WebElement Carparkinglots=SeleniumHelper.driver.findElement(By.id(variablecalling3.carparkinglotid));
ArrayList<String> parkinglots=new ArrayList<>();
List<WebElement> list=Carparkinglots.findElements(By.tagName(variablecalling3.listofdropdown));
Reporter.log("Available carparking lots are : ", true);
for(WebElement e : list) {
Reporter.log(e.findElement(By.tagName("a")).getText(), true);

}
if(parkinglots.contains(parkinglot)){
Reporter.log("Car parking Lot Number "+parkinglot+" Is available to allot", true);
}
}

@Test(priority=6,dependsOnMethods="AddRecordForSimulation")
public void CheckStatusInvacantCarParking() throws InterruptedException, IOException{
Reporter.log("....................Checking Status In Vacant Car Parking..................", true);
helper.DeepSleep();
helper.RefreshPage();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnCarParkingLotsButton);
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.VacantcarparkingButton);
helper.Sleep();
WebElement vacantcarparking=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfparkinglots=vacantcarparking.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int rows=1;rows<RowsOfparkinglots.size();rows++){
List<WebElement>ColoumnsInparkinglots=RowsOfparkinglots.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsInparkinglots.get(2).getText().equals(MethodCalling7.SecondParkinglotNumber)){
Reporter.log("Status of "+MethodCalling7.SecondParkinglotNumber+" is : " +ColoumnsInparkinglots.get(7).getText(), true);

}

if(ColoumnsInparkinglots.get(2).getText().equals(parkinglot)){
Reporter.log("Status of "+parkinglot+" is : " +ColoumnsInparkinglots.get(7).getText(), true);
	
}

}
helper.TakeScreenShot("Status Of Parking Lots In Vacant Car parking");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Status Of Parking Lots In Vacant Car parking" , true);

}
@Test(priority=7,dependsOnMethods="CheckStatusInvacantCarParking")
public void EditingPreviouRecordAsFrequent() throws InterruptedException{
	
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	helper.DeepSleep();	
	helper.ClickByXpath(VariableCalling.ClickOnVisitorRegestor);
	helper.Sleep();
	Method7.EditRecordAsFrequent(parkinglot);
}

@Test(priority=8,dataProvider="Frequent",dataProviderClass= DataProvider8.class,dependsOnMethods="EditingPreviouRecordAsFrequent")
public void AssignCarparkingLotToFrequentVisitor(String VisitorName,String Gate,String VehicleNo,String PassNoForFrequentVisitor) throws IOException{
	helper.DeepSleep();
	Method7.AssignCarparkingLotToFrequentVisitor(VisitorName, Gate, VehicleNo, PassNoForFrequentVisitor, parkinglot);
	
}

@Test(priority=9,dependsOnMethods="AssignCarparkingLotToFrequentVisitor")
public void StatusCheckInVacantcarparking() throws InterruptedException, IOException{
	Reporter.log("....................Checking Status In Vacant Car Parking..................", true);
	helper.DeepSleep();
	helper.RefreshPage();
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.ClickOnCarParkingLotsButton);
	helper.DeepSleep();
	helper.ClickByXpath(variablecalling3.VacantcarparkingButton);
	helper.Sleep();

	WebElement vacantcarparking=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
	List<WebElement>RowsOfparkinglots=vacantcarparking.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
	for(int rows=1;rows<RowsOfparkinglots.size();rows++){
	List<WebElement>ColoumnsInparkinglots=RowsOfparkinglots.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
	if(ColoumnsInparkinglots.get(2).getText().equals(MethodCalling7.SecondParkinglotNumber)){
	Reporter.log("Status of "+MethodCalling7.SecondParkinglotNumber+" is : " +ColoumnsInparkinglots.get(7).getText(), true);
	}
	if(ColoumnsInparkinglots.get(2).getText().equals(parkinglot)){
	Reporter.log("Status of "+parkinglot+" is : " +ColoumnsInparkinglots.get(7).getText(), true);
	}
	
	}
	helper.TakeScreenShot("Status Of Parking Lots After Occupied In Vacant Car parking");
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Status Of Parking Lots After Occupied In Vacant Car parking" , true);

	}


private void closeAlertAndGetItsText() {
try {
	
 Alert alert = SeleniumHelper.driver.switchTo().alert();
 String alertText = alert.getText();
 Reporter.log("Un expected Popup came as : "+alertText, true);
 if (acceptNextAlert) {
    alert.accept();
     } else {
   alert.dismiss();
     }
   
    } catch(NoAlertPresentException e) {
  
		     }
finally{
	acceptNextAlert = true;
	
}
}


}
