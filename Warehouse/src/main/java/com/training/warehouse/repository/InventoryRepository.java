package com.training.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.warehouse.domain.Product;

public interface InventoryRepository extends JpaRepository<Product, Long> {

}
