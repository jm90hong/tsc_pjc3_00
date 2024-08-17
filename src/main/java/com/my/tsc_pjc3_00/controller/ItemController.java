package com.my.tsc_pjc3_00.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.tsc_pjc3_00.service.ItemService;
import com.my.tsc_pjc3_00.vo.AdminUser;
import com.my.tsc_pjc3_00.vo.Item;
import com.my.tsc_pjc3_00.vo.User;

@RestController
@RequestMapping(value="item")
public class ItemController {

	
	@Autowired
	ItemService itemService;
	
	
	@GetMapping("findBySearchCount")
	public int findBySearchCount(
				@RequestParam(value="type",defaultValue = "") String item_type,
				@RequestParam(value="word",defaultValue = "") String word
			) {
		
		Item i = new Item();
		i.setItem_type(item_type);
		i.setItem_sch_word(word);
		
		int count = itemService.findBySearchCount(i);
		
		return count;
	}
	
	
	@GetMapping("findBySearch")
	public List<Item> findBySearch(
				@RequestParam(value="type",defaultValue = "") String item_type,
				@RequestParam(value="word",defaultValue = "") String word,
				@RequestParam(value="start") int start,
				@RequestParam(value="count") int count
				
			) {
		
		
		
		Item i = new Item();
		i.setItem_type(item_type);
		i.setItem_sch_word(word);
		i.setStart(start);
		i.setCount(count);
		
		List<Item> list = itemService.findBySearch(i);
		
		return list;
	}
	
	
	@GetMapping("count")
	public int count() {
		
		return itemService.findCount();
	}
	
	
	
	@GetMapping("all")
	public List<Item> all(
			@RequestParam(value="start") int start,
			@RequestParam(value="count") int count
			) {
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("count", count);
		
		
		
		List<Item> all = itemService.findPart(map);
		
		return all;
	}
	
	
	
	@PostMapping("save")
	public String save(
				@RequestParam(value="item_name") String item_name,
				@RequestParam(value="item_code") String item_code,
				@RequestParam(value="item_img") String item_img,
				@RequestParam(value="item_type") String item_type,
				@RequestParam(value="item_process") String item_process,
				@RequestParam(value="item_content") String item_content,
				HttpSession s
			) {
		
		
		AdminUser admin = (AdminUser) s.getAttribute("admin");
		User user = (User) s.getAttribute("me");
		
		
		
		try {
			s.getId();
		}catch(Exception e) {
			return "no-user";
		}
		
		
		
		
		int user_idx=0;
		
		if(admin != null) {
			user_idx=0;
		}
		
		if(user != null) {
			user_idx=user.getUser_idx();
		}
		
		
		
		Item item = new Item();
		item.setItem_name(item_name);
		item.setItem_img(item_img);
		item.setItem_type(item_type);
		item.setItem_process(item_process);
		item.setItem_code(item_code);
		item.setItem_content(item_content);
		item.setUser_idx(user_idx);
		
		
		itemService.save(item);
		
		return "ok";
	}
	
	
}
