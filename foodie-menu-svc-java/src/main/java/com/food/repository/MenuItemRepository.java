package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.entity.MenuItemEntity;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {

	@Query(value = "SELECT * FROM menu_item WHERE restaurant_id = ?1", nativeQuery = true)
	List<MenuItemEntity> getMenuItemsByRestaurantId(Long id);

}
