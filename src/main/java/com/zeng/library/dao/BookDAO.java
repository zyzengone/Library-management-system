package com.zeng.library.dao;

import com.zeng.library.pojo.Book;
import com.zeng.library.pojo.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    Page<Book> findByCategory(Category category, Pageable pageable);
    List<Book> findByNameLike(String keyword,Pageable pageable);
}
