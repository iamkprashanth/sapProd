package com.galaxe.sapProd.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the variants database table.
 * 
 */
@Entity
@Table(name="variants")
@NamedQuery(name="Variant.findAll", query="SELECT v FROM Variant v")
public class Variant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="variant_id")
	private Integer variantId;

	private String variant;

	//bi-directional many-to-one association to VariantValue
	@OneToMany(mappedBy="variant", fetch=FetchType.EAGER)
	private List<VariantValue> variantValues;

	public Variant() {
	}

	public Integer getVariantId() {
		return this.variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

	public String getVariant() {
		return this.variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public List<VariantValue> getVariantValues() {
		return this.variantValues;
	}

	public void setVariantValues(List<VariantValue> variantValues) {
		this.variantValues = variantValues;
	}

	public VariantValue addVariantValue(VariantValue variantValue) {
		getVariantValues().add(variantValue);
		variantValue.setVariant(this);

		return variantValue;
	}

	public VariantValue removeVariantValue(VariantValue variantValue) {
		getVariantValues().remove(variantValue);
		variantValue.setVariant(null);

		return variantValue;
	}

}