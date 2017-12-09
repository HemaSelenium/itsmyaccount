package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberPostagecourierregistor extends TestBase{
@Test(priority=1)
public void PostageAndCourier()throws Exception{
Reporter.log("Script Name:Member---->Application--->PostageAndCourier", true);	
Reporter.log("----------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
}
@Test(priority=2)
public void DataInPostageAndCourierList()throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnPostageANdCourierRegistorButton);
Thread.sleep(4000);
Reporter.log("Data In Postage/courier Register Able To View", true);
File MemberPostageAndCourier=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(MemberPostageAndCourier, new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberPostageAndCourier.png"));
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.EnterBlockNameToSearch);
Thread.sleep(4000);
helper.SetValueByXpath(VariableCalling. EnterDataToSearchInRegularVendors, GlobalVariablesCalling.EnterMemberBlockName);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
File SearchMemberBlockNameDataInCouriers=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(SearchMemberBlockNameDataInCouriers, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchMemberBlockNameDataInCouriers.png"));

WebElement PostageAndCourier=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsOfPostageAndCourier=PostageAndCourier.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>BlockName=new ArrayList<String>();
for(int Rows=1;Rows<RowsOfPostageAndCourier.size();Rows++){
List<WebElement>ColoumnsOfPostageAndCourier=RowsOfPostageAndCourier.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
BlockName.add(ColoumnsOfPostageAndCourier.get(4).getText());
}
if(BlockName.contains(GlobalVariablesCalling.EnterMemberBlockName)){
	Reporter.log("Search function Working With Block Name With Equal Functionality", true);	
}
else{
	Reporter.log("Search Not Working With Block Name With Equal Functionality OR No data Available with Searched Block", true);	
}


}
@Test(priority=3)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInPostageAndCourier);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInPostageAndCourier);
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberPostageAndCourier.png"));
	}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberPostageAndCourier.png" + "  MemberPostageAndCourier", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchMemberBlockNameDataInCouriers.png" + "  SearchMemberBlockNameDataInCouriers", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberPostageAndCourier.png" + "  MemberPostageAndCourier", true);
Reporter.log(" ", true);
}
}
