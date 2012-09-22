package com.rockhoppertech.mvc.web.rest;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rockhoppertech.mvc.domain.User;
import com.rockhoppertech.mvc.repositories.UserRepository;

@Controller
@RequestMapping("/rest/users")
public class UserRestController {

	private final UserRepository repository;

	@Autowired
	public UserRestController(UserRepository repository) {
		Assert.notNull(repository);
		this.repository = repository;
	}

	@RequestMapping(method = GET)
	@ResponseBody
	public Users showUsers(Model model) {
		return new Users(repository.findAll());
	}

	@RequestMapping(method = POST)
	@ResponseStatus(CREATED)
	public void createUser(@RequestBody User User, HttpServletResponse response) {
		repository.save(User);
		response.setHeader("Location",
				String.format("/rest/Users/%s", User.getId()));
	}

	@RequestMapping(value = "/{id}", method = GET)
	@ResponseBody
	public User showUser(@PathVariable Long id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = PUT)
	@ResponseStatus(OK)
	public void updateUser(@RequestBody User User) {

		repository.save(User);
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	@ResponseStatus(OK)
	public void deleteUser(@PathVariable Long id) {
		repository.delete(id);
	}
}