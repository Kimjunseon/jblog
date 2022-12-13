package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.UserRepository;
import com.bitacademy.jblog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void join(UserVo userVo) {
		userRepository.insert(userVo);
	}

	public UserVo findUser(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}

	public UserVo findByname(String id) {
		UserVo userVo = userRepository.findName(id);
		return userVo;
	}

}
