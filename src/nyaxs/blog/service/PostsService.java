package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Posts;

public interface PostsService {
	int addPost(Posts post);
	int deletePost(int id);
	List<Posts> getPostByTitle(String title);
	int updatePostTitle(Posts post);
	List<Posts> listPostsByUserId(int userId);
	List<Posts> listPostsAll();
	Posts getPostById(int id)throws Exception;
}
