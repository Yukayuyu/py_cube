package app;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import common.dataIO.FileParser01;



import dataObjects.Record;
import simpleBatis.RecordDAO;


import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


class MailThread extends Thread {

	String title = "要シフト提出";
	String text = "期日までにシフトを提出してください。";
	String e_id;

	final String username = "puttyo76@gmail.com";
	final String password = "10437564tt";
	Properties props = new Properties();

	MailThread(String catchid) {
		this.e_id = catchid;
	}
	
	String empInf(String catchid){
		RecordDAO daodao = new RecordDAO();
		Record theEmp = daodao.getARecordWithPK(catchid);
		String theInf = theEmp.toString();
		return theInf;
	}
	
	String toAddress(String catchid) {
		String address;
		RecordDAO daodao = new RecordDAO();
		address = daodao.getTheEmail(catchid);
		return address;
	}

	@Override
	public void run() {
		

		
		
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		
		
		

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("puttyo76@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress(e_id)));
			message.setSubject(title);
			message.setText(text);
			message.setText(empInf(e_id));

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		String threadNum = Thread.currentThread().getName();
		System.out.println(threadNum + "Done");
	}

}

public class MultipleSendOut  {
	
	public static void main(String[] args) {
		
		RecordDAO daodao = new RecordDAO();
		List <Record> allEmployees = daodao.getAllRecordsFromTable("employee");
		
	
		for(int i =1 ;i<(allEmployees.size()+4);i+=5) {

		MailThread m1 = new MailThread(empId(i));
		MailThread m2 = new MailThread(empId(i+1));
		MailThread m3 = new MailThread(empId(i+2));
		MailThread m4 = new MailThread(empId(i+3));
		MailThread m5 = new MailThread(empId(i+4));

		m1.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();

		try {
			m1.join();
			m2.join();
			m3.join();
			m4.join();
			m5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
	    }
				
		}
		
	}
	
	public static String empId(int y){
		String emp_id;
		if(y<10) {
			emp_id = ("E000"+y);
		}else if(10<=y && y<100) {
			emp_id = ("E00"+y);
		}else if(100<=y && y<1000) {
			emp_id = ("E0"+y);
		}else {
			emp_id = ("E"+y);
		}
		return emp_id;
	}
	
	
	

}
