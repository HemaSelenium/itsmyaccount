package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import IntegrationWithBiometric.AdminRegularvendorsWithoutBadgeId;



//import dashboard.Date;

public class MethodsCalling {
	
	public static Logger log=Logger.getLogger(AdminRegularvendorsWithoutBadgeId.class.getName());
	boolean contains;	
	public void AvailabilityCheckManageRole() throws InterruptedException {
		Thread.sleep(4000);
		WebElement ManageRole = SeleniumHelper.driver.findElement(By.xpath(VariableCalling.SelectManageMembersTable));
		Thread.sleep(4000);
		List<WebElement> tableRows = ManageRole.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		Thread.sleep(4000);
			for (int index = 1; index < tableRows.size(); index++) {
			Select role = new Select(tableRows.get(index).findElement(By.id("RoleID")));
			role.selectByVisibleText(GlobalVariablesCalling.EnterRoleNameToAdd);
			List<WebElement> rolecount = role.getOptions();
			int RoleSize = rolecount.size();
			for (int NumberOfRoles = 0; NumberOfRoles < RoleSize; NumberOfRoles++) {
			String rValue = rolecount.get(NumberOfRoles).getText();
			if (rValue.equals(GlobalVariablesCalling.EnterRoleNameToAdd)) {
			role.selectByVisibleText(GlobalVariablesCalling.EnterRoleNameToAdd);
			Reporter.log(GlobalVariablesCalling.EnterRoleNameToAdd+" role is available in "+index+" Row", true);
			
				}
			}
		}

	}
	
	public void FullAccessGivenToMySociety(){
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyResidents)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToCarParkingLots)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToInHouseStaff)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyCommitteeMembers)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToregularVendors)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToOwnerORTenantMovementregister)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToVisitorRegister)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToPostageAndCourierRegister)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToStaffAttendanceRegister)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToServantMaidList)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyFacilities)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToSocietyMeetingCalendar)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToCurrentHappenings)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToForums)).click();
		SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToVoting)).click();
		}
	
public void FullAccessGivenToComplaints(){
SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToComplaints)).click();	
	}
public void ReadAccessGivenToComplaintsTracker(){
SeleniumHelper.driver.findElement(By.xpath(variablecalling3.ReadAccessToComplaintTracker)).click();	
	}

public void FullAccessGivenToAssets(){
SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToAssets)).click();
	}
public void ReadAccessGivenToSocietyInventory(){
SeleniumHelper.driver.findElement(By.xpath(variablecalling3.ReadAccessToSocietyInventory)).click();
	}
public void ReadAccessGivenToAMCDetails(){
SeleniumHelper.driver.findElement(By.xpath(variablecalling3.ReadAccessToAMC)).click();
	}

public void ReadAccessGivenToSocietyDocuments(){
SeleniumHelper.driver.findElement(By.xpath(variablecalling3.ReadAccessToSocietyDocuments)).click();
	}	
