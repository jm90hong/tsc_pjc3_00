package com.my.tsc_pjc3_00.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.tsc_pjc3_00.service.ItemService;
import com.my.tsc_pjc3_00.vo.AdminUser;
import com.my.tsc_pjc3_00.vo.Item;
import com.my.tsc_pjc3_00.vo.User;


@Controller
public class ViewController {
	
	
	boolean isPass=true;
	
	
	String getView(HttpSession s, String jspName) {
		User me = (User) s.getAttribute("me");
		AdminUser admin = (AdminUser) s.getAttribute("admin");
		
		
		if(isPass) {
			return jspName;
		}
		
		
		
		if(admin != null) {
			return jspName;
		}else if(me != null){
			return jspName;
		}else {
			return "redirect:/";
		}
		
	}
	
	
	@Autowired
	ItemService itemService;
	
	
	
	@GetMapping("")
	public String login(
				HttpSession session
			) {
		User me = (User) session.getAttribute("me");
		
		
		return "login";
	}
	
	@GetMapping("add-user")
	public String addUser() {
		return "add-user";
		
	}
	
	
	@GetMapping("add-item")
	public String addItem(HttpSession session,Model model) {
		
		model.addAttribute("menu", "itemlist");
		
		return getView(session, "add-item");
	}
	
	
	
	@GetMapping("detail-item")
	public String detailItem(
				HttpSession session,
				Model model,
				@RequestParam(value="item_idx") int item_idx
			) {
		
		model.addAttribute("menu", "itemlist");
		
		
		Item item = itemService.findByItemIdx(item_idx);
		
		model.addAttribute("item", item);
		
		return getView(session, "detail-item");
	}
	
	
	@GetMapping("item-list")
	public String itemList(HttpSession session,Model model) {
		
		
		model.addAttribute("menu", "itemlist");
		
	
		return getView(session, "item-list");
		
	}
	
	

}
