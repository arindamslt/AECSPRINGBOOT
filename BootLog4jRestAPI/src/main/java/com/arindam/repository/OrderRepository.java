package com.arindam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arindam.model.Order;

public interface OrderRepository extends JpaRepository<Order,String> {

}
