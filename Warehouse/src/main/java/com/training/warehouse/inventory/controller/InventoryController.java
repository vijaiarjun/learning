package com.training.warehouse.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.warehouse.inventory.domain.Product;
import com.training.warehouse.inventory.model.ProductModel;
import com.training.warehouse.inventory.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService mInventoryService;

	@PostMapping("/products")
	public Product addProduct(@RequestBody ProductModel rProductModel) {
		return mInventoryService.addProduct(rProductModel);
	}

	@GetMapping("/products")
	public List<ProductModel> getProducts() {
		return mInventoryService.getProducts();
	}

	@GetMapping("/products/{rProductId}")
	public ProductModel getProduct(@PathVariable Long rProductId) {
		return mInventoryService.getProduct(rProductId);
	}
}
