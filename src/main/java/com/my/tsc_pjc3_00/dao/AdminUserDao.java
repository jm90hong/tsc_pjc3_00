package com.my.tsc_pjc3_00.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.tsc_pjc3_00.vo.AdminUser;

@Repository
public class AdminUserDao {

	
	@Autowired
	SqlSession s;
	
	
	public AdminUser findByIdAndPw(AdminUser o) {
		return s.selectOne("admin_user.findByIdAndPw",o);
	}
	
}
