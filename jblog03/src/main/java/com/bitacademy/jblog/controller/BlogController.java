package com.bitacademy.jblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.vo.BlogVo;

@Controller
/**
 * 
 * id:(?!assets)  <- assets이 아닌 .* <- 모든 문자} assets이 아닌 모든 문자는 해당 맵핑으로 이동
 * 
 */
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@RequestMapping({"", "/{pathNo1}", "/{pathNo1}/{pathNo2}"})
	public String index(
		@PathVariable("id") String id,
		//Optional<> null값이 생성되지 않음
		@PathVariable("pathNo1") Optional<Long> pathNo1,
		@PathVariable("pathNo2") Optional<Long> pathNo2) {
		Long categoryNo = 0L;
		Long postNo = 0L;
		
		if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
		} else if (pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		}
		
		return "blog/index";
	}
	
	@RequestMapping(value={"/admin","/admin/basic"}, method=RequestMethod.GET)
	public String adminBasic(@PathVariable("id") String id) {
		return "blog/admin-basic";
		
	}
	
	@RequestMapping(value={"/admin","/admin/basic"}, method=RequestMethod.POST)
	public String adminBasic(@ModelAttribute BlogVo blogVo, Model model) {
		blogService.changeByTitleAndProfile(blogVo);
		blogVo.setTitle(blogVo.getTitle());
		return "blog/index";
		
	}
	
	
	@RequestMapping(value="/admin/write", method=RequestMethod.GET)
	public String write() {
		return "blog/admin-write";
		
	}
	
	@RequestMapping(value="/admin/category", method=RequestMethod.GET)
	public String login() {
		return "blog/admin-category";
		
	}
	
}
