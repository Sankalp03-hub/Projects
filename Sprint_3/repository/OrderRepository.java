package com.clothkatta.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothkatta.sb.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
