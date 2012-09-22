package com.rockhoppertech.mvc.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * A test entity that uses Spring Data's AbstractPersistable.
 * 
 * @author <a href="http://rockhoppertech.com/blog/">Gene De Lisa</a>
 * 
 */
@Entity
public class User extends AbstractPersistable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Basic
	@NotNull
	@Size(min = 4, max = 20)
	private String username;

	@Basic
	@NotNull
	@Size(min = 4, max = 20)
	private String password;

	@Basic
	@Size(min = 4, max = 20)
	private String given;

	@Basic
	@Size(min = 4, max = 20)
	private String family;

	@Basic
	@Size(min = 4, max = 20)
	private String email;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String given, String family,
			String email) {
		this.username = username;
		this.password = password;
		this.given = given;
		this.family = family;
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGiven() {
		return this.given;
	}

	public void setGiven(String given) {
		this.given = given;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(this.getId()).append(' ');
		sb.append("username:").append(this.username).append(' ');
		sb.append("password:").append(this.password).append(' ');
		sb.append("given:").append(this.given).append(' ');
		sb.append("family:").append(this.family).append(' ');
		sb.append("email:").append(this.email);
		return sb.toString();
	}

}
