package ch05.domain;
// ch05 ���� dynamic sql    <if>
public class Post {
	private String title;
	private String content;
	
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return title + ": " + content;
	}
}
