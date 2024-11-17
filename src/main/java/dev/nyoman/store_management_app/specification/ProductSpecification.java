package dev.nyoman.store_management_app.specification;

import dev.nyoman.store_management_app.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class ProductSpecification {
    public static Specification<Product> getSpecification(String q){
        return (root, query, criteriaBuilder) -> {
            if(!StringUtils.hasText(q)) return criteriaBuilder.conjunction();

            Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%"+q+"%");
            return namePredicate;
        };

    }
}