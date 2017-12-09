package dashboard;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSocietyInventoryInchargeDetails extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->SocietyInventory---->InchargeDetails", true);	
Reporter.log("--------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
Thread.sleep(3000);
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
} 
@Test(priority=2,dataProvider="Inchargedetails",dataProviderClass= Dataproviders.class)
public void EditInchargeDetails(String EnterInchargePersonname) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnInchargeDetailsButton);	
Thread.sleep(3000);

File InchargeDetailsBeforeEditing=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(InchargeDetailsBeforeEditing, new File(GlobalVariablesCalling.ScreenShotsFileName+"InchargeDetailsBeforeEditing.png"));


String InchargePerson=SeleniumHelper.driver.findElement(By.id(VariableCalling2.NameOfInChargePerson)).getAttribute("value");

Thread.sleep(3000);
Reporter.log("Incharge Person name BeforeEditing: "+InchargePerson, true);
Thread.sleep(3000);
helper.ClearElementById(VariableCalling2.NameOfInChargePerson);
Thread.sleep(3000);
helper.SetValueByID(VariableCalling2.NameOfInChargePerson, EnterInchargePersonname);
Thread.sleep(3000);
helper.ClickByID(VariableCalling2.ClickonSaveButtonInInchargeDetails);
Thread.sleep(3000);
helper.ClickByID(VariableCalling2.ClickOnInchargeDetailsButton);
Thread.sleep(3000);
String InchargePersonName= SeleniumHelper.driver.findElement(By.id(VariableCalling2.NameOfInChargePerson)).getAttribute("value");
Thread.sleep(2000);
Reporter.log("Incharge Person name After Editing: "+InchargePersonName, true);
Thread.sleep(2000);
File InchargeDetailsAfterEditing=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(InchargeDetailsAfterEditing, new File(GlobalVariablesCalling.ScreenShotsFileName+"InchargeDetailsAfterEditing.png"));	
}

@Test(priority=3)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"InchargeDetailsBeforeEditing.png" + "  InchargeDetailsBeforeEditing", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"InchargeDetailsAfterEditing.png" + "  InchargeDetailsAfterEditing", true);
Reporter.log(" ", true);
}	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
