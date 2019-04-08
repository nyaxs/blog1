package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Logs;
import nyaxs.blog.pojo.Talks;

public interface TalksService {
	int addTalk(Talks talk);
	int deleteTalk(int id);
	List<Talks> listTalksByUserId(int userId);
	List<Talks> listTalksAll();
	public void toLog(Logs log);
}
