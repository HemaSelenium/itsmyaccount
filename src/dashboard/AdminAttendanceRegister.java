package dashboard;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
public class AdminAttendanceRegister extends TestBase {
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->AttendanceRegister", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);	
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
}
@Test(priority=2)
public void AttendanceRegister() throws InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnMaintenanceTeam);
Thread.sleep(4000);
Method.CompareAttendanceRegisterMembersAndMaintenanceTeamMembers();
}
@Test(priority=3)
public void AddAttendanceToMembers() throws InterruptedException, IOException{
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(3000);
try{
Reporter.log("Before Add Attendance To Member Number Of Days Worked Is: "+SeleniumHelper.driver.findElement(By.xpath(VariableCalling.GetNumberOfDaysWorked)).getText(), true);
helper.ClickByXpath(VariableCalling.AddOneDayAttendance);
helper.ClickByID(VariableCalling.ClickOnSave);
Thread.sleep(2000);
helper.ProcessAlert();
Thread.sleep(2000);
String NumberOfWorkingDaysAfterAddAttendance=SeleniumHelper.driver.findElement(By.xpath(VariableCalling.GetNumberOfDaysWorked)).getText();
System.out.println("After Add Attendance To Member Number Of Days Worked Is: "+NumberOfWorkingDaysAfterAddAttendance);
Thread.sleep(4000);
if(SeleniumHelper.driver.findElement(By.xpath(VariableCalling.GetNumberOfDaysWorked)).getText().equals(NumberOfWorkingDaysAfterAddAttendance)){
Reporter.log("Attendance Saved Sucessfully", true);
}
else{
Reporter.log("Attendance Not Saved Sucessfully", true);
}
}
catch(NoSuchElementException e){
Reporter.log("Either In HouseStaff Details Not Available In Attendance Register  ", true);
}
File AttendanceAfterSaving=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AttendanceAfterSaving, new File(GlobalVariablesCalling.ScreenShotsFileName+"AttendanceAfterSaving.png"));


helper.ClickByXpath(VariableCalling.ClickOnDropDownListOfMonths);
Thread.sleep(2000);
helper.ClickByLinkText(VariableCalling.SelectMonthToGetAttendancce);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnDropDownListOfYears);
Thread.sleep(2000);
helper.ClickByLinkText(VariableCalling.SelectYearToGetAttendance);
Thread.sleep(2000);
helper.ClickByID("getAttendance");
}
@Test(priority=4)
public void Export() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInAttendanceregistor);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInAttendanceRegistor);
Thread.sleep(4000);
File AdminAttendanceRegisterPdf=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AdminAttendanceRegisterPdf, new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminAttendanceRegisterPdf.png"));

}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AttendanceAfterSaving.png" +  " AttendanceAfterSaving", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminAttendanceRegisterPdf.png" + " AdminAttendanceRegisterPdf", true);
Reporter.log(" ", true);
}

}

