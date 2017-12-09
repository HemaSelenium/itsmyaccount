package VisitorRegister;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
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

public class FrequentVisitor extends TestBase1 {
	public String VisitorName;
	public String VisitorName1;
	@Test(priority =1)
	public void frequent() throws BiffException, IOException, InterruptedException{
		Reporter.log("Test Script:  VisitorregisterTestingIMA_TC_009",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: FrequentVisitor",true);
		helper1.clickelementbyXpath(Variables.ApplicationButton);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorRegister);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchPassumber);
		   helper1.SAP();
		   File src=new File("C://Users//IMA//workspace//ItsMyAccount//VisitorRegistorExcel.xls");
			FileInputStream fis=new FileInputStream(src);
			Workbook wb1=Workbook.getWorkbook(fis);
			Sheet sh1= wb1.getSheet("Sheet3");
			String PassNo=sh1.getCell(0,0).getContents();
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
				SeleniumHelper1.driver.findElement(By.xpath(Variables.OutTime)).clear();
				helper1.SAP();
				
				if(SeleniumHelper1.driver.findElement(By.xpath(Variables.FrequentVisitorradioButton)).isSelected()){
					
		        }
		        else{
		        	helper1.clickelementbyXpath(Variables.FrequentVisitorradioButton);
		            
		        }
				
