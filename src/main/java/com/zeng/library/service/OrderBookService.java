package com.zeng.library.service;

import com.zeng.library.dao.OrderBookDAO;
import com.zeng.library.dao.UserDAO;
import com.zeng.library.pojo.OrderBook;
import com.zeng.library.pojo.User;
import com.zeng.library.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
