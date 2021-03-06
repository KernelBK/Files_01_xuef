package com.xuef2018.bookstore.domain.web;

import com.xuef2018.bookstore.domain.Book;

/**
 * ���ﳵ�еĵ�����¼
 * @author moveb
 *
 */
public class ShoppingCartItem {
	private Book book;
	private int bookNum;
	
	public ShoppingCartItem(Book book){
		this.book = book;
		bookNum = 1;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	// ���㵥����¼ �� Ǯ��
	public float getItemMoney(){
		return book.getPrice() * bookNum;
	}
	public void increBookNum(){
		bookNum += 1;
	}
}
