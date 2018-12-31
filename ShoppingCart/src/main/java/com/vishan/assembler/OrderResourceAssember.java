package com.vishan.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.vishan.entity.Order;
import com.vishan.resource.OrderResource;
import com.vishan.service.OrderService;

@Component
public class OrderResourceAssember extends ResourceAssemblerSupport<Order, OrderResource> {
	public OrderResourceAssember() {
		super(OrderService.class, OrderResource.class);
	}

	@Override
	public OrderResource toResource(Order order) {
		OrderResource orderResource = instantiateResource(order);
		orderResource.add(
				linkTo(methodOn(OrderService.class).getOrderById(order.getOrderId())).withSelfRel(),
				linkTo(methodOn(OrderService.class).getOrders()).withRel("orders")
				);
		orderResource.setOrderId(order.getOrderId());
		orderResource.setNumberOfItems(order.getNumberOfItems());
		orderResource.setOrderTotal(order.getOrderTotal());
		return orderResource;
	};
	
	@Override
	public List<OrderResource> toResources(Iterable<? extends Order> orders) {
		List<OrderResource> orderResources = new ArrayList<>();
		orders.forEach(order -> orderResources.add(toResource(order)));
		return orderResources;
	}
}
