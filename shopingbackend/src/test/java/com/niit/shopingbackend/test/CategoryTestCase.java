package com.niit.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingbackend.dao.CategoryDAO;
import com.niit.shopingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("car"); category.setDescription("this is jaquar car!!");
	 * category.setImageURL("car.jpg");
	 * 
	 * assertEquals("successfully add a category inside the table"
	 * ,true,categoryDAO.add(category));
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(2); assertEquals(
	 * "successfully fetched a single category inside the table"
	 * ,"mobile",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(2);
	 * 
	 * category.setName("moto mobile");
	 * 
	 * assertEquals("successfully updated a single category in the table", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(2); assertEquals(
	 * "successfully deleted a single category in the table", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * 
	 * assertEquals("successfully fetched the list of categories from the table"
	 * ,2, categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		category = new Category();

		category.setName("car");
		category.setDescription("this is jaquar car!!");
		category.setImageURL("car.jpg");

		assertEquals("successfully add a category inside the table", true, categoryDAO.add(category));

		category = new Category();

		category.setName("mobile");
		category.setDescription("this is hp laptop!!");
		category.setImageURL("moto.jpg");

		assertEquals("successfully add a category inside the table", true, categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(2);

		category.setName("moto mobile");

		assertEquals("successfully updated a single category in the table", true, categoryDAO.update(category));

		// delete the category
		assertEquals("successfully deleted a single category in the table", true, categoryDAO.delete(category));

		// fetching the list
		assertEquals("successfully fetched the list of categories from the table", 1, categoryDAO.list().size());

	}

}
