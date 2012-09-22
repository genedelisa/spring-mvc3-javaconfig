package com.rockhoppertech.mvc.repositories.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rockhoppertech.mvc.domain.User;
import com.rockhoppertech.mvc.repositories.UserRepository;

/**
 * A Stub repository.
 * 
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
@Repository
public class DefaultUserRepository implements UserRepository {
	private final Map<String, User> users;

	public DefaultUserRepository() {
		this.users = new HashMap<String, User>();

		User user = null;
		this.save(user = new User("rocky", "yo", "Rocky", "Balboa",
				"foo@bar.com"));

		this.save(user = new User("bruno", "domeSweetDome", "Bruno", "Lessky",
				"foo@bar.com"));

		this.save(user = new User("noah", "pa$$word", "Noah", "Vale",
				"foo@bar.com"));

		this.save(user = new User("heidi", "pa$$word", "Heidi", "Clare",
				"foo@bar.com"));

		this.save(user = new User("helen", "pa$$word", "Helen", "Back",
				"foo@bar.com"));

		this.save(user = new User("jack", "pa$$word", "Jack", "Haas",
				"foo@bar.com"));

		this.save(user = new User("justin", "pa$$word", "Justin", "Case",
				"foo@bar.com"));

		this.save(user = new User("ophelia", "pa$$word", "Ophelia", "Payne",
				"foo@bar.com"));

		this.save(user = new User("paige", "pa$$word", "Paige", "Turner",
				"foo@bar.com"));

		this.save(user = new User("ricko", "pa$$word", "Rick", "O'Shea",
				"foo@bar.com"));

		this.save(user = new User("ricks", "pa$$word", "Rick", "Shaw",
				"foo@bar.com"));

		this.save(user = new User("sal", "pa$$word", "Sal", "Minella",
				"foo@bar.com"));

		this.save(user = new User("seth", "pa$$word", "Seth", "Poole",
				"foo@bar.com"));

		this.save(user = new User("russ", "pa$$word", "Russell", "Leeves",
				"foo@bar.com"));

		this.save(user = new User("shanda", "pa$$word", "Shanda", "Lear",
				"foo@bar.com"));

		this.save(user = new User("sonny", "pa$$word", "Sonny", "Day",
				"foo@bar.com"));

		this.save(user = new User("stan", "pa$$word", "Stan", "Still",
				"foo@bar.com"));

		this.save(user = new User("stanc", "pa$$word", "Stanley", "Cupp",
				"foo@bar.com"));

		this.save(user = new User("sue", "pa$$word", "Sue", "Flay",
				"foo@bar.com"));

		this.save(user = new User("tim", "pa$$word", "Tim", "Burr",
				"foo@bar.com"));

		this.save(user = new User("tommy", "pa$$word", "Tommy", "Hawk",
				"foo@bar.com"));

		this.save(user = new User("warren", "pa$$word", "Warren", "Peace",
				"foo@bar.com"));

		this.save(user = new User("will", "pa$$word", "Will", "Power",
				"foo@bar.com"));

		this.save(user = new User("woody", "pa$$word", "Woody", "Forrest",
				"foo@bar.com"));

		this.save(user = new User("x", "pa$$word", "X.", "Benedict",
				"foo@bar.com"));

		this.save(user = new User("bosnia", "pa$$word", "Sarah", "Yayvo",
				"foo@bar.com"));
	}

	@Override
	public List<User> findByUsername(String userName) {
		if (this.users.containsKey(userName) == false) {
			throw new IllegalArgumentException("Whoozat? " + userName);
		}
		final User user = this.users.get(userName);
		List<User> list = new ArrayList<User>();
		list.add(user);
		return list;
	}

	@Override
	public User save(User user) {
		this.users.put(user.getUsername(), user);
		return user;
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAll() {
		final List<User> all = new ArrayList<User>();
		for (final User user : this.users.values()) {
			all.add(user);
		}
		return Collections.unmodifiableList(all);
	}

	@Override
	public void delete(User user) {
		if (this.users.containsKey(user.getUsername())) {
			this.users.remove(user.getUsername());
		} else {
			throw new IllegalArgumentException(
					"User is unknown. How can I delete that? " + user);
		}

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
