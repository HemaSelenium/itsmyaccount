package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class ManageMembers extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Dashboard--->Manage Members(Edit Managemember details,Move out& Create New Member)", true);	 
Reporter.log("-------------------------------------------------------------------------------------------------------", true);	 
Reporter.log("", true);	 
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
}
@Test(priority=2)
public void EditManagMemberDetails() throws InterruptedException, IOException, HeadlessException, AWTException
{
WebElement Member=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement>RowsInMember= Member.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement>coloumnsInMember= RowsInMember.get(RowsInMember.size()-1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.DeepSleep();
Reporter.log("1)Mobile Number Of member Before Editing:  "+coloumnsInMember.get(5).findElement(By.tagName("input")).getAttribute("value"), true);	 
helper.DeepSleep();
coloumnsInMember.get(5).findElement(By.tagName("input")).clear();
helper.DeepSleep();
coloumnsInMember.get(5).findElement(By.tagName("input")).sendKeys(VariableCalling.EnterMemberContactNumber);
helper.Sleep();
Reporter.log("2)MailId Of member Before Editing:  "+coloumnsInMember.get(7).findElement(By.tagName("input")).getAttribute("value"), true);	 
coloumnsInMember.get(7).findElement(By.tagName("input")).clear();
helper.Sleep();
coloumnsInMember.get(7).findElement(By.tagName("input")).sendKeys(VariableCalling.EnterMemberMailId);
helper.Sleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnSaveButtonInManageMembers)).click();
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnDashBoardButton)).click();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
helper.MaxSleep();
WebElement MemberList=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement>RowsInMemberList= MemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement>coloumnsInMemberList= RowsInMemberList.get(RowsInMemberList.size()-1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
Reporter.log("3)Mobile Number Of member After Editing:  "+coloumnsInMemberList.get(5).findElement(By.tagName("input")).getAttribute("value"), true);	 
Reporter.log("4)MailId Of member After Editing:  "+coloumnsInMemberList.get(7).findElement(By.tagName("input")).getAttribute("value"), true);	 
String OccupancyOfMember=coloumnsInMemberList.get(3).findElement(By.tagName("select")).getAttribute("value");
if (OccupancyOfMember.equals("O")){
Reporter.log("5)OccupancyOfMember : Owner", true);	 
coloumnsInMemberList.get(3).findElement(By.xpath(VariableCalling.SelectOccupancyAsTenant)).click();	
helper.MaxSleep();
helper.TakeScreenShotOfWindowPopUp("Change Occupancy Of Member");
helper.ProcessAlert();
}
else{
Reporter.log("5)OccupancyOfMember : Tenant", true);	 
coloumnsInMemberList.get(3).findElement(By.xpath(VariableCalling.SelectOccupancyAsOwner)).click();	
helper.DeepSleep();
helper.ProcessAlert();
helper.DeepSleep();
 }}
