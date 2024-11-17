package dev.nyoman.store_management_app.controller;

import dev.nyoman.store_management_app.dto.request.ProductRequest;
import dev.nyoman.store_management_app.dto.request.SearchPagingRequest;
import dev.nyoman.store_management_app.dto.response.ProductResponse;
import dev.nyoman.store_management_app.entity.Product;
import dev.nyoman.store_management_app.service.ProductService;
import dev.nyoman.store_management_app.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        Product product = productService.createProduct(request);
        return ResponseUtil.responseBuilder(HttpStatus.CREATED, "Successfully create new Product",product);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "name") String sort
    ) {
        SearchPagingRequest pagingResponse = SearchPagingRequest.builder()
                .query(name)
                .page(page - 1)
                .size(size)
                .sort(sort)
                .build();
        Page<ProductResponse> productResponses = productService.findAll(pagingResponse);
        return ResponseUtil.responseBuilderPage(HttpStatus.OK, "Successfully retrieved all Products", productResponses);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        Product product = productService.findById(id);
        return ResponseUtil.responseBuilder(HttpStatus.OK, "Successfully retrieved Product by ID", product);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductRequest request) {
        Product product = productService.updateProduct(id, request);
        return ResponseUtil.responseBuilder(HttpStatus.OK, "Successfully updated Product by ID", product);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseUtil.responseBuilder(HttpStatus.OK, "Successfully deleted Product by ID", id);
    }
}
