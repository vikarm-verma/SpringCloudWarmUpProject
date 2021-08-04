package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId")Long userId)
	{
		//return this.userService.getUser(userId);
		
		User user = this.userService.getUser(userId);
		//Here the problem is localhost is hardcoded ,so suppose if we have thousands of services running then at that time it
		//will create trouble , so for solving this we need eureka server.
		//Eureka Server - Registers the services
		//List contacts = this.restTemplate.getForObject("http://localhost:9002/contact/user/"+user.getUserId(), List.class);
		List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
		user.setContact(contacts);
		return user;
	}

}
