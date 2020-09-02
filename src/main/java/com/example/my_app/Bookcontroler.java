package com.example.my_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Bookcontroler {
    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @PostMapping("/books")
    public boolean createABook(@RequestBody Book book){
        repository.save(book);
        return true;
    }
    @GetMapping("/books/{id}")
    public Book findAbook(@PathVariable int id){
        Optional<Book> book1=repository.findById(id);
        return book1.get();  

    }

}
