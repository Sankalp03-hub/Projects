package com.clothkatta.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clothkatta.sb.entity.Order;
import com.clothkatta.sb.service.OrderService;

import jakarta.validation.Valid;

public class OrderController {
	
	@Autowired
	OrderService os;
	
	@PostMapping("/order/addOrder")
	public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order){
		return new ResponseEntity<Order>(os.addorder(order),
				HttpStatus.CREATED);
	}
	
	//use getmapping to fetch data from db table
	@GetMapping("/order/getOrder/{oid}")
	public ResponseEntity<Order> getOrder(@PathVariable("cid") int cid){
		return new ResponseEntity<Order>(os.getorderDetail(cid),HttpStatus.OK);
	}
	
	@GetMapping("order/getOrder")
	public List<Order> getOrder(){
		return os.getAllorder();
	}

}
