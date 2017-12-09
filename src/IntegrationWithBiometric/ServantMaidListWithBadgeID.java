package IntegrationWithBiometric;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
import common.variablecalling3;
public class ServantMaidListWithBadgeID extends TestBase{
public  String ServantName;
public  String BlockName=GlobalVariablesCalling.EnterMemberBlockName;
public  String ApartmentNumber=GlobalVariablesCalling.EnterMemberApartmentNumber;
public  String BlockName2=GlobalVariablesCalling.BlockNameOf2ndMember;
public  String ApartmentNumber2=GlobalVariablesCalling.ApartmentNumberOf2ndMember;
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->ServantMaid List with Badge Id With SMS Tick", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.Sleep();

}
@Test(priority=2,dataProvider="ServantMaidListWithBadgeID",dataProviderClass= DataProvider8.class)
public void AddRecord(String Servantname,String ContactNo,String Cost,String WorkType,String BadgeID,String Reference1,String Reference2,String Reference3) throws AWTException, InterruptedException, IOException{
Method8.AddServantDetails(Servantname, ContactNo, Cost, BlockName, ApartmentNumber, WorkType, BadgeID, Reference1, Reference2, Reference3);
helper.DeepSleep();

helper.TakeScreenShot("AddedservantRecordWithBadgeId");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedservantRecordWithBadgeId", true);

}
@Test(priority=3,dataProvider="EditServantMaidListWithBadgeID",dataProviderClass= DataProvider8.class)
public void EditRecordWithUploadImageOnLeftSideAndWebCamOnRightSide(String servantName) throws AWTException, InterruptedException, IOException{
ServantName=servantName;
	helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.WebCameImageOnLeftSide);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.TakeSnapShotOnLeftSide);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.UploadImageOnRightSide);
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
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
helper.DeepSleep();
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException ex){
}
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();		
WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int rows=1;rows<Rows.size();rows++){
List<WebElement>Coloumns=Rows.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(Coloumns.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(Coloumns.get(5).getText().equals(ServantName)){
Actions Act=new Actions(SeleniumHelper.driver);
Act.doubleClick(Coloumns.get(5)).build().perform();
helper.DeepSleep();
helper.TakeScreenShot("Edited Servant Record With Upload Image On Left Side And WebCam On RightSide");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Servant Record With Upload Image On Left Side And WebCam On RightSide", true);
helper.Sleep();
helper.RefreshPage();
helper.Sleep();
break;
}}}}
WebElement Table1=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows1=Table1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));	
for(int rows=1;rows<Rows1.size();rows++){
List<WebElement>coloumns=Rows1.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(coloumns.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(coloumns.get(5).getText().equals(ServantName)){
Actions Act=new Actions(SeleniumHelper.driver);
Act.doubleClick(coloumns.get(5)).build().perform();
helper.DeepSleep();
break;
}}}}}
@Test(priority=4,dataProvider="EditServantMaidListWithExistedBadgeID",dataProviderClass= DataProvider8.class,dependsOnMethods="EditRecordWithUploadImageOnLeftSideAndWebCamOnRightSide")
public void EditServantMaidListWithExistedBadgeID(String ExistedBadgeID) throws InterruptedException, IOException{
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.id("PassNo")).clear();
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("PassNo")).sendKeys(ExistedBadgeID);;
helper.Sleep();
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
helper.TakeScreenShot("Edited Servant Record With Existed Badge Id");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Servant Record With Existed Badge Id", true);

try{
helper.ProcessAlert();
}
catch(NoAlertPresentException ex){
Reporter.log("While Saving record with existed Badge Id Didn't  get any warning popup", true);
}
	
}
@Test(priority=5,dataProvider="ServantMaidListWithBadgeID",dataProviderClass= DataProvider8.class,dependsOnMethods="EditServantMaidListWithExistedBadgeID")
public void AddServantDetailsToanotherMember(String Servantname,String ContactNo,String Cost,String WorkType,String BadgeID,String Reference1,String Reference2,String Reference3) throws AWTException, InterruptedException{
Method8.AddServantDetails(Servantname, ContactNo, Cost, BlockName2, ApartmentNumber2, WorkType, BadgeID, Reference1, Reference2, Reference3);
helper.DeepSleep();

}
@Test(priority=6,dependsOnMethods="AddServantDetailsToanotherMember")
public void ManuallyNeedToBeCheck(){
Reporter.log("Swipe FP of 1003 servant for Entry", true);
Reporter.log("----------------------------------", true);
Reporter.log("1) SMS to reach to TWO apartment units members As ENTERED", true);
Reporter.log("2) Biometric screen to be updated with one record as INTime", true);
Reporter.log("3) Biometric screen to be updated as IN with intime", true);
Reporter.log("4) Bio-metric Summary listing tobe updated as 1/0", true);
Reporter.log("Swipe FP 1003 of servant for EXIT", true);
Reporter.log("----------------------------------", true);
Reporter.log("1) SMS to reach to TWO aparment unit member as LEFT", true);
Reporter.log("2) Biometric screen to be updated with one record with OUTTIME", true);
Reporter.log("3) Biometric screen to be update as OUT with out time", true);
Reporter.log("4) Bio-metric Summary listing to be uploaded as 1/1", true);


}










}
