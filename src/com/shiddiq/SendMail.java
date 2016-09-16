package com.shiddiq;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {
	
	 final static String username = "someusername";
     final static String password = "somepassword";
     
   public static void main(String [] args) {    
      // Recipient's email ID needs to be mentioned.
      String to = "shiddiqitt@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "shiddiqazis@outlook.com";

      // Assuming you are sending email from localhost
      String host = "smtp-mail.outlook.com";

      // Get system properties
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.auth", "true");
      properties.setProperty("mail.smtp.starttls.enable", "true");
      //properties.setProperty("mail.user", "shiddiqitt@gmail.com");
      //properties.setProperty("mail.password", "Bajika123");
      
      
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      properties.setProperty("mail.smtp.port", "587");

      // Get the default Session object.
      //Session session = Session.getDefaultInstance(properties);
      
      Session session = Session.getInstance(properties,
              new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
              });

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}