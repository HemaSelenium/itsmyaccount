package common;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class DataProvider7 {
@DataProvider    (name = "SimulateFacilityWithHalfAndFullDayPricesWithOwnerLogin")	
public static Object [][] SimulateFacilityWithHalfAndFullDayPricesWithOwnerLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FullAndHalfdayChargesfacility");
int rows = s.getRows();
System.out.println(rows);
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
@DataProvider    (name = "SimulateFacilityWithHalfAndFullDayPricesWithTenantLogin")	
public static Object [][] SimulateFacilityWithHalfAndFullDayPricesWithTenantLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FullAndHalfdayChargesfacility");
int rows = s.getRows();
int columns = s.getColumns()-15;
String inputdata [][]= new String [rows-2][columns-5]; 
for (int i=2; i<rows; i++){
for (int j=5; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-5] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
@DataProvider    (name = "SimulateFacilityWithHalfAndFullDayPricesfor1dayWithAdminLogin")	
public static Object [][] SimulateFacilityWithHalfAndFullDayPricesfor1dayWithAdminLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FullAndHalfdayChargesfacility");
int rows = s.getRows();
int columns = s.getColumns()-10;
String inputdata [][]= new String [rows-2][columns-10]; 
for (int i=2; i<rows; i++){
for (int j=10; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-10] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
@DataProvider    (name = "SimulateFacilityWithHalfAndFullDayPricesfor6hoursWithAdminLogin")	
public static Object [][] SimulateFacilityWithHalfAndFullDayPricesfor6hoursWithAdminLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FullAndHalfdayChargesfacility");
int rows = s.getRows();
int columns = s.getColumns()-5;
String inputdata [][]= new String [rows-2][columns-15]; 
for (int i=2; i<rows; i++){
for (int j=15; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-15] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
@DataProvider    (name = "SimulateFacilityWithHalfAndFullDayPricesfor13hrsWithAdminLogin")	
public static Object [][] SimulateFacilityWithHalfAndFullDayPricesfor13hrsWithAdminLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FullAndHalfdayChargesfacility");
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
@DataProvider    (name = "SimulateFacilityWithpackagePricesWithOwnerLogin")	
public static Object [][] SimulateFacilityWithpackagePricesWithOwnerLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FacilityWithPackagePrices");
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

@DataProvider    (name = "SimulateFacilityWithPackagePricesWithTenantLogin")	
public static Object [][] SimulateFacilityWithPackagePricesWithTenantLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FacilityWithPackagePrices");
int rows = s.getRows();
int columns = s.getColumns()-15;
String inputdata [][]= new String [rows-2][columns-5]; 
for (int i=2; i<rows; i++){
for (int j=5; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-5] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	
@DataProvider    (name = "SimulateFacilityWithPackagePricesfor1dayWithAdminLogin")	
public static Object [][] SimulateFacilityWithPackagePricesfor1dayWithAdminLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FacilityWithPackagePrices");
int rows = s.getRows();
int columns = s.getColumns()-10;
String inputdata [][]= new String [rows-2][columns-10]; 
for (int i=2; i<rows; i++){
for (int j=10; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-10] = cl.getContents();
	                       
	            }
	        }
	                return inputdata;
	
	}	

@DataProvider    (name = "SimulateFacilityWithpackagePricesfor6hoursWithAdminLogin")	
public static Object [][] SimulateFacilityWithpackagePricesfor6hoursWithAdminLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FacilityWithPackagePrices");
int rows = s.getRows();
int columns = s.getColumns()-5;
String inputdata [][]= new String [rows-2][columns-15]; 
for (int i=2; i<rows; i++){
for (int j=15; j<columns; j++){   
Cell cl = s.getCell(j,i);
inputdata [i-2][j-15] = cl.getContents();
	                  
	            }
	        }
	                return inputdata;
	
	}	

@DataProvider    (name = "SimulateFacilityWithPackagePricesfor5hrsWithAdminLogin")	
public static Object [][] SimulateFacilityWithPackagePricesfor5hrsWithAdminLogin()  throws  IOException, BiffException  {
File fs = new File(GlobalVariablesCalling.VariablesFileLocation);
Workbook ws= Workbook.getWorkbook(fs);
Sheet s = ws.getSheet("FacilityWithPackagePrices");
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
