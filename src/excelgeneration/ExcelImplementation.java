package excelgeneration;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelImplementation extends UnicastRemoteObject implements Excel {
       public ExcelImplementation() throws Exception {
	
	}
       
       @Override
    public void excelGen(String Filename,String Worksheetname,Map data) throws Exception {
    	   XSSFWorkbook workbook = new XSSFWorkbook(); 
           
           XSSFSheet sheet = workbook.createSheet(Worksheetname);
         

             
     
           Set<String> keyset = data.keySet();
           int rownum = 0;
           for (String key : keyset)
           {
               Row row = sheet.createRow(rownum++);
               Object [] objArr = (Object[]) data.get(key);
               int cellnum = 0;
               for (Object obj : objArr)
               {
                  Cell cell = row.createCell(cellnum++);
                  if(obj instanceof String)
                       cell.setCellValue((String)obj);
                   else if(obj instanceof Integer)
                       cell.setCellValue((Integer)obj);
               }
           }
           try
           {
               //Write the workbook in file system
               FileOutputStream out = new FileOutputStream(new File(Filename+".xlsx"));
               workbook.write(out);
               out.close();
               System.out.println("Generated File Successfully");
           } 
           catch (Exception e) 
           {
               e.printStackTrace();
           }
    	
    }
       
       
}
