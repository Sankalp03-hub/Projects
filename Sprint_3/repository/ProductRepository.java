package com.clothkatta.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothkatta.sb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
