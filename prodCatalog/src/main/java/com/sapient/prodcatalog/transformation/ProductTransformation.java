package com.sapient.prodcatalog.transformation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.prodcatalog.model.Product;
import com.sapient.prodcatalog.model.ProductVariant;
import com.sapient.prodcatalog.payload.BrandResponse;
import com.sapient.prodcatalog.payload.CategoryResponse;
import com.sapient.prodcatalog.payload.ProductResponse;
import com.sapient.prodcatalog.payload.ProductVariantResponse;
import com.sapient.prodcatalog.payload.SellerResponse;

@Component
public class ProductTransformation 
{

	public List<ProductResponse> transformProduct(List<Product> productList)
	{
		List<ProductResponse> responses=new ArrayList<ProductResponse>();
		ProductResponse productResponse=null;
		CategoryResponse categoryResponse=null;
		BrandResponse brandResponse=null;
		List<ProductVariantResponse> productVarResps=new ArrayList<ProductVariantResponse>();;
		ProductVariantResponse productVariantResponse=null;
		SellerResponse sellerResponse;
		for (Product product : productList) {
			productResponse=new ProductResponse();
			productResponse.setProductId(product.getProductId());
			productResponse.setProductName(product.getProductName());

			brandResponse=new BrandResponse();
			brandResponse.setBrandId(product.getBrand().getBrandId());
			brandResponse.setBrandName(product.getBrand().getBrandName());

			categoryResponse=new CategoryResponse();
			categoryResponse.setCategoryId(product.getCategory().getCategoryId());
			categoryResponse.setCategoryName(product.getCategory().getCategoryName());
			
			for(ProductVariant prodVar: product.getProductVariants()) {
				productVariantResponse=new ProductVariantResponse();
				productVariantResponse.setPrice(prodVar.getPrice());
				productVariantResponse.setProductVariantName(prodVar.getProductVariantName());
				productVariantResponse.setProductVariantsId(prodVar.getProductVariantsId());
				productVariantResponse.setQuantity(prodVar.getQuantity());
				productVariantResponse.setSku(prodVar.getSku());
				
				sellerResponse=new SellerResponse();
				sellerResponse.setSellerId(prodVar.getSeller().getSellerId());
				sellerResponse.setSellerName(prodVar.getSeller().getSellerName());
				productVariantResponse.setSellerResponse(sellerResponse);
				productVarResps.add(productVariantResponse);
			}
			
			productResponse.setProductVarResp(productVarResps);
			productResponse.setBrandResponse(brandResponse);
			productResponse.setCategoryResponse(categoryResponse);
			responses.add(productResponse);
		}
		return responses;
	}

}
