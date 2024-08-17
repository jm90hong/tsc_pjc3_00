package com.my.tsc_pjc3_00.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.tsc_pjc3_00.dao.ItemDao;
import com.my.tsc_pjc3_00.vo.Item;

@Service
public class ItemService {
	
	
	@Autowired
	ItemDao itemDao;
	
	
	
	
	public int findBySearchCount(Item item) {
		return itemDao.findBySearchCount(item);
	}
	
	public List<Item> findBySearch(Item item) {
		return itemDao.findBySearch(item);
	}
	
	public Item findByItemIdx(int itemIdx) {
		return itemDao.findByItemIdx(itemIdx);
	}

	public int findCount() {
		return itemDao.findCount();
	}
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}
	
	public List<Item> findPart(HashMap<String, Integer> map) {
		return itemDao.findPart(map);
	}
	
	public int save(Item item) {
		return itemDao.save(item);
	}
	
}
