package com.food.service;

import java.util.List;

import com.food.dto.ResponceMessage;
import com.food.entity.MenuItemEntity;

public interface MenuItemService {

	ResponceMessage saveMenuItem(MenuItemEntity menuItem);

	List<MenuItemEntity> getMenuList();

}
