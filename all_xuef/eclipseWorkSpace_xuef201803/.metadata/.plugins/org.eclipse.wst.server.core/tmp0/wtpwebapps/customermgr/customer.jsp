<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
			"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>'()</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<!-- jQuery -->
<script src="${APP_PATH}/js/jquery-1.10.1.js"></script>
<!-- Bootstrap 核心 CSS -->
<link rel="stylesheet"
	href="${APP_PATH}/css/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<!-- Bootstrap 核心 javasSript -->
<script src="${APP_PATH}/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<!-- 标题 -->
		<div class="row">
		  	<div class="col-md-12"><h1>客户管理系统</h1></div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
					aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" 
		        		aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">新增客户</h4>
		      </div>
		      
		      <div class="modal-body">
		        <form class="form-horizontal">
				  <div class="form-group">
				    <label for="input1" class="col-sm-2 control-label">编号</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputCusId" 
				      										  placeholder="customerId">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="input2" class="col-sm-2 control-label">姓名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputShowName" 
				      										  placeholder="showName">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="input3" class="col-sm-2 control-label">注册时间</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputRegTime" 
				      										  value="2018-04-07">
				    </div>
				  </div>
				</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" id="add2Save">Save</button>
		      </div>
		        
		    </div>
		  </div>
		</div>
		
		
		<!-- 标题一般操作 -->
		<div class="row">
		  	<div class="col-md-4 col-md-offset-9">
		  		<button type="button" class="btn btn-primary btn-md" id="add_emp"
		  				data-toggle="modal" data-target="#myModal"> 
		  			 Add <span class="glyphicon glyphicon-plus"></span></button>
		  		<button type="button" class="btn btn-danger"> 
		  			 DelALL<span class="glyphicon glyphicon-remove"></span></button>
			</div>
		</div>
		<div class="row">
		  	<div class="col-md-12"><h4>******</h4></div>
		</div>
		<!-- 数据展示 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-hover" id="cus_table">
					<thead>
						<tr class="info">
							<th>..</th>
							<th>编号</th>
							<th>姓名</th>
							<th>注册时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 分页信息 -->
		<div class="row">
			<div class="col-md-6" id="page_info">
				
			</div>
			<div class="col-md-6" id="page_nav">
			</div>
		</div>
	</div>
	
	<!-- 页面加载完成后执行 -->
	<script type="text/javascript">
		$(function(){
			// 到达第一页
			to_page(1);
			$("#add2Save").click(function(){
				var params = {};
				params._method = "POST";
				var cusId = $("#inputCusId").val();
				var showN = $("#inputShowName").val();
				var regTime = $("#inputRegTime").val();
				
				params.customerId = cusId;
				params.showName = showN;
				params.registerTime = regTime;
				add2save(params);
			});
		});
		
		function add2save(newCus){
			$.ajax({
				url: "${APP_PATH}/customerAdd",
				type: "post",
				data: newCus,
				success: function(resMsg){
					// 关闭模态框
					$('#myModal').modal('hide');
					// 到达最后一页
					to_page(1000000000);
				}
			});
		}
		function to_page(pageNo){
			$.ajax({
				url: "${APP_PATH}/customers",
				type: "get",
				data: "pageNo="+pageNo,
				success: function(resMsg){
					console.log(resMsg);
					// 构建客户信息列表
					var customersPage = resMsg.res.pageInfo;
					build_cusList(customersPage, {});
					build_page_info(resMsg, {});
					build_page_nav(resMsg, {});
				}
			});
		}
		// 保存修改
		function saveCus(params){
			params._method="PUT";
			$.ajax({
				url: "${APP_PATH}/customer/"+params.customerId,
				type: "POST",
				contentType: "application/x-www-form-urlencoded",
				data: params,
				success: function(result){
					console.log(result);
				}
			});
		}
		// 删除某个客户
		function delCus(delCusUuid, pageNo){
			$.ajax({
				url: "${APP_PATH}/customerDel/"+delCusUuid,
				type: "POST",
				contentType: "application/x-www-form-urlencoded",
				data: {_method: "DELETE"},
				success: function(result){
					// 刷新当前页
					to_page(pageNo);
				}
			});
		}
		
		// 构建列表
		function build_cusList(customsPage, nonuse){
			$("#cus_table tbody").empty();
			var customs = customsPage.list; // 客户数组
			
			// 遍历客户数组
			$.each(customs, function(index, item){
				var uuidInput = $("<input></input>")
											.attr("type", "text")
											.attr("readonly", "true")
											.addClass("form-control")
											.attr("size", "1")
											.attr("name", "uuid");
				var cNoInput = $("<input></input>")
											.attr("type", "text")
											.attr("readonly", "true")
											.addClass("form-control")
											.attr("size", "1")
											.attr("name", "customerId");
				var cNameInput = $("<input/>").attr("type", "text")
											  .attr("readonly", "true")
											  .addClass("form-control")
											  .attr("size", "3")
											  .attr("name", "showName")
											  
				var cTimeInput = $("<input />").attr("type", "text")
											  .attr("readonly", "true")
											  .attr("name", "registerTime")
											.addClass("form-control")
											.attr("size", "5");
											
				var uuidTd = $("<td></td>").append(uuidInput.val(item.uuid));
				var cNoTd = $("<td></td>").append(cNoInput.val(item.customerId));
				var cNameTd = $("<td></td>").append(cNameInput.val(item.showName));
				var cTimeTd = $("<td></td>").append(cTimeInput.val(item.registerTime));
				
				var inp = $(this).parent().siblings()
				var isEditable = inp.children().last().attr("readonly")==true
				
				var saveClickBind = false;
				var btn = $("<button></button>")
								.attr("type","button")
								.addClass("btn btn-primary btn-sm")
								.text("Edit")
								.click(function(){
									// 点击edit button时，将对应input设置为可编辑状态
									//alert("isEditable " + isEditable)
									// edit 按钮 转为 save 按钮
									if(!isEditable){
										//alert("click edit")
										$(this).empty();
										var records = $(this).parent().siblings().children();
										
										$(this).addClass("btn-warning")
											.append("Sav<span class='glyphicon glyphicon-save'></span>")
										
										// 为save绑定事件; 这儿的逻辑有点乱
										if(!saveClickBind
												&& $(this).hasClass("btn-warning")){
											//alert("为save绑定事件");
											$(this).click(function(){
												// 是save操作时才执行
												var paramJson = {};
												if(!$(this).hasClass("btn-warning")){
													$.each(records, function(idx, item){
														// 拼接请求串
														paramJson[$(item).attr("name")] = $(item).val()
													});
													//alert("save: " + paramJson);
													saveCus(paramJson);
												}
											});
											saveClickBind = true;
										};
											
										records.removeAttr("readonly")
										records.first().attr("readonly", true)
										
										isEditable = true
									}else{
										//alert("click save")
										$(this).empty()
										$(this).removeClass("btn-warning")
											.addClass("btn-primary")
											.append("Edit<span class='glyphicon glyphicon-pencil'></span>")
										$(this).parent().siblings().children().attr("readonly", true)
										
										isEditable = false
									}
								})
								.append($("<span></span>")
								.addClass("glyphicon glyphicon-pencil"));
				
				var opeTd = $("<td></td>")
						.append(btn)
						.append(" ")
						.append($("<button></button>")
									.attr("type","button")
									.addClass("btn btn-danger btn-sm")
									.text("DeL")
									.click(function(){
										var rcds = $(this).parent().siblings().children();
										//alert("del: " + $(rcds[0]).val());
										var delCusUuid = $(rcds[0]).val();
										delCus(delCusUuid, customsPage.pageNum);
									})
									.append($("<span></span>")
									.addClass("glyphicon glyphicon-remove")));
				$("<tr></tr>").append(uuidTd).append(cNoTd).append(cNameTd)
							  .append(cTimeTd).append(opeTd)
							  .appendTo("#cus_table tbody");
			});
		}
		
		// 构建分页信息
		function build_page_info(res){
			$("#page_info").empty()
			var page_info_json = res.res.pageInfo
			$("#page_info").append("当前第 "+ page_info_json.pageNum + 
					" 页 共 " + page_info_json.pages + " 页 " + page_info_json.total + " 条记录")
		}
		// 构建分页导航
		function build_page_nav(res){
			$("#page_nav").empty()
			var page_info_json = res.res.pageInfo
			var nav = $("<nav></nav>")
			var par_ul = $("<ul></ul>").addClass("pagination")
			var first = $("<li></li>").append($("<a></a>").append("首页"));
			
			var pre = $("<li></li>").append($("<a></a>")
											.append("&laquo;"));
			
			// 没有前一页时，禁用首页和pre链接
			if(page_info_json.hasPreviousPage == false){
				first.addClass("disabled")
				pre.addClass("disabled")
			}else{
				first.click(function(){
					to_page(1);
				});
				pre.click(function(){
					to_page(page_info_json.pageNum-1)
				});
			}
			var next = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var last = $("<li></li>").append($("<a></a>").append("末页"));
			// 没有后一页时，禁用末页和next链接
			if(page_info_json.hasNextPage == false){
				next.addClass("disabled");
				last.addClass("disabled");
			}else{
				next.click(function(){
					to_page(page_info_json.pageNum+1);
				});
				
				last.click(function(){
					to_page(page_info_json.pages);
				});
			}
				
			par_ul.append(first).append(pre);
			
			$.each(page_info_json.navigatepageNums, function(index, item){
				var cur = $("<li></li>").append($("<a></a>").append(item)
													.click(function(){
														to_page(item);
													}));
				// 高亮当前页
				if(page_info_json.pageNum == item){
					cur.addClass("active");
				}
				par_ul.append(cur);
				par_ul.append(next).append(last);
			});
			nav.append(par_ul);
			$("#page_nav").append(nav);
		}
	</script>
</body>
</html>