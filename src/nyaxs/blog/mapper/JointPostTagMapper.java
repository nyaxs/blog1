package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.JointPostTag;

public interface JointPostTagMapper {
	List<JointPostTag> getListTagsByPost(int post_id);
	List<JointPostTag> getListPostByTag(int tag_id);
}
