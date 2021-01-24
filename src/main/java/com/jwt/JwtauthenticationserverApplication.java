package com.jwt;

import com.jwt.dao.UserRepository;
import com.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class JwtauthenticationserverApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public void createUser() {
		User user = new User();
		Random random = new Random();
		Long id = new Long(random.nextInt(100));
		user.setUsername("user"+id);
		user.setId(id);
		user.setEmail("user"+id+"@gmail.com");
		user.setPassword("user@"+id);
		user.setEnabled(true);
		user.setRole("Admin");

		User save = userRepository.save(user);
		System.out.println(save);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtauthenticationserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUser();
	}
}
