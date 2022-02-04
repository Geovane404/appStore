package com.gtecnologia.store.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtecnologia.store.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User u1 = new User(1L, "Alex", "alex@gmail.com", "92209999", "1234567");
		User u2 = new User(2L, "Jonas", "jonas@gmail.com", "92209999", "1234567");
		User u3 = new User(3L, "Mary", "mary@gmail.com", "92209999", "1234567");

		List<User> list = Arrays.asList(u1, u2, u3);
		return ResponseEntity.ok().body(list);
	}

}
