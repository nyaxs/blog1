package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.UsersRelationMapper;
import nyaxs.blog.pojo.UsersRelation;
import nyaxs.blog.service.UsersRelationService;

@Service
public class UsersRelationServiceImpl implements  UsersRelationService{

	@Autowired
	UsersRelationMapper userRelationMapper;

	@Override
	public List<UsersRelation> getFollowedList(int id) throws Exception {
		return userRelationMapper.getFollowedList(id);
	}
	

}
