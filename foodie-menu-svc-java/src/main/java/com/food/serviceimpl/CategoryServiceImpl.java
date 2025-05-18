package com.food.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.MenuCategoryEntity;
import com.food.repository.CategoryRepository;
import com.food.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryRepository categotyRepository;

	@Override
	public List<MenuCategoryEntity> getCategory() {
		logger.info("Started CategoryServiceImpl -- Service");
		List<MenuCategoryEntity> menuCategoryList = new ArrayList<MenuCategoryEntity>();
		try {
			menuCategoryList = categotyRepository.findAll();
		} catch (Exception e) {
			logger.info("Error CategoryServiceImpl -- Service" + e);
		}

		logger.info("Ended CategoryServiceImpl -- Service");
		return menuCategoryList;
	}

}
