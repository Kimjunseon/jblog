package com.bitacademy.jblog.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.vo.CategoryVo;


@Controller
@RequestMapping("/{id:(?!assets).*}/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public String categoryIndex(@RequestParam("no") Long no , Model model) {
		Map<String, Object> map = categoryService.getCategoryList(no);
		model.addAttribute("map", map);
		System.out.println("no: " + no);
		System.out.println("map: " + map);
		return "blog/admin-category";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(CategoryVo categoryVo) {
		categoryService.addCategory(categoryVo);
		return "redirect:/"+categoryVo.getId()+"/admin/category";
		
	}
	
}
