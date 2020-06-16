package communication.javaMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import common.util.HrProperties;

public class MailSender implements Mailable {
	@Override
	public void send(String title, String text) {
		Properties globalProps = HrProperties.readGlobalProps();
		final String username = globalProps.getProperty("senderMailAddress");
		final String password = globalProps.getProperty("senderPassword");
		final String dstMailAddress = globalProps.getProperty("dstMailAddress");

		Session session = Session.getDefaultInstance(globalProps, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dstMailAddress));
			message.setSubject(title);
			message.setText(text); 
			
			Transport.send(message);
			System.out.println("An Email has been send to: " + dstMailAddress); 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
