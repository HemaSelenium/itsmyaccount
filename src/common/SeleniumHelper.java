//========================================================================================
// http://www.hilip.net
//
//	Helper class for all selenium driver operations
//
// Change list:
// 
//========================================================================================
package common;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;
public class SeleniumHelper {
public static WebDriver driver;
public ITestResult result;
public void Init() {
FirefoxProfile profile = new FirefoxProfile();
profile.setPreference("media.navigator.permission.disabled", true);
driver = new FirefoxDriver(profile);
driver.manage().window().maximize();
DeepSleep();
	}
// wait with various timings
	public void MaxSleep() {
		try {
			Thread.sleep(4000);
		} catch (Exception ex) {
		}
	}

	public void DeepSleep() {
		try {
			Thread.sleep(3000);
		} catch (Exception ex) {
		}
	}
public void ClickElementByCssSelector(String selector) throws InterruptedException{
		
	driver.findElement(By.cssSelector(selector)).click();
	Thread.sleep(4000);	
	}

	public void Sleep() {
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {

		}
	}

	public void Nap() {
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {

		}
	}

	// Get object value using various options
	public String GetValueByID(String id) {
		return driver.findElement(By.id(id)).getText();
	}

	public String GetValueByXpath(String id) {
		return driver.findElement(By.xpath(id)).getText();
	}

	public String getCssValue(String id, String attr) {
		return driver.findElement(By.id(id)).getCssValue(attr);
	}

	public ArrayList<String> GetOptionsByID(String ID) {
		ArrayList<String> options = new ArrayList<String>();
		WebElement Item = driver.findElement(By.id(ID));
		if (Item.isDisplayed()) {
			List<WebElement> Options = Item.findElements(By.tagName("option"));
			for (WebElement current : Options) {
				options.add(current.getText());
			}
		}
		return options;
	}

	// Click event for object using various options
	public void ClickByID(String id) {
		driver.findElement(By.id(id)).click();
		Nap();
	}

	public void ClickByPartialText(String id) {
		driver.findElement(By.partialLinkText(id)).click();
		Nap();
	}
	

	public void ClickByLinkText(String id) {
		driver.findElement(By.linkText(id)).click();
		Nap();
	}

	public void ClickByCSSSelector(String id) {
		driver.findElement(By.cssSelector(id)).click();
		Nap();
	}

	public void ClickByXpath(String id) {

		
		
		driver.findElement(By.xpath(id)).click();
		Nap();
	}

	// navigating between windows
	public String SwitchToLastWindow() {
		String[] wins = driver.getWindowHandles().toArray(new String[0]);
		String target = wins[wins.length - 1];
		driver.switchTo().window(target);
		return wins[0];
			}

	public void SwitchToPrevWindow(String target) {
		driver.switchTo().window(target);
	}

	public void Navigate(String url) {
		driver.get(url);
		DeepSleep();
	}

	// set values for components
	private void SetValue(WebElement elm, String data) {
		elm.clear();
		elm.click();
		elm.sendKeys(data);
	}
	public String GetCurrentMonth(){
		Calendar c = Calendar.getInstance();
	    String CurrentMonth=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH ) ;
	    return CurrentMonth;
	}

	// set values for components
	public void SetValue1(String ID, String data) {
		WebElement elm = driver.findElement(By.id(ID));
		elm.sendKeys(data);
	}

	public void SetValueByID(String id, String data) {
		SetValue(driver.findElement(By.id(id)), data);
		Nap();
	}
	
	public void SetValueByname(String id, String data) {
		SetValue(driver.findElement(By.name(id)), data);
		Nap();
	}
	
	

public void SetValueByXpath(String id, String data) {
SetValue(driver.findElement(By.xpath(id)), data);
Nap();
}
public void ClickOnTabButton(String id){
driver.findElement(By.id(id)).sendKeys(Keys.TAB);
}

	public void SetDropDownValue(String id, String data) {
		new Select(driver.findElement(By.id(id))).selectByVisibleText(data);
		Sleep();
	}
	public void SelectElementFromDroapDownList(String xpath,String value){
		
	}
	
	
	
	

	// check if an object exists
	public boolean IsExistsByID(String ID) {
		return driver.findElements(By.id(ID)).size() != 0;
	}

	public boolean IsSelectedByID(String ID) {
		return driver.findElement(By.id(ID)).isSelected();
	}

	public boolean isDisplayed(String ID) {
		return driver.findElement(By.id(ID)).isDisplayed();
	}

	// close browser
	public void quit() {
		driver.quit();
	}

	public void ExecuteScript(String script) {
		((JavascriptExecutor) driver).executeScript(script);

	}
