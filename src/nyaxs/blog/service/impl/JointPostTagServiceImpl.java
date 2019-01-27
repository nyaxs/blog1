package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.JointPostTagMapper;
import nyaxs.blog.pojo.JointPostTag;
import nyaxs.blog.service.JointPostTagService;

@Service
public class JointPostTagServiceImpl implements JointPostTagService{

	@Autowired
	JointPostTagMapper jointPostTagMapper;
	
	@Override
	public List<JointPostTag> getListTagsByPost(int post_id) {
		// TODO Auto-generated method stub
		return jointPostTagMapper.getListTagsByPost(post_id);
	}

	@Override
	public List<JointPostTag> getListPostByTag(int tag_id) {
		// TODO Auto-generated method stub
		return jointPostTagMapper.getListPostByTag(tag_id);
	}

}
