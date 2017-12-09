package dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;

public class HidingMailAndContactOfCommitteeMember extends TestBase{
	String CommitteeMember;
	String Block;
	String ApartmentNumber;
	@Test
public void HidingMail() throws InterruptedException{
		
		helper.Navigate(GlobalVariablesCalling.EnterUrl);
		helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
		helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
		helper.ClickByID(VariableCalling.SelectTermsAndConditions);
		helper.ClickByXpath(VariableCalling.LoginButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnManageMembers);
		helper.DeepSleep();
		WebElement MemberList=SeleniumHelper.driver.findElement(By.tagName(VariableCalling2.IdentifyingManageMembersTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		helper.MaxSleep();
		List<WebElement>RowsInMemberList= MemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		helper.Sleep();
		for(int i=0;i<RowsInMemberList.size()-1;i++){
		List<WebElement>coloumnsInMemberList= RowsInMemberList.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		helper.Sleep();
		String Result=coloumnsInMemberList.get(21).findElement(By.tagName("input")).getAttribute("value");
		if(Result.isEmpty()){
		}
		else{
		JavascriptExecutor jse = (JavascriptExecutor)SeleniumHelper.driver;
		jse.executeScript("arguments[0].setAttribute('type', 'text');", coloumnsInMemberList.get(2).findElement(By.tagName("input")));
		Reporter.log("Hiding Mail Id and ContactNumber Of the committee Member is : "+coloumnsInMemberList.get(4).findElement(By.tagName("input")).getAttribute("value"), true);
		CommitteeMember=coloumnsInMemberList.get(4).findElement(By.tagName("input")).getAttribute("value");
		JavascriptExecutor js = (JavascriptExecutor)SeleniumHelper.driver;
		js.executeScript("arguments[0].setAttribute('type', 'text');", coloumnsInMemberList.get(0).findElement(By.xpath("//input[2]")));
		Block=coloumnsInMemberList.get(0).findElement(By.xpath(VariableCalling.Block)).getAttribute("value");
		System.out.println("Block : "+Block);
		JavascriptExecutor js2 = (JavascriptExecutor)SeleniumHelper.driver;
		js2.executeScript("arguments[0].setAttribute('type', 'text');", coloumnsInMemberList.get(1).findElement(By.xpath("//input[2]")));
		ApartmentNumber=coloumnsInMemberList.get(1).findElement(By.xpath(VariableCalling.ApartmentNo)).getAttribute("value");
		System.out.println("Apartment Number :"+ApartmentNumber);
		helper.DeepSleep();
		if(coloumnsInMemberList.get(6).findElement(By.tagName("input")).isSelected()){
		
		break;	
		}else{
		coloumnsInMemberList.get(6).findElement(By.tagName("input")).click();
		helper.Sleep();
		coloumnsInMemberList.get(8).findElement(By.tagName("input")).click();
		SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnSaveButtonInManageMembers)).click();
		helper.MaxSleep();
		break;
		
		}}
		}
		Method7.CheckingHidingMailIdAndMobileNumberInMyResidents(CommitteeMember);
		Method7.CheckingHidingMailIdAndMobileNumberInCarparkingLots(CommitteeMember);
		Method7.CheckingHidingMailIdAndMobileNumberInDueList(CommitteeMember);
		Method7.CheckingHidingMailIdAndMobileNumberInCommitteeMembers(CommitteeMember);
		Method7.CheckingHidingMailIdAndMobileNumberWhileFacilityBooking(Block, ApartmentNumber);
	}
	
	


}
