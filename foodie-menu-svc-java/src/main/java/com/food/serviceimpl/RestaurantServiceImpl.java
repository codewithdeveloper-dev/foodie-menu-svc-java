package com.food.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.RestaurantResponce;
import com.food.entity.MenuCategoryEntity;
import com.food.entity.MenuItemEntity;
import com.food.entity.RestaurantEntity;
import com.food.entity.SubCategoryEntity;
import com.food.repository.RestaurantRepository;
import com.food.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	private Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public List<RestaurantEntity> getRestaurantList() {
		logger.info("Started RestaurantServiceImpl -- Service");
		List<RestaurantEntity> restaurantList = new ArrayList<RestaurantEntity>() ;
		restaurantList =restaurantRepository.findAll();
		logger.info("Ended RestaurantServiceImpl -- Service");
		return restaurantList;
	}

	@Override
	public RestaurantResponce saveRestaurantData(RestaurantEntity restaurantEntity) {
		logger.info("Started saveRestaurantData -- Service");
		RestaurantResponce restaurantRespose = new RestaurantResponce();
		try {
//			for (MenuCategoryEntity category : restaurantEntity.getMenuCategories()) {
//			    category.setRestaurantEntity(restaurantEntity);
//			    for (SubCategoryEntity sub : category.getSubCategories()) {
//			        sub.setMenuCategoryEntity(category);
//			        for (MenuItemEntity item : sub.getItems()) {
//			            item.setSubCategoryEntity(sub);
//			        }
//			    }
//			}
			for(MenuCategoryEntity category : restaurantEntity.getMenuCategories()) {
				category.setRestaurantEntity(restaurantEntity);
				for(SubCategoryEntity subCategory : category.getSubCategories()) {
					subCategory.setMenuCategoryEntity(category);
					for(MenuItemEntity item : subCategory.getItems()) {
						item.setSubCategoryEntity(subCategory);
					}
				}
			}
			RestaurantEntity restaurantResponse = restaurantRepository.save(restaurantEntity);
			if(restaurantResponse.getRestaurantId()!=0) {
				restaurantRespose.setMessage("Data Saved Successfully");
				restaurantRespose.setStatus(true);
			}
		} catch (Exception e) {
			restaurantRespose.setError(e.toString());;
			restaurantRespose.setStatus(false);
		}
		
		logger.info("Ended saveRestaurantData -- Service");
		return restaurantRespose;
	}
	
	
	
	

	
	

}
