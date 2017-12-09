package common;
public class VariableCalling2 {
//currentevents
	public static String ClickOnCurrentEventsButton=".//*[@id='113']/div/img";

	
	
	public static String FromTime="timepicker1";
	public static String ToTime="timepicker2";
	public static String ClickOnSaveButtonInCurrentEvents=".//*[@id='CurrentHappenings']/div/div[3]/button[1]";
	public static String SelectTypeInSearchFunction="//option[contains(.,'Type')]";
	public static String FacilityButton="a[href*='Facility']";
	
	
	public static String EnterDataToSearch="jqg1";
	public static String TypeOfEventInFirstRow=".//*[@id='1']/td[3]";
	
	//societymeeting calander
	public static String ClickOnSocietyMeetingCalanderButton=".//*[@id='112']/div/img";
	public static String EnterFromDateInSocietyMeetingCalander="from";
	public static String EnterToDateInSocietyMeetingCalander="to";
	public static String EnterFromTimeInSocietyMeetingCalander="timepicker1";
	public static String IdentifyCalander=".//*[@id='calendar']/div[2]";
	public static String IdentifyingCalanderRows=".cal-row-fluid.cal-before-eventlist";
	public static String EnterToTimeInSocietyMeetingCalander="timepicker2";
	public static String IdentifyingCalanderDates="div";
	public static String FindingAllMeetingEvents="events-list";
	public static String MeetingEvent="a";
	public static String FindingListOfMeeting=".//*[@id='cal-slide-content']/ul";
	public static String SearchingEachevent="li";
	public static String GetDescriptionOfEvent="a";
	public static String XpathOfReason=".//*[@id='Reason']";
	public static String FindingEvent="span";
	public static String GetColourOfEvent="background-color";
	public static String ListofEvents="cal-slide-content";
	public static String ClickOnSaveButtonInSocietyDocument=".//*[@id='DocumentLibrary']/div/div[3]/button[1]";
	
	public static String SelectSendMail="sendmail";
	public static String ClickOnSubmitButton="submit";
	public static String PressTabButton="\t";
	public static String SelectBlockToInviteMeeting="Block 1";
	
	
	public static String ClickBlockDropDownList="BlockID";
	public static String ClickOnCancelButtonInSocietyMeetingCalendar="//input[@value='C']";
	public static String EnterReasonFormeetingCancelation="Meeting Cancelled";
	public static String ClickOnSaveButton="submit";
	
	//Commitee members
	public static String ClickOnCommiteeMembersButton=".//*[@id='104']/div/img";
	public static String DesignationOfCommiteeMembers=".//*[@id='1']/td[3]";
	public static String EnterDataToSearchInCommiteemembers="jqg1";
	public static String MailIdOfCommiteeMember=".//*[@id='1']/td[8]";
	 public static String AutherizationMessageInCommiteeMembers= "html/body/div[1]";
	
	//Admin forget userid
	public static String ClickOnForgetUserId=".//*[@id='body']/div/div/div/form/div[2]/div/div[4]/div/div[1]/a";
	public static String MailIdLocation=".//*[@type='email']";
	
	public static String ClickOnGetUserIdButton=".//*[@id='body']/div/div/div/form/div[2]/div/div[3]/button";
	public static String PasswordLocation=".//*[@type='password']";
	
	
	public static String ClickOnSignInButton=".//*[@id='passwordNext']";
	public static String ClickOnNextButton="identifierNext";
	
	//Admin forget password
	
public static String ClickOnForgetPasswordButton=".//*[@id='body']/div/div/div/form/div[2]/div/div[4]/div/div[2]/a";
public static String EnterUserIdLocation="UID"; 
public static String ClickOnGetPasswordButton=".//*[@id='body']/div/div/div/form/div[2]/div/div[3]/button";

public static String ClickOnChangePasswordButton=".//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/span/a";
public static String OldPasswordLocation=".//*[@id='User']/div/div[2]/div[2]/div[2]/input";
public static String ClickOnSaveButtonForChangePassword=".//*[@id='User']/div/div[3]/button[1]";	

public static String UnReadMail="//*[@class='zF']";
public static String SubjectOfMail="//*[@class='y6']/span/b";
public static String MessageInMail="//*[@class='y6']/span[2]";

public static String NetBalanceInDashBoard=".//*[@id='SocietyAdmin']/div[1]/div[1]/div/div[2]/div/div[2]/a";
public static String BalanceAmount=".//*[@id='BAL']";

//nonmember details
public static String NonMemberPassword="Welcome";
public static String NonMemberPasswordLocation=".//*[@id='User']/div/div[2]/div[3]/div[2]/div/input";	
public static String ClickOnNext=".//*[@id='User']/div/div[3]/button";	
public static String ClickOnGeneralLedgerAccountButton=".//*[@id='502']/div/img";	
public static String ClickOnLogoutButton=".//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/span/a";
public static String SelectNonMemberNameInSearchFunction="//option[contains(.,'NonMemberName')]";

