package myfinance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
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

public class AdvancePaymentForMaintainance extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	String advancevoucherno4;
	
	
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();
	
	
	@Test(priority = 1)
	public void ScriptName() {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_009",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Advance payment for Maintainance",true);
	}

	
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		helper1.SAP();	
	}
	
	@Test(priority = 3,dataProvider = "Advance",dependsOnMethods="Login")
	public void advance(String amount) throws InterruptedException, BiffException, IOException {
		advancevoucherno4=help2.AdvancePaymentforMaintainance(amount);
		//System.out.println(advancevoucherno4);
		helper1.SAP();
	}
	
	@Test(priority = 4,dependsOnMethods="advance")
	public void writeVoucherno()
			throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException {
		/*help1.writeVoucherno(voucherno);
		Thread.sleep(12000);*/
		
		FileOutputStream file = new FileOutputStream(FinanceGlobalVariables.GettingHeaderReferenceForMaintainanceAdvance);
		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sheet = wb.createSheet("Advance2", 0);
		
		Label sheetcontent1 = new Label(0,0,advancevoucherno4);
	
		sheet.addCell(sheetcontent1);
		wb.write();
		wb.close();
	}
	
	@Test(priority = 5,dependsOnMethods="writeVoucherno")
	public void ManualChecking() {
		Reporter.log("Items to be checked Manually");
		Reporter.log("----------------------------");
		Reporter.log("SMS Status");
		Reporter.log("Email Status");
		Reporter.log("Soft copy in Email");
		Reporter.log("Check DayBookEntry");
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports");
		

	}
	@DataProvider(name = "Advance")
	public Object[][] readexcel2() throws IOException, BiffException {
		File fs = new File(FinanceGlobalVariables.Advance);
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("maintainance");
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
