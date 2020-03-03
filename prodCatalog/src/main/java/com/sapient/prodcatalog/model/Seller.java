package com.sapient.prodcatalog.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seller database table.
 * 
 */
@Entity
@NamedQuery(name="Seller.findAll", query="SELECT s FROM Seller s")
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seller_id")
	private Integer sellerId;

	@Column(name="seller_name")
	private String sellerName;

	//bi-directional many-to-one association to ProductVariant
	@OneToMany(mappedBy="seller", fetch=FetchType.EAGER)
	private List<ProductVariant> productVariants;

	public Seller() {
	}

	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public List<ProductVariant> getProductVariants() {
		return this.productVariants;
	}

	public void setProductVariants(List<ProductVariant> productVariants) {
		this.productVariants = productVariants;
	}

	public ProductVariant addProductVariant(ProductVariant productVariant) {
		getProductVariants().add(productVariant);
		productVariant.setSeller(this);

		return productVariant;
	}

	public ProductVariant removeProductVariant(ProductVariant productVariant) {
		getProductVariants().remove(productVariant);
		productVariant.setSeller(null);

		return productVariant;
	}

}