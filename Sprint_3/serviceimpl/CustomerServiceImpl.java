package com.clothkatta.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothkatta.sb.entity.Customer;
import com.clothkatta.sb.exception.CustomerIdNotFoundException;
import com.clothkatta.sb.repository.CustomerRepository;
import com.clothkatta.sb.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository crepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return crepo.save(customer);
	}

	@Override
	public Customer getCustomerDetails(int cid) {
		return crepo.findById(cid).
			       orElseThrow(()-> new CustomerIdNotFoundException("Customer Id is not correct"));	}

	@Override
	public Customer updateCustomerDetails(Customer customer, int cid) {
		Customer updatedCustomer = crepo.findById(cid).
		         orElseThrow(()-> new CustomerIdNotFoundException("Customer Id is not correct"));

		//set new values
		updatedCustomer.setCphone(customer.getCphone());
		
		crepo.save(updatedCustomer); //saving updated details 
			return updatedCustomer; 
	}

	@Override
	public void deleteCustomerDetail(int cid) {
		crepo.findById(cid).
		orElseThrow(()-> new CustomerIdNotFoundException("Customer Id is not correct"));
	    crepo.deleteById(cid);		
	}

	
	
		

}
