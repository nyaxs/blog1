package nyaxs.blog.pojo;

import java.util.Date;

public class Logs {
	private int id;
	private Date log_date;
	/* log_type: "information" or "exception" */
	private String log_type;
	private String log_content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return log_date;
	}
	public void setDate(Date log_date) {
		this.log_date = log_date;
	}
	
	public String getType() {
		return log_type;
	}
	public void setType(String log_type) {
		this.log_type = log_type;
	}
	
	public String getContent() {
		return log_content;
	}
	public void setContent(String log_content) {
		this.log_content = log_content;
	}
	
}
