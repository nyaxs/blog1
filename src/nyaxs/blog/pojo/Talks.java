package nyaxs.blog.pojo;


import java.util.Date;

public class Talks {
	private int id;
	private int talk_author;
	private Date talk_date;
	private String talk_content;
	private int talk_comment_count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTalk_author() {
		return talk_author;
	}
	public void setTalk_author(int talk_author) {
		this.talk_author = talk_author;
	}
	public Date getTalk_date() {
		return talk_date;
	}
	public void setTalk_date(Date talk_date) {
		this.talk_date = talk_date;
	}
	public String getTalk_content() {
		return talk_content;
	}
	public void setTalk_content(String talk_content) {
		this.talk_content = talk_content;
	}
	public int getTalk_comment_count() {
		return talk_comment_count;
	}
	public void setTalk_comment_count(int talk_comment_count) {
		this.talk_comment_count = talk_comment_count;
	}
}
