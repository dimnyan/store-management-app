package dev.nyoman.store_management_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product products;
    private int quantity;
}
