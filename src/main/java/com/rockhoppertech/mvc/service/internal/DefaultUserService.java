package com.rockhoppertech.mvc.service.internal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rockhoppertech.mvc.domain.User;
import com.rockhoppertech.mvc.repositories.UserRepository;
import com.rockhoppertech.mvc.service.UserService;


/**
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 *
 */
@Service("userService")
@Transactional(readOnly = true)
public class DefaultUserService implements UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(DefaultUserService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = false)
	public User create(User user) {
		logger.debug("creating {}", user);
		User ret = this.userRepository.save(user);
		logger.debug("created {}", ret);
		return ret;
	}

	@Override
	public User findByID(Long id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public List<User> findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public Iterable<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public User update(User user) {
		return this.userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(User user) {
		this.userRepository.delete(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		this.userRepository.delete(id);
	}

}
