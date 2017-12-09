package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class MethodCalling8 {
public String ServantName;
public  String BlockName;
public String ApartmentNumber;
protected static SeleniumHelper helper = new SeleniumHelper();
public void SelectMYResidentsAndDueListInSMSOptions(String FunctionName){
SeleniumHelper.driver.findElement(By.xpath(".//*[@id='SMSSubscription_chosen']/ul")).click();
WebElement SmsOptions=SeleniumHelper.driver.findElement(By.xpath(".//*[@id='SMSSubscription_chosen']/div/ul"));
List<WebElement> list=SmsOptions.findElements(By.tagName("li"));
for(int i=0;i<list.size();i++){
if(list.get(i).getText().equals(FunctionName)){
list.get(i).click();
break;
}}}
	

public void AddServantDetails(String Servantname,String ContactNo,String Cost,String Block,String ApartmentNo,String WorkType,String BadgeID,String Reference1,String Reference2,String Reference3) throws AWTException, InterruptedException{
ServantName=Servantname;
BlockName=Block;
ApartmentNumber=ApartmentNo;
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnServantMaidListButton);
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnAddButton);
helper.DeepSleep();
helper.SetValueByID("ServantName", ServantName);
helper.SetValueByID("Contact", ContactNo);
helper.SetValueByID("Cost", Cost);
helper.ClickByXpath(variablecalling3.BlockDropDowninServantMaidList);
SeleniumHelper.driver.findElement(By.linkText(BlockName)).click();
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.ApartmentNumberDropDownInServantMaidList);
SeleniumHelper.driver.findElement(By.linkText(ApartmentNumber)).click();
helper.DeepSleep();
WebElement TypesOfWork=SeleniumHelper.driver.findElement(By.xpath(variablecalling3.TypesOfworks));
List<WebElement> Types=TypesOfWork.findElements(By.tagName("div"));
for(int work=0;work<Types.size();work++){
String TypeOfWork=Types.get(work).findElement(By.tagName("input")).getAttribute("id");
if(TypeOfWork.equals(WorkType)){
Types.get(work).findElement(By.tagName("input")).click();
break;		
}}
SeleniumHelper.driver.findElement(By.id("PassNo")).clear();
helper.Sleep();
SeleniumHelper.driver.findElement(By.id("PassNo")).sendKeys(BadgeID);;
helper.Sleep();
helper.SetValueByID("Reference1", Reference1);
helper.SetValueByID("Reference2", Reference2);
helper.SetValueByID("Reference3", Reference3);
helper.ClickByXpath(VariableCalling2.UploadImage);
helper.Sleep();
helper.Sleep();
StringSelection stringSelection = new StringSelection(GlobalVariablesCalling.ImageToUpload);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_V);
rb.keyRelease(KeyEvent.VK_CONTROL);
helper.Sleep();
rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.WebCam);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling2.TakeSnapShot);
helper.DeepSleep();
helper.DeepSleep();
helper.ClickByXpath(variablecalling3.SaveButtonInServantMaid);
try{
helper.ProcessAlert();
}
catch(NoAlertPresentException ex){
}
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>ServantNames=new ArrayList<String>();
for(int rows=1;rows<Rows.size();rows++){
List<WebElement>Coloumns=Rows.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
if(Coloumns.get(3).getText().equals(BlockName)){
if(Coloumns.get(4).getText().equals(ApartmentNumber)){
ServantNames.add(Coloumns.get(5).getText());
}}}
if(ServantNames.contains(ServantName)){
Reporter.log("Servant Details Added Sucessfully With "+ ServantName + " For Following Block And Apartment : "+BlockName+" "+ApartmentNumber, true);
for(int i=0;i<Rows.size();i++){
List<WebElement>Coloumn=Rows.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
if(Coloumn.get(3).getText().equals(BlockName)){
if(Coloumn.get(4).getText().equals(ApartmentNumber)){
if(Coloumn.get(5).getText().equals(ServantName)){
Coloumn.get(4).click();
helper.Sleep(); 
break;
}}}}}
else{
Reporter.log("Servant Details Unable To Add", true);
}}




}
