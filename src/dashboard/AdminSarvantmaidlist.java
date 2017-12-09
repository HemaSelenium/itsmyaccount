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
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class AdminSarvantmaidlist extends TestBase{
@Test(priority=1)
public void Login()throws Exception{
Reporter.log("Script Name:Admin---->Application--->ServantMaidList", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
}
@Test(priority=2,dataProvider="AdminServantMaidList",dataProviderClass= DataProvider3.class)
public void AddEditDeleteServantDetails(String EnterServantName,String EnterServantContactNumber,String EnterSalaryForServant,String EnterTypeOfWork,String SearchServantNameAfterAdd,String EnterServantContactNumberToEdit,String SearchContactNumberAfterEdit,String SearchServantNameAfterDelete ) throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnServantMaidListButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID(VariableCalling.EnterServantNameID, EnterServantName);
helper.SetValueByID(VariableCalling.EnterServantContactNumberID, EnterServantContactNumber);
helper.SetValueByID(VariableCalling.EnterSalaryID, EnterSalaryForServant);
helper.ClickByXpath(VariableCalling.ClickOnBlockDropdownListInServantMaidList);
Thread.sleep(4000);
helper.ClickByLinkText(GlobalVariablesCalling.EnterMemberBlockName);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnApartmentNumberDropDownlist);
Thread.sleep(4000);
helper.ClickByLinkText(GlobalVariablesCalling.EnterMemberApartmentNumber);
Thread.sleep(2000);
WebElement Servantlist=SeleniumHelper.driver.findElement(By.xpath(VariableCalling.AdminTypeOfWorks));
List<WebElement>TypeOfWorks=Servantlist.findElements(By.tagName(VariableCalling.ListOfTypeOfWorks));
for(int Worktype=0;Worktype<TypeOfWorks.size();Worktype++){
String TypeOfWork=TypeOfWorks.get(Worktype).getText();
if(TypeOfWork.equals(EnterTypeOfWork)){
TypeOfWorks.get(Worktype).findElement(By.tagName(VariableCalling.SelectTypeOfWork)).click();	
}}helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInServantMaidList);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.EnterBlockNameToSearch);
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, GlobalVariablesCalling.EnterMemberBlockName);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.EnterApartmentNumberToSearch);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberApartmentNumber);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
WebElement Servants=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>ServantmemberRows=Servants.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
for(int Rows=1;Rows<ServantmemberRows.size();Rows++){
List<WebElement>ColoumnsOfCouriers=ServantmemberRows.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfCouriers.get(2).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfCouriers.get(3).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(ColoumnsOfCouriers.get(4).getText().equals(SearchServantNameAfterAdd)){
File AddedServantMaidList=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(AddedServantMaidList, new File(GlobalVariablesCalling.ScreenShotsFileName+"AddedServantMaidList.png"));
Reporter.log("Servant Details Added Sucessfully", true);	
Reporter.log("Before Editing ContactNumber Of Servant Is : "+ColoumnsOfCouriers.get(5).getText(), true);	
ColoumnsOfCouriers.get(4).click();
helper.ClickByID(VariableCalling.ClickOnEditButton);
Thread.sleep(3000);
helper.SetValueByID(VariableCalling.EnterServantContactNumberID, EnterServantContactNumberToEdit);
helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInServantMaidList);
Thread.sleep(2000);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(3000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.EnterBlockNameToSearch);
helper.SetValueByXpath(VariableCalling.EnterDataToSearchInSearchFunction, GlobalVariablesCalling.EnterMemberBlockName);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.EnterApartmentNumberToSearch);
helper.SetValueByXpath(VariableCalling.EnterDataToSearch, GlobalVariablesCalling.EnterMemberApartmentNumber);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(2000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(2000);
WebElement MemberServants=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>MemberServantRows=MemberServants.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
for(int RowsOfServants=1;RowsOfServants<MemberServantRows.size();RowsOfServants++){
List<WebElement>ColoumnsOfMemberServants=MemberServantRows.get(RowsOfServants).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(ColoumnsOfMemberServants.get(2).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfMemberServants.get(3).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(ColoumnsOfMemberServants.get(5).getText().equals(SearchContactNumberAfterEdit)){	
File ServantDetailsAfterEdit=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ServantDetailsAfterEdit, new File(GlobalVariablesCalling.ScreenShotsFileName+"ServantDetailsAfterEdit.png"));
Reporter.log("Edit Servant ContactNumber Sucessfully", true);	
Reporter.log("After Editing ContactNumber Of Servant Is : "+ColoumnsOfMemberServants.get(5).getText(), true);	
ColoumnsOfMemberServants.get(5).click();
helper.ClickByID(VariableCalling.ClickONDeleteButton);
try{
helper.ProcessAlert();
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(3000);
WebElement ServantMaidList=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>ServantMaidListRows=ServantMaidList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
List<String>ServantNames=new ArrayList<String>();
for(int RowsOfServantmaidList=1;RowsOfServantmaidList<ServantMaidListRows.size();RowsOfServantmaidList++){
List<WebElement>ColoumnsOfServantmaidList=MemberServantRows.get(RowsOfServantmaidList).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
if(ColoumnsOfServantmaidList.get(2).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfServantmaidList.get(3).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
ServantNames.add(ColoumnsOfCouriers.get(4).getText());	
}}}
if(ServantNames.contains(SearchServantNameAfterDelete)){
Reporter.log("Added ServantDetails Unable To Delete ", true);	

}
else{
Reporter.log("Added ServantDetails Deleted Sucessfully ", true);	

}
}catch(UnhandledAlertException e){
DesiredCapabilities dc = new DesiredCapabilities();
dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement ServantMaidList=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>ServantMaidListRows=ServantMaidList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));		
List<String>ServantNames=new ArrayList<String>();
for(int RowsOfServantmaidList=1;RowsOfServantmaidList<ServantMaidListRows.size();RowsOfServantmaidList++){	
List<WebElement>ColoumnsOfServantmaidList=ServantMaidListRows.get(RowsOfServantmaidList).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
if(ColoumnsOfServantmaidList.get(2).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(ColoumnsOfServantmaidList.get(3).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
ServantNames.add(ColoumnsOfServantmaidList.get(4).getText());		
}}}
if(ServantNames.contains(SearchServantNameAfterDelete)){
Reporter.log("Added ServantDetails Unable To Delete ", true);	
}
else{
Reporter.log("Added ServantDetails Deleted Sucessfully ", true);	
}}
break;
}
else{
Reporter.log(" Servant ContactNumber Unable TO Edit", true);	
}}}}	
break;	
}}}}}

@Test(priority=3)
public void Export() throws InterruptedException, IOException, HeadlessException, AWTException{
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnExportButtonInServantMaidList);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInServantMaidList);
Thread.sleep(4000);
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+"AdminServantMaidListPdf.png"));
}
@Test(priority=4)
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AddedServantMaidList.png" +  "   AddedServantMaidList.png", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ServantDetailsAfterEdit.png" + "   ServantDetailsAfterEdit", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AdminServantMaidListPdf.png" + "   AdminServantMaidListPdf", true);	
Reporter.log(" ", true);	
}
	
	
	
	
	
	

}
