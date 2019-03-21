package com.how2java.tmall.web;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public Page4Navigator list(@RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size){
        start = start<0?0:start;
        Page4Navigator pageUser = userService.list(start,size,5);
        return pageUser;
    }
}
