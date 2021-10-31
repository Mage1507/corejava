package excelgeneration;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;



public class RmiExcelServer {
   public static void main(String[] args) throws Exception {
	    ExcelImplementation server = new ExcelImplementation();
	    
		LocateRegistry.createRegistry(2000);
		
		Naming.bind("rmi://localhost:2000/excelserver",server);
		
		System.out.println("Server is running.");
}
}
