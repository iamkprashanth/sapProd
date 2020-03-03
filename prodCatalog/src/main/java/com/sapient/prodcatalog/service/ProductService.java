package com.sapient.prodcatalog.service;

import java.util.List;

import com.sapient.prodcatalog.payload.ProductResponse;

public interface ProductService 
{
	
	public List<ProductResponse> findByBrand(Integer brandId);

	public List<ProductResponse> getAllProducts(Integer pageNo, Integer pageSize, String sortBy);

}
