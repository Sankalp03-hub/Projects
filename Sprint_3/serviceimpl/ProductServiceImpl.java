
package com.clothkatta.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothkatta.sb.entity.Product;
import com.clothkatta.sb.exception.CustomerIdNotFoundException;
import com.clothkatta.sb.exception.ProductIdNotFoundException;
import com.clothkatta.sb.repository.ProductRepository;
import com.clothkatta.sb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository prepo;

	@Override
	public Product addProduct(Product product) {
		return prepo.save(product);

	}

	@Override
	public Product getProductDetails(int pid) {
		return prepo.findById(pid).
			       orElseThrow(()-> new ProductIdNotFoundException("Product Id is not correct"));	}

	

	@Override
	public Product updateProductDetails(Product product, int pid) {
		Product updatedProduct = prepo.findById(pid).
		         orElseThrow(()-> new ProductIdNotFoundException("Product Id is not correct"));

		//set new values
		updatedProduct.setPprice(product.getPprice());
		
		prepo.save(updatedProduct); //saving updated details 
			return updatedProduct; 
	}

	@Override
	public void deleteProductDetail(int pid) {
		prepo.findById(pid).
		orElseThrow(()-> new CustomerIdNotFoundException("Product Id is not correct"));
	    prepo.deleteById(pid);			
	}

}
