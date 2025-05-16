package com.food.entity;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	@NotNull
	@Column(name = "restaurant_id", nullable = false)
	private long restaurantId;
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@Column(name = "cuisine_type")
	private String cuisineType;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "restaurant_url")
	private String restaurantUrl;
	
	@Column(name = "email")
	private String email;
	
	
	@OneToMany(mappedBy = "restaurantEntity", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<MenuCategoryEntity> menuCategories;


	public long getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public String getRestaurantUrl() {
		return restaurantUrl;
	}


	public void setRestaurantUrl(String restaurantUrl) {
		this.restaurantUrl = restaurantUrl;
	}
	
	




	public List<MenuCategoryEntity> getMenuCategories() {
		return menuCategories;
	}


	public void setMenuCategories(List<MenuCategoryEntity> menuCategories) {
		this.menuCategories = menuCategories;
	}


	public RestaurantEntity(@NotNull long restaurantId, String restaurantName, String cuisineType, String address,
			String phoneNumber, String restaurantUrl, String email, List<MenuCategoryEntity> menuCategories) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.restaurantUrl = restaurantUrl;
		this.email = email;
		this.menuCategories = menuCategories;
	}


	public RestaurantEntity() {
		super();
	}
	
	
	
	
	
	
	
	

}
