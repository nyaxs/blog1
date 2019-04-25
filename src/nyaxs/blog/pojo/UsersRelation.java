package nyaxs.blog.pojo;

public class UsersRelation {
	private int id;
	private int user_id;
	private int followed_id;
	private int relation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFollowed_id() {
		return followed_id;
	}
	public void setFollowed_id(int followed_id) {
		this.followed_id = followed_id;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
}
