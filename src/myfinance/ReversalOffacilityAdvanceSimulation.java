package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;

import java.io.IOException;


import org.testng.Reporter;

import org.testng.annotations.Test;

import FinanceCommon.TestBase;
import jxl.read.biff.BiffException;

public class ReversalOffacilityAdvanceSimulation extends TestBase {
logindetails ldr = new logindetails();
	
	
	
	BookingFacilityHelper help1 = new BookingFacilityhelpDEMO10();
	FinancialVouchersHelp help2 = new FinancialVouchersHelp();
		
	@Test(priority = 1)
	public void ScriptName() {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_011",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Reversal of Facility Advance",true);
	}

	@Test(priority = 2)
	public void login()
			throws InterruptedException, IOException {
		ldr.adminlogin();
		helper1.SAP();
	}

	@Test(priority = 3,dependsOnMethods="login")
	public void advance( ) throws InterruptedException, BiffException, IOException, HeadlessException, AWTException {
		help2.ReversalOfFacilityadvance();
		helper1.SAP();
		
	}

	
}
