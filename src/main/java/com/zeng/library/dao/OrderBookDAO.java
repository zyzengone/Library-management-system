package com.zeng.library.dao;

import com.zeng.library.pojo.OrderBook;
import com.zeng.library.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookDAO extends JpaRepository<OrderBook,Integer> {
    Page<OrderBook> findByUser(User user, Pageable pageable);
}
