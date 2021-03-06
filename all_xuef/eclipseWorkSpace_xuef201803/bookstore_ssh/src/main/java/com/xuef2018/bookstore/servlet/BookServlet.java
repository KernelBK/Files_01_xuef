package com.xuef2018.bookstore.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.User;
import com.xuef2018.bookstore.domain.web.ShoppingCart;
import com.xuef2018.bookstore.domain.web.ShoppingCartItem;
import com.xuef2018.bookstore.service.BookService;

public class BookServlet extends ActionSupport implements RequestAware, 
										SessionAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	private int id; // book id
	public void setId(int id) {
		this.id = id;
	}
	private javax.servlet.http.HttpServletResponse response;  
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
	private String username;
	public void setUsername(String username) {
		this.username = username;
	}
	// 检查用户名
	public void logincheck(){
		response.setCharacterEncoding("UTF-8");
		try {
			System.out.println(username);
			String result = "";
			if(bookService.existName(username)){
				result = "<font color='blue'>用户名可用<font>";
			}else{
				result = "<font color='red'>!用户名不存在!<font>";
			}
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String pwd;
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	// 用户名密码是否匹配
	public void logincheckpwd(){
		response.setCharacterEncoding("UTF-8");
		try {
			System.out.println(username + "---" + pwd);
			//User user = (User) sessionMap.get("user");
			String result = "";
			if(bookService.checkPwd(username, pwd)){
				result = "<font color='blue'>密码正确<font>";
				User user = new User();
				user.setName(username);
				user.setAccountid(Integer.parseInt(pwd));
				sessionMap.put("user", user);
			}else{
				result = "<font color='red'>!密码错误!<font>";
			}
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String login2pay(){
		// 1. 更新库存： 销量和存货 mybooks
		// 2. 更新账户余额 account
		// 3. 插入一条 trade 记录
		// 4. 插入若干条 tradeitem
		// 5. 清空购物车
		ShoppingCart cart = (ShoppingCart) sessionMap.get("cart");
		int accountid = ((User)sessionMap.get("user")).getAccountid();
		bookService.pay(username, cart);
		sessionMap.clear();
		return "paysucc";
	}
	// 结账
	public String settle(){
		return "settle";
	}
	// 清空购物车
	public String deleteAll(){
		ShoppingCart cart = (ShoppingCart) sessionMap.get("cart");
		cart.clear();
		return "cart";
	}
	// 从购物车删除某条记录
	public String deleteRecord(){
		ShoppingCart cart = (ShoppingCart) sessionMap.get("cart");
		cart.removeItem(id);
		return "cart";
	}
	// 查看购物车
	public String seeCart(){
		ShoppingCart cart = (ShoppingCart) sessionMap.get("cart");
		for(ShoppingCartItem sc:cart.getItems()){
			System.out.println(sc.getBook().getTitle() + "---" + sc.getBookNum());
		}
		sessionMap.put("seeCart", cart.getItems());
		return "cart";
	}
	// 加入购物车
	public String add2cart(){
		// 1. 从session中取出购物车
		ShoppingCart cart = (ShoppingCart) sessionMap.get("cart");
		// 2. 如果购物车为null，new 一个购物车
		if(cart == null){
			cart = new ShoppingCart();
		}
		// 3. 把书加入购物车
		Book book = bookService.getBook(id);
		cart.addBook(book);
		requestMap.put("newBook", book);
		// 4. 把购物车加入session中
		sessionMap.put("allbooks", getBooks());
		sessionMap.put("cart", cart);
		return "books-list";
	}
	// 查看图书
	public String detail(){
		requestMap.put("book", bookService.getBook(id));
		return "book-detail";
	}
	private String pageNo;
	private String minPrice;
	private String maxPrice;
	private int page_no = 1;
	private float min_price = 0;
	private float max_price = Integer.MAX_VALUE;
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	private void checkAndInit(){
		if(pageNo != null && !"".equals(pageNo)){
			page_no = Integer.parseInt(pageNo);
		}
		if(minPrice != null && !"".equals(minPrice)){
			min_price = Float.parseFloat(minPrice);
		}
		if(maxPrice != null && !"".equals(maxPrice)){
			max_price = Float.parseFloat(maxPrice);
		}
	}
	public String getBooks(){
		System.out.println(requestMap);
		checkAndInit();
		CriteriaBook criteriaBook = new CriteriaBook(min_price, max_price, page_no);
		Page<Book> page = bookService.getPage(criteriaBook);
		System.out.println(page);
		requestMap.put("allbooks", page);
		return "books-list";
	}
	private Map<String, Object> requestMap;
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}
	private Map<String, Object> sessionMap;
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}

}
