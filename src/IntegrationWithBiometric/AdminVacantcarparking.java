package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.HeadlessException;
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
import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
import common.variablecalling3;
public class AdminVacantcarparking extends TestBase{
String parkingLotNumber;
String parkingLocatedAt;
String NameOfIncharge;
String ContactNumber;
String VehicleNumber;
@Test(priority=1)
public void Login(){
Reporter.log("Script Name:Admin---->Application--->AdminVacantcarparking", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2,dependsOnMethods="Login",dataProvider="vacantcarparking",dataProviderClass= DataProvider8.class)
public void Addvacantcarparking(String ParkingLotNumber,String LocatedAt,String InchargeName,String ContactNo,String VehicleNo) throws InterruptedException, IOException{
parkingLotNumber=ParkingLotNumber;
parkingLocatedAt=LocatedAt;
NameOfIncharge=InchargeName;
ContactNumber=ContactNo;
VehicleNumber=VehicleNo;


helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnCarParkingLotsButton);
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.VacantcarparkingButton);
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.SetValueByID("ParkingLotNo", parkingLotNumber);
helper.SetValueByID("LocatedAt", parkingLocatedAt);
helper.SetValueByID("InchargeName", NameOfIncharge);
helper.SetValueByID("ContactNo", ContactNumber);
helper.SetValueByID("VehicleNo", VehicleNumber);
helper.Sleep();
helper.ClickByXpath(variablecalling3.SaveButtonInCarparkinglots);
helper.Sleep();

helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.SelectCarparkingLotNumberInSearchFunction);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, parkingLotNumber);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();	
String ParkingLotNo=helper.GetValueByXpath(variablecalling3.DataAfterSearch);
if(ParkingLotNo.equals(parkingLotNumber)){
Reporter.log("1) Vacant Car parking Details Added Sucessfully ",true);
Reporter.log("1.a) Added car parking lot number: "+ParkingLotNo, true);
		}
