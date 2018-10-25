package com.helloworldweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.helloworldweb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value="from Product order by identifier desc")
	List<Product> listProductsOrderByIdentifier();
}
