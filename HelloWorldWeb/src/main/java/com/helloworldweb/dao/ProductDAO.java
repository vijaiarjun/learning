package com.helloworldweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.helloworldweb.entity.Product;
import com.helloworldweb.repository.ProductRepository;

@Service
public class ProductDAO {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product saveProduct(Product pProduct) {
		return productRepository.saveAndFlush(pProduct);
	}
	
	public List<Product> listProductsOrderByIdentifier() {
		return productRepository.listProductsOrderByIdentifier();
	}
}
