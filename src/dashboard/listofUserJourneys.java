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
public class listofUserJourneys {
WebDriver driver = new FirefoxDriver();
public String NameOfCity="BANGALORE";
@Test
public void AllUsers() throws InterruptedException{
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

System.out.println("Main List Of User Jouneys Are :");
WebElement list=driver.findElement(By.xpath(".//*[@id='layout-header']/nav/div/div[2]/div/ul"));
List<WebElement>Numbers=list.findElements(By.className("dropdown"));
for(int j=0;j<Numbers.size();j++){
System.out.println(j+1+")"+Numbers.get(j).findElement(By.tagName("a")).getText());
Actions action = new Actions(driver);
action.moveToElement(Numbers.get(j).findElement(By.tagName("a"))).click().build().perform();
WebElement Menu=Numbers.get(j).findElement(By.className("dropdown-menu"));
List<WebElement>Menulist=Menu.findElements(By.tagName("li"));
System.out.println("List of user jouneys under Above category:");
for(int k=0;k<Menulist.size();k++){
System.out.println("* "+Menulist.get(k).getText());
 }}}}
        
        
		
		
		
		
	


