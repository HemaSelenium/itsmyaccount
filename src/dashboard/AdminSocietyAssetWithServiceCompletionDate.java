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
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
 
public class AdminSocietyAssetWithServiceCompletionDate extends TestBase{
	public String Assetname;
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
}
@Test(priority=2,dataProvider="RenewAmcWithServiceCompletion",dataProviderClass= Dataproviders.class)
public void AddAssestForFillinfServiceCompletionDate(String EnterAssetCategory,String EnterAssetName,String EnterAssetTag,String EnterPurchasedPrice,String EnterPurchasedFrom,String EnterAssertLocation,String SelectDocumentToAttach,String EnterAssetNameToSearch,String VerifyingAssetNameAfterSearch,String EnterVendorNameInAmcDetails,String EnterAddressInAmcDetails,String EnterContact1InAmcDetails,String EnterContact2InAmcDetails,String EnterEndDateToRenewAmc,String SelectFrequencyType,String EnterNumberOfDaysSmsReminderBefore,String EnterAddedAssetNameToSearch,String EnterAssetNameToSearchInAmcDetails,String SearchForAsetAfterGivenServiceCompletionDate,String EnterDeletedAssetName) throws InterruptedException, IOException, HeadlessException, AWTException{
Assetname=EnterAssetName;
	helper.ClickByXpath(VariableCalling2.ClickOnSocietyAssetsButton);
helper.DeepSleep();
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
WebElement AssetList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));

if (AssetList.getSize()!=null) {
List<WebElement> AssetRows = AssetList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement> AssetColoumns = AssetRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(AssetColoumns.get(3).getText().contains(VerifyingAssetNameAfterSearch))
{
Reporter.log("Asset Is Added Sucessfully", true);	
helper.Sleep();
File AddedAssetWithServiceCompletionDate=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedAssetWithServiceCompletionDate, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedAssetWithServiceCompletionDate.png"));
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID(VariableCalling2.ClickOnRenewAmcButton);	
helper.SetValueByID("VendorName", EnterVendorNameInAmcDetails);
helper.SetValueByID("Address", EnterAddressInAmcDetails);
helper.SetValueByID("Contact1", EnterContact1InAmcDetails);
helper.SetValueByID("Contact2", EnterContact2InAmcDetails);
SeleniumHelper.driver.findElement(By.id("EndDate")).clear();
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("EndDate")).sendKeys(EnterEndDateToRenewAmc);
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("EndDate")).sendKeys(Keys.TAB);
helper.Sleep();
Select selectByVisibleText = new Select (SeleniumHelper.driver.findElement(By.id(VariableCalling2.ClickOnFrequencyTypesDropDownListButton)));
helper.Sleep();;
selectByVisibleText.selectByVisibleText(SelectFrequencyType);
helper.Sleep();
helper.SetValueByID("SMSBefore", EnterNumberOfDaysSmsReminderBefore);
helper.ClickByXpath(VariableCalling2.ClickOnRenewButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.ClickOnAmcDetailsButton);
helper.DeepSleep();
WebElement Tablevalues=SeleniumHelper.driver.findElement(By.tagName("table")).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));	
helper.Sleep();
List<String>Asset=new ArrayList<String>();
List<WebElement> tableRows1 = Tablevalues.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
 for(int i=0;i<tableRows1.size();i++){
List<WebElement> tablecoloumns = tableRows1.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Asset.add(tablecoloumns.get(2).getText());

}


if(Asset.contains(EnterAssetName)){
Reporter.log("Renewd Asset Found In Amc Details List", true);
for(int j=0;j<tableRows1.size();j++){
List<WebElement>coloumns=tableRows1.get(j).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns.get(2).getText().equals(Assetname)){
coloumns.get(13).findElement(By.tagName("input")).sendKeys(MethodsCalling.CurrentDate());
coloumns.get(13).findElement(By.tagName("input")).sendKeys(Keys.TAB);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonAfterEnterServiceCompletionDate);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.ClickOnAmcDetailsButtonInApplication);
helper.DeepSleep();
WebElement AmcDetails=SeleniumHelper.driver.findElement(By.tagName("table")).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));	
List<WebElement> RowsInAmcDetails = AmcDetails.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int Amc=0;Amc<RowsInAmcDetails.size();Amc++){
List<WebElement> ColoumnsInAmcDetails = RowsInAmcDetails.get(Amc).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsInAmcDetails.get(2).getText().contains(EnterAssetNameToSearchInAmcDetails)){
String ServiceCompletionDate=ColoumnsInAmcDetails.get(13).findElement(By.tagName("input")).getAttribute("value");
Reporter.log("ServiceCompletionDate:"+ServiceCompletionDate, true);	
if(ServiceCompletionDate!=null){
Reporter.log("Entered Service Completion Date Saved Sucessfully", true);	
File AmcdetailsOfAssetAfterFillServiceCompletionDate=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AmcdetailsOfAssetAfterFillServiceCompletionDate, new File(GlobalVariablesCalling.ScreenShotsFileName+"AmcdetailsOfAssetAfterFillServiceCompletionDate.png"));
helper.ClickByXpath(VariableCalling2.ClickOnBackToAssetButton);	
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling2.SelectAssetNameInSearchFunction);
helper.Sleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, SearchForAsetAfterGivenServiceCompletionDate);
helper.Sleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.Sleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.Sleep();
WebElement ListOfAssets=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));	
if (ListOfAssets.getSize()!=null) {
helper.ClickByID(VariableCalling.SelectRow);
helper.Sleep();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.Sleep();
helper.ProcessAlert();
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
WebElement SocietyAssetList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsInSocietyAssets= SocietyAssetList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String> list = new ArrayList<String>();
for(int k=0;k<RowsInSocietyAssets.size();k++){
List<WebElement>AssetNameList= RowsInSocietyAssets.get(k).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
list.add(AssetNameList.get(2).getText());
}if(list.contains(EnterDeletedAssetName)){
Reporter.log(" Asset Unable To Deleted  ", true);	
}else{
Reporter.log(" Asset  Deleted Sucessfully ", true);
}}
else{
Reporter.log("Asset Not Found In Society List After saved ServiceCompletion Date", true);	
}	}
else{
Reporter.log("Given Service Completion Date Unable To Saved", true);	
}break;	
}}
break;}}}
else{
	Reporter.log("Renewd Asset Not Found In Amc Details List", true);	
}}
else{
Reporter.log("Asset Unable To Add", true);	
}	}else{
Reporter.log("Asset Unable To Add / Search With Asset name Not working", true);	
}
helper.ClickByXpath(VariableCalling.ClickExportButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickPdfButton);
helper.DeepSleep();
Reporter.log("Data Exported To Pdf Sucessfully", true);	
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminAssetsWithServiceCompletionDatePdf.png"));
}
@Test(priority=3)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedAssetWithServiceCompletionDate.png" + "  AddedAssetWithServiceCompletionDate", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AmcdetailsOfAssetAfterFillServiceCompletionDate.png" + "  AmcdetailsOfAssetAfterFillServiceCompletionDate", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminAssetsWithServiceCompletionDatePdf.png" + "  AdminAssetsWithServiceCompletionDatePdf", true);	
Reporter.log(" ", true);	

}

}

