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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.Dataproviders;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSocietyassestsWithoutServiceCompletionDate extends TestBase {
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->SocietyAssets", true);	
Reporter.log("----------------------------------------------", true);
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
helper.ClickByXpath(VariableCalling2.ClickOnSocietyAssetsButton);
helper.DeepSleep();
}
@Test(priority=2,dataProvider="SocietyAssets",dataProviderClass= Dataproviders.class)
public void AddEditDeleteAssest(String EnterAssetCategory,String EnterAssetName,String EnterAssetTag,String EnterPurchasedPrice,String EnterPurchasedFrom,String EnterAssertLocation,String SelectDocumentToAttach,String EnterAssetNameToSearch,String VerifyingAssetNameAfterSearch,String  EnterPurchaseLocationToEdit,String EnterAssetNameToSearchAfterEdit,String SearchForLocationAfterEdit,String EnterVendorNameInAmcDetails,String EnterAddressInAmcDetails,String EnterContact1InAmcDetails,String EnterContact2InAmcDetails,String EnterEndDateOfAssetToRenew,String SelectFrequencyType,String EnterNumberOfDaysSmsReminderBefore,String EnterAssetNameToSearchAfterRenew,String EnterAddedAssetName,String EnterDeletedAssetName ) throws InterruptedException, IOException{
boolean contains=true;
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("AssetCategory", EnterAssetCategory);
helper.SetValueByID("AssetName", EnterAssetName);
helper.SetValueByID("AssetTag", EnterAssetTag);
helper.SetValueByID("Price", EnterPurchasedPrice);
helper.SetValueByID("PurchasedFrom", EnterPurchasedFrom);
helper.SetValueByID("AssetLocation", EnterAssertLocation);
SeleniumHelper.driver.findElement(By.name("file_upload")).sendKeys(SelectDocumentToAttach);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnSave);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectAssetNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterAssetNameToSearch);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement Assets=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
if (Assets.getSize()!=null) {
List<WebElement> RowsInAssets = Assets.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> ColoumnsInAssets = RowsInAssets.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsInAssets.get(3).getText().contains(VerifyingAssetNameAfterSearch))
{
Reporter.log("Asset Is Added Sucessfully", true);
helper.Sleep();
Reporter.log("Asset Location Before Edit Is: "+ColoumnsInAssets.get(9).getText(), true);
File AddedAssetWithoutServiceCompletionDate=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedAssetWithoutServiceCompletionDate, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedAsset.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnEditButton);
helper.DeepSleep();
helper.SetValueByID("AssetLocation", EnterPurchaseLocationToEdit);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnSave);
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.SelectAssetNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterAssetNameToSearchAfterEdit);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.DeepSleep();
WebElement AssetList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.Sleep();
if (AssetList.getSize()!=null) {
List<WebElement> RowsOfAssets = AssetList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> ColoumnsOfAssets = RowsOfAssets.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Reporter.log("Asset Location After Edit Is : "+ColoumnsOfAssets.get(9).getText(), true);
if(ColoumnsOfAssets.get(9).getText().contains(SearchForLocationAfterEdit))
{
Reporter.log("Asset Location Details Edited Sucessfully", true);
File EditedAssetWithoutServiceCompletionDate=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(EditedAssetWithoutServiceCompletionDate, new File(GlobalVariablesCalling.ScreenShotsFileName+"EditedAsset.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnRenewAmcButton);	
helper.DeepSleep();
helper.SetValueByID("VendorName", EnterVendorNameInAmcDetails);
helper.SetValueByID("Address", EnterAddressInAmcDetails);
helper.SetValueByID("Contact1", EnterContact1InAmcDetails);
helper.SetValueByID("Contact2", EnterContact2InAmcDetails);
SeleniumHelper.driver.findElement(By.id("EndDate")).clear();
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("EndDate")).sendKeys(EnterEndDateOfAssetToRenew);
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("EndDate")).sendKeys(Keys.TAB);
helper.Sleep();
Select selectByVisibleText = new Select (SeleniumHelper.driver.findElement(By.id(VariableCalling2.ClickOnFrequencyTypesDropDownListButton)));
helper.Sleep();
selectByVisibleText.selectByVisibleText(SelectFrequencyType);
helper.Sleep();
helper.SetValueByID("SMSBefore", EnterNumberOfDaysSmsReminderBefore);
helper.Sleep();
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnRenewButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnAmcDetailsButton);
helper.DeepSleep();
WebElement AmcDetailsList=SeleniumHelper.driver.findElement(By.tagName("table")).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));	
helper.Sleep();
List<WebElement> RowsOfAmcList = AmcDetailsList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
lable: for(int i=0;i<RowsOfAmcList.size();i++){
List<WebElement> ColoumnsOfAmcList = RowsOfAmcList.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(ColoumnsOfAmcList.get(2).getText().equals(EnterAssetNameToSearchAfterRenew)){
Reporter.log("servicecompletion date: "+ColoumnsOfAmcList.get(13).getText(), true);
if(ColoumnsOfAmcList.get(13).getText().equals("")){
helper.Sleep();
File AmcDetailsOfAddedAsset=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AmcDetailsOfAddedAsset, new File(GlobalVariablesCalling.ScreenShotsFileName+"AmcDetailsOfAddedAsset.png"));
Reporter.log("Asset Has No service completion Date", true);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnBackToAssetButton);	
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectAssetNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterAddedAssetName);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement TableList1=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
if (TableList1.getSize()!=null) {
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.Sleep();
helper.ProcessAlert();
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement TableList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows= TableList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String> list = new ArrayList<String>();
for(int k=0;k<Rows.size();k++){
List<WebElement>AssetNameList= Rows.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
list.add(AssetNameList.get(2).getText());

if(list.contains(EnterDeletedAssetName)){
Reporter.log(" Asset Not Deleted ", true);
}}
if(list.contains(EnterDeletedAssetName)){
helper.Sleep();
Reporter.log("Asset Unable to delete", true);
}
else{
helper.Sleep();
Reporter.log(" Asset Deleted Sucessfully ", true);
File AssetListAfterDeletedAddedAsset=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AssetListAfterDeletedAddedAsset, new File(GlobalVariablesCalling.ScreenShotsFileName+"AssetListAfterDeletedAddedAsset.png"));

}	
break lable;
}			}}}		
			
				}
			}
			
else{
Reporter.log("Asset  Notfound InList", true);
}
		}
		}
else{
Reporter.log("Asset Is Not Added Sucessfully", true);
		    
			}
	}
@Test(priority=3)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickExportButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickPdfButton);
helper.DeepSleep();
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminAssetsPdf.png"));

}

@Test(priority=4)
public void Results(){
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedAsset.png" + "  AddedAsset", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"EditedAsset.png" + "  EditedAsset", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AmcDetailsOfAddedAsset.png" + "  AmcDetailsOfAddedAsset", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AssetListAfterDeletedAddedAsset.png" + "  AssetListAfterDeletedAddedAsset", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminAssetsPdf.png" + "  AdminAssetsPdf", true);
Reporter.log(" ", true);

}}


