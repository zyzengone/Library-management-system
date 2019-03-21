package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Book;
import com.how2java.tmall.service.BookService;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/categories/{cid}/books")
    public Page4Navigator<Book> list(@PathVariable("cid") int cid, @RequestParam(value = "start",defaultValue = "0")int start,
                                     @RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Page4Navigator<Book> page = bookService.list(cid,start,size,5);
        return page;
    }
    @PostMapping("/books")
    public Object add(@RequestBody Book bean){
        bookService.add(bean);
        return bean;
    }
    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.delete(id);
        return null;
    }
}
