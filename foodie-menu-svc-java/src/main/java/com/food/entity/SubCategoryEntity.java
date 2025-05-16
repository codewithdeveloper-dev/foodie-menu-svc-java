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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subcategory_id ")
	private long subcategoryId;
	@NotNull
	@Column(name = "type")
	private String  type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private MenuCategoryEntity menuCategoryEntity;
	
	@OneToMany(mappedBy = "subCategoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<MenuItemEntity> items;

	public long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public MenuCategoryEntity getMenuCategoryEntity() {
		return menuCategoryEntity;
	}

	public void setMenuCategoryEntity(MenuCategoryEntity menuCategoryEntity) {
		this.menuCategoryEntity = menuCategoryEntity;
	}

	public List<MenuItemEntity> getItems() {
		return items;
	}

	public void setItems(List<MenuItemEntity> items) {
		this.items = items;
	}

	
	
	
	

}
