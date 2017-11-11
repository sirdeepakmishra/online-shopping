package net.deepak.shoppingbackend.dto;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user_detail")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter first name!")
	@Column(name="first_name")
	private String firstName;
	
	
	@NotBlank(message = "Please enter last name!")
	@Column(name="last_name")
	private String lastName;
	
	
	@NotBlank(message = "Please enter email!")
	private String email;
	
	
	@NotBlank(message = "Please enter contact number!")
	@Column(name="contact_number")
	private String contactNumber;
	
	
	private String role;
	
	@NotBlank(message = "Please enter password!")
	private String password;
	
	//confirm password transient filed so it can not store into database
	@NotBlank(message = "Please enter Confirm password!")
	@Transient
	private String confirmPassword;
	
	
	private boolean enable=true;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;

////////////////////////////////////
	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public String getRole() {
		return role;
	}


	public String getPassword() {
		return password;
	}


	public boolean isEnable() {
		return enable;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}

//logging and debugging
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enable="
				+ enable + "]";
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
/*	@OneToMany(targetEntity=Address.class)
	@JoinTable(name = "USER_ADDRESS", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	public ArrayList Address;

	public ArrayList getAddress() {
		return Address;
	}


	public void setAddress(ArrayList address) {
		Address = address;
	}*/


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
