package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import IntegrationWithBiometric.AdminRegularvendorsWithoutBadgeId;




public class MethodCalling3 {
public static Logger log=Logger.getLogger(AdminRegularvendorsWithoutBadgeId.class.getName());
String UserPassword;
public void CheckOccupationIsFreeOrNot() throws InterruptedException{
//DOMConfigurator.configure("log4j.xml");
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnDashBoardButton)).click();
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnManageMembers)).click();
Thread.sleep(3000);
WebElement NonMemberList=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>RowsInNonMemberList= NonMemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>coloumnsInNonMemberList= RowsInNonMemberList.get(RowsInNonMemberList.size()-1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String OccupancyType=coloumnsInNonMemberList.get(3).findElement(By.tagName("select")).getAttribute("value");
if (OccupancyType.equals("F")){
Reporter.log("After Member Movement Occupancy Type Of Block Is: Free", true);
     	      	            }
else{
if (OccupancyType.equals("O")){
Reporter.log("10)After Member Movement Occupancy Type Of Block Is: Owner", true);
            		            	}
else{
Reporter.log("10)After Member Movement Occupancy Type Of Block Is: Tenant", true);
      		            	}            }	}
public void checkAlert() {
DOMConfigurator.configure("log4j.xml");
try {
WebDriverWait wait = new WebDriverWait(SeleniumHelper.driver, 2);
wait.until(ExpectedConditions.alertIsPresent());
Alert alert = SeleniumHelper.driver.switchTo().alert();
String AlertText = alert.getText();
Reporter.log("While Editing After ClickOn Save Button PopUpCame As: "+AlertText, true);
alert.accept();
SeleniumHelper.driver.switchTo().defaultContent();
 } catch (Exception e) {
    }	}
 
public void VerifyingNonMemberUserNameAfterEdit() throws InterruptedException{
//DOMConfigurator.configure("log4j.xml");
WebElement NonMemberList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
Thread.sleep(4000);
List<WebElement>RowsInNonMemberList= NonMemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
Thread.sleep(4000);
for(int rows=0;rows<RowsInNonMemberList.size();rows++){
Thread.sleep(2000);
List<WebElement>coloumnsInNonMemberList= RowsInNonMemberList.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Thread.sleep(2000);
String NonMemberUserName=coloumnsInNonMemberList.get(3).getText();
Thread.sleep(2000);
if(NonMemberUserName.equals(GlobalVariablesCalling.EnterNonMemberUserName)){
Actions Act=new Actions(SeleniumHelper.driver);
Act.doubleClick(coloumnsInNonMemberList.get(3)).build().perform();
Thread.sleep(4000);
String EditedContactNumber=SeleniumHelper.driver.findElement(By.id("NonMemberContact")).getAttribute("value");
Thread.sleep(3000);
Reporter.log("Edited Contactnumber Is : "+EditedContactNumber, true);
if(EditedContactNumber.equals(GlobalVariablesCalling.EnterNewNonMemberContactNumberToEdit)){
Thread.sleep(3000);
Reporter.log("Sucessfully Edited Contact Number", true);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnCloseButtonOfOpenedDetailsPage)).click();
Thread.sleep(3000);
}else{
Reporter.log("Unable To Edit Contact Details", true);
}	    }}}
public void VerifyingSelectFunctionality() throws InterruptedException, IOException{
//DOMConfigurator.configure("log4j.xml");
boolean contains=false;
WebElement MyResidents=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
List<WebElement>ListOfMemberRows=MyResidents.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String> list = new ArrayList<String>();
Thread.sleep(2000);
for (int Rows = 1; Rows < ListOfMemberRows.size(); Rows++) {
List<WebElement>ListOfMemberColoumns=ListOfMemberRows.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
list.add(ListOfMemberColoumns.get(2).getText());
}	
		
for(int j=0;j<list.size();j++){
if((list.get(j)).equals(GlobalVariablesCalling.EnterMemberBlockName))
Thread.sleep(2000);
		{
contains=true;
		}
		}
if(contains){
Thread.sleep(2000);
System.out.println(GlobalVariablesCalling.EnterMemberBlockName+" Block Name Deatails Available After Select Member Block");	
Thread.sleep(1000);
File VerifyingSelectFunctionInMyResidents=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(VerifyingSelectFunctionInMyResidents, new File(GlobalVariablesCalling.ScreenShotsFileName+"VerifyingSelectFunctionInMyResidents .png"));
	}
else{
Thread.sleep(2000);
Reporter.log("Select Not Working Properly", true);
Thread.sleep(1000);
		}	
}
public void CompareManageMembersANdCarparkingLotMembers() throws InterruptedException{
DOMConfigurator.configure("log4j.xml");
WebElement Member=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
Thread.sleep(2000);
List<WebElement>RowsInMember= Member.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
Thread.sleep(2000);
List<String> ManageMembersList = new ArrayList<String>();
for(int Members=0;Members< RowsInMember.size();Members++){
List<WebElement>coloumnsInMember= RowsInMember.get(Members).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
ManageMembersList.add(coloumnsInMember.get(4).findElement(By.tagName("input")).getAttribute("value"));
  }
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnApplicationButton)).click();
Thread.sleep(4000);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnCarParkingLotsButton)).click();
Thread.sleep(2000);
WebElement members=SeleniumHelper.driver.findElement(By.id("Grid"));
Thread.sleep(3000);
List<WebElement>rows=members.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>MemberListInCarParkingLots=new ArrayList<String>();
for(int i=1; i<rows.size();i++){
List<WebElement>coloumns2=rows.get(i).findElements(By.tagName("td"));
MemberListInCarParkingLots.add(coloumns2.get(3).getText());
        }
if(MemberListInCarParkingLots.size() != ManageMembersList.size()) {
Reporter.log("1) Number Of  ManageMembers List And CarparkingLots Members List  Not Equal ", true);
Reporter.log("2)Members In CarParkingLots:"+MemberListInCarParkingLots.size() , true);
Reporter.log("3)Owners In ManageMembers :"+ManageMembersList.size(), true);
    	     }
else{
Reporter.log("1)Members In ManageMembers And Members In CarParking Lots Both Are Same", true);
Reporter.log("2)Members In ManageMembers List Are : ", true);
for(int j=0; j<ManageMembersList.size(); j++) {
Reporter.log(ManageMembersList.get(j), true);
     	     }
Reporter.log("3)Members In CarParkingLots Are : ", true);
for(int j=0; j<MemberListInCarParkingLots.size(); j++) {
System.out.println( MemberListInCarParkingLots.get(j));
      	    }}}}
    		
    		
    	
    	
    	
	
 
	 
	 


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

