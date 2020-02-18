package com.galaxe.sapProd.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galaxe.sapProd.model.Product;

@Repository
public interface ProductPaginationRepository extends PagingAndSortingRepository<Product, Integer>
{
	
	Page<Product> findAll(Pageable pageable);
	
	@Query("SELECT p FROM Product p where p.brand.brandId=:brandId")
	public List<Product> getProductsById(@Param("brandId") Integer brandId);

}
