package com.clazerti.demo.resources;

import com.clazerti.demo.entities.Order;
import com.clazerti.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity<List<Order>> getAll() { return ResponseEntity.ok().body(orderService.findAll()); }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getById(@PathVariable Integer id) throws Exception {
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
