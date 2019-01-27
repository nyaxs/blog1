package nyaxs.blog.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Comments {
	private int comment_id;
	private int comment_post_id;
	private int comment_user_id;
	private Timestamp comment_date;
	private String comment_content;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_post_id() {
		return comment_post_id;
	}
	public void setComment_post_id(int comment_post_id) {
		this.comment_post_id = comment_post_id;
	}
	public int getComment_user_id() {
		return comment_user_id;
	}
	public void setComment_user_id(int comment_user_id) {
		this.comment_user_id = comment_user_id;
	}
	public Timestamp getComment_date() {
		return comment_date;
	}
	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
}
