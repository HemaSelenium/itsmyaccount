package dashboard;
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
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.variablecalling3;

public class AdminProfile extends TestBase{
@Test(priority=1)
public void SmsSubscription() throws Exception{
Reporter.log("Script Name:Admin--->Dashboard--->Profile", true);	
Reporter.log("-----------------------------------------", true);	
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.ClickByXpath(VariableCalling.ClickOnProfileButton);	
helper.DeepSleep();
WebElement SelectedSMSOptionsList=SeleniumHelper.driver.findElement(By.xpath(".//*[@id='SMSSubscription_chosen']/ul"));
List<WebElement>SMSList=SelectedSMSOptionsList.findElements(By.tagName("li"));
List<String>SMSS=new ArrayList<String>();
for(int options=0;options<SMSList.size();options++){
SMSS.add(SMSList.get(options).getText());
}
if(SMSS.contains("My Residents / Due List")) {
Reporter.log("MyResidents/DueList Check Box Already Selected", true);	
helper.TakeScreenShot("AlreadySelectedMyResidentsAndDueListCheckBox");
helper.Sleep();
for(int i=0;i<SMSList.size();i++){
if(SMSList.get(i).getText().equals("My Residents / Due List")){
SMSList.get(i).findElement(By.tagName("a")).click();
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnSaveButton);
helper.Sleep();
try{
helper.RefreshPage();
helper.ClickByXpath(variablecalling3.LogOutButton);
helper.DeepSleep();
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
helper.RefreshPage();
Thread.sleep(5000);
helper.ClickByXpath(variablecalling3.LogOutButton);
helper.DeepSleep();
}
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnProfileButton);	
helper.DeepSleep();
helper.TakeScreenShot("AfterDeSelectingSelectedMyResidentsAndDueListCheckBox");
WebElement SelectedSMSOptions=SeleniumHelper.driver.findElement(By.xpath(".//*[@id='SMSSubscription_chosen']/ul"));
List<WebElement>List=SelectedSMSOptions.findElements(By.tagName("li"));
List<String>optionlist=new ArrayList<String>();
for(int option=0;option<List.size();option++){
optionlist.add(List.get(option).getText());
}

if(optionlist.contains("My Residents / Due List")) {
Reporter.log("Unable to Deselect MyResidents/DueListCheckBox", true);	
}
else{
Reporter.log("Deselect MyResidents/DueList CheckBox Sucessfully", true);
Method8.SelectMYResidentsAndDueListInSMSOptions("My Residents / Due List");
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnSaveButton);
helper.DeepSleep();
try{
helper.RefreshPage();
}
catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
helper.RefreshPage();
Thread.sleep(5000);
helper.ClickByXpath(variablecalling3.LogOutButton);
							}
helper.DeepSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnProfileButton);	
helper.DeepSleep();
WebElement SMSOptionsList=SeleniumHelper.driver.findElement(By.xpath(".//*[@id='SMSSubscription_chosen']/ul"));
List<WebElement>SMS=SMSOptionsList.findElements(By.tagName("li"));
List<String>smslist=new ArrayList<String>();
						

for(int optionslist=0;optionslist<SMS.size();optionslist++){
smslist.add(SMS.get(optionslist).getText())	;
}
if(smslist.contains("My Residents / Due List")) {

Reporter.log("MyResidents/DueList CheckBox Selected Sucessfully", true);	
}                                                                               
else{
Reporter.log("MyResidents/DueList CheckBox Unable To Select", true);	
    }}					break;
				}
	
			}	
			
			
		}
		else{
			helper.TakeScreenShot("BeforeSelectingMyResidentsAndDueListCheckBox");
			Reporter.log("Initially MyResidents/DueList CheckBox is Not Selected", true);	
			helper.DeepSleep();
			Method8.SelectMYResidentsAndDueListInSMSOptions("My Residents / Due List");
			helper.DeepSleep();
			helper.ClickByID(VariableCalling.ClickOnSaveButton);
			helper.DeepSleep();
			try{
				helper.RefreshPage();
				}
				catch(UnhandledAlertException e){
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
				
				helper.RefreshPage();
				Thread.sleep(5000);
				helper.ClickByXpath(variablecalling3.LogOutButton);
				
				}
			helper.DeepSleep();
			helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
			helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
			helper.ClickByID(VariableCalling.SelectTermsAndConditions);
			helper.ClickByXpath(VariableCalling.LoginButton);
			helper.DeepSleep();
			helper.ClickByXpath(VariableCalling.ClickOnProfileButton);	
			helper.DeepSleep();

			WebElement SelectedSMSList=SeleniumHelper.driver.findElement(By.xpath(".//*[@id='SMSSubscription_chosen']/ul"));
			List<WebElement>SMSoptionlist=SelectedSMSList.findElements(By.tagName("li"));
			List<String> list = new ArrayList<String>();
			for(int listofoptions=0;listofoptions<SMSoptionlist.size();listofoptions++){
				list.add(SMSoptionlist.get(listofoptions).getText());
			}

if(list.contains("My Residents / Due List")) {

Reporter.log("MyResidents/DueList CheckBox Selected Sucessfully", true);
helper.TakeScreenShot("AfterSelectingMyResidentsAndDueListCheckBox");
}
else{
Reporter.log("Unable To Select MyResidents/DueList CheckBox", true);	
}
		}
		}
	
		
		
	@Test(priority=2)
	public void Results(){
	Reporter.log(" ", true);	
	Reporter.log("Files Stored in (Path Name)", true);	
	Reporter.log("-----------------------------", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AlreadySelectedMyResidentsAndDueListCheckBox", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterDeSelectingSelectedMyResidentsAndDueListCheckBox", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"BeforeSelectingMyResidentsAndDueListCheckBox", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterSelectingMyResidentsAndDueListCheckBox", true);	
	Reporter.log(" ", true);	
	Reporter.log("Items to be checked Manually", true);	
	Reporter.log("-----------------------------", true);	
	Reporter.log("MyResidents/DueList CheckBox Selected Or Not", true);	
	Reporter.log(" ", true);	
	}
	
	
	
	
	
	
	
	
	
	
	}

