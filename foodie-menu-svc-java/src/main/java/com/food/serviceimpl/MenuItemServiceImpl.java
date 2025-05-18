package com.food.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.ResponceMessage;
import com.food.entity.MenuItemEntity;
import com.food.repository.MenuItemRepository;
import com.food.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	private Logger logger = LoggerFactory.getLogger(MenuItemServiceImpl.class);

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public ResponceMessage saveMenuItem(MenuItemEntity menuItem) {
		logger.info("Started MenuItemServiceImpl -- Service");
		ResponceMessage responceMessage = new ResponceMessage();
		try {
			MenuItemEntity menuItemResponce = menuItemRepository.save(menuItem);
			if (menuItemResponce.getItemId() != 0) {
				responceMessage.setMessage("MenuItem Saved Successfully");
				responceMessage.setStatus(true);
			}
		} catch (Exception e) {
			logger.info("Error MenuItemServiceImpl -- Service" + e.toString());
			responceMessage.setError(e.toString());
			responceMessage.setStatus(false);
		}
		logger.info("Ented MenuItemServiceImpl -- Service");
		return responceMessage;
	}

	@Override
	public List<MenuItemEntity> getMenuList() {
		logger.info("Started MenuItemServiceImpl -- Service");
		List<MenuItemEntity> menuItemList = new ArrayList<>();
		menuItemList = menuItemRepository.findAll();
		logger.info("Ended MenuItemServiceImpl -- Service");
		return menuItemList;
	}

}
