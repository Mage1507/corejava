package excelgeneration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Map;
import java.util.TreeMap;

public class ClientExcel {
    public static void main(String[] args) throws Exception{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Excel excel = (Excel)Naming.lookup("rmi://localhost:2000/excelserver");
		System.out.println("Enter the filename");
		String Filename = in.readLine();
		System.out.println("Enter the worksheetname");
		String Worksheetname = in.readLine();
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "USERNAME", "PASSWORD"});
        data.put("2", new Object[] {1, "Magesh", "1234"});
        data.put("3", new Object[] {2, "Prem", "12345"});
		excel.excelGen(Filename,Worksheetname,data);
		System.out.println("Your file is in path:");
	    File file = new File(Filename);
	    System.out.println(file.getAbsolutePath());
		
	}
}
