package com.my.tsc_pjc3_00.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.tsc_pjc3_00.dao.UserDao;
import com.my.tsc_pjc3_00.vo.User;

@Service
public class UserService {

	
	@Autowired
	UserDao userDao;
	
	
	public int save(User user) {
		return userDao.save(user);
		
	}
	
	public User findById(String id) {
		
		return userDao.findById(id);
		
	}
	
	public User findByIdAndPw(User user) {
		return userDao.findByIdAndPw(user);
	}
	
	public User findByIdx (int user_idx) {
		return userDao.findByIdx(user_idx);
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public int delete(int user_idx) {
		
		return userDao.delete(user_idx);
	}
	
}
