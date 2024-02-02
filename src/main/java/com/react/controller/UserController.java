package com.react.controller;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.entity.User;

@RestController
public class UserController {

	private static void sleepexe() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/get/users")
	public List<User> getAllUsers() {

		return IntStream.rangeClosed(1, 10).peek(i -> {
					sleepexe();})
				.peek(u -> System.out.println("processing count : " + u))
				.mapToObj(i -> new User(i, "name" + i))
				.collect(Collectors.toList());

	}

}
