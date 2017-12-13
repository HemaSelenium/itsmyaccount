package myfinance;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;



public class CreateEditDeleteGLAccount extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	protected static FinanceVariables fin=new FinanceVariables();
	 boolean result=true;

	
	 @Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_025",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name: Create Edit Delete GL Account",true);
			ldr.adminlogin();
			helper1.SAP();
			
		}
	
	@Test(priority = 2)
	public void CreateGL() throws InterruptedException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GeneralLedgerAccount)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AddGL)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLAccountName)).sendKeys(FinanceVariables.GLName);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).sendKeys(FinanceVariables.GLDescriptionTxt);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerGroupId)).sendKeys(FinanceVariables.GLGroup1);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).click();
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveGL)).click();
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(FinanceVariables.GLName);
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		helper1.SAP();
		WebElement load=MethodsCalling.driver.findElement(By.id(Variables.IdentifyingTable));
		WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
		List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
       
		int jsize=rows3.size();
	
		for(int p=1;p<jsize;p++){  
      				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
			String data3=coloumn3.get(2).getText();
			System.out.println(data3);
			
			if(data3.equals(FinanceVariables.GLName)){
				coloumn3.get(2).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.EditGroupName)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLAccountName)).clear();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLAccountName)).sendKeys(FinanceVariables.GLName1);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveGL)).click();
				helper1.SAP();
				MethodsCalling.driver.navigate().refresh();
				helper1.SAP();
				break;
		
	}

}
	}
	
	@Test(priority = 3)
	public void DeleteGL() throws InterruptedException{
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(FinanceVariables.GLName);
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		helper1.SAP();
	
		WebElement load=MethodsCalling.driver.findElement(By.id(Variables.IdentifyingTable));
		WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
		List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
       
		int jsize=rows3.size();
	
		for(int p=1;p<jsize;p++){  
      				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
			String data3=coloumn3.get(2).getText();
			System.out.println(data3);
			
			if(data3.equals(FinanceVariables.GLName)){
				coloumn3.get(2).click();
	helper1.SAP();
	MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DeleteGL)).click();
	helper1.SAP();
	Alert simple1=MethodsCalling.driver.switchTo().alert();
	simple1.accept();
	break;
	
}
		}
	}
}
