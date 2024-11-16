package com.mustbuy.orderservice.service;

import com.mustbuy.orderservice.entity.Order;
import com.mustbuy.orderservice.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);  // Create or update the order
    }

    @Override
    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);  // Get order by ID
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();  // Get all orders
    }

    @Override
    public Order updateOrder(Integer orderId, Order order) {
        if (orderRepository.existsById(orderId)) {
            order.setOrderId(orderId);  // Ensure the orderId matches the existing one
            return orderRepository.save(order);  // Update the order
        } else {
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }

    @Override
    public void deleteOrder(Integer orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);  // Delete order by ID
        } else {
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }
}
