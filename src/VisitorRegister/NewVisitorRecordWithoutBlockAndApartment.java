package VisitorRegister;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class NewVisitorRecordWithoutBlockAndApartment extends TestBase1 {
	public String PassNo;
	@Test(priority =1,dataProvider = "register")
	public void login(String name,String number, String Contactname, String gate, String purpose, String passnumber) throws AWTException, InterruptedException{
		Reporter.log("Test Script:  VisitorregisterTestingIMA_TC_002",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  NewVisitorRecordWithoutBlockAndApartment",true);
		
		PassNo=passnumber;
		helper1.clickelementbyXpath(Variables.ApplicationButton);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorRegister);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.addrole);
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
		helper1.SetValueByID(Variables.visitorname, name);
		helper1.SAP();
		helper1.SetValueByID(Variables.contactnum, number);
		helper1.SAP();
		helper1.SetValueByID(Variables.contactname, Contactname);
		helper1.SAP();
		helper1.SetValueByID(Variables.gatenum, gate);
		helper1.SAP();
		helper1.SetValueByID(Variables.purpose, purpose);
		helper1.SAP();
		SeleniumHelper1.driver.findElement(By.id(Variables.MeetingTime)).clear();
		helper1.SAP();
		helper1.SetValueByID(Variables.MeetingTime, Method.PresentTime());
		helper1.SAP();
		SeleniumHelper1.driver.findElement(By.xpath(Variables.Passnumber)).clear();
		helper1.SAP();
		helper1.SetValueByxpath(Variables.Passnumber, PassNo);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.uploadimage);
		helper1.SAP();
		 helper1.UploadImage();
		 helper1.SAP();
	   helper1.clickelementbyXpath(Variables.saveVisitor);
	   helper1.SAP();
	}
	
	@Test(priority =2,dependsOnMethods="login")
	public void Manual1(){
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS should reach the Moderator as ARRIVED", true);
	}
	   
	   
	@Test(priority =3,dependsOnMethods="Manual1")
	   public void exit() throws InterruptedException{
	    helper1.clickelementbyXpath(Variables.searchgridbtn);
	   helper1.SAP();
	   helper1.clickelementbyXpath(Variables.searchPassumber);
	   helper1.SAP();
	 System.out.println(PassNo);
		helper1.SAP();
	   helper1.SetValueByxpath(Variables.searchTxtbox1, PassNo );
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
			String data3=coloumn3.get(3).getText();
			//System.out.println(data3);
			if(data3.equals(PassNo)){
			coloumn3.get(0).click();
			Reporter.log("Records added successfully", true);
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
			Reporter.log("out time:"+ OutTime, true);
			helper1.SAP();
			helper1.clickelementbyXpath(Variables.saveVisitor);
			helper1.SAP();
	}
			else{
				System.out.println("not found");
			}
	
		}
	}
	@Test(priority =4,dependsOnMethods="exit")
	public void Manual2(){
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS should reach the Moderator as LEFT", true);
		Reporter.log("***************************************",true);
	}
	
	@DataProvider(name = "register")
	public Object[][] readexcel2() throws IOException, BiffException {
		File fs = new File("C://Users//IMA//workspace//ItsMyAccount//VisitorRegistorExcel.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Visitor");
		int rows = s.getRows();
		int columns = s.getColumns()-27;
		String inputdata[][] = new String[rows - 2][columns];
		for (int i = 2; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 2][j] = cl.getContents();
			}
		}
		return inputdata;
	}

	


}
