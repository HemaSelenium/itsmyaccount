package dashboard;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSocietyinventoryMigratedItems extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->SocietyInventory---->MigratedItems", true);	
Reporter.log("------------------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
}
@Test(priority=2,dataProvider="MigratedItems",dataProviderClass= Dataproviders.class)
public void MigratedItems(String EnterIemCategory,String EnterItemName,String EnterQuantityOfItems,String EnterItemNameToSearch,String EnterItemNameToVerify,String EnterItemQuantityToEdit,String EnterItemNameToSearchAfterEdit,String EnterQuantityOfItemToVerifyAfterEdit,String EnterItemNameToSearchAgain,String EnterItemNameToVerifyInInventoryPage,String VerifyingItemQuNtity ) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnMigratedButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("ItemCategory", EnterIemCategory);
helper.SetValueByID("ItemName", EnterItemName);
helper.SetValueByID("Quantity", EnterQuantityOfItems);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInMigratedPage);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemNameToSearch);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement MigratedItems=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
if (MigratedItems.getSize()!=null) {
List<WebElement> RowsOfItems = MigratedItems.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> ColoumnsOfItems = RowsOfItems.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfItems.get(3).getText().contains(EnterItemNameToVerify))
{
Reporter.log("Migrated item Is Added Sucessfully", true);	
Reporter.log("Item Quantity Before Editing Is :"+ColoumnsOfItems.get(4).getText(), true);	
File AddedMigrateditems=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedMigrateditems, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedMigrateditems.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.SetValueByID("Quantity", EnterItemQuantityToEdit);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInMigratedPage);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemNameToSearchAfterEdit);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement AddedMigratedItems=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

if (AddedMigratedItems.getSize()!=null) {
List<WebElement>RowsOfMigratedItems = AddedMigratedItems.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));

List<WebElement> coloumns = RowsOfMigratedItems.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));

if(coloumns.get(4).getText().contains(EnterQuantityOfItemToVerifyAfterEdit))
{
Reporter.log("Added Item Edited Sucessfully", true);	
Reporter.log("Item Quantity Before Editing Is :"+coloumns.get(4).getText(), true);	
File EditedMigratedItemsDetails=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedMigratedItemsDetails, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedMigratedItemsDetails.png"));
helper.ClickByXpath(VariableCalling2.ClickOnBackToInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemNameToSearchAgain);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement InventoryItems=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

if (InventoryItems.getSize()!=null) {
List<WebElement> RowsOfInventoryItems = InventoryItems.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> coloumnsOfInventoryItems = RowsOfInventoryItems.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumnsOfInventoryItems.get(2).getText().contains(EnterItemNameToVerifyInInventoryPage))
{
if(coloumnsOfInventoryItems.get(3).getText().contains(VerifyingItemQuNtity))
{
Reporter.log("Closing Balance Is : "+coloumnsOfInventoryItems.get(3).getText(), true);	
File ClosingBalanceInInventory=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ClosingBalanceInInventory, new File(GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceInInventory.png"));

}}}}}}
else{
Reporter.log("Added Item Unable To Edited ", true);	
}}
else{
Reporter.log("Asset Is Not Added Sucessfully", true);	
}}
@Test(priority=3)
public void Export()throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnMigratedButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickExportButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickPdfButton);
helper.DeepSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminMigratedItemsPdf.png"));
}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedMigrateditems.png" + "  AddedMigrateditems", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedMigratedItemsDetails.png" + "  EditedMigratedItems", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceInInventory.png" + "  ClosingBalanceInInventory", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminMigratedItemsPdf.png" + "  AdminMigratedItemsPdf", true);	
Reporter.log(" ", true);	

}

}
