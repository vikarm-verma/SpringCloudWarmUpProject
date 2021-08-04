package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	//fake user list
	
	List<User> list=List.of(
			new User(1001L,"Vikram Verma","9008222123" ),
			new User(1002L,"Rahul Verma","8808222156" ),
			new User(1003L,"Rony Verma","9808222777" )
			);	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return this.list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	}
}
