package IntegrationWithBiometric;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider8;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
import common.variablecalling3;
public class EditSeravntmaidListWithUnTickSMS extends TestBase{
public  String BlockName2=GlobalVariablesCalling.BlockNameOf2ndMember;
public  String ApartmentNumber2=GlobalVariablesCalling.ApartmentNumberOf2ndMember;
public  String ServantName;
@Test(priority=1)
public void login() throws Exception{
Reporter.log("Script Name:Admin---->Application--->ServantMaid List with Badge Id With SMS Tick", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password",GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
 }
@Test(priority=2,dataProvider="EditServantMaidListWithBadgeID",dataProviderClass= DataProvider8.class)
public void EditPreviousRecordsWithUntickSMS(String servantName) throws InterruptedException, IOException{
ServantName=servantName;
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnServantMaidListButton);
helper.DeepSleep();
WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));	
for(int rows=1;rows<Rows.size();rows++){
List<WebElement>Coloumns=Rows.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(Coloumns.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(Coloumns.get(5).getText().equals(ServantName)){
Actions Act=new Actions(SeleniumHelper.driver);
Act.doubleClick(Coloumns.get(5)).build().perform();
helper.DeepSleep();
if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
SeleniumHelper.driver.findElement(By.id("ISSMS")).click();
}
helper.Sleep();
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
break;
}}}}
helper.RefreshPage();
helper.DeepSleep();
WebElement Table1=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows1=Table1.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));	
for(int row=1;row<Rows1.size();row++){
List<WebElement>Coloumn=Rows1.get(row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumn.get(3).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
if(Coloumn.get(4).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
if(Coloumn.get(5).getText().equals(ServantName)){
Actions Act=new Actions(SeleniumHelper.driver);
Act.doubleClick(Coloumn.get(5)).build().perform();
helper.DeepSleep();
if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
Reporter.log("Unable to Untick SMS Option", true);
}else{
Reporter.log("Untick SMS Option Done Sucessfully For The Servant Record Who Is Working in "+GlobalVariablesCalling.EnterMemberBlockName+" ApartmentNumber "+GlobalVariablesCalling.EnterMemberApartmentNumber, true);
}
break;
}}}}
helper.RefreshPage();
helper.DeepSleep();
WebElement Table2=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows2=Table2.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));	
for(int ROW=1;ROW<Rows2.size();ROW++){
List<WebElement>coloumns=Rows2.get(ROW).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumns.get(3).getText().equals(BlockName2)){
if(coloumns.get(4).getText().equals(ApartmentNumber2)){
if(coloumns.get(5).getText().equals(ServantName)){
Actions Act1=new Actions(SeleniumHelper.driver);
Act1.doubleClick(coloumns.get(5)).build().perform();
helper.DeepSleep();
if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
SeleniumHelper.driver.findElement(By.id("ISSMS")).click();
	}
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
break;
}}}}
WebElement Table3=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows3=Table3.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));	
for(int ROWS=1;ROWS<Rows3.size();ROWS++){
List<WebElement>coloumn=Rows3.get(ROWS).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(coloumn.get(3).getText().equals(BlockName2)){
if(coloumn.get(4).getText().equals(ApartmentNumber2)){
if(coloumn.get(5).getText().equals(ServantName)){
Actions Act1=new Actions(SeleniumHelper.driver);
Act1.doubleClick(coloumn.get(5)).build().perform();
helper.DeepSleep();
helper.TakeScreenShot("Edited Servant Record With Untick SMS Option");
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Edited Servant Record With Untick SMS Option", true);
if(SeleniumHelper.driver.findElement(By.id("ISSMS")).isSelected()){
Reporter.log("Unable to Untick SMS Option", true);
}else{
Reporter.log("Untick SMS Option Done Sucessfully For The Servant Record Who Is Working in "+BlockName2+" ApartmentNumber "+ApartmentNumber2, true);
}	break;
}}}}		
}
@Test(priority=3,dependsOnMethods="EditPreviousRecordsWithUntickSMS")
public void ManuallyNeedToBeCheck(){
Reporter.log("Swipe FP of 1003 Servant for ENTRY", true);
Reporter.log("----------------------------------", true);
Reporter.log("1) SMS NOT to be triggered (Check sms balance before and after swipe)", true);
Reporter.log("2) Biometric screen to updated with one record with IN-TIME", true);
Reporter.log("3) Summary listing should updated as 1/0 in servant maid list", true);
Reporter.log(" Swipe FP of 1003 Servant for EXIT", true);
Reporter.log("----------------------------------", true);
Reporter.log("1) SMS NOT to be triggered (Check SMS Balance before and after swipe)", true);
Reporter.log("2) Biometric screen to be updated with one record as OUT-TIME", true);
Reporter.log("3) Summary Listing should updated as 1/1 Under servantmaidlist", true);
}
	
	
	
		

}
