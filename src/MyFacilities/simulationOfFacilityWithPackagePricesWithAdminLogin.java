package MyFacilities;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider7;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class simulationOfFacilityWithPackagePricesWithAdminLogin extends TestBase{
	@Test(priority=1,dataProvider="SimulateFacilityWithPackagePricesfor1dayWithAdminLogin",dataProviderClass= DataProvider7.class)
	public void BookingFacility(String EnterFacilityNameToSearch,String FacilityName,String EnterFromTime,String EnterToTime,String EnterDescription) throws InterruptedException, IOException, HeadlessException, AWTException{
	Reporter.log("ScriptName:Admin Login  - Book for 1 day  (9 AM to Next day 9 AM) - Should show Rs. 1000", true);	
	Reporter.log("-----------------------------------------------------------------------------------------", true);
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
	helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
	helper.Sleep();
	helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
	helper.Sleep();
	helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
	helper.Sleep();
	helper.ClickByXpath(VariableCalling.ClickOnFindButton);
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.CloseSearchFunction);
	helper.DeepSleep();
	WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
	List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
	try{
	List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
	String FacilityNames=FacilityColoumns.get(2).getText();
	if(FacilityNames.equals(FacilityName)){
	Reporter.log("Added Free Facility Found Sucessfully", true);
	}
	try{
	String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
	Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
	if(PriceDetailsButton.equals("Show")){
	if(BookingButton.equals("Book / Cancel")){
	FacilityColoumns.get(11).findElement(By.tagName("button")).click();
	helper.MaxSleep();
	helper.Sleep();
	helper.ClickByID(VariableCalling.ClickOnAddButton);
	helper.MaxSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).sendKeys(MethodsCalling.EnterTomorrowDate());
	helper.DeepSleep();
	helper.ClickOnTabButton("FromDate");
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromTime)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromTime)).sendKeys(EnterFromTime);
	helper.ClickOnTabButton("FromTime");
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).sendKeys(MethodsCalling.EnterDayAfterTomorrowDate());
	helper.ClickOnTabButton("ToDate");
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToTime)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToTime)).sendKeys(EnterToTime);
	helper.ClickOnTabButton("ToTime");
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.Description)).sendKeys(EnterDescription);
	helper.Sleep();
	helper.Sleep();
	helper.blockselection();
	helper.DeepSleep();
	helper.apartmentselection();
	helper.DeepSleep();
	String TotalAmount=SeleniumHelper.driver.findElement(By.id("Total")).getAttribute("value");
	Reporter.log("Total Amount Charged For Selected Period Of Time Is:" +TotalAmount, true);
	if(TotalAmount.equals(0)){
	String ErrorMessage=helper.GetValueByID("InvailLabel");
	Reporter.log("Error Message Came As : "+ErrorMessage, true);	
	}
	helper.TakeScreenShot("Simulation Of Facility With package Prices For 1Day With Admin Login");
	}}			
	}catch(NoSuchElementException Exception){
	Reporter.log("Booking Button Not Available So booking Is Not Allowed For This Facility", true);
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
	helper.TakeScreenShot("Booking Not Allowed For Facility With package Prices For 6hrs With Admin Login");
	Reporter.log("Booking Not Allowed For Facility With package Prices For 1Day With Admin Login", true);
	}}catch(NoSuchElementException Exception){
	Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
	}
	Reporter.log(" ", true);
	Reporter.log("Files Stored In(Path Name)", true);	
	Reporter.log("---------------------------", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Simulation Of Facility With package Prices For 1Day With Admin Login",true);
	Reporter.log(" ", true);
		}

}
