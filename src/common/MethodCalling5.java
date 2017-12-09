package common;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
public class MethodCalling5 {
protected static SeleniumHelper helper = new SeleniumHelper();
public void AddFacility(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterMinimumHoursOfHalfDay,String EnterAmountForMinimumHoursOfHalfDay,String EnterMinimumHoursOfFullDay,String EnterAmountForMinimumHoursOfFullDay,String EnterPackageHours,String EnterAmountForPackageHours,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
helper.SetValueByID("FacilityName", EnterFacilityName);
helper.SetValueByID("ContactPerson", EnterContactPersonName);
helper.SetValueByID("ContactNumber", EnterContactNumber);
helper.ClickByXpath(VariableCalling2.ClickOnRatesForDropDownButton);
helper.Sleep();
helper.ClickByLinkText(RatesFor);
helper.DeepSleep();
helper.ClearElementById("timepicker3");
helper.SetValueByID("timepicker3", FromTime);
helper.ClearElementById("timepicker4");
helper.SetValueByID("timepicker4", ToTime);
helper.ClickByID(VariableCalling2.SelectIsBookingAllowedCheckBox);
helper.ClickByID(VariableCalling2.SelectIsPaidCheckBox);
helper.SetValueByID("M2", EnterMinimumHoursOfHalfDay);
helper.SetValueByID("Amt2", EnterAmountForMinimumHoursOfHalfDay);
helper.SetValueByID("M3", EnterMinimumHoursOfFullDay);
helper.SetValueByID("Amt3", EnterAmountForMinimumHoursOfFullDay);
helper.SetValueByID("M4", EnterPackageHours);
helper.SetValueByID("Amt4", EnterAmountForPackageHours);
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
String FacilityName=FacilityColoumns.get(2).getText();
if(FacilityName.equals(AddedFacilityName)){
Reporter.log("Facility Added Sucessfully", true);
helper.TakeScreenShot("PaidFacilityWithHalfDay,FulldayAndPackagePrices");
FacilityColoumns.get(2).click();
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
}catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available", true);
System.out.println();
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
}}
else{
Reporter.log("Facility Unable Not Added Sucessfully", true);
}}
catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}}
public void AddFreeFacility(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
helper.SetValueByID("FacilityName", EnterFacilityName);
helper.SetValueByID("ContactPerson", EnterContactPersonName);
helper.SetValueByID("ContactNumber", EnterContactNumber);
helper.ClickByXpath(VariableCalling2.ClickOnRatesForDropDownButton);
helper.Sleep();
helper.ClickByLinkText(RatesFor);
helper.DeepSleep();
helper.ClearElementById("timepicker3");
helper.SetValueByID("timepicker3", FromTime);
helper.ClearElementById("timepicker4");
helper.SetValueByID("timepicker4", ToTime);
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
String FacilityName=FacilityColoumns.get(2).getText();
if(FacilityName.equals(AddedFacilityName)){
Reporter.log("Facility Added Sucessfully", true);
helper.TakeScreenShot("AddedFacilityWithNotAllowedBooking");
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
helper.DeepSleep();
FacilityColoumns.get(2).click();
}
catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available", true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
helper.DeepSleep();
FacilityColoumns.get(2).click();
}}
else{
Reporter.log("Facility Unable Not Added Sucessfully", true);
}}
catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}		}
public void AddFacilityWith30mintsslot(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String SlotDuration,String EnterFacilityNameToSearch,String AddedFacilityName) throws IOException{
helper.SetValueByID("FacilityName", EnterFacilityName);
helper.SetValueByID("ContactPerson", EnterContactPersonName);
helper.SetValueByID("ContactNumber", EnterContactNumber);
helper.ClickByXpath(VariableCalling2.ClickOnRatesForDropDownButton);
helper.Sleep();
helper.ClickByLinkText(RatesFor);
helper.DeepSleep();
helper.ClearElementById("timepicker3");
helper.SetValueByID("timepicker3", FromTime);
helper.ClearElementById("timepicker4");
helper.SetValueByID("timepicker4", ToTime);
helper.ClickByID(VariableCalling2.SelectIsBookingAllowedCheckBox);
helper.ClickByXpath(VariableCalling2.ClickOnSlotDurationDropDown);
List<WebElement>SlotDurationList=SeleniumHelper.driver.findElements(By.xpath("//*[@id='BookingSlot']//option"));
for(int i=0;i<SlotDurationList.size();i++){
String Duration=SlotDurationList.get(i).getAttribute("value");
WebElement Slot=SlotDurationList.get(i);
if(Duration.equals(SlotDuration)){
helper.doubleclick(Slot);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInFacility);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
try{
List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String FacilityName=FacilityColoumns.get(2).getText();
if(FacilityName.equals(AddedFacilityName)){
Reporter.log("Facility Added Sucessfully", true);
helper.TakeScreenShot("AddedFacilityWithAllowedBookingWithSlotDurationOf30Mints");
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
FacilityColoumns.get(2).click();
}
catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available", true);
System.out.println();
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
FacilityColoumns.get(2).click();
}}
else{
Reporter.log("Facility Unable Not Added Sucessfully", true);
}}
catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}break;
}}}
public void AddFacilityForOwners(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterMinimumHours,String EnterAmountForMinimumHours,String EnterCancelCharges,String EnterFacilityNameToSearch,String AddedFacilityName) throws IOException{

helper.SetValueByID("FacilityName", EnterFacilityName);
helper.SetValueByID("ContactPerson", EnterContactPersonName);
helper.SetValueByID("ContactNumber", EnterContactNumber);
helper.ClickByXpath(VariableCalling2.ClickOnRatesForDropDownButton);
helper.Sleep();
helper.ClickByLinkText(RatesFor);
helper.DeepSleep();
helper.ClearElementById("timepicker3");
helper.SetValueByID("timepicker3", FromTime);
helper.ClearElementById("timepicker4");
helper.SetValueByID("timepicker4", ToTime);
helper.ClickByID(VariableCalling2.SelectIsBookingAllowedCheckBox);
helper.ClickByID(VariableCalling2.SelectIsPaidCheckBox);
helper.SetValueByID("M1", EnterMinimumHours);
helper.Sleep();
helper.SetValueByID("Amt1", EnterAmountForMinimumHours);
helper.Sleep();
helper.SetValueByID("CancelCharges", EnterCancelCharges);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInFacility);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
helper.DeepSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
try{
List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String FacilityName=FacilityColoumns.get(2).getText();
if(FacilityName.equals(AddedFacilityName)){
Reporter.log("Facility Added Sucessfully", true);
helper.TakeScreenShot("PaidFacilityOnlyForOwners");
try{
String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
FacilityColoumns.get(2).click();
}catch(NoSuchElementException Exception){
Reporter.log("Booking Button Not Available", true);
String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
FacilityColoumns.get(2).click();
}}
else{
Reporter.log("Facility Unable Not Added Sucessfully", true);
}}
catch(NoSuchElementException Exception){
Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
}	}
public void AddFacilityForTenant(String EnterFacilityName,String LinkParentFacility,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterMinimumHours,String EnterAmountForMinimumHours,String EnterCancelCharges,String EnterFacilityNameToSearch,String AddedFacilityName) throws IOException{
	helper.SetValueByID("FacilityName", EnterFacilityName);
	helper.SetValueByID("auto_BaseFacility", LinkParentFacility);
	
			
	helper.SetValueByID("ContactPerson", EnterContactPersonName);
	helper.SetValueByID("ContactNumber", EnterContactNumber);
	helper.ClickByXpath(VariableCalling2.ClickOnRatesForDropDownButton);
	helper.Sleep();
	helper.ClickByLinkText(RatesFor);
	helper.DeepSleep();
	helper.ClearElementById("timepicker3");
	helper.SetValueByID("timepicker3", FromTime);
	helper.ClearElementById("timepicker4");
	helper.SetValueByID("timepicker4", ToTime);
	helper.ClickByID(VariableCalling2.SelectIsBookingAllowedCheckBox);
	helper.ClickByID(VariableCalling2.SelectIsPaidCheckBox);
	helper.SetValueByID("M1", EnterMinimumHours);
    helper.Sleep();
	helper.SetValueByID("Amt1", EnterAmountForMinimumHours);
	helper.Sleep();
	helper.SetValueByID("CancelCharges", EnterCancelCharges);
	helper.Sleep();
	helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInFacility);
	helper.MaxSleep();
	helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
	helper.Sleep();
	helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
	helper.MaxSleep();
	helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
	helper.MaxSleep();
	helper.ClickByXpath(VariableCalling.ClickOnFindButton);
	helper.MaxSleep();
	helper.ClickByXpath(VariableCalling.CloseSearchFunction);
	helper.MaxSleep();
	WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
	List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
	try{
	List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
	String FacilityName=FacilityColoumns.get(2).getText();
	if(FacilityName.equals(AddedFacilityName)){
	Reporter.log("Facility Added Sucessfully", true);
	helper.TakeScreenShot("PaidFacilityOnlyForTenants");
	try{
	String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
	Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
	FacilityColoumns.get(2).click();
	}
	catch(NoSuchElementException Exception){
	Reporter.log("Booking Button Not Available", true);
	System.out.println();
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
	FacilityColoumns.get(2).click();
	}}
	else{
	Reporter.log("Facility Unable Not Added Sucessfully", true);
	}}
	catch(NoSuchElementException Exception){
	Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
	}
}



}
