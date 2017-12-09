package common;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
public class MethodsCalling2 {
String UserId;
String UserPassword;
public void SelectBlock(){
WebElement select = SeleniumHelper.driver.findElement(By.id("BlockID"));
List<WebElement> options = select.findElements(By.tagName("option"));
for(WebElement option : options){
 if(option.getText().equals(GlobalVariablesCalling.EnterMemberBlockName)) {
  option.click();
  break;
       }}}
public void CancelMeeting(String AgendaOfMeeting) throws InterruptedException, IOException{
Calendar calObject = Calendar.getInstance();
calObject.add(Calendar.DAY_OF_YEAR, 1);
WebElement dateWidget = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyCalander));  
Thread.sleep(1000);
List<WebElement> cellrows = dateWidget.findElements(By.cssSelector(VariableCalling2.IdentifyingCalanderRows));
Thread.sleep(1000);
loop1:for (int row = 0; row < 5; row++) {
Thread.sleep(1000);
List<WebElement> columns = cellrows.get(row).findElements(By.tagName(VariableCalling2.IdentifyingCalanderDates));
Thread.sleep(1000);
for (int coloumn = 0; coloumn < 14; coloumn++) {
String givendate = columns.get(coloumn).getText();
Thread.sleep(1000);
if(givendate.length()==1){
String tomorrowDate = new SimpleDateFormat("d").format(calObject.getTime());
if (givendate.equals(tomorrowDate))
{
columns.get(coloumn).click();
Thread.sleep(2000);
WebElement Event = SeleniumHelper.driver.findElement(By.id(VariableCalling2.ListofEvents));  
Thread.sleep(2000);
List<WebElement> ListOfEvents = Event.findElements(By.tagName(VariableCalling2.SearchingEachevent));
Thread.sleep(2000);
for(int j=1;j<ListOfEvents.size();j++){
String Description=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();
if(AgendaOfMeeting.equals(Description)){
String ColourOfEvents=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);
if(ColourOfEvents.equals(VariableCalling.RGBAValueOfBlue)){
ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).click();
Thread.sleep(2000);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClickOnCancelButtonInSocietyMeetingCalendar)).click();
Thread.sleep(2000);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.XpathOfReason)).sendKeys(VariableCalling2.EnterReasonFormeetingCancelation);
SeleniumHelper.driver.findElement(By.id(VariableCalling2.ClickOnSaveButton)).click();	
Thread.sleep(4000);
File AfterDeleteMeetingInMeetingCalander=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AfterDeleteMeetingInMeetingCalander, new File(GlobalVariablesCalling.ScreenShotsFileName+"AfterDeleteMeetingWithSmsInMeetingCalander.png"));	
Reporter.log("Meeting Cancelled", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterDeleteMeetingWithSmsInMeetingCalander.png" +  "   AfterDeleteMeetingWithSmsInMeetingCalander", true);
                			                                               break;} } }
