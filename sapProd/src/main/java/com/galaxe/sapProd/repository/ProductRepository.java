package com.galaxe.sapProd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galaxe.sapProd.model.Brand;
import com.galaxe.sapProd.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
	
	@Query("SELECT p FROM Product p where p.brand.brandId=:brandId")
	public List<Product> getProductsById(@Param("brandId") Integer brandId);
	
	List<Product> findByBrand(Brand brand);
	

}
