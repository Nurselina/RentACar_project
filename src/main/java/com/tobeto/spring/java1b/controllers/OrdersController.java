package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.java1b.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.java1b.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.java1b.dtos.responses.order.GetOrderResponse;
import com.tobeto.spring.java1b.entities.Company;
import com.tobeto.spring.java1b.entities.Order;
import com.tobeto.spring.java1b.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<GetOrderListResponse> getAll(){
        List<Order> orderList =orderRepository.findAll();
        List<GetOrderListResponse> getOrderListResponses =new ArrayList<>();
        for(Order order: orderList){
            GetOrderListResponse response=new GetOrderListResponse();
            response.setAmount(order.getAmount());
            response.setDate(order.getDate());
            response.setStarRent(order.getStartRent());
            response.setEndRent(order.getEndRent());
            getOrderListResponses.add(response);
        }
        return getOrderListResponses;

    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        Order order=orderRepository.findById(id).orElseThrow();
        GetOrderResponse getOrderResponse =new GetOrderResponse();
        getOrderResponse.setAmount(order.getAmount());
        getOrderResponse.setDate(order.getDate());
        getOrderResponse.setStarRent(order.getStartRent());
        getOrderResponse.setEndRent(order.getEndRent());


        return getOrderResponse;
    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        Order order=new Order();
        order.setAmount(addOrderRequest.getAmount());
        order.setDate(addOrderRequest.getDate());
        order.setStartRent(addOrderRequest.getStarRent());
        order.setEndRent(addOrderRequest.getEndRent());

        orderRepository.save(order);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest) throws Exception {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setAmount(updateOrderRequest.getAmount());
            order.setDate(updateOrderRequest.getDate());
            order.setStartRent(updateOrderRequest.getStarRent());
            order.setEndRent(updateOrderRequest.getEndRent());
            orderRepository.save(order);
        } else {
            throw new Exception("Güncellenemedi.");
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderRepository.deleteById(id);

    }
}
