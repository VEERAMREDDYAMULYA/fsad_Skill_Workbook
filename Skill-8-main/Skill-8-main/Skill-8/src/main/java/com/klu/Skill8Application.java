package com.klu;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Skill8Application {

    public static void main(String[] args) {
        SpringApplication.run(Skill8Application.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository repo) {
        return args -> {

            // Insert sample data
            repo.save(new Product("Laptop", "Electronics", 60000));
            repo.save(new Product("Phone", "Electronics", 30000));
            repo.save(new Product("Shoes", "Fashion", 2000));
            repo.save(new Product("Watch", "Fashion", 5000));
            repo.save(new Product("Tablet", "Electronics", 25000));

            System.out.println("Sample Products Inserted Successfully!");
        };
    }
}