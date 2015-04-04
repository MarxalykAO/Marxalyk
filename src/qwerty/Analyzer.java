package qwerty;

public class Analyzer {		
	public static void main(String[] args) {
		try {			
			IParseLine parseLine = new ParseLine();
			IParsedLineConsoleOutput printObject = new ParsedLineConsoleOutput();
			IProcess fileAnalyzer = new Process(parseLine, printObject);			
			fileAnalyzer.process(args[0], args[1], args[2], args[3]);			
			IFirstReport firstReport = new FirstReport();
			ISecondReport secondReport = new SecondReport();
			IThirdReport thirdReport = new ThirdReport();
			IReports reports = new Reports(firstReport, secondReport, thirdReport);
			reports.buildReport(args[0], args[1], args[2], args[3], args[4]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds");
		}
		catch (NumberFormatException e) {
			System.out.println("False number format.");
		}
	}
}