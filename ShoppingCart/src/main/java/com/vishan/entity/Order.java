package com.vishan.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="ORDERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order extends ResourceSupport {
	@Id 
	private Long orderId;
	private int numberOfItems;
	private BigDecimal orderTotal;
	
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", numberOfItems=" + numberOfItems + ", orderTotal=" + orderTotal + "]";
	}
	
	
}
