package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.UsersRelationMapper;
import nyaxs.blog.pojo.UsersRelation;
import nyaxs.blog.service.UsersRelationService;
import nyaxs.blog.util.BlogException;

@Service
public class UsersRelationServiceImpl implements  UsersRelationService{

	@Autowired
	UsersRelationMapper userRelationMapper;

	@Override
	public List<UsersRelation> getFollowedList(int id) throws Exception {
		return userRelationMapper.getFollowedList(id);
	}

	@Override
	public List<UsersRelation> getBothFollowedList(int id) throws Exception {
		// TODO Auto-generated method stub
		return userRelationMapper.getBothFollowedList(id);
	}

	@Override
	public List<UsersRelation> getFollwers(int id) throws Exception {
		// TODO Auto-generated method stub
		return userRelationMapper.getFollwers(id);
	}

	@Override
	public void cancelFollowing(int userId, int followedId) throws Exception {
		// TODO Auto-generated method stub
		userRelationMapper.cancelFollowing(userId, followedId);
	}

	public void updateBothRelation(int id1, int id2) throws Exception {
		// TODO Auto-generated method stub
		
		userRelationMapper.updateBothRelationId1(id1, id2);
		userRelationMapper.updateBothRelationId2(id1, id2);
	}
	
	

	@Override
	public void deleteRelationSingle(int userId, int followedId) throws Exception {
		// TODO Auto-generated method stub
		userRelationMapper.deleteRelationSingle(userId, followedId);
	}
	

}
