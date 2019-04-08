package nyaxs.blog.mapper;

import java.util.Date;
import java.util.List;

import nyaxs.blog.pojo.Logs;

public interface LogsMapper {
	void addLog(Logs log);
	void deleteLogById(int id);
	void deleteLogByType(String type);
	List<Logs> getLogsByType(String type);
	/* First record -----> DateO ] ... */
	/* ... [ DateH -----> Present */
	/* ... [ DateH -----> DateO ] ... */
	/* deprecated comments */
	/* New: from date to date2 */
	List<Logs> getLogsByDate(Date date, Date date2);

}
