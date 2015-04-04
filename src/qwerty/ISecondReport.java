package qwerty;

import java.util.Date;

public interface ISecondReport {
	public SecondReportRecord sumBytesInReply(String logFileName, String startLine, String countOfLines, String outputFileName, Date timePeriodSince, Date timePeriodUntil);
}
