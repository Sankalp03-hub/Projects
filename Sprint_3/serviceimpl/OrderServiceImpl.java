package com.clothkatta.sb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothkatta.sb.entity.Order;
import com.clothkatta.sb.exception.OrderIdNotFoundException;
import com.clothkatta.sb.repository.OrderRepository;
import com.clothkatta.sb.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	OrderRepository orepo;
	
	@Override
	public Order addorder(Order order) {
		// TODO Auto-generated method stub
		return orepo.save(order);
	}

	@Override
	public Order getorderDetail(int oid) {
		// TODO Auto-generated method stub
		return orepo.findById(oid).orElseThrow(()-> new OrderIdNotFoundException("Entered batch is not present"));
	}

	@Override
	public List<Order> getAllorder() {
		// TODO Auto-generated method stub
		return orepo.findAll();
	}

	

}
