package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.vo.BlogVo;
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
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("")
	public String write(Model model, UserVo userVo) {
		model.addAttribute("list", categoryService.getCategoryList());
		BlogVo blogVo2 = blogService.findBlog(userVo.getId());
		model.addAttribute("blogVo2", blogVo2);
		return "blog/admin-write";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestParam("vo.title") String title,
					  PostVo postVo,
					  UserVo userVo) {
		CategoryVo categoryVo = categoryService.findCategoryNo(title);
		System.out.println(categoryVo);
		postVo.setCategoryNo(categoryVo.getNo());
		System.out.println(postVo);
		postService.addPost(postVo);
		return "redirect:/"+userVo.getId()+""; 
	}
	
}
