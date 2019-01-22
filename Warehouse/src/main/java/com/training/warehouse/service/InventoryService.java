package com.training.warehouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.warehouse.domain.Product;
import com.training.warehouse.model.ProductModel;
import com.training.warehouse.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository mInventoryRepository;

	public Product addProduct(ProductModel pProductModel) {
		Product vProduct = new Product();
		vProduct.setProductName(pProductModel.getProductName());
		return mInventoryRepository.save(vProduct);
	}

	public List<ProductModel> getProducts() {
		List<Product> vProducts = mInventoryRepository.findAll();

		List<ProductModel> vProductModelList = new ArrayList<ProductModel>();

		ProductModel vProductModel = null;

		for (Product iProduct : vProducts) {
			vProductModel = new ProductModel();
			vProductModel.setProductName(iProduct.getProductName());
			vProductModel.setProductId(iProduct.getProductId());
			vProductModelList.add(vProductModel);
		}

		return vProductModelList;
	}

	public ProductModel getProduct(Long pProductId) {
		Product vProduct = mInventoryRepository.getOne(pProductId);

		ProductModel vProductModel = new ProductModel();
		vProductModel.setProductId(vProduct.getProductId());
		vProductModel.setProductName(vProduct.getProductName());

		return vProductModel;
	}
}
