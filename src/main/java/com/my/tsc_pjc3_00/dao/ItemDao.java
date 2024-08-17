package com.my.tsc_pjc3_00.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.tsc_pjc3_00.vo.Item;

@Repository
public class ItemDao {
	
	
	@Autowired
	SqlSession s;
	
	
	public int findBySearchCount(Item item) {
		return s.selectOne("item.findBySearchCount",item);
	}
	
	
	public List<Item> findBySearch(Item item) {
		return s.selectList("item.findBySearch",item);
	}
	
	
	public Item findByItemIdx(int itemIdx) {
		return s.selectOne("item.findByItemIdx",itemIdx);
	}
	
	public int findCount() {
		return s.selectOne("item.findCount");
	}
	
	public List<Item> findPart(HashMap<String, Integer> map) {
		return s.selectList("item.findPart",map);
	}
	
	
	public List<Item> findAll() {
		return s.selectList("item.findAll");
	}
	
	public int save(Item item) {
		return s.insert("item.save",item);
	}
	
	
	
}
