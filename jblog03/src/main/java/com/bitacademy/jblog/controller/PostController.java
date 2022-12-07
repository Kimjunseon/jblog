package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets).*}/admin/write")
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("")
	public String write() {
		return "blog/admin-write";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(PostVo postVo, UserVo userVo) {
		postService.addPost(postVo);
		return "redirect:/"+userVo.getId()+"";
	}
	
}
