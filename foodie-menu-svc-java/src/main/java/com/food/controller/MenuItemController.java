package com.food.controller;

import java.util.ArrayList;
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

import com.food.dto.ResaurantDto;
import com.food.dto.ResponceMessage;
import com.food.entity.MenuItemEntity;
import com.food.service.MenuItemService;




@RestController
public class MenuItemController {
	private Logger logger = LoggerFactory.getLogger(MenuItemController.class);
	@Autowired
	private MenuItemService menuItemService;
	
	@PostMapping("/saveMenuItem")
	public ResponseEntity<?> getMethodName(@RequestBody MenuItemEntity menuItem) {
		logger.info("Started MenuItemController -- controler");
		ResponceMessage responceMessage = new  ResponceMessage();
		responceMessage = menuItemService.saveMenuItem(menuItem);
		logger.info("Ended MenuItemController -- controler");
		return new ResponseEntity<>(responceMessage,HttpStatus.OK);
	}
	
	@GetMapping("/getMenuItem")
	public ResponseEntity<?> getMenuItem() {
		logger.info("Started MenuItemController -- controler");
		List<MenuItemEntity> menuItemList = new ArrayList<MenuItemEntity>();
		menuItemList = menuItemService.getMenuList();
		logger.info("Ended MenuItemController -- controler");
		return new ResponseEntity<>(menuItemList,HttpStatus.OK);
	}
	
	

}
