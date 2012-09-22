package com.rockhoppertech.mvc.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.rockhoppertech.mvc.domain.User;


@XmlRootElement
public class Users {
	private List<User> users = new ArrayList<User>();

	public Users(Iterable<User> all) {
		for(User user: all) {
			users.add(user);
		}
	}
}
