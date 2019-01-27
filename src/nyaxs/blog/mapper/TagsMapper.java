package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.Tags;

public interface TagsMapper {
	void addTag(Tags tag);
	void deleteTag(int tag_id);
	List<Tags> listTagsAll();
}
