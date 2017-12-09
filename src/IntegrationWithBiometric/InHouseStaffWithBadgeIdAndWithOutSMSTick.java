package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class InHouseStaffWithBadgeIdAndWithOutSMSTick extends TestBase{
public String BadgeID;
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->Admin In House Staff With BadgeId And SMS Tick ", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2,dataProvider="InhouseStaffWithoutSMSTick",dataProviderClass= DataProvider8.class)
public void AddRecordWithoutSMSTick(String EnterWorkType,String InHouseStaffMemberName,String ContactNo, String StaffContact2,String EnterSalaryOfStaffMember,String EnterAgencyName,String EnterDescription,String BadgeId,String Reference1,String Reference2 ,String Reference3     ) throws AWTException, InterruptedException, IOException{
BadgeID=BadgeId;
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnMaintenanceTeam);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.DeepSleep();
helper.SetValueByID("WorkType", EnterWorkType);
helper.SetValueByID("MaintenanceTeamMemberName", InHouseStaffMemberName);
helper.SetValueByID("Contact1", ContactNo);
helper.SetValueByID("Contact2", StaffContact2);
helper.SetValueByID("MonthlySalary", EnterSalaryOfStaffMember);
helper.SetValueByID("Agency", EnterAgencyName);
helper.SetValueByID("Description", EnterDescription);
helper.SetValueByID("PassNo", BadgeID);
helper.Sleep();
if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
SeleniumHelper.driver.findElement(By.id("ISSMS")).click();
helper.Sleep();
Reporter.log("SMS Option Is UnTicked Now", true);
}else{
Reporter.log("SMS Option Is UnTicked Already", true);
}
helper.SetValueByID("Reference1", Reference1);
helper.SetValueByID("Reference2", Reference2);
helper.SetValueByID("Reference3", Reference3);
helper.ClickByXpath(VariableCalling2.UploadImage);
helper.Sleep();
helper.Sleep();
StringSelection stringSelection = new StringSelection(GlobalVariablesCalling.ImageToUpload);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_CONTROL);
helper.Sleep();
rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.WebCam);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.TakeSnapShot);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInMaintenanceTeammembers);
helper.DeepSleep();
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException ex){
}
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);			
WebElement MaintenceMemberTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfMaintenceTeamMembers=MaintenceMemberTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>MemberList=new ArrayList<String>();
List<String>MemberContacts=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfMaintenceTeamMembers.size();Rows++){
List<WebElement>ColoumnsInMaintenceTeamMembers=RowsOfMaintenceTeamMembers.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
MemberList.add(ColoumnsInMaintenceTeamMembers.get(4).getText());
MemberContacts.add(ColoumnsInMaintenceTeamMembers.get(5).getText());
}
if(MemberList.contains(InHouseStaffMemberName)){
if(MemberContacts.contains(ContactNo)){	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectNameInSearchOptions);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.TextFieldInSearchButtonOfMaintenceTeamMembers, InHouseStaffMemberName);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
helper.Sleep();
WebElement MaintenceMemberTable1=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfMaintenceTeamMembers1=MaintenceMemberTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>ColoumnsInMaintenceTeamMembers1=RowsOfMaintenceTeamMembers1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String Badge=ColoumnsInMaintenceTeamMembers1.get(2).getAttribute("title");
int BadgeNumber=Integer.parseInt(Badge);
String Badgeid = String.valueOf(BadgeNumber);
if(Badgeid.isEmpty()){
Reporter.log("1)New Member Added Sucessfully In InHouse Staff But  Badge Id Coloumn Is Empty  " , true);
ColoumnsInMaintenceTeamMembers1.get(2).click();
}
else{
if(Badgeid.equals(BadgeID)){
Reporter.log("1)New Member Added Sucessfully In InHouse Staff With Badge Id : " +BadgeID, true);
ColoumnsInMaintenceTeamMembers1.get(2).click();
}
else{
System.out.println("Badge Id Which Given As Input Is Replaced With following Id :"+Badgeid);
ColoumnsInMaintenceTeamMembers1.get(2).click();
}}}else{
Reporter.log("1)Unable To Add New Member In InHouse Staff", true);	
}}
else{
Reporter.log("1)Unable To Add New Member In InHouse Staff", true);	
	}}
@Test(priority=3,dependsOnMethods="AddRecordWithoutSMSTick",dataProvider="EditWithExistedBadgeIDAndWithoutSMSTick",dataProviderClass= DataProvider8.class)
public void EditRecordWithPrevioslyAddedBadgeID(String PreviouslyAddedBadgeId) throws InterruptedException, IOException{
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();	
helper.TakeScreenShot("AddedInhouseStaffWithoutSmsTick");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedInhouseStaffWithoutSmsTick", true);
helper.SetValueByID("PassNo", PreviouslyAddedBadgeId);
helper.Sleep();	
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInMaintenanceTeammembers);
helper.DeepSleep();

helper.TakeScreenShot("EditingWithExistedBadgeIdOfInhouseStaffRecordWithoutSmsTick");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditingWithExistedBadgeIdOfInhouseStaffRecordWithoutSmsTick", true);
try{
helper.ProcessAlert();
helper.Sleep();
}
catch(NoAlertPresentException e){
Reporter.log("Even Record Edited With Existed BadgId Did't Get Any Error", true);	
}}

@Test(priority=4,dependsOnMethods="EditRecordWithPrevioslyAddedBadgeID")
public void ManuallyNeedToBeCheck(){
	Reporter.log("     ", true);
Reporter.log("Manually Need TO Check Following Items", true);
Reporter.log("Swipe FP(Finger print) of 1002 in Biometric device (For Entry)", true);
Reporter.log("........................", true);
Reporter.log("1)SMS Not to be triggered.(check SMS count in dashboard before and after FP swipe)", true);
Reporter.log("2)Attendance register to be updated.", true);
Reporter.log("3)Biometric screen to be updated as IN with intime.", true);
Reporter.log("4)Summary listing tobe updated as 2/1", true);
Reporter.log("Swipe FP of 1002 in Biometric (For Exit)", true);
Reporter.log("........................", true);
Reporter.log("1)  SMS Not to be triggered.(check SMS count in dashboard before and after FP swipe)", true);
Reporter.log("2) Attendance register to be updated.", true);
Reporter.log("3) Biometric screen to be updated as OUT with Out time.", true);
Reporter.log("4) Summary listing tobe updated as 2/2 under inhouse staff.", true);
	
}








}

