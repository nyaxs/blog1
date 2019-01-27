package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.PostsMapper;
import nyaxs.blog.pojo.Posts;
import nyaxs.blog.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService {

	@Autowired
	PostsMapper postMapper;

	@Override
	public int addPost(Posts post) {
		// TODO Auto-generated method stub
		try {
			postMapper.addPost(post);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deletePost(int id) {
		postMapper.deletePost(id);
		return 1;
	}

	@Override
	public List<Posts> getPostByTitle(String title) {
		return postMapper.getPostByTitle(title);
	}

	@Override
	public int updatePostTitle(Posts post) {
		postMapper.updatePostTitle(post);
		return 1;
	}

	@Override
	public List<Posts> listPostsByUserId(int userId) {
		return postMapper.listPostsByUserId(userId);
	}

	@Override
	public List<Posts> listPostsAll() {
		return postMapper.listPostsAll();
	}
}
