package dashboard;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class MemberSocietyAssests extends TestBase{
@Test(priority=1)
public void Login()throws Exception {
Reporter.log("Script Name:Member---->Application--->Society Assets", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
}
@Test(priority=2)
public void MemberAssests()throws Exception {
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();	
helper.ClickByXpath(VariableCalling2.ClickOnSocietyAssetsButton);
Thread.sleep(4000);
Reporter.log("Society Assets Are Only Able To View", true);	
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling2.SelectAssetNameInSearchFunction);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.SelectIsNotNullOptionInSearch);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
File AssetListAfterDeletedAddedAsset=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AssetListAfterDeletedAddedAsset, new File(GlobalVariablesCalling.ScreenShotsFileName+"SearchAssetNameWithNotNullFunctionInMemberAsset.png"));
helper.ClickByXpath(VariableCalling.ClickExportButton);
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickPdfButton);
Thread.sleep(3000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"MemberAssets.png"));
}

@Test(priority=3)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"SearchAssetNameWithNotNullFunctionInMemberAsset.png" + " SearchAssetNameWithNotNullFunctionInMemberAsset", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"MemberAssets.png" + "  MemberAssets", true);	
Reporter.log(" ", true);
}
}
