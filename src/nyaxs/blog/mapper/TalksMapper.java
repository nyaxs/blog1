package nyaxs.blog.mapper;

import java.util.List;
import nyaxs.blog.pojo.Talks;

public interface TalksMapper {
	void addTalk(Talks talk) throws Exception;
	void deleteTalk(int id) throws Exception;
	void updateTalk(Talks talk) throws Exception;
	List<Talks> listTalksByUserId(int userId) throws Exception;
	List<Talks> listTalksAll() throws Exception;
}
