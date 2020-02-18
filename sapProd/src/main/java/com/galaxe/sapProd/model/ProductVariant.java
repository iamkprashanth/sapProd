package com.galaxe.sapProd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_variants database table.
 * 
 */
@Entity
@Table(name="product_variants")
@NamedQuery(name="ProductVariant.findAll", query="SELECT p FROM ProductVariant p")
public class ProductVariant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_variants_id")
	private Integer productVariantsId;

	private float price;

	private String productVariantName;

	private Integer quantity;

	private String sku;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="productVariant", fetch=FetchType.EAGER)
	private List<ProductDetail> productDetails;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Seller
	@ManyToOne
	@JoinColumn(name="seller_id")
	private Seller seller;

	public ProductVariant() {
	}

	public Integer getProductVariantsId() {
		return this.productVariantsId;
	}

	public void setProductVariantsId(Integer productVariantsId) {
		this.productVariantsId = productVariantsId;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductVariantName() {
		return this.productVariantName;
	}

	public void setProductVariantName(String productVariantName) {
		this.productVariantName = productVariantName;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProductVariant(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProductVariant(null);

		return productDetail;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}