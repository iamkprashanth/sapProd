package com.sapient.prodcatalog.payload;

import java.io.Serializable;

import javax.persistence.Column;

public class SellerResponse implements Serializable
{
	
	private Integer sellerId;
	private String sellerName;
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
}
