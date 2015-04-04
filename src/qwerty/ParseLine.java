package qwerty;

import java.util.regex.Pattern;

public class ParseLine implements IParseLine {	
	@Override
	public LogFileRecord parseLine(String lineToParse) {
		String[] firstSplit = lineToParse.split("( - - )|( \")|(\" )");
		String[] secondSplit = firstSplit[3].split(" ");		
		LogFileRecord parsedLine = new LogFileRecord();
		if(Pattern.matches("[0-9]{2,3}\\.[0-9]{2,3}\\.[0-9]{2,3}\\.[0-9]{2,3}" , firstSplit[0])) {
			parsedLine.setHostInternetProtocol(firstSplit[0]);			
		}
		else {
			parsedLine.setHostName(firstSplit[0]);
		}		
		firstSplit[1] = firstSplit[1].replace("[", "");
		firstSplit[1] = firstSplit[1].replace("]", "");
		parsedLine.setMyDate(firstSplit[1]);
		parsedLine.setRequest("\"" + firstSplit[2] + "\"");
		parsedLine.setReplyCode(Integer.parseInt(secondSplit[0]));
		parsedLine.setBytesInReply(Integer.parseInt(secondSplit[1]));			
		return parsedLine;
	}
}