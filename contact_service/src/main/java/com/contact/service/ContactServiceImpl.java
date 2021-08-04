package com.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	//fake list of contacts
	
	List<Contact> list = List.of(
			new Contact(1L,"amit@gmail.com","Amit sharma",1001L),
			new Contact(2L,"anit@gmail.com","Anit sharma",1002L),
			new Contact(3L,"Rohan@gmail.com","Rohan sharma",1003L)
			);
	
	@Override
	public List<Contact> getContactToUser(Long userId) {
		// TODO Auto-generated method stub
		return list.stream().filter(contact->contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
