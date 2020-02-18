package com.galaxe.sapProd.payload;

public class ProductVariantResponse
{
	private Integer productVariantsId;
	private float price;
	private String productVariantName;
	private Integer quantity;
	private String sku;
	private SellerResponse sellerResponse;
	public Integer getProductVariantsId() {
		return productVariantsId;
	}
	public void setProductVariantsId(Integer productVariantsId) {
		this.productVariantsId = productVariantsId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductVariantName() {
		return productVariantName;
	}
	public void setProductVariantName(String productVariantName) {
		this.productVariantName = productVariantName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public SellerResponse getSellerResponse() {
		return sellerResponse;
	}
	public void setSellerResponse(SellerResponse sellerResponse) {
		this.sellerResponse = sellerResponse;
	}
	
}
