package com.avijit.together.server.dto;

import java.io.Serializable;

import com.avijit.together.server.model.User;

/**
 * @author avijit
 *
 */
public class AuthenticationResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final User user;
	private final String token;
	private final String expiration = "86400";

	public AuthenticationResponseDTO(String token, User user) {
		this.token = token;
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 * @return the expiration
	 */
	public String getExpiration() {
		return expiration;
	}
}
