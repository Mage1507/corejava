package emailwithattachement;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiEmailServer {
   public static void main(String[] args) throws Exception{
	EmailAttachImpl server = new EmailAttachImpl();
	
	LocateRegistry.createRegistry(2000);
	
	Naming.bind("rmi://localhost:2000/emailattserver", server);
	
	System.out.println("Server is running.");
}
}
