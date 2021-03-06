package com.xuef2018.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.ShoppingCart;
import com.xuef2018.bookstore.service.BookService;
import com.xuef2018.bookstore.utils.webutil.WebUtil;

public class LookoverAllBooksServlet extends HttpServlet {
	private BookService bookService = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 根据 method 参数，调用相应的方法
		String methodName = req.getParameter("method");
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//getBooks(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	// 结账
	protected void settle(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/settle.jsp").forward(req, resp);
	}
	
	// 删除购物车中的 一条记录
	protected void removeItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		ShoppingCart shopCart = WebUtil.getShopCart(req, resp);
		shopCart.removeItem(id);
		req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
	}
	
	protected void removeAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ShoppingCart shopCart = WebUtil.getShopCart(req, resp);
		shopCart.clear();
		req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
	}
	
	protected void lookCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
	}
	protected void add2Cart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		ShoppingCart shopCart = WebUtil.getShopCart(req, resp);
		
		Book bookAdded = bookService.getBookDetail(id);
		shopCart.addBook(bookAdded);
		System.out.println("有多少本： " + shopCart.getTotalNum());
		req.setAttribute("bookAdded", bookAdded);
		getBooks(req, resp);
	}
	protected void getBookDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取书的 id
		String bookIdStr = req.getParameter("id");
		int id = -1;
		try{
			id = Integer.parseInt(bookIdStr);
		}catch(NumberFormatException e){}
		// 如果 id = -1, 不进行查询
		// 如果 book 为空, 重定向至错误提示页面——该书不存在
		Book book = bookService.getBookDetail(id);
		req.setAttribute("book", book);
		System.out.println("book: " + book);
		req.getRequestDispatcher("/WEB-INF/pages/bookDetail.jsp").forward(req, resp);
		
	}
	protected void getBooks(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String minPriceStr = req.getParameter("minPrice");
		String maxPriceStr = req.getParameter("maxPrice");
		String pageNoStr = req.getParameter("pageNo");
		int pageNo = 1;
		float minPrice = 0, maxPrice = Integer.MAX_VALUE;
		if(minPriceStr != null && !minPriceStr.equals(""))
			minPrice = Float.parseFloat(minPriceStr);
		if(maxPriceStr != null && !maxPriceStr.equals(""))
			maxPrice = Float.parseFloat(maxPriceStr);
		if(pageNoStr != null)
			pageNo = Integer.parseInt(pageNoStr);
		
		System.out.println(minPrice + " " + maxPrice + " " + pageNo);
		
		Page<Book> page = bookService.getPage(new CriteriaBook(minPrice, maxPrice, pageNo));
		//System.out.println("page..." + page);
		req.setAttribute("allBooks", page);
		req.getRequestDispatcher("/WEB-INF/pages/allBooks.jsp").forward(req, resp);
	}
}
