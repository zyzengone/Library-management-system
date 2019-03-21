package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.OrderBook;
import com.how2java.tmall.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookDAO extends JpaRepository<OrderBook,Integer> {
    Page<OrderBook> findByUser(User user, Pageable pageable);
}
