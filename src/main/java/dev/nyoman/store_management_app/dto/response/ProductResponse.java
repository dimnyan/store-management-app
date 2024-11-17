package dev.nyoman.store_management_app.dto.response;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String name;
    private Long price;
    private Integer stock;
}
