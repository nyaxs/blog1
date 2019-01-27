package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Tags;

public interface TagsService {
	int addTag(Tags tag);
	int deleteTag(int tag_id);
	List<Tags> listTagsAll();
}