public void FullAccessGivenToMyAccount(){
	SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyAccount)).click();
	SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyPDC)).click();
	SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyPersonalDocuments)).click();
	SeleniumHelper.driver.findElement(By.xpath(variablecalling3.FullAccessToMyCommitments)).click();
	
}

	
	
	
	public void SelectManageRole() throws InterruptedException {

		WebElement ManageRole = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
		List<WebElement> tableRows1 = ManageRole.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		int index = tableRows1.size();
		for (index = 1; index < tableRows1.size(); index++) {
			List<WebElement> tablecoloumns = tableRows1.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
			String rowdata = tablecoloumns.get(2).getText();
			System.out.println(rowdata);
			if (rowdata.equals(GlobalVariablesCalling.EnterRoleNameToAdd)) {
				tablecoloumns.get(2).click();
				Thread.sleep(1000);
			}
		}

	}
	public void selectRow(){
		SeleniumHelper.driver.findElement(By.xpath(".//*[@id='1']/td[3]")).click();
	}
	
	public void SelectManageRoleToDelete() throws InterruptedException {

		WebElement ManageRole = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
		List<WebElement> tableRows1 = ManageRole.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		int index = tableRows1.size();
		for (index = 1; index < tableRows1.size(); index++) {
			List<WebElement> tablecoloumns = tableRows1.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
			String rowdata = tablecoloumns.get(2).getText();
			if (rowdata.equals(GlobalVariablesCalling.EditedRoleName)) {
				tablecoloumns.get(2).click();
				Thread.sleep(1000);
			}
		}

	}
	public void SelectManageRoleToDeleteAfterAssignToMember() throws InterruptedException {

		WebElement ManageRole = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
		List<WebElement> tableRows1 = ManageRole.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		int index = tableRows1.size();
		for (index = 1; index < tableRows1.size(); index++) {
			List<WebElement> tablecoloumns = tableRows1.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
			String rowdata = tablecoloumns.get(2).getText();
			if (rowdata.equals(GlobalVariablesCalling.EnterRoleNameToAdd)) {
				tablecoloumns.get(2).click();
				Thread.sleep(1000);
			}
		}

	}
	public void SearchRoleAfterDelete() throws InterruptedException {
		boolean contains=true;
		WebElement ManageRole = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
		List<WebElement> tableRows1 = ManageRole.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		int index = tableRows1.size();
		List<String> list = new ArrayList<String>();
		Thread.sleep(2000);
		for (index = 1; index < tableRows1.size(); index++) {
			List<WebElement> tablecoloumns = tableRows1.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
			Thread.sleep(2000);
			list.add(tablecoloumns.get(2).getText());
			Thread.sleep(2000);
			
		}
		for(int j=0;j<list.size();j++){
		if((list.get(j)).equals(GlobalVariablesCalling.EditedRoleName))
			Thread.sleep(2000);
		{
			 contains=false;
		}
		}
		if(contains){
			Thread.sleep(2000);
			Reporter.log(GlobalVariablesCalling.EditedRoleName+"  Role Not Deleted Sucessfully", true);
			Thread.sleep(1000);
			}
		else{
			Thread.sleep(2000);
			Reporter.log(GlobalVariablesCalling.EditedRoleName+"  Role Deleted Sucessfully", true);
					Thread.sleep(1000);
		}
		}
	
	public static String CurrentDate(){
		Date CurrentDate = new Date();
	    DateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    String TodayDate = DateFormat.format(CurrentDate);
	 return TodayDate;
		       
}
public static String CurrentTime(){
	Date CurrentDate = new Date();
    DateFormat DateFormat = new SimpleDateFormat("hh:mm a");
    String SystemTime = DateFormat.format(CurrentDate);
 return SystemTime;	
	
	
	
	
}
	
	public static String EnterTomorrowDate(){
		Calendar calObject = Calendar.getInstance();
        calObject.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrowDate = new SimpleDateFormat("dd-MM-yyyy").format(calObject.getTime());
        return tomorrowDate;
		
	}
	public static String EnterDayAfterTomorrowDate(){
		Calendar calObject = Calendar.getInstance();
        calObject.add(Calendar.DAY_OF_YEAR, 2);
        String DayAfterTomorrowDate = new SimpleDateFormat("dd-MM-yyyy").format(calObject.getTime());
        return DayAfterTomorrowDate;
		
	}
