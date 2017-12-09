package myfinance;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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


public class BookingFacilityFor1000_01 extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
		BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	
	protected static FinanceVariables fin=new FinanceVariables();
	String voucherno=null;

	@Test(priority = 1)
	public void ScriptName() throws InterruptedException, IOException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_001",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Facility Booking",true);
		helper1.SAP();
		
	}

	@Test(priority = 2)
	public void UserLogin()
			throws InterruptedException, IOException {
		method.userLoginWithScreenShotsBeforeProcess1();
		helper1.SAP();
	}

	@Test(priority = 3)
	public void logout() throws InterruptedException {
		ldr.logout();
		helper1.SAP();
	}

	@Test(priority = 4)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();
		
	}

	@Test(priority = 5, dataProvider = "AddFacility",dependsOnMethods="Login")
	public void AddFacility(String facilityname, String contactperson, String contactnumber, String hour,String amount, String days) throws BiffException, InterruptedException, IOException
			{
		help1.Addfacility( facilityname, contactperson, contactnumber, hour, amount, days);
		helper1.SAP();	
		
	}

	@Test(priority = 6, dataProvider = "BookFacility",dependsOnMethods="AddFacility")
	public void Bookfacility(String Facilityname, String Fromdateid,String FromTime, String Todateid,
			String ToTime,String Description)
			throws BiffException, InterruptedException, IOException {
		help1.BookFacility(Facilityname,Fromdateid,  FromTime,Todateid,ToTime,Description);
		helper1.SAP();
	}

	@Test(priority = 7,dependsOnMethods="Bookfacility")
	public void FIGvoucherno() throws InterruptedException, BiffException, IOException {
		
	voucherno = help1.ToGetGeneratedVoucherno();
	helper1.SAP();
	


	}
	
	@Test(priority = 8,dependsOnMethods="FIGvoucherno")
	public void MemberReports() throws InterruptedException{
		
		help1.MemberReports( voucherno);
		helper1.SAP();
		
	}
	
	
	@Test(priority = 9,dependsOnMethods="MemberReports")
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GettingFacilityHeaderReferenceof1000);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("Payment", 0);
		
		Label sheetcontent1 = new Label(0,0,voucherno);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}

	

	@Test(priority = 10,dependsOnMethods="writeVoucherno")
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
		File fs = new File(FinanceGlobalVariables.FacilityBookingFor1000);
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
		File fs = new File(FinanceGlobalVariables.FacilityBookingFor1000);
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
	
	