public String ProcessAlert() throws InterruptedException {
Alert alert = driver.switchTo().alert();
String msg = alert.getText();
Reporter.log("Message popup Came As ---> " +msg, true);
alert.accept();
driver.switchTo().defaultContent();
return msg;

	}
	public void dropdown() {
		Select dropdown = new Select(driver.findElement(By.id("BlockID")));

		Nap();
		dropdown.selectByIndex(1);
		Nap();
	}
	
	
public void RefreshPage() throws InterruptedException{
	driver.navigate().refresh();
	Thread.sleep(4000);
}
	

public void File2() {
driver.findElement(By.name("fileinput")).sendKeys("F:\\h.txt");
}

public void TakeScreenShot(String FileName) throws IOException{
File scrFile = ((TakesScreenshot) SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrFile,new File(GlobalVariablesCalling.ScreenShotsFileName + FileName +".png"));
}
public void TakeScreenShotOfExportPDF(String FileName ) throws IOException, HeadlessException, AWTException{
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+ FileName +".png"));
}
public void TakeScreenShotOfWindowPopUp(String FileName ) throws IOException, HeadlessException, AWTException{
BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
ImageIO.write(image, "png", new File(GlobalVariablesCalling.ScreenShotsFileName+ FileName +".png"));
}

public void backpage() {
driver.navigate().back();
}

	

	public void action() {
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath(".//*[@id='1']/td[2]/a"))).build().perform();
	}

	

	public void clearFromTime() throws InterruptedException {
		driver.findElement(By.id("FromTime")).clear();
		Thread.sleep(10);

	}

	public void clearToTime() throws InterruptedException {
		driver.findElement(By.id("ToTime")).clear();
		Thread.sleep(10);
	}

	public void clearToDate() throws InterruptedException {
		driver.findElement(By.id("ToDate")).clear();
		Thread.sleep(10);
	}
	public void clearFromDate() throws InterruptedException {
		driver.findElement(By.id("FromDate")).clear();
		Thread.sleep(10);
	}

	public void Getcss() throws InterruptedException {
		driver.findElement(By.id("1014")).getCssValue("color");
		Thread.sleep(10);

	}

	public void clearhours() throws InterruptedException {
		driver.findElement(By.id("M1")).clear();
		Thread.sleep(20);
	}

	public void clearamount() throws InterruptedException {
		driver.findElement(By.id("Amt1")).clear();
		Thread.sleep(20);
	}

	public void SelectTypeOfDueDate() throws InterruptedException {
		Select DueDate = new Select(driver.findElement(By.id("TypeOfDueDate")));
		Thread.sleep(20);
		DueDate.selectByVisibleText("End Of month");
	}

	

	public void blockselection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('BlockID').style.display='block';");

		// Then Select required value
		Select dropdown = new Select(driver.findElement(By.id("BlockID")));
		dropdown.selectByVisibleText(GlobalVariablesCalling.EnterMemberBlockName);
		
	}
	
	

	public void apartmentselection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('ApartmentID').style.display='block';");

		// Then Select required value
		Select apartment = new Select(driver.findElement(By.id("ApartmentID")));
		apartment.selectByVisibleText(GlobalVariablesCalling.EnterMemberApartmentNumber);
	}

	public void amountclear() {
		driver.findElement(By.id("BA1")).clear();
	}

	public void doubleclick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		
	}
	public void ClearElementById(String id) {
		// TODO Auto-generated method stub
		driver.findElement(By.id(id)).clear();
		Nap();
	}
	public void ClearElementByname(String id) {
		// TODO Auto-generated method stub
		driver.findElement(By.name(id)).clear();
		Nap();
	}
	
	

	}
	
