package FinanceCommon;



import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.sql.Driver;
//import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Reporter;

public class SeleniumHelper1 extends TestBase1 {
	public static WebDriver driver;
	public void init() throws InterruptedException{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("media.navigator.permission.disabled", true);
		driver = new FirefoxDriver(profile);
	 
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
   SeleniumHelper1.driver.get(Variables.url);
		Thread.sleep(4000);
		SeleniumHelper1.driver.findElement(By.id("UserName")).sendKeys(Variables.userid);
		SeleniumHelper1.driver.findElement(By.id("Password")).sendKeys(Variables.password);
		Thread.sleep(4000);
		SeleniumHelper1.driver.findElement(By.xpath(Variables.condition)).click();
		SeleniumHelper1. driver.findElement(By.xpath(Variables.logbtn)).click();
		Thread.sleep(4000);
		
		
		
	}
	public void quit(){
		driver.quit();
	
	}
	/*public void navigate(String URl ) throws InterruptedException{
		driver.get(URl);
		Thread.sleep(4000);
	}*/
	public void SetValueByID(String id,String Value) {
		 driver.findElement(By.id(id)).sendKeys(Value);
	}
	public void SetValueByxpath(String xpath,String Value){
		driver.findElement(By.xpath(xpath)).sendKeys(Value);
	}
public void clickelementbyXpath(String xpath){
	driver.findElement(By.xpath(xpath)).click();
}
public void clickelementsbyid(String id){
	driver.findElement(By.id(id)).click();
}
public void sleep(){
	try{
		Thread.sleep(3000);
	}
	catch (Exception ex){
		
	}
}
public void NAP(){
	try{
		Thread.sleep(1000);
	}
	catch (Exception ex){
}

}

public void SAP(){
	try{
		Thread.sleep(4000);
	}
	catch (Exception ex){
}
}
public void PageRefresh() throws InterruptedException{
	driver.navigate().refresh();
	Thread.sleep(4000);
}
public void ScreenShot(String Filename) throws IOException{
	 File scrFile= ((TakesScreenshot)SeleniumHelper1.driver).getScreenshotAs(OutputType.FILE);
     
     FileUtils.copyFile(scrFile,new File(Filename));
     
     
}
public void log() throws InterruptedException  {
	driver.findElement(By.id("UserName")).sendKeys(Variables.memuserid);
	driver.findElement(By.id("Password")).sendKeys(Variables.mempwd);
	Thread.sleep(4000);
	driver.findElement(By.xpath(Variables.condition)).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath(Variables.logbtn)).click();
	}
public void handlingalert(){
	Alert simple=SeleniumHelper1.driver.switchTo().alert();
		
	
		simple.accept();
}
public void bufferscreenshot(String Filename) throws IOException,HeadlessException,AWTException{
	
       // Robot robot = new Robot();
        
        
		BufferedImage screenShot = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write( screenShot, "png", new File(Variables.sourcepath+Filename+".png"));
         
       
    
    }
public void UploadImage() throws AWTException{
	 StringSelection ss = new StringSelection("C:\\Users\\IMA\\Downloads\\IMA Wallpaper");
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss); //copy the above string to clip board     
     Robot robot;
     robot = new Robot();
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     robot.delay(2000); 
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_CONTROL); //paste the copied string into the dialog box
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
helper1.SAP();
}
}



