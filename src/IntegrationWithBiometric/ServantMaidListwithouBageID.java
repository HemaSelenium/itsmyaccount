package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
import common.variablecalling3;
public class ServantMaidListwithouBageID extends TestBase{
public String ServantName;
public String EditedContactNo;
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->Add/Edit/Delete servantMaid List withOut Badge Id", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
	}
@Test(priority=2,dataProvider="ServantMaidList",dataProviderClass= DataProvider8.class)
public void ServantDetails(String Servantname,String ContactNo,String Cost,String WorkType,String Reference1,String Reference2,String Reference3,String ContactNoToEdit) throws AWTException, InterruptedException, IOException{
ServantName=Servantname;
EditedContactNo=ContactNoToEdit;
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnServantMaidListButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("ServantName", ServantName);
helper.SetValueByID("Contact", ContactNo);
helper.Sleep();
helper.SetValueByID("Cost", Cost);
helper.ClickByXpath(variablecalling3.BlockDropDowninServantMaidList);
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.ApartmentNumberDropDownInServantMaidList);
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.DeepSleep();
WebElement TypesOfWork=SeleniumHelper.driver.findElement(By.xpath(variablecalling3.TypesOfworks));
List<WebElement> Types=TypesOfWork.findElements(By.tagName("div"));
for(int work=0;work<Types.size();work++){
String TypeOfWork=Types.get(work).findElement(By.tagName("input")).getAttribute("id");
if(TypeOfWork.equals(WorkType)){
Types.get(work).findElement(By.tagName("input")).click();
break;		
}
}
SeleniumHelper.driver.findElement(By.id("PassNo")).clear();
helper.Sleep();
helper.SetValueByID("Reference1", Reference1);
helper.SetValueByID("Reference2", Reference2);
helper.SetValueByID("Reference3", Reference3);
helper.ClickByXpath(VariableCalling2.UploadImage);
helper.Sleep();
helper.Sleep();
StringSelection stringSelection = new StringSelection(GlobalVariablesCalling.ImageToUpload);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_CONTROL);
helper.Sleep();
rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.WebCam);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.TakeSnapShot);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException ex){
}
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int rows=1;rows<Rows.size();rows++){
List<WebElement>Coloumns=Rows.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(Coloumns.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(Coloumns.get(5).getText().equals(ServantName)){
Reporter.log("Servant Details Added Sucessfully", true);
Coloumns.get(4).click();
helper.Sleep();
helper.TakeScreenShot("ServantDetailsWithoutBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ServantDetailsWithoutBadgeId", true);
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("Contact", ContactNoToEdit);
helper.Sleep();
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
helper.DeepSleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement Table1=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows1=Table1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int rows1=1;rows1<Rows1.size();rows1++){
List<WebElement>Coloumns1=Rows1.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns1.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(Coloumns1.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(Coloumns1.get(6).getText().equals(EditedContactNo)){
Coloumns1.get(6).click();
helper.TakeScreenShot("EditedServantDetailsWithoutBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedServantDetailsWithoutBadgeId", true);
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.DeepSleep();
try{
helper.DeepSleep();
helper.ProcessAlert();
}
catch(NoAlertPresentException e){
Reporter.log("Delete conformation popup didn't come", true);
}
List<String>ServantList=new ArrayList<String>();
WebElement Table2=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows2=Table2.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int rows2=1;rows2<Rows2.size();rows1++){
List<WebElement>Coloumns2=Rows2.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns2.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(Coloumns2.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
ServantList.add(Coloumns2.get(5).getText());
}}}
if(ServantList.contains(ServantName)){
Reporter.log("Servant Details Unable to delete", true);
}else{
Reporter.log("Servant Details Deleted Sucessfully", true);
}}
break;	
}}}	break;
}}}}}





















}
