package dev.nyoman.store_management_app.service;

import dev.nyoman.store_management_app.dto.request.CreateOrderRequest;
import dev.nyoman.store_management_app.dto.response.OrderResponse;
import dev.nyoman.store_management_app.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    String createOrder(CreateOrderRequest request);
    List<Order> getAllOrders();
}
