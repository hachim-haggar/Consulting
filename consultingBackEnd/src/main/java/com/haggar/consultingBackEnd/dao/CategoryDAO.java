package com.haggar.consultingBackEnd.dao;

import java.util.List;

import com.haggar.consultingBackEnd.dto.Category;


public interface CategoryDAO {
	
	boolean add(Category category);
	
	List<Category> list();
	Category get(int id);

}
