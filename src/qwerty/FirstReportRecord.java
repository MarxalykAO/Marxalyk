package qwerty;

import java.util.HashMap;
import java.util.Map;

public class FirstReportRecord {
	private Map<String , Integer> maxHostOrInternetProtocol = new HashMap<String , Integer>();
	public Map<String , Integer> getMaxHostOrInternetProtocol() {
		return maxHostOrInternetProtocol;
	}
	public void setMaxHostOrInternetProtocol(
			Map<String , Integer> maxHostOrInternetProtocol) {
		this.maxHostOrInternetProtocol = maxHostOrInternetProtocol;
	}
}