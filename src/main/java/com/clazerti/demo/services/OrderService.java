package com.clazerti.demo.services;

import com.clazerti.demo.entities.Order;
import com.clazerti.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Integer id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new Exception("Pedido não encontrado");
        }

        return order.get();
    }
}
