package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class customer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \n");
      out.write("\t\t\t\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>'()</title>\n");

	pageContext.setAttribute("APP_PATH", request.getContextPath());

      out.write("\n");
      out.write("\n");
      out.write("<!-- jQuery -->\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.10.1.js\"></script>\n");
      out.write("<!-- Bootstrap 核心 CSS -->\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap-3.3.7-dist/css/bootstrap.min.css\" />\n");
      out.write("<!-- Bootstrap 核心 javasSript -->\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<!-- 标题 -->\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t  \t<div class=\"col-md-12\"><h1>客户管理系统</h1></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Modal -->\n");
      out.write("\t\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" \n");
      out.write("\t\t\t\t\taria-labelledby=\"myModalLabel\">\n");
      out.write("\t\t  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("\t\t    <div class=\"modal-content\">\n");
      out.write("\t\t      <div class=\"modal-header\">\n");
      out.write("\t\t        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" \n");
      out.write("\t\t        \t\taria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("\t\t        <h4 class=\"modal-title\" id=\"myModalLabel\">新增客户</h4>\n");
      out.write("\t\t      </div>\n");
      out.write("\t\t      \n");
      out.write("\t\t      <div class=\"modal-body\">\n");
      out.write("\t\t        <form class=\"form-horizontal\">\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t    <label for=\"input1\" class=\"col-sm-2 control-label\">编号</label>\n");
      out.write("\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"inputCusId\" \n");
      out.write("\t\t\t\t      \t\t\t\t\t\t\t\t\t\t  placeholder=\"customerId\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t    <label for=\"input2\" class=\"col-sm-2 control-label\">姓名</label>\n");
      out.write("\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"inputShowName\" \n");
      out.write("\t\t\t\t      \t\t\t\t\t\t\t\t\t\t  placeholder=\"showName\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t    <label for=\"input3\" class=\"col-sm-2 control-label\">注册时间</label>\n");
      out.write("\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t      <input type=\"text\" class=\"form-control\" id=\"inputRegTime\" \n");
      out.write("\t\t\t\t      \t\t\t\t\t\t\t\t\t\t  value=\"2018-04-07\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t  </div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t      </div>\n");
      out.write("\t\t      <div class=\"modal-footer\">\n");
      out.write("\t\t        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\t\t        <button type=\"button\" class=\"btn btn-primary\" id=\"add2Save\">Save</button>\n");
      out.write("\t\t      </div>\n");
      out.write("\t\t        \n");
      out.write("\t\t    </div>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- 标题一般操作 -->\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t  \t<div class=\"col-md-4 col-md-offset-9\">\n");
      out.write("\t\t  \t\t<button type=\"button\" class=\"btn btn-primary btn-md\" id=\"add_emp\"\n");
      out.write("\t\t  \t\t\t\tdata-toggle=\"modal\" data-target=\"#myModal\"> \n");
      out.write("\t\t  \t\t\t Add <span class=\"glyphicon glyphicon-plus\"></span></button>\n");
      out.write("\t\t  \t\t<button type=\"button\" class=\"btn btn-danger\"> \n");
      out.write("\t\t  \t\t\t DelALL<span class=\"glyphicon glyphicon-remove\"></span></button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t  \t<div class=\"col-md-12\"><h4>******</h4></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- 数据展示 -->\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-12\">\n");
      out.write("\t\t\t\t<table class=\"table table-bordered table-hover\" id=\"cus_table\">\n");
      out.write("\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t<tr class=\"info\">\n");
      out.write("\t\t\t\t\t\t\t<th>..</th>\n");
      out.write("\t\t\t\t\t\t\t<th>编号</th>\n");
      out.write("\t\t\t\t\t\t\t<th>姓名</th>\n");
      out.write("\t\t\t\t\t\t\t<th>注册时间</th>\n");
      out.write("\t\t\t\t\t\t\t<th>操作</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- 分页信息 -->\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-md-6\" id=\"page_info\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-md-6\" id=\"page_nav\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<!-- 页面加载完成后执行 -->\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t$(function(){\n");
      out.write("\t\t\t// 到达第一页\n");
      out.write("\t\t\tto_page(1);\n");
      out.write("\t\t\t$(\"#add2Save\").click(function(){\n");
      out.write("\t\t\t\tvar params = {};\n");
      out.write("\t\t\t\tparams._method = \"POST\";\n");
      out.write("\t\t\t\tvar cusId = $(\"#inputCusId\").val();\n");
      out.write("\t\t\t\tvar showN = $(\"#inputShowName\").val();\n");
      out.write("\t\t\t\tvar regTime = $(\"#inputRegTime\").val();\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tparams.customerId = cusId;\n");
      out.write("\t\t\t\tparams.showName = showN;\n");
      out.write("\t\t\t\tparams.registerTime = regTime;\n");
      out.write("\t\t\t\tadd2save(params);\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\tfunction add2save(newCus){\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customerAdd\",\n");
      out.write("\t\t\t\ttype: \"post\",\n");
      out.write("\t\t\t\tdata: newCus,\n");
      out.write("\t\t\t\tsuccess: function(resMsg){\n");
      out.write("\t\t\t\t\t// 关闭模态框\n");
      out.write("\t\t\t\t\t$('#myModal').modal('hide');\n");
      out.write("\t\t\t\t\t// 到达最后一页\n");
      out.write("\t\t\t\t\tto_page(1000000000);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\tfunction to_page(pageNo){\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customers\",\n");
      out.write("\t\t\t\ttype: \"get\",\n");
      out.write("\t\t\t\tdata: \"pageNo=\"+pageNo,\n");
      out.write("\t\t\t\tsuccess: function(resMsg){\n");
      out.write("\t\t\t\t\tconsole.log(resMsg);\n");
      out.write("\t\t\t\t\t// 构建客户信息列表\n");
      out.write("\t\t\t\t\tvar customersPage = resMsg.res.pageInfo;\n");
      out.write("\t\t\t\t\tbuild_cusList(customersPage, {});\n");
      out.write("\t\t\t\t\tbuild_page_info(resMsg, {});\n");
      out.write("\t\t\t\t\tbuild_page_nav(resMsg, {});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t// 保存修改\n");
      out.write("\t\tfunction saveCus(params){\n");
      out.write("\t\t\tparams._method=\"PUT\";\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/\"+params.customerId,\n");
      out.write("\t\t\t\ttype: \"POST\",\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded\",\n");
      out.write("\t\t\t\tdata: params,\n");
      out.write("\t\t\t\tsuccess: function(result){\n");
      out.write("\t\t\t\t\tconsole.log(result);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t// 删除某个客户\n");
      out.write("\t\tfunction delCus(delCusUuid, pageNo){\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\turl: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${APP_PATH}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customerDel/\"+delCusUuid,\n");
      out.write("\t\t\t\ttype: \"POST\",\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded\",\n");
      out.write("\t\t\t\tdata: {_method: \"DELETE\"},\n");
      out.write("\t\t\t\tsuccess: function(result){\n");
      out.write("\t\t\t\t\t// 刷新当前页\n");
      out.write("\t\t\t\t\tto_page(pageNo);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t// 构建列表\n");
      out.write("\t\tfunction build_cusList(customsPage, nonuse){\n");
      out.write("\t\t\t$(\"#cus_table tbody\").empty();\n");
      out.write("\t\t\tvar customs = customsPage.list; // 客户数组\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t// 遍历客户数组\n");
      out.write("\t\t\t$.each(customs, function(index, item){\n");
      out.write("\t\t\t\tvar uuidInput = $(\"<input></input>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"type\", \"text\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"readonly\", \"true\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.addClass(\"form-control\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"size\", \"1\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"name\", \"uuid\");\n");
      out.write("\t\t\t\tvar cNoInput = $(\"<input></input>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"type\", \"text\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"readonly\", \"true\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.addClass(\"form-control\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"size\", \"1\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"name\", \"customerId\");\n");
      out.write("\t\t\t\tvar cNameInput = $(\"<input/>\").attr(\"type\", \"text\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .attr(\"readonly\", \"true\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .addClass(\"form-control\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .attr(\"size\", \"3\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .attr(\"name\", \"showName\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  \n");
      out.write("\t\t\t\tvar cTimeInput = $(\"<input />\").attr(\"type\", \"text\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .attr(\"readonly\", \"true\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t  .attr(\"name\", \"registerTime\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.addClass(\"form-control\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.attr(\"size\", \"5\");\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\tvar uuidTd = $(\"<td></td>\").append(uuidInput.val(item.uuid));\n");
      out.write("\t\t\t\tvar cNoTd = $(\"<td></td>\").append(cNoInput.val(item.customerId));\n");
      out.write("\t\t\t\tvar cNameTd = $(\"<td></td>\").append(cNameInput.val(item.showName));\n");
      out.write("\t\t\t\tvar cTimeTd = $(\"<td></td>\").append(cTimeInput.val(item.registerTime));\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar inp = $(this).parent().siblings()\n");
      out.write("\t\t\t\tvar isEditable = inp.children().last().attr(\"readonly\")==true\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar saveClickBind = false;\n");
      out.write("\t\t\t\tvar btn = $(\"<button></button>\")\n");
      out.write("\t\t\t\t\t\t\t\t.attr(\"type\",\"button\")\n");
      out.write("\t\t\t\t\t\t\t\t.addClass(\"btn btn-primary btn-sm\")\n");
      out.write("\t\t\t\t\t\t\t\t.text(\"Edit\")\n");
      out.write("\t\t\t\t\t\t\t\t.click(function(){\n");
      out.write("\t\t\t\t\t\t\t\t\t// 点击edit button时，将对应input设置为可编辑状态\n");
      out.write("\t\t\t\t\t\t\t\t\t//alert(\"isEditable \" + isEditable)\n");
      out.write("\t\t\t\t\t\t\t\t\t// edit 按钮 转为 save 按钮\n");
      out.write("\t\t\t\t\t\t\t\t\tif(!isEditable){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert(\"click edit\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(this).empty();\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar records = $(this).parent().siblings().children();\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(this).addClass(\"btn-warning\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.append(\"Sav<span class='glyphicon glyphicon-save'></span>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t// 为save绑定事件; 这儿的逻辑有点乱\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif(!saveClickBind\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t&& $(this).hasClass(\"btn-warning\")){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//alert(\"为save绑定事件\");\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(this).click(function(){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t// 是save操作时才执行\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tvar paramJson = {};\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tif(!$(this).hasClass(\"btn-warning\")){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$.each(records, function(idx, item){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t// 拼接请求串\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tparamJson[$(item).attr(\"name\")] = $(item).val()\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//alert(\"save: \" + paramJson);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tsaveCus(paramJson);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsaveClickBind = true;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t};\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\trecords.removeAttr(\"readonly\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\trecords.first().attr(\"readonly\", true)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\tisEditable = true\n");
      out.write("\t\t\t\t\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert(\"click save\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(this).empty()\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(this).removeClass(\"btn-warning\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.addClass(\"btn-primary\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.append(\"Edit<span class='glyphicon glyphicon-pencil'></span>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$(this).parent().siblings().children().attr(\"readonly\", true)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\tisEditable = false\n");
      out.write("\t\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\t})\n");
      out.write("\t\t\t\t\t\t\t\t.append($(\"<span></span>\")\n");
      out.write("\t\t\t\t\t\t\t\t.addClass(\"glyphicon glyphicon-pencil\"));\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar opeTd = $(\"<td></td>\")\n");
      out.write("\t\t\t\t\t\t.append(btn)\n");
      out.write("\t\t\t\t\t\t.append(\" \")\n");
      out.write("\t\t\t\t\t\t.append($(\"<button></button>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t.attr(\"type\",\"button\")\n");
      out.write("\t\t\t\t\t\t\t\t\t.addClass(\"btn btn-danger btn-sm\")\n");
      out.write("\t\t\t\t\t\t\t\t\t.text(\"DeL\")\n");
      out.write("\t\t\t\t\t\t\t\t\t.click(function(){\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar rcds = $(this).parent().siblings().children();\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert(\"del: \" + $(rcds[0]).val());\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar delCusUuid = $(rcds[0]).val();\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdelCus(delCusUuid, customsPage.pageNum);\n");
      out.write("\t\t\t\t\t\t\t\t\t})\n");
      out.write("\t\t\t\t\t\t\t\t\t.append($(\"<span></span>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t.addClass(\"glyphicon glyphicon-remove\")));\n");
      out.write("\t\t\t\t$(\"<tr></tr>\").append(uuidTd).append(cNoTd).append(cNameTd)\n");
      out.write("\t\t\t\t\t\t\t  .append(cTimeTd).append(opeTd)\n");
      out.write("\t\t\t\t\t\t\t  .appendTo(\"#cus_table tbody\");\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t// 构建分页信息\n");
      out.write("\t\tfunction build_page_info(res){\n");
      out.write("\t\t\t$(\"#page_info\").empty()\n");
      out.write("\t\t\tvar page_info_json = res.res.pageInfo\n");
      out.write("\t\t\t$(\"#page_info\").append(\"当前第 \"+ page_info_json.pageNum + \n");
      out.write("\t\t\t\t\t\" 页 共 \" + page_info_json.pages + \" 页 \" + page_info_json.total + \" 条记录\")\n");
      out.write("\t\t}\n");
      out.write("\t\t// 构建分页导航\n");
      out.write("\t\tfunction build_page_nav(res){\n");
      out.write("\t\t\t$(\"#page_nav\").empty()\n");
      out.write("\t\t\tvar page_info_json = res.res.pageInfo\n");
      out.write("\t\t\tvar nav = $(\"<nav></nav>\")\n");
      out.write("\t\t\tvar par_ul = $(\"<ul></ul>\").addClass(\"pagination\")\n");
      out.write("\t\t\tvar first = $(\"<li></li>\").append($(\"<a></a>\").append(\"首页\"));\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tvar pre = $(\"<li></li>\").append($(\"<a></a>\")\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.append(\"&laquo;\"));\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t// 没有前一页时，禁用首页和pre链接\n");
      out.write("\t\t\tif(page_info_json.hasPreviousPage == false){\n");
      out.write("\t\t\t\tfirst.addClass(\"disabled\")\n");
      out.write("\t\t\t\tpre.addClass(\"disabled\")\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tfirst.click(function(){\n");
      out.write("\t\t\t\t\tto_page(1);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\tpre.click(function(){\n");
      out.write("\t\t\t\t\tto_page(page_info_json.pageNum-1)\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar next = $(\"<li></li>\").append($(\"<a></a>\").append(\"&raquo;\"));\n");
      out.write("\t\t\tvar last = $(\"<li></li>\").append($(\"<a></a>\").append(\"末页\"));\n");
      out.write("\t\t\t// 没有后一页时，禁用末页和next链接\n");
      out.write("\t\t\tif(page_info_json.hasNextPage == false){\n");
      out.write("\t\t\t\tnext.addClass(\"disabled\");\n");
      out.write("\t\t\t\tlast.addClass(\"disabled\");\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tnext.click(function(){\n");
      out.write("\t\t\t\t\tto_page(page_info_json.pageNum+1);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tlast.click(function(){\n");
      out.write("\t\t\t\t\tto_page(page_info_json.pages);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\tpar_ul.append(first).append(pre);\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$.each(page_info_json.navigatepageNums, function(index, item){\n");
      out.write("\t\t\t\tvar cur = $(\"<li></li>\").append($(\"<a></a>\").append(item)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t.click(function(){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tto_page(item);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}));\n");
      out.write("\t\t\t\t// 高亮当前页\n");
      out.write("\t\t\t\tif(page_info_json.pageNum == item){\n");
      out.write("\t\t\t\t\tcur.addClass(\"active\");\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tpar_ul.append(cur);\n");
      out.write("\t\t\t\tpar_ul.append(next).append(last);\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tnav.append(par_ul);\n");
      out.write("\t\t\t$(\"#page_nav\").append(nav);\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}