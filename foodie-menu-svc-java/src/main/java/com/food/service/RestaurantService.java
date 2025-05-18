package com.food.service;

import java.util.List;

import com.food.dto.ResaurantDto;
import com.food.dto.ResponceMessage;
import com.food.entity.RestaurantEntity;

public interface RestaurantService {

	List<RestaurantEntity> getRestaurantList();

	ResponceMessage saveRestaurantData(RestaurantEntity restaurantEntity);

	ResponceMessage saveRestaurant(RestaurantEntity restaurantEntity);

	ResaurantDto getRestaurantById(Long id);

}
