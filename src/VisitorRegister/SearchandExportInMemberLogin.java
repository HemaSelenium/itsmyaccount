package VisitorRegister;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.SeleniumHelper1;
import FinanceCommon.TestBase1;
import FinanceCommon.Variables;


public class SearchandExportInMemberLogin extends TestBase1 {
	@Test
	public void FromAndToDate() throws InterruptedException, IOException, HeadlessException, AWTException{
		Reporter.log("Test Script:  VisitorregisterTestingIMA_TC_014",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name: SearchandExportInMemberLogin",true);
		helper1.clickelementbyXpath(Variables.logout);
		helper1.SAP();
		Method.MemberLogin();
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.ApplicationButton);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorRegister);
		helper1.SAP();
		helper1.SetValueByxpath(Variables.VisitorFromDate, Method.PresentdateMinus6());
		helper1.SAP();
		helper1.SetValueByxpath(Variables.VisitorToDate, Method.PresentDate());
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.GetDetails);
		helper1.SAP();
		helper1.PageRefresh();
		helper1.SAP();
		String name=SeleniumHelper1.driver.findElement(By.xpath(Variables.VisitorNameTab)).getText();
		helper1.SAP();
		System.out.println(name);
		helper1.SetValueByID(Variables.Anysearchtxtbox, name);
		helper1.SAP();
		helper1.clickelementsbyid(Variables.Anysearchbtn);
		helper1.SAP();
		helper1.PageRefresh();
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorExport);
		helper1.SAP();
		helper1.clickelementbyXpath(Variables.VisitorExportpdf);
		helper1.SAP();
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File("C:\\Users\\IMA\\workspace\\ItsMyAccount\\VisitorinMemberLogin.png"));
		helper1.SAP();
Reporter.log("Export pdf file of visitor register stored in path:C:\\Users\\IMA\\workspace\\ItsMyAccount\\VisitorinMemberLogin.png",true);
	      helper1.SAP();
          
	}


}
