package qwerty;

public class ParsedLineConsoleOutput implements IParsedLineConsoleOutput {
	@Override
	public void parsedLineConsoleOutput(LogFileRecord parsedLine) {
		parsedLine.print(parsedLine);
	}
}