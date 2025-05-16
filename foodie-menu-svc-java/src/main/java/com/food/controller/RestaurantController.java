package com.food.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.RestaurantResponce;
import com.food.entity.RestaurantEntity;
import com.food.service.RestaurantService;


@RestController
public class RestaurantController {

	private Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/getRestaurantList")
	public ResponseEntity<?> getMethodName() {
		logger.info("Started RestaurantController -- controler");
		List <RestaurantEntity> ListRestaurant = null;
		ListRestaurant= restaurantService.getRestaurantList();
		logger.info("Ended RestaurantController -- controler");
		return new ResponseEntity<>(ListRestaurant, HttpStatus.OK);

	}
	
	@PostMapping("saveRestaurantList")
	public RestaurantResponce saveRestaurantData(@RequestBody RestaurantEntity restaurantEntity) {
		logger.info("Started saveRestaurantData -- controler");
		RestaurantResponce responce = restaurantService.saveRestaurantData(restaurantEntity);
		logger.info("Started saveRestaurantData -- controler");
		return responce;
	}
	

}
