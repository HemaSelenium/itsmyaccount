package dashboard;
import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class Managerole extends TestBase{
@Test(priority=1)
public void AddRole()throws Exception{
Reporter.log("Script Name:Manage Roles-->Add New Role --> Edit New Role and existing any role-->View Changes affected after editing-->Delete New Role-->	Add New Role", true);
Reporter.log("-----------------------------------------------------------------------------------------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.MaxSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.Sleep();
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.Sleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.Sleep();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling. ClickOnManageRoleButton);
helper.DeepSleep();
helper.TakeScreenShot("ManagerolesBeforeAdding");
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("RoleName", GlobalVariablesCalling.EnterRoleNameToAdd);
helper.Sleep();
Method.FullAccessGivenToMySociety();
helper.DeepSleep();
Method.FullAccessGivenToAssets();
helper.Sleep();
Method.FullAccessGivenToComplaints();
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInManageRole);
helper.DeepSleep();
helper.TakeScreenShot("ManagerolesAfterAdding");
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.SelectRoleNameInSearch);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EnterRoleNameToAdd);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
String RoleName=helper.GetValueByXpath(VariableCalling.RoleNameAfterSearch);
helper.DeepSleep();
if(RoleName.equals(GlobalVariablesCalling.EnterRoleNameToAdd)){
helper.DeepSleep();
Reporter.log(" Role Added As : "+GlobalVariablesCalling.EnterRoleNameToAdd, true);
helper.Sleep();


}else{
Reporter.log(GlobalVariablesCalling.EnterRoleNameToAdd+" Role Not Added", true);
}}	@Test(priority=2)
public void EditRole() throws InterruptedException, IOException{
	helper.DeepSleep();
//Method.SelectManageRole();
Method.selectRow();
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("RoleName", GlobalVariablesCalling.EditedRoleName);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInManageRole);
helper.DeepSleep();
helper.TakeScreenShot("ManagerolesAfterEditing");
helper.DeepSleep();
helper.RefreshPage();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectRoleNameInSearch);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EditedRoleName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
String RoleName=helper.GetValueByXpath(VariableCalling.RoleNameAfterSearch);
helper.MaxSleep();
if(RoleName.equals(GlobalVariablesCalling.EditedRoleName)){
helper.Sleep();
Reporter.log(GlobalVariablesCalling.EnterRoleNameToAdd+" Role Edited As "+GlobalVariablesCalling.EditedRoleName, true);
Method.selectRow();
}else{
Reporter.log(GlobalVariablesCalling.EnterRoleNameToAdd+" Role Not Edited As "+GlobalVariablesCalling.EditedRoleName, true);
}}	
@Test(priority=3)
public void DeleteRole() throws InterruptedException, IOException{					
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.ProcessAlert();
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.TakeScreenShot("ManagerolesListAfterDelete");
Method.SearchRoleAfterDelete();

}
@Test(priority=4)
public void AddNewRole() throws InterruptedException, IOException{	
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.Sleep();
helper.SetValueByID("RoleName", GlobalVariablesCalling.EnterRoleNameToAdd);
helper.Sleep();
Method.FullAccessGivenToMySociety();
helper.DeepSleep();
Method.FullAccessGivenToAssets();
helper.Sleep();
Method.ReadAccessGivenToSocietyInventory();
helper.Sleep();
Method.ReadAccessGivenToAMCDetails();
helper.Sleep();
Method.ReadAccessGivenToSocietyDocuments();
helper.Sleep();
Method.FullAccessGivenToComplaints();
helper.Sleep();
Method.ReadAccessGivenToComplaintsTracker();
helper.Sleep();
Method.FullAccessGivenToMyAccount();
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInManageRole);
helper.MaxSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.TakeScreenShot("RoleAddedAgainAfterDelete");
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectRoleNameInSearch);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearch, GlobalVariablesCalling.EnterRoleNameToAdd);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
String RoleName=helper.GetValueByXpath(VariableCalling.RoleNameAfterSearch);
helper.MaxSleep();
if(RoleName.equals(GlobalVariablesCalling.EnterRoleNameToAdd)){
helper.MaxSleep();
Reporter.log(" Role Added As : "+GlobalVariablesCalling.EnterRoleNameToAdd, true);
}
else{
Reporter.log(GlobalVariablesCalling.EnterRoleNameToAdd+" Role Not Added", true);
	}
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ManagerolesBeforeAdding", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ManagerolesAfterAdding", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ManagerolesAfterEditing", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ManagerolesListAfterDelete", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"RoleAddedAgainAfterDelete", true);
Reporter.log("--------------------------------------------------------------------------------------------------------------------------------", true);
Reporter.log(" ", true);
}	}
	
	


