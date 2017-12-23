package com.niit.shopingbackend.dao;

import com.niit.shopingbackend.dto.Address;
import com.niit.shopingbackend.dto.Cart;
import com.niit.shopingbackend.dto.User;

public interface UserDAO {
	// add an user
	boolean addUser(User user);

	// add an address
	boolean addAddress(Address address);

	// add a cart
	boolean addCart(Cart cart);
}
