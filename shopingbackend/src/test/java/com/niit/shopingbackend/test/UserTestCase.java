package com.niit.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingbackend.dao.UserDAO;
import com.niit.shopingbackend.dto.Address;
import com.niit.shopingbackend.dto.Cart;
import com.niit.shopingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shopingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Hitman");
		user.setLastName("Rohit");
		user.setEmail("hitman@gmail.com");
		user.setContactNumber("8220279852");
		user.setRole("USER");
		user.setPassword("hitman");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("no 6, periyar ramasammy street guduvancheri");
		address.setAddressLineTwo("near ration shop");
		address.setCity("guduvancheri");
		address.setState("TamilNadu");
		address.setCountry("India");
		address.setPostalCode("603202");
		address.setBilling(true);

		// link the user with the address using user id
		address.setUserId(user.getId());

		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());

			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));

			// add a shipping address for this user

			address = new Address();
			address.setAddressLineOne("no 6, periyar ramasammy street guduvancheri");
			address.setAddressLineTwo("near ration shop");
			address.setCity("guduvancheri");
			address.setState("TamilNadu");
			address.setCountry("India");
			address.setPostalCode("603202");
			// set shipping to true
			address.setBilling(true);

			// link it with the user
			address.setUserId(user.getId());

			// add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
			
			

		}

	}

}
