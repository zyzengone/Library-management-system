package com.how2java.tmall.service;

import com.how2java.tmall.dao.BookDAO;
import com.how2java.tmall.pojo.Book;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired CategoryService categoryService;
    public void add(Book bean){
        bookDAO.save(bean);
    }
    public void delete(int id){
        bookDAO.delete(id);
    }
    public Book get(int id){
        return bookDAO.findOne(id);
    }
    public void update(Book bean){
        bookDAO.save(bean);
    }
    public Page4Navigator<Book> list(int cid,int start,int size,int navigatePages ){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Book> pageFromJPA = bookDAO.findByCategory(category,pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
    public Page4Navigator<Book> listAll(int start,int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Book> pageFromJPA = bookDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
    public List<Book> search(String name, int start, int size){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable page = new PageRequest(start,size,sort);
        List<Book> books = bookDAO.findByNameLike("%"+name+"%",page);
        return books;
    }
}
