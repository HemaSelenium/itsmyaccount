package dashboard;
import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
public class Duelist extends TestBase {
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Admin--->DashBoard--->Duelist", true);	
Reporter.log("-----------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2)
public void SendSMS() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnDueListButton);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.SelectMemberInSearchOptions);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
helper.TakeScreenShot("SearchForMemberInDueList");
helper.Sleep();
try{
String Membername=helper.GetValueByXpath(VariableCalling.MemberNameOfColoumnAfterSearch);
if(Membername.equals(GlobalVariablesCalling.EnterMemberName)){
helper.Sleep();

helper.ClickByID(VariableCalling.SelectOneMember);
helper.ClickByID(VariableCalling.ClickOnSmsButton);				
helper.ProcessAlert();
String MobileNumber=helper.GetValueByXpath(VariableCalling.GetMobileNumberInDueList);
Reporter.log("Sms Sent To : " +MobileNumber, true);	
helper.DeepSleep();
}}
catch(NoSuchElementException e){
Reporter.log("Eaither Search Function Not Working For Member OR Member Not Found In DueList", true);	
}	} 
@Test(priority=3)
public void SendMail() throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.SelectMemberInSearchOptions);
helper.Sleep();
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();	
try{
if(helper.GetValueByXpath(VariableCalling.MemberNameOfColoumnAfterSearch).equals(GlobalVariablesCalling.EnterMemberName)){
	
helper.ClickByID(VariableCalling.SelectOneMember);
helper.ClickByID(VariableCalling.ClickOnEmailButton);
helper.ProcessAlert();
String MailId=helper.GetValueByXpath(VariableCalling.GetTextFromEmailField);
Reporter.log("Mail Sent To : " + MailId, true);	
helper.DeepSleep();
}}
catch(NoSuchElementException e){
Reporter.log("Eaither Search Function Not Working For Member OR Member Not Found In DueList", true);	

}}

@Test(priority=4)
public void TotalAmountInDueList() throws InterruptedException{
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
String TotalAmount=helper.GetValueByID(VariableCalling.GetTotalAmountInDueList);
Reporter.log("TotlAmount in DueList Footer Is: "+TotalAmount, true);	
helper.DeepSleep();
Reporter.log(helper.GetValueByXpath("html/body/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/table/tbody/tr/td[3]"), true);	
}@Test(priority=5)
public void PDfFormate() throws InterruptedException{
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInDueList);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnPDFButtonInDueList);
helper.Sleep();
}
@Test(priority=6)
public void Results() throws InterruptedException{
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchForMemberInDueList", true);	
Reporter.log(" ", true);	
Reporter.log("Items to be checked Manually", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("SMS Status", true);	
Reporter.log("Mail Status", true);
Reporter.log(" ", true);
}
}