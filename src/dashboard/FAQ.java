package dashboard;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class FAQ extends TestBase{
@Test(priority=1)
public void Login() throws Exception{
Reporter.log("Script Name:Admin---->Dashboard--->FAQ", true);
Reporter.log("--------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
helper.ClickByID(VariableCalling.SelectTermsAndConditions);
helper.ClickByXpath(VariableCalling.LoginButton);
} 
@Test(priority=2)
public void FrequentlyAskedQuestions() throws InterruptedException, IOException{
helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
helper.DeepSleep();
helper.ClickByLinkText(VariableCalling.ClickOnFAQButton);
helper.DeepSleep();
helper.SetValueByID(VariableCalling.SearchField, VariableCalling.EnterTextIntoSearchField);
helper.ClickByID(VariableCalling.ClickOnGoButton);
Thread.sleep(3000);
File FAQ=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(FAQ, new File(GlobalVariablesCalling.ScreenShotsFileName+"FAQHomePage.png"));
SeleniumHelper.driver.navigate().refresh();
Thread.sleep(4000);
WebElement FAQs=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingALLFAQs));
List<WebElement>ListOfFAQ= FAQs.findElements(By.tagName(VariableCalling2.LocatingOneFAQ));
ListOfFAQ.get(ListOfFAQ.size()-1).findElement(By.tagName(VariableCalling2.ClickOnPerticularQuestion)).click();
Thread.sleep(2000);
File FAQDescription=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(FAQDescription, new File(GlobalVariablesCalling.ScreenShotsFileName+"FAQDescription.png"));
WebElement FAQS=SeleniumHelper.driver.findElement(By.id("allfaq")).findElement(By.tagName("ul"));
List<WebElement> TopicsRelatedToFAQ=FAQS.findElements(By.tagName(VariableCalling2.LocatingOneFAQ));
TopicsRelatedToFAQ.get(3).findElement(By.tagName("a")).click();
String FAQRelatedToOneTopic=TopicsRelatedToFAQ.get(3).findElement(By.tagName("a")).getText();
Reporter.log("Searching FQA Related To : "+FAQRelatedToOneTopic, true);
File FAQOfOneTopic=((TakesScreenshot)SeleniumHelper.driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(FAQOfOneTopic, new File(GlobalVariablesCalling.ScreenShotsFileName+"FAQOfOneTopic.png"));
Reporter.log(" ", true);
Reporter.log("Files Stored in (Path Name)", true);
Reporter.log("-----------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FAQHomePage.png", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FAQOfOneTopic.png" , true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FAQDescription.png", true);
Reporter.log(" ", true);
	}

}
