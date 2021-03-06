<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br><br>
	<center>
		<c:if test="${!empty sessionScope.shopCart}">
			购物车一共：${sessionScope.shopCart.totalNum } 本书 <br><br>
			<table>
				<tr>
					<td>书名</td>
					<td>数量</td>
					<td>价格</td>
					<td></td>
				<tr>
				<c:forEach items="${sessionScope.shopCart.items}" var="item">
					<tr>
						<td>${item.book.title }</td>
						<td>${item.bookNum }</td>
						<td>${item.book.price}</td>
						<td><a href="lookoverAllBooksServlet?method=removeItem&id=
						${item.book.id }&pageNo=${param.pageNo}
	&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">删除</a></td>
					<tr>
				</c:forEach>
				<tr></tr>
				<tr>
					<td><a href="lookoverAllBooksServlet?method=removeAll&pageNo=${param.pageNo}
	&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">批量删除</a></td>
					<td>一共 ${sessionScope.shopCart.totalMoney}元</td>
					<td><a href="lookoverAllBooksServlet?method=settle">结算</a></td>
					<td><a href="lookoverAllBooksServlet?method=getBooks&pageNo=${param.pageNo}
	&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">继续购物</a></td>
				</tr>
			</table>
		</c:if>
	</center>
</body>
</html>