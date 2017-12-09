package dashboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;

public class uploadfile extends TestBase{
	
	@Test
		public void Contactus() throws AWTException {
			
			
			
		helper.Navigate(GlobalVariablesCalling.EnterUrl);
		helper.SetValue1("UserName", GlobalVariablesCalling.EnterAdminUserId);
		helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
		helper.ClickByID(VariableCalling.SelectTermsAndConditions);
		helper.ClickByXpath(VariableCalling.LoginButton);
		helper.ClickByID(VariableCalling.ClickOnContactIMAHelpDeskButton);
		helper.ClickByID("file_select");
		
		
		
		String text = "F:\\h.txt";
	    StringSelection stringSelection = new StringSelection(text);
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(stringSelection, stringSelection);
	Robot r=new Robot();
	    
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    helper.MaxSleep();
	    helper.MaxSleep();
		
		
	}}


