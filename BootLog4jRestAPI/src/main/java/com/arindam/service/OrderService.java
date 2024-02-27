package com.arindam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.exception.OrderIdNotFoundException;
import com.arindam.model.Order;
import com.arindam.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
OrderRepository orepo;
	public void addData(Order order)
	{
		orepo.save(order);
	}
	public void deleteData(String orderId)
	{
		Order order=orepo.findById(orderId).orElse(null);
		if(order!=null)
		{
			orepo.delete(order);
		}
	}
	public List<Order> getData()
	{
		List<Order> olist=orepo.findAll();
		return olist;
	}
	public Order updateData(Order order,String orderId)
	{
		Order orders=orepo.findById(orderId).orElse(null);
		if(orders!=null)
		{
			orders.setOrderId(orderId);
			//orders.setOrderDt(order.getOrderDt());
			orders.setOqty(order.getOqty());
			orepo.save(orders);
			
		}
		return orders;
		
	}
	public Order getorderById(String orderId) throws OrderIdNotFoundException
	{
		Order order=orepo.findById(orderId).orElse(null);
		if(order==null)
		{
			throw new OrderIdNotFoundException();
		}
		return order;
	}
}
