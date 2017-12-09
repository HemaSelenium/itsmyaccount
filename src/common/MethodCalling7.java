package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class MethodCalling7 {
	public static String PassNo;
	public static String parkinglot;
	public String OutTimeInSavedRecord;
	public static String SecondParkinglotNumber;
	public static String LotNumber;
	protected static SeleniumHelper helper = new SeleniumHelper();
	boolean acceptNextAlert;
	public void EditRecordAsFrequent(String parkinglot) throws InterruptedException{
		
		Reporter.log("..............Creating Frequent Visitor By Editing Record Which is having carparking lot number of : "+parkinglot+" ...............", true);
		helper.DeepSleep();
		helper.RefreshPage();
		helper.DeepSleep();
		WebElement VisitorRegister=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<WebElement>RowsOfVisitors=VisitorRegister.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int Rows=1;Rows<RowsOfVisitors.size();Rows++){
		List<WebElement>ColoumnsOfVisitors=RowsOfVisitors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
		if(ColoumnsOfVisitors.get(11).getText().equals(parkinglot)){
		ColoumnsOfVisitors.get(11).click();
		helper.Sleep();
		helper.ClickByID(VariableCalling.ClickOnEditButton);
		helper.DeepSleep();
		helper.ClickByXpath(variablecalling3.FrequentVisitor);
		helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInVisitorRegistor); 
		helper.DeepSleep();
		break;
		}}
	}
	
	public void AnotherAddVisitorRecord(String EnterVisitorName,String EnterVisitorContactNumber,String EnterPersonTomeet, String EnterGate,String EnterPurpose,String EnterPassNo,String CarParkingLotNumber, String EnterVehicalNumber  ) throws InterruptedException, IOException, AWTException{
		PassNo=EnterPassNo;
		SecondParkinglotNumber=CarParkingLotNumber;
		helper.DeepSleep();
		Reporter.log("...........Adding Record With parking lot NUmber "+SecondParkinglotNumber+" ...........", true);
		helper.ClickByID(VariableCalling.ClickOnAddButton);
		helper.Sleep();
		try {
			
			 Alert alert = SeleniumHelper.driver.switchTo().alert();
			 String alertText = alert.getText();
			 Reporter.log("Un expected Popup came as : "+alertText, true);
			 if (acceptNextAlert) {
			    alert.accept();
			     } else {
			   alert.dismiss();
			     }
			   
			    } catch(NoAlertPresentException e) {
			  
					     }
			finally{
				acceptNextAlert = true;
				
			}
			
		helper.Sleep();
		SeleniumHelper.driver.findElement(By.id("date")).clear();
		SeleniumHelper.driver.findElement(By.id("date")).sendKeys(MethodsCalling.CurrentDate());
		helper.Sleep();
		helper.SetValueByID("VisitorName", EnterVisitorName);
		helper.SetValueByID("ContactNo", EnterVisitorContactNumber);
		helper.SetValueByID("PersonToMeet",EnterPersonTomeet);
		helper.SetValueByID("Gate",EnterGate);
		helper.DeepSleep();
		helper.ClickByXpath(variablecalling3.BlockDropDown);
		SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberBlockName)).click();
		helper.DeepSleep();
		helper.ClickByXpath(variablecalling3.ApartmentNumbersDropdown);
		SeleniumHelper.driver.findElement(By.linkText(GlobalVariablesCalling.EnterMemberApartmentNumber)).click();
		helper.DeepSleep();
		helper.SetValueByID("RefField", EnterPurpose);
		String InTime=SeleniumHelper.driver.findElement(By.xpath(variablecalling3.InTimeField)).getAttribute("value");
		String SystemTime= MethodsCalling.CurrentTime();
		try{
		Assert.assertEquals(InTime,SystemTime);
		Reporter.log("1) In Time Filled Automatically Filled With System Time ", true);
		helper.TakeScreenShot("Automatically Filled InTime In 2nd Visitor Register");
		Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Automatically Filled InTime In 2nd Visitor Register" , true);

		}
		catch(AssertionError e){
		if(InTime.isEmpty()){
		Reporter.log("1) In Time Field Didnt Fill Automatically",true);
		helper.TakeScreenShot("InTime Didn't Fill In 2nd Visitor Register");
		Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"InTime Didn't Fill In 2nd Visitor Register" , true);
		}
		else{
		Reporter.log("1) In Time Field Filled Automatically But It Didnt Match To Current System Time which is : "+InTime , true);
		helper.TakeScreenShot("InTime Didn't Match With SystemTime In 2nd Visitor");
		Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"InTime Didn't Match With SystemTime In 2nd Visitor" , true);
		}}	  
		helper.SetValueByID("PassNo", EnterPassNo);
		helper.DeepSleep();
		helper.ClickByCSSSelector(variablecalling3.CarparkinglotDropdown);
	    helper.Sleep();
	    helper.TakeScreenShot("Available carparking lots while adding 2nd record");
	    
		//helper.TakeScreenShot("Available carparking lots While adding second Visitor are :");
		Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Available carparking lots while adding 2nd record" , true);
		WebElement Carparkinglots=SeleniumHelper.driver.findElement(By.id(variablecalling3.carparkinglotid));
		List<WebElement> list=Carparkinglots.findElements(By.tagName(variablecalling3.listofdropdown));

		Reporter.log("Available carparking lots are : ", true);

		for(WebElement e : list) {
		System.out.println(e.findElement(By.tagName("a")).getText());
		}SeleniumHelper.driver.findElement(By.linkText(SecondParkinglotNumber)).click();
		helper.SetValueByID("VehicleNo", EnterVehicalNumber);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling2.UploadImage);
		helper.Sleep();
		StringSelection stringSelection = new StringSelection(GlobalVariablesCalling.ImageToUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		helper.Sleep();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnSaveButtonInVisitorRegistor); 
		helper.DeepSleep();
		SeleniumHelper.driver.navigate().refresh();
		Thread.sleep(4000);
		WebElement VisitorRegister=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<WebElement>RowsOfVisitors=VisitorRegister.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		List<String>DateInVisitorRegister=new ArrayList<String>();
		List<String>PassNumber=new ArrayList<String>();
		for(int Rows=1;Rows<RowsOfVisitors.size();Rows++){
		List<WebElement>ColoumnsOfVisitors=RowsOfVisitors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		DateInVisitorRegister.add(ColoumnsOfVisitors.get(2).getText());
		PassNumber.add(ColoumnsOfVisitors.get(3).getText());
		}
		if(DateInVisitorRegister.contains(MethodsCalling.CurrentDate())){
		if(PassNumber.contains(PassNo)){
		Reporter.log("2) New VisitorRegister Details Added To VisitorRegister List Sucessfully", true);	
		}
		else{
		Reporter.log("3) Unable To Add Visitor Details ", true);
		}}}
	
	
	
	
	

	public void AssignCarparkingLotToFrequentVisitor(String VisitorName,String Gate,String VehicleNo,String PassNo,String parkinglot) throws IOException{
		LotNumber=parkinglot;
		helper.ClickByXpath(variablecalling3.FrequentButton);
		helper.DeepSleep();
		helper.TakeScreenShot("Frequent Visitors");
		Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Frequent Visitors" , true);
		WebElement FrequentVisitorRegister=SeleniumHelper.driver.findElement(By.id(VariableCalling2. IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<WebElement>RowsOfFrequentVisitors=FrequentVisitorRegister.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int Rows=1;Rows<RowsOfFrequentVisitors.size();Rows++){
			List<WebElement>ColoumnsOfVisitors=RowsOfFrequentVisitors.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
			if(ColoumnsOfVisitors.get(2).getText().equals(GlobalVariablesCalling.EnterMemberBlockName)){
				if(ColoumnsOfVisitors.get(3).getText().equals(GlobalVariablesCalling.EnterMemberApartmentNumber)){
					if(ColoumnsOfVisitors.get(4).getText().equals(VisitorName)){
						
						ColoumnsOfVisitors.get(7).findElement(By.tagName("a")).click();
						helper.DeepSleep();
						try {
							
							 Alert alert = SeleniumHelper.driver.switchTo().alert();
							 String alertText = alert.getText();
							 Reporter.log("Un expected Popup came as : "+alertText, true);
							 if (acceptNextAlert) {
							    alert.accept();
							     } else {
							   alert.dismiss();
							     }
							   
							    } catch(NoAlertPresentException e) {
							  
									     }
							finally{
								acceptNextAlert = true;
								
							}
						
						helper.SetValueByID("Gate",Gate);
						helper.SetValueByID("VehicleNo", VehicleNo);
						helper.SetValueByID("PassNo", PassNo);
						helper.ClickByXpath(".//*[@id='Visitor']/div[2]/div[2]/div/div[2]/div[4]/a");
						WebElement Carparkinglots=SeleniumHelper.driver.findElement(By.id(variablecalling3.CarparkingLotIdInFrequent));
						List<WebElement> list=Carparkinglots.findElements(By.tagName(variablecalling3.listofdropdown));
						Reporter.log("Available carparking lots are : ", true);
						for(WebElement e : list) {
						String AvailablecarparkinglotNumber=e.findElement(By.tagName("a")).getText();
						System.out.println(AvailablecarparkinglotNumber);
						if(AvailablecarparkinglotNumber.equals(LotNumber)){
							e.findElement(By.tagName("a")).click();
							helper.DeepSleep();
							Reporter.log("Assigning Parking Lot Number " +LotNumber+" To Frequent Visitor ", true);
							helper.ClickByXpath(variablecalling3.ClickOnSaveButtonInFrequentVisitor);
							break;
						}
						
						}
						
						
						
						
					}
				}
					
					
				break;	
				}
				
		}
		
	}
	
	public void CheckingHidingMailIdAndMobileNumberInMyResidents(String CommitteeMember){
		helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.MyResidentsButton);
		helper.DeepSleep();
		WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<String>MembersInList=new ArrayList<String>();
		List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int Row=1;Row<Rows.size();Row++){
		List<WebElement>Coloumns=Rows.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		MembersInList.add(Coloumns.get(6).getAttribute("title"));
		}
		if(MembersInList.contains(CommitteeMember)){
		for(int j=0;j<Rows.size();j++){
		List<WebElement>Coloumn=Rows.get(j).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		
		
		if(Coloumn.get(6).getAttribute("title").equals(CommitteeMember)){
		if(Coloumn.get(7).getAttribute("title").contains("*")	){
		Reporter.log("ContactNumber in My Residents Is Dislaying as *****", true);	
				
		}
		else{
			Reporter.log("ContactNumber in My Residents Is Not Displaying as *****", true);		
		}
		if(Coloumn.get(8).getAttribute("title").contains("*")	){
			Reporter.log("Mail Id In My Residents Is Dislaying as *****", true);	
		}
		else{
			Reporter.log("Mail Id In My Residents Is Not Dislaying as *****", true);
		}
		break;
		}}}
		else{
			System.out.println("comittee member not found");
		
		}
		
	}
	public void CheckingHidingMailIdAndMobileNumberInCarparkingLots(String CommitteeMember){
		helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnCarParkingLotsButton);
		helper.DeepSleep();
		WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<String>MembersInCarparking=new ArrayList<String>();
		List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int Row=1;Row<Rows.size();Row++){
		List<WebElement>Coloumns=Rows.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		MembersInCarparking.add(Coloumns.get(3).getAttribute("title"));
		}
			if(MembersInCarparking.contains(CommitteeMember)){
			for(int i=0;i<Rows.size();i++){
			List<WebElement>ColoumnsInCaraprking=Rows.get(i).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
		if(ColoumnsInCaraprking.get(3).getAttribute("title").equals(CommitteeMember)){
		if(ColoumnsInCaraprking.get(5).getAttribute("title").contains("*")	){
		Reporter.log("ContactNumber In CarparkingLots Is Dislaying as *****", true);	
				
		}
		else{
			Reporter.log("ContactNumber In CarparkingLots Is Not Displaying as *****", true);		
		}
		if(ColoumnsInCaraprking.get(6).getAttribute("title").contains("*")	){
			Reporter.log("Mail Id In CarparkingLots Is Dislaying as *****", true);	
		}
		else{
			Reporter.log("Mail Id In CarparkingLots Is Not Dislaying as *****", true);
		}
		break;
		}}}
		else{
			System.out.println("comittee member not found");
		
		}
	
	}
	
	
	public void CheckingHidingMailIdAndMobileNumberInDueList(String CommitteeMember){
		helper.ClickByXpath(VariableCalling.ClickOnDashBoardButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnDueListButton);
		helper.DeepSleep();
		WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<String>Members=new ArrayList<String>();
		List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int Row=1;Row<Rows.size();Row++){
		List<WebElement>Coloumns=Rows.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		Members.add(Coloumns.get(4).getAttribute("title"));
		}
		if(Members.contains(CommitteeMember)){
		for(int k=1;k<Rows.size();k++){
		List<WebElement>Coloumn=Rows.get(k).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));	
		if(Coloumn.get(4).getAttribute("title").equals(CommitteeMember)){
		if(Coloumn.get(5).getAttribute("title").contains("*")	){
		Reporter.log("ContactNumber In DueList Is Dislaying as *****", true);	
				
		}
		else{
			Reporter.log("ContactNumber In DueList Is Not Displaying as *****", true);		
		}
		if(Coloumn.get(6).getAttribute("title").contains("*")	){
			Reporter.log("Mail Id In DueList Is Dislaying as *****", true);	
		}
		else{
			Reporter.log("Mail Id In DueList Is Not Dislaying as *****", true);
		}
		break;
		}}}
		
		else{
			System.out.println("comittee member not found in DueList");
		
		}
		
	}
	
	public void CheckingHidingMailIdAndMobileNumberInCommitteeMembers(String CommitteeMember){
		helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling2.ClickOnCommiteeMembersButton);
		helper.DeepSleep();
		WebElement Table=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<WebElement>Rows=Table.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int Row=1;Row<Rows.size();Row++){
		List<WebElement>Coloumns=Rows.get(Row).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		if(Coloumns.get(5).getAttribute("title").equals(CommitteeMember)){
		if(Coloumns.get(6).getAttribute("title").contains("*")	){
		Reporter.log("ContactNumber In CommitteeMembers Is Dislaying as *****", true);	
				
		}
		else{
			Reporter.log("ContactNumber In CommitteeMembers Is Not Displaying as *****", true);		
		}
		if(Coloumns.get(7).getAttribute("title").contains("*")	){
			Reporter.log("Mail Id In CommitteeMembers  Is Dislaying as *****", true);	
		}
		else{
			Reporter.log("Mail Id In CommitteeMembers Is Not Dislaying as *****", true);
		}
		break;
		}
		
		}
	}
	
