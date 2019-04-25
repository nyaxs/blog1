package nyaxs.blog.pojo;

import java.util.Date;
import java.util.List;

public class TimeLineBean {
	private int author;
	private String userLogin;
	private String niceName;
	private Date date;
	private String content;
	private String talkDetail;
	private String title;
	private String status;
	private Date modified;
	private String type;
	private int comment_count;
	private int upvote_count;
	private int share_count;
	private int collect_count;
	private List<JointPostTag> tagPost;
	private List<JointTalkTag> tagTalk;
	public int getUpvote_count() {
		return upvote_count;
	}
	public void setUpvote_count(int upvote_count) {
		this.upvote_count = upvote_count;
	}
	public int getShare_count() {
		return share_count;
	}
	public void setShare_count(int share_count) {
		this.share_count = share_count;
	}
	public int getCollect_count() {
		return collect_count;
	}
	public void setCollect_count(int collect_count) {
		this.collect_count = collect_count;
	}

	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public List<JointPostTag> getTagPost() {
		return tagPost;
	}
	public void setTagPost(List<JointPostTag> tagPost) {
		this.tagPost = tagPost;
	}
	public List<JointTalkTag> getTagTalk() {
		return tagTalk;
	}
	public void setTagTalk(List<JointTalkTag> tagTalk) {
		this.tagTalk = tagTalk;
	}
	public String getTalkDetail() {
		return talkDetail;
	}
	public void setTalkDetail(String talkDetail) {
		this.talkDetail = talkDetail;
	}
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

}
