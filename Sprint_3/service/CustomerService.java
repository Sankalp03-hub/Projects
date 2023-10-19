package com.clothkatta.sb.service;

import com.clothkatta.sb.entity.Customer;

public interface CustomerService {
	//method for saving Students details in db table
	Customer addCustomer(Customer customer);
	
	//method to fetch Students detail based on sid from db table
	Customer getCustomerDetails(int cid);
	
	//method to modify Students detail based on sid from db table
	Customer updateCustomerDetails(Customer customer, int cid);
	
	//method to remove Students detail based on sid from db table
	void deleteCustomerDetail(int cid);

}
