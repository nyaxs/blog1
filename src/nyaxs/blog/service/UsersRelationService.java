package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.UsersRelation;

public interface UsersRelationService {
	List<UsersRelation> getFollowedList(int id) throws Exception;
}
