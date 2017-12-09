package common;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import IntegrationWithBiometric.AdminRegularvendorsWithoutBadgeId;

public class MethodCalling4 {
public static Logger log=Logger.getLogger(AdminRegularvendorsWithoutBadgeId.class.getName());
public void CompareManageMembersANdMyResidents() throws InterruptedException{
WebElement Member=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
Thread.sleep(2000);
List<WebElement>RowsInMember= Member.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
Thread.sleep(2000);
List<String> ManageMembersList = new ArrayList<String>();
for(int Members=0;Members< RowsInMember.size();Members++){
List<WebElement>coloumnsInMember= RowsInMember.get(Members).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Thread.sleep(4000);
ManageMembersList.add(coloumnsInMember.get(4).findElement(By.tagName("input")).getAttribute("value"));
   }
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnApplicationButton)).click();
Thread.sleep(4000);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.MyResidentsButton)).click();
Thread.sleep(2000);
WebElement members=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
Thread.sleep(3000);
List<WebElement>rows=members.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>MemberListInMyResiddents=new ArrayList<String>();
for(int i=1; i<rows.size();i++){
List<WebElement>coloumns2=rows.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
MemberListInMyResiddents.add(coloumns2.get(6).getText());
        }
if(MemberListInMyResiddents.size() != ManageMembersList.size()) {
Reporter.log("Number Of  ManageMembers List And CarparkingLots Members List  Not Equal ", true);
Reporter.log("Members In MyResidents:"+MemberListInMyResiddents.size(), true);
Reporter.log("Owners In ManageMembers :"+ManageMembersList.size(), true);
 }
else{
Reporter.log("Members In ManageMembers And Members In MyResidents Both Are Same", true);
Reporter.log("Members In ManageMembers List Are : ", true);
for(int j=0; j<ManageMembersList.size(); j++) {
Reporter.log(ManageMembersList.get(j), true);
   
   }
Reporter.log("Members In MyResidents : ", true);
for(int j=0; j<MemberListInMyResiddents.size(); j++) {
Reporter.log(MemberListInMyResiddents.get(j), true);
               	         	    }}}
public void CompareMAnagemebersAndCommiteeMembers() throws InterruptedException{
WebElement Member=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
Thread.sleep(2000);
List<WebElement>RowsInMember= Member.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
Thread.sleep(2000);
List<String> ManageMembersList = new ArrayList<String>();
List<String>ManageMembersList2=new ArrayList<String>();
for(int Members=0;Members< RowsInMember.size();Members++){
List<WebElement>coloumnsInMember= RowsInMember.get(Members).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Thread.sleep(4000);
String Designation=coloumnsInMember.get(21).findElement(By.tagName("input")).getAttribute("value");
if(Designation.isEmpty()){
 		}
else{
String OccupancyOfMember=coloumnsInMember.get(3).findElement(By.tagName("select")).getAttribute("value");		
if(OccupancyOfMember.equals("O")){
String MemberInManageMembers=coloumnsInMember.get(4).findElement(By.tagName("input")).getAttribute("value");
Reporter.log("Member Of " +MemberInManageMembers+" having Designation Of " +Designation +" In ManageMembers", true);
ManageMembersList.add(coloumnsInMember.get(4).findElement(By.tagName("input")).getAttribute("value"));
  	}
else{
String MemberInManageMembers=coloumnsInMember.get(9).findElement(By.tagName("input")).getAttribute("value");
Reporter.log("Member Of " +MemberInManageMembers+" having Designation Of " +Designation +" In ManageMembers", true);
ManageMembersList2.add(coloumnsInMember.get(9).findElement(By.tagName("input")).getAttribute("value"));
  	}
ManageMembersList.addAll(ManageMembersList2);	
	      		
	      	
	   		}
	    }
 
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnApplicationButton)).click();
Thread.sleep(4000);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.ClickOnCommiteeMembersButton)).click();
Thread.sleep(2000);
WebElement members=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
Thread.sleep(3000);
List<WebElement>rows=members.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<String>MemberListInMyCommiteemembers=new ArrayList<String>();
for(int i=1; i<rows.size();i++){
List<WebElement>coloumns2=rows.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String DesignationInCommiteeMembers=coloumns2.get(2).getText();
String MemberNameInCommiteeMembers=coloumns2.get(5).getText();
Reporter.log("Member Of " +MemberNameInCommiteeMembers+" having Designation Of " +DesignationInCommiteeMembers +" In CommiteeMembers", true);
MemberListInMyCommiteemembers.add(coloumns2.get(5).getText());
    
} 
	   
if(ManageMembersList.containsAll(MemberListInMyCommiteemembers)){
Reporter.log(" ManageMembers who has  Designation And CommiteeMembers Are Same ", true);
}
else{
Reporter.log(" ManageMembers who has  Designation And CommiteeMembers Are Not Same ", true);

}
	   
	   
   }
    	












    	
    	
    	
	
}
