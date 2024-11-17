package dev.nyoman.store_management_app.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetailRequest {
    private String productId;
    private Integer quantity;
}
