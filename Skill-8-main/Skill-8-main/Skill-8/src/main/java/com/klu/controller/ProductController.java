package com.klu.controller;

import com.klu.model.Product;
import com.klu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min,
                                @RequestParam double max) {
        return service.filterByPrice(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> sorted() {
        return service.sortProducts();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }
}