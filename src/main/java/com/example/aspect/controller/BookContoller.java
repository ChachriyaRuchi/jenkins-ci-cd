package com.example.aspect.controller;

import com.example.aspect.annotation.LogreqAndRes;
import com.example.aspect.entity.Book;
import com.example.aspect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookContoller {
    @Autowired
    private BookService bookService;
    @LogreqAndRes
    @PostMapping
    public Book createBook(@RequestBody Book book){
       return bookService.addBook(book);
    }
    @GetMapping("/{id}")
    public Book getBookBYId(@PathVariable("id") Integer id){
        return bookService.getBookById(id);
    }
    @GetMapping("/all/{author}")
    public List<Book> getAllBooks(@PathVariable("author")String authorName){
        return bookService.getAllBooksByAuthorName(authorName);
    }
}