else{
Reporter.log("1) Vacant Carparking Details Unable To Add Or Search With ParkingLotNumber Failed", true);
helper.TakeScreenShot("Unable To Add Vacant CarparkingLot");	

}
}
@Test(priority=3,dependsOnMethods="Addvacantcarparking",dataProvider="EditCarparkingDetails",dataProviderClass= DataProvider8.class)
public void EditAndDelete(String ParkingLotNumberToEdit) throws InterruptedException, IOException{
String EditedCarparkingLotNumber=ParkingLotNumberToEdit;
helper.TakeScreenShot("Added VacantCarParking details");

helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("ParkingLotNo", EditedCarparkingLotNumber);
helper.Sleep();
helper.ClickByXpath(variablecalling3.SaveButtonInCarparkinglots);
helper.Sleep();
helper.RefreshPage();
helper.DeepSleep();
WebElement vacantcarparking=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

List<WebElement>RowsOfparkinglots=vacantcarparking.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ParkingLotNumberlist=new ArrayList<String>();
for(int rows=1;rows<RowsOfparkinglots.size();rows++){
List<WebElement>ColoumnsInparkinglots=RowsOfparkinglots.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
ParkingLotNumberlist.add(ColoumnsInparkinglots.get(2).getText());	
}
if(ParkingLotNumberlist.contains(EditedCarparkingLotNumber)){
Reporter.log("2) Carparking details edited sucessfully", true);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.SelectCarparkingLotNumberInSearchFunction);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, EditedCarparkingLotNumber);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();	
helper.TakeScreenShot("Edited Vacant Car Parking Details ");
String ParkingLotNoAfterEdit=helper.GetValueByXpath(variablecalling3.DataAfterSearch);
Reporter.log("2.a) Car Parking Lot No After Editing Is: "+ParkingLotNoAfterEdit, true);
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement parkinglots=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
helper.DeepSleep();
}
WebElement parkinglots=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Parkinglotsrows=parkinglots.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
List<String>CarparkinglotNo=new ArrayList<String>();
for(int EventRows=1;EventRows<Parkinglotsrows.size();EventRows++){
List<WebElement>ParkinglotsColoumns=Parkinglotsrows.get(EventRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
CarparkinglotNo.add(ParkinglotsColoumns.get(2).getText());	
}
if(CarparkinglotNo.contains(EditedCarparkingLotNumber)){
Reporter.log("3) Added CarParking Lot Details Unable To Delete ", true);	
}
else{
Reporter.log("3) Added CarParking Lot Details Deleted Sucessfully ", true);	
}	}
else{
Reporter.log("2) Carparking details unable to edit", true);}
}
@Test(priority=4,dependsOnMethods="EditAndDelete",dataProvider="vacantcarparking",dataProviderClass= DataProvider8.class)
public void AddRecord(String ParkingLotNumber,String LocatedAt,String InchargeName,String ContactNo,String VehicleNo ) throws InterruptedException, IOException{
Addvacantcarparking(ParkingLotNumber, LocatedAt, InchargeName, ContactNo, VehicleNo);
helper.TakeScreenShot("Added carparking lot number with "+ParkingLotNumber);
Reporter.log("4) File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added carparking lot number with "+ParkingLotNumber ,true);	
}
@Test(priority=5,dependsOnMethods="AddRecord",dataProvider="addvacantcarparking",dataProviderClass= DataProvider8.class)
public void AddOneMoreRecord(String ParkingLotNumber,String LocatedAt,String InchargeName,String ContactNo,String VehicleNo ) throws InterruptedException, IOException, HeadlessException, AWTException{
Addvacantcarparking(ParkingLotNumber, LocatedAt, InchargeName, ContactNo, VehicleNo);
helper.TakeScreenShot("Added carparking lot number with "+ParkingLotNumber);
Reporter.log("5) File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added carparking lot number with "+ParkingLotNumber ,true);

}
@Test(priority=6,dependsOnMethods="AddOneMoreRecord")
public void AnyTextSearchAndExport() throws HeadlessException, IOException, AWTException, InterruptedException{
helper.DeepSleep();
helper.RefreshPage();
helper.Sleep();
helper.SetValueByXpath(variablecalling3.AnyTextSearchBox, parkingLotNumber);
helper.Sleep();
helper.ClickByXpath(variablecalling3.AnyTextSearchButton);
String ParkingLotNumberAfterSearch=helper.GetValueByXpath(variablecalling3.DataAfterSearch);
if(ParkingLotNumberAfterSearch.equals(parkingLotNumber)){
Reporter.log("6) AnyText Search with parkinglot number is working fine", true);
helper.TakeScreenShot("Search with parkinglot number"+parkingLotNumber);
}
else{
Reporter.log("6) AnyText Search with parkinglot number is Not working ", true);
}
helper.SetValueByXpath(variablecalling3.AnyTextSearchBox, parkingLocatedAt);
helper.Sleep();
helper.ClickByXpath(variablecalling3.AnyTextSearchButton);
String LocatedAtAfterSearch=helper.GetValueByXpath(variablecalling3.LocatedAtColoumDataAfterSearch);
if(LocatedAtAfterSearch.equals(parkingLocatedAt)){
Reporter.log("7) AnyText Search with LocatedAt is working fine", true);
helper.TakeScreenShot("Search with LocatedAt"+parkingLocatedAt);
	}
else{
Reporter.log("7) AnyText Search with LocatedAt is Not working ", true);	
}
helper.SetValueByXpath(variablecalling3.AnyTextSearchBox, NameOfIncharge);
helper.Sleep();
helper.ClickByXpath(variablecalling3.AnyTextSearchButton);
String NameOfInchargeAfterSearch=helper.GetValueByXpath(variablecalling3.InchargeNameColoumDataAfterSearch);
if(NameOfInchargeAfterSearch.equals(NameOfIncharge)){
Reporter.log("8) AnyText Search with NameOfIncharge is working fine", true);
helper.TakeScreenShot("Search with NameOfIncharge"+NameOfIncharge);
	}
else{
Reporter.log("8) AnyText Search with NameOfIncharge is Not working ", true);	
}
helper.SetValueByXpath(variablecalling3.AnyTextSearchBox, ContactNumber);
helper.Sleep();
helper.ClickByXpath(variablecalling3.AnyTextSearchButton);
String ContactNumberAfterSearch=helper.GetValueByXpath(variablecalling3.ContactNumberColoumDataAfterSearch);

if(ContactNumberAfterSearch.equals(ContactNumber)){
Reporter.log("9) AnyText Search with ContactNumber is working fine", true);
helper.TakeScreenShot("Search with ContactNumber"+ContactNumber);
}
else{
Reporter.log("9) AnyText Search with ContactNumber is Not working ", true);	
}
helper.SetValueByXpath(variablecalling3.AnyTextSearchBox, VehicleNumber);
helper.Sleep();
helper.ClickByXpath(variablecalling3.AnyTextSearchButton);
String VehicleAfterSearch=helper.GetValueByXpath(variablecalling3.VehicleNumberColoumDataAfterSearch);
if(VehicleAfterSearch.equals(VehicleNumber)){
Reporter.log("10) AnyText Search with VehicleNumber is working fine", true);
helper.TakeScreenShot("Search with VehicleNumber"+VehicleNumber);
}
else{
Reporter.log("10) AnyText Search with VehicleNumber is Not working ", true);	
}
helper.RefreshPage();
helper.Sleep();
helper.ClickByXpath(variablecalling3.ExportButtonInCarparkinglots);
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.PDFButtonIncarparkinglots);
helper.DeepSleep();
helper.TakeScreenShotOfExportPDF("AdminVacantCarparkingPdf");
}
@Test(priority=7,dependsOnMethods="AnyTextSearchAndExport")
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added VacantCarParking details" , true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Vacant Car Parking Details" , true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminVacantCarparkingPdf" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search with parkinglot number"+parkingLotNumber , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search with LocatedAt"+parkingLocatedAt , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search with NameOfIncharge"+NameOfIncharge, true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search with ContactNumber"+ContactNumber, true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search with VehicleNumber"+VehicleNumber, true);
Reporter.log(" ", true);	

}
	}

