package com.training.warehouse.inventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.warehouse.inventory.domain.Product;
import com.training.warehouse.inventory.model.ProductModel;
import com.training.warehouse.inventory.repository.InventoryRepository;

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
			vProductModel.setReservationCode(iProduct.getReservationCode());
			vProductModel.setReservationStatus(iProduct.getReservationStatus());
			vProductModelList.add(vProductModel);
		}

		return vProductModelList;
	}

	public ProductModel getProduct(Long pProductId) {
		Product vProduct = mInventoryRepository.getOne(pProductId);

		ProductModel vProductModel = new ProductModel();
		vProductModel.setProductId(vProduct.getProductId());
		vProductModel.setProductName(vProduct.getProductName());
		vProductModel.setReservationCode(vProduct.getReservationCode());
		vProductModel.setReservationStatus(vProduct.getReservationStatus());
		
		return vProductModel;
	}
	
	public ProductModel reserveProduct(ProductModel pProductModel) {
		Product vProduct = mInventoryRepository.getOne(pProductModel.getProductId());
		vProduct.setReservationCode(String.valueOf(new Date().getTime()));
		vProduct.setReservationStatus("RESERVED");
		vProduct = mInventoryRepository.save(vProduct);
		
		ProductModel vResultProductModel = new ProductModel();
		vResultProductModel.setProductName(vProduct.getProductName());
		vResultProductModel.setProductId(vProduct.getProductId());
		vResultProductModel.setReservationCode(vProduct.getReservationCode());
		vResultProductModel.setReservationStatus(vProduct.getReservationStatus());
		
		return vResultProductModel;
	}
	
	
	public ProductModel unReserveProduct(ProductModel pProductModel) {
		Product vProduct = mInventoryRepository.getOne(pProductModel.getProductId());
		vProduct.setReservationCode(pProductModel.getReservationCode());
		vProduct.setReservationStatus(pProductModel.getReservationStatus());
		vProduct = mInventoryRepository.save(vProduct);
		
		ProductModel vResultProductModel = new ProductModel();
		vResultProductModel.setProductName(vProduct.getProductName());
		vResultProductModel.setProductId(vProduct.getProductId());
		vResultProductModel.setReservationCode(vProduct.getReservationCode());
		vResultProductModel.setReservationStatus(vProduct.getReservationStatus());
		
		return vResultProductModel;
	}
}
