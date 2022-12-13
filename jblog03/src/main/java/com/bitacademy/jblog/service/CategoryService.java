package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryRepository;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.UserVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addCategory(CategoryVo categoryVo) {
		categoryRepository.insert(categoryVo);
		
	}

	public List<CategoryVo> getCategoryList() {
		return categoryRepository.categoryList();
	}

	public void deleteCategory(String title) {
		categoryRepository.delete(title);
		
	}

	public CategoryVo findCategoryNo(String title) {
		CategoryVo categoryVo = categoryRepository.findNo(title);
		return categoryVo;
	}



}
