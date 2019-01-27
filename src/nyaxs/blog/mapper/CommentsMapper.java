package nyaxs.blog.mapper;

import java.util.List;

import nyaxs.blog.pojo.Comments;

public interface CommentsMapper {
	void addComment(Comments comment);
	void deleteComment(int comment_id);
	List<Comments> listCommentsByPost(int comment_post_id);
	List<Comments> listCommentsByUser(int comment_user_id);
}
