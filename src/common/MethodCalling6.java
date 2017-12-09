package common;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
public class MethodCalling6 {
protected static SeleniumHelper helper = new SeleniumHelper();
public void AddFacilityForOthers(String EnterFacilityName,String LinkParentFacility,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterMinimumHours,String EnterAmountForMinimumHours,String EnterCancelCharges,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
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
Thread.sleep(2000);
helper.SetValueByID("Amt1", EnterAmountForMinimumHours);
Thread.sleep(2000);
helper.SetValueByID("CancelCharges", EnterCancelCharges);
Thread.sleep(2000);
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
		helper.TakeScreenShot("PaidFacilityOnlyForOthers");
		try{
		String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
		Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
		String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
		Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
		FacilityColoumns.get(2).click();
		}catch(NoSuchElementException Exception){
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
	public void AddfacilityWithRatesForBoth(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterMinimumHours,String EnterAmountForMinimumHours,String EnterPackageHours,String EnterAmountForPackageHours,String EnterCancelCharges,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
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
		Thread.sleep(2000);
		helper.SetValueByID("Amt1", EnterAmountForMinimumHours);
		Thread.sleep(2000);
		helper.SetValueByID("M4", EnterPackageHours);
		helper.SetValueByID("Amt4", EnterAmountForPackageHours);
		helper.SetValueByID("CancelCharges", EnterCancelCharges);
		Thread.sleep(2000);
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
		helper.TakeScreenShot("PaidFacilityOnlyForBoth");
		try{
		String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
		Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
		String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
		Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
		FacilityColoumns.get(2).click();
		}catch(NoSuchElementException Exception){
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
	
public void AddFacilityWithHourlyhalfDayFullDayPriceDetails(String EnterFacilityName,String EnterContactPersonName,String EnterContactNumber,String RatesFor,String FromTime,String ToTime,String EnterMinimumHours,String EnterAmountForMinimumHours,String EnterMinimumHoursOfHalfDay,String EnterAmountForMinimumHoursOfHalfDay,String EnterMinimumHoursOfFullDay,String EnterAmountForMinimumHoursOfFullDay,String EnterFacilityNameToSearch,String AddedFacilityName) throws InterruptedException, IOException{
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
	Thread.sleep(2000);
	helper.SetValueByID("Amt1", EnterAmountForMinimumHours);
	Thread.sleep(2000);
	helper.SetValueByID("M2", EnterMinimumHoursOfHalfDay);
	helper.SetValueByID("Amt2", EnterAmountForMinimumHoursOfHalfDay);
	helper.SetValueByID("M3", EnterMinimumHoursOfFullDay);
	helper.SetValueByID("Amt3", EnterAmountForMinimumHoursOfFullDay);
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
	helper.TakeScreenShot("PaidFacilityWithHourly,HalfDayAndFulldayPrices");
	try{
	String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
	Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
	FacilityColoumns.get(2).click();
	}catch(NoSuchElementException Exception){
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
	}	}
	
public void CancelFacility(String DescriptionOfFacility) throws InterruptedException, IOException, HeadlessException, AWTException{
Calendar calObject = Calendar.getInstance();
calObject.add(Calendar.DAY_OF_YEAR, 1);
WebElement dateWidget = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyCalander));  
List<WebElement> cellrows = dateWidget.findElements(By.cssSelector(VariableCalling2.IdentifyingCalanderRows));
loop1:for (int row = 0; row < 5; row++) {
List<WebElement> columns = cellrows.get(row).findElements(By.tagName(VariableCalling2.IdentifyingCalanderDates));
for (int coloumn = 0; coloumn < 14; coloumn++) {
String givendate = columns.get(coloumn).getText();
if(givendate.length()==1){
String tomorrowDate = new SimpleDateFormat("d").format(calObject.getTime());
if (givendate.equals(tomorrowDate))
{
columns.get(coloumn).click();
helper.DeepSleep();
WebElement Event = SeleniumHelper.driver.findElement(By.id(VariableCalling2.ListofEvents)); 
helper.Sleep();
List<WebElement> ListOfEvents = Event.findElements(By.tagName(VariableCalling2.SearchingEachevent));
helper.Sleep();
for(int j=1;j<ListOfEvents.size();j++){
String Description=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();
if(Description.equals(DescriptionOfFacility)){
String ColourOfEvents=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);
if(ColourOfEvents.equals(VariableCalling.RGBAValueOfOrnage)){
ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).click();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling.CancelButton)).click();
helper.DeepSleep();

break;} } }
break loop1;
}}
else{
String tomorrowDate = new SimpleDateFormat("dd").format(calObject.getTime());
if (givendate.equals(tomorrowDate))
{
columns.get(coloumn).click();
helper.DeepSleep();
WebElement Event = SeleniumHelper.driver.findElement(By.id(VariableCalling2.ListofEvents));  
helper.Sleep();
List<WebElement> ListOfEvents = Event.findElements(By.tagName(VariableCalling2.SearchingEachevent));
helper.Sleep();
for(int j=0;j<ListOfEvents.size();j++){
String Description=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();
if(Description.equals(DescriptionOfFacility)){
String ColourOfEvents=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);
if(ColourOfEvents.equals(VariableCalling.RGBAValueOfOrnage)){
Reporter.log("Colour Of Added Facility In Calendar is Orange", true);
ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).click();
helper.DeepSleep();

SeleniumHelper.driver.findElement(By.id(VariableCalling.CancelButton)).click();
helper.MaxSleep();

break;} } }
break loop1;
	}               			                                            		  
                			                                            		  
	}}}    }     	}
