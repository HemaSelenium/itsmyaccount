package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminMaintananceTeamMembers extends TestBase{
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->MaintenanceTeammembers", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2,dataProvider="MaintenanceTeamMembers",dataProviderClass= DataProviders2.class)
public void AddMaintenanceMember(String EnterWorkType,String EnterMaintenanceMemberName,String EnterMaintenanceMemberPersonContact1,String EnterMaintenanceMemberPersonContact2,String EnterSalaryOfMaintenanceMember,String EnterAgencyName,String ENterDescriptionInMaintenance,String SearchMemberNameAfterAdd,String SearchMemberContact1AfterAdd,String EnterMaintenanceMemberNameToSearch,String EnterMobilenumberToEdit,String SearchMemberNameAfterEdit,String SearchMemberContact1AfterEdit,String EnterMaintenanceMemberNameToSearchAfterEdit,String SearchForMemberAfterDelete) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnMaintenanceTeam);
Thread.sleep(4000);
helper.ClickByID(VariableCalling.ClickOnAddButton);
Thread.sleep(4000);
helper.SetValueByID("WorkType", EnterWorkType);
helper.SetValueByID("MaintenanceTeamMemberName", EnterMaintenanceMemberName);
helper.SetValueByID("Contact1", EnterMaintenanceMemberPersonContact1);
helper.SetValueByID("Contact2", EnterMaintenanceMemberPersonContact2);
helper.SetValueByID("MonthlySalary", EnterSalaryOfMaintenanceMember);
helper.SetValueByID("Agency", EnterAgencyName);
helper.SetValueByID("Description", ENterDescriptionInMaintenance);
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInMaintenanceTeammembers);
Thread.sleep(4000);
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement MaintenceMemberTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

List<WebElement>RowsOfMaintenceTeamMembers=MaintenceMemberTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));

List<String>MemberList=new ArrayList<String>();
List<String>MemberContacts=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfMaintenceTeamMembers.size();Rows++){

List<WebElement>ColoumnsInMaintenceTeamMembers=RowsOfMaintenceTeamMembers.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));

MemberList.add(ColoumnsInMaintenceTeamMembers.get(3).getText());
MemberContacts.add(ColoumnsInMaintenceTeamMembers.get(4).getText());
}

if(MemberList.contains(SearchMemberNameAfterAdd)){
if(MemberContacts.contains(SearchMemberContact1AfterAdd)){
Reporter.log("1)New Member Added To MaintenceTeam Sucessfully", true);		
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectNameInSearchOptions);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.TextFieldInSearchButtonOfMaintenceTeamMembers, EnterMaintenanceMemberNameToSearch);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
File AddedMaintenanceMember=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedMaintenanceMember, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedMaintenanceMember.png"));

helper.ClickByID(VariableCalling.SelectRow);
Thread.sleep(4000);
helper.ClickByID(VariableCalling.ClickOnEditButton);
Thread.sleep(4000);
helper.SetValueByID("Contact1",EnterMobilenumberToEdit);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInMaintenanceMembers);
Thread.sleep(4000);
WebElement MaintenceTeamMemberTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfMaintenceMembers=MaintenceTeamMemberTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));

List<String>MemberListAfterEdit=new ArrayList<String>();
List<String>MemberConactListAfterEdit=new ArrayList<String>();
for(int RowsInMaintenaceTeam=1;RowsInMaintenaceTeam<RowsOfMaintenceMembers.size();RowsInMaintenaceTeam++){
List<WebElement>ColoumnsInMaintenceMembers=RowsOfMaintenceMembers.get(RowsInMaintenaceTeam).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
MemberListAfterEdit.add(ColoumnsInMaintenceMembers.get(3).getText());
MemberConactListAfterEdit.add(ColoumnsInMaintenceMembers.get(4).getText());
}
if(MemberListAfterEdit.contains(SearchMemberNameAfterEdit)){
if(MemberConactListAfterEdit.contains(SearchMemberContact1AfterEdit)){
Reporter.log("2)Contact Number Of Newly Added Member Edited Sucessfully", true);	
System.out.println();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectNameInSearchOptions);
helper.DeepSleep();
helper.SetValueByXpath(VariableCalling.TextFieldInSearchButtonOfMaintenceTeamMembers, EnterMaintenanceMemberNameToSearchAfterEdit);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
File EditedMaintenanceMember=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedMaintenanceMember, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedMaintenanceMember.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.ProcessAlert();
Thread.sleep(4000);
WebElement MaintencaMembersAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfMaintenceMembersAfterDelete=MaintencaMembersAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>MaintenceMembers=new ArrayList<String>();
for(int RowsAfterDelete=1;RowsAfterDelete<RowsOfMaintenceMembersAfterDelete.size();RowsAfterDelete++){
List<WebElement>ColoumnsAfterDelete=RowsOfMaintenceMembersAfterDelete.get(RowsAfterDelete).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
MaintenceMembers.add(ColoumnsAfterDelete.get(2).getText());
	}
if(MaintenceMembers.contains(SearchForMemberAfterDelete)){
Reporter.log("3)Member Unable To Delete", true);	
}else{
Reporter.log("3)Added Member Deleted Sucessfully", true);	
}Thread.sleep(2000);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);

}

else{
Reporter.log("2)Contact Number Of Newly Added Member Unable To Edited", true);	
}
}else{
Reporter.log("2)After Editing Unable To Find Newly Added Member In List", true);	
}}

else{
Reporter.log("1)unable To Add New Member In MaintenanceMembers", true);	
}	}
else{
Reporter.log("1)Unable To Add New Member In MaintenanceMembers", true);	
}}
@Test(priority=3)
public void Export() throws InterruptedException, HeadlessException, AWTException, IOException{
helper.ClickByXpath(VariableCalling. ClickOnExportButtonInMaintenanceMembers);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInMaintenanceMembers);
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminMaintenceTeamMembersPdf .png"));

 }
@Test(priority=4)
public void Results(){
	Reporter.log(" ", true);	
	Reporter.log("Files Stored in (Path Name)", true);	
	Reporter.log("-----------------------------", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedMaintenanceMember.png" + "  AddedMaintenanceMember", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedMaintenanceMember.png" + "  EditedMaintenanceMember", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminMaintenceTeamMembersPdf.png" + "  AdminMaintenceTeamMembersPdf", true);	
	Reporter.log(" ", true);	
	Reporter.log("Items to be checked Manually", true);	
	Reporter.log("-----------------------------", true);	
	Reporter.log("Check Added MaitenceMember Deleted Or Not", true);	
	Reporter.log(" ", true);	

}




}
