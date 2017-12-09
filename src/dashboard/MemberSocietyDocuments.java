package dashboard;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberSocietyDocuments extends TestBase{
@Test(priority=1)
public void Login(){
Reporter.log("Script Name:Member---->Application--->CurrentEvents", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority = 2, dependsOnMethods = "Login")
public void DocumentsList()throws InterruptedException, IOException {
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSocietyDocuments);
helper.DeepSleep();
Reporter.log("Society Documents Only Able To View", true);
helper.TakeScreenShot("MemberSocietyDocuments");
}
@Test(priority=3,dependsOnMethods = "DocumentsList")
public void Search() throws InterruptedException, IOException{
String EnterDocumentNameToSearch=helper.GetValueByXpath(VariableCalling2.TypeOfEventInFirstRow);
Reporter.log("Searching For Current Event Of: "+EnterDocumentNameToSearch, true);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(3000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, EnterDocumentNameToSearch);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
helper.TakeScreenShot("SearchDocumentName");
}
@Test(priority=4,dependsOnMethods = "Search")
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberSocietyDocuments" + "  MemberSocietyDocuments", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchDocumentName" + "  SearchDocumentName", true);
Reporter.log(" ", true);

}}
