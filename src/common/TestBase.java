//========================================================================================
// http://www.hilip.net
//
//	Acts as base class for all the SIA tests. This holds the standard operations to perform any test
//
// Change list:
// 
//========================================================================================

package common;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class TestBase {
		
	protected static MethodsCalling Method=new MethodsCalling();
	protected static VariableCalling2 calling2=new VariableCalling2();
	protected static MethodsCalling2 Method2=new MethodsCalling2();
	protected static MethodCalling3 Method3=new MethodCalling3();
	protected static GlobalVariablesCalling GlobalVariables	=new GlobalVariablesCalling();	
	protected static SeleniumHelper helper = new SeleniumHelper();
	protected static VariableCalling calling = new VariableCalling();
	protected static MethodCalling4 Method4 = new MethodCalling4();
	protected static MethodCalling5 Method5=new MethodCalling5();
	protected static MethodCalling6 Method6=new MethodCalling6();
	protected static MethodCalling7 Method7=new MethodCalling7();
	protected static MethodCalling8 Method8=new MethodCalling8();
	protected static Logger log=Logger.getLogger(TestBase.class.getName());
	//	to perform default operations (login) before executing any test
	@BeforeClass
	public void setUp() throws Exception {
		StaticSetup();
	}
	
	//	to perform default operation (login) through static method
	public static void StaticSetup() throws InterruptedException
	{
		try {
			DOMConfigurator.configure("log4j.xml");
			helper.Init();
			helper.DeepSleep();
			
		} catch (TimeoutException ex) {
			System.out.print(ex.getMessage());
		}
	}

	//	to perform default operations (close) after any test
	@AfterClass
	public void tearDown() throws Exception {
    helper.quit();
	}
}
