package com.gtecnologia.store.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gtecnologia.store.entities.User;
import com.gtecnologia.store.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Alex", "alex@gmail.com", "92209999", "1234567");
		User u2 = new User(null, "Jonas", "jonas@gmail.com", "92209999", "1234567");
		User u3 = new User(null, "Mary", "mary@gmail.com", "92209999", "1234567");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

	}

}