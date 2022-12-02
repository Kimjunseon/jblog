package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/catagory")
public class CategoryController {

	@RequestMapping(value="/add")
	public String add() {
		
		return "/category";
		
	}
	
	
	
	
}
