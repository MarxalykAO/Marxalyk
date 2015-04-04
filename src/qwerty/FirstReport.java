package qwerty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FirstReport implements IFirstReport {
	@Override
	public FirstReportRecord s(String logFileName, String startLine, String countOfLines, String outputFileName, Date timePeriodSince, Date timePeriodUntil) {		
		Map <String , Integer> allHosts = new HashMap<String , Integer>();
		FirstReportRecord firstReportRecord = new FirstReportRecord();		
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
						if(logFileRecord.getHostName() == null) {
							Integer oldValue = allHosts.get(logFileRecord.getHostInternetProtocol());
					        if (oldValue == null) {
					            allHosts.put(logFileRecord.getHostInternetProtocol(), 1);
					        } else {
					            allHosts.put(logFileRecord.getHostInternetProtocol(), oldValue + 1);
					        }
						}							
						if(logFileRecord.getHostInternetProtocol() == null) {
							Integer oldValue = allHosts.get(logFileRecord.getHostName());
					        if (oldValue == null) {
					            allHosts.put(logFileRecord.getHostName(), 1);
					        } else {
					            allHosts.put(logFileRecord.getHostName(), oldValue + 1);
					        }
						}
																
						flag = true; 
					}
				}						
				allHosts = new TreeMap<String, Integer>(allHosts);		        
		        Iterator<Entry<String, Integer>> iter = allHosts.entrySet().iterator();
		        while (iter.hasNext()) {
		            Entry<String, Integer> entry = iter.next();
		            System.out.println(entry.getKey());		
		            System.out.println(entry.getValue());		            		            
		        }
			}
			else System.out.println("timePeriodSince can't >= than timePeriodUntil.");			
			fileReader.close();		
		}
		catch (IOException e) {			
			System.out.println("IO error.");
		}		
		if(flag) {
			//System.out.println(thirdReportRecord.getMaxRequest());
			//System.out.println(thirdReportRecord.getBytesInMaxRequest());
		}
		else System.out.println("No replies in this time period.");
		return firstReportRecord;
	}
}