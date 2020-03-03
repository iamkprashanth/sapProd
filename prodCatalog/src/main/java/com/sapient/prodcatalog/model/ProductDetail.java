package com.sapient.prodcatalog.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_details database table.
 * 
 */
@Entity
@Table(name="product_details")
@NamedQuery(name="ProductDetail.findAll", query="SELECT p FROM ProductDetail p")
public class ProductDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_detail_id")
	private Integer productDetailId;

	//bi-directional many-to-one association to ProductVariant
	@ManyToOne
	@JoinColumn(name="product_variants_id")
	private ProductVariant productVariant;

	//bi-directional many-to-one association to VariantValue
	@ManyToOne
	@JoinColumn(name="value_id")
	private VariantValue variantValue;

	public ProductDetail() {
	}

	public Integer getProductDetailId() {
		return this.productDetailId;
	}

	public void setProductDetailId(Integer productDetailId) {
		this.productDetailId = productDetailId;
	}

	public ProductVariant getProductVariant() {
		return this.productVariant;
	}

	public void setProductVariant(ProductVariant productVariant) {
		this.productVariant = productVariant;
	}

	public VariantValue getVariantValue() {
		return this.variantValue;
	}

	public void setVariantValue(VariantValue variantValue) {
		this.variantValue = variantValue;
	}

}