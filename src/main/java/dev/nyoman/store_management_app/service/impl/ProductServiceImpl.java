package dev.nyoman.store_management_app.service.impl;

import dev.nyoman.store_management_app.dto.request.ProductRequest;
import dev.nyoman.store_management_app.dto.request.SearchPagingRequest;
import dev.nyoman.store_management_app.dto.response.ProductResponse;
import dev.nyoman.store_management_app.entity.Product;
import dev.nyoman.store_management_app.repository.ProductsRepository;
import dev.nyoman.store_management_app.service.ProductService;
import dev.nyoman.store_management_app.specification.ProductSpecification;
import dev.nyoman.store_management_app.util.SortUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductsRepository productsRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        Product productBuilder = Product.builder()
                        .name(request.getName())
                                .stock(request.getStock())
                                        .price(request.getPrice())
                                                .build();
        return productsRepository.saveAndFlush(productBuilder);
    }

    @Override
    public Product findById(String id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public Page<ProductResponse> findAll(SearchPagingRequest request) {
        Sort sort = SortUtil.parseSort(request.getSort());
        Pageable pageable = PageRequest.of(request.getPage() <= 0 ? 0 : request.getPage(), request.getSize(), sort);
        Specification<Product> specification = ProductSpecification.getSpecification(request.getQuery());
        Page<Product> products = productsRepository.findAll(specification, pageable);
        return products.map(this::toResponse);
    }

    @Override
    public Product updateProduct(String id, ProductRequest request) {
        Product product = productsRepository.findById(id).get();
        product.setName(request.getName());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        return productsRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(String id) {
        productsRepository.deleteById(id);
    }

    private ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock()).build();
    }
}
