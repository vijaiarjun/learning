package com.vishan.resource;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

public class OrderResource extends ResourceSupport {
	private Long orderId;
	private int numberOfItems;
	private BigDecimal orderTotal;
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the numberOfItems
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	/**
	 * @param numberOfItems the numberOfItems to set
	 */
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	/**
	 * @return the orderTotal
	 */
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}
	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}
}
