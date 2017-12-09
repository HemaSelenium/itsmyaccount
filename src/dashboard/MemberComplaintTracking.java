package dashboard;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberComplaintTracking extends TestBase {
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Member---->Application--->MyComplaints---->TrackComplaints", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
Thread.sleep(3000);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
}
@Test(priority=2,dataProvider="MemberComplaintTracker",dataProviderClass= DataProviders2.class)
public void GetComplaintsByGivingFromAndToDate(String EnterFromDate,String EnterToDate ) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnComplaintTrackingButton);
Thread.sleep(4000);
Reporter.log("Member Can Only Able To See Complaint Status", true);	
helper.TakeScreenShot("Member Tracking Complaints");
helper.SetValueByID(VariableCalling2.EnterFromDdate, EnterFromDate);
Thread.sleep(4000);
helper.SetValueByID(VariableCalling2.EnterToDate, EnterToDate);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnComplaintsButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInComplaints);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInComplaints);
Thread.sleep(4000);
Reporter.log("Complaints Data Exported Into Pdf", true);	
Reporter.log(" ", true);	
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Member Tracking Complaints" +  "     Member Tracking Complaints", true);	
Reporter.log(" ", true);	
}
	
	
	
	
	
	
}