break loop1;
}}
else{
	String tomorrowDate = new SimpleDateFormat("dd").format(calObject.getTime());
	if (givendate.equals(tomorrowDate))
	{
	columns.get(coloumn).click();
	Thread.sleep(2000);
	WebElement Event = SeleniumHelper.driver.findElement(By.id(VariableCalling2.ListofEvents));  
	Thread.sleep(2000);
	List<WebElement> ListOfEvents = Event.findElements(By.tagName(VariableCalling2.SearchingEachevent));
	Thread.sleep(2000);
	for(int j=1;j<ListOfEvents.size();j++){
	String Description=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).getText();
	if(AgendaOfMeeting.equals(Description)){
	String ColourOfEvents=ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.FindingEvent)).getCssValue(VariableCalling2.GetColourOfEvent);
	if(ColourOfEvents.equals(VariableCalling.RGBAValueOfBlue)){
	ListOfEvents.get(j).findElement(By.tagName(VariableCalling2.GetDescriptionOfEvent)).click();
	Thread.sleep(2000);
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClickOnCancelButtonInSocietyMeetingCalendar)).click();
	Thread.sleep(2000);
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.XpathOfReason)).sendKeys(VariableCalling2.EnterReasonFormeetingCancelation);
	SeleniumHelper.driver.findElement(By.id(VariableCalling2.ClickOnSaveButton)).click();	
	Thread.sleep(4000);
	File AfterDeleteMeetingInMeetingCalander=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(AfterDeleteMeetingInMeetingCalander, new File(GlobalVariablesCalling.ScreenShotsFileName+"AfterDeleteMeetingWithSmsInMeetingCalander.png"));	
	Reporter.log("Meeting Cancelled", true);
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterDeleteMeetingWithSmsInMeetingCalander.png" +  "   AfterDeleteMeetingWithSmsInMeetingCalander", true);
	
	                			                                               break;} } }
	break loop1;
	}               			                                            		  
                			                                            		  
	}





}}








                			                                              }
                		     
	public void ClickOnColourOfEvent() throws InterruptedException{
	Calendar calObject = Calendar.getInstance();
    calObject.add(Calendar.DAY_OF_YEAR, 1);
    WebElement DatesCalander = SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.IdentifyCalander));  
    Thread.sleep(1000);
    List<WebElement> cellrows = DatesCalander.findElements(By.cssSelector(VariableCalling2.IdentifyingCalanderRows));
    Thread.sleep(1000);
    lable1:   for (int Rows = 0; Rows < 5; Rows++) {
    Thread.sleep(1000);
    List<WebElement> columns = cellrows.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingCalanderDates));
    Thread.sleep(1000);
    for (int Coloumn = 0; Coloumn <= 13; Coloumn++) {
    String givendate = columns.get(Coloumn).getText();
    Thread.sleep(1000);
    if(givendate.length()==1){
    	String tomorrowDate = new SimpleDateFormat("d").format(calObject.getTime());
    if (givendate.equals(tomorrowDate))
       {
     List<WebElement> cell1=columns.get(Coloumn).findElements(By.className(VariableCalling2.FindingAllMeetingEvents)); 
     Thread.sleep(4000);   
     List<WebElement> cell2 =cell1.get(0).findElements(By.tagName(VariableCalling2.MeetingEvent));
     Thread.sleep(2000); 
     cell2.get(cell2.size()-1).click();
     Reporter.log("Meeting Details Of Clicked Event Are Ready To View ", true);
     Thread.sleep(3000); 	
     
     break lable1;
     } }else{
    String tomorrowDate = new SimpleDateFormat("dd").format(calObject.getTime());
    if (givendate.equals(tomorrowDate))
      {
     List<WebElement> cell1=columns.get(Coloumn).findElements(By.className(VariableCalling2.FindingAllMeetingEvents)); 
     Thread.sleep(2000);   
     List<WebElement> cell2 =cell1.get(0).findElements(By.tagName(VariableCalling2.MeetingEvent));
     Thread.sleep(2000); 
      cell2.get(cell2.size()-1).click();
     Reporter.log("Meeting Details Of Clicked Event Are Ready To View ", true);
     Thread.sleep(2000);   	
     break lable1;
                	                 }
                	 
                 
                 
                 }    }      }
                 }
  
