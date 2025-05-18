package com.food.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.entity.MenuCategoryEntity;
import com.food.service.CategoryService;


@RestController
public class CategoryController {
	private Logger logger = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("getCategory")
	public ResponseEntity<?> getCategory() {
		logger.info("Started CategoryController -- controler");
		List<MenuCategoryEntity> meanuCategoryList = new ArrayList<>();
		meanuCategoryList = categoryService.getCategory();
		logger.info("Ented CategoryController -- controler");
		return new ResponseEntity<>(meanuCategoryList, HttpStatus.OK);
	}

}
