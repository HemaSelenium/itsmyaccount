package dashboard;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class ShowEventsInSocietyMeetingCalendar extends TestBase{
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
@Test(priority=2)
public void ShowEvent() throws IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyMeetingCalanderButton);	
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnMonthDropDownListButton);
helper.DeepSleep();
WebElement Month= SeleniumHelper.driver.findElement(By.id(VariableCalling2.ListOfMonths));
List<WebElement> ListOfMonths =Month.findElements(By.tagName(VariableCalling2.IdentifyingTagName));
for(int i=0;i<ListOfMonths.size();i++){
if(ListOfMonths.get(i).findElement(By.tagName(VariableCalling2.GetValuesFromList)).getText().equals(helper.GetCurrentMonth())){
String previousMonth=ListOfMonths.get(i).findElement(By.tagName(VariableCalling2.GetValuesFromList)).getText();
ListOfMonths.get(i).findElement(By.tagName(VariableCalling2.GetValuesFromList)).click();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnYearDropDownListButton);
helper.DeepSleep();
WebElement Year= SeleniumHelper.driver.findElement(By.id(VariableCalling2.ListOfYears));
List<WebElement> ListOfYears =Year.findElements(By.tagName(VariableCalling2.IdentifyingTagName));
for(int j=0;j<ListOfYears.size();j++){
if(ListOfYears.get(j).findElement(By.tagName(VariableCalling2.GetValuesFromList)).getText().equals(MethodsCalling.PresentYear())){
ListOfYears.get(j).findElement(By.tagName(VariableCalling2.GetValuesFromList)).click();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnShowEventsButton);
helper.MaxSleep();
String TitleOfCalendar=helper.GetValueByXpath(VariableCalling2.GetTitleOfCalendar);
String MonthAndYear=previousMonth+" "+MethodsCalling.PresentYear();
System.out.println("Selected Month And Year Are: "+MonthAndYear);
if(TitleOfCalendar.equals(MonthAndYear)){
Reporter.log("Selected Month And year Of Events Displayed Sucessfully", true);
helper.TakeScreenShot("Events Of Selected Month And Year");
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Events Of Selected Month And Year", true);
Reporter.log(" ", true);
}
else{
Reporter.log("Selected Month And year Of Events Not Displayed ", true);
}}}}}}}


