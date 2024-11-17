package dev.nyoman.store_management_app.dto.request;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateOrderRequest {
    List<OrderDetailRequest> orderDetailRequestList;
}
