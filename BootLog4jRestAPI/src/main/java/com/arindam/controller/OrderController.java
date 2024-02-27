package com.arindam.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.exception.OrderIdNotFoundException;
import com.arindam.model.Order;
import com.arindam.service.OrderService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/order")
@CrossOrigin(origins="http://localhost:3000/")
@Validated
public class OrderController {
	@Autowired
Environment env;
	@Autowired
	OrderService oservice;
	Log logger=LogFactory.getLog(OrderController.class);
	@PostMapping("/add")
	public ResponseEntity<String> addData(@Valid @RequestBody Order order)
	{
		String msg=env.getProperty("order.add.data");
		oservice.addData(order);
		logger.info("DATA ADDED"+order.getOrderId());
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/fetch")
	public ResponseEntity<List<Order>> getData()
	{
	 List<Order> olist=oservice.getData();
	 return new ResponseEntity<List<Order>>(olist,HttpStatus.OK);
	}
	@DeleteMapping("/del/{orderId}")
	public ResponseEntity<String> deleteData(@PathVariable String orderId)
	{
		String msg=env.getProperty("order.data.delete");
		oservice.deleteData(orderId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/upd/{orderId}")
	public ResponseEntity<Order> updateData(@PathVariable String orderId,@RequestBody Order order)
	{
		Order orders=oservice.updateData(order, orderId);
		return new ResponseEntity<Order>(orders,HttpStatus.OK);
		
	}
	@GetMapping("/fetch/{orderId}")
	public ResponseEntity<Order> getDataByID(@PathVariable String orderId) throws OrderIdNotFoundException
	{
		Order order=oservice.getorderById(orderId);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}

}