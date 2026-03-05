package com.klu.springmvclibrary;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1. welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2. count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 3. price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4. list of books
    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java", "Spring Boot", "Data Structures");
    }

    // 5. path variable
    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id) {
        return "Details of Book Id: " + id;
    }

    // 6. request parameter
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching book with title: " + title;
    }

    // 7. author name
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 8. add book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book Added Successfully";
    }

    // 9. view books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}