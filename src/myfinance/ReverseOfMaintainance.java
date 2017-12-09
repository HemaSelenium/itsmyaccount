package myfinance;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReverseOfMaintainance {
	WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	
	
	
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();
	
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		ldr.adminlogin();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2,dataProvider = "payment")
	public void advance(String voucherno3 ) throws InterruptedException, BiffException, IOException {
		help2.ReversalOfMaintainanceadvance();
		Thread.sleep(8000);
		WebElement reversaltable = driver.findElement(By.xpath(".//*[@id='Grid1']/tbody"));
		Thread.sleep(8000);
		int rowcount = reversaltable.findElements(By.tagName("tr")).size();
		Thread.sleep(8000);
		loop1: for (int i = 1; i < rowcount; i++) {
			String rowID = i + "";
			// List<WebElement> rows =
			// reversaltable.findElement(By.xpath(".//*[@id='Grid1']/tbody")).findElements(By.id(rowID));
			List<WebElement> rows1 = reversaltable.findElements(By.id(rowID));
			Thread.sleep(5000);
			String rowdata = rows1.get(0).findElements(By.tagName("td")).get(6).getText();
			System.out.println(rowdata);
			System.out.println(123);
			
			if (rowdata.equals(voucherno3)) {
				System.out.println(123);
				System.out.println(voucherno3);
				rows1.get(0).findElements(By.tagName("td")).get(6).click();
				driver.findElement(By.id("Reason")).sendKeys("Reversing advance amount of facility booking");
				driver.findElement(By.id("Generate")).click();
				Alert alert = driver.switchTo().alert();
				String message = alert.getText();
				 String advancevoucherno1 = message.split(" ")[3];
				System.out.println("Reverse advance voucher no: " + advancevoucherno1);
				alert.accept();
				break loop1;
		
	}

		}
	}
	
	@DataProvider(name = "payment")
	public Object[][] readexcel4() throws IOException, BiffException {
		File fs = new File("C:\\Users\\IMA\\Desktop\\AdvancePayments1.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Advance2");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows][columns];
		System.out.println(rows);
		System.out.println(columns);
		
				Cell cl = s.getCell(0, 0);
				inputdata[0][0] = cl.getContents();
		
		return inputdata;
	}

}



