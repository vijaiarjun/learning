package com.vishan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishan.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}