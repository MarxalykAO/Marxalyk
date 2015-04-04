package qwerty;

import java.util.Date;

public interface IThirdReport {
	public ThirdReportRecord maxBytesInRequest(String logFileName, String startLine, String countOfLines, String outputFileName, Date timePeriodSince, Date timePeriodUntil);
}