				helper1.SAP();
				String Visitor=SeleniumHelper1.driver.findElement(By.id(Variables.visitorname)).getAttribute("value");
				helper1.SAP();
				//System.out.println(Visitor);
				helper1.SAP();
				VisitorName=Visitor;
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
				}
				
			}
				
				
	}
	

	@Test(priority =2,dependsOnMethods="frequent")
	public void Manual1(){
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("1)---SMS should reach the Moderator as ARRIVED", true);
	}
	   
	@Test(priority =3,dependsOnMethods="Manual1")
	public void exit() throws InterruptedException{
		helper1.clickelementbyXpath(Variables.FrequentVisitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 //System.out.println(VisitorName);
		 
			helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchFind);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchgridClose);
		   helper1.SAP();
		   
		helper1.clickelementbyXpath(Variables.Visitor);
		helper1.SAP();
		
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 //System.out.println(VisitorName);
		 
			helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchFind);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchgridClose);
		   helper1.SAP();
		   WebElement load1=SeleniumHelper1.driver.findElement(By.id(Variables.IdentifyingTable));
			WebElement match1=load1.findElement(By.tagName(Variables.IdentifyingTableBody));
			List<WebElement> rows=match1.findElements(By.tagName(Variables.IdentifyingTableRows));   
	   
			int jsize1=rows.size();
		
			for(int q=1;q<jsize1;q++){  
	  				List<WebElement> coloumn=rows.get(q).findElements(By.tagName(Variables.IdentifyingTableColoumn));
				String data=coloumn.get(4).getText();
				//System.out.println(data);
				if(data.equals(VisitorName)){
				coloumn.get(0).click();
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
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
	}
				
}
}
	@Test(priority =4,dependsOnMethods="exit")
	public void Manual2(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("2)---SMS should reach the Moderator as LEFT", true);
	}
	@Test(priority =5,dependsOnMethods="Manual2")
	public void arrive() throws BiffException, IOException, InterruptedException{
		
		helper1.clickelementbyXpath(Variables.Visitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchPassumber);
		   helper1.SAP();
		   File src=new File("C://Users//IMA//workspace//ItsMyAccount//VisitorRegistorExcel.xls");
			FileInputStream fis=new FileInputStream(src);
			Workbook wb1=Workbook.getWorkbook(fis);
			Sheet sh1= wb1.getSheet("Sheet4");
			String PassNo=sh1.getCell(0,0).getContents();
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
				SeleniumHelper1.driver.findElement(By.xpath(Variables.OutTime)).clear();
				helper1.SAP();
if(SeleniumHelper1.driver.findElement(By.xpath(Variables.FrequentVisitorradioButton)).isSelected()){
					
		        }
		        else{
		        	helper1.clickelementbyXpath(Variables.FrequentVisitorradioButton);
		            
		        }
				helper1.SAP();
				String Visitor=SeleniumHelper1.driver.findElement(By.id(Variables.visitorname)).getAttribute("value");
				helper1.SAP();
				//System.out.println(Visitor);
				helper1.SAP();
				VisitorName1=Visitor;
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
				}
			
			}
				
				
	}
		
	
	@Test(priority =6,dependsOnMethods="arrive")
	public void Manual3(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("3)---SMS should reach the Member as ARRIVED", true);
	}
	
	
	@Test(priority =7,dependsOnMethods="Manual3")
	public void exit1() throws InterruptedException {
		helper1.clickelementbyXpath(Variables.FrequentVisitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 //System.out.println(VisitorName);
		 
			helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName1);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchFind);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchgridClose);
		   helper1.SAP();
		helper1.clickelementbyXpath(Variables.Visitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 //System.out.println(VisitorName1);
		 
			helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName1);
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
				if(data3.equals(VisitorName1)){
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
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
	}
				
}
		
	}
	
	@Test(priority =8,dependsOnMethods="exit1")
	public void Manual4(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("4)---SMS should reach the Member as LEFT", true);
	}
	
	@Test(priority=9,dataProvider="register1",dependsOnMethods="exit1")
	public void arrived1(String gate, String pass) throws AWTException, InterruptedException{
		
		helper1.clickelementbyXpath(Variables.FrequentVisitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 System.out.println(VisitorName);
		 
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
				coloumn3.get(7).findElement(By.tagName("a")).click();
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
	
	@Test(priority =10,dependsOnMethods="arrived1")
	public void Manual5(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("5)---SMS should reach the Moderator as ARRIVED", true);
	}
	
	@Test(priority =11,dependsOnMethods="Manual5")
	public void exit2() throws InterruptedException{
		helper1.clickelementbyXpath(Variables.Visitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 //System.out.println(VisitorName1);
		 
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
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
	}
				
}
	}
	
	@Test(priority =12,dependsOnMethods="exit2")
	public void Manual6(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("6)---SMS should reach the Moderator as LEFT", true);
	}
	
	@Test(priority =13,dataProvider="register",dependsOnMethods="Manual6")
	public void arrived2(String gate,String passnum) throws AWTException, InterruptedException{
		helper1.clickelementbyXpath(Variables.FrequentVisitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 System.out.println(VisitorName1);
		 
			helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName1);
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
				if(data3.equals(VisitorName1)){
				//coloumn3.get(0).click();
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.ArrivedButton);
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
				helper1.SetValueByID(Variables.gatenum,gate);
				helper1.SAP();
				helper1.SetValueByxpath(Variables.Passnumber,passnum);
				helper1.SAP();
				
			   helper1.clickelementbyXpath(Variables.saveVisitor);
			   helper1.SAP();
			   break;
	}
			
	}
	}
	@Test(priority =14,dependsOnMethods="arrived2")
	public void Manual7(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("7)--SMS should reach the Member as ARRIVED", true);
	}
	@Test(priority =15,dependsOnMethods="Manual7")
	public void exit3() throws InterruptedException{
		helper1.clickelementbyXpath(Variables.Visitor);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.searchgridbtn);
		   helper1.SAP();
		   helper1.clickelementbyXpath(Variables.searchVisitorName);
		   helper1.SAP();
		 //System.out.println(VisitorName1);
		 
			helper1.SAP();
		   helper1.SetValueByxpath(Variables.searchTxtbox1, VisitorName1);
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
				if(data3.equals(VisitorName1)){
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
				helper1.SAP();
				helper1.clickelementbyXpath(Variables.saveVisitor);
				helper1.SAP();
				break;
	}
				
}
	}
	@Test(priority =16,dependsOnMethods="exit3")
	public void Manual8(){
		
		Reporter.log("----------------------------",true);
		Reporter.log("8)--SMS should reach the Member as LEFT", true);
		Reporter.log("***************************************",true);
	}
	
	
	
	@DataProvider(name = "register")
	public Object[][] readexcel2() throws IOException, BiffException {
		File fs = new File("C://Users//IMA//workspace//ItsMyAccount//VisitorRegistorExcel.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Arrived");
		int rows = s.getRows();
		int columns = s.getColumns()-8;
		String inputdata[][] = new String[rows - 4][columns];
		for (int i = 4; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 4][j] = cl.getContents();
				
				
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
		int columns = s.getColumns()-6;
		String inputdata[][] = new String[rows - 4][columns-2];
		for (int i = 4; i < rows; i++) {
			for (int j =2; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 4][j-2] = cl.getContents();
			}
		}
		return inputdata;
	}
}

