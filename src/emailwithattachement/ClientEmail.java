package emailwithattachement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class ClientEmail {
  public static void main(String[] args) throws Exception {
	  EmailAttachement mail = (EmailAttachement)Naming.lookup("rmi://localhost:2000/emailattserver");
	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	  System.out.println("Enter the Receiptent email address:");
	  String to = in.readLine();
	  System.out.println("Enter the Subject of the Mail:");
	  String subject = in.readLine();
	  System.out.println("Enter the Sending FileName:");
	  String filename = in.readLine();
	  System.out.println("Enter the message to send");
	  String content = in.readLine();
	  mail.sendEmail(to,subject,filename,content);
}
}
