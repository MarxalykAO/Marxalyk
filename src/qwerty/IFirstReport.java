package qwerty;

import java.util.Date;

public interface IFirstReport {
	public FirstReportRecord s(String logFileName, String startLine, String countOfLines, String outputFileName, Date timePeriodSince, Date timePeriodUntil);
}
