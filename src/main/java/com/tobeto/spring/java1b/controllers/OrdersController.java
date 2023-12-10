package com.tobeto.spring.java1b.controllers;

import com.tobeto.spring.java1b.services.abstracts.OrderService;
import com.tobeto.spring.java1b.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.java1b.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderResponse;
import com.tobeto.spring.java1b.entities.Order;
import com.tobeto.spring.java1b.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {
    private final OrderService orderService;


    @GetMapping
    public List<GetOrderListResponse> getAll(){
       return orderService.getAll();

    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
       return orderService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
       orderService.add(addOrderRequest);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest) throws Exception {
       orderService.update(id,updateOrderRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);

    }
    @GetMapping("findByAmountLessThanEqual")
    public List<GetOrderListResponse> findByAmountLessThanEqual (@RequestParam double amount){
        return orderService.findByAmountLessThanEqual(amount);
    }
    @GetMapping("findByStartDateBetween")
    public List<GetOrderListResponse> findByStartDateBetween (@RequestParam LocalDate date1, LocalDate date2){
        return orderService.findByStartDateBetween(date1, date2);
    }
}
