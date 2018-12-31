package com.vishan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishan.entity.Order;
import com.vishan.repository.OrderRepository;

@Service
public class OrderDAO {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrderById(Long orderId) {
		return orderRepository.getOne(orderId);
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
