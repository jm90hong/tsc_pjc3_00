package com.my.tsc_pjc3_00.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.tsc_pjc3_00.service.UserService;
import com.my.tsc_pjc3_00.vo.User;



@RestController
@RequestMapping(value="user")
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	@PostMapping("logout")
	public String logout(HttpSession s) {
		
		s.invalidate();
		
		return  "ok";
	}
	
	
	@GetMapping("findById")
	public User findById(@RequestParam(value="id") String id) {

		User user = userService.findById(id);
		
		return user;
	}
	
	
	
	
	@PostMapping("save")
	public String save(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw
			) {
		
		
		User exU = userService.findById(id);
		if(exU != null) {
			return "email";
		}
		
		
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		
		userService.save(user);
		
		
		return MyHttp.OK;
	}
	
	
	@PostMapping("login")
	public User login(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				HttpSession session
			) {
		
		
		User user  =  new User();
		user.setId(id);
		user.setPw(pw);
		
		User result = userService.findByIdAndPw(user);
		
		
		if(result != null) {
			//회원이 존재함.
			session.setAttribute("me", result);
		}
		
		return result;
	}
	
	
}
