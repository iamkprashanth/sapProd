package com.sapient.prodcatalog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.prodcatalog.payload.ProductResponse;
import com.sapient.prodcatalog.service.ProductService;

@RestController
@RequestMapping(value="/api/product")
public class SearchController 
{
	
	public static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/brand/{brandId}")
	public List<ProductResponse> getProductsByBrand(@PathVariable("brandId") Integer brandId)
	{
		logger.info("getProductsByBrand :: brandId="+brandId);
		return productService.findByBrand(brandId);
	}
	
	@GetMapping(value="/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "productName") String sortBy) 
    {
		logger.info("**START** getAllProducts :: pageNo="+pageNo +", pageSize="+pageSize +", sortBy="+sortBy);
        List<ProductResponse> list = productService.getAllProducts(pageNo, pageSize, sortBy);
       // return new ResponseEntity<List<ProductResponse>>(list, new HttpHeaders(), HttpStatus.OK); 
        logger.info("**END** getAllProducts :: List<ProductResponse> list size="+list.size());
        return ResponseEntity.ok(list);
    }

}
