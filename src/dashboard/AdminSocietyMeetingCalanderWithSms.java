package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSocietyMeetingCalanderWithSms extends TestBase{
@Test(priority=1)
public void Login() throws InterruptedException{
Reporter.log("Script Name:Admin---->Application--->SocietyMeetingCalander---MeetingBookedWithSms", true);
Reporter.log("----------------------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
}
@Test(priority=2,dependsOnMethods="Login",dataProvider="MeetingBookedWithSms",dataProviderClass= DataProvider3.class)
public void WithSmsAndEnableEmail(String EnterFromTime,String EnterToTime,String EnterLocationOfMeeting,String EnterAgendaOfMeeting,String EnterMessage,String EnterAgendaOfMeetingToVerify) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyMeetingCalanderButton);	
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.ClearElementById(VariableCalling2.EnterFromDateInSocietyMeetingCalander);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterFromDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
helper.Sleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterFromDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
helper.SetValueByID(VariableCalling2.EnterFromTimeInSocietyMeetingCalander, EnterFromTime);
helper.Sleep();
helper.ClearElementById(VariableCalling2.EnterToDateInSocietyMeetingCalander);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterToDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
helper.Sleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterToDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterToTimeInSocietyMeetingCalander, EnterToTime);
helper.DeepSleep();
helper.SetValueByID("Location", EnterLocationOfMeeting);
helper.SetValueByID("Agenda", EnterAgendaOfMeeting);
helper.SetValueByID("SMSMsg", EnterMessage);
Method2.SelectBlock();
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnSubmitButton);
helper.DeepSleep();
helper.TakeScreenShot("AfterAddMeetingWithSmsInMeetingCalander");
helper.DeepSleep();
Calendar calObject = Calendar.getInstance();
calObject.add(Calendar.DAY_OF_YEAR, 1);
WebElement CalandarDates = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyCalander));  
List<WebElement> cellrows = CalandarDates.findElements(By.cssSelector(VariableCalling2.IdentifyingCalanderRows));
for (int row = 0; row < 5; row++) {
List<WebElement> columns = cellrows.get(row).findElements(By.tagName(VariableCalling2.IdentifyingCalanderDates));
for (int coloumn = 0; coloumn <14; coloumn++) {
String givendate = columns.get(coloumn).getText();
if(givendate.length()==1){
String tomorrowDate = new SimpleDateFormat("d").format(calObject.getTime());	
if (givendate.equals(tomorrowDate))	      
{	
columns.get(coloumn).click();
helper.Sleep();    
WebElement ListOfEvents = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingListOfMeeting)); 
List<WebElement> ListOfEvent = ListOfEvents.findElements(By.tagName(VariableCalling2.SearchingEachevent));
helper.Sleep();	   
for(int j=0;j<ListOfEvent.size();j++){
String Description=ListOfEvent.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();
if( EnterAgendaOfMeetingToVerify.equals(Description)){	                           	 
helper.Sleep();   
String ColourOfEvent=ListOfEvent.get(j).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);	                         
if(ColourOfEvent.equals("rgba(255, 165, 0, 1)")){	    
Reporter.log("ColourOfEvent for The Description of "+Description+ " Is: Orange", true);
    }	                		 
else if(ColourOfEvent.equals("rgba(255, 0, 0, 1)")){
Reporter.log("ColourOfEvent Is: Red", true);
}else if(ColourOfEvent.equals("rgba(0, 0, 255, 1)")){
Reporter.log("Meeting Added Sucessfully", true);	
Reporter.log(" Description Of Event: "+ Description, true);	
Reporter.log("ColourOfEvent Is: Blue", true);

}else{
Reporter.log("Event Colour Is None Of The Blue,Orange,Red Colours", true);
}}} break;}}else{
	
	String tomorrowDate = new SimpleDateFormat("dd").format(calObject.getTime());	
	if (givendate.equals(tomorrowDate))	      
	{	
	Reporter.log(givendate, true);
	columns.get(coloumn).click();
	helper.Sleep();    
	WebElement ListOfEvents = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingListOfMeeting)); 
	List<WebElement> ListOfEvent = ListOfEvents.findElements(By.tagName(VariableCalling2.SearchingEachevent));
	helper.Sleep();	   
	for(int j=0;j<ListOfEvent.size();j++){
	String Description=ListOfEvent.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();
	if( EnterAgendaOfMeetingToVerify.equals(Description)){	                           	 
	helper.Sleep();   
	String ColourOfEvent=ListOfEvent.get(j).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);	                         
	if(ColourOfEvent.equals("rgba(255, 165, 0, 1)")){	    
	Reporter.log("ColourOfEvent for The Description of "+Description+ " Is: Orange", true);
	    }	                		 
	else if(ColourOfEvent.equals("rgba(255, 0, 0, 1)")){
	Reporter.log("ColourOfEvent Is: Red", true);
	}else if(ColourOfEvent.equals("rgba(0, 0, 255, 1)")){
	Reporter.log("Meeting Added Sucessfully", true);	
	Reporter.log(" Description Of Event: "+ Description, true);	
	Reporter.log("ColourOfEvent Is: Blue", true);
		}else{
	Reporter.log("Event Colour Is None Of The Blue,Orange,Red Colours", true);
	}}} break;}	
}
}
helper.DeepSleep();

}

}
@Test(priority=3,dependsOnMethods="WithSmsAndEnableEmail",dataProvider="MeetingBookedWithtSmsWithAlreadyBookedDetails",dataProviderClass= DataProvider3.class)
public void BookingWithSameDetailsWithSms(String EnterFromTime,String EnterToTime,String EnterLocationOfMeeting,String EnterAgendaOfMeeting,String EnterMessage) throws InterruptedException, HeadlessException, IOException, AWTException{
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.ClearElementById(VariableCalling2.EnterFromDateInSocietyMeetingCalander);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterFromDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
helper.Sleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterFromDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterFromTimeInSocietyMeetingCalander, EnterFromTime);
helper.Sleep();
helper.ClearElementById(VariableCalling2.EnterToDateInSocietyMeetingCalander);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterToDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
helper.Sleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterToDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterToTimeInSocietyMeetingCalander, EnterToTime);
helper.Sleep();
helper.SetValueByID("Location", EnterLocationOfMeeting);
helper.SetValueByID("Agenda",EnterAgendaOfMeeting);
helper.SetValueByID("SMSMsg", EnterMessage);
helper.Sleep();
Method2.SelectBlock();
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnSubmitButton);
helper.DeepSleep();
helper.TakeScreenShotOfWindowPopUp("MeetingWithSmsBookedWithAlredyBookedTimings");
WebDriverWait wait = new WebDriverWait(SeleniumHelper.driver, 2);
try{
wait.until(ExpectedConditions.alertIsPresent());
Alert alert = SeleniumHelper.driver.switchTo().alert();
String Message = alert.getText();
Reporter.log("when Tried To Book Meeting With AlreadyBooked Timings PopUp Came As : "+Message, true);
helper.TakeScreenShotOfWindowPopUp("");
alert.accept();  
helper.RefreshPage();
}catch(Exception e){
Reporter.log("Meeting Booked With AlreadyBooked Same Timings With Sms ", true);
}
}
@Test(priority=4,dependsOnMethods="BookingWithSameDetailsWithSms",dataProvider="CancelBookedMeetingWithSms",dataProviderClass= DataProvider3.class)
public void MeetingCancel(String AgendaOfMeeting) throws InterruptedException, IOException{
helper.Sleep();
Method2.CancelMeeting(AgendaOfMeeting);	
}
@Test(priority=5,dependsOnMethods="MeetingCancel")
public void Results() throws InterruptedException{
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterAddMeetingWithSmsInMeetingCalander" +  "   AfterAddMeetingWithSmsInMeetingCalander", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MeetingWithSmsBookedWithAlredyBookedTimings" + "  MeetingWithSmsBookedWithAlredyBookedTimings", true);
Reporter.log(" ", true);
}
}
