package common;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider3 {
	@DataProvider    (name = "AdminPostageAndCourier")	
	public static Object [][] AdminPostageAndCourier()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminPostageAndCourier");
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
	@DataProvider    (name = "AdminServantMaidList")	
	public static Object [][] AdminServantMaidList()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminServantMaidList");
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
	
	@DataProvider    (name = "MeetingBookedWithoutSms")	
	public static Object [][] MeetingBookedWithoutSms()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MeetingWithoutSms");
	        int rows = s.getRows();
	        int columns = s.getColumns()-5;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "MeetingBookedWithoutSmsWithAlreadyBookedDetails")	
	public static Object [][] MeetingBookedWithoutSmsWithAlreadyBookedDetails()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MeetingWithoutSms");
	        int rows = s.getRows();
	        int columns = s.getColumns()-1;
	      	String inputdata [][]= new String [rows-1][columns-5]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=5; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-5] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}		
	
	@DataProvider    (name = "MeetingBookedWithSms")	
	public static Object [][] MeetingBookedWithSms()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MeetingWithSMS");
	        int rows = s.getRows();
	        int columns = s.getColumns()-6;
	      	String inputdata [][]= new String [rows-1][columns]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}
	@DataProvider    (name = "MeetingBookedWithtSmsWithAlreadyBookedDetails")	
		public static Object [][] MeetingBookedWithSmsWithAlreadyBookedDetails()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MeetingWithSMS");
	        int rows = s.getRows();
	        int columns = s.getColumns()-1;
	      	String inputdata [][]= new String [rows-1][columns-6]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=6; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-6] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	@DataProvider    (name = "AddSocietyDocument")	
	public static Object [][] AddSocietyDocument()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminSocietyDocuments");
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
	@DataProvider    (name = "DeleteSocietyDocument")	
	public static Object [][] DeleteSocietyDocument()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminSocietyDocuments");
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
	@DataProvider    (name = "EditSocietyDocument")	
	public static Object [][] EditSocietyDocument()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("AdminSocietyDocuments");
	        int rows = s.getRows();
	        int columns = s.getColumns()-1;
	      	String inputdata [][]= new String [rows-1][columns-5]; 
	        for (int i=1; i<rows; i++){
	    	       for (int j=5; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i-1][j-5] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	@DataProvider    (name = "MyAccountFilter")	
	public static Object [][] MyAccountFilter()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MyAccountFilter");
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
	@DataProvider    (name = "ContactIMAHelpDesk")	
	public static Object [][] ContactIMAHelpDesk()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("ContactIMAHelpDesk");
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
	@DataProvider    (name = "CreateComplaintByNonMember")	
	public static Object [][] CreateComplaint()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("CreateComplaintByNonMember");
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
	
	@DataProvider    (name = "EditComplaintByNonMember")	
	public static Object [][] EditComplaints()  throws  IOException, BiffException  {
		
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("CreateComplaintByNonMember");
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
	
	@DataProvider    (name = "CancelMeeting")	
	public static Object [][] CancelMeeting()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MeetingWithoutSms");
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
	@DataProvider    (name = "CancelBookedMeetingWithSms")	
	public static Object [][] CancelBookedMeetingWithSms()  throws  IOException, BiffException  {
		 File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	        Workbook ws= Workbook.getWorkbook(fs);
	        Sheet s = ws.getSheet("MeetingWithSMS");
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
	
	
	
}
