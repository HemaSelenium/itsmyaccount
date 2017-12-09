package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
public class MemberSocietyInventory extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Member---->Application--->Society Inventory", true);	
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
@Test(priority=2)
public void MigratedItems() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnMigratedButton);
Thread.sleep(4000);
try{
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingButtonsInFooter)).findElement(By.tagName(VariableCalling2.VerifyingButtonsAreAvailableOrNot)).isDisplayed();
Reporter.log("Add ,Edit ,Delete Buttons Are Visible InMigrated Items", true);	
File MemberMigratedItems=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberMigratedItems, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberMigratedItems.png"));
}catch( NoSuchElementException ignored){
Reporter.log("Add,Edit,Delete  Buttons Are Not Visible In Migrated items", true);		
File MemberMigratedItems=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberMigratedItems, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberMigratedItems.png"));
}	}
@Test(priority=3)
public void Reciepts() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnBackToInventoryButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnRecieptsButton);
Thread.sleep(4000);
try{
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingButtonsInFooter)).findElement(By.tagName(VariableCalling2.VerifyingButtonsAreAvailableOrNot)).isDisplayed();
Reporter.log("Add ,Edit ,Delete Buttons Are Visible In Receipts", true);	
File MemberReciepts=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberReciepts, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberReciepts.png"));
}
catch( NoSuchElementException ignored){
Reporter.log("Add,Edit,Delete  Buttons Are Not Visible In Receipts", true);		
File MemberReciepts=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberReciepts, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberReciepts.png"));
}
}
@Test(priority=4)
public void Issues() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling2.ClickOnBackToInventoryButton);
Thread.sleep(4000);	
helper.ClickByXpath(VariableCalling2.ClickonIssuesButton);
Thread.sleep(4000);
try{
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.FindingButtonsInFooter)).findElement(By.tagName(VariableCalling2.VerifyingButtonsAreAvailableOrNot)).isDisplayed();
Reporter.log("Add ,Edit ,Delete Buttons Are Visible In Issues", true);	
}
catch( NoSuchElementException ignored){
Reporter.log("Add,Edit,Delete  Buttons Are Not Visible In Issues", true);		
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling2.ClickOnBackToInventoryButton);
Thread.sleep(4000);	
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInSocietyInventory);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnPdfButtonInSocietyInVentory);
Thread.sleep(4000);
Reporter.log("List In Inventory Page Exported To PDF", true);	
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberSocietyInventoryPDF.png"));
}	}
@Test(priority=5)
public void LoginAgain()throws Exception{
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
}@Test(priority=6)
public void SocietyInventoryReports() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnReportButton);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButtonInReports);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInReports);
Thread.sleep(4000);
Reporter.log("All Inventory Reports Exported To Pdf", true);	
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberSocietyInventoryReports.png"));
}
@Test(priority=7)
public void LoginToGetSelectedItemsReports()throws Exception{
helper.Navigate(GlobalVariablesCalling.EnterUrl);
Thread.sleep(4000);
helper.SetValue1("UserName",GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
Thread.sleep(4000);
}
@Test(priority=8,dataProvider="ReportsInSocietyInventory",dataProviderClass= Dataproviders.class)
public void GetreportOfGivenItem(String EnterItemCategory,String EnterItemName)throws Exception{  
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnReportButton);
Thread.sleep(4000);
helper.SetValueByID("ItemCategory", EnterItemCategory);
Thread.sleep(4000);
helper.SetValueByID("ItemName", EnterItemName);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButtonInReports);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInReports);
Thread.sleep(4000);
Reporter.log("Searched Item Reports Exported To Pdf", true);	
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberSocietyInventoryReportOfGivenItem.png"));
}	
@Test(priority=9)
public void Results(){
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberMigratedItems.png" + " MemberMigratedItems", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberReciepts.png" + "  MemberReciepts", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberSocietyInventoryPDF.png" + "  MemberSocietyInventoryPDF", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberSocietyInventoryReportOfGivenItem.png" + "  MemberSocietyInventoryReportOfGivenItem", true);	
Reporter.log(" ", true);
}






}
