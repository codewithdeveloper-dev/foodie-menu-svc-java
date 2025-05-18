package com.food.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.entity.SubCategoryEntity;
import com.food.repository.SubCategoryRepository;
import com.food.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	
	private Logger logger = LoggerFactory.getLogger(SubCategoryServiceImpl.class);
	
	@Autowired
	SubCategoryRepository subCategoryRepository;

	@Override
	public List<SubCategoryEntity> getsubCategory() {
		logger.info("Started SubCategoryServiceImpl -- Service");
		List<SubCategoryEntity> subCategoryList = new ArrayList<SubCategoryEntity>();
		try {
			subCategoryList = subCategoryRepository.findAll();
		} catch (Exception e) {
			logger.info("Error SubCategoryServiceImpl -- Service" + e);
		}
		logger.info("Ented SubCategoryServiceImpl -- Service");
		return subCategoryList;
	}
	
	

}
