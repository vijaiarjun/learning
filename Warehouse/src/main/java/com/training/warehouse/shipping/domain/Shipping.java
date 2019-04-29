package com.training.warehouse.shipping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Shipping {
	@Id @GeneratedValue
	private @Getter Long shippingId;
	private @Getter @Setter String reservationCode;
}
