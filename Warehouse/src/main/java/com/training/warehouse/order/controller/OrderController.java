package com.training.warehouse.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.warehouse.order.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService mOrderService;
	
	@PostMapping("/order")
	public void createOrder() {
		mOrderService.createOrder();
	}
}
