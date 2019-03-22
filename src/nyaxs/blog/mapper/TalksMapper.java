package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.Talks;

public interface TalksMapper {
	void addTalk(Talks talk);
	void deleteTalk(int id);
	/* no need?: List<Talks> getTalksByKeywords(String keyword); */
	List<Talks> listTalksByUserId(int userId);
	List<Talks> listTalksAll();
}
