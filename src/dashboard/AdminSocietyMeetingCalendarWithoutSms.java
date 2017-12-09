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
public class AdminSocietyMeetingCalendarWithoutSms extends TestBase {
@Test(priority=1)
public void Login() throws InterruptedException{
Reporter.log("Script Name:Admin---->Application--->SocietyMeetingCalander--->Meeting Booked Without Sms And With Enabled Email CheckBox", true);	
Reporter.log("----------------------------------------------", true);	
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
@Test(priority=2,dependsOnMethods="Login",dataProvider="MeetingBookedWithoutSms",dataProviderClass= DataProvider3.class)
public void WithoutSmsAndEnableEmail(String EnterFromTime,String EnterToTime,String EnterLocationOfMeeting,String EnterAgendaOfMeeting,String EnterAgendaOfMeetingToVerify) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyMeetingCalanderButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.ClearElementById(VariableCalling2.EnterFromDateInSocietyMeetingCalander);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterFromDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
helper.Sleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterFromDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
helper.DeepSleep();
helper.SetValueByID(VariableCalling2.EnterFromTimeInSocietyMeetingCalander, EnterFromTime);
helper.Sleep();
helper.ClearElementById(VariableCalling2.EnterToDateInSocietyMeetingCalander);
helper.DeepSleep();
helper.SetValueByID(VariableCalling2.EnterToDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterToDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
helper.DeepSleep();
helper.SetValueByID(VariableCalling2.EnterToTimeInSocietyMeetingCalander, EnterToTime);
helper.Sleep();
helper.SetValueByID("Location", EnterLocationOfMeeting);
helper.SetValueByID("Agenda", EnterAgendaOfMeeting);
Method2.SelectBlock();
helper.Sleep();
helper.ClickByID(VariableCalling2.SelectSendMail);
helper.ClickByID(VariableCalling2.ClickOnSubmitButton);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.TakeScreenShot("AfterAddMeetingWithoutSmsInMeetingCalander");

helper.DeepSleep();
Calendar calObject = Calendar.getInstance();
calObject.add(Calendar.DAY_OF_YEAR, 1);


WebElement CalandarDates = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyCalander));  
List<WebElement> cellrows = CalandarDates.findElements(By.cssSelector(VariableCalling2.IdentifyingCalanderRows));
loop:for (int rows = 0; rows< 5; rows++) {
List<WebElement> columns = cellrows.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingCalanderDates));
for (int coloumns = 0; coloumns <14; coloumns++) {
String givendate = columns.get(coloumns).getText();
if(givendate.length()==1){
String tomorrowDate = new SimpleDateFormat("d").format(calObject.getTime());
if (givendate.equals(tomorrowDate))	      
{	
   
columns.get(coloumns).click();
Thread.sleep(2000);        
WebElement ListOfEvents = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingListOfMeeting)); 
List<WebElement> ListOfEvent = ListOfEvents.findElements(By.tagName(VariableCalling2.SearchingEachevent));
Thread.sleep(2000);  	   
for(int ListRows=0;ListRows<ListOfEvent.size();ListRows++){
String Description=ListOfEvent.get(ListRows).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();	   
Reporter.log(" Description Of Event: "+ Description, true);	
if(EnterAgendaOfMeetingToVerify.equals(Description)){	                           	 
Thread.sleep(2000);	    
String ColourOfEvent=ListOfEvent.get(ListRows).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);	                         
if(ColourOfEvent.equals(VariableCalling.RGBAValueOfOrnage)){	 
Reporter.log("ColourOfEvent for The Description of "+Description+ " Is: Orange", true);	
		
 }	                		 
else if(ColourOfEvent.equals(VariableCalling.RGBAValueOfRed)){	
Reporter.log("ColourOfEvent Is: Red", true);	
}else if(ColourOfEvent.equals(VariableCalling.RGBAValueOfBlue)){	
Reporter.log("ColourOfEvent Is: Blue", true);	
Reporter.log("Meeting Added Sucessfully", true);
break;

}else{
Reporter.log("Event Colour Is None Of The Blue,Orange,Red Colours", true);	
}}
} break loop;}}else{
String tomorrowDate = new SimpleDateFormat("dd").format(calObject.getTime());
	//Reporter.log("Date:"+tomorrowDate, true);
	if (givendate.equals(tomorrowDate))	      
	{	
	   
	columns.get(coloumns).click();
	Thread.sleep(2000);        
	WebElement ListOfEvents = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingListOfMeeting)); 
	List<WebElement> ListOfEvent = ListOfEvents.findElements(By.tagName(VariableCalling2.SearchingEachevent));
	Thread.sleep(2000);  	   
	for(int ListRows=0;ListRows<ListOfEvent.size();ListRows++){
	String Description=ListOfEvent.get(ListRows).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();	   
	Reporter.log(" Description Of Event: "+ Description, true);	
	if(EnterAgendaOfMeetingToVerify.equals(Description)){	                           	 
	Thread.sleep(2000);	    
	String ColourOfEvent=ListOfEvent.get(ListRows).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);	                         
	if(ColourOfEvent.equals(VariableCalling.RGBAValueOfOrnage)){	 
	Reporter.log("ColourOfEvent for The Description of "+Description+ " Is: Orange", true);	
	   		
	 }	                		 
	else if(ColourOfEvent.equals(VariableCalling.RGBAValueOfRed)){	
	Reporter.log("ColourOfEvent Is: Red", true);	
	System.out.println();
	}else if(ColourOfEvent.equals(VariableCalling.RGBAValueOfBlue)){	
	Reporter.log("ColourOfEvent Is: Blue", true);	
	Reporter.log("Meeting Added Sucessfully", true);
	break;
	}else{
	Reporter.log("Event Colour Is None Of The Blue,Orange,Red Colours", true);	
	}}
	} break loop;}
	
	}
}

