package FinanceCommon;

import java.util.logging.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase1 {
	protected static MethodsCalling Method=new MethodsCalling();
	protected static Variables calling2=new Variables();
	protected static MethodsCalling Method2=new MethodsCalling();
	
	
	protected static SeleniumHelper1 helper1 = new SeleniumHelper1();

	protected static Logger log=Logger.getLogger(TestBase.class.getName());
//		to perform default operations (login) before executing any test
	@BeforeClass
	public void setUp() throws Exception {
	StaticSetup();
	}

//		to perform default operation (login) through static method
	public static void StaticSetup() throws InterruptedException
	{
	try {
	//DOMConfigurator.configure("log4j.xml");
	helper1.init();
	helper1.sleep();

	} catch (TimeoutException ex) {
	System.out.print(ex.getMessage());
	}
	}

//		to perform default operations (close) after any test
	@AfterClass
	public void tearDown() throws Exception {
	   helper1.quit();
	}
}