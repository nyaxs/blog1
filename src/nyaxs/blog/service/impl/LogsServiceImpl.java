package nyaxs.blog.service.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.LogsMapper;
import nyaxs.blog.pojo.Logs;
import nyaxs.blog.service.LogsService;

/* For TEST. I don't know weather it's of use... */
import nyaxs.blog.service.TalksService;

@Service
public class LogsServiceImpl implements LogsService {
	
	@Autowired
	LogsMapper logMapper;
	private Logs log;

	@Override
	public int addLog(Logs log) {
		// TODO Auto-generated method stub
		try {
			logMapper.addLog(log);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteLogById(int id) {
		logMapper.deleteLogById(id);
		return 1;
	}

	@Override
	public int deleteLogByType(String type) {
		logMapper.deleteLogByType(type);
		return 1;
	}
	
	@Override
	public List<Logs> getLogsByType(String type) {
		return logMapper.getLogsByType(type);
	}
	
	@Override
	public List<Logs> getLogsByDate(Date date, Date date2) {
		return logMapper.getLogsByDate(date, date2);
	}
	
	public void logTalk(Logs log)
	{
		this.log=log;
	}
}
