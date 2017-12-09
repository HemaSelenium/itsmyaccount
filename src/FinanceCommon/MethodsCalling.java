package FinanceCommon;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class MethodsCalling {
	protected static FinanceVariables fin=new FinanceVariables();
	protected static MethodsCalling method=new MethodsCalling();
	 int numberOfPixelsToDragTheScrollbarDown = 50;
	String UserId;
	 String PassWord;
	 public static WebDriver driver;
	 public void Init(){
		 driver = new FirefoxDriver();
	 }
	 public void quit(){
		 driver.quit();
	 }
	
	public void attachfile(){
		JavascriptExecutor js= (JavascriptExecutor) SeleniumHelper1.driver;
		js.executeScript("document.getElementById('fileinput').style.display='block';");
		SeleniumHelper1.driver.findElement(By.id("fileinput")).sendKeys(Variables.AttachFileInput);		
		js.executeScript("document.getElementById('fileinput').style.display='none';");
		
	}

	public String getuserid() throws InterruptedException{
		SeleniumHelper1.driver.get("https://www.gmail.com");
		
	SeleniumHelper1.driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("pragnashree.ps@gmail.com");
Thread.sleep(2000);
SeleniumHelper1.driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		
Thread.sleep(2000);

SeleniumHelper1.driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("pragna1234");
		
Thread.sleep(2000);
SeleniumHelper1.driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();

		
		
       
Thread.sleep(2000);
        
        
		List<WebElement> unread = SeleniumHelper1.driver.findElements(By.xpath("//*[@class='zF']"));
		String Mymailer="ItsMyAccount - Admin";
		for(int i=0;i<unread.size();i++){
		    if(unread.get(i).isDisplayed()==true)
		    {
		    	if(unread.get(i).getText().equals(Mymailer)){
		            System.out.println("Yes we have got mail form " + Mymailer);
		           Thread.sleep(2000);
		            String SubjectInMail= unread.get(i).findElement(By.xpath("//*[@class='y6']/span/b")).getText();        
		            String Subject ="Your credentials to access ItsMyAccount.com" ;
		            if(SubjectInMail.equals(Subject)){
		            System.out.println("Yes we have got mail form " + Mymailer+ "  With Subject Of "  +SubjectInMail);
		            Thread.sleep(2000);
		            String MessageInMail=unread.get(i).findElement(By.xpath("//*[@class='y6']/span[2]")).getText();   
		            UserId = MessageInMail.split(" ")[7];
		            Reporter.log("User Id : "+UserId, true);
		            unread.get(i).findElement(By.xpath("//*[@class='y6']/span[2]")).click();
		            }else{
		            System.out.println("No mail form " + Mymailer+ "With Subject Of "+SubjectInMail);
		            }
		            
		            
		            break;
		            }else{
		            System.out.println("No mail form " + Mymailer);
		            }
		    }
		}
		return UserId ;
		
	}
	public String getpassword() throws InterruptedException{
		
		
		
				
		List<WebElement> unread = SeleniumHelper1.driver.findElements(By.xpath("//*[@class='zF']"));
		String Mymailer="ItsMyAccount - Admin";
		for(int i=0;i<unread.size();i++){
			System.out.println(unread.size());
		    if(unread.get(i).isDisplayed()==true)
		    {
		    	if(unread.get(i).getText().equals(Mymailer)){
		            System.out.println("Yes we have got mail form " + Mymailer);
		         
		            String SubjectInMail= unread.get(i).findElement(By.xpath("//*[@class='y6']/span/b")).getText();        
		            String Subject ="Your credentials to access ItsMyAccount.com" ;
		            if(SubjectInMail.equals(Subject)){
		            System.out.println("Yes we have got mail form " + Mymailer+ "  With Subject Of "  +SubjectInMail);
		            
		            String MessageInMail=unread.get(i).findElement(By.xpath("//*[@class='y6']/span[2]")).getText(); 
		            Thread.sleep(4000);
		           PassWord = MessageInMail.split(":")[2];
		            Reporter.log("password : "+PassWord, true);
		            unread.get(i).findElement(By.xpath("//*[@class='y6']/span[2]")).click();
		            }else{
		            System.out.println("No mail form " + Mymailer+ "With Subject Of "+SubjectInMail);
		            }
		            break;
		            }
		    	else
		    	{
		            System.out.println("No mail form " + Mymailer);
		            }
		    }
		}
		return PassWord;
		
	}
	public String getresetpassword() throws InterruptedException{
		
		
		
		
		List<WebElement> unread = SeleniumHelper1.driver.findElements(By.xpath("//*[@class='zF']"));
		String Mymailer="ItsMyAccount - Admin";
		for(int i=0;i<unread.size();i++){
			System.out.println(unread.size());
		    if(unread.get(i).isDisplayed()==true)
		    {
		    	if(unread.get(i).getText().equals(Mymailer)){
		            System.out.println("Yes we have got mail form " + Mymailer);
		         
		            String SubjectInMail= unread.get(i).findElement(By.xpath("//*[@class='y6']/span/b")).getText();        
		            String Subject ="Your credentials to access ItsMyAccount.com" ;
		            if(SubjectInMail.equals(Subject)){
		            System.out.println("Yes we have got mail form " + Mymailer+ "  With Subject Of "  +SubjectInMail);
		            
		            String MessageInMail=unread.get(i).findElement(By.xpath("//*[@class='y6']/span[2]")).getText(); 
		            Thread.sleep(4000);
		           PassWord = MessageInMail.split(":")[1];
		            Reporter.log("password : "+PassWord, true);
		            unread.get(i).findElement(By.xpath("//*[@class='y6']/span[2]")).click();
		            }else{
		            System.out.println("No mail form " + Mymailer+ "With Subject Of "+SubjectInMail);
		            }
		            break;
		            }
		    	else
		    	{
		            System.out.println("No mail form " + Mymailer);
		            }
		    }
		}
		return PassWord;
		
	}
	public void scroll(){
		JavascriptExecutor jse = (JavascriptExecutor)SeleniumHelper1.driver;
		jse.executeScript("arguments[0].scrollTop = arguments[1];",SeleniumHelper1.driver.findElement(By.xpath(".//*[@id='gview_erGrid']/div[3]")), 2000);
		
	}
	
public void MemberLogin() throws InterruptedException{
	SeleniumHelper1.driver.findElement(By.id(FinanceVariables.UsernameId)).sendKeys(Variables.MemberUserid);
	Thread.sleep(2000);
	SeleniumHelper1.driver.findElement(By.id(FinanceVariables.PasswordId)).sendKeys(Variables.MemberPassword);
	Thread.sleep(2000);
	SeleniumHelper1.driver.findElement(By.id(FinanceVariables.TermsAndConditions)).click();
	Thread.sleep(2000);
	SeleniumHelper1.driver.findElement(By.id(FinanceVariables.SignIn)).click();
	Thread.sleep(2000);
}
public void AdminLogin() throws InterruptedException{
	SeleniumHelper1.driver.findElement(By.id("UserName")).sendKeys(Variables.userid);
	SeleniumHelper1.driver.findElement(By.id("Password")).sendKeys(Variables.password);
	Thread.sleep(4000);
	SeleniumHelper1.driver.findElement(By.xpath(Variables.condition)).click();
	SeleniumHelper1. driver.findElement(By.xpath(Variables.logbtn)).click();
	Thread.sleep(4000);
	
}

	public String PresentDate(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, 0);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		return startDate;
	}
	
	
	public String StartingDateOfMonth(){
		Calendar c = Calendar.getInstance(); 
		c.set(Calendar.DAY_OF_MONTH, 1); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
		
	}
	public String StartingDatePlus12(){
		Calendar c = Calendar.getInstance(); 
		//c.add(field, amount);
		c.set(Calendar.DAY_OF_MONTH, 13); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDateplus12=df.format(c.getTime());
		
		
		return startDateplus12;
		
	}
	public String StartingDatePlus10(){
		Calendar c = Calendar.getInstance(); 
		c.set(Calendar.DAY_OF_MONTH, 10); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDateplus12=df.format(c.getTime());
		
		
		return startDateplus12;
		
	}
	
	public String StartingDateOfMonthplus1(){
		Calendar c = Calendar.getInstance(); 
		//c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 2); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String StartingDateOfMonthplus14(){
		Calendar c = Calendar.getInstance(); 
		//c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String Presentdateplus12(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, 12);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String Presentdateplus13(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, 13);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	
	public String StartingDateOfMonthplus12(){
		Calendar c = Calendar.getInstance(); 
		//c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 13); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String StartingDateOfMonthplus10(){
		Calendar c = Calendar.getInstance(); 
		//c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 11); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String StartingDateOfMonthplus2(){
		Calendar c = Calendar.getInstance(); 
		//c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 3); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String StartingDateOfMonthplus2plus10(){
		Calendar c = Calendar.getInstance(); 
		//c.add(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 13); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	
	public String PresentdateMinus5(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, -5);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String PresentdateMinus6(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, -6);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String NextFinancialYearDate(){
		String input = "05-04-2017";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd-MM-yyyy" );
		LocalDate localDate = LocalDate.parse ( input,formatter );
		LocalDate yearLater = localDate.plusYears ( 1 );
		String llll=formatter.format(yearLater);
		System.out.println ( "localDate: " + localDate + " and yearLater: " + yearLater );
	//System.out.println(llll);
		return llll;
	
	
	
	
	
}
	public String NextFinancialFromYear(){
		 int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financiyalYearFrom="";
		 if(CurrentYear>=2017)
		    {
		        financiyalYearFrom="01-04-"+(CurrentYear+1);
		        System.out.println(financiyalYearFrom);
		    }
		return financiyalYearFrom;
		 
	
	
}
	public String NextFinancialtoYear(){
		 int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financialYearTo="";
		 if(CurrentYear>=2017)
		    {
		        financialYearTo="31-03-"+(CurrentYear+2);
		        System.out.println(financialYearTo);
		    }
		return financialYearTo;
		 
	
	
}
	public String PreviousYear(){
		Calendar cal = Calendar.getInstance();

		   
	    cal.add(Calendar.YEAR, -1);
	    SimpleDateFormat form= new SimpleDateFormat("dd-MM-YYYY");
	    String startDate=form.format(cal.getTime());
	    //System.out.println(startDate);
		return startDate;
		 
	
	
}
	public String PresentdateMinus1(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, -1);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String NextFinancialtoYearplus1month(){
		 int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financialYearTo="";
		 if(CurrentYear>=2017)
		    {
		        financialYearTo="30-04-"+(CurrentYear+1);
		        System.out.println(financialYearTo);
		    }
		return financialYearTo;
}
	public String NextFinancialtoYearMinus1month(){
		 int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financialYearTo="";
		 if(CurrentYear>=2017)
		    {
		        financialYearTo="14-02-"+(CurrentYear+1);
		        System.out.println(financialYearTo);
		    }
		return financialYearTo;
}
	public String NextFinancialtoYear1(){
		 int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financialYearTo="";
		 if(CurrentYear>=2017)
		    {
		        financialYearTo="31-03-"+(CurrentYear+1);
		        System.out.println(financialYearTo);
		    }
		return financialYearTo;
		 
	
	
}
	public String Presentdateplus1(){
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DAY_OF_MONTH, 1);
		//c.set(Calendar.DAY_OF_MONTH, 16); 
		 
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	       String startDate=df.format(c.getTime());
		
		
		return startDate;
}
	public String PreviousFinancialYearfromDate(){
		int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financialYearTo="";
		 if(CurrentYear>=2017)
		    {
		        financialYearTo="01-04-"+(CurrentYear-2);
		        System.out.println(financialYearTo);
		    }
		return financialYearTo;
		
		
	}
	public String PreviousFinancialYearToDate(){
		int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		 String financialYearTo="";
		 if(CurrentYear>=2017)
		    {
		        financialYearTo="31-03-"+(CurrentYear-1);
		        System.out.println(financialYearTo);
		    }
		return financialYearTo;
		
		
	}
	public String PresentTime(){
		String time=DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now());
		System.out.println("In time:"+time);
		return time;
}
	public void TakeScreenShot(String FileName) throws IOException{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File(FinanceGlobalVariables.ScreenShotsFileName + FileName +".png"));
		}
	
	public void TakeScreenShotOfWindowPopUp(String FileName ) throws IOException, HeadlessException, AWTException{
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(FinanceGlobalVariables.ScreenShotsFileName+ FileName +".png"));
		}
	
