package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.UsersRelation;

public interface UsersRelationMapper {
	List<UsersRelation> getFollowedList(int id) throws Exception;
	List<UsersRelation> getBothFollowedList(int id) throws Exception;
	void updateRelationClear(int id) throws Exception;
	void updateRelationBoth(int id1,int id2) throws Exception; 
}
