package com.avizva.trainingProject.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;




/**
 * 
 * @author Akshay.Chourasia
 * @entity annotation used to map the class instances with the entities of Database. 
 */
@Entity
@Component
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Pattern(regexp = "[^0-9]*")
	private String name;
	@Id
	@NotEmpty
	@Size(min=3, max = 15)
	private String username;
	@NotEmpty
	private String password;
	
	@NotEmpty
	@Email
	@Column(unique=true)
	private String email;

	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	
	@NotNull
	private Long contact;
	
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;

	/**
	 * This variable is for determining whether the user is administrator or not.
	 */
	private String role;
	
	/**
	 * This is used to activate and deactivate user's account
	 */
	
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean enabled;
	

	
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enable) {
		this.enabled = enable;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", email="
				+ email + ", address=" + address + ", contact=" + contact + ", dob=" + dob + ", role=" + role
				+ ", enabled=" + enabled + "]";
	}

	
	
	
	

}
