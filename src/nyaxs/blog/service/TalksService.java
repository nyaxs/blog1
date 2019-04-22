package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Talks;

public interface TalksService {
	int addTalk(Talks talk) throws Exception;
	int deleteTalk(int id) throws Exception;
	int updateTalk(Talks talk) throws Exception;
	List<Talks> listTalksByUserId(int userId) throws Exception;
	List<Talks> listTalksAll() throws Exception;
}
