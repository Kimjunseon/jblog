package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.BlogVo;

@Repository
public class BlogRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean insert(BlogVo vo) {
		int count = sqlSession.insert("blog.insert", vo);
		return count == 1;
	}

	public Boolean update(BlogVo blogvo) {
		int count = sqlSession.update("blog.update", blogvo);
		return count == 1;
	}
	
	
}
