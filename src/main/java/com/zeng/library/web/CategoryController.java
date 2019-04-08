package com.zeng.library.web;

import com.zeng.library.pojo.Book;
import com.zeng.library.pojo.Category;
import com.zeng.library.service.CategoryService;
import com.zeng.library.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class CategoryController {
	@Autowired
    CategoryService categoryService;

	@GetMapping("/categories")
	public Page4Navigator<Book> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		start = start<0?0:start;
		Page4Navigator<Book> page =categoryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
		return page;
	}
	@PostMapping("/categories")
	public Object add(@RequestBody Category bean){
		categoryService.add(bean);
		return bean;
	}

	@DeleteMapping("/categories/{id}")
	public String delete(@PathVariable("id") int id,HttpServletRequest request){
		categoryService.delete(id);
		File imageFile = new File(request.getServletContext().getRealPath("/img/category"));
		File file = new File(imageFile,id+".jpg");
		file.delete();
		return null;
	}
	@GetMapping("/categories/{id}")
	public Category get(@PathVariable("id") int id) throws Exception{
		Category bean = categoryService.get(id);
		return bean;
	}
    @PutMapping("/categories")
    public Object update(@RequestBody Category bean){
	    categoryService.update(bean);
	    return bean;
    }
}

