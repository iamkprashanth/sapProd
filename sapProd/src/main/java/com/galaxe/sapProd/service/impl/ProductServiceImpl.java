package com.galaxe.sapProd.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.galaxe.sapProd.model.Brand;
import com.galaxe.sapProd.model.Product;
import com.galaxe.sapProd.payload.ProductResponse;
import com.galaxe.sapProd.repository.ProductPaginationRepository;
import com.galaxe.sapProd.repository.ProductRepository;
import com.galaxe.sapProd.service.ProductService;
import com.galaxe.sapProd.transformation.ProductTransformation;

@Service
public class ProductServiceImpl implements ProductService
{

	public static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTransformation productTransformation;
	
	@Autowired
	private ProductPaginationRepository productPageRepository;

	@Override
	public List<ProductResponse> findByBrand(Integer brandId){
		Brand brand=new Brand();
		brand.setBrandId(brandId);
		return productTransformation.transformProduct(productRepository.findByBrand(brand));
	}

	@Override
	public List<ProductResponse> getAllProducts(Integer pageNo, Integer pageSize, String sortBy) {
		
		Sort sortOrder = Sort.by(sortBy).descending(); 
		Pageable pageable=PageRequest.of(pageNo, pageSize,sortOrder);
		Page<Product> pageResult= productPageRepository.findAll(pageable);
		return productTransformation.transformProduct(pageResult.getContent());
	}

}
