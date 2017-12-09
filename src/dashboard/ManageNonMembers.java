package dashboard;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class ManageNonMembers extends TestBase {
@Test(priority=1)
public void Login() throws Exception {
Reporter.log("Script Name:Manage Non-Members--> Create New User id--> Edit New User id-->>Delete New RUser Id-->	Add New User Id...>Assign Role and Save....>Login WithNew User ID", true);	
Reporter.log("------------------------------------------------------------------------------------------------------------------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.MaxSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.Sleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
}
@Test(priority=2)
public void AddNonMember() throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnManageNonMembersButton);	
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.Sleep();
helper.SetValueByID("NonMemberName", GlobalVariablesCalling.EnterNonMemberName);
helper.Sleep();
helper.SetValueByID("NonMemberContact", GlobalVariablesCalling.EnterNonMemberContactNumber);
helper.Sleep();
helper.SetValueByID("NonMemberEmail",GlobalVariablesCalling.EnterNonMemberEmail);
helper.Sleep();
helper.SetValueByID("UserName", GlobalVariablesCalling.EnterNonMemberUserName);	
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSAveButtonInNonMembers);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectNonMemberNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EnterNonMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
helper.TakeScreenShot("SearchAddedNonMember");
WebElement NonMemberList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.DeepSleep();
List<WebElement>RowsInNonMemberList= NonMemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
for(int rows=0;rows<RowsInNonMemberList.size();rows++){
List<WebElement>coloumnsInNonMemberList= RowsInNonMemberList.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
String NonMemberUserName=coloumnsInNonMemberList.get(3).getText();
helper.Sleep();
if(NonMemberUserName.equals(GlobalVariablesCalling.EnterNonMemberUserName)){
Reporter.log("NonMember Details Added Sucessfully", true);		
coloumnsInNonMemberList.get(3).click();
helper.DeepSleep();
}}}
@Test(priority=3,dependsOnMethods={"AddNonMember"})
public void EditNonMember() throws Exception{
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.MaxSleep();
helper.SetValueByID("NonMemberContact", GlobalVariablesCalling.EnterNewNonMemberContactNumberToEdit);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSAveButtonInNonMembers);
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectNonMemberNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EnterNonMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
Method3.VerifyingNonMemberUserNameAfterEdit();
helper.DeepSleep();
}
@Test(priority=4,dependsOnMethods={"EditNonMember"})
public void DeleteNonMember() throws InterruptedException{
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectNonMemberNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EnterNonMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
Method.SelectNonMemberUserName();
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.DeepSleep();
helper.ProcessAlert();		
helper.DeepSleep();
}@Test(priority=5,dependsOnMethods={"DeleteNonMember"})
public void AddNonMemberAfterDelete() throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnManageNonMembersButton);	
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("NonMemberName", GlobalVariablesCalling.EnterNonMemberNameToAddAfterDelete);
helper.Sleep();
helper.SetValueByID("NonMemberContact", GlobalVariablesCalling.EnterNonMemberContactNumber);
helper.Sleep();
helper.SetValueByID("NonMemberEmail",GlobalVariablesCalling.EnterNonMemberEmail);
helper.Sleep();
helper.SetValueByID("UserName", GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete);	
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnRoleDropDownListButton);
helper.DeepSleep();
helper.ClickByLinkText(GlobalVariablesCalling.EnterRoleNameToAdd);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSAveButtonInNonMembers);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectNonMemberNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EnterNonMemberNameToAddAfterDelete);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement NonMemberList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
List<WebElement>RowsInNonMemberList= NonMemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.Sleep();
for(int rows=0;rows<RowsInNonMemberList.size();rows++){
helper.Sleep();
List<WebElement>coloumnsInNonMemberList= RowsInNonMemberList.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
String NonMemberUserName=coloumnsInNonMemberList.get(3).getText();
helper.Sleep();
if(NonMemberUserName.equals(GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete)){
Reporter.log("NonMember Details Added Sucessfully", true);		
 }   }	}
@Test(priority=6,dependsOnMethods={"AddNonMemberAfterDelete"})
public void LoginWithNewDetails() throws Exception {
helper.ClickByXpath(VariableCalling2.ClickOnLogoutButton);
helper.DeepSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete);
helper.SetValue1("Password", VariableCalling2.NonMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.Sleep();
helper.SetValueByXpath(VariableCalling2.NonMemberPasswordLocation,VariableCalling2.NonMemberPassword);
helper.SetValueByID("newpassword", GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete);
helper.Sleep();
helper.SetValueByID("retype", GlobalVariablesCalling.EnterNonMemberUserNameToAddAfterDelete);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnNext);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.MyResidentsButton);
helper.DeepSleep();
Reporter.log("Clicked On MyResidents Button", true);	
helper.DeepSleep();
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException e){
Reporter.log("Entered Into My Residents Screen", true);	
}
helper.ClickByXpath(VariableCalling.ClickOnLogoutButtonInNonMemberLogin);
helper.DeepSleep();
}
@Test(priority=7,dependsOnMethods={"AddNonMemberAfterDelete"})
public void Export() throws InterruptedException, IOException{
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.Sleep();
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.Sleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnManageNonMembersButton);	
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnExportButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnPdfButton);
helper.DeepSleep();
helper.TakeScreenShot("ManageNonMembersPdf");
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ManageNonMembersPdf", true);	
Reporter.log("File Name: "+GlobalVariablesCalling.ScreenShotsFileName+"SearchAddedNonMember", true);	
 }
}
	
	
	
	


