package trello.qsp.genericutility;

import java.time.LocalDateTime;

public class JavaUtility {
	
	public String localDateTime() {
		String ldt = LocalDateTime.now().toString().replace(':', '-');
		
		return ldt;
	}

}
