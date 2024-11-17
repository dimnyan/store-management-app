package dev.nyoman.store_management_app.service;

import dev.nyoman.store_management_app.dto.request.ProductRequest;
import dev.nyoman.store_management_app.dto.request.SearchPagingRequest;
import dev.nyoman.store_management_app.dto.response.ProductResponse;
import dev.nyoman.store_management_app.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest request);
    Product findById(String id);
    Page<ProductResponse> findAll(SearchPagingRequest request);
    Product updateProduct(String id, ProductRequest request);
    void deleteProduct(String id);
}
