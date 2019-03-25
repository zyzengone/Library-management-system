package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class CategoryController {
	@Autowired CategoryService categoryService;

	@GetMapping("/categories")
	public Page list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		start = start<0?0:start;
		Page page =categoryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
		return page;
	}
	@PostMapping("/categories")
	public Object add(Category bean){
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
//	@PutMapping("/categories/{id}")
//	public Object update(Category bean,MultipartFile image,HttpServletRequest request) throws IOException {
//		String name = request.getParameter("name");
//		bean.setName(name);
//		categoryService.update(bean);
//		if (image!=null)
//			saveOrUpdateImageFile(bean,image,request);
//		return bean;
//	}
    @PutMapping("/categories")
    public Object update(@RequestBody Category bean){
	    categoryService.update(bean);
	    return bean;
    }
}

