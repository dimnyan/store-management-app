package dev.nyoman.store_management_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;
    private Long subtotal;
    private LocalDateTime date;


    @PrePersist
    protected void prePersist() {
        this.date = LocalDateTime.now();
    }
}
