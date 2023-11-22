package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.entities.Order;
import com.tobeto.spring.java1b.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @GetMapping("{id}")
    public Order getById(@PathVariable int id){

        return orderRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Order order){

        orderRepository.save(order);
    }
    @PutMapping("{id}")
    public void update(@RequestBody Order order){
        orderRepository.findById(order.getId()).orElseThrow();
        orderRepository.save(order);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderRepository.deleteById(id);

    }
}
