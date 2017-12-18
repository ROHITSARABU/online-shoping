package com.niit.shopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shopingbackend.dao.CategoryDAO;
import com.niit.shopingbackend.dto.Category;



@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category

		category.setId(1);
		category.setName("mobile");
		category.setDescription("this is moto g3 mobile");
		category.setImageURL("moto.jpg");

		categories.add(category);

		// second category

		category = new Category();

		category.setId(2);
		category.setName("car");
		category.setDescription("this is jaquar car");
		category.setImageURL("car.jpg");

		categories.add(category);
		
		
		//third category
		
		
		category = new Category();

		category.setId(3);
		category.setName("laptop");
		category.setDescription("this is hp laptop");
		category.setImageURL("lap.jpg");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		
		
		//enhanced for loop
		
		for(Category category : categories){
			
			if(category.getId()==id) return category;

			
		}
		return null;
	}
	

}
