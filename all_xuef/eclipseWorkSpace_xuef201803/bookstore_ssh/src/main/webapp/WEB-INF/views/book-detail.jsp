<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>'()-xuef</title>
<link rel="stylesheet" type="text/css" href="styles/basic.css" />
</head>
<body>
	<div class="book-detail">
		<center>
			书名: ${book.title }<br><br>
			作者: ${book.author }<br><br>
			价格: ${book.price }<br><br>
			出版日期: ${book.publishingdate }<br><br>
			销量: ${book.salesamount }<br><br>
			剩餘: ${book.storenumber }<br><br>
			評論: ${book.text }<br><br>
			<a href="book-getBooks.action?pageNo=${param.pageNo}
					&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">继续购物</a><br>
		</center>
	</div>
</body>
</html>