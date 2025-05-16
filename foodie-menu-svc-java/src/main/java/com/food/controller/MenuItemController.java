package com.food.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MenuItemController {
	
	@GetMapping("/get")
	public String getMethodName() {
		return "running";
	}
	

}
