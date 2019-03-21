package com.how2java.tmall.service;

import com.how2java.tmall.dao.OrderBookDAO;
import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.Book;
import com.how2java.tmall.pojo.OrderBook;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBookService {
    @Autowired
    OrderBookDAO orderBookDAO;
    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;
    public void add(OrderBook bean){
        orderBookDAO.save(bean);
    }
    public void delete(int id){
        orderBookDAO.delete(id);
    }
    public Object get(int id){
       return orderBookDAO.findOne(id);
    }
    public void update(OrderBook bean){
        orderBookDAO.save(bean);
    }
    public Page4Navigator<OrderBook> list(int uid, int start, int size, int navigatePage){
        User user = userService.get(uid);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormat = orderBookDAO.findByUser(user,pageable);
        return new Page4Navigator<OrderBook>(pageFormat,navigatePage);
    }
    public Page4Navigator<OrderBook> listAll(int start,int size,int navigatePage){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormat = orderBookDAO.findAll(pageable);
        return new Page4Navigator<OrderBook>(pageFormat,navigatePage);
    }
}