public void CheckingHidingMailIdAndMobileNumberWhileFacilityBooking(String BlockName,String ApartmentNumber ) throws InterruptedException{
helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
helper.DeepSleep();
helper.ClickElementByCssSelector(VariableCalling2.FacilityButton);
helper.DeepSleep();
	
		
		
		WebElement Tables=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		List<WebElement>NoOfRows=Tables.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		for(int p=1;p<NoOfRows.size();p++){
		List<WebElement>Coloumns=NoOfRows.get(p).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		try{
			String BookingButton=Coloumns.get(11).findElement(By.tagName("button")).getText();
			Coloumns.get(11).findElement(By.tagName("button")).click();
			helper.DeepSleep();
			helper.DeepSleep();
			helper.ClickByID(VariableCalling.ClickOnAddButton);
			helper.MaxSleep();
			JavascriptExecutor js = (JavascriptExecutor)SeleniumHelper. driver;
			js.executeScript("document.getElementById('BlockID').style.display='block';");

			
			Select dropdown = new Select(SeleniumHelper.driver.findElement(By.id("BlockID")));
			dropdown.selectByVisibleText(BlockName);
			/*helper.blockselection();
			helper.DeepSleep();
			helper.apartmentselection();
			helper.DeepSleep();*/
			JavascriptExecutor js1 = (JavascriptExecutor) SeleniumHelper.driver;
			js1.executeScript("document.getElementById('ApartmentID').style.display='block';");

			
			Select apartment = new Select(SeleniumHelper.driver.findElement(By.id("ApartmentID")));
			apartment.selectByVisibleText(ApartmentNumber);
			
		String ContactNumber=	SeleniumHelper.driver.findElement(By.xpath(".//*[@id='MemberContact']")).getAttribute("value");
		if(ContactNumber.contains("*")){
		Reporter.log("Contact Number While FacilityBooking Displaying As ***** While Facility Booking", true);
		
			}
		else{
			Reporter.log("Contact Number While FacilityBooking  Displaying Not Displaying As ***** Even Hided ", true);
			
		}
		
		break;
		}
		catch(NoSuchElementException Exception){
			
		}
		
		
		}
	}
	
	
	
}
