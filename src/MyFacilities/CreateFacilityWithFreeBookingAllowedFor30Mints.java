package MyFacilities;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.DataProvider4;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class CreateFacilityWithFreeBookingAllowedFor30Mints extends TestBase {
@Test(priority=1,dataProvider="AddFreeFacilityWith30MintsSlot",dataProviderClass= DataProvider4.class)
public void AddFacility(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String SlotDuration,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
Reporter.log("Script Name:Admin---->Application--->MyFacilities--->Create one Facility with FREE - Allowed for Booking with 30 min booking Slot", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
helper.ClickElementByCssSelector(VariableCalling2.FacilityButton);
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
//AddFacilityWith30mintsslot(EnterFacilityName, EnterContactPersonName, EnterContactNumber, RatesFor, FromTime, ToTime, SlotDuration, EnterFacilityNameToSearch, AddedFacilityName);

Method5.AddFacilityWith30mintsslot(EnterFacilityName, EnterContactPersonName, EnterContactNumber, RatesFor, FromTime, ToTime, SlotDuration, EnterFacilityNameToSearch, AddedFacilityName);
}
@Test(priority=2,dataProvider="EditFreeFacilityWith30MintsSlot",dataProviderClass= DataProvider4.class)
	public void EditAndDeleteFacility(String EnterContactNumber,String EnterFacilityNameToSearch,String EditedContactNumber,String EnterFacilityNameToSearchAfterDelete) throws IOException, InterruptedException{
		helper.ClickByID(VariableCalling.ClickOnEditButton);
		helper.DeepSleep();
		helper.DeepSleep();
	helper.ClearElementById("ContactNumber");
	helper.SetValueByID("ContactNumber", EnterContactNumber);	
	helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInFacility);
	Thread.sleep(4000);
	helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
	Thread.sleep(2000);
	helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
	Thread.sleep(4000);
	helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
	Thread.sleep(4000);
	helper.ClickByXpath(VariableCalling.ClickOnFindButton);
	Thread.sleep(4000);
	helper.ClickByXpath(VariableCalling.CloseSearchFunction);
	Thread.sleep(4000);
	WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
	List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));

	try{
		List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		String PersonNumber=FacilityColoumns.get(8).getText();
		if(PersonNumber.equals(EditedContactNumber)){
		Reporter.log("Facility Details Edited Sucessfully", true);
		helper.TakeScreenShot("EditedFacilityWithAllowedBookingWithSlotDurationOf30Mints");
		FacilityColoumns.get(8).click();
		helper.ClickByID(VariableCalling.ClickONDeleteButton);
		helper.ProcessAlert();
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
		Thread.sleep(2000);
		helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
		Thread.sleep(4000);
		helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearchAfterDelete);
		Thread.sleep(4000);
		helper.ClickByXpath(VariableCalling.ClickOnFindButton);
		Thread.sleep(4000);
		helper.ClickByXpath(VariableCalling.CloseSearchFunction);
		Thread.sleep(4000);
		WebElement Facility=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
		List<WebElement>Rows=Facility.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		try{
			List<WebElement>Coloumns=Rows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
			Coloumns.size();
			Reporter.log("Facility Unable To Delete", true);
		}
		catch(IndexOutOfBoundsException Exception){
			Reporter.log("AddedFacility Deleted Sucessfully", true);
			helper.TakeScreenShot("AfterDeleteFacilityWithAllowedBookingWithSlotDurationOf30Mints");
		}
		
		}
		else{
		Reporter.log("Facility Unable To Edited Sucessfully", true);
		}}
		catch(NoSuchElementException Exception){
		Reporter.log("Search With Facility Name Not Working/Facility Not Found After Edit", true);
		}
	
}
@Test(priority=3,dataProvider="AddFreeFacilityWith30MintsSlot",dataProviderClass= DataProvider4.class)
public void AddFacilityAfterDelete(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String SlotDuration,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();	

Method5.AddFacilityWith30mintsslot(EnterFacilityName, EnterContactPersonName, EnterContactNumber, RatesFor, FromTime, ToTime, SlotDuration, EnterFacilityNameToSearch, AddedFacilityName);
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedFacilityWithAllowedBookingWithSlotDurationOf30Mints" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedFacilityWithAllowedBookingWithSlotDurationOf30Mints" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterDeleteFacilityWithAllowedBookingWithSlotDurationOf30Mints" , true);
	
}






}