public void userLoginWithScreenShotsBeforeProcess1() throws InterruptedException, IOException {
		
		driver.get(FinanceVariables.URL);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("UserName")).sendKeys(FinanceGlobalVariables.MemberUsername);
		Thread.sleep(3000);
		driver.findElement(By.id("Password")).sendKeys(FinanceGlobalVariables.MemberPassword);
		Thread.sleep(3000);
		driver.findElement(By.id(FinanceVariables.TermsAndConditions)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(FinanceVariables.SignIn)).click();
		Thread.sleep(3000);
		method.TakeScreenShot("DashboardBeforeStart");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"DashboardBeforeStart", true);
		
		//FileUtils.copyFile(screenshot, new File(path));
		Thread.sleep(3000);
		String StartingAmount = driver.findElement(By.xpath(FinanceVariables.AmountInMemberDashboard))
				.getText();
		Thread.sleep(3000);
		Reporter.log("Member Balance Before Start - Dash board:  " + StartingAmount,true);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(FinanceVariables.Application)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(FinanceVariables.MemberMyAccount)).click();
		Thread.sleep(3000);
		String NetBalance = driver.findElement(By.xpath(FinanceVariables.MemberNetBalance)).getText();
		Thread.sleep(3000);
		//File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		method.TakeScreenShot("MyAccountBeforeStart");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"MyAccountBeforeStart", true);
		
		
		
		Reporter.log("", true);
		Reporter.log("Member Balance Before Start - My Account:  " + NetBalance,true);
		

	}
	
	public void userLoginWithScreenShotsAfterProcess1(WebDriver driver) throws InterruptedException, IOException {
		driver.get(FinanceVariables.URL);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id(FinanceVariables.UsernameId)).sendKeys(FinanceGlobalVariables.MemberUsername);
		Thread.sleep(3000);
		driver.findElement(By.id(FinanceVariables.PasswordId)).sendKeys(FinanceGlobalVariables.MemberPassword);
		Thread.sleep(3000);
		driver.findElement(By.id(FinanceVariables.TermsAndConditions)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(FinanceVariables.SignIn)).click();
		Thread.sleep(3000);
		
		
		
				
		method.TakeScreenShot("DashboardAfterProcess");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"DashboardAfterProcess", true);
		
		String StaritngAmount = driver.findElement(By.xpath(FinanceVariables.AmountInMemberDashboard))
				.getText();
		Thread.sleep(3000);
		Reporter.log("Member Balance After Process - Dash board:  " + StaritngAmount,true);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(FinanceVariables.Application)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(FinanceVariables.MemberMyAccount)).click();
		Thread.sleep(3000);
		String NetBalance = driver.findElement(By.xpath(FinanceVariables.MemberNetBalance)).getText();
		Thread.sleep(3000);
		
		method.TakeScreenShot("MyAccountAfterProcess");
		Reporter.log("File Name : "+FinanceGlobalVariables.ScreenShotsFileName+"MyAccountAfterProcess", true);
		
		
		Reporter.log("Member Balance After Process - My Account:  " + NetBalance,true);
		
	}
	
	
	
}