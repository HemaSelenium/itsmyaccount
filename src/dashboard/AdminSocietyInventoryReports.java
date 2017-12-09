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

import org.testng.Reporter;
import org.testng.annotations.Test;
import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSocietyInventoryReports extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->SocietyInventory---->Reports", true);	
Reporter.log("------------------------------------------------------------------", true);	
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
@Test(priority=2)
public void SocietyInventoryReports() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnReportButton);
Thread.sleep(4000);
helper.ClickByID(VariableCalling2.ClickOnGetDetailsButtonInReports);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInReports);
Thread.sleep(4000);
Reporter.log(" All Inventory Reports Exported To Pdf", true);
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminSocietyInventoryReportPdf.png"));
} 
 @Test(priority=3)
public void LoginAgain()throws Exception{
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
@Test(priority=4,dataProvider="ReportsInSocietyInventory",dataProviderClass= Dataproviders.class)
public void GetreportOfPerticularItem(String EnterItemCategory,String EnterItemName)throws Exception{  
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
Reporter.log(" Reports Of Searched Items Exported To Pdf", true);	
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminReportOfGivenItemNamePdf.png"));
}
@Test(priority=5)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminSocietyInventoryReportPdf.png" + "  Admin Society Inventory Report Pdf", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminReportOfGivenItemNamePdf.png" + "  Admin Report Of Given ItemName Pdf", true);	
Reporter.log(" ", true);	
}












}
