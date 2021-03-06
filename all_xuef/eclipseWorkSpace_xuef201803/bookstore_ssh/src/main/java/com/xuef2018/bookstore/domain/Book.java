package com.xuef2018.bookstore.domain;

import java.util.Date;

public class Book {
	private int id;
	private String author;
	private String title;
	private float price;
	private Date publishingdate;
	private int salesamount;
	private int storenumber;
	private String text;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getSalesamount() {
		return salesamount;
	}
	public void setSalesamount(int salesamount) {
		this.salesamount = salesamount;
	}
	public int getStorenumber() {
		return storenumber;
	}
	public void setStorenumber(int storenumber) {
		this.storenumber = storenumber;
	}
	public Date getPublishingdate() {
		return publishingdate;
	}
	public void setPublishingdate(Date publishingdate) {
		this.publishingdate = publishingdate;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title
				+ ", price=" + price + ", publishingdate=" + publishingdate
				+ ", salesamount=" + salesamount + ", storenumber="
				+ storenumber + "]";
	}
	
}
