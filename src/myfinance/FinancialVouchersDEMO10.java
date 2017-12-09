package myfinance;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FinancialVouchersDEMO10 extends FinancialVouchersHelp {
	
	public Object[][] Payment(WebDriver driver, String voucherno)
			throws InterruptedException, BiffException, IOException {
		
		String splitmessage[][] = new String[1][1];
		Thread.sleep(4000);
		File fs = new File("C:\\Users\\IMA\\Desktop\\Seleniumvariables1.xls");
		Workbook ws = Workbook.getWorkbook(fs);
		Sheet s = ws.getSheet("Payment");
		int rows = s.getRows();
		int columns = s.getColumns();
		String inputdata[][] = new String[rows - 1][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cl = s.getCell(j, i);
				inputdata[i - 1][j] = cl.getContents();
			}
		}
		for (int i = 0; i < rows - 1; i++) {
			String url = inputdata[i][0];
			String dateid = inputdata[i][1];
			String Block = inputdata[i][2];
			String Flatno = inputdata[i][3];
			String naration = inputdata[i][4];
			driver.navigate().to(url);
			Thread.sleep(4000);
			driver.findElement(By.id("Payment")).click();
			Thread.sleep(4000);
			setDate(driver,dateid,2016,10,16);
			driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[1]/div/a/i")).click();
			Thread.sleep(4000);
			driver.findElement(By.linkText(Block)).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[2]/div[2]/div/a/i")).click();
			// *[@id='Payment']/div/div/div[2]/div[2]/div[2]/div/a/i
			Thread.sleep(4000);
			driver.findElement(By.linkText(Flatno)).click();
			Thread.sleep(4000);
			driver.findElement(By.id("Go")).click();
			Thread.sleep(4000);
			WebElement paymenttable = driver.findElement(By.xpath(".//*[@id='Payment']/div/div/div[2]/div[4]/table/tbody"));
			// *[@id='Payment']/div/div/div[2]/div[4]/table/tbody
			// *[@id='Payment']/div/div/div[2]/div[3]/table/tbody
			List<WebElement> rows1 = paymenttable.findElements(By.tagName("tr"));
			int rowscount = rows1.size();
			for (rowscount = 1; rowscount < rows1.size(); rowscount++) {
				List<WebElement> columns1 = rows1.get(rowscount).findElements(By.tagName("td"));
				String rowvalue = columns1.get(1).getText();
				if (rowvalue.equals(voucherno)) {
					System.out.println("Paying amount for the voucher: " + voucherno);
					columns1.get(0).findElement(By.tagName("input")).click();
					break;
				}
			}
			Thread.sleep(4000);
			driver.findElement(By.id("Narration")).sendKeys(naration);
			Thread.sleep(4000);
			driver.findElement(By.id("btnpay")).click();
			Thread.sleep(4000);
			Alert alert = driver.switchTo().alert();
			Thread.sleep(4000);
			String message3 = alert.getText();
			Thread.sleep(4000);
			System.out.println(message3);
			splitmessage[0][0] = message3.split(" ")[1];
			Thread.sleep(4000);
			System.out.println("Generated Payment Receipt no: " + splitmessage[0][0]);
			alert.accept();
			Thread.sleep(2000);

		}
		return splitmessage;
	}
	
	public void setDate(WebDriver driver,String id,int year,int month,int day) throws InterruptedException{
		//System.out.println("setDate");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date datespecified = c.getTime();
		driver.findElement(By.id(id)).clear();
		Thread.sleep(2000);
		driver.findElement(By.id(id)).sendKeys(df.format(datespecified));
		Thread.sleep(2000);
	}

}
