package com.zeng.library.dao;
 
import com.zeng.library.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
