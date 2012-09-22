package com.rockhoppertech.mvc.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The bean backing the login form. Contains validation annotations.
 * 
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 *
 */
public class LoginForm {
	@NotNull
	@Size(min = 4, max = 20)
	private String username;
	
	@NotNull
	@Size(min = 4, max = 20)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("username:").append(this.username).append(' ');
		sb.append("password:").append(this.password);
		return sb.toString();
	}

}
