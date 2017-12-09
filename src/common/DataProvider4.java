package common;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider4 {
	@DataProvider    (name = "AddFacilityNoAllowedBooking")	
	public static Object [][] AddFacilityNoAllowedBooking()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AddFacilityNoAllowedBooking");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	@DataProvider    (name = "EditFacilityNoAllowedBooking")	
	public static Object [][] EditFacilityNoAllowedBooking()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AddFacilityNoAllowedBooking");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-8]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=8; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-8] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "FacilityWithFree")	
	public static Object [][] FacilityNoAllowedBooking()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AddFacilityNoAllowedBooking");
	        int rows = s.getRows();
	        int columns =s.getColumns()-(s.getColumns()-1);
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	                Cell cl = s.getCell(0,i);
	                inputdata [i-1][0] = cl.getContents();
	                       
	            
	        }
	                return inputdata;
	
	}	
	
	
	
	
	
	
	
	
	@DataProvider    (name = "AddFreeFacilityWith30MintsSlot")	
	public static Object [][] AddFreeFacilityWith30MintsSlot()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AddFreeFacilityWith30MintsSlot");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	
	@DataProvider    (name = "EditFreeFacilityWith30MintsSlot")	
	public static Object [][] EditFreeFacilityWith30MintsSlot()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AddFreeFacilityWith30MintsSlot");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-9]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=9; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-9] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	
	@DataProvider    (name = "BookFreeFacilityWith30MintsSlot")	
	public static Object [][] BookFreeFacilityWith30MintsSlot()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookingFreeFacilityFor30mints");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	        	 for (int j=0; j<columns; j++){  
	    	                    Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	        	 }      
	        }
	                return inputdata;
	
	}
	
	@DataProvider    (name = "BookFree30MintsWithMemberLogin")	
	public static Object [][] BookFreeFacilityWith30MintsSlotWithMemberLogin()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("BookFree30MintsWithMemberLogin");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	        	 for (int j=0; j<columns; j++){  
	    	                    Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	        	 }      
	        }
	                return inputdata;
	
	}
	
	
	
	
	
	
	
	
	
	
	@DataProvider    (name = "PaidFacilityOnlyForOwners")	
	public static Object [][] PaidFacilityOnlyForOwners()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityOnlyForOwners");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "EditPaidFacilityOnlyForOwners")	
	public static Object [][] EditPaidFacilityOnlyForOwners()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityOnlyForOwners");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-11]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=11; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-11] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	
	
	
	
	
	@DataProvider    (name = "PaidFacilityOnlyForTenants")	
	public static Object [][] PaidFacilityOnlyForTenants()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityOnlyForTenants");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	@DataProvider    (name = "EditPaidFacilityOnlyForTenants")	
	public static Object [][] EditPaidFacilityOnlyForTenants()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityOnlyForTenants");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-12]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=12; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-12] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	
	
	
	
	@DataProvider    (name = "PaidFacilityOnlyForOthers")	
	public static Object [][] PaidFacilityOnlyForOthers()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityOnlyForOthers");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	@DataProvider    (name = "EditPaidFacilityOnlyForOthers")	
	public static Object [][] EditPaidFacilityOnlyForOthers()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityOnlyForOthers");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-12]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=12; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-12] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	
	@DataProvider    (name = "PaidFacilityForBoth")	
	public static Object [][] PaidFacilityForBoth()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityForBoth");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "EditPaidFacilityForBoth")	
	public static Object [][] EditPaidFacilityForBoth()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("PaidFacilityForBoth");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-13]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=13; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-13] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "FacilityWithHalfAndFullDayPrices")	
	public static Object [][] FacilityWithHalfAndFullDayPrices()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityWithHalfAndFullDayPrice");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	@DataProvider    (name = "EditFacilityWithHalfAndFullDayPrices")	
	public static Object [][] EditFacilityWithHalfAndFullDayPrices()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityWithHalfAndFullDayPrice");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-14]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=14; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-14] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	
	
	
	
	@DataProvider    (name = "FacilityWithFullDayPackagePrice")	
	public static Object [][] FacilityWithFullDayPackagePrice()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityWithFullDayPackagePrice");
	        int rows = s.getRows();
	        int columns = s.getColumns()-4;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "EditFacilityWithFullDayPackagePrice")	
	public static Object [][] EditFacilityWithFullDayPackagePrice()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityWithFullDayPackagePrice");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-14]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=14; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-14] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	@DataProvider    (name = "FacilityWithLessthanAllowedTime")	
	public static Object [][] FacilityWithLessthanAllowedTime()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityWithLessthanAllowedTime");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	@DataProvider    (name = "FacilityWithMoreThanAllowedTime")	
	public static Object [][] FacilityWithMoreThanAllowedTime()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityWithMoreThanAllowedTime");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	
	
	
}
