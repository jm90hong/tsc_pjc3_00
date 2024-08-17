package com.my.tsc_pjc3_00.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.tsc_pjc3_00.service.AdminUserService;
import com.my.tsc_pjc3_00.vo.AdminUser;

@Controller
@RequestMapping(value="api/au")
public class AdminUserController {

	
	
	
	@Autowired
	AdminUserService adminUserService;
	
	
	
	@GetMapping("login")
	@ResponseBody
	public AdminUser login(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				HttpSession session
			) {
		
		
		AdminUser au = new AdminUser();
		au.setId(id);
		au.setPw(pw);
		
		
		if(au != null) {
			session.setAttribute("admin", au);
		}
		
		return adminUserService.findByIdAndPw(au);
	}
	
	
	
}
