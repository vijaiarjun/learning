package com.training.warehouse.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.warehouse.inventory.domain.Product;

public interface InventoryRepository extends JpaRepository<Product, Long> {

}
