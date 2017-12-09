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
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberPdc extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Member---->Application--->MyAccount--->Post Dated Cheques", true);	
Reporter.log("--------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
}@Test(priority=2)
public void MemberPdcInMyAccount() throws InterruptedException, HeadlessException, IOException, AWTException{
helper.ClickByXpath(VariableCalling2.ClickOnPdcInMyAccount);
helper.DeepSleep();
helper.TakeScreenShot("Member PDC List");
WebElement PdcList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<String>BlockNames=new ArrayList<String>();
List<WebElement> RowsInPDCList = PdcList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
try{
	
for(int i=0;i<RowsInPDCList.size();i++){
List<WebElement> ColoumnsInPDCList = RowsInPDCList.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
BlockNames.add(ColoumnsInPDCList.get(3).getText());
}
if(BlockNames.contains(GlobalVariablesCalling.EnterMemberBlockName)){
Reporter.log("Data Related Searched Block Name Are Displyed ", true);
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInMyPDc);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnPDFButtonInMyPdc);
helper.MaxSleep();
Reporter.log("Data Exported To PDF", true);
helper.TakeScreenShotOfExportPDF("Pdf Of Member PDC");
}
else{
Reporter.log("Other Block Details also  Displyed ", true);	
}}
catch(IndexOutOfBoundsException e){
Reporter.log("No data available in screen ", true);	
	
}
}
@Test(priority=3,dependsOnMethods="MemberPdcInMyAccount")
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Member PDC List" + "  AddedPDC", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Pdf Of Member PDC" + "  EnchasedDateUnableToSave", true);
Reporter.log(" ", true);
	
}






}
