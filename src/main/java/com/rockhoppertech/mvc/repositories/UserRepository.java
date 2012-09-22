package com.rockhoppertech.mvc.repositories;

import java.util.List;

import com.rockhoppertech.mvc.domain.User;

/**
 * Stub repository.
 * 
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
public interface UserRepository {

	List<User> findByUsername(String username);

	// Spring Data would define these for you
	User save(User user);

	User findOne(Long id);

	Iterable<User> findAll();

	void delete(User user);

	void delete(Long id);

}