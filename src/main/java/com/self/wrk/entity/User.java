package com.self.wrk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * A User entity that holds information about the User
 * 
 * @author Karthick
 *
 */
@Entity
@Table(name = "user_info")
public class User implements Serializable {

	private static final long serialVersionUID = 4042460032659684146L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name", length = 100)
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "password", length = 10)
	private String password;
	@Column(name = "last_logged_in")
	private Date lastLoggedIn = new Date();

	public User() {

	}

	public User(String name, String address, String password) {
		super();
		this.name = name;
		this.address = address;
		this.password = password;
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoggedIn() {
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", password=" + password
				+ ", lastLoggedIn=" + lastLoggedIn + "]";
	}

}
