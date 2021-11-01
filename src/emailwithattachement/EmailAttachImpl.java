package emailwithattachement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailAttachImpl extends UnicastRemoteObject implements EmailAttachement{
    private String to;
	private String subject;
	private String filename;
	private String content;
	public EmailAttachImpl() throws Exception{
		
	}
    @Override
    public void sendEmail(String to,String subject,String filename,String content) throws Exception{
    
        String from = "mageshmscss@gmail.com";

        
         this.to = to;
        
         this.subject = subject;
        
         this.filename = filename;
        
         this.content = content;

     
        String host = "smtp.gmail.com";


        Properties properties = new Properties();
		properties.load(new FileInputStream("Email.properties"));

       

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("mageshmscss@gmail.com", "");

            }

        });

        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(from));  
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
        message.setSubject(subject);  

        
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText(content);  
       
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
        
      
        DataSource source = new FileDataSource(filename);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(filename);  
        
        
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  
        
        message.setContent(multipart );  
            
          
        System.out.println("sending...");
            
            
        Transport.send(message);
        System.out.println("Sent message successfully....");
        
        
        

    	
    }
}
