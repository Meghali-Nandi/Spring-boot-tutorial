package com.walmart.api.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.api.order.models.Order;

public interface OrderDao extends JpaRepository<Order,String>{
}
