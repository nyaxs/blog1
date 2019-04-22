package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nyaxs.blog.mapper.TalksMapper;
import nyaxs.blog.pojo.Talks;
import nyaxs.blog.service.TalksService;
import nyaxs.blog.util.BlogException;

@Service
public class TalksServiceImpl implements TalksService {

	@Autowired
	TalksMapper talkMapper;

	@Override
	public int addTalk(Talks talk) throws Exception {
		talkMapper.addTalk(talk);
		return 1;
	}

	@Override
	public int deleteTalk(int id) throws Exception {
		talkMapper.deleteTalk(id);
		return 1;
	}

	@Override
	public int updateTalk(Talks talk) throws Exception {
		talkMapper.deleteTalk(talk.getId());
		return 1;
	}

	@Override
	public List<Talks> listTalksByUserId(int userId) throws Exception {
		List<Talks> list = talkMapper.listTalksByUserId(userId);
		if(list == null) {
			throw new BlogException("获取到的TalksListByUserId为空");
		}
		return list;
	}

	@Override
	public List<Talks> listTalksAll() throws Exception {
		List<Talks> list = talkMapper.listTalksAll();
		if(list == null) {
			throw new BlogException("获取到的TalksListAll为空");
		}
		return list;
	}

	
}
