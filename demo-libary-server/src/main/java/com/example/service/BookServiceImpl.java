package com.example.service;

import com.example.dao.RedisDao;
import com.example.entity.Book;
import com.example.mapper.BookMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Value("${redis.key}")
    private String key;

    @Autowired
    private RedisDao redisDao;

    @Override
    public Map<String,Object> getAllBook(Integer page,Integer size) {

        Map<String,Object> map = new HashMap<>();

        PageHelper.startPage(page, size);
        List<Book> books = bookMapper.selectAllBook();
        PageInfo<Book> info = new PageInfo<>(books);
        map.put("books", info.getList());
        map.put("rowCount", info.getTotal());
        map.put("pageCount", info.getPages());
        return map;
    }

    @Override
    public Book getBookById(Integer bid) {
        return bookMapper.selectBookById(bid);
    }

    @Override
    public List<Book> searchBooks(String name) {
        redisDao.setAdd(key,name);
        redisDao.expireat(key,5);
        return bookMapper.selectBooks(name);
    }
}
