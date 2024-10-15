package com.appling.paging.application.paging_concept.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appling.paging.application.paging_concept.entity.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {
	public Optional<User> findById(Long id);
	
}
