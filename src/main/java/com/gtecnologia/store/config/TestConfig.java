package com.gtecnologia.store.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gtecnologia.store.entities.Order;
import com.gtecnologia.store.entities.User;
import com.gtecnologia.store.repositories.OrderRepository;
import com.gtecnologia.store.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Alex", "alex@gmail.com", "92209999", "1234567");
		User u2 = new User(null, "Jonas", "jonas@gmail.com", "92209999", "1234567");
		User u3 = new User(null, "Mary", "mary@gmail.com", "92209999", "1234567");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
