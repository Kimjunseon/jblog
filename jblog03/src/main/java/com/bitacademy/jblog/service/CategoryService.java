package com.bitacademy.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryRepository;
import com.bitacademy.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addCategory(CategoryVo categoryVo) {
		categoryRepository.insert(categoryVo);
		
	}

	public Map<String, Object> getCategoryList(Long no) {
		List<CategoryVo> list = categoryRepository.categoryList(no);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}

}
