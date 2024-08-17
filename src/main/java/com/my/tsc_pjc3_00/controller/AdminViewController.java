package com.my.tsc_pjc3_00.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class AdminViewController {

	
	@GetMapping("login")
	public String login() {
		
		
		return "admin/admin-login";
	}
	
}
