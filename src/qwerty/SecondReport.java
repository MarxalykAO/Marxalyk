package qwerty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class SecondReport implements ISecondReport {
	@Override
	public SecondReportRecord sumBytesInReply(String logFileName, String startLine, String countOfLines, String outputFileName, Date timePeriodSince, Date timePeriodUntil) {
		SecondReportRecord secondReportRecord = new SecondReportRecord();		
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
						secondReportRecord.setSumOfBytes(secondReportRecord.getSumOfBytes() + logFileRecord.getBytesInReply());
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
		if(flag) System.out.println("Summ of bytes = " + secondReportRecord.getSumOfBytes());
		else System.out.println("No replies in this time period.");
		return secondReportRecord;
	}
}