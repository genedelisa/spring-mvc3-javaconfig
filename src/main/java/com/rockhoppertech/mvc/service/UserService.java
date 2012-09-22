package com.rockhoppertech.mvc.service;

import java.util.List;

import com.rockhoppertech.mvc.domain.User;

public interface UserService {

	public User create(User user);

	public User findByID(Long id);
	
	public List<User> findByUsername(String userName);

	public Iterable<User> findAll();

	public User update(User user);

	public void delete(User user);

	public void delete(Long id);

}

