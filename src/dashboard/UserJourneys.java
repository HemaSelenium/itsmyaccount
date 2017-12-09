package dashboard;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UserJourneys {
WebDriver driver = new FirefoxDriver();
public String NameOfCity="BANGALORE";
public static String FirstUserJourney=" On Road Price";
public static String SecondUserJourney=" Explore New Cars ";
public static String Make="";
public static String Model="";
	public static String City=""; 
	@Test
	public void FirstUserJourney() throws InterruptedException{
		//Navigate to URL	
		driver.get("http://www.indianbluebook.com");
		// maximize Window
		driver.manage().window().maximize();
		//handling alert
		try{
		Alert alert=driver.switchTo().alert();
		alert.accept();
		}
		catch(NoAlertPresentException e){
		}
		//click on dropdown field of City
		driver.findElement(By.cssSelector(".chosen-single>div>b")).click();

		WebElement SelectCity=driver.findElement(By.xpath(".//*[@id='cityPopupField_chosen']/div/ul"));
		List<WebElement> ListOfCities=SelectCity.findElements(By.tagName("li"));
		for(int i=0;i<ListOfCities.size();i++){
		String CityName=ListOfCities.get(i).getText();
		if(CityName.equals(NameOfCity)){
		ListOfCities.get(i).click();
		try{
		Alert alert=driver.switchTo().alert();
		alert.accept();
		}
		catch(NoAlertPresentException e){
		}			
		break;}}
		if(driver.findElement(By.xpath(".//*[@id='citySelected']")).equals(NameOfCity)){
			System.out.println("selected city saved sucessfully");
		}
		else{
		System.out.println("Selected City didn't save  /  it replaced with some other city ");
		System.out.println("selected city in header is : "+driver.findElement(By.xpath(".//*[@id='citySelected']")).getText());
		}
		WebElement list=driver.findElement(By.xpath(".//*[@id='layout-header']/nav/div/div[2]/div/ul"));
		List<WebElement>Numbers=list.findElements(By.className("dropdown"));
		for(int j=0;j<Numbers.size();j++){
		Actions action = new Actions(driver);
		action.moveToElement(Numbers.get(j).findElement(By.tagName("a"))).click().build().perform();
		WebElement Menu=Numbers.get(j).findElement(By.className("dropdown-menu"));
		List<WebElement>Menulist=Menu.findElements(By.tagName("li"));
		for(int k=0;k<Menulist.size();k++){
			if(Menulist.get(k).getText().equals(FirstUserJourney)){
				Menulist.get(k).click();
				Thread.sleep(3000);
				WebElement Userjourney=driver.findElement(By.xpath(".//*[@id='make2_chosen']/div/ul"));
				List<WebElement>MakeList=Userjourney.findElements(By.tagName("li"));
				for(int p=0;p<MakeList.size();p++){
					if(MakeList.get(p).equals(Make)){
						MakeList.get(p).click();
					}
					
					
					
					
				}
				
				
			}
		
		 }}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
