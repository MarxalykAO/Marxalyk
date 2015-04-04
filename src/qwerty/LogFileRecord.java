package qwerty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogFileRecord {
	private Host hostInternetProtocolOrName = new Host();
	private Date myDate = new Date();
	private String request;
	private int replyCode;
	private int bytesInReply;
	public void print(LogFileRecord parsedLine) {
		if(parsedLine.getHostInternetProtocol() == null) {
			System.out.println("Host: " + parsedLine.getHostName());
		}
		else {
			System.out.println("IP: " + parsedLine.getHostInternetProtocol());
		}
		System.out.println("Time: " + parsedLine.getMyDate());				
		System.out.println("Request: " + parsedLine.getRequest());
		System.out.println("Reply Code: " + parsedLine.getReplyCode());
		System.out.println("Bytes in reply: " + parsedLine.getBytesInReply());
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getReplyCode() {
		return replyCode;
	}
	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}
	public int getBytesInReply() {
		return bytesInReply;
	}
	public void setBytesInReply(int bytesInReply) {
		this.bytesInReply = bytesInReply;
	}	
	public Date getMyDate() {
		return myDate;
	}
	public void setMyDate(String time) {		
		try {
			myDate = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z" , Locale.US).parse(time);
		}
		catch (ParseException e) {			
			System.out.println("Parse error.");			
		}	
	}
	public String getHostInternetProtocol() {
		return hostInternetProtocolOrName.getInternetProtocol();
	}
	public void setHostInternetProtocol(String internetProtocol) {
		hostInternetProtocolOrName.setInternetProtocol(internetProtocol);
	}
	public String getHostName() {
		return hostInternetProtocolOrName.getName();
	}
	public void setHostName(String name) {
		hostInternetProtocolOrName.setName(name);
	}
}