package com.food.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "menu_category")
public class MenuCategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id ")
	private Long categoryId ;
	@Column(name = "category_name ")
	private String categoryName ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurantEntity;
	
	@OneToMany(mappedBy = "menuCategoryEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<SubCategoryEntity> subCategories;
	
	

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}

	

	
	public List<SubCategoryEntity> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategoryEntity> subCategories) {
		this.subCategories = subCategories;
	}
	
	

	public MenuCategoryEntity(Long categoryId, String categoryName, RestaurantEntity restaurantEntity,
			List<SubCategoryEntity> subCategories) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.restaurantEntity = restaurantEntity;
		this.subCategories = subCategories;
	}

	public MenuCategoryEntity() {
		super();
	}

	
	
	
	
	


}
