package com.clothkatta.sb.service;


import java.util.List;

import com.clothkatta.sb.entity.Order;

public interface OrderService {
	
	
	Order addorder(Order order);
	
	Order getorderDetail(int oid);
	
	List<Order> getAllorder();

}
