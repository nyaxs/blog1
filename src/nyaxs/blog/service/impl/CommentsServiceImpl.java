package nyaxs.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyaxs.blog.mapper.CommentsMapper;
import nyaxs.blog.pojo.Comments;
import nyaxs.blog.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	CommentsMapper commentMapper;
	
	@Override
	public int addComment(Comments comment) {
		// TODO Auto-generated method stub
		try {
			commentMapper.addComment(comment);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteComment(int comment_id) {
		try {
			commentMapper.deleteComment(comment_id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comments> listCommentsByPost(int comment_post_id) {
		// TODO Auto-generated method stub
		try {
			return commentMapper.listCommentsByPost(comment_post_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;	// TODO: handle exception
		}
		
	}

	@Override
	public List<Comments> listCommentsByUser(int comment_user_id) {
		// TODO Auto-generated method stub
		return commentMapper.listCommentsByUser(comment_user_id);
	}

}
