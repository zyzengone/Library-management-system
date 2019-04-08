package com.zeng.library.dao;

import com.zeng.library.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User getByNameAndPassWord(String name,String password);
}