public String IdentifyUserIdInMailInbox() throws InterruptedException{
	Thread.sleep(4000);
	List<WebElement> unreademeil = SeleniumHelper.driver.findElements(By.xpath(VariableCalling2.UnReadMail));
String MyMailer = "ItsMyAccount - Admin";
for(int i=0;i<unreademeil.size();i++){
if(unreademeil.get(i).isDisplayed()==true){
if(unreademeil.get(i).getText().equals(MyMailer)){
System.out.println("Yes we have got mail form " + MyMailer);
String SubjectInMail= unreademeil.get(i).findElement(By.xpath(VariableCalling2.SubjectOfMail)).getText();        
String Subject ="Your credentials to access ItsMyAccount.com" ;
if(SubjectInMail.equals(Subject)){
System.out.println("Yes we have got mail form " + MyMailer+ "  With Subject Of "  +SubjectInMail);	
String MessageInMail=unreademeil.get(i).findElement(By.xpath(VariableCalling2.MessageInMail)).getText();   	
 UserId = MessageInMail.split(" ")[7];
Reporter.log("User Id : "+UserId, true);
unreademeil.get(i).findElement(By.xpath(VariableCalling2.MessageInMail)).click();
}else{
System.out.println("No mail form " + MyMailer+ "With Subject Of "+SubjectInMail);
 }
break;
 }else{
 System.out.println("No mail form " + MyMailer);
 }}}    
return UserId; 
 }
 
public String IdentifyUserpasswordInMailInbox() throws InterruptedException{
Thread.sleep(4000);

List<WebElement> unreademeil = SeleniumHelper.driver.findElements(By.xpath(VariableCalling2.UnReadMail));
String MyMailer = "ItsMyAccount - Admin";
for(int i=0;i<unreademeil.size();i++){
if(unreademeil.get(i).isDisplayed()==true){
if(unreademeil.get(i).getText().equals(MyMailer)){
Reporter.log("Yes we have got mail form " + MyMailer, true);	
String SubjectInMail= unreademeil.get(i).findElement(By.xpath(VariableCalling2.SubjectOfMail)).getText();        
String Subject ="Your credentials to access ItsMyAccount.com" ;
if(SubjectInMail.equals(Subject)){
Reporter.log("Yes we have got mail form " + MyMailer+ "  With Subject Of "  +SubjectInMail, true);	
String MessageInMail=unreademeil.get(i).findElement(By.xpath(VariableCalling2.MessageInMail)).getText();   	
UserPassword = MessageInMail.split(":")[2];
Reporter.log("User Password : "+UserPassword, true);
unreademeil.get(i).findElement(By.xpath(VariableCalling2.MessageInMail)).click();
}else{
Reporter.log("No mail form " + MyMailer+ "With Subject Of "+SubjectInMail, true);
}break;
}else{
Reporter.log("No mail form " + MyMailer, true);
}}}    	
return  UserPassword;  
} 	
         	
public String IdentifyResetUserpasswordInMailInbox() throws InterruptedException{
Thread.sleep(4000);

List<WebElement> unreademeil = SeleniumHelper.driver.findElements(By.xpath(VariableCalling2.UnReadMail));
String MyMailer = "ItsMyAccount - Admin";
for(int i=0;i<unreademeil.size();i++){
if(unreademeil.get(i).isDisplayed()==true){
if(unreademeil.get(i).getText().equals(MyMailer)){
Reporter.log("Yes we have got mail form " + MyMailer, true);	
String SubjectInMail= unreademeil.get(i).findElement(By.xpath(VariableCalling2.SubjectOfMail)).getText();        
String Subject ="Your credentials to access ItsMyAccount.com" ;
if(SubjectInMail.equals(Subject)){
Reporter.log("Yes we have got mail form " + MyMailer+ "  With Subject Of "  +SubjectInMail, true);	
String MessageInMail=unreademeil.get(i).findElement(By.xpath(VariableCalling2.MessageInMail)).getText();   	
UserPassword = MessageInMail.split(":")[1];
Reporter.log("User Password : "+UserPassword, true);
unreademeil.get(i).findElement(By.xpath(VariableCalling2.MessageInMail)).click();
}else{
Reporter.log("No mail form " + MyMailer+ "With Subject Of "+SubjectInMail, true);
}break;
}else{
Reporter.log("No mail form " + MyMailer, true);
}}}    	
return  UserPassword;  
}}  			  	
        
      
       
  
                		 
                	      	             
                            
               
           
           
	
		

       


