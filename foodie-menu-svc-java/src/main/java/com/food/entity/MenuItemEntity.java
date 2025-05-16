package com.food.entity;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.food.enums.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "menu_item")
public class MenuItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id ")
	private long itemId;
	@Column(name = "item_name")
	@NotNull
	private String itemName;
	@Column(name = "description")
	private String description;
	@NotNull
	@Column(name = "price")
	private Double price ;
	@Column(name = "img_url")
	private String imgUrl;
	@Column(name = "status")
	private StatusEnum status;
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "spicy_level")
	private String spicyLevel;
	@Column(name = "is_available")
	private Boolean isAvailable;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "preparation_time")
	private int preparationTime;
	@Column(name = "rating")
	private Double  rating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id")
	private SubCategoryEntity subCategoryEntity;
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getSpicyLevel() {
		return spicyLevel;
	}
	public void setSpicyLevel(String spicyLevel) {
		this.spicyLevel = spicyLevel;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public int getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public SubCategoryEntity getSubCategoryEntity() {
		return subCategoryEntity;
	}
	public void setSubCategoryEntity(SubCategoryEntity subCategoryEntity) {
		this.subCategoryEntity = subCategoryEntity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
