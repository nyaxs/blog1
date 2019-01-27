package nyaxs.blog.pojo;


import java.util.Date;

public class Posts {
	private int id;
	private int post_author;
	private Date post_date;
	private String post_content;
	private String post_title;
	private String post_status;
	private Date post_modified;
	private String post_type;
	private String comment_count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPost_author() {
		return post_author;
	}
	public void setPost_author(int post_author) {
		this.post_author = post_author;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public Date getPost_modified() {
		return post_modified;
	}
	public void setPost_modified(Date post_modified) {
		this.post_modified = post_modified;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public String getComment_count() {
		return comment_count;
	}
	public void setComment_count(String comment_count) {
		this.comment_count = comment_count;
	}
	
}
