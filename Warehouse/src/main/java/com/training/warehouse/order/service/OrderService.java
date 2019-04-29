package com.training.warehouse.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.warehouse.inventory.model.ProductModel;
import com.training.warehouse.inventory.service.InventoryService;

@Service
public class OrderService {
	@Autowired
	private InventoryService mInventoryService;
	
	public void createOrder() {
		ProductModel vProductInOrder = mInventoryService.getProduct(Long.valueOf(1));
		// Reserve Inventory
		mInventoryService.reserveProduct(vProductInOrder);
	}
}
