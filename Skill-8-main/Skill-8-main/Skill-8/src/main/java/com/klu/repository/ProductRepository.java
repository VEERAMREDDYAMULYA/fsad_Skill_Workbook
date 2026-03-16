package com.klu.repository;

import com.klu.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Queries
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL – Sort by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortByPrice();

    // JPQL – Expensive products
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensive(@Param("price") double price);

    // JPQL – Fetch by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> fetchByCategory(@Param("category") String category);
}