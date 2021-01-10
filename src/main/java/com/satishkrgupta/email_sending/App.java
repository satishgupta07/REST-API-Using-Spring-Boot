package com.satishkrgupta.email_sending;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("preparing to send message...");
        String message = "Hello, Dear this is message for security check.";
        String subject = "CodersArea : Confirmation";
        String to = "sg8939687@gmail.com";
        String from = "satishgupta.cse01@gmail.com";
        
        sendEmail(message, subject, to , from);
    }

    //this is responsible to send email..
	private static void sendEmail(String message, String subject, String to, String from) {
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
