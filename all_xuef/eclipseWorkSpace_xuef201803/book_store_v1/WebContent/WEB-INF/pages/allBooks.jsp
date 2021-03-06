<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.xuef2018.bookstore.domain.Book"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookshop</title>
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		// 实现带条件的查询
		$('a').click(function(){
			//var hiddenval = $(":hidden").serialize()
			var href = this.href + concatHref()
			//alert("href: " + href)
			window.location.href = href
			return false
		})
		// 拼接 查询条件字符串
		var concatHref = function(){
			// 获取隐藏域中的 查询条件
			var minp = $(" input[ type='hidden'][name='minPrice']").val()
			var maxp = $(" input[ type='hidden'][ name='maxPrice']").val()
			var href = ''
			// 拼 跳转字符串
			if(minp != '')
				href = href + '&minPrice=' + minp
			if(maxp != '')
				href = href + '&maxPrice=' + maxp
			return href
		};
		$("#pageNoForTurn").change(function(){
			$pageNoForT = $(this).val()
			//alert("turn2 " + $pageNoForT)
			// 校验输入页码
			// 保证全数字
			var reg = /^\d+$/
			if(!reg.test($pageNoForT)){
				$(this).val("") //清空输入
				alert("页码必须为数值")
				return
			}
			var pageInt = parseInt($pageNoForT)
			if(pageInt < 1 || pageInt > parseInt("${allBooks.totalPageNumber}")){
				$(this).val("")
				alert("页码不合法")
				return
			}
			var href = concatHref()
			href = href + "&pageNo=" + $pageNoForT 
			var href = "lookoverAllBooksServlet?method=getBooks" + href
			//alert(href)
			window.location.href = href
		})
	})

</script>
</head>
<body>
	<br><br><br>
	<input type="hidden" value="${param.minPrice}" name="minPrice" />
	<input type="hidden" value="${param.maxPrice}" name="maxPrice" />
	<center>
		<form action="lookoverAllBooksServlet?method=getBooks" method="POST">
		Price: <input type="text" size="2" name="minPrice" />---
		<input type="text" size="2" name="maxPrice" /> 
		<input type="submit" value="查询" />
		</form>
		<br><br>
		<table>
			<c:forEach items="${allBooks.list}" var="book">
				<tr>
					<td><a href="lookoverAllBooksServlet?method=getBookDetail&pageNo=${allBooks.pageNo}
					&id=${book.id}">
					${ book.title }</a>--
					${book.author}
					</td>
					<td>${ book.price }</td>
					<td> <a href="lookoverAllBooksServlet?method=add2Cart&pageNo=${allBooks.pageNo}
					&id=${book.id}">加入购物车</a></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		共 ${allBooks.totalPageNumber }页 &nbsp;
		当前 第${allBooks.pageNo}页 &nbsp;
		<c:if test="${allBooks.hasPre}">
			<a href="lookoverAllBooksServlet?method=getBooks&pageNo=1">首页</a>
			 &nbsp;
			<a href="lookoverAllBooksServlet?method=getBooks&pageNo=${allBooks.prePage}">上一页</a>
		</c:if>
		
		<c:if test="${allBooks.hasNext}">
			<a href="lookoverAllBooksServlet
			?method=getBooks&pageNo=${allBooks.nextPage}">下一页</a>
			 &nbsp;
			<a href="lookoverAllBooksServlet?method=getBooks&pageNo=${allBooks.totalPageNumber}">末页</a>
		</c:if>
		&nbsp;&nbsp;跳到&nbsp;<input id="pageNoForTurn" type="text" size="1" />&nbsp;页
		<br><br>
		<c:if test="${!empty sessionScope.shopCart}">
			<strong style="color:red">${bookAdded.title} </strong>加入购物车<br>
			您的购物车中有 ${sessionScope.shopCart.totalNum} 本书 <a href="lookoverAllBooksServlet?method=lookCart
			&pageNo=${allBooks.pageNo}">查看购物车</a>
		</c:if>
	</center>
</body>
</html>