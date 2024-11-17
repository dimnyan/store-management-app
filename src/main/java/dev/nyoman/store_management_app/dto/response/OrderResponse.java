package dev.nyoman.store_management_app.dto.response;

import dev.nyoman.store_management_app.entity.OrderDetail;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderResponse {
    private String orderId;
    private List<OrderDetail> orderDetails;
}
