package com.example.aspect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;
    private String authorName;
    private Long bookPrice;


    public Book(String s, String s1, Long v) {
        this.bookName=s;
        this.authorName=s1;
        this.bookPrice=v;
    }
}
