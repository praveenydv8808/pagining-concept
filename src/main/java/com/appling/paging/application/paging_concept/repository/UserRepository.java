package com.appling.paging.application.paging_concept.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.appling.paging.application.paging_concept.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
