package com.speaker.api;

import org.springframework.beans.factory.annotation.Autowired;

import com.speaker.api.repository.*;

public class ServiceFactory {

	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	@Autowired
	private MessageRepository messageRepository;

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}
	
	@Autowired
	private UserRepository userRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}	
}
