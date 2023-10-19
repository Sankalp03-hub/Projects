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

import com.clothkatta.sb.entity.Customer;
import com.clothkatta.sb.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	//use postmapping to insert data
		@PostMapping("/addCustomer")
		public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer){
			return new ResponseEntity<Customer>(cs.addCustomer(customer),HttpStatus.CREATED);
		}
		//use getmapping to fetch data from db table
		@GetMapping("/getCustomer/{cid}")
		public ResponseEntity<Customer> getcustomer(@PathVariable("cid") int cid){
		return new ResponseEntity<Customer>(cs.getCustomerDetails(cid),HttpStatus.OK);
		}
		
		//use getmapping to remove existing data from db table
		@PutMapping("/editCustomer/{cid}")
		public ResponseEntity<Customer> editCustomer(@Valid @PathVariable("cid") int cid, @RequestBody Customer customer){
		return new ResponseEntity<Customer>(cs.updateCustomerDetails(customer, cid),HttpStatus.OK);
		}
		@DeleteMapping("/deleteCustomer/{cid}")
		public ResponseEntity<String> deleteTeacher(@PathVariable("cid") int cid){
			cs.deleteCustomerDetail(cid);
		return new ResponseEntity<String>("Deleted successfully....",HttpStatus.OK);
		
		}
	

}
