package com.helloworld;

import org.springframework.stereotype.Component;

@Component
public class Item {
	private long itemId;
	private String partNumber;
	private String itemName;
	private String itemAttributeValue;
	
	public long getItemId() {
		return itemId;
	}
	
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	
	public String getPartNumber() {
		return partNumber;
	}
	
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemAttributeValue() {
		return itemAttributeValue;
	}
	
	public void setItemAttributeValue(String itemAttributeValue) {
		this.itemAttributeValue = itemAttributeValue;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", partNumber=" + partNumber + ", itemName=" + itemName
				+ ", itemAttributeValue=" + itemAttributeValue + "]";
	}
	
	
}
