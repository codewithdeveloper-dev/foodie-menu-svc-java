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

import com.food.entity.SubCategoryEntity;
import com.food.service.SubCategoryService;

@RestController
public class SubCategoryController {
	
	private Logger logger = LoggerFactory.getLogger(SubCategoryController.class);
	@Autowired
	SubCategoryService subCategoryService;
	
	
	@GetMapping("getSubCategory")
	public ResponseEntity<?> getSubCategory() {
		logger.info("Started SubCategoryController -- controler");
		List<SubCategoryEntity> subCategoryList = new ArrayList<SubCategoryEntity>();
		subCategoryList = subCategoryService.getsubCategory();
		logger.info("Started SubCategoryController -- controler");
		return new ResponseEntity<>(subCategoryList,HttpStatus.OK);
	}
	

}
