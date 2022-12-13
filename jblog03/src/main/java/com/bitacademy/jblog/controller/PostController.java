package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets).*}/admin/write")
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public String write(Model model) {
		model.addAttribute("list", categoryService.getCategoryList());
		return "blog/admin-write";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestParam("vo.title") String title,
					  PostVo postVo,
					  UserVo userVo) {
		CategoryVo categoryVo = categoryService.findCategoryNo(title);
		postVo.setCategoryNo(categoryVo.getNo());
		postService.addPost(postVo);
		return "redirect:/"+userVo.getId()+""; 
	}
	
}
