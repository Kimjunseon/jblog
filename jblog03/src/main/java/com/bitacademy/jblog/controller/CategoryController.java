package com.bitacademy.jblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.UserVo;


@Controller
@RequestMapping("/{id:(?!assets).*}/admin/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public String categoryIndex(UserVo userVo, Model model) {
		model.addAttribute("list", categoryService.getCategoryList());
		System.out.println(model);
		return "blog/admin-category";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(CategoryVo categoryVo) {
		System.out.println(categoryVo);
		categoryService.addCategory(categoryVo);
		return "redirect:/"+categoryVo.getId()+"/admin/category";
		
	}
	
	@RequestMapping(value="/delete/{title}", method=RequestMethod.GET)
	public String delete(@PathVariable("title") String title, CategoryVo categoryVo) {
		categoryService.deleteCategory(title);
		return "redirect:/"+categoryVo.getId()+"/admin/category";
		
	}
	
}
