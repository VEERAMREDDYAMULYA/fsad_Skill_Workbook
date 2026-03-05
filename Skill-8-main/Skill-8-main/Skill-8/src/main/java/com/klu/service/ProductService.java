package com.klu.service;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> filterByPrice(double min, double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> sortProducts() {
        return repo.sortByPrice();
    }

    public List<Product> getExpensiveProducts(double price) {
        return repo.findExpensive(price);
    }
}