package nyaxs.blog.service;

import java.util.List;

import nyaxs.blog.pojo.Comments;

public interface CommentsService {
	int addComment(Comments comment);
	int deleteComment(int comment_id);
	List<Comments> listCommentsByPost(int comment_post_id);
	List<Comments> listCommentsByUser(int comment_user_id);
}
