package common;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider5 {

	@DataProvider    (name = "OwnerFacilitySimulationWithAdminLogin")	
	public static Object [][] FacilityWithMoreThanAllowedTime()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOwnerFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-20;
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OwnerFacilityBookingWithOwnerLogin")	
	public static Object [][] OwnerFacilityBookingWithOwnerLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOwnerFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-16;
	      	String inputdata [][]= new String [rows-2][columns-4]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=4; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-4] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OwnerFacilitySimulationWithOwnerLogin")	
	public static Object [][] OwnerFacilitySimulationWithOwnerLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOwnerFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-12;
	      	String inputdata [][]= new String [rows-2][columns-8]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=8; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-8] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "OwnerFacilitySimulationWithTenatLogin")	
	public static Object [][] OwnerFacilitySimulationWithTenatLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOwnerFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-8;
	      	String inputdata [][]= new String [rows-2][columns-12]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=12; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-12] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "OwnerFacilityOverlapWithAdminLogin")	
	public static Object [][] OwnerFacilityOverlapWithAdminLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOwnerFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-2][columns-16]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=16; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-16] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	@DataProvider    (name = "OwnerFacilityOverlapWithMemberLogin")	
	public static Object [][] OwnerFacilityOverlapWithMemberLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingOwnerFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns-20]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=20; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-20] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
		
	@DataProvider    (name = "TenantFacilitySimulationWithAdminLogin")	
	public static Object [][] TenantFacilitySimulationWithAdminLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingTenantFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-20;
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "TenantFacilityBookingWithTenantLogin")	
	public static Object [][] TenantFacilityBookingWithTenantLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingTenantFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-16;
	      	String inputdata [][]= new String [rows-2][columns-4]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=4; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-4] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	@DataProvider    (name = "TenantFacilitySimulationWithTenantLogin")	
	public static Object [][] TenantFacilitySimulationWithTenantLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingTenantFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-12;
	      	String inputdata [][]= new String [rows-2][columns-8]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=8; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-8] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "TenantFacilitySimulationWithOwnerLogin")	
	public static Object [][] TenantFacilitySimulationWithOwnerLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingTenantFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-8;
	      	String inputdata [][]= new String [rows-2][columns-12]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=12; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-12] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "TenatFacilityOverlapWithAdminLogin")	
	public static Object [][] TenatFacilityOverlapWithAdminLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingTenantFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-2][columns-16]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=16; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-16] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "TenantFacilityOverlapWithTenantLogin")	
	public static Object [][] TenantFacilityOverlapWithTenantLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingTenantFacility");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns-20]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=20; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j-20] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
}
