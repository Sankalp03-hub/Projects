package com.clothkatta.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clothkatta.sb.entity.Product;
import com.clothkatta.sb.service.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController

public class ProductController {
	
	@Autowired
	ProductService ps;
	
	//use postmapping to insert data
	@PostMapping("/addProducts")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
		return new ResponseEntity<Product>(ps.addProduct(product),HttpStatus.CREATED);
	}
	//use getmapping to fetch data from db table
	@GetMapping("/getProduct/{pid}")
	public ResponseEntity<Product> getProduct( @PathVariable("pid") int pid){
	return new ResponseEntity<Product>(ps.getProductDetails(pid),HttpStatus.OK);
	}
	
	//use getmapping to remove existing data from db table
	@PutMapping("/editProduct/{pid}")
	public ResponseEntity<Product> editProduct(@Valid @PathVariable("pid") int pid, @RequestBody Product product){
	return new ResponseEntity<Product>(ps.updateProductDetails(product, pid),HttpStatus.OK);
	}
	@DeleteMapping("/deleteProduct/{pid}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("pid") int pid){
		ps.deleteProductDetail(pid);
	return new ResponseEntity<String>("Deleted successfully....",HttpStatus.OK);
	
	}

}
