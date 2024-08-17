package com.my.tsc_pjc3_00.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.tsc_pjc3_00.dao.AdminUserDao;
import com.my.tsc_pjc3_00.vo.AdminUser;

@Service
public class AdminUserService {

	
	@Autowired
	AdminUserDao adminUserDao;
	
	
	public AdminUser findByIdAndPw(AdminUser o) {
		return adminUserDao.findByIdAndPw(o);
	}
	
	
	
	
}
