package com.galaxe.sapProd.service;

import java.util.List;

import com.galaxe.sapProd.payload.ProductResponse;

public interface ProductService 
{
	
	public List<ProductResponse> findByBrand(Integer brandId);

	public List<ProductResponse> getAllProducts(Integer pageNo, Integer pageSize, String sortBy);

}
