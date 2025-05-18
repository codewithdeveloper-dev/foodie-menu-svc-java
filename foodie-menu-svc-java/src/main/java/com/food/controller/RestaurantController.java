package com.food.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.ResaurantDto;
import com.food.dto.ResponceMessage;
import com.food.entity.RestaurantEntity;
import com.food.service.RestaurantService;



@RestController
public class RestaurantController {

	private Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService restaurantService;
	
	//saveRestaurant
	@PostMapping("/saveRestaurant")
	public  ResponseEntity<?> saveRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
		logger.info("Started RestaurantController -- controler");
		ResponceMessage response =  new ResponceMessage();
		response = restaurantService.saveRestaurant(restaurantEntity);
		logger.info("Enter saveRestaurantData -- controler");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//getRestaurant
	@GetMapping("/getRestaurant")
	public ResponseEntity<?> getRestaurant() {
		logger.info("Started RestaurantController -- controler");
		List <RestaurantEntity> ListRestaurant = null;
		ListRestaurant= restaurantService.getRestaurantList();
		logger.info("Ended RestaurantController -- controler");
		return new ResponseEntity<>(ListRestaurant, HttpStatus.OK);

	}
	
	
	 @GetMapping("/{id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable Long id){
	logger.info("Started MenuItemController -- controler");
	ResaurantDto  resaurantDto = new ResaurantDto();
	resaurantDto = restaurantService.getRestaurantById(id);
	logger.info("Ended MenuItemController -- controler");
    return new ResponseEntity<>(resaurantDto,HttpStatus.OK);
	}

	
	
	
	
	
	@PostMapping("saveRestaurantList")
	public ResponseEntity<?> saveRestaurantData(@RequestBody RestaurantEntity restaurantEntity) {
		logger.info("Started saveRestaurantData -- controler");
		ResponceMessage responce = restaurantService.saveRestaurantData(restaurantEntity);
		logger.info("Started saveRestaurantData -- controler");
		return new ResponseEntity<>(responce, HttpStatus.OK);
	}
	

}
