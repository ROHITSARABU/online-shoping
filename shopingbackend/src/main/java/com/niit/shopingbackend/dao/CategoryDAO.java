package com.niit.shopingbackend.dao;

import java.util.List;

import com.niit.shopingbackend.dto.Category;

public interface CategoryDAO 
{

	List<Category> list();
	Category get(int id);
	
	
}
