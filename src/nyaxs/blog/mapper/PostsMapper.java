package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.Posts;

public interface PostsMapper {
	void addPost(Posts post);
	void deletePost(int id);
	List<Posts> getPostByTitle(String title);
	void updatePostTitle(Posts post);
	List<Posts> listPostsByUserId(int userId);
	List<Posts> listPostsAll();
	
}
