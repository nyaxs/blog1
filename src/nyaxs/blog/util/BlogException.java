package nyaxs.blog.util;

/*
 * 自定义异常类
 */
public class BlogException extends Exception{
	
	private String exMessage;
	
	public BlogException(String exMessage) {
		this.setExMessage(exMessage);
	}

	public String getExMessage() {
		return exMessage;
	}

	public void setExMessage(String exMessage) {
		this.exMessage = exMessage;
	}
}
