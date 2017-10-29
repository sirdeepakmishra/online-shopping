package net.deepak.shoppingbackend.dto;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_detail")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	private String role;
	private String password;
	
	
	private boolean enable=true;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
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
	
	
	

}
