package com.satishgupta.emailsendingapi.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author satishkumar06
 */
@Service
public class EmailService {
    
    public boolean sendEmail(String subject, String message, String to) {
        
                //rest of the code...
                boolean f = false;
                String from = "satishgupta.cse01@gmail.com";
                
        	//Variable for gmail
		String host = "smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("satishgupta.cse01@gmail.com", "8570045570");
			}
			
		});
		
		session.setDebug(true);
		
		// Step 2 : Compose the message [text, multi-media]
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			//from email
			m.setFrom(from);
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send
			//Step 3 : Send the message using Transport class
			Transport.send(m);
			
			System.out.println("Sent successfully....................");
                        f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
                return f;
       
    }

}
