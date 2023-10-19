package com.clothkatta.sb.service;

import com.clothkatta.sb.entity.Product;

public interface ProductService {
	//method for saving Students details in db table
	        Product addProduct(Product product);
			
			//method to fetch Students detail based on sid from db table
	        Product getProductDetails(int pid);
			
			//method to modify Students detail based on sid from db table
	        Product updateProductDetails(Product product, int pid);
			
			//method to remove Students detail based on sid from db table
			void deleteProductDetail(int pid);

}
