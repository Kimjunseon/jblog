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

	public List<CategoryVo> getCategoryList(String string) {
		return categoryRepository.categoryList(string);
	}

	public void deleteCategory(String title) {
		categoryRepository.delete(title);
		
	}

	public CategoryVo findCategoryNo(String title) {
		CategoryVo categoryVo = categoryRepository.findTitle(title);
		return categoryVo;
	}

	public void joinCategoryInsert(CategoryVo categoryVo) {
		categoryRepository.insertCategory(categoryVo);
		
	}
	
	public List<CategoryVo> findCategoryFromNo(String id) {
		return categoryRepository.findNo(id);
	}

	public List<CategoryVo> findCategoryList(String id) {
		return categoryRepository.findCategoryList(id);
	}


}
