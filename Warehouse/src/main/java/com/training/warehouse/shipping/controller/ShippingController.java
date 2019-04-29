package com.training.warehouse.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.warehouse.shipping.model.ShippingModel;
import com.training.warehouse.shipping.service.ShippingService;

@RestController
public class ShippingController {
	@Autowired
	private ShippingService mShippingService;
	
	@PostMapping("/shipping/{iReservationCode}")
	public ShippingModel confirmShipping(@PathVariable String iReservationCode) {
		return mShippingService.confirmShipping(iReservationCode);
	}
}
