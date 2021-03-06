<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>'(() ())</title>
<%
	pageContext.setAttribute("emp_path", request.getContextPath());
%>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${emp_path}/css/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${emp_path}/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<!-- 标题 -->
		<div class="row">
		  	<div class="col-md-12"><h1>EmpsAdmS</h1></div>
		</div>
		
		<!-- 标题一般操作 -->
		<div class="row">
		  	<div class="col-md-4 col-md-offset-10"> <!-- col-md-offset-8 -->
		  		<button type="button" class="btn btn-primary"> 
		  			<span class="glyphicon glyphicon-plus"></span> Add </button>
		  		<button type="button" class="btn btn-danger"> 
		  			<span class="glyphicon glyphicon-remove"></span> Delete </button>
			</div>
		</div>
		<div class="row">
		  	<div class="col-md-12"><h4>******</h4></div>
		</div>
		<!-- 数据展示 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-hover">
					<tr class="info">
						<th>工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>岗位</th>
						<th>部门</th>
						<th>地点</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="emp">
						<tr>
							<th>${emp.eNo}</th>
							<th>${emp.eName}</th>
							<th>${emp.eGender=='m'?'男':'女'}</th>
							<th>${emp.eJob}</th>
							<th>${emp.department.dName}</th>
							<th>${emp.department.dLocation}</th>
							<th>
								<button type="button" class="btn btn-primary btn-sm"> 
		  						<span class="glyphicon glyphicon-pencil"></span> Edit </button>
		  						<button type="button" class="btn btn-danger btn-sm"> 
		  						<span class="glyphicon glyphicon-remove"></span> DeL </button>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<!-- 分页信息 -->
		<div class="row">
			<div class="col-md-6">
				当前第${pageInfo.pageNum}页 共${pageInfo.pages}页 ${pageInfo.total}条记录
			</div>
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<c:if test="${pageInfo.pageNum == 1}">
				  		<li class="disabled"><a href="${emp_path}/emps?pageNo=1">首页</a></li>
				  		<li class="disabled">
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				    </c:if>
				    
				    <c:if test="${pageInfo.pageNum != 1}">
				    	<li><a href="${emp_path}/emps?pageNo=1">首页</a></li>
				  		<li>
					      <a href="${emp_path}/emps?pageNo=${pageInfo.pageNum-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				    </c:if>
				  	
				    
				    <c:forEach items="${pageInfo.navigatepageNums}" var="pn">
				    	<c:if test="${pageInfo.pageNum == pn}">
				    		<li class="active"><a href="#">${pn}</a></li>
				    	</c:if>
				    	<c:if test="${pageInfo.pageNum != pn}">
				    		<li><a href="${emp_path}/emps?pageNo=${pn}">${pn}</a></li>
				    	</c:if>
				    </c:forEach>
				    
				    <c:if test="${pageInfo.pageNum == pageInfo.pages}">
					    <li class="disabled">
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    <li class="disabled"><a href="#">末页</a></li>
				    </c:if>
				    <c:if test="${pageInfo.pageNum != pageInfo.pages}">
					    <li>
					      <a href="${emp_path}/emps?pageNo=${pageInfo.pageNum+1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    <li><a href="#">末页</a></li>
				    </c:if>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>