	//resetpassword
public static String ClickOnResetPasswordButton=".//*[@id='905']/div/img";
public static String ClickOnUserNameDropdownList=".//*[@id='User']/div/div[2]/div[2]/div[1]/a";	
public static String ClickOnResetPassword=".//*[@id='User']/div/div[3]/button";

//my facilities

public static String SelectIsBookingAllowedCheckBox="IsBookingAllowed";
public static String ClickOnSlotDurationDropDown=".//*[@id='BookingSlot']";
public static String SelectIsPaidCheckBox="IsPaid";
public static String SelectFacilityNameInSearchFunction="//option[contains(.,'Facility Name')]";
public static String ClickOnSaveButtonInFacility=".//*[@id='Facility']/div/div[3]/button[1]";
public static String ClickOnRatesForDropDownButton=".//*[@id='Facility']/div/div[2]/div[2]/div[5]/a";
public static String IdentifyFacilityTable="#Grid>tbody";

public static String ClickOnMonthDropDownListButton="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[1]/div/a";
public static String ClickOnYearDropDownListButton="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[2]/div/a";
public static String ListOfMonths="ui-id-1";
public static String IdentifyingTagName="li";
public static String GetValuesFromList="a";
public static String ListOfYears="ui-id-2";
public static String ClickOnShowEventsButton=".//*[@id='monthYear']";
public static String GetTitleOfCalendar=".//*[@id='title']";
//societyAssests
public static String ClickOnSocietyAssetsButton=".//*[@id='201']/div/img";
public static String SelectAssetNameInSearchFunction="//option[contains(.,'Asset Name')]";
public static String EnterDataToSearchInAssets="jqg2";
public static String ClickOnRenewAmcButton="Renew";
public static String ClickOnFrequencyTypesDropDownListButton="Freq";
public static String IdentifyingTable="Grid";
public static String IdentifyingManageMembersTable="table";
public static String IdentifyingListOfElementsInTable="tbody";
public static String IdentifyingNumberOfRowsInTable="tr";
public static String IdentifyingNumberOfColoumnsInTable="td";
public static String ClickOnRenewButton=".//*[@id='Renew' and @type='submit']";
public static String ClickOnAmcDetailsButton="html/body/div[1]/div/div/div/div[3]/a";
public static String ClickOnBackToAssetButton=".//*[@id='AssSer']/div[3]/a";
public static String ClickOnSaveButtonAfterEnterServiceCompletionDate=".//*[@id='AssSer']/div[3]/button";
public static String ClickOnAmcDetailsButtonInApplication=".//*[@id='203']/div/img";
public static String ClickOnExportButtonInAmcDetailsPage=".//*[@id='AssSer']/div[1]/div[4]/div/button";
public static String ClickOnPdfButtonInAmcDetailsPage=".//*[@id='AssSer']/div[1]/div[4]/div/ul/li[1]/a";
public static String ClickOnGetDetailsButton="GetDetails";
public static String EnterFromDdate="FromDate";
public static String EnterToDate="ToDate";
public static String ClickOnSocietyInventoryButton=".//*[@id='202']/div/img";
public static String ClickOnMigratedButton="html/body/div[1]/div/div/div/div[3]/a[1]/button";
public static String ClickOnSaveButtonInMigratedPage=".//*[@id='Migrated']/div/div[3]/button[1]";
public static String SelectItemNameInSearchFunction="//option[contains(.,'Item Name')]";
public static String ClickOnBackToInventoryButton="html/body/div[1]/div/div/div/div[3]/a";

public static String ClickOnRecieptsButton="html/body/div[1]/div/div/div/div[3]/a[2]/button";
public static String ClickOnSaveButtonInReciepts=".//*[@id='Receipts']/div/div[3]/button[1]";
public static String PurchasedFromLocation="RefField1";
public static String ValueLocation="RefField2";
public static String ClickonIssuesButton="html/body/div[1]/div/div/div/div[3]/a[3]/button";

public static String EnterIssueIssuedToWhome="RefField1";
public static String EnterIssueApprovedByWhome="RefField2";
public static String ClickOnBlockDropDownList=".//*[@id='Issues']/div/div[2]/div[2]/div[8]/a";
public static String ClickOnApartmentNumbersDropDownList=".//*[@id='Issues']/div/div[2]/div[2]/div[9]/a";
public static String ClickOnSaveButtonInIssues=".//*[@id='Issues']/div/div[3]/button[1]";

public static String ClickOnInchargeDetailsButton="PD";
public static String NameOfInChargePerson="RefField1";
public static String ClickonSaveButtonInInchargeDetails="INCSave";

public static String ClickOnReportButton="Rep";
public static String ClickOnGetDetailsButtonInReports="RepDet";
public static String ClickOnExportButtonInReports=".//*[@id='InventoryTransaction']/div/div[3]/a";
public static String ClickOnCloseButtonInReports="CloseRep";
public static String ClickOnAmcDetailsButtonInAssetsAndInventory=".//*[@id='203']/div/img";

public static String ClickOnExportButton="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[5]/div/button";
public static String ClickOnPdfButton="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[5]/div/ul/li[1]/a";
public static String FindingButtonsInFooter="html/body/div[1]/div/div/div/div[3]";
public static String VerifyingButtonsAreAvailableOrNot="button";

public static String ClickOnExportButtonInSocietyInventory="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[8]/div/button";
public static String ClickOnPdfButtonInSocietyInVentory="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[8]/div/ul/li[1]/a";

//complaints
public static String ClickOnComplaintsButton=".//*[@id='401']/div/img";
public static String ClickOnBlockDropDownListInComplaints=".//*[@id='Complaint']/div/div[2]/div[2]/div[3]/a";
public static String ClickOnApartmentNumbersDropDownListInComplaints=".//*[@id='Complaint']/div/div[2]/div[2]/div[4]/a";
public static String ClickOnPriorityOfComplaintDropDownList=".//*[@id='Complaint']/div/div[2]/div[2]/div[5]/a";
public static String ClickOnStatusOfComplaintsDropDownList=".//*[@id='Complaint']/div/div[2]/div[2]/div[6]/a";
public static String ClickOnMemberComplaintPriorityDropDown=".//*[@id='Complaint']/div/div[2]/div[2]/div[3]/a";
public static String ClickOnMemberComplaintStatusDropDown=".//*[@id='Complaint']/div/div[2]/div[2]/div[4]/a";
public static String ClickOnSaveButtonInComplaints=".//*[@id='Complaint']/div/div[3]/button[1]";


public static String SelectDescriptionInSearchFunction="//option[contains(.,'Description')]";
public static String ClickOnComplaintTrackingButton=".//*[@id='402']/div/img";
public static String SelectTicketNumberInSearchFunction="//option[contains(.,'Ticket Number')]";
public static String ClickOnPdfButtonInComplaints="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[6]/div/button";
public static String ClickOnExportButtonInComplaints="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[6]/div/ul/li[1]/a";
public static String EnterDataToSearchInComplaints="jqg1";
public static String ClickOnChangeStatusButton="Edit";

public static String ClickOnExportButtonInComplaintTracking="html/body/div[1]/div/div/div/div/div[1]/div[2]/div[4]/button";
public static String ClickOnPdfButtonInComplaintTracking="html/body/div[1]/div/div/div/div/div[1]/div[2]/div[4]/ul/li[1]/a/i";

public static String GetModeratorNameOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_ModeratorName']";
public static String GetModeratorContactNumberOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_ModeratorContact']";
public static String GetModeratorMailIdOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_ModeratorEmail']";

public static String GetKeyContact1NameOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_TresurerName']";
public static String GetKeyContact1ContactNumberOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_TresurerContact']";
public static String GetKeyContact1MailIdOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_TresurerEmail']";

public static String GetKeyContact2OfKeyMemberDetailsInApplication=".//*[@id='SocietyView_PresidentName']";
public static String GetKeyContact2ContactNumberOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_PresidentContact']";
public static String GetKeyContact2MailIdOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_PresidentEmail']";
public static String IdentifyingKeyMemberDetailsLocationInDashBoard=".//*[@id='SocietyAdmin']/div[1]/div[3]/div[1]/div[2]";
public static String IdentifyingKeyMemberDetailsInDashBoard="div";
public static String ClearOldContactNumberOfModeratorOfKeyMemberDetailsInApplication=".//*[@id='SocietyView_ModeratorContact']";

public static String ClickOnUpdateButton=".//*[@id='SocietyAdmin']/div/div[6]/div[2]/button";
public static String GetDataInField="value";

//pdc
public static String ClickOnPdcButton=".//*[@id='505']/div/img";
public static String ClickOnDropDownListOfBlock=".//*[@id='PDC']/div/div[2]/div[2]/div[1]/a";
public static String ClickOnDropDownListOfApartments=".//*[@id='PDC']/div/div[2]/div[2]/div[2]/a";
public static String ClickOnSaveButtonInPdc=".//*[@id='PDC']/div/div[3]/button[1]";
public static String ClickOnMonthsDropDownlistButton="MonthNum";
public static String ClickOnYearDropDownlistButton="Year";
public static String SelectChequeNumberInSearchFunction="//option[contains(.,'Cheque No')]";
public static String ClickOnExportButtonInMyPDc="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[5]/div/button";
public static String ClickOnPDFButtonInMyPdc="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[5]/div/ul/li[1]/a";

public static String ClickOnDasBoardButton=".//*[@id='bs-example-navbar-collapse-1']/ul/li[1]/span/a";
public static String ClickOnViewAllButtonInMyPDC=".//*[@id='viewallPDC']/img";

public static String ClickOnPdcInMyAccount=".//*[@id='802']/div/img";

public static String SelectBlockNameInSearch="//option[contains(.,'Block Name')]";
//my personaldocuments
public static String ClickOnMyPersonalDocumentsButton=".//*[@id='803']/div/img";
public static String ClickOnSaveButtonInPersonalDocuments=".//*[@id='DocumentLibrary']/div/div[3]/button[1]";

public static String FileDisplayTypeAsLine="document.getElementsByName('file_upload')[0].style.display='inline'";
public static String FileDisplayTypeAsNone="document.getElementsByName('file_upload')[0].style.display='none'";

public static String SelectDocumentNameInSearchFunction="//option[contains(.,'Document Name')]";
//mycommitments
public static String ClickOnMyCommitmentsButton=".//*[@id='804']/div/img";
public static String ClickOnCategoriesButton="Categories";

public static String ClickOnCommitmentsButton="Commitments";
public static String ClickOnSaveButtonInCommitments=".//*[@id='Commitment']/div/div[3]/button[1]";

public static String ClickOnCategoryDropdownList=".//*[@id='Commitment']/div/div[2]/div[2]/div[1]/a";
public static String ClickOnFrequencyDropDownList=".//*[@id='Commitment']/div/div[2]/div[2]/div[6]/a";
public static String ClickOnCommitmentCategoryDropdown="CommitmentCategoryID";
public static String EnterCommitmentDueDate="SlotDueDate";
public static String clickOnExportButtonInCommitments="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[8]/div/button";
public static String ClickOnPdfButtonInCommitments="html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/table/tbody/tr/td[8]/div/ul/li[1]/a";

public static String IdentifyingALLFAQs="mysociety";
public static String LocatingOneFAQ="li";
public static String ClickOnPerticularQuestion="a";


public static String UploadImage=".//*[@id='file_select1']";
public static String UploadImageOnRightSide=".//*[@id='file_select2']";

public static String WebCam=".//*[@id='web1']";
public static String WebCameImageOnLeftSide=".//*[@id='web']";

public static String TakeSnapShot=".//*[@id='pre_take_buttons1']/input";
public static String TakeSnapShotOnLeftSide=".//*[@id='pre_take_buttons']/input";
public static String BadgeId=".//*[@id='1']/td[3]";


}
