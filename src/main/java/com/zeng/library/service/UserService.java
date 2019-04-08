package com.zeng.library.service;

import com.zeng.library.dao.UserDAO;
import com.zeng.library.pojo.User;
import com.zeng.library.util.Page4Navigator;
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
    public Page4Navigator list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormat = userDAO.findAll(pageable);
        return new Page4Navigator(pageFormat,navigatePages);
    }
    public User get(String name,String password){
        return userDAO.getByNameAndPassWord(name,password);
    }
}
