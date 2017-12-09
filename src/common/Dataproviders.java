package common;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Dataproviders {
		
	@DataProvider    (name = "MemberLoginDetails")
    public static Object [][] MemberLoginDetails()  throws  IOException, BiffException  {
        
    File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
        Workbook ws= Workbook.getWorkbook(fs);
        Sheet s = ws.getSheet("MemberLoginDetails");
        int rows = s.getRows();
        int columns = s.getColumns();
       /* System.out.println("rows: "+rows);
        System.out.println("columns: "+columns);*/
        String inputdata [][]= new String [rows-1][columns]; 
       for (int i=1; i<rows; i++){
    	  
       for (int j=0; j<columns; j++){   
                Cell cl = s.getCell(j,i);
                inputdata [i-1][j] = cl.getContents();
                        
            }
        }
                return inputdata;
    }
		
	
	
	@DataProvider    (name = "Facility")	
	public static Object [][] Addfacility()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("FacilityAdd");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	       /* System.out.println("rows: "+rows);
	        System.out.println("columns: "+columns);*/
	        String inputdata [][]= new String [rows-1][columns]; 
	       for (int i=1; i<rows; i++){
	    	  
	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "SocietyAssets")	
	public static Object [][] AddAsset()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("SocietyAssets");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	       /* System.out.println("rows: "+rows);
	        System.out.println("columns: "+columns);*/
	        String inputdata [][]= new String [rows-1][columns]; 
	       for (int i=1; i<rows; i++){
	    	  
	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	
	
	@DataProvider    (name = "RenewAmcWithServiceCompletion")	
	public static Object [][] RenewAmcWithServiceCompletion()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("RenewAmcWithServiceCompletion");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	       /* System.out.println("rows: "+rows);
	        System.out.println("columns: "+columns);*/
	        String inputdata [][]= new String [rows-1][columns]; 
	       for (int i=1; i<rows; i++){
	    	  
	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	
	
	@DataProvider    (name = "AmcDetailsByGivenPeriodOfDates")	
	public static Object [][] AmcDetails()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AmcDetailsByGivenPeriodOfDates");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	       /* System.out.println("rows: "+rows);
	        System.out.println("columns: "+columns);*/
	        String inputdata [][]= new String [rows-1][columns]; 
	       for (int i=1; i<rows; i++){
	    	  
	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	
	
	
	@DataProvider    (name = "MigratedItems")	
	public static Object [][] MigratedItems()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MigratedItems");
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
	
	@DataProvider    (name = "Reciepts")	
	public static Object [][] Reciepts()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Reciepts");
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
	
	@DataProvider    (name = "Issues")	
	public static Object [][] Issues()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("Issues");
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
	
	@DataProvider    (name = "Inchargedetails")	
	public static Object [][] InchargeDetails()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("InchargeDetails");
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
	@DataProvider    (name = "ReportsInSocietyInventory")	
	public static Object [][] ReportsInSocietyInventory()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("ReportsInSocietyInventory");
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
	@DataProvider    (name = "MemberSocietyAssets")	
	public static Object [][] MemberSocietyAssets()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberSocietyAssets");
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
	@DataProvider    (name = "CreateComplaint")	
	public static Object [][] CreateComplaint()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("CreateComplaint");
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
	
	@DataProvider    (name = "EditComplaints")	
	public static Object [][] EditComplaints()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("CreateComplaint");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-6]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=6; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-6] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}			
	@DataProvider    (name = "CreateMemberComplaints")	
	public static Object [][] CreateMemberComplaints()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberComplaints");
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
	
	@DataProvider    (name = "EditMemberComplaints")	
	public static Object [][] EditMemberComplaints()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MemberComplaints");
	        int rows = s.getRows();
	        int columns = s.getColumns();
	      	String inputdata [][]= new String [rows-1][columns-6]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=6; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-6] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}			

	
	
}
