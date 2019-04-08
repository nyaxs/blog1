package nyaxs.blog.service;

import java.util.Date;
import java.util.List;

import nyaxs.blog.pojo.Logs;

public interface LogsService {
	int addLog(Logs log);
	int deleteLogById(int id);
	int deleteLogByType(String type);
	List<Logs> getLogsByType(String type);
	/* First record -----> DateO ] ... */
	/* ... [ DateH -----> Present */
	/* ... [ DateH -----> DateO ] ... */
	/* deprecated comments */
	/* New: from date to date2 */
	List<Logs> getLogsByDate(Date date, Date date2);
}
