package qwerty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Process implements IProcess {
	private IParseLine parseLine;
	private IParsedLineConsoleOutput printObject;
	public Process(IParseLine parseLine, IParsedLineConsoleOutput printObject) {
		this.parseLine = parseLine;
		this.printObject = printObject;
	}
	@Override
	public void process(String logFileName, String startLine, String countOfLines, String outputFileName) {		
		String lineToParse = "";
	    BufferedReader fileReader = null;
	    //BufferedWriter fileWriter = null;
		try {			
			fileReader = new BufferedReader(new FileReader(logFileName));
			//fileWriter = new BufferedWriter(new FileWriter(new File(args3)));
			for(int i = 0; i < Integer.parseInt(startLine); i++) {
				fileReader.readLine();
			}
			for(int i = 0; i < Integer.parseInt(countOfLines); i++) {
				lineToParse = fileReader.readLine();
				//if(i == Integer.parseInt(args2) - 1) S = fileReader.readLine();
				//else S = fileReader.readLine()+"\r\n";
				//fileWriter.write(S);
				printObject.parsedLineConsoleOutput(parseLine.parseLine(lineToParse));				
				System.out.println("______________\n");
			}
			fileReader.close();
			//fileWriter.close();
		}
		catch (IOException e) {			
			System.out.println("IO error.");
		}
	}
}