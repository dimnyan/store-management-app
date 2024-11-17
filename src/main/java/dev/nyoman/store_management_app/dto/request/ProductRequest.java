package dev.nyoman.store_management_app.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductRequest {
    private String name;
    private Long price;
    private Integer stock;
}
