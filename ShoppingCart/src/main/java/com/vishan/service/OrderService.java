/**
 * 
 */
package com.vishan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishan.assembler.OrderResourceAssember;
import com.vishan.dao.OrderDAO;
import com.vishan.entity.Order;
import com.vishan.resource.OrderResource;

/**
 * @author Vijai
 *
 */
@RestController
public class OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderResourceAssember orderResourceAssembler;
	
	@GetMapping(value="/orders", produces=MediaTypes.HAL_JSON_VALUE)
	public List<OrderResource> getOrders() {
		List<OrderResource> orderResources = orderResourceAssembler.toResources(orderDAO.getOrders());
		return orderResources;
	}
	
	@GetMapping(value="/orders/{orderId}", produces=MediaTypes.HAL_JSON_VALUE)
	public OrderResource getOrderById(@PathVariable Long orderId) {
		Order order = orderDAO.getOrderById(orderId);
		OrderResource orderResource = orderResourceAssembler.toResource(order);
		return orderResource;
	}
	
	@PostMapping(value="/orders")
	public OrderResource createOrder(@RequestBody Order order) {
		Order createdOrder = orderDAO.saveOrder(order);
		OrderResource orderResource = orderResourceAssembler.toResource(createdOrder);
		return orderResource;
	}
	
	@PutMapping("/orders/{orderId}")
	public OrderResource modifyOrder(@RequestBody Order order, @PathVariable Long orderId) {
		Order modifiedOrder = orderDAO.getOrderById(orderId);
		modifiedOrder = orderDAO.saveOrder(order);
		OrderResource orderResource = orderResourceAssembler.toResource(modifiedOrder);
		return orderResource;
	}
}
