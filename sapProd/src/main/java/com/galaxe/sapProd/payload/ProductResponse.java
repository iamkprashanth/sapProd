package com.galaxe.sapProd.payload;

import java.io.Serializable;
import java.util.List;

public class ProductResponse implements Serializable
{
	
	private int productId;
	private String productName;
	private BrandResponse brandResponse;
	private CategoryResponse categoryResponse;
	private List<ProductVariantResponse> productVarResp;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BrandResponse getBrandResponse() {
		return brandResponse;
	}
	public void setBrandResponse(BrandResponse brandResponse) {
		this.brandResponse = brandResponse;
	}
	public CategoryResponse getCategoryResponse() {
		return categoryResponse;
	}
	public void setCategoryResponse(CategoryResponse categoryResponse) {
		this.categoryResponse = categoryResponse;
	}
	public List<ProductVariantResponse> getProductVarResp() {
		return productVarResp;
	}
	public void setProductVarResp(List<ProductVariantResponse> productVarResp) {
		this.productVarResp = productVarResp;
	}

}
