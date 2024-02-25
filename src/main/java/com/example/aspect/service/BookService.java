package com.example.aspect.service;

import com.example.aspect.annotation.LogreqAndRes;
import com.example.aspect.entity.Book;
import com.example.aspect.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;
/*    @PostConstruct
    public void initDb(){
        List<Book> books= IntStream.rangeClosed(1,1000).mapToObj(i -> new Book("book"+i,"author"+i,new Random().nextLong(5000))).collect(Collectors.toList());
            repository.saveAll(books);
    }*/
    @LogreqAndRes
    public Book addBook(Book book){
        Book newBook=new Book();

            newBook.setBookName(book.getBookName());

            newBook.setBookPrice(book.getBookPrice());
            newBook.setAuthorName(book.getAuthorName());
            return repository.save(newBook);
    }
    public Book getBookById(Integer bookId){
        return repository.findById(bookId).orElse(null);
    }
    public List<Book> getAllBooksByAuthorName(String authorName){
        List<Book> books=new ArrayList<>();
        books=repository.findAllByAuthorName(authorName);
        return books;
    }


}
