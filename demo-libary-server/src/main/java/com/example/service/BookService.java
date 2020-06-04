package com.example.service;

import com.example.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    public Map<String,Object> getAllBook(Integer page, Integer size);
    public Book getBookById(Integer bid);
    public List<Book> searchBooks(String name);
}
