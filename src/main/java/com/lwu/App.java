package com.lwu;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.google.protobuf.Message;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	//getting random
    	RnadomCode rndom= new RnadomCode();
    	String code=rndom.getRandomCode(6);
    	
        //working
    	//Message Part
    	
    	
    	
    	
    	
    	 String mess = "Dear User,\n\nThank you for registering.\nYour Verification Code is: " + code + "\n\nBest regards,\nYour Name"+"\nMessage Sent at"+"\n"+new Date().toString();
    	
    	String subject="Enrollment Confirmmation :EvotingIndia";
    	String to="uks245899@gmail.com";
    	String from ="evotingofficial54@gmail.com";
    	
    	sendEmail(mess,subject,to,from);
    	
    	
    	
    	
    	
    	
    }
    //this method is to send email;

	private static void sendEmail(String mess, String subject, String to, String from) {
		// TODO Auto-generated method stub
		String host="smtp.gmail.com";
		
		//get the system propertires
		
		Properties properties=System.getProperties();
		
		//mapping/setting the important properties to the object
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1 get the session object
		
		
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("evotingofficial54@gmail.com", "lvpbzcrkqoydmril");
			}
			
			
		});
		
		//step 2 compose  message
		
	MimeMessage m=	new MimeMessage(session);
	
	//from email configuration
	
	try {
		m.setFrom(from);
		
		//adding reciprent
		m.addRecipient(RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		
		m.setSubject(subject);
		//Adding text to 
		m.setText(mess);
		
		Transport.send(m);
		
		System.out.println("Sent Sucessfully..........");
		
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
		
		
		
		
		
		
		 
		
	}
}

