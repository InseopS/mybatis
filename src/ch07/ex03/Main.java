package ch07.ex03;

import java.time.LocalDate;

import ch07.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		System.out.println(mapper.insertUser(
				new User(16, null, LocalDate.of(2025, 5, 25))));
	}
}