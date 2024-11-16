package com.mustbuy.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.mustbuy.orderservice.entity.Order;

public interface OrderService {
	Order createOrder(Order order);

	Optional<Order> getOrderById(Integer orderId);

	List<Order> getAllOrders();

	Order updateOrder(Integer orderId, Order order);

	void deleteOrder(Integer orderId);
}
