package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.PostRepository;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public void addPost(PostVo postVo) {
		postRepository.insertPost(postVo);
		
	}

	public PostVo findTitleAndContents(PostVo postVo) {
		return postRepository.titleAndContents(postVo);
	}

	public List<PostVo> getTitleAndDateList(Long no) {
		return postRepository.postList(no);
	}

}
