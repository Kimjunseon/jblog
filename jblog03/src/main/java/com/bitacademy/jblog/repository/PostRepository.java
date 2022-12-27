package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;

@Repository
public class PostRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean insertPost(PostVo postVo) {
		int count = sqlSession.insert("post.insertPost", postVo);
		return count == 1;
	}

	public PostVo titleAndContents(PostVo postVo) {
		return sqlSession.selectOne("post.titleAndContents", postVo);
	}

	public List<PostVo> postList(Long no) {
		return sqlSession.selectList("post.postList", no);
		
	}

}
