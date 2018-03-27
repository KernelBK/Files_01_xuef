<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>'()-xuef</title>
</head>
<body>
	<br><br>
	<center>
		购物车中有 <span class="emphasis"> ${cart.totalNum}</span> 本书<br>
		<s:if test="#session.cart == null">
			'()
		</s:if>
		<s:else>
			<table>
				<tr>
					<td>TITLE</td>
					<td>QUA</td>
					<td>OPE</td>
				</tr>
				<s:iterator value="#session.seeCart">
					<tr>
						<td><s:property value="book.title"/></td>
						<td><s:property value="bookNum"/></td>
						<td><a href="book-deleteRecord.action?id=${book.id}">删除</a></td>
					</tr>
				</s:iterator>
			</table>
		</s:else>
		<br><br>
		<a href="book-deleteAll.action">批量删除</a>
		<a href="book-settle.action">结算</a>
		<a href="book-getBooks.action?pageNo=${param.pageNo}
					&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">继续购物</a><br>
	</center>
	
</body>
</html>