@Test(priority=3)
public void MoveOut() throws InterruptedException, IOException{
WebElement MemberList=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement>RowsInMemberList= MemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement>coloumnsInMemberList= RowsInMemberList.get(RowsInMemberList.size()-1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.DeepSleep();
String MovedUserName=coloumnsInMemberList.get(2).findElement(By.tagName("input")).getAttribute("value");
Reporter.log("6)MovedUserName : "+MovedUserName, true);	 
String MovedMemberName=coloumnsInMemberList.get(4).findElement(By.tagName("input")).getAttribute("value");
Reporter.log("7)move out MemberName : "+coloumnsInMemberList.get(4).findElement(By.tagName("input")).getAttribute("value"), true);	    
helper.DeepSleep();
coloumnsInMemberList.get(37).findElement(By.tagName("input")).click();
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.MovementDateLocation)).sendKeys(GlobalVariablesCalling.EnterMemberMoveOutdate);
helper.Sleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnMovedOutButton)).click(); 
helper.DeepSleep();
WebDriverWait wait = new WebDriverWait(SeleniumHelper.driver, 2);
try{
wait.until(ExpectedConditions.alertIsPresent());
Alert alert = SeleniumHelper.driver.switchTo().alert();
String msg = alert.getText();
Reporter.log("8)"+msg, true);	 
alert.accept();  
 }catch(Exception e){
	      }
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectOwnerTenantMoveMentButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectMemberNameToSearch);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearch,MovedMemberName );
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
try{
String ValueInMemberNameField=helper.GetValueByXpath(VariableCalling.GetTextFromMemberNameField);
if(MovedMemberName.equals(ValueInMemberNameField))
{
Reporter.log("9)In Moved out register  "+MovedMemberName+"  is available", true);
helper.TakeScreenShot("SearchForMoveoutMemberInMovementRegister");

Method3.CheckOccupationIsFreeOrNot();
helper.DeepSleep();
}
else{
Reporter.log(" 9)In Moved out register  "+MovedMemberName+"  is not available", true);	 
Method3.CheckOccupationIsFreeOrNot();
helper.DeepSleep();
}}
catch(NoSuchElementException ignored){
Reporter.log("9)Eaither Search Not Working Or MoveOutMember Not Available ", true);	 
Method3.CheckOccupationIsFreeOrNot();
helper.DeepSleep();
}}
@Test(priority=4)
public void CreateNewMember() throws InterruptedException, IOException{
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnDashBoardButton)).click();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
helper.DeepSleep();
WebElement MemberList=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement>RowsInMemberList= MemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
List<WebElement>coloumnsInMemberList= RowsInMemberList.get(RowsInMemberList.size()-1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
JavascriptExecutor jse = (JavascriptExecutor)SeleniumHelper.driver;
jse.executeScript("arguments[0].setAttribute('type', 'text');", coloumnsInMemberList.get(2).findElement(By.tagName("input")));
helper.Sleep();
String NewUserId=coloumnsInMemberList.get(2).findElement(By.tagName("input")).getAttribute("value");
//coloumnsInMemberList.get(2).findElement(By.tagName("input")).clear();
helper.MaxSleep();
//coloumnsInMemberList.get(2).findElement(By.tagName("input")).sendKeys(NewUserId);
helper.DeepSleep();
coloumnsInMemberList.get(3).findElement(By.tagName("select")).sendKeys(GlobalVariablesCalling.SelectOcuupancyTypeForNewMember);
helper.DeepSleep();
coloumnsInMemberList.get(3).findElement(By.tagName("select")).sendKeys(Keys.ENTER);
helper.Sleep();
coloumnsInMemberList.get(4).findElement(By.tagName("input")).sendKeys(GlobalVariablesCalling.EnterMemberName); 
coloumnsInMemberList.get(5).findElement(By.tagName("input")).sendKeys(GlobalVariablesCalling.EnterMemberContactNumber); 
coloumnsInMemberList.get(7).findElement(By.tagName("input")).sendKeys(GlobalVariablesCalling.EnterMemberMailId); 
//coloumnsInMemberList.get(14).findElement(By.tagName("input")).click();
helper.DeepSleep();
try{
//coloumnsInMemberList.get(15).findElement(By.tagName("input")).sendKeys(GlobalVariablesCalling.EnterNumberOfMembersInApartment); 
String FlateSize=coloumnsInMemberList.get(24).findElement(By.tagName("input")).getAttribute("value");
if(!FlateSize.equals("none")){
Reporter.log("10)While Adding New User Flate Size Filled Automatically From Previous Record", true);	 
  }
else{
Reporter.log("10)Flate Size Field Is Empty", true);	 
 }
coloumnsInMemberList.get(14).findElement(By.tagName("input")).click();

SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnSaveButtonInManageMembers)).click();
helper.MaxSleep();
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
helper.DeepSleep();
Alert alert = SeleniumHelper.driver.switchTo().alert();
String msg = alert.getText();
Reporter.log("Message popup Came As " +msg, true);
alert.accept();
helper.Sleep();
}
catch(NoAlertPresentException e){
	
}

SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnLogoutButton));
helper.DeepSleep();
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName", NewUserId);
helper.DeepSleep();	    
helper.SetValue1("Password", GlobalVariablesCalling.EnterOldMemberPassword);
helper.DeepSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
SeleniumHelper.driver.findElement(By.name("oldpassword")).sendKeys(GlobalVariablesCalling.EnterOldMemberPassword);
SeleniumHelper.driver.findElement(By.name("newpassword")).sendKeys(NewUserId);
SeleniumHelper.driver.findElement(By.name("retype")).sendKeys(NewUserId);
helper.ClickByXpath(VariableCalling2.ClickOnNext);
helper.MaxSleep();
if(SeleniumHelper.driver.getCurrentUrl().equals(GlobalVariablesCalling.HomePageUrl)){
Reporter.log("11)Login Sucessfully With New UserCredentials And sucessfully changed Password also", true);	
Reporter.log("12) New Login Credentials are :", true);
Reporter.log("UserID : " +NewUserId, true);
Reporter.log("Password : " +NewUserId, true);
helper.TakeScreenShot("AfterLoginWithNewCredentials");
 }
else{
Reporter.log("11)Login Failed With Newly Created Member Credentials", true);	 
} }
@Test(priority=5)
public void DetailsOfScreenShots(){
Reporter.log(" ", true);	 
Reporter.log("Files Stored in (Path Name)", true);	 
Reporter.log("-----------------------------", true);	 
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Change Occupancy Of Member", true);	 
Reporter.log("File Name: "+GlobalVariablesCalling.ScreenShotsFileName+"SearchForMoveoutMemberInMovementRegister", true);	 
Reporter.log("File Name: "+GlobalVariablesCalling.ScreenShotsFileName+"AfterLoginWithNewCredentials", true);	 
Reporter.log(" ", true);	 
Reporter.log("Items To Be Checked manually", true);	 
Reporter.log("----------------------------", true);	 
Reporter.log("Mobile Number,MailId Edited Or Not", true);	 
Reporter.log("Moved Out Member Is Available In Movement Register Or Not ", true);	 
Reporter.log(" ", true);	 
}}




