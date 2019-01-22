package com.training.warehouse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private @Getter Long productId;
	private @Getter @Setter String productName;
}
