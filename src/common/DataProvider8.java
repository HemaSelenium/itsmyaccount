package common;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProvider8 {
	@DataProvider    (name = "vacantcarparking")	
	public static Object [][] vacantcarparking()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("vacantcarparking");
	int rows = s.getRows();
	int columns = s.getColumns()-6;
	String inputdata [][]= new String [rows-1][columns]; 
	for (int i=1; i<rows; i++){
	for (int j=0; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-1][j-0] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "EditCarparkingDetails")	
	public static Object [][] EditCarparkingDetails()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("vacantcarparking");
	int rows = s.getRows();
	int columns = s.getColumns()-5;
	String inputdata [][]= new String [rows-1][columns-5]; 
	for (int i=1; i<rows; i++){
	for (int j=5; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-1][j-5] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "addvacantcarparking")	
	public static Object [][] addvacantcarparking()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("vacantcarparking");
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
	
	@DataProvider    (name = "Visitor")	
	public static Object [][] AllotParkingLotToVisitor()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("Visitor");
	int rows = s.getRows();
	int columns = s.getColumns()-13;
	String inputdata [][]= new String [rows-2][columns]; 
	for (int i=2; i<rows; i++){
	for (int j=0; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-0] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "VisitorRecord2")	
	public static Object [][] VisitorRecord2()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("Visitor");
	int rows = s.getRows();
	int columns = s.getColumns()-4;
	String inputdata [][]= new String [rows-2][columns-8]; 
	for (int i=2; i<rows; i++){
	for (int j=8; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-8] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "Frequent")	
	public static Object [][] FrequentVisitor()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("Visitor");
	int rows = s.getRows();
	int columns = s.getColumns();
	String inputdata [][]= new String [rows-2][columns-17]; 
	for (int i=2; i<rows; i++){
	for (int j=17; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-17] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "ServantMaidList")	
	public static Object [][] Servant()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("ServantMaidList");
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
	@DataProvider    (name = "ServantMaidListWithBadgeID")	
	public static Object [][] ServantMaidListWithBadgeID()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("ServantMaidListWithBadgeID");
	int rows = s.getRows();
	int columns = s.getColumns()-1;
	String inputdata [][]= new String [rows-2][columns]; 
	for (int i=2; i<rows; i++){
	for (int j=0; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "EditServantMaidListWithExistedBadgeID")	
	public static Object [][] EditServantMaidListWithExistedBadgeID()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("ServantMaidListWithBadgeID");
	int rows = s.getRows();
	int columns = s.getColumns();
	String inputdata [][]= new String [rows-2][columns-8]; 
	for (int i=2; i<rows; i++){
	for (int j=8; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-8] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}		
	
	
	
	@DataProvider    (name = "InhouseWithBadgeID")	
	public static Object [][] InhouseWithBadgeID()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("InHouseStaffWithBadgeID");
	int rows = s.getRows();
	int columns = s.getColumns()-13;
	String inputdata [][]= new String [rows-2][columns]; 
	for (int i=2; i<rows; i++){
	for (int j=0; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	
	@DataProvider    (name = "EditInhouseStaffDetails")	
	public static Object [][] EditInhouseStaffDetails()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("InHouseStaffWithBadgeID");
	int rows = s.getRows();
	int columns = s.getColumns()-21;
	String inputdata [][]= new String [rows-3][columns-1]; 
	for (int i=3; i<rows; i++){
	for (int j=1; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-3][j-1] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	
	
	@DataProvider    (name = "ExistedBadgeID")	
	public static Object [][] ExistedBadgeID()  throws  IOException, BiffException  {
		
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("InHouseStaffWithBadgeID");
	int rows = s.getRows()-1;
	int columns = s.getColumns()-12;
	String inputdata [][]= new String [rows-2][columns-11]; 
	for (int i=2; i<rows;i++){
	for (int j=11; j<columns;j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-11] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
	@DataProvider    (name = "InhouseStaffWithoutSMSTick")	
	public static Object [][] InhouseStaffWithoutSMSTick()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("InHouseStaffWithBadgeID");
	int rows = s.getRows()-1;
	int columns = s.getColumns()-1;
	String inputdata [][]= new String [rows-2][columns-12]; 
	for (int i=2; i<rows; i++){
	for (int j=12; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-12] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	
@DataProvider    (name = "EditWithExistedBadgeIDAndWithoutSMSTick")	
	public static Object [][] EditWithExistedBadgeIDAndWithoutSMSTick()  throws  IOException, BiffException  {
	File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
	Workbook ws= Workbook.getWorkbook(fs);
	Sheet s = ws.getSheet("InHouseStaffWithBadgeID");
	int rows = s.getRows()-1;
	int columns = s.getColumns();
	String inputdata [][]= new String [rows-2][columns-23]; 
	for (int i=2; i<rows; i++){
	for (int j=23; j<columns; j++){   
	Cell cl = s.getCell(j,i);
	inputdata [i-2][j-23] = cl.getContents();
		                       
		            }
		        }
		                return inputdata;
		
		}	

@DataProvider    (name = "EditServantMaidListWithBadgeID")	
public static Object [][] EditServantMaidListWithBadgeID()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("ServantMaidListWithBadgeID");
int rows = s.getRows();
int columns = s.getColumns()-8;
String inputdata [][]= new String [rows-2][columns]; 
for (int i=2; i<rows; i++){
for (int j=0; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
	
	
}
