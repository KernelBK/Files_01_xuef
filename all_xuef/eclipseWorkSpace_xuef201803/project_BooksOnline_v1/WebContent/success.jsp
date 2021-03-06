<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="com.xuef2018.bean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= request.getAttribute("user_name") %>'s BookOnline</title>
</head>
<body>
	Welcome <%= request.getAttribute("user_name") %><br><br>
	
	<% 
		List<Book> books = (List<Book>)request.getAttribute("all_books");
	%>
	<table>
		<tr>
			<td>book_name</td>
			<td>last updated</td>
			<td>stars</td>
		</tr>
		<%
			for (Book book: books){
		%>
		<tr>
			<td>
				<a href="openBookServlet?id=<%= book.getBook_id() %>"><%= book.getBook_name() %></a>
			</td>
			<td>
				<%= book.getLast_modified_time() %>
			</td>
			<td>
				<%= book.getStars() %>
			</td>
		</tr>
		<% 
			}
		%>
	
	</table>
</body>
</html>