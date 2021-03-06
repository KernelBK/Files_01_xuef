package com.xuef2018.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.ShoppingCart;
import com.xuef2018.bookstore.domain.User;
import com.xuef2018.bookstore.service.BookService;
import com.xuef2018.bookstore.service.UserService;
import com.xuef2018.bookstore.utils.webutil.WebUtil;

public class UserServlet extends HttpServlet {
	private UserService userService = new UserService();
	
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
	// 登录验证
	protected void loginCheck(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + " " + password);
		User user = userService.getUser(username);
		System.out.println("user: " + user);
		//req.getRequestDispatcher("/WEB-INF/pages/settle.jsp").forward(req, resp);
	}
}
