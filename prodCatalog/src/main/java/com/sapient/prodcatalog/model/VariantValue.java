package com.sapient.prodcatalog.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the variant_value database table.
 * 
 */
@Entity
@Table(name="variant_value")
@NamedQuery(name="VariantValue.findAll", query="SELECT v FROM VariantValue v")
public class VariantValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="value_id")
	private Integer valueId;

	private String value;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="variantValue", fetch=FetchType.EAGER)
	private List<ProductDetail> productDetails;

	//bi-directional many-to-one association to Variant
	@ManyToOne
	@JoinColumn(name="variant_id")
	private Variant variant;

	public VariantValue() {
	}

	public Integer getValueId() {
		return this.valueId;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setVariantValue(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setVariantValue(null);

		return productDetail;
	}

	public Variant getVariant() {
		return this.variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

}