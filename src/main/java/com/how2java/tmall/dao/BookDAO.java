package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Book;
import com.how2java.tmall.pojo.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Integer> {
    Page<Book> findByCategory(Category category, Pageable pageable);
}