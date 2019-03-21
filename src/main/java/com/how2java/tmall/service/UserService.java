package com.how2java.tmall.service;

import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public User get(int id){
        return userDAO.findOne(id);
    }
    public Page4Navigator list(int start, int size,int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormat = userDAO.findAll(pageable);
        return new Page4Navigator(pageFormat,navigatePages);
    }
}
