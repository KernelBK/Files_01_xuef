package com.xuef2018.bookstore.utils.webutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xuef2018.bookstore.domain.ShoppingCart;

public class WebUtil {
	/**
	 * 从session中获取 shopCart;
	 * 如果没有，创建一个。
	 * @param req
	 * @param resp
	 * @return
	 */
	public static ShoppingCart getShopCart(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		ShoppingCart shopCart = (ShoppingCart)session.getAttribute("shopCart");
		if(shopCart == null){
			shopCart = new ShoppingCart();
			session.setAttribute("shopCart", shopCart);
		}else{
			shopCart = (ShoppingCart)session.getAttribute("shopCart");
		}
		return shopCart;
	}
}
