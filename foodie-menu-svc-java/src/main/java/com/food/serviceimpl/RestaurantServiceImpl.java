package com.food.serviceimpl;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.ResaurantDto;
import com.food.dto.ResponceMessage;
import com.food.entity.MenuCategoryEntity;
import com.food.entity.MenuItemEntity;
import com.food.entity.RestaurantEntity;
import com.food.entity.SubCategoryEntity;
import com.food.repository.MenuItemRepository;
import com.food.repository.RestaurantRepository;
import com.food.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public List<RestaurantEntity> getRestaurantList() {
		logger.info("Started RestaurantServiceImpl -- Service");
		List<RestaurantEntity> restaurantList = new ArrayList<RestaurantEntity>();
		restaurantList = restaurantRepository.findAll();
		logger.info("Ended RestaurantServiceImpl -- Service");
		return restaurantList;
	}

	@Override
	public ResponceMessage saveRestaurantData(RestaurantEntity restaurantEntity) {
		logger.info("Started saveRestaurantData -- Service");
		ResponceMessage responceMessage = new ResponceMessage();
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
//			for(MenuCategoryEntity category : restaurantEntity.getMenuCategories()) {
//				category.setRestaurantEntity(restaurantEntity);
//				for(SubCategoryEntity subCategory : category.getSubCategories()) {
//					subCategory.setMenuCategoryEntity(category);
//					for(MenuItemEntity item : subCategory.getItems()) {
//						item.setSubCategoryEntity(subCategory);
//					}
//				}
//			}
			RestaurantEntity restaurantResponse = restaurantRepository.save(restaurantEntity);
			if (restaurantResponse.getRestaurantId() != 0) {
				responceMessage.setMessage("Data Saved Successfully");
				responceMessage.setStatus(true);
			}
		} catch (Exception e) {
			responceMessage.setError(e.toString());
			;
			responceMessage.setStatus(false);
		}

		logger.info("Ended saveRestaurantData -- Service");
		return responceMessage;
	}

	@Override
	public ResponceMessage saveRestaurant(RestaurantEntity restaurantEntity) {
		logger.info("Start saveRestaurant -- Service");
		ResponceMessage responceMessage = new ResponceMessage();
		RestaurantEntity restaurantResponse = restaurantRepository.save(restaurantEntity);
		try {
			if (restaurantResponse.getRestaurantId() != 0) {
				logger.info("Ended saveRestaurant -- Service");
				responceMessage.setMessage("Restaurant Saved Successfully");
				responceMessage.setStatus(true);
			}
		} catch (Exception e) {
			logger.info("Ended saveRestaurant -- Service");
			responceMessage.setError(e.toString());
			responceMessage.setStatus(false);
		}
		return responceMessage;
	}

	@Override
	public ResaurantDto getRestaurantById(Long id) {
		logger.info("Started saveRestaurant -- Service");
		ResaurantDto resaurantDto = new ResaurantDto();
		List<MenuItemEntity> menuItemList = new ArrayList<MenuItemEntity>();
		Optional<RestaurantEntity> restaurantEntity = restaurantRepository.findById(id);
		menuItemList = menuItemRepository.getMenuItemsByRestaurantId(id);
		resaurantDto.setMenuItemList(menuItemList);
		resaurantDto.setRestaurantName(restaurantEntity.get().getRestaurantName());
		resaurantDto.setRestaurantUrl(restaurantEntity.get().getRestaurantUrl());
		resaurantDto.setAddress(restaurantEntity.get().getAddress());
		resaurantDto.setCuisineType(restaurantEntity.get().getCuisineType());
		resaurantDto.setEmail(restaurantEntity.get().getEmail());
		resaurantDto.setPhoneNumber(restaurantEntity.get().getPhoneNumber());
		logger.info("Ended saveRestaurant -- Service");
		return resaurantDto;
	}

}
