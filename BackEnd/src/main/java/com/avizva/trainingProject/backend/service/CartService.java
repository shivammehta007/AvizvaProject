package com.avizva.trainingProject.backend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.avizva.trainingProject.backend.model.Product;

public interface CartService {
	public boolean addProductToCart(int productId , int productQuantity , HttpSession session);
	public boolean removeProductFromCart(int cartId);
	public boolean updateCartQuantity(int productId,int CartQuantity,String username);
	public Long priceCalculator(String username,Long ...discount);
	public int hasProduct(int productId);
	public List<Product> allProductInCart();
}