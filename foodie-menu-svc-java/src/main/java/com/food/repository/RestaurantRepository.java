package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.entity.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

//	@Query(name = "Select * from public.restaurant",nativeQuery = true)
//	RestaurantEntity getRestaurantList();

//	@Query(name = "Select * from public.restaurant",nativeQuery = true)
//    RestaurantEntity es =getRestaurantList();



}
