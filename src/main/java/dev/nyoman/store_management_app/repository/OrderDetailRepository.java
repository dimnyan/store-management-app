package dev.nyoman.store_management_app.repository;

import dev.nyoman.store_management_app.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
