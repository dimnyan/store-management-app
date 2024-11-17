package dev.nyoman.store_management_app.repository;

import dev.nyoman.store_management_app.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, String> {
    Page<Product> findAll(Specification<Product> specification, Pageable pageable);
}
