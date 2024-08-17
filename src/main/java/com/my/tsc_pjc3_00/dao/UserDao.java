package com.my.tsc_pjc3_00.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.tsc_pjc3_00.vo.User;


@Repository
public class UserDao {
	
	@Autowired
	SqlSession s;
	
	public int save(User user) {
		return s.insert("user.save",user);
		
	}
	
	public User findById(String id) {
		
		return s.selectOne("user.findById", id);
		
	}
	
	public User findByIdAndPw(User user) {
		return s.selectOne("user.findByIdAndPw", user);
	}
	
	public User findByIdx (int user_idx) {
		return s.selectOne("user.findByIdx", user_idx);
	}
	
	public List<User> findAll(){
		return s.selectList("user.findAll");
	}
	
	public int delete(int user_idx) {
		
		return s.delete("user.delete", user_idx);
	}
	

	

}
