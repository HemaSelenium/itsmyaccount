package dashboard;
import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class autotext {
	@Test
	public void textcomplete() throws InterruptedException, AWTException{
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.google.co.in");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.name("q")).sendKeys("h");
	Thread.sleep(3000);
	WebElement table=driver.findElement(By.xpath(".//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul"));
	List<WebElement>values=table.findElements(By.tagName("li"));
	System.out.println(values.size());
	//String[] ttt=values.toArray(new String[0]);
	for(int k=0;k<values.size();k++){
	String listofdata=values.get(k).findElement(By.xpath(".//*[@role='option']/div[2]/b")).getText();
	System.out.println(listofdata);
	String value="h"+listofdata;
	System.out.println(value);
	if(value.equals("hotstar")){
	System.out.println("text found");	
	Thread.sleep(4000);
	values.get(k).findElement(By.xpath(".//*[@role='option']/div[2]/b")).click();
	Thread.sleep(4000);
	break;
	}
		
	}
	
		
		
	}
		
	
	

}
