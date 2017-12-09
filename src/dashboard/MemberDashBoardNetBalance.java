package dashboard;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class MemberDashBoardNetBalance extends TestBase{
@Test
public void dshboardNetBalance() throws IOException{
Reporter.log("ScriptName:Member-->DashBoard-->NetBalance", true);	
Reporter.log("------------------------------------------", true);	
Reporter.log(" ", true);	
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
helper.DeepSleep();

//String BalanceInDashBoard=SeleniumHelper.driver.findElement(By.xpath(VariableCalling2.NetBalanceInDashBoard)).getText();
String BalanceInDashBoard=helper.GetValueByXpath(VariableCalling2.NetBalanceInDashBoard);
String DashBoardBalance=BalanceInDashBoard.replaceAll(",", "");
Float NetBalanceInDashBoard=Float.parseFloat(DashBoardBalance);

Reporter.log("Net Balance In DashBoard:", true);
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.ClickByXpath(VariableCalling.ClickOnMyAccountButton);
helper.DeepSleep();
helper.ClickByID("IsActive_ON");
String BalanceAmount=helper.GetValueByXpath(VariableCalling2.BalanceAmount);
String RegularBalance=BalanceAmount.replaceAll(",", "");
Float Value1=Float.parseFloat(RegularBalance);
Reporter.log("Regular Balance Amount : " +Value1, true);
helper.TakeScreenShot("Member My Account Regular Balance ");
helper.ClickByID("IsActive_OFF");
String AdvanceBalanceAmount=helper.GetValueByXpath(VariableCalling2.BalanceAmount);
String AdvanceBalance=AdvanceBalanceAmount.replaceAll(",", "");
Float Value2=Float.parseFloat(AdvanceBalance);
Reporter.log("Advance Balance Amount : " +Value2, true);
helper.TakeScreenShot("Member My Account Advance Balance ");
String NetBalance=helper.GetValueByID("NET");
String NetBalanceInApplication=NetBalance.replaceAll(",","");
Reporter.log("NetBalance Amount : " +NetBalanceInApplication, true);
Float Balance=Value1-Value2;
if(NetBalanceInDashBoard.equals(NetBalanceInApplication)){
Reporter.log("DashBoard Net Balance And MyAccount Netbalance Both Are Equal ", true);
}
else{
Reporter.log("DashBoard Net Balance And MyAccount Netbalance Both Are Not Equal ", true);
}
if(Balance==Float.parseFloat(NetBalanceInApplication)){
Reporter.log("NetBance Is Equal To Regular Amount Minus Advance Amount", true);
}
else{
Reporter.log("NetBance Is Not Equal To Regular Amount Minus Advance Amount", true);
}	}
@Test
public void Results(){
Reporter.log(" ", true);	
Reporter.log("Files Stored in (Path Name)", true);	
Reporter.log("-----------------------------", true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Member My Account Regular Balance " , true);	
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Member My Account Advance Balance " , true);	
Reporter.log(" ", true);	
}
		
						
					
					
					
					
					
					
					
					
					
					
					
					
					
			
	
	

}
