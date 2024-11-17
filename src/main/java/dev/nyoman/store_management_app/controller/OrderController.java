package dev.nyoman.store_management_app.controller;

import dev.nyoman.store_management_app.dto.request.CreateOrderRequest;
import dev.nyoman.store_management_app.entity.Order;
import dev.nyoman.store_management_app.service.OrderService;
import dev.nyoman.store_management_app.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        return ResponseUtil.responseBuilder(HttpStatus.CREATED, "Successfully Created New Order", orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return ResponseUtil.responseBuilder(HttpStatus.OK, "All Orders", orderService.getAllOrders());
    }
}
