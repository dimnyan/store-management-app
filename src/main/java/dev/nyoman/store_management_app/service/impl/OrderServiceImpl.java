package dev.nyoman.store_management_app.service.impl;

import dev.nyoman.store_management_app.dto.request.CreateOrderRequest;
import dev.nyoman.store_management_app.dto.response.OrderResponse;
import dev.nyoman.store_management_app.entity.Order;
import dev.nyoman.store_management_app.entity.OrderDetail;
import dev.nyoman.store_management_app.entity.Product;
import dev.nyoman.store_management_app.repository.OrderDetailRepository;
import dev.nyoman.store_management_app.repository.OrderRepository;
import dev.nyoman.store_management_app.service.OrderService;
import dev.nyoman.store_management_app.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;
    private final OrderRepository orderRepository;

    @Override
    public String createOrder(CreateOrderRequest request) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        AtomicReference<Long> subtotal = new AtomicReference<>(0L);

        request.getOrderDetailRequestList().forEach(orderDetailRequest -> {
            Product product = productService.findById(orderDetailRequest.getProductId());
            subtotal.updateAndGet(v -> v + product.getPrice());
            OrderDetail orderDetail = OrderDetail.builder()
                    .products(product)
                    .quantity(orderDetailRequest.getQuantity())
                    .build();
            OrderDetail orderDetail1 = orderDetailRepository.saveAndFlush(orderDetail);
            orderDetailList.add(orderDetail1);
        });

        Order order = Order.builder()
                .orderDetail(orderDetailList)
                .subtotal(subtotal.get())
                .build();

        return orderRepository.saveAndFlush(order).getId();
    }

    @Override
    public List<Order> getAllOrders() {
       return orderRepository.findAll();
    }
}
