package FinanceCommon;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

public class TestBase {
	public static WebDriver driver;
	protected static MethodsCalling method=new MethodsCalling();
	
	protected static SeleniumHelper1 helper1 = new SeleniumHelper1();
	protected static Variables var=new Variables();
	
	@BeforeClass
public void setup() throws InterruptedException{
	
	StaticSetup();	
}
public static void StaticSetup() throws InterruptedException {
	try
	{
		method.Init();
		
	
	
	}
	catch(TimeoutException ex){
		System.out.println(ex.getMessage());
		
}
}

@AfterClass
public void tearDown() throws Exception {
  method.quit();
  Thread.sleep(2000);
}
}