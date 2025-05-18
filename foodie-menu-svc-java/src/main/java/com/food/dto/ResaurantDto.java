package com.food.dto;

import java.util.List;

import com.food.entity.MenuItemEntity;

import jakarta.persistence.Column;

public class ResaurantDto {

	private String restaurantName;

	private String cuisineType;

	private String address;

	private String phoneNumber;

	private String restaurantUrl;

	private String email;
	
	private List<MenuItemEntity> menuItemList;

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

	public String getRestaurantUrl() {
		return restaurantUrl;
	}

	public void setRestaurantUrl(String restaurantUrl) {
		this.restaurantUrl = restaurantUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MenuItemEntity> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItemEntity> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
	
}
