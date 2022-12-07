package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<CategoryVo> categoryList(Long no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		return sqlSession.selectList("category.categoryList", map);
	}

}
