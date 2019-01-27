package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.JointPostTag;

public interface JointPostTagService {
	List<JointPostTag> getListTagsByPost(int post_id);
	List<JointPostTag> getListPostByTag(int tag_id);
}
