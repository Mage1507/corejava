package emailwithattachement;

import java.rmi.Remote;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailAttachement extends Remote {
      public void sendEmail(String to,String subject,String filename,String message) throws Exception;
}
