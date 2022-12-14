package ch05.ex02;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		User user = mapper.selectUser(new Search("john", new Post(null, null)));
		user = mapper.selectUser(new Search("john", new Post("舛税", null)));
		user = mapper.selectUser(new Search("john", new Post(null, "壱軒")));
		// choose 紫遂生稽 蒋拭 繕闇幻 限焼亀 衣引葵戚 蟹紳陥.
		user = mapper.selectUser(new Search("john", new Post("舛税", "いけしけいし")));
		
		System.out.println(user);
	}
}
