package com.xuef2018.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//System.out.println(username);
		// 如果用户名 密码正确，转发至 LoginSuccessServlet
		if("xuef".equals(username) && "121314".equals(password)){
			//System.out.println("login suc");
			req.getRequestDispatcher("loginSuccessServlet").forward(req, resp);
		}else{
			
		}
//		req.getRequestDispatcher("/someServlet").forward(req, resp);
		//redirect
//		resp.sendRedirect("someServlet");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
