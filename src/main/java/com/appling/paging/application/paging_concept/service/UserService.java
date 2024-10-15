package com.appling.paging.application.paging_concept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appling.paging.application.paging_concept.entity.User;
import com.appling.paging.application.paging_concept.exceptionHandling.UserNotFoundException;
import com.appling.paging.application.paging_concept.repository.UserJPARepository;
import com.appling.paging.application.paging_concept.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userPagerRepository;
	@Autowired
	UserJPARepository userJPARepository;

	public Page<User> findUsers(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return userPagerRepository.findAll(pageable);
	}

	public void deleteUserData(int id) {
		User user = userJPARepository.findById((long) id).orElseThrow(() -> new UserNotFoundException("user not found with ID: "+id));
		userJPARepository.delete(user);
	}

	public void addUser(User user) {
		userJPARepository.save(user);
	}
	
	
}
