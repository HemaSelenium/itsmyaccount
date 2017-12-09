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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSocietyinventoryissues extends TestBase{
	public String EnterItemName;
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->SocietyInventory---->Issues", true);	
Reporter.log("----------------------------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
} 
@Test(priority=2,dataProvider="Issues",dataProviderClass= Dataproviders.class)
public void SocietyInventoryIssues(String EnterItemCategory,String EnterItemName,String EnterItemQuantity,String EnterIssueissuedToWhome,String EnterIssueApprovedByWhome,String EnterRecieverNumber,String EnterItemNameToSearch,String EnterItemNameToVerify,String EnterItemQuantityToEdit,String EnterItemNameToSearchAfterEdit,String EnterQuantityOfItemToVerifyAfterEdit,String EnterItemNameToSearchAgain,String EnterItemNameToVerifyInInventoryPage,String VerifyingItemQuNtity) throws InterruptedException, IOException{
EnterItemName=EnterItemNameToSearchAgain;
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickonIssuesButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("ItemCategory",EnterItemCategory);
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("ItemCategory")).sendKeys(Keys.TAB);
helper.Sleep();
helper.SetValueByID("ItemName",EnterItemName);
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("ItemName")).sendKeys(Keys.TAB);
helper.Sleep();
helper.SetValueByID("Quantity", EnterItemQuantity);
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("Quantity")).sendKeys(Keys.TAB);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterIssueIssuedToWhome, EnterIssueissuedToWhome);
helper.SetValueByID(VariableCalling2.EnterIssueApprovedByWhome, EnterIssueApprovedByWhome);
helper.SetValueByID("ReceiverNo", EnterRecieverNumber);
helper.ClickByXpath(VariableCalling2.ClickOnBlockDropDownList);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnApartmentNumbersDropDownList);
helper.Sleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInIssues);
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
for(int ItemNames=1;ItemNames<tableRows1.size();ItemNames++){
List<WebElement> tablecoloumns = tableRows1.get(ItemNames).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(tablecoloumns.get(3).getText().equals(EnterItemNameToVerify)){
if(tablecoloumns.get(9).getText().equals(MethodsCalling.CurrentDate()))	{
	
	
Reporter.log("Issues Added Sucessfully", true);	
Reporter.log("Issue Is Added With Quantity :"+tablecoloumns.get(4).getText(), true);	
File AddedIssues=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedIssues, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedIssues.png"));
tablecoloumns.get(9).click();
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
SeleniumHelper.driver.findElement(By.id("ItemCategory")).sendKeys(Keys.TAB);
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("ItemCategory")).sendKeys(Keys.TAB);
helper.Sleep();
helper.ClearElementById("Quantity");
helper.Sleep();
helper.SetValueByID("Quantity", EnterItemQuantityToEdit);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInIssues);
helper.Sleep();
Method3.checkAlert();
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
if(coloumns.get(4).getText().equals(EnterQuantityOfItemToVerifyAfterEdit))
{
Reporter.log("issues Item Edited Sucessfully", true);	
Reporter.log("Issues Quantity Edited As :"+coloumns.get(4).getText(), true);	
File EditedIssues=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedIssues, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedIssues.png"));
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
try{
List<WebElement> Rows1 = values.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> coloumns1 = Rows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns1.get(2).getText().contains(EnterItemNameToVerifyInInventoryPage))
{
if(coloumns1.get(3).getText().contains(VerifyingItemQuNtity))
{
Reporter.log("Closing Balance Is : "+coloumns1.get(3).getText(), true);	
File ClosingBalanceOfAddedIssueInInventory=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ClosingBalanceOfAddedIssueInInventory, new File(GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceOfAddedIssueInInventory.png"));	
}
else{
Reporter.log(" Issue Of Item Unable to Found In Inventory ", true);	
}
}else{
Reporter.log(" Issue Of Item Unable to Found In Inventory ", true);	
}}
catch(NoSuchElementException e){
Reporter.log("Search Not Working In Inventory Items Page ", true);	
}}else{
Reporter.log("Unable To Edit Issues Quantity ", true);	
File UnableToEditIssues=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(UnableToEditIssues, new File(GlobalVariablesCalling.ScreenShotsFileName+"UnableToEditIssues.png"));	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"UnableToEditIssues.png" + "  Unable To EditedIssues", true);	

helper.ClickByXpath(VariableCalling2.ClickOnBackToInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectItemNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterItemName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement values=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
try{
List<WebElement> Rows1 = values.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> coloumns1 = Rows1.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns1.get(2).getText().contains(EnterItemName))
{

Reporter.log("Closing Balance Is : "+coloumns1.get(3).getText(), true);	
File ClosingBalanceOfAddedIssueInInventory=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ClosingBalanceOfAddedIssueInInventory, new File(GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceOfAddedIssueInInventory.png"));	
}
else{
Reporter.log(" Issue Of Item Unable to Found In Inventory ", true);	
}}
catch(NoSuchElementException e){
Reporter.log("Search Not Working In Inventory Items Page ", true);	
}



}
	}
else{
Reporter.log("Search Function With ItemName Not working After Edit Or Page Loading issue", true);	
}	}
else{
Reporter.log("Issue Unable To Add", true);	
	}
break;}else{
}}
}
else{
Reporter.log("Search Function With ItemName Not working (Or ) Added Issue Unable To Save ", true);	
}}	
@Test(priority=3)
public void Export()throws Exception{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();	
helper.ClickByXpath(VariableCalling2.ClickOnSocietyInventoryButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickonIssuesButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInIssues);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInIssues);
helper.DeepSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminIssuesPdf.png"));
}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedIssues.png" + "  AddedIssues", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedIssues.png" + "  EditedIssues", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ClosingBalanceOfAddedIssueInInventory.png" + "  ClosingBalanceOfAddedIssueInInventory", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminIssuesPdf.png" + "  AdminIssuesPdf", true);	
Reporter.log(" ", true);	
}}			
			
			
			
			
			
			
			
			
			
			
			
			
			
		


