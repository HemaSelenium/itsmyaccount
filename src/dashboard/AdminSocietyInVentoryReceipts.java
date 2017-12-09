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
public class AdminSocietyInVentoryReceipts extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->SocietyInventory---->Reciepts", true);
Reporter.log("--------------------------------------------------------------------", true);
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
@Test(priority=2,dataProvider="Reciepts",dataProviderClass= Dataproviders.class)
public void AddAndEditReciepts(String EnterIemCategory,String EnterItemName,String EnterQuantityOfItems,String EnterPurchasedFrom,String EnterValue,String EnterItemNameToSearch,String EnterItemCategoryToVerify,String EnterItemNameToVerify,String EnterItemQuantityToEdit,String EnterItemNameToSearchAfterEdit,String EnterQuantityOfItemToVerifyAfterEdit,String EnterItemNameToSearchAgain,String EnterItemNameToVerifyInInventoryPage,String VerifyingItemQuNtity) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnRecieptsButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("ItemCategory", EnterIemCategory);
helper.SetValueByID("ItemName", EnterItemName);
helper.SetValueByID("Quantity", EnterQuantityOfItems);
helper.SetValueByID(VariableCalling2.PurchasedFromLocation, EnterPurchasedFrom);
helper.SetValueByID(VariableCalling2.ValueLocation, EnterValue);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInReciepts);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemNameToSearch);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
if (Tablevalues.getSize()!=null) {
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> tablecoloumns = tableRows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(tablecoloumns.get(3).getText().equals(EnterItemCategoryToVerify)){
if(tablecoloumns.get(4).getText().contains(EnterItemNameToVerify))
{
Reporter.log("Reciept Added Sucessfully", true);
helper.Sleep();
Reporter.log("Recipt Is Added With Quantity :"+tablecoloumns.get(5).getText(), true);
File AddedReciepts=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedReciepts, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedReciepts.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID("Edit");
helper.DeepSleep();
helper.SetValueByID("Quantity", EnterItemQuantityToEdit);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInReciepts);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemNameToSearchAfterEdit);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
if (Table.getSize()!=null) {
List<WebElement> tableRows = Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> coloumns = tableRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns.get(5).getText().contains(EnterQuantityOfItemToVerifyAfterEdit))
{
Reporter.log("Added Item Edited Sucessfully", true);
Reporter.log("Reciept Quantity Edited As :"+coloumns.get(5).getText(), true);
File EditedRecieptDetails=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedRecieptDetails, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedRecieptDetails.png"));
helper.ClickByXpath(VariableCalling2.ClickOnBackToInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemNameToSearchAgain);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement values=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
if (values.getSize()!=null) {
List<WebElement> Rows1 = values.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> coloumns1 = Rows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns1.get(2).getText().contains(EnterItemNameToVerifyInInventoryPage))
{

if(coloumns1.get(3).getText().contains(VerifyingItemQuNtity))
{		
Reporter.log("Closing Balance Is : "+coloumns1.get(3).getText(), true);
File ClosingBalanceOfAddedReciepts=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ClosingBalanceOfAddedReciepts, new File(GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceOfAddedReciepts.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
}}}}}}
else{
Reporter.log("Added Reciept Unable To Edited ", true);
}}
else{
Reporter.log("Recipt Is Not Added Sucessfully", true);
}}else{
Reporter.log("Recipt Is Not Added Sucessfully", true);
}}
@Test(priority=3)
public void Export()throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnRecieptsButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInReciepts);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInReciepts);
helper.DeepSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminRecieptsPdf.png"));
}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedReciepts.png" + "  AddedReciepts", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedRecieptDetails.png" + "  EditedRecieptDetails", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceOfAddedReciepts.png" + "  ClosingBalanceOfAddedReciepts", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminRecieptsPdf.png" + "  AdminRecieptsPdf", true);
Reporter.log(" ", true);

}


}
