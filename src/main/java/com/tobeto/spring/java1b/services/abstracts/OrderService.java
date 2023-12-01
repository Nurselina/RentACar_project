package com.tobeto.spring.java1b.services.abstracts;

import com.tobeto.spring.java1b.services.dtos.requests.order.AddOrderRequest;
import com.tobeto.spring.java1b.services.dtos.requests.order.UpdateOrderRequest;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderListResponse;
import com.tobeto.spring.java1b.services.dtos.responses.order.GetOrderResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {
    List<GetOrderListResponse> getAll();
    GetOrderResponse getById(int id);
    void add(AddOrderRequest addOrderRequest);
    void update(int id, UpdateOrderRequest updateOrderRequest) throws Exception;
    void delete(int id);
}