public static String PreviousMonth(){
	Calendar calObject = Calendar.getInstance();
    calObject.add(Calendar.MONTH,-1);
    String LastMonth =calObject.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
   	return LastMonth;
}
public static String PresentYear(){
	Calendar calObject1 = Calendar.getInstance();
    calObject1.add(Calendar.YEAR,0);
    String year = new SimpleDateFormat("yyyy").format(calObject1.getTime());
    return year;
}
	
	
	
	/*public static String EnterInput(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Choice 'Yes' To Continue  ");
		String choice=scanner.next();	
			return choice;
	}*/
	public void FirstRowMemberdetails() throws InterruptedException {
		WebElement header=SeleniumHelper.driver.findElement(By.id("gview_Grid"));
		List<WebElement> tableheaders = header.findElements(By.tagName("th"));
		List<String>list=new ArrayList<String>();
		for(int headers=1;headers<tableheaders.size();headers++)
		{
	list.add(SeleniumHelper.driver.findElement(By.xpath(".//*[@id='gview_Grid']/div[2]/div/table/thead/tr/th["+headers+"]")).getText());
	
		Thread.sleep(2000);
		}
		
			
		
		
					
		WebElement carparkinglots = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
		List<WebElement> tableRows = carparkinglots.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		List<WebElement> tablecoloumns = tableRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		List<String>MemberDetails=new ArrayList<String>();
		for (int index = 0; index < tablecoloumns.size();index++) {
			
		MemberDetails.add(tablecoloumns.get(index).getText());
		}
		Reporter.log("4)One Full Record Data Of Member : ", true);
				String Results=String.join("   ", list);
		Reporter.log(Results, true);
		String Results2=String.join("    ", MemberDetails);
		Reporter.log("    "+Results2, true);
		
				
					
		}
		
		
		
		
	public void FindingMessageInApplicationNoticeBoard() throws InterruptedException {

		WebElement ManageRole = SeleniumHelper.driver.findElement(By.cssSelector(".table.table-hover>tbody"));
		List<WebElement> tableRows1 = ManageRole.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		int index = tableRows1.size();
		List<String> list = new ArrayList<String>();
		for (index = 0; index < tableRows1.size(); index++) {
		List<WebElement> tablecoloumns = tableRows1.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		System.out.println(tablecoloumns.get(1).getText());
		list.add(tablecoloumns.get(1).getText());
		Thread.sleep(5000);
		}	
			if(list.contains(VariableCalling.EnterMessageInNoticeBoard)){
				Reporter.log("3)Message Available In Application NoticeBoard", true);
				Thread.sleep(1000);
			}
			else{
				Reporter.log("3)Message Not Available In Application NoticeBoard", true);
			}
					
		

	}
	
	
	
	
	
	
		public void OccupancyOfMembers() {

			WebElement Myresidents = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
			List<WebElement> tableRows = Myresidents.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
			int index = tableRows.size();

			for (index = 1; index < tableRows.size(); index++) {
				List<WebElement> tablecoloumns = tableRows.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
				String rowdata = tablecoloumns.get(5).getText();
				Reporter.log(rowdata, true);
							}
		}
		
		public void SelectNonMemberUserName() throws InterruptedException {
		   
		    WebElement NonMemberList=SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable)).findElement(By.tagName(VariableCalling2.IdentifyingListOfElementsInTable));
		    List<WebElement>RowsInNonMemberList= NonMemberList.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
		    Thread.sleep(4000);
		    
		   for(int rows=0;rows<RowsInNonMemberList.size();rows++){
		    	 Thread.sleep(2000);
		    	
		    List<WebElement>coloumnsInNonMemberList= RowsInNonMemberList.get(rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
		    Thread.sleep(2000);
		    String NonMemberUserName=coloumnsInNonMemberList.get(3).getText();
		    Thread.sleep(2000);
		    if(NonMemberUserName.equals(GlobalVariablesCalling.EnterNonMemberUserName)){
		    	coloumnsInNonMemberList.get(3).click();
				
					Thread.sleep(3000);
				}
			}

		}
		
		
		
		
		
public void CompareAttendanceRegisterMembersAndMaintenanceTeamMembers() throws InterruptedException {
WebElement MaintenanceTeam = SeleniumHelper.driver.findElement(By.id(VariableCalling2.IdentifyingTable));
Thread.sleep(2000);
List<WebElement> tableRows1 = MaintenanceTeam.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
Thread.sleep(2000);
List<String> list = new ArrayList<String>();
for (int index = 1; index < tableRows1.size(); index++) {
List<WebElement> tablecoloumns = tableRows1.get(index).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
Thread.sleep(2000);
list.add(tablecoloumns.get(4).getText());
Thread.sleep(2000);
}
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnApplicationButton)).click();
Thread.sleep(2000);
SeleniumHelper.driver.findElement(By.xpath(VariableCalling.ClickOnAttendanceRegister)).click();
Thread.sleep(2000);
WebElement AttendenceRegister = SeleniumHelper.driver.findElement(By.id("divAttendance"));
List<WebElement> RegisterTableRows= AttendenceRegister.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
for(int coloumns=0; coloumns<list.size();coloumns++){
for (int Rows = 1; Rows < RegisterTableRows.size(); Rows++) {
List<WebElement> RegisterTablecoloumns = RegisterTableRows.get(Rows).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String RegisterTableData = RegisterTablecoloumns.get(1).getText();
if (RegisterTableData.contains(list.get(coloumns))){
Reporter.log("Members In Attendance Register List: "+RegisterTableData, true);
Reporter.log("Maintenance Member List: "+list.get(coloumns), true);
Reporter.log("Member List In Attendance Register Matched With Maintenance Members", true);
}}}}} 
	                	                                                
	                		
	                			 
	                					
	                				 
	                		   
	                	                                                        
	                		 
	                	                                               	             
	                	         
	      
	          
	           
	            
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	

