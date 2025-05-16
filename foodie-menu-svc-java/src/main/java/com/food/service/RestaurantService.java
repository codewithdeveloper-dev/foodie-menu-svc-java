package com.food.service;

import java.util.List;

import com.food.dto.RestaurantResponce;
import com.food.entity.RestaurantEntity;

public interface RestaurantService {

	List<RestaurantEntity> getRestaurantList();

	RestaurantResponce saveRestaurantData(RestaurantEntity restaurantEntity);

}
