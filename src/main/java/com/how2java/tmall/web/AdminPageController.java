package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//用于后台管理页面的页面跳转
@Controller
public class AdminPageController {
	@GetMapping(value="admin")
    public String admin(){
		return "redirect:admin_category_list";
    } //客户端跳转
	@GetMapping(value="/admin_category_list")
	public String listCategory(){
		return "admin/listCategory";
	}
	@GetMapping(value = "/admin_category_edit")
	public String editCategory(){
		return "admin/editCategory";
	}
	@GetMapping(value = "/admin_bookAll_list")
    public String listBookAll(){
	    return "admin/listBookAll";
    }
	@GetMapping(value = "admin_book_list")
	public String listBook(){
		return "admin/listBook";
	}
	@GetMapping(value = "admin_user_list")
	public String listUser(){
		return "admin/listUser";
	}
	@GetMapping(value = "admin_orderbook_list")
    public String listOrderbook(){
	    return "admin/listOrderBook";
    }
    @GetMapping(value = "admin_orderall_list")
    public String listOrderAll(){
        return "admin/listOrderAll";
    }
    @GetMapping(value = "admin_login")
	public String login(){
		return "admin/login";
	}
}