helper.DeepSleep();

}}
@Test(priority=3,dependsOnMethods="WithoutSmsAndEnableEmail",dataProvider="MeetingBookedWithoutSmsWithAlreadyBookedDetails",dataProviderClass= DataProvider3.class)

public void BooingWithSameDetailsWithoutSms(String EnterFromTime,String EnterToTime,String EnterLocationOfMeeting,String EnterAgendaOfMeeting) throws InterruptedException, IOException, HeadlessException, AWTException{

	helper.RefreshPage();
	helper.ClickByID(VariableCalling.ClickOnAddButton);
	Thread.sleep(3000);
	helper.ClearElementById(VariableCalling2.EnterFromDateInSocietyMeetingCalander);
	Thread.sleep(3000);
	helper.SetValueByID(VariableCalling2.EnterFromDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
	Thread.sleep(3000);
	SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterFromDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
	Thread.sleep(3000);
	helper.SetValueByID(VariableCalling2.EnterFromTimeInSocietyMeetingCalander, EnterFromTime);
	Thread.sleep(2000);
	helper.ClearElementById(VariableCalling2.EnterToDateInSocietyMeetingCalander);
	Thread.sleep(4000);
	helper.SetValueByID(VariableCalling2.EnterToDateInSocietyMeetingCalander, MethodsCalling.EnterTomorrowDate());
	Thread.sleep(3000);
	SeleniumHelper.driver.findElement(By.id(VariableCalling2.EnterToDateInSocietyMeetingCalander)).sendKeys(VariableCalling2.PressTabButton);
	Thread.sleep(3000);
	helper.SetValueByID(VariableCalling2.EnterToTimeInSocietyMeetingCalander, EnterToTime);
	Thread.sleep(3000);
	helper.SetValueByID("Location", EnterLocationOfMeeting);
	helper.SetValueByID("Agenda", EnterAgendaOfMeeting);
	Method2.SelectBlock();
	Thread.sleep(3000);
	helper.ClickByID(VariableCalling2.SelectSendMail);
	Thread.sleep(2000);
	
helper.ClickByID(VariableCalling2.ClickOnSubmitButton);
Thread.sleep(4000);

helper.TakeScreenShotOfWindowPopUp("MeetingBookedWithAlredyBookedTimings");
WebDriverWait wait = new WebDriverWait(SeleniumHelper.driver, 2);
try{
wait.until(ExpectedConditions.alertIsPresent());
Alert alert = SeleniumHelper.driver.switchTo().alert();
String Message = alert.getText();
Reporter.log("when Tried To Book Meeting With AlreadyBooked Timings PopUp Came As : "+Message, true);	
alert.accept();  
helper.RefreshPage();
}
catch(Exception e){
Reporter.log("Meeting Booked With AlreadyBooked Same Timings Without Sms ", true);	
  }

}
@Test(priority=4,dependsOnMethods="BooingWithSameDetailsWithoutSms",dataProvider="CancelMeeting",dataProviderClass= DataProvider3.class)
public void CancelMeeting(String AgendaOfMeeting ) throws InterruptedException, IOException{
	helper.DeepSleep();
Method2.CancelMeeting(AgendaOfMeeting);	
}

@Test(priority=5,dependsOnMethods="CancelMeeting")
public void Results() throws InterruptedException{
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterAddMeetingWithoutSmsInMeetingCalander" +  "   AfterAddMeetingInMeetingCalander", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MeetingBookedWithAlredyBookedTimings" + "  MeetingBookedWithAlredyBookedTimings", true);	
Reporter.log(" ", true);	
	}

}
