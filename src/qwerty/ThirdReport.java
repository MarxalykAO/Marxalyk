package qwerty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ThirdReport implements IThirdReport {
	@Override
	public ThirdReportRecord maxBytesInRequest(String logFileName, String startLine, String countOfLines, String outputFileName, Date timePeriodSince, Date timePeriodUntil) {
		int max = -1;
		ThirdReportRecord thirdReportRecord = new ThirdReportRecord();		
		IParseLine parseLine = new ParseLine();
		LogFileRecord logFileRecord = new LogFileRecord();
		BufferedReader fileReader = null;		
		boolean flag = false;
		try {			
			fileReader = new BufferedReader(new FileReader(logFileName));						
			if(timePeriodSince.getTime() < timePeriodUntil.getTime()) {
				for(int i = 0; i < Integer.parseInt(startLine); i++) {
					fileReader.readLine();
				}
				for(int i = 0; i < Integer.parseInt(countOfLines); i++) {
					
					logFileRecord = parseLine.parseLine(fileReader.readLine()); 				
					if((logFileRecord.getMyDate().getTime() >= timePeriodSince.getTime()) && (logFileRecord.getMyDate().getTime() <= timePeriodUntil.getTime())) {
						if(logFileRecord.getBytesInReply() > max) {
							max = logFileRecord.getBytesInReply();
							if(logFileRecord.getHostName() == null) thirdReportRecord.setMaxRequest(logFileRecord.getHostInternetProtocol());
							if(logFileRecord.getHostInternetProtocol() == null) thirdReportRecord.setMaxRequest(logFileRecord.getHostName());
							thirdReportRecord.setBytesInMaxRequest(max);
						}							
						flag = true; 
					}
				}				
			}
			else System.out.println("timePeriodSince can't >= than timePeriodUntil.");			
			fileReader.close();		
		}
		catch (IOException e) {			
			System.out.println("IO error.");
		}		
		if(flag) {
			System.out.println("Max bytes in reply on request:");
			System.out.println("Request: " + thirdReportRecord.getMaxRequest());
			System.out.println("Bytes: " + thirdReportRecord.getBytesInMaxRequest());
		}
		else System.out.println("No requests in this time period.");
		return thirdReportRecord;
	}
}