<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.xuef2018.bookstore.domain.Book" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>'()-xuef</title>
<link rel="stylesheet" type="text/css" href="styles/basic.css" />
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
		if(pageInt < 1 || pageInt > parseInt("${allbooks.totalPageNumber}")){
			$(this).val("")
			alert("页码不合法")
			return
		}
		var href = concatHref()
		href = href + "&pageNo=" + $pageNoForT 
		var href = "book-getBooks?1=1" + href
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
		<s:if test="#session.cart != null">
			<a class="emphasis" href="book-seeCart.action?pageNo=${allbooks.pageNo}">查看购物车</a><br><br>
		</s:if>
		
		<form action="" method="POST">
		Price: <input type="text" size="2" name="minPrice" />---
		<input type="text" size="2" name="maxPrice" /> 
		<input type="submit" value="查询" />
		</form>
		<br><br>
		<s:if test="#request.allbooks == null">
			'()
		</s:if>
		<s:else>
			<table>
				<tr>
					<td>ID</td>
					<td>AUTHOR</td>
					<td>TITLE</td>
				</tr>
				<s:iterator value="#request.allbooks.list">
					<tr>
						<td>${id}</td>
						<td>${author}</td>
						<td><a href="book-detail?id=${id}&pageNo=${allbooks.pageNo}">${title}</a></td>
						<td><a href="book-add2cart.action?id=${id}&pageNo=${allbooks.pageNo}">加入购物车</a></td>
					</tr>
				</s:iterator>
			</table>
		</s:else>
		共 ${requestScope.allbooks.totalPageNumber} 页&nbsp;
		当前第  ${requestScope.allbooks.pageNo} 页 &nbsp;
		<s:if test="#request.allbooks.hasPre == true">
			<a href="book-getBooks.action?pageNo=1">首页</a>
			 &nbsp;
			<a href="book-getBooks.action?pageNo=${allbooks.prePage}">上一页</a>
		</s:if>
		
		<s:if test="#request.allbooks.hasNext == true">
			<a href="book-getBooks.action?pageNo=${allbooks.nextPage}">下一页</a>
			 &nbsp;
			<a href="book-getBooks.action?pageNo=${allbooks.totalPageNumber}">末页</a>
		</s:if>
		&nbsp;&nbsp;跳到&nbsp;<input id="pageNoForTurn" type="text" size="1" />&nbsp;页
		<br><br>
		<br><br>
		<s:if test="#request.book != null">
			您已将 <span class="emphasis"> ${newBook.title}</span> 加入购物车 <br>
		</s:if>
		购物车中有 <span class="emphasis"> ${cart.totalNum}</span> 本书<br>
	</center>
</body>
</html>