package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class Noticeboard extends TestBase {
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->Dashboard--->NoticeBoard", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValueByID("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValueByID("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
}
@Test(priority=2)
public void AddMessageToNoticeBoard() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.ClickByXpath(VariableCalling.ClickOnNoticeBoard);
Thread.sleep(4000);
helper.ClickByID(VariableCalling.ClickOnAddButton);
Thread.sleep(4000);
helper.SetValueByID("Message", VariableCalling.EnterMessageInNoticeBoard);
helper.SetValueByID("ValidTo", MethodsCalling.EnterTomorrowDate());
Thread.sleep(4000);
SeleniumHelper.driver.findElement(By.id("ValidTo")).sendKeys(VariableCalling.PressTabKey);
Thread.sleep(2000);	
helper.ClickByID(VariableCalling.ClickOnSave);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectMessageInSearchOptions);
Thread.sleep(4000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, VariableCalling.EnterMessageInNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
helper.TakeScreenShot("SearchForAddedMessageInNoticeBoard");
WebElement NoticeBoard = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement> TableRows = NoticeBoard .findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>TableColoumns=TableRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String MessageInNoticeBoard=TableColoumns.get(3).getText();
if(MessageInNoticeBoard.equals(VariableCalling.EnterMessageInNoticeBoard)){
Reporter.log("1)Entered Message In NoticeBoard As : "+VariableCalling.EnterMessageInNoticeBoard, true);
Reporter.log("2)Message Added To NoticeBoard List ", true);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnViewAllButtonInNoticeBoard);
Thread.sleep(3000);
helper.TakeScreenShot("MessagesInPllicationNoticeBoard");
Method.FindingMessageInApplicationNoticeBoard();
helper.ClickByID("Close");
	}
else{
Reporter.log("Message Not Added", true);
	}
	}
@Test(priority=3,dependsOnMethods={"AddMessageToNoticeBoard"})
public void EditMessageInNoticeBoard() throws InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.SelectMessageInSearchOptions);
Thread.sleep(4000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, VariableCalling.EnterMessageInNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
WebElement NoticeBoard = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
Thread.sleep(4000);
List<WebElement> TableRows = NoticeBoard .findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>TableColoumns=TableRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String MessageInNoticeBoard=TableColoumns.get(3).getText();
if(MessageInNoticeBoard.equals(VariableCalling.EnterMessageInNoticeBoard)){
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("Message", VariableCalling.EnterMessageToEditInNoticeBoard);
helper.ClickByID(VariableCalling.ClickOnSave);
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.SelectMessageInSearchOptions);
Thread.sleep(4000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, VariableCalling.EnterMessageToEditInNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
WebElement NoticeBoardMessages = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement> tableRows1 = NoticeBoardMessages .findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
try{
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String NoticeBoardMessage=tablecoloumns.get(3).getText();
if(NoticeBoardMessage.equals(VariableCalling.EnterMessageToEditInNoticeBoard)){
Reporter.log("4)Message In NoticeBoard Edited Sucessfully ", true);
}}
catch(NoSuchElementException e){
Reporter.log("4)Either Search Not Working Or Message Not Edited", true);
}}
else{
Reporter.log("4)Searched Item Not Same As Edited Item", true);
}}
@Test(priority=4,dependsOnMethods={"EditMessageInNoticeBoard"})
public void DeleteMessageInNoticeBoard() throws InterruptedException, IOException, HeadlessException, AWTException{
boolean Result=true;
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnNoticeBoard);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.SelectMessageInSearchOptions);
Thread.sleep(2000);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, VariableCalling.EnterMessageToEditInNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
helper.ClickByID(VariableCalling.SelectRow);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
Thread.sleep(3000);
helper.ProcessAlert();
Thread.sleep(3000);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement NoticeBoardMessages = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement> tableRows1 = NoticeBoardMessages .findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String> list = new ArrayList<String>();
for (int MessageRows = 1; MessageRows < tableRows1.size(); MessageRows++) {
List<WebElement> tablecoloumns = tableRows1.get(MessageRows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
list.add(tablecoloumns.get(3).getText());
Thread.sleep(5000);
}
for(int MessagesInNoticeBoard=0;MessagesInNoticeBoard<list.size();MessagesInNoticeBoard++){
if(list.get(MessagesInNoticeBoard).equals(VariableCalling.EnterMessageToEditInNoticeBoard)){
Result=false;
}}
if (Result){
Reporter.log("5)NoticeBoard Message Deleted Sucessfully", true);
Thread.sleep(1000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnViewAllButtonInNoticeBoard);
Thread.sleep(3000);
helper.TakeScreenShot("List Of Messages In NoticeBoard After Delte");
Method.FindingMessageInApplicationNoticeBoard();
helper.ClickByID("Close");
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInNoticeBoard);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInNoticeBoard);	
Thread.sleep(4000);
helper.TakeScreenShotOfExportPDF("NoticeBoardPdf");
}
else{
Reporter.log("5)Message  Not Deleted", true);
}
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchForAddedMessageInNoticeBoard" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MessagesInPllicationNoticeBoard", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"List Of Messages In NoticeBoard After Delte", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"NoticeBoardPdf", true);
Reporter.log(" ", true);
Reporter.log("Items to be checked Manually", true);
Reporter.log("-----------------------------", true);
Reporter.log("Check Events Which are not  Expired  Should Be  In ACTIVE section", true);
Reporter.log("Check Events Wich Are Expired Should  Be In INACTIVE Section", true);
Reporter.log(" ", true);
	}
}

