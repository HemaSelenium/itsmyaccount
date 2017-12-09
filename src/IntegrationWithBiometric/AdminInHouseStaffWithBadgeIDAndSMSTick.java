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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminInHouseStaffWithBadgeIDAndSMSTick extends TestBase{
public String InHouseStaffMemberName;
public String ContactNo;
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
@Test(priority=2,dataProvider="InhouseWithBadgeID",dataProviderClass= DataProvider8.class)
public void AddRecord(String EnterWorkType,String InHouseStaffMember,String StaffContact1,String StaffContact2,String EnterSalaryOfStaffMember,String EnterAgencyName,String EnterDescription,String BadgeId,String Reference1,String Reference2,String Reference3     ) throws IOException, AWTException, InterruptedException{
InHouseStaffMemberName=InHouseStaffMember;
ContactNo=StaffContact1;
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
helper.TakeScreenShot("AddedMaintenanceMember");
helper.Sleep();
WebElement MaintenceMemberTable1=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfMaintenceTeamMembers1=MaintenceMemberTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>ColoumnsInMaintenceTeamMembers1=RowsOfMaintenceTeamMembers1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String Badge=ColoumnsInMaintenceTeamMembers1.get(2).getAttribute("title");
int BadgeNumber=Integer.parseInt(Badge);
String Badgeid = String.valueOf(BadgeNumber);

if(Badgeid.isEmpty()){
	helper.Sleep();
Reporter.log("1)New Member Added Sucessfully In InHouse Staff But  Badge Id Coloumn Is Empty  " , true);
ColoumnsInMaintenceTeamMembers1.get(2).click();
helper.DeepSleep();
helper.TakeScreenShot("Badge Id Coloumn Is Empty In InHouse Staff");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Badge Id Coloumn Is Empty In InHouse Staff", true);
}
else{
if(Badgeid.equals(BadgeID)){
Reporter.log("1)New Member Added Sucessfully In InHouse Staff With Badge Id : " +BadgeID, true);
ColoumnsInMaintenceTeamMembers1.get(2).click();
helper.DeepSleep();
helper.TakeScreenShot("In InHouse Staff With Badge Id");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"In InHouse Staff With Badge Id", true);
}
else{
System.out.println("1)Badge Id Which Given As Input Is Replaced With following Id :"+Badgeid);
ColoumnsInMaintenceTeamMembers1.get(2).click();
helper.DeepSleep();
helper.TakeScreenShot("Added Badge Id Replaced With Other");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added Badge Id Replaced With Other", true);

}}}else{
Reporter.log("1)Unable To Add New Member In InHouse Staff", true);	
}}
else{
Reporter.log("1)Unable To Add New Member In InHouse Staff", true);	
}}

@Test(priority=3,dataProvider="EditInhouseStaffDetails",dataProviderClass= DataProvider8.class,dependsOnMethods="AddRecord")
public void EditRecord(String StaffName,String ContactNumber) throws IOException, AWTException, InterruptedException{
	InHouseStaffMemberName=StaffName;
	ContactNo=ContactNumber;
	helper.DeepSleep();
	helper.ClickByID(VariableCalling.ClickOnEditButton);
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling2.WebCameImageOnLeftSide);
	helper.DeepSleep();
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling2.TakeSnapShotOnLeftSide);
	helper.DeepSleep();
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling2.UploadImageOnRightSide);
	helper.Sleep();
	helper.Sleep();
	StringSelection stringSelection1 = new StringSelection(GlobalVariablesCalling.ImageToUpload);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, stringSelection1);
	Robot rb1=new Robot();
	rb1.keyPress(KeyEvent.VK_CONTROL);
	rb1.keyPress(KeyEvent.VK_V);
	rb1.keyRelease(KeyEvent.VK_V);
	rb1.keyRelease(KeyEvent.VK_CONTROL);
	helper.Sleep();
	rb1.keyPress(KeyEvent.VK_ENTER);
	rb1.keyRelease(KeyEvent.VK_ENTER);
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
	WebElement MaintenceMemberTable1=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

	List<WebElement>RowsOfMaintenceTeam=MaintenceMemberTable1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
	List<String>MemberList1=new ArrayList<String>();
	List<String>MemberContacts1=new ArrayList<String>();
	for(int Rows=1;Rows<RowsOfMaintenceTeam.size();Rows++){
	List<WebElement>ColoumnsInMaintenceTeam=RowsOfMaintenceTeam.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
	MemberList1.add(ColoumnsInMaintenceTeam.get(4).getText());
	MemberContacts1.add(ColoumnsInMaintenceTeam.get(5).getText());
	}
	if(MemberList1.contains(InHouseStaffMemberName)){
	if(MemberContacts1.contains(ContactNo)){	
	helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.SelectNameInSearchOptions);
	helper.Sleep();
	helper.SetValueByXpath(VariableCalling.TextFieldInSearchButtonOfMaintenceTeamMembers, InHouseStaffMemberName);
	helper.ClickByXpath(VariableCalling.ClickOnFindButton);
	helper.Sleep();
	helper.ClickByXpath(VariableCalling.CloseSearchFunction);
	helper.DeepSleep();
	try{
	helper.ClickByID(VariableCalling.SelectRow);
	helper.DeepSleep();
	helper.ClickByID(VariableCalling.ClickOnEditButton);
	helper.DeepSleep();
	helper.DeepSleep();
	helper.TakeScreenShot("Edited Inhousestaff Record");
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Inhousestaff Record", true);
	
	
	}
	catch(NoSuchElementException e){
	Reporter.log("Search with Name Didn't work  ", true);
	}}}
}

@Test(priority=4,dataProvider="ExistedBadgeID",dataProviderClass= DataProvider8.class,dependsOnMethods="EditRecord")
public void EditRecordWithAlreadyExistedBadgeId(String ExistedBadgeId) throws InterruptedException, IOException{
helper.DeepSleep();
helper.SetValueByID("PassNo", ExistedBadgeId);
helper.Sleep();	
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInMaintenanceTeammembers);
helper.DeepSleep();
helper.TakeScreenShot("Edited Inhousestaff Record With Existed BadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Inhousestaff Record With Existed BadgeId", true);
try{
helper.ProcessAlert();
helper.Sleep();
}
catch(NoAlertPresentException e){
Reporter.log("Even Record Edited With Existed BadgId Did't Get Any Error", true);	
}

}

@Test(priority=5)
public void ManuallyNeedToBeCheck(){
	Reporter.log("Swipe FP(Finger print) of 1001 in Biometric device (For Entry)", true);
	Reporter.log("........................", true);
	Reporter.log("1) SMS to reach moderator as ENTERED", true);
	Reporter.log("2) Attendance register to be updated", true);
	Reporter.log("3) Biometric screen to be updated as IN with intime", true);
	Reporter.log("4) Bio-metric Summary listing tobe updated as 1/0", true);
	Reporter.log("Swipe FP of 1001 in Biometric (For Exit)", true);
	Reporter.log("........................", true);
	Reporter.log("1)  SMS to reach moderator as  LEFT", true);
	Reporter.log("2) Biometric screen to be update as OUT with out time", true);
	Reporter.log("3) Bio-metric Summary listing to be uploaded as 1/1", true);
	
	
}




}
