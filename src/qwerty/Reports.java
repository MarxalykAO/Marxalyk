package qwerty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Reports implements IReports {	
	private IFirstReport firstReport;
	private ISecondReport secondReport;
	private IThirdReport thirdReport;
	public Reports(IFirstReport firstReport, ISecondReport secondReport, IThirdReport thirdReport) {		
		this.firstReport = firstReport;
		this.secondReport = secondReport;
		this.thirdReport = thirdReport;
	}
	@Override
	public void buildReport(String logFileName, String startLine, String countOfLines, String outputFileName, String numberOfReport) {				
		Date timePeriodSince = new Date();
		Date timePeriodUntil = new Date();
		try {			
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Since (in format: dd/MMM/yyyy:HH:mm:ss Z) : ");
			timePeriodSince = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z" , Locale.US).parse(consoleReader.readLine());
			System.out.print("Until (in format: dd/MMM/yyyy:HH:mm:ss Z) : ");
			timePeriodUntil = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z" , Locale.US).parse(consoleReader.readLine());
		}
		catch (ParseException e) {
			System.out.println("Wrong format.");
		}
		catch (IOException e) {			
			e.printStackTrace();
		}
		if(Integer.parseInt(numberOfReport) == 1) firstReport.s(logFileName, startLine, countOfLines, outputFileName, timePeriodSince, timePeriodUntil);
		if(Integer.parseInt(numberOfReport) == 2) secondReport.sumBytesInReply(logFileName, startLine, countOfLines, outputFileName, timePeriodSince, timePeriodUntil);
		if(Integer.parseInt(numberOfReport) == 3) thirdReport.maxBytesInRequest(logFileName, startLine, countOfLines, outputFileName, timePeriodSince, timePeriodUntil);
		
	}
}