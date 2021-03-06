package com.xuef2018.bookstore.domain.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.xuef2018.bookstore.domain.Book;
/**
 * 购物车
 * @author moveb
 *
 */
public class ShoppingCart {
	// book_id + ShoppingCartItem
	private Map<Integer, ShoppingCartItem> shopCart = 
								new HashMap<Integer, ShoppingCartItem>();
			
	public boolean hasBook(Integer id){
		return shopCart.containsKey(id);
	}
	public void addBook(Book book){
		ShoppingCartItem shoppingCartItem = shopCart.get(book.getId());
		
		if(shoppingCartItem != null){
			shoppingCartItem.increBookNum();
		}else{
			shoppingCartItem = new ShoppingCartItem(book);
			shopCart.put(book.getId(), shoppingCartItem);
		}
	}
	/**
	 * 购物车中 图书总数
	 * @return
	 */
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

	public void clear(){
		shopCart.clear();
	}
	/**
	 * 根据book id 从购物车删除该条记录
	 * @param id
	 */
	public void removeItem(int id){
		shopCart.remove(id);
	}
	public void updateItemNum(int id, int bookNum){
		ShoppingCartItem shoppingCartItem = shopCart.get(id);
		if(shoppingCartItem != null) shoppingCartItem.setBookNum(bookNum);
	}
}
