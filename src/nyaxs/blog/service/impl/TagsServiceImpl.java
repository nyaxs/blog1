package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.TagsMapper;
import nyaxs.blog.pojo.Tags;
import nyaxs.blog.service.TagsService;

@Service
public class TagsServiceImpl implements TagsService{

	@Autowired
	TagsMapper tagMapper;
	
	@Override
	public int addTag(Tags tag) {
		tagMapper.addTag(tag);
		return 1;
	}

	@Override
	public int deleteTag(int tag_id) {
		tagMapper.deleteTag(tag_id);
		return 1;
	}

	@Override
	public List<Tags> listTagsAll() {
		// TODO Auto-generated method stub
		return tagMapper.listTagsAll();
	}

}
