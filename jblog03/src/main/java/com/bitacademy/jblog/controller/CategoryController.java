package com.bitacademy.jblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.vo.CategoryVo;


@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping({"","/list"})
	public String index() {
		return "blog/admin-category";
	}
	
	@RequestMapping(value="/add")
	public String add(CategoryVo categoryVo) {
		System.out.println("--" + categoryVo);
		categoryService.addCategory(categoryVo);
		return "redirect:/category";
		
	}
	
	
	
	
}
