package com.how2java.tmall.web;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Object login(@RequestBody User userParam, HttpSession httpSession){
        User user = userService.get(userParam.getName(),userParam.getPassWord());
        if (user==null){
            return Result.fail();
        } else {
            httpSession.setAttribute("user",userParam);
            return Result.success();
        }
    }
}
