package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody Cart cart) {
        cartService.addProduct(cart);
        return ResponseEntity.ok("Item added to cart.");
    }
    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable Long cartId) {
        cartService.removeProduct(cartId);
        return ResponseEntity.ok("Item removed from cart.");
    }
    @PutMapping("/update/{cartId}")
    public ResponseEntity<String> updateCartItem(@PathVariable Long cartId, @RequestBody Cart cart) {
        cartService.updateCart(cartId, cart);
        return ResponseEntity.ok("Cart item updated.");
    
	}

}
