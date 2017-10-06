package net.deepak.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	
	@NotBlank(message="Please enter Product Name!")
	private String name;
	
	@NotBlank(message="Please enter Brand Name!")
	private String brand;
	
	@JsonIgnore
	@NotBlank(message="Please enter Product Description!")
	private String description;
	
	
	@Column(name="unit_price")
	@Min(value=1,message="Price can't be less than 1!")
	private double unitPrice;
	
	
	@Min(value=1,message="Please enter quantity atleast 1!")
	private int quantity;	
	
	
	@Column(name="is_active")
	private boolean active;
	
	@JsonIgnore
	@Column(name="category_id")
	private int categoryId;
	
	@JsonIgnore
	@Column(name="supplier_id")
	private int supplierId;
	
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile 	file;
	
	
	//constructor
	public Product(){
		this.code="PRD"+ UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}
	

	
	////////getter setter
	public int getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public String getDescription() {
		return description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public boolean isActive() {
		return active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public int getViews() {
		return views;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public void setViews(int views) {
		this.views = views;
	}

	//override toString() for logger
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}



	public MultipartFile getFile() {
		return file;
	}



	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	
	
	
	
	
	

}
