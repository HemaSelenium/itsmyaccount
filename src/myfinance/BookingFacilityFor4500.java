package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.TestBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class BookingFacilityFor4500 extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersDEMO10();
	 protected static FinanceVariables fin=new FinanceVariables();
	 
	String voucherno=null;
	
	
	@Test(priority = 1)
	public void ScriptName() {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_012",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Facility Booking for 4500",true);
	}

	

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority =3 , dataProvider = "AddFacility",dependsOnMethods="Login")
	public void AddFacility(String facilityname, String contactperson, String contactnumber, String hour,String amount) throws BiffException, InterruptedException, IOException
			{
			
		help1.Addfacility1(facilityname, contactperson, contactnumber, hour, amount);
		helper1.SAP();	
		
	}

	
	@Test(priority = 4, dataProvider = "BookFacility",dependsOnMethods="AddFacility")
	public void Bookfacility(String Facilityname, String Fromdateid,String FromTime, String Todateid,
			String ToTime,String Description)
			throws BiffException, InterruptedException, IOException, HeadlessException, AWTException {
		help1.BookFacility1(Facilityname,Fromdateid,  FromTime,Todateid,ToTime,Description);
		helper1.SAP();
	}
	
	@Test(priority = 5,dependsOnMethods="Bookfacility")
	public void FIGvoucherno() throws InterruptedException, BiffException, IOException {
		helper1.SAP();
	voucherno = help1.ToGetGeneratedVoucherno1();
	helper1.SAP();
	//System.out.println(voucherno);
	
	
	}
	@Test(priority = 6,dependsOnMethods="FIGvoucherno")
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		
		
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GettingHeaderReferenceForFacility4500);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("Payment", 0);
		
		Label sheetcontent1 = new Label(0,0,voucherno);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}
	
	@Test(priority = 7,dependsOnMethods="writeVoucherno")
	public void ManualChecking() {
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);

	}
	

	@DataProvider(name = "AddFacility")
	public Object[][] readexcel1() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.FacilityBookingFor4500);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("AddFacility");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows - 1][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 1][j] = cl.getContents();
			}
		}
		return inputdata;
	}

	@DataProvider(name = "BookFacility")
	public Object[][] readexcel2() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.FacilityBookingFor4500);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("BookFacility");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows - 1][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 1][j] = cl.getContents();
			}
		}
		return inputdata;
	}
	
	

}
