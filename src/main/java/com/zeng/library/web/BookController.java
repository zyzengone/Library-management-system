package com.zeng.library.web;

import com.zeng.library.pojo.Book;
import com.zeng.library.service.BookService;
import com.zeng.library.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public Page4Navigator<Book> list(@RequestParam(value = "start",defaultValue = "0") int start,
                                     @RequestParam(value ="size",defaultValue = "5")int size){
        start = start<0?0:start;
        Page4Navigator<Book> page = bookService.listAll(start,size,5);
        return page;
    }
    @GetMapping("/categories/{cid}/books")
    public Page4Navigator<Book> list(@PathVariable("cid") int cid, @RequestParam(value = "start",defaultValue = "0")int start,
                                     @RequestParam(value = "size",defaultValue = "5")int size){
        start = start<0?0:start;
        Page4Navigator<Book> page = bookService.list(cid,start,size,5);
        return page;
    }
    @GetMapping("books/{id}")
    public Book get(@PathVariable(value = "id") int id){
        Book book = bookService.findOne(id);
        return book;
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
    @PutMapping("/books")
    public Object update(@RequestBody Book bean){
        bookService.update(bean);
        return bean;
    }
}
