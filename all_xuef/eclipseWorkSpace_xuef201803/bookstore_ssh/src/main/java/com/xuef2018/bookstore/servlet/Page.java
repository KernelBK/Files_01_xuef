package com.xuef2018.bookstore.servlet;

import java.util.List;

public class Page<T> {
	// 当前页
	private int pageNo;
	private List<T> list;
	//每页显示条数
	private int pageSize = 3;
	//图书总数
	private int totalItemNumber;
	
	// 总页数
	public int getTotalPageNumber(){
		int totalPageNumber = totalItemNumber/pageSize;
		if(totalItemNumber % pageSize !=0)
			totalPageNumber += 1;
		
		return totalPageNumber;
	}
	public boolean getHasNext(){
		if(getPageNo() < getTotalPageNumber())
			return true;
		return false;
	}
	public boolean getHasPre(){
		if(getPageNo() > 1)
			return true;
		return false;
	}
	public int getPrePage(){
		if(getHasPre()) return getPageNo()-1;
		return getPageNo();
	}
	public int getNextPage(){
		if(getHasNext()) return getPageNo() + 1;
		return getPageNo();
	}
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	//
	public int getPageNo() {
		if(pageNo < 0) pageNo = 1;
		if(pageNo > getTotalPageNumber()) 
			pageNo = getTotalPageNumber();
		return pageNo;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalItemNumber() {
		return totalItemNumber;
	}
	public void setTotalItemNumber(int totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", list=" + list + ", pageSize="
				+ pageSize + ", totalItemNumber=" + totalItemNumber + "]";
	}
	
}
