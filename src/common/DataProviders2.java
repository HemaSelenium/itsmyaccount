package common;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProviders2 {
	@DataProvider    (name = "ChangestatusOfComplaintToPicked")	
	public static Object [][] ChangestatusOfComplaintToPicked()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("ChangestatusOfComplaintToPicked");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}			

	@DataProvider    (name = "ChangeComplaintStatusToClosed")	
	public static Object [][] ChangeComplaintStatusToClosed()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("ChangeComplaintStatusToClosed");
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
	@DataProvider    (name = "MemberComplaintTracker")	
	public static Object [][] MemberComplaintTracker()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberComplaintTracker");
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
	@DataProvider    (name = "AdminPdc")	
	public static Object [][] AdminPdc()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminPdc");
	        int rows = s.getRows();
	        int columns = s.getColumns()-7;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "EditPdc")	
	public static Object [][] EditPdc()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminPdc");
	        int rows = s.getRows();
	        int columns = s.getColumns()-3;
	      	String inputdata [][]= new String [rows-1][columns-11]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=11; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-11] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	
	@DataProvider    (name = "DeletePdc")	
	public static Object [][]DeletePdcInAdmin()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminPdc");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-15]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=15; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-15] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}			
		
	@DataProvider    (name = "MemberPdc")	
	public static Object [][]MemberPdc()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberPdc");
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
	
	@DataProvider    (name = "MemberPersonalDocuments")	
	public static Object [][]MemberPersonalDocuments()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberPersonalDocuments");
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
	
	
	
	@DataProvider    (name = "MemberCategoryInMyCommitments")	
	public static Object [][]MemberCategoryInMyCommitments()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberCategoryInMyCommitments");
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
	
	
	@DataProvider    (name = "AddCategoryInMyCommitments")	
	public static Object [][]AddCategoryInMyCommitments()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AddCategoryInMyCommitments");
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

	@DataProvider    (name = "CreateCommitment")	
	public static Object [][]CreateCommitment()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("CreateCommitment");
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
	@DataProvider    (name = "MaintenanceTeamMembers")	
	public static Object [][]MaintenanceTeamMembers()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MaintenaceMembers");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
@DataProvider    (name = "RegularVendors")	
public static Object [][]RegularVendors()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("RegularVendors");
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
@DataProvider    (name = "RegularVendorsWithBadgeId")	
public static Object [][]RegularVendorsWithBadgeId()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("RegularVendors");
int rows = s.getRows();
int columns = s.getColumns()-1;
String inputdata [][]= new String [rows-2][columns-10]; 
for (int i=2; i<rows; i++){
for (int j=10; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-10] = cl.getContents();
                       
	            }
	        }
	                return inputdata;
	
	}	
	
	

	
	
	@DataProvider    (name = "RegularVendorsWithBadgeIdWithoutSMSTick")	
	public static Object [][]RegularVendorsWithBadgeIdWithoutSMSTick()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("RegularVendorWithoutSMSTick");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-2][columns]; 
	        for (int i=2; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider    (name = "RegularVendorsWithExistedBadgeId")	
	public static Object [][]RegularVendorsWithExistedBadgeId()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("RegularVendors");
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
	
	
	
	
	
	@DataProvider    (name = "VisitorRegister")	
	public static Object [][]VisitorRegister()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("VisitorRegister");
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
	@DataProvider    (name = "AdminCurrentEvents")	
	public static Object [][]AdminCurrentEvents()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminCurrentEvents");
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
	
	@DataProvider    (name = "ChangeStatusByNonMember")	
	public static Object [][] ChangeStatusByNonMember() throws BiffException, IOException   {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("ChangeStatusByNonMember");
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
