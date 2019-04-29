package com.training.warehouse.shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.warehouse.inventory.model.ProductModel;
import com.training.warehouse.inventory.service.InventoryService;
import com.training.warehouse.shipping.domain.Shipping;
import com.training.warehouse.shipping.model.ShippingModel;
import com.training.warehouse.shipping.respository.ShippingRepository;

@Service
public class ShippingService {
	@Autowired
	private InventoryService mInventoryService;
	@Autowired
	private ShippingRepository mShippingRepository;

	public ShippingModel confirmShipping(String pReservationCode) {
		List<ProductModel> vProductModelList = mInventoryService.getProducts();
		
		ShippingModel vReturnShippingModel = null;
		ProductModel vReservedProductModel = null;
		
		for (ProductModel iProductModel : vProductModelList) {
			if(iProductModel.getReservationCode().equals(pReservationCode) && 
					iProductModel.getReservationStatus().equals("RESERVED")) {
				vReservedProductModel = iProductModel;
				vReturnShippingModel = createShipping(iProductModel.getReservationCode());
				break;
			}
		}
		
		// Also update product status to unreserved
		vReservedProductModel.setReservationCode(null);
		vReservedProductModel.setReservationStatus("UNRESERVED");
		removeInventory(vReservedProductModel);
		
		return vReturnShippingModel;
	}
	
	private ShippingModel createShipping(String reservationCode) {
		Shipping vShipping = new Shipping();
		vShipping.setReservationCode(reservationCode);
		vShipping =  mShippingRepository.save(vShipping);
		
		ShippingModel vReturnShippingModel = new ShippingModel();
		vReturnShippingModel.setShippingId(vShipping.getShippingId());
		vReturnShippingModel.setReservationCode(vShipping.getReservationCode());
		return vReturnShippingModel;
	}
	
	private void removeInventory(ProductModel pProductModel) {
		mInventoryService.unReserveProduct(pProductModel);
	}
}
