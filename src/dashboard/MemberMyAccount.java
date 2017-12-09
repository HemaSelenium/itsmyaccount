package dashboard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider3;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberMyAccount extends TestBase{
@Test(priority=1,dataProvider="MyAccountFilter",dataProviderClass= DataProvider3.class)
public void MyAccount(String EnterFromDate,String EnterToDate,String EnterVoucherType)throws Exception{
Reporter.log("Script Name:Member---->Application--->MyAccount", true);	
Reporter.log("----------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnMyAccountButton);
helper.MaxSleep();
helper.Sleep();
helper.TakeScreenShot("ListOfMemberFinanceVouchers");
WebElement MemberFinanceVoucherList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
helper.MaxSleep();
List<WebElement> FinaceVoucherListRows = MemberFinanceVoucherList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
helper.MaxSleep();
if(FinaceVoucherListRows.size()>1){
List<WebElement> FinaceVoucherListColoumns = FinaceVoucherListRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
helper.MaxSleep();








helper.ClickByXpath(VariableCalling.ClickOnFilterButton);
helper.SetValueByID("FromDate", EnterFromDate);
helper.ClickOnTabButton("FromDate");
helper.SetValueByID("ToDate", EnterToDate);
helper.Sleep();
helper.ClickOnTabButton("ToDate");
helper.Sleep();
helper.ClickByID(VariableCalling.ClickOnGo);
helper.DeepSleep();
helper.TakeScreenShot("After Filter Vouchers ");
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnVoucherTypeListButton);
helper.DeepSleep();
WebElement VoucherTypes=SeleniumHelper.driver.findElement(By.id(VariableCalling.IdentifyVouchers));
List<WebElement>ListOfVouchers=VoucherTypes.findElements(By.tagName(VariableCalling.IdentifyListOfVouchers));
for(int vouchers=0;vouchers<ListOfVouchers.size();vouchers++){
	String TypeOfVoucher=ListOfVouchers.get(vouchers).findElement(By.tagName(VariableCalling.SelectedVoucher)).getText();
	if(TypeOfVoucher.equals(EnterVoucherType)){
		ListOfVouchers.get(vouchers).findElement(By.tagName(VariableCalling.SelectedVoucher)).click();
		helper.DeepSleep();
		helper.TakeScreenShot("After Selected Entered Voucher Type");
		break;
	}
}

SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
ArrayList<String>FooterValues=new ArrayList<String>();
String footerdata=helper.GetValueByXpath(VariableCalling.FooterData);
String FooterNetbalance=helper.GetValueByXpath(VariableCalling.FooterNetBalance);
FooterValues.addAll(Arrays.asList("Debit", "Credit","Balance"));
for(int string=0;string<FooterValues.size();string++){
if(footerdata.indexOf(FooterValues.get(string))!=-1){
System.out.println("Footer has "+FooterValues.get(string));
WebElement FooterAmounts=SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ListOfFooterAmounts));
List<WebElement>Amounts= FooterAmounts.findElements(By.tagName(VariableCalling.Amount));
Reporter.log(FooterValues.get(string)+" Amount In Footer Is : "+Amounts.get(string).getText(), true);	
}
else{
Reporter.log("Can't Find " +FooterValues.get(string)+ " In Footer", true);		
}	}
if(FooterNetbalance.indexOf("NET Balance as on")!=-1){
Reporter.log("Net Balance Found In Footer", true);	
Reporter.log("Net Balance As On Date Is: "+helper.GetValueByID(VariableCalling.NetBalanceDate), true);	
Reporter.log("Net Balance Amount :"+helper.GetValueByID(VariableCalling.NetBalanceAmount), true);	
}
else{
System.out.println("Can't Find NetBalance In Footer");
}
helper.DeepSleep();
try{
helper.ClickByXpath(VariableCalling.ClickOnBaseVoucherOfFirstRowVoucher);
helper.MaxSleep();
helper.DeepSleep();
helper.TakeScreenShot("Base Finace Voucher Of LoggedIn Member");
helper.Sleep();
SeleniumHelper.driver.navigate().refresh();
helper.DeepSleep();
helper.ClickByXpath(VariableCalling.ClickOnDownLoadButtonOfSoftCopyOfFirstRow);
helper.DeepSleep();
helper.TakeScreenShotOfWindowPopUp("Screen Shot After DownLoad SoftCopy");
helper.DeepSleep();
helper.ClickByID(VariableCalling.ClickOnPayOnlineButton);

}
catch(NoSuchElementException e){
	Reporter.log("No Vouchers Available under Maintence Voucher type", true);
	}
	


}
else{
Reporter.log("No Member FinaceVoucher List Available To View", true);		
}
	}
@Test(priority=2,dependsOnMethods="MyAccount")
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"ListOfMemberFinanceVouchers" +  "  ListOfMemberFinanceVouchers", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"After Filter Vouchers " + "   After Filter Vouchers", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"After Selected Entered Voucher Type" + "  After Selected Entered Voucher Type", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Base Finace Voucher Of LoggedIn Member" + "  Base Finace Voucher Of LoggedIn Member", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Screen Shot After DownLoad SoftCopy" + "  Screen Shot After DownLoad SoftCopy", true);	
Reporter.log(" ", true);	
Reporter.log("Items ToCheck Manually", true);	
Reporter.log("----------------------", true);	
Reporter.log("Check Soft Copy Able To DownLoad or Not ", true);	
Reporter.log("Check Advance,Regular Invoices should display when  Advance,Regular Buttons Selected Respectively", true);
}
}
