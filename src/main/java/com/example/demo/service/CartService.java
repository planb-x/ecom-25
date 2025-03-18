package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	
	public Optional<Cart> getCartById(Long cardId) {
		return cartRepository.findById(cardId);
	}
	
	public Cart addProduct(Cart cart) {
		return cartRepository.save(cart);
	}

	public void removeProduct(Long cartId) {
		cartRepository.deleteById(cartId);
		
	}

	public Cart updateCart(Long cartId, Cart cart) {
		cart.setCartId(cartId);
		return cartRepository.save(cart);
		
	}
}
