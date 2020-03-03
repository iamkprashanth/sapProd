package com.sapient.prodcatalog.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;

	@Column(name="product_name")
	private String productName;

	//bi-directional many-to-one association to ProductVariant
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<ProductVariant> productVariants;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public Product() {
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<ProductVariant> getProductVariants() {
		return this.productVariants;
	}

	public void setProductVariants(List<ProductVariant> productVariants) {
		this.productVariants = productVariants;
	}

	public ProductVariant addProductVariant(ProductVariant productVariant) {
		getProductVariants().add(productVariant);
		productVariant.setProduct(this);

		return productVariant;
	}

	public ProductVariant removeProductVariant(ProductVariant productVariant) {
		getProductVariants().remove(productVariant);
		productVariant.setProduct(null);

		return productVariant;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}