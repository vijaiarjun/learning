package com.training.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.warehouse.domain.Product;
import com.training.warehouse.model.ProductModel;
import com.training.warehouse.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService mProductService;

	@PostMapping("/product/addproduct")
	public Product addProduct(@RequestBody ProductModel rProductModel) {
		return mProductService.addProduct(rProductModel);
	}

	@GetMapping("/product/getproducts")
	public List<ProductModel> getProducts() {
		return mProductService.getProducts();
	}

	@GetMapping("/product/getproduct/{rProductId}")
	public ProductModel getProduct(@PathVariable Long rProductId) {
		return mProductService.getProduct(rProductId);
	}
}
