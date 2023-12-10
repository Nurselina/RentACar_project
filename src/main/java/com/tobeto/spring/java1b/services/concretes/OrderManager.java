package com.tobeto.spring.java1b.services.concretes;

import com.tobeto.spring.java1b.entities.Order;
import com.tobeto.spring.java1b.repositories.OrderRepository;
import com.tobeto.spring.java1b.services.abstracts.OrderService;
import com.tobeto.spring.java1b.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.java1b.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<GetOrderListResponse> getAll() {
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

    @Override
    public GetOrderResponse getById(int id) {
        Order order=orderRepository.findById(id).orElseThrow();
        GetOrderResponse getOrderResponse =new GetOrderResponse();
        getOrderResponse.setAmount(order.getAmount());
        getOrderResponse.setDate(order.getDate());
        getOrderResponse.setStarRent(order.getStartRent());
        getOrderResponse.setEndRent(order.getEndRent());


        return getOrderResponse;
    }

    @Override
    public void add(AddOrderRequest addOrderRequest) {
        Order order=new Order();
        order.setAmount(addOrderRequest.getAmount());
        order.setDate(addOrderRequest.getDate());
        order.setStartRent(addOrderRequest.getStarRent());
        order.setEndRent(addOrderRequest.getEndRent());

        orderRepository.save(order);
    }

    @Override
    public void update(int id, UpdateOrderRequest updateOrderRequest) throws Exception {
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

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<GetOrderListResponse> findByAmountLessThanEqual(double amount) {
        List<Order> orderList=orderRepository.findByAmountLessThanEqual(amount);
        List<GetOrderListResponse> getOrderListResponses =new ArrayList<>();
        for (Order order : orderList){
            GetOrderListResponse response= new GetOrderListResponse();
            response.setAmount(order.getAmount());
            response.setDate(order.getDate());
            response.setStarRent(order.getStartRent());
            response.setEndRent(order.getEndRent());
            getOrderListResponses.add(response);


        }
        return getOrderListResponses;
    }

    @Override
    public List<GetOrderListResponse> findByStartDateBetween(LocalDate date1, LocalDate date2) {
        return orderRepository.findByStartDateBetween(date1, date2);
    }
}
