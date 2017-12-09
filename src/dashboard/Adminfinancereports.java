package dashboard;
import java.io.File;
import org.junit.Test;
import common.TestBase;

public class Adminfinancereports extends TestBase{
	@Test
	public void Financereport(){
		
	//helper.Navigate(GlobalVariablesCalling.EnterUrl);
	//File sdcard = new File("C:/Users/Its my Account/Desktop");
	File from = new File("C:/Users/Its my Account/Desktop","anju.txt");
	File to = new File("C:/Users/Its my Account/Desktop","anu.txt");
	
	from.renameTo(to);
	
	/*
		helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
		//send password
		helper.SetValue1("Password", "DEM4_A1");
		//click on agree terms and conditions
			helper.ClickByID("VariableCalling.SelectTermsAndConditions");
			//click on login button
			helper.ClickByXpath(VariableCalling.LoginButton);
			helper.DeepSleep();
	//click on application button
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	helper.DeepSleep();
	
	
	helper.ClickByXpath(".//*[@id='506']/div");
	helper.DeepSleep();

	helper.ClickByID("setlink");
	helper.DeepSleep();
	helper.SetValueByID("FromDate", "06-06-2016");
	helper.SetValueByID("ToDate", "06-06-2016");
	//click on go
	helper.ClickByXpath(".//*[@id='btnGo']");
	helper.DeepSleep();
	//click on trail balance
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[1]/a");
	//click on balancesheet
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[2]/a");
	helper.DeepSleep();
	//click on expenditure 
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[3]/a");
	helper.DeepSleep();
	//click on daybook
	helper.ClickByXpath("html/body/div[1]/div/div/ul/li/b[5]/a");*/
}

}
