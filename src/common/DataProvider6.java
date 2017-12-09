package common;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider6 {
	@DataProvider    (name = "OTHFacilitySimulationWithAdminLogin")	
	public static Object [][] FacilityWithMoreThanAllowedTime()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-32;
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OTHFacilityBookingWithAdminLogin")	
	public static Object [][] OwnerFacilityBookingWithOwnerLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-26;
	      	String inputdata [][]= new String [rows-2][columns-6]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=6; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-6] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OTHFacilitySimulationFor1hr30MintsWithAdminLogin")	
	public static Object [][] OTHFacilitySimulationFor1hr30MintsWithAdminLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-20;
	      	String inputdata [][]= new String [rows-2][columns-12]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=12; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-12] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OTHFacilitySimulationWithOwnerLogin")	
	public static Object [][] OTHFacilitySimulationWithOwnerLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-16;
	      	String inputdata [][]= new String [rows-2][columns-18]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=18; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-18] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		

	@DataProvider    (name = "OTHFacilitySimulationWithTenantLogin")	
	public static Object [][] OTHFacilitySimulationWithTenantLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-12;
	      	String inputdata [][]= new String [rows-2][columns-22]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=22; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-22] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OTHFacilitySimulationOfSameTimingOverLapWithAdminLogin")	
	public static Object [][] OTHFacilitySimulationOfSameTimingOverLapWithAdminLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-6;
	      	String inputdata [][]= new String [rows-2][columns-26]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=26; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-26] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "OTHFacilitySimulationOfDifferentTimingOverLapWithAdminLogin")	
	public static Object [][] OTHFacilitySimulationOfDifferentTimingOverLapWithAdminLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOTHFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns-32]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=32; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-32] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "OwnerFacilityCancellation")	
	public static Object [][] OwnerFacilityCancellation()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Cancellation Facilities");
	        int rows = s.getRows();
	        int columns = s.getColumns()-6;
	      	String inputdata [][]= new String [rows-3][columns]; 
	        for (int i=3; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "TenantFacilityCancellation")	
	public static Object [][] TenantFacilityCancellation()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Cancellation Facilities");
	        int rows = s.getRows();
	        int columns = s.getColumns()-5;
	      	String inputdata [][]= new String [rows-3][columns-1]; 
	        for (int i=3; i<rows; i++){
	    	       for (int j=1; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-1] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "BookOwnerFacilityAfterCancelOwnerFacility")	
	public static Object [][] BookOwnerFacilityAfterCancelOwnerFacility()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Cancellation Facilities");
	        int rows = s.getRows();
	        int columns = s.getColumns()-1;
	      	String inputdata [][]= new String [rows-3][columns-2]; 
	        for (int i=3; i<rows; i++){
	    	       for (int j=3; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-2] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "CancelOTHFacility")	
	public static Object [][] CancelOTHFacility()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Cancellation Facilities");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns-11]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=11; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-11] = cl.getContents();
	                	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "CancelOwnerFacility")	
	public static Object [][] CancelOwnerFacility()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Cancellation Facilities");
	        int rows = s.getRows();
	        int columns = s.getColumns()-11;
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "CancelTenantFacility")	
	public static Object [][] CancelTenantFacility()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("Cancellation Facilities");
	int rows = s.getRows();
	int columns = s.getColumns()-8;
	String inputdata [][]= new String [rows-2][columns-3]; 
	for (int i=2; i<rows; i++){
	for (int j=3; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-3] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "BookOwnerFacilityAfterCancelledFacility")	
	public static Object [][] BookOwnerFacilityAfterCancelledFacility()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("Cancellation Facilities");
	int rows = s.getRows();
	int columns = s.getColumns()-3;
	String inputdata [][]= new String [rows-2][columns-6]; 
	for (int i=2; i<rows; i++){
	for (int j=6; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-6] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "SimulateRatesForBOTHFacility")	
	public static Object [][] SimulateRatesForBOTHFacility()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
	int rows = s.getRows();
	int columns = s.getColumns()-28;
	String inputdata [][]= new String [rows-2][columns]; 
	for (int i=2; i<rows; i++){
	for (int j=0; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
	
	@DataProvider    (name = "SimulateRatesForBOTHFacilityWithTenantLogin")	
	public static Object [][] SimulateRatesForBOTHFacilityWithTenantLogin()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
	int rows = s.getRows();
	int columns = s.getColumns()-23;
	String inputdata [][]= new String [rows-2][columns-5]; 
	for (int i=2; i<rows; i++){
	for (int j=5; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-5] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
	
	@DataProvider    (name = "SimulateRatesForBOTHFacilityWithAdminLogin")	
	public static Object [][] SimulateRatesForBOTHFacilityWithAdminLogin()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
	int rows = s.getRows();
	int columns = s.getColumns()-18;
	String inputdata [][]= new String [rows-2][columns-10]; 
	for (int i=2; i<rows; i++){
	for (int j=10; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-10] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
	
	@DataProvider    (name = "SimulateFacilityWithSpecialPackageAndHourlyRatesWithAdminLogin")	
	public static Object [][] SimulateFacilityWithSpecialPackageAndHourlyRatesWithAdminLogin()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
	int rows = s.getRows();
	int columns = s.getColumns()-13;
	String inputdata [][]= new String [rows-2][columns-15]; 
	for (int i=2; i<rows; i++){
	for (int j=15; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-15] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "SimulateFacilityWithSpecialPackageAndHourlyRatesWithAdminLoginFor5:30hrs")	
	public static Object [][] SimulateFacilityWithSpecialPackageAndHourlyRatesWithAdminLoginFor5hrsAnd30mints()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
	int rows = s.getRows();
	int columns = s.getColumns()-8;
	String inputdata [][]= new String [rows-2][columns-20]; 
	for (int i=2; i<rows; i++){
	for (int j=20; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-20] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}

	@DataProvider    (name = "BookFacilityWithSpecialPackageAndHourlyRatesWithAdminLoginFor7hrs")	
	public static Object [][] BookFacilityWithSpecialPackageAndHourlyRatesWithAdminLoginFor7hrs()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
	int rows = s.getRows();
	int columns = s.getColumns()-3;
	String inputdata [][]= new String [rows-2][columns-25]; 
	for (int i=2; i<rows; i++){
	for (int j=25; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-25] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
@DataProvider    (name = "CancelFacilityWithSpecialPackageAndHourlyRatesWithAdminLoginFor7hrs")	
public static Object [][] CancelFacilityWithSpecialPackageAndHourlyRatesWithAdminLoginFor7hrs()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("SimulateRatesForBOTHFacility");
int rows = s.getRows();
int columns = s.getColumns();
String inputdata [][]= new String [rows-2][columns-30]; 
for (int i=2; i<rows; i++){
for (int j=30; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-30] = cl.getContents();
	          	                       
	            }
	        }
	                return inputdata;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
