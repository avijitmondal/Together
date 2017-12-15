/*****************************************************************************
 * FILE NAME   : Credential.java
 * VERSION     : 1.0
 * AUTHOR      : avijit
 * DATE        : Aug 24, 2017
 * DESCRIPTION : together-server
 ****************************************************************************/
package com.avijit.together.server.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author avijit
 *
 */
@Entity
@Table(name = "AUTHENTICATION")
public class Credential {

	/**
	 * Unique ID for Credential
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "ID")
	private UUID id;

	/**
	 * Credential username
	 */
	@Column(name = "USERNAME")
	@NotBlank(message = "error.username.notblank")
	private String username;

	/**
	 * Credential email
	 */
	@Column(name = "EMAIL")
	private String email;

	/**
	 * Credential password
	 */
	@Column(name = "PASSWORD")
	@NotBlank(message = "error.password.notblank")
	private String password;

	/**
	 * Credential enabled or not
	 */
	@Column(name = "ENABLED", columnDefinition = "CHAR", length = 1)
	private boolean enabled;

	/**
	 * DateTime when password last reset
	 */
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "LAST_PASSWORD_RESET")
	private Date lastPasswordResetDate;

	/**
	 * Authority types for that credential
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AUTHENTICATION_AUTHORITY", joinColumns = {
			@JoinColumn(name = "AUTHENTICATION_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID") })
	private List<Authority> authorities;

	/**
	 * 
	 */
	public Credential() {
		super();
	}

	/**
	 * @param id
	 *            Unique ID for Credential
	 * @param username
	 *            Credential username
	 * @param email
	 *            Credential email
	 * @param password
	 *            Credential password
	 * @param enabled
	 *            Credential enabled or not
	 * @param lastPasswordResetDate
	 *            DateTime when password last reset
	 * @param authorities
	 *            Authority types for that credential
	 */
	public Credential(UUID id, String username, String email, String password, boolean enabled,
			Date lastPasswordResetDate, List<Authority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.authorities = authorities;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the lastPasswordResetDate
	 */
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	/**
	 * @param lastPasswordResetDate
	 *            the lastPasswordResetDate to set
	 */
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	/**
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Credential [" + (id != null ? "id=" + id + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + "enabled=" + enabled + ", "
				+ (lastPasswordResetDate != null ? "lastPasswordResetDate=" + lastPasswordResetDate + ", " : "")
				+ (authorities != null ? "authorities=" + authorities : "") + "]";
	}
}
