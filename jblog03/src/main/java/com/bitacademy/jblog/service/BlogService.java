package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogRepository;
import com.bitacademy.jblog.vo.BlogVo;


@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
		
	public void joinBlogInsert(BlogVo blogVo) {
		blogRepository.insert(blogVo);
	}
	public void changeByTitleAndProfile(BlogVo blogVo) {
		blogRepository.update(blogVo);
	}
	
	public BlogVo findBlog(String id) {
		BlogVo blogVo2 = blogRepository.findBlog(id);
		return blogVo2;
	}


}
