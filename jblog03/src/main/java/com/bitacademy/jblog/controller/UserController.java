package com.bitacademy.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo) {
		return "user/join";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo , Model model) {
		return "user/join";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	} // 완

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
}
