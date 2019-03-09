package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.TalksMapper;
import nyaxs.blog.pojo.Talks;
import nyaxs.blog.service.TalksService;

@Service
public class TalksServiceImpl implements TalksService {
	
	@Autowired
	TalksMapper talkMapper;

	@Override
	public int addTalk(Talks talk) {
		// TODO Auto-generated method stub
		try {
			talkMapper.addTalk(talk);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteTalk(int id) {
		// TODO Auto-generated method stub
		talkMapper.deleteTalk(id);
		return 1;
	}

	@Override
	public List<Talks> listTalksByUserId(int userId) {
		return talkMapper.listTalksByUserId(userId);
	}

	@Override
	public List<Talks> listTalksAll() {
		return talkMapper.listTalksAll();
	}

}
