package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean insert(CategoryVo categoryVo) {
		int count = sqlSession.insert("category.insert", categoryVo);
		return count == 1;
		
	}

	public List<CategoryVo> categoryList(String string) {
		return sqlSession.selectList("category.categoryList", string);
	}

	public Boolean delete(String title) {
		return sqlSession.selectOne("category.delete", title);
		
	}

	public CategoryVo findTitle(String title) {
		CategoryVo vo = sqlSession.selectOne("category.findTitle", title);
		return vo;
	}

	public Boolean insertCategory(CategoryVo categoryVo) {
		int count = sqlSession.insert("category.insertCategory", categoryVo);
		return count == 1;
	}
	
	public List<CategoryVo> findNo(String id) {
		return sqlSession.selectList("category.findNo", id);
	}

	public List<CategoryVo> findCategoryList(String id) {
		return sqlSession.selectList("category.findList", id);
	}
	

}
