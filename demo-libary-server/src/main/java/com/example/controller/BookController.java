package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    private Integer size = 5;

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public Map<String,Object> allBooks(Integer page){
        Integer pid = page == null ? 1: page;
        return bookService.getAllBook(pid,size);
    }

    @RequestMapping(value = "/books/{bid}",method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer bid){
        return bookService.getBookById(bid);
    }

    @RequestMapping(value = "/book/{name}",method = RequestMethod.GET)
    public List<Book> searchBook( @PathVariable String name ){
        return bookService.searchBooks(name);
    }


}
