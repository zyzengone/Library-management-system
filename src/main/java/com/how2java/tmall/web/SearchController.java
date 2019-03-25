package com.how2java.tmall.web;


import com.how2java.tmall.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {
    @Autowired
    BookService bookService;
    @PostMapping("/search")
    public Object search(@RequestParam(value = "keyword") String keyWord){
        return bookService.search(keyWord,0,20);
    }
}
