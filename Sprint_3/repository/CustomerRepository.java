package com.clothkatta.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothkatta.sb.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
