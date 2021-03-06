package com.xuef2018.bookstore.domain.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.xuef2018.bookstore.domain.Book;

public class ShoppingCart {
	private Map<Integer, ShoppingCartItem> shopCart = 
								new HashMap<Integer, ShoppingCartItem>();
			
	public boolean hasBook(Integer id){
		return shopCart.containsKey(id);
	}
	public void addBook(Book book){
		ShoppingCartItem shoppingCartItem = shopCart.get(book.getId());
		// 如果购物车中已经有该书
		if(shoppingCartItem != null){
			shoppingCartItem.increBookNum();
		}else{
			shoppingCartItem = new ShoppingCartItem(book);
			shopCart.put(book.getId(), shoppingCartItem);
		}
	}
	// 计算购物车中 图书总数量
	public int getTotalNum(){
		int total = 0;
		for(ShoppingCartItem sci:getItems()){
			total += sci.getBookNum();
		}
		return total;
	}
	public Collection<ShoppingCartItem> getItems(){
		return shopCart.values();
	}
	// 计算购物车中图书 总金额
	public float getTotalMoney(){
		float totalMoney = 0f;
		for(ShoppingCartItem sci:getItems()){
			totalMoney += sci.getBook().getPrice() * sci.getBookNum();
		}
		return totalMoney;
	}
	public boolean isEmpty(){
		return shopCart.isEmpty();
	}
	// 清空购物车
	public void clear(){
		shopCart.clear();
	}
	public void removeItem(int id){
		shopCart.remove(id);
	}
	public void updateItemNum(int id, int bookNum){
		ShoppingCartItem shoppingCartItem = shopCart.get(id);
		if(shoppingCartItem != null) shoppingCartItem.setBookNum(bookNum);
	}
}
