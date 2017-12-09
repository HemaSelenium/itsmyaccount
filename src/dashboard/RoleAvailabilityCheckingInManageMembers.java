package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class RoleAvailabilityCheckingInManageMembers extends TestBase{
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Manage Members----->Scroll right most to check whether Added Role is available for assignment in each row of member under Role Assignment", true);
Reporter.log("------------------------------------------------------------------------------------------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.DeepSleep();
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.DeepSleep();
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.Sleep();
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
}
@Test(priority=2)	
public void RoleAvailability() throws InterruptedException, IOException {
helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
helper.MaxSleep();
Method. AvailabilityCheckManageRole();
helper.MaxSleep();
helper.TakeScreenShot("AddedRoleIsAssigningToMembers");
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInManageMembers);
helper.MaxSleep();
}
@Test(priority=3,dependsOnMethods="RoleAvailability")
public void DeleteRoleAfterAssignToMember() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling. ClickOnManageRoleButton);
helper.MaxSleep();
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
Method.selectRow();
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.MaxSleep();
helper.ProcessAlert();
helper.DeepSleep();
helper.TakeScreenShotOfWindowPopUp("TryToDeleteRoleAfterAssigningToMember");
helper.ProcessAlert();
helper.MaxSleep();
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedRoleIsAssigningToMembers", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"TryToDeleteRoleAfterAssigningToMember", true);
Reporter.log(" ", true);
}

     
    
    
    
    
    
}
}
