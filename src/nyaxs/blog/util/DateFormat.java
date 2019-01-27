package nyaxs.blog.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateFormat {
	public static Timestamp getCurrentTime() {
		Date date = new Date();       
		Timestamp timeStamep = new Timestamp(date.getTime());
		return timeStamep;
	}
}
