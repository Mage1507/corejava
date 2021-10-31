package pdfgeneration;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
	public static void main(String[] args) throws Exception {
		PDFImplementation server = new PDFImplementation();
		
		LocateRegistry.createRegistry(2000);
		
		Naming.bind("rmi://localhost:2000/pdfserver", server);
		
		System.out.println("Server is running.");
	}
}
