package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//用于后台管理页面的页面跳转
@Controller
public class AdminPageController {
	@GetMapping(value="/admin")
    public String admin(){
		return "redirect:admin_category_list";
    }
	@GetMapping(value="/admin_category_list")
	public String listCategory(){
		return "admin/listCategory";
	}
	@GetMapping(value = "/admin_category_edit")
	public String editCategory(){
		return "admin/editCategory";
	}
	@GetMapping(value = "admin_book_list")
	public String listBook(){
		return "admin/listBook";
	}
	@GetMapping(value = "admin_user_list")
	public String listUser(){
		return "admin/listUser";
	}
}
