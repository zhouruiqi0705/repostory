package com.example.mapper;

import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    public List<Book> selectAllBook();
    public Book selectBookById(Integer bid);
    public List<Book> selectBooks(String name);

}
