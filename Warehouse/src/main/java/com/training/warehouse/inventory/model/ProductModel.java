package com.training.warehouse.inventory.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductModel {
	private Long productId;
	private String productName;
	private String reservationCode;
	private String reservationStatus;
}
