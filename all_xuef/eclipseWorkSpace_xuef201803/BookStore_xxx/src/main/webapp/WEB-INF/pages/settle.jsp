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
			购物车一共：${sessionScope.shopCart.totalNum } 本书 <br>
			一共：${sessionScope.shopCart.totalMoney } 元<br><br>
		</c:if>
		<form action="userServlet?method=loginCheck"
				method="POST">
			<input type="text" name="username" /><br><br>
			<input type="password" name="password" /><br><br>
			<input type="submit" value="login" />
		</form>
	</center>
</body>
</html>