package dev.nyoman.store_management_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Long price;
    private Integer stock;
}
