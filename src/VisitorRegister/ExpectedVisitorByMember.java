package VisitorRegister;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.SeleniumHelper1;
import FinanceCommon.TestBase1;
import FinanceCommon.Variables;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




public class ExpectedVisitorByMember extends TestBase1 {
	String VisitorName;
	@Test(priority =1,dataProvider = "register")
	public void create(String Visitorname, String contactperson, String contactnum,String date,String Fromtime, String Totime,String Purpose) throws InterruptedException{
		Reporter.log("Test Script:  VisitorregisterTestingIMA_TC_011",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: ExpectedVisitorByMember",true);
		helper1.clickelementbyXpath(Variables.logout);
		helper1.SAP();
		Method.MemberLogin();
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.ApplicationButton);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorRegister);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.ExpectedVisitorInMember);
		helper1.SAP();
		helper1.clickelementsbyid(Variables.AddExpected);
		helper1.SAP();
		try
        {
            Alert alert3 = SeleniumHelper1.driver.switchTo().alert();
            alert3.accept();
            
        }
        catch(NoAlertPresentException e)
        {
          Thread.sleep(1000);
  
         
        }
		helper1.SetValueByID(Variables.visitorname,Visitorname);
		helper1.SAP();
		String Visitor=SeleniumHelper1.driver.findElement(By.id(Variables.visitorname)).getAttribute("value");
		helper1.SAP();
		//System.out.println(Visitor);
		helper1.SAP();
		VisitorName=Visitor;
		helper1.SAP();
		helper1.SetValueByID(Variables.contactname, contactperson);
		helper1.SAP();
		helper1.SetValueByID(Variables.contactnum, contactnum);
		helper1.SAP();
		SeleniumHelper1.driver.findElement(By.id(Variables.expecteddate)).clear();
		helper1.SAP();
		helper1.SetValueByID(Variables.expecteddate, date);
		helper1.SAP();
		SeleniumHelper1.driver.findElement(By.id(Variables.expecteddate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		SeleniumHelper1.driver.findElement(By.id(Variables.MeetingTime)).clear();
		helper1.SAP();
		helper1.SetValueByID(Variables.MeetingTime, Fromtime);
		helper1.SAP();
		helper1.SetValueByxpath(Variables.OutTime, Totime);
		helper1.SAP();
		helper1.SetValueByID(Variables.purpose, Purpose);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.Webcam);
		helper1.SAP();
	   helper1.clickelementbyXpath(Variables.TakeSnapshot);
	   helper1.SAP();
		helper1.clickelementbyXpath(Variables.saveVisitor);
		helper1.SAP();			
		
		
	}

	
	@Test(priority =2,dependsOnMethods="create")
	public void Manual1(){
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("1)---SMS to reach Visitor Mobile number with 4 digit Unique id", true);
	}
	@Test(priority =3,dataProvider="register1",dependsOnMethods="Manual1")
public void exit(String gate, String pass) throws InterruptedException{
		
		helper1.clickelementbyXpath(Variables.logout);
		helper1.SAP();
		Method.AdminLogin();
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.ApplicationButton);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorRegister);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.ExpectedVisitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.ExpectedsearchVisitorName);
		   helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchFind);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchgridClose);
		   helper1.SAP();
		   WebElement load=SeleniumHelper1.driver.findElement(By.id(Variables.IdentifyingTable));
			WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
			List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
	   
			int jsize=rows3.size();
		
			for(int p=1;p<jsize;p++){  
	  				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
				String data3=coloumn3.get(4).getText();
				System.out.println(data3);
				if(data3.equals(VisitorName)){
					helper1.SAP();
				//coloumn3.get(13).findElement(By.tagName("a")).click();
				helper1.clickelementbyXpath(Variables.ExpectedArrived);
				helper1.SAP();
				try
		        {
		            Alert alert3 = SeleniumHelper1.driver.switchTo().alert();
		            alert3.accept();
		            
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		         
		        }
				helper1.SAP();
				helper1.SetValueByID(Variables.gatenum,gate);
				helper1.SAP();
				helper1.SetValueByxpath(Variables.Passnumber,pass);
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
			   helper1.SAP();
			   break;	
	}
				
}	
	
}
	@Test(priority =4,dependsOnMethods="exit")
	public void Manual3(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("2)--SMS should reach the Member as ARRIVED", true);
	}	
			
	@Test(priority =5,dependsOnMethods="Manual3")
	public void search1() throws InterruptedException{
		helper1.clickelementbyXpath(Variables.Visitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchFind);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchgridClose);
		   helper1.SAP();
		   WebElement load=SeleniumHelper1.driver.findElement(By.id(Variables.IdentifyingTable));
			WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
			List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
	   
			int jsize=rows3.size();
		
			for(int p=1;p<jsize;p++){  
	  				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
				String data3=coloumn3.get(4).getText();
				//System.out.println(data3);
				if(data3.equals(VisitorName)){
				coloumn3.get(0).click();
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.EditVisitor);
				helper1.SAP();
				try
		        {
		            Alert alert3 = SeleniumHelper1.driver.switchTo().alert();
		            alert3.accept();
		            
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		         
		        }
				helper1.SAP();
				String OutTime=SeleniumHelper1.driver.findElement(By.xpath(Variables.OutTime)).getAttribute("value");
				helper1.SAP();
				Reporter.log("System time will be the out time:"+ OutTime, true);
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
	}
				
}
	}
	@Test(priority =6,dependsOnMethods="search1")
	public void Manual8(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("3)--SMS should reach the Member as LEFT", true);
		Reporter.log("***************************************",true);
	}
	
	
	@DataProvider(name = "register")
	public Object[][] readexcel2() throws IOException, BiffException {
		File fs = new File("C://Users//IMA//workspace//ItsMyAccount//VisitorRegistorExcel.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Visitor");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows - 2][columns-26];
		for (int i = 2; i < rows; i++) {
			for (int j = 26; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 2][j-26] = cl.getContents();
			}
		}
		return inputdata;
	}
	@DataProvider(name = "register1")
	public Object[][] readexcel21() throws IOException, BiffException {
		File fs = new File("C://Users//IMA//workspace//ItsMyAccount//VisitorRegistorExcel.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Arrived");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows - 4][columns-8];
		for (int i = 4; i < rows; i++) {
			for (int j = 8; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 4][j-8] = cl.getContents();
			}
		}
		return inputdata;
	}


}
