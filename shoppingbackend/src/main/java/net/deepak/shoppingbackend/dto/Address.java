package net.deepak.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
/*	*//************//*
	@ManyToOne
	private User user;
	*//************/
	
	@NotBlank(message = "Please enter address line one!")
	@Column(name="address_line_one")
	private String addressLineOne;
	
	
	@NotBlank(message = "Please enter address line two!")
	@Column(name="address_line_two")
	private String addressLineTwo;
	
	@NotBlank(message = "Please enter city!")
	private String city;
	
	@NotBlank(message = "Please enter state!")
	private String state;
	
	@NotBlank(message = "Please enter country!")
	private String country;
	
	@NotBlank(message = "Please enter postal code!")
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="is_shipping")
	private boolean shipping;
	
	@Column(name="is_billing")
	private boolean billing;
	
	
	
	//////////////getter setter
	public int getId() {
		return id;
	}
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	
	
	
	
	
	
	

}
