package com.food.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	


	public MenuCategoryEntity() {
		super();
	}

	
	

}
//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "restaurant_id")
//private RestaurantEntity restaurantEntity;
//
//@OneToMany(mappedBy = "menuCategoryEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//private List<SubCategoryEntity> subCategories;//	@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "restaurant_id")
//private RestaurantEntity restaurantEntity;
//
//@OneToMany(mappedBy = "menuCategoryEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//private List<SubCategoryEntity> subCategories;