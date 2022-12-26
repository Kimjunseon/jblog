package com.bitacademy.jblog.controller;  

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.FileUploadService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileUploadService fileuploadService;
	
	@RequestMapping({"", "/{pathNo1}", "/{pathNo1}/{pathNo2}"})
	public String index(
		BlogVo blogVo,
		UserVo userVo,
		PostVo postVo,
		Model model,
		@PathVariable("id") String id,
		//Optional<> null값이 생성되지 않음
		@PathVariable("pathNo1") Optional<Long> pathNo1,
		@PathVariable("pathNo2") Optional<Long> pathNo2) {
		CategoryVo categoryVo = categoryService.findCategoryFromNo(id);
		postVo.setNo(categoryVo.getNo());
		BlogVo blogVo2 = blogService.findBlog(userVo.getId());
		model.addAttribute("blogVo2", blogVo2);
		System.out.println("blog: " + blogVo2);
		model.addAttribute("getIndex", postService.findTitleAndContents(postVo));

		
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
	public String adminBasic(@PathVariable("id") String id, UserVo userVo, Model model) {
		BlogVo blogVo2 = blogService.findBlog(userVo.getId());
		return "blog/admin-basic";
		
	}
	
	@RequestMapping(value="/admin/update", method=RequestMethod.GET)
	public String changeTitleAndProfile(
			@PathVariable("id") String id) {
		return "blog/" + id;
	}
	
	@RequestMapping(value="/admin/update", method=RequestMethod.POST)
	public String changeTitleAndProfile(
			BlogVo blogVo,
			CategoryVo categoryVo,
			@RequestParam(value="file") MultipartFile multipartFile) {
		String url = fileuploadService.restore(multipartFile);
		blogVo.setProfile(url);
		blogService.changeByTitleAndProfile(blogVo);
		return "blog/index";
	}
	
}
