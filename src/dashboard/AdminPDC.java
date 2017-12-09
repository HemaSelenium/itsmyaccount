package dashboard;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProviders2;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminPDC extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->MyFinance--->Post Dated Cheques", true);	
Reporter.log("--------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
}	
@Test(priority=2,dataProvider="AdminPdc",dataProviderClass= DataProviders2.class)
public void AddPdc(String EnterChequeNumber,String EnterBankName,String EnterChequeDate,String EnterMonth,String EnterYear,String EnterAmount,String EnterDescription,String EnterNumberOfDaysRemindBeforeChequeDate,String EnterNumberOfDaysRemindAfterChequeDate,String EnterChequeNumberInSearch,String EnterAddedChequeNumberToVerify) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling2.ClickOnPdcButton);
helper.MaxSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);	
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClickOnDropDownListOfBlock)).click();
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClickOnDropDownListOfApartments)).click();
helper.MaxSleep();
SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
helper.MaxSleep();
helper.SetValueByID("Cheque_No", EnterChequeNumber);
helper.SetValueByID("BankName", EnterBankName);
helper.SetValueByID("Cheque_Date",EnterChequeDate);
helper.DeepSleep();
Select SelectMonth = new Select(SeleniumHelper.driver.findElement(By.id(VariableCalling2.ClickOnMonthsDropDownlistButton)));
helper.DeepSleep();
SelectMonth.selectByVisibleText(EnterMonth);
helper.DeepSleep();
Select SelectYear = new Select(SeleniumHelper.driver.findElement(By.id(VariableCalling2.ClickOnYearDropDownlistButton)));
helper.DeepSleep();
SelectYear.selectByVisibleText(EnterYear);
helper.DeepSleep();
helper.SetValueByID("Amount", EnterAmount);
helper.SetValueByID("Description", EnterDescription);
helper.SetValueByID("Reminder_Before", EnterNumberOfDaysRemindBeforeChequeDate);
helper.SetValueByID("Reminder_After", EnterNumberOfDaysRemindAfterChequeDate);
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInPdc);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectChequeNumberInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterChequeNumberInSearch);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement PdcList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> RowsInPDCList = PdcList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
try{
List<WebElement> ColoumnsInPDCList = RowsInPDCList.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
try{
if(ColoumnsInPDCList.get(7).getText().equals(EnterAddedChequeNumberToVerify)){
Reporter.log("Pdc Added Sucessfully", true);	
helper.TakeScreenShot("Added PDC");	
List<WebElement> ColoumnsOfFirstRowInPDCList = RowsInPDCList.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfFirstRowInPDCList.get(0).getText().equals("Overdue")){
Reporter.log("Added Pdc Is Under OverDue", true);	
ColoumnsInPDCList.get(7).click();
helper.DeepSleep();
}else{
if(ColoumnsOfFirstRowInPDCList.get(0).getText().equals("Notdue")){
Reporter.log("Added Pdc Is Under Notdue", true);	
ColoumnsInPDCList.get(7).click();
helper.DeepSleep();
}else{
Reporter.log("Added Pdc Is Not Under NotDue", true);	
}}}
}catch(NoSuchElementException Ignored){
Reporter.log("Unable To Select Added PDC", true);	
}}
catch(NoSuchElementException Ignored){
Reporter.log("Pdc Unable To Add Pdc /Search Pdc With Cheque Number Not Working ", true);	
}
}
@Test(priority=3,dataProvider="EditPdc",dataProviderClass= DataProviders2.class,dependsOnMethods="AddPdc")
public void EditPdc(String EnterEncashedDate,String EnterChequeNumberInSearch,String EnterEncahedDateToVerify,String EnterChequeDateToVerifyInDashBoardPDC) throws InterruptedException, IOException{
boolean Result=true;
String MemberDetails=GlobalVariablesCalling.EnterMemberBlockName+" - "+GlobalVariablesCalling.EnterMemberApartmentNumber+" : "+GlobalVariablesCalling.EnterMemberName;
helper.ClickByID(VariableCalling.ClickOnEditButton);	
helper.DeepSleep();
helper.SetValueByID("Encahsed_Date",EnterEncashedDate);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnSaveButtonInPdc);
helper.MaxSleep();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectChequeNumberInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterChequeNumberInSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement PdcListTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> RowsInPDCListTable = PdcListTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
try{
List<WebElement> ColoumnsInPDCListTable = RowsInPDCListTable.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(ColoumnsInPDCListTable.get(16).getText().equals(null)){
Reporter.log("Enchased Date Unable To Save", true);	
helper.TakeScreenShot("Enchased Date Unable To Save");
}
else{
if(ColoumnsInPDCListTable.get(16).getText().equals(EnterEncahedDateToVerify)){
helper.DeepSleep();
List<WebElement> FirstRowElementsInTable = RowsInPDCListTable.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(FirstRowElementsInTable.get(0).getText().equals("Encashed")){
Reporter.log("After Enchased Date Is Filled,  Pdc Is Now Under Enchased List", true);	
helper.TakeScreenShot("After Enchased Date Filled");
helper.ClickByXpath(VariableCalling2.ClickOnDasBoardButton);	
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnViewAllButtonInMyPDC);
helper.MaxSleep();
WebElement DasboardMyPdc=SeleniumHelper.driver.findElement(By.tagName("table"));
List<WebElement> DashBoardPdcList=DasboardMyPdc.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int List=1;List<DashBoardPdcList.size();List++){
List<WebElement> DashBoardPdc=DashBoardPdcList.get(List).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(DashBoardPdc.get(2).getText().equals(EnterChequeDateToVerifyInDashBoardPDC)){
Reporter.log("Member Details "+MemberDetails, true);	
if(DashBoardPdc.get(0).getText().equals(MemberDetails)){
Result=false;
break;	
}}}
if(Result){
Reporter.log("After Enchased Date Is Filled, Added Pdc Not Displaying In DasBorad Pdc List", true);	
helper.TakeScreenShot("DashBoard Pdc Afte rFilled Enchased Date");
}else{
Reporter.log("After Enchased Date Is Filled, Added Pdc Displaying In DasBorad Pdc List", true);	
helper.TakeScreenShot("DashBoard PDC After Filled Enchased Date");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"DashBoardPDCcAfterFilledEnchasedDate" + "  DashBoardPDCcAfterFilledEnchasedDate ", true);
}}
else{
Reporter.log("AfterFilling Enchased Date,  Pdc Is Now Under :" +FirstRowElementsInTable.get(0).getText(), true);	
}}else{
Reporter.log("Given Enchased Date is Not Updated", true);	
}}}
catch(NoSuchElementException Ignored){
Reporter.log("Search Working Fails With Cheque Number After Edit", true);	
}}
@Test(priority=4,dataProvider="DeletePdc",dataProviderClass= DataProviders2.class,dependsOnMethods="EditPdc")
public void DeletePDC(String EnterChequeNumberInSearch,String EnterAddedChequeNumberToVerify,String SearchCheckNumberAfterDelete) throws InterruptedException{
SeleniumHelper.driver.navigate().refresh();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnPdcButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectChequeNumberInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, EnterChequeNumberInSearch);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement PdcListTable=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> RowsInPDCListTable = PdcListTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
List<WebElement> ColoumnsInPDCListTable = RowsInPDCListTable.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.Sleep();
if(ColoumnsInPDCListTable.get(7).getText().equals(EnterAddedChequeNumberToVerify)){
ColoumnsInPDCListTable.get(7).click();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
helper.MaxSleep();
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectChequeNumberInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, SearchCheckNumberAfterDelete);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement PdcListTableAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> RowsInPDCListTableAfterDelete = PdcListTableAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
try{
List<WebElement> ColoumnsInPDCListTableAfterDelete=RowsInPDCListTableAfterDelete.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
Reporter.log(" Pdc Unable To Delete", true);
}catch(IndexOutOfBoundsException Ignore){
helper.MaxSleep();
Reporter.log("Pdc Deleted Sucessfully",true);
}}catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.SelectChequeNumberInSearchFunction);
helper.MaxSleep();
helper.SetValueByID(VariableCalling2.EnterDataToSearchInAssets, SearchCheckNumberAfterDelete);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
helper.MaxSleep();
WebElement PdcListTableAfterDelete=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> RowsInPDCListTableAfterDelete = PdcListTableAfterDelete.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.DeepSleep();
try{
List<WebElement> ColoumnsInPDCListTableAfterDelete=RowsInPDCListTableAfterDelete.get(2).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();
Reporter.log(" Pdc Unable To Delete", true);
}catch(IndexOutOfBoundsException Ignore){
helper.MaxSleep();
Reporter.log("Pdc Deleted Sucessfully", true);
}}}}
@Test(priority=5,dependsOnMethods="DeletePDC")
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
SeleniumHelper.driver.navigate().refresh();
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnExportButtonInMyPDc);
helper.MaxSleep();
helper.ClickByXpath(VariableCalling2.ClickOnPDFButtonInMyPdc);
helper.MaxSleep();
Reporter.log("Pdc List data Exported To PDF", true);
helper.TakeScreenShotOfExportPDF("Admin Pdc Export To Pdf");
}
@Test(priority=6,dependsOnMethods="Export")
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Added PDC" + "  AddedPDC", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Enchased Date Unable To Save" + "  EnchasedDateUnableToSave", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"After Enchased Date Filled" + "  AfterEnchasedDateFilled ", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"DashBoard Pdc After Filled Enchased Date" + "  DashBoardPdcAfterFilledEnchasedDate ", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Admin Pdc Export To Pdf" + "  Admin Pdc Export To Pdf ", true);
Reporter.log(" ", true);

}
